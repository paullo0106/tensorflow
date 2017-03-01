/*
 *
 * Copyright 2015, Google Inc.
 * Copyright 2017, Uber Technologies Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *     * Neither the name of Uber Technologies Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <grpc/support/alloc.h>
#include <grpc/support/host_port.h>
#include <grpc/support/string_util.h>

#include "src/core/ext/client_config/lb_policy_registry.h"
#include "src/core/ext/client_config/resolver_registry.h"
#include "src/core/lib/iomgr/resolve_address.h"
#include "src/core/lib/iomgr/timer.h"
#include "src/core/lib/support/backoff.h"
#include "src/core/lib/support/string.h"

#include "tensorflow/core/distributed_runtime/rpc/grpc_file_resolver.h"

#define GRPC_LOOKUP_FILE "GRPC_LOOKUP_FILE"
#define REFRESH_MILLIS 20000

// If GRPC_LOOKUP_FILE environment variable is set, this resolver
// resolve requests like file:///<name>:<index> to <host>:<port>.
//
// It looks up <host>:<port> in lookup file by <name> and <index>.
//
// Lookup file has format:
// <name>:<index>=<host>:<port>

typedef struct {
    /** base class: must be first */
    grpc_resolver base;
    /** refcount */
    gpr_refcount refs;
    /** name to resolve */
    char *name;
    /** default port to use */
    char *default_port;
    /** subchannel factory */
    grpc_client_channel_factory *client_channel_factory;
    /** load balancing policy name */
    char *lb_policy_name;

    /** mutex guarding the rest of the state */
    gpr_mu mu;
    /** which version of resolved_config have we published? */
    int published_version;
    /** which version of resolved_config is current? */
    int resolved_version;
    /** pending next completion, or NULL */
    grpc_closure *next_completion;
    /** target config address for next completion */
    grpc_client_config **target_config;
    /** current (fully resolved) config */
    grpc_client_config *resolved_config;
    /** refresh timer */
    bool have_refresh_timer;
    grpc_timer refresh_timer;

    /** currently resolving addresses */
    grpc_resolved_addresses *addresses;
} file_resolver;

static void file_resolver_destroy(grpc_exec_ctx *exec_ctx, grpc_resolver *r);

static void file_resolver_resolve_locked(grpc_exec_ctx *exec_ctx,
                                         file_resolver *r);
static void file_resolver_report_result_locked(grpc_exec_ctx *exec_ctx,
                                               file_resolver *r);

static void file_resolver_shutdown(grpc_exec_ctx *exec_ctx, grpc_resolver *r);
static void file_resolver_channel_saw_error(grpc_exec_ctx *exec_ctx, grpc_resolver *r);
static void file_resolver_next(grpc_exec_ctx *exec_ctx, grpc_resolver *r,
                               grpc_client_config **target_config,
                               grpc_closure *on_complete);

static const grpc_resolver_vtable file_resolver_vtable = {
        file_resolver_destroy, file_resolver_shutdown, file_resolver_channel_saw_error,
        file_resolver_next};

static void file_resolver_shutdown(grpc_exec_ctx *exec_ctx, grpc_resolver *resolver) {
    file_resolver *r = (file_resolver *)resolver;
    gpr_log(GPR_DEBUG, "file_resolver_shutdown [%p] [%s]", r, r->name);
    gpr_mu_lock(&r->mu);
    if (r->have_refresh_timer) {
        grpc_timer_cancel(exec_ctx, &r->refresh_timer);
    }
    if (r->next_completion != NULL) {
        *r->target_config = NULL;
        grpc_exec_ctx_sched(exec_ctx, r->next_completion,
                            GRPC_ERROR_CREATE("Resolver Shutdown"), NULL);
        r->next_completion = NULL;
    }
    gpr_mu_unlock(&r->mu);
}

static void file_resolver_channel_saw_error(grpc_exec_ctx *exec_ctx,
                                            grpc_resolver *resolver) {
    file_resolver *r = (file_resolver *)resolver;
    gpr_log(GPR_DEBUG, "file_resolver_channel_saw_error [%p] [%s]", r, r->name);
    gpr_mu_lock(&r->mu);
    file_resolver_resolve_locked(exec_ctx, r);
    gpr_mu_unlock(&r->mu);
}

static void file_resolver_next(grpc_exec_ctx *exec_ctx, grpc_resolver *resolver,
                               grpc_client_config **target_config,
                               grpc_closure *on_complete) {
    file_resolver *r = (file_resolver *)resolver;
    gpr_log(GPR_DEBUG, "file_resolver_next [%p] [%s]", r, r->name);
    gpr_mu_lock(&r->mu);
    GPR_ASSERT(!r->next_completion);
    r->next_completion = on_complete;
    r->target_config = target_config;
    if (r->resolved_version == 0) {
        file_resolver_resolve_locked(exec_ctx, r);
    } else {
        // Just report previously resolved version.
        file_resolver_report_result_locked(exec_ctx, r);
    }
    gpr_mu_unlock(&r->mu);
}

static void file_resolver_on_refresh_timer(grpc_exec_ctx *exec_ctx, void *arg,
                                           grpc_error *error) {
    file_resolver *r = arg;
    gpr_log(GPR_DEBUG, "file_resolver_on_refresh_timer [%p] [%s]", r, r->name);

    gpr_mu_lock(&r->mu);
    r->have_refresh_timer = false;
    if (error == GRPC_ERROR_NONE) {
        file_resolver_resolve_locked(exec_ctx, r);
    }
    gpr_mu_unlock(&r->mu);

    GRPC_RESOLVER_UNREF(exec_ctx, &r->base, "refresh-timer");
}

static bool addresses_equals(grpc_resolved_addresses *left,
                             grpc_resolved_addresses *right) {
    if (left == NULL || right == NULL) {
        return false;
    }

    if (left->naddrs != right->naddrs) {
        return false;
    }
    size_t naddrs = left->naddrs;

    size_t i;
    for (i = 0; i < naddrs; i++) {
        if (left->addrs[i].len != right->addrs[i].len) {
            return false;
        }
        size_t addrlen = left->addrs[i].len;

        if (memcmp(left->addrs[i].addr, right->addrs[i].addr, addrlen) != 0) {
            return false;
        }
    }

    return true;
}

/** returns copy of the string that must be freed by the caller */
char* grpc_file_resolver_lookup_name(const char* name) {
    const char* lookup_file_name = getenv(GRPC_LOOKUP_FILE);
    if (!lookup_file_name) {
        gpr_log(GPR_ERROR, "GRPC_LOOKUP_FILE is not set.");
        return NULL;
    }

    FILE* fp = fopen(lookup_file_name, "r");
    if (fp == NULL) {
        gpr_log(GPR_ERROR, "Unable to open GRPC_LOOKUP_FILE: %s",
                lookup_file_name);
        return NULL;
    }

    char* line = NULL;
    size_t len = 0;
    ssize_t read;
    char* result = NULL;
    while ((read = getline(&line, &len, fp)) != -1) {
        // Parse and match.
        char* end = line;
        // TODO(asergeev): be less restrictive with file format - strip whitespace, etc
        char* ln_name = strsep(&end, "=");
        char* ln_addr = strsep(&end, "\r\n");
        if (strcmp(name, ln_name) == 0) {
            result = strdup(ln_addr);
            break;
        }
    }

    free(line);
    fclose(fp);

    return result;
}

static void file_resolver_resolve_locked(grpc_exec_ctx *exec_ctx,
                                         file_resolver *r) {
    gpr_log(GPR_DEBUG, "file_resolver_resolve_locked [%p] [%s]", r, r->name);

    // Lookup address.
    grpc_resolved_addresses *addresses = NULL;
    char* addr = grpc_file_resolver_lookup_name(r->name);
    if (addr) {
        // Since addr is IP address with port, this call does not block.
        grpc_error* error =
                grpc_blocking_resolve_address(addr, r->default_port, &addresses);
        if (error != GRPC_ERROR_NONE) {
            const char *msg = grpc_error_string(error);
            gpr_log(GPR_ERROR, "Address %s failed to resolve: %s", addr, msg);
        }
        free(addr);
    }

    if (!addresses_equals(addresses, r->addresses)) {
        grpc_resolved_addresses_destroy(r->addresses);
        r->addresses = addresses;

        grpc_client_config *config = NULL;
        grpc_lb_policy *lb_policy;
        if (addresses != NULL) {
            grpc_lb_policy_args lb_policy_args;
            config = grpc_client_config_create();
            memset(&lb_policy_args, 0, sizeof(lb_policy_args));
            lb_policy_args.addresses = addresses;
            lb_policy_args.client_channel_factory = r->client_channel_factory;
            lb_policy =
                    grpc_lb_policy_create(exec_ctx, r->lb_policy_name, &lb_policy_args);
            if (lb_policy != NULL) {
                grpc_client_config_set_lb_policy(config, lb_policy);
                GRPC_LB_POLICY_UNREF(exec_ctx, lb_policy, "construction");
            }
        }
        if (r->resolved_config) {
            grpc_client_config_unref(exec_ctx, r->resolved_config);
        }
        r->resolved_config = config;
        r->resolved_version++;
        file_resolver_report_result_locked(exec_ctx, r);
    } else {
        gpr_log(GPR_DEBUG, "file_resolver_resolve_locked [%p] [%s]: short-circuit", r, r->name);
    }

    // TODO(asergeev): use inotify/watch of GRPC_LOOKUP_FILE
    // Schedule refresh in 20 seconds.
    if (!r->have_refresh_timer) {
        gpr_timespec now = gpr_now(GPR_CLOCK_MONOTONIC);
        gpr_timespec next_try = gpr_time_add(
                now, gpr_time_from_millis(REFRESH_MILLIS, GPR_TIMESPAN));
        r->have_refresh_timer = true;
        GRPC_RESOLVER_REF(&r->base, "refresh-timer");
        grpc_timer_init(exec_ctx, &r->refresh_timer, next_try,
                        file_resolver_on_refresh_timer, r, now);
    }
}

static void file_resolver_report_result_locked(grpc_exec_ctx *exec_ctx,
                                               file_resolver *r) {
    gpr_log(GPR_DEBUG, "file_resolver_report_result_locked [%p] [%s]", r, r->name);
    if (r->next_completion != NULL &&
        r->resolved_version != r->published_version) {
        *r->target_config = r->resolved_config;
        if (r->resolved_config) {
            grpc_client_config_ref(r->resolved_config);
        }
        grpc_exec_ctx_sched(exec_ctx, r->next_completion, GRPC_ERROR_NONE, NULL);
        r->next_completion = NULL;
        r->published_version = r->resolved_version;
    }
}

static void file_resolver_destroy(grpc_exec_ctx *exec_ctx, grpc_resolver *gr) {
    file_resolver *r = (file_resolver *)gr;
    gpr_log(GPR_DEBUG, "file_resolver_destroy [%p] [%s]", r, r->name);
    gpr_mu_destroy(&r->mu);
    if (r->resolved_config) {
        grpc_client_config_unref(exec_ctx, r->resolved_config);
    }
    grpc_client_channel_factory_unref(exec_ctx, r->client_channel_factory);
    gpr_free(r->name);
    gpr_free(r->default_port);
    gpr_free(r->lb_policy_name);
    grpc_resolved_addresses_destroy(r->addresses);
    gpr_free(r);
}

static grpc_resolver *file_resolver_create(grpc_resolver_args *args,
                                           const char *default_port,
                                           const char *lb_policy_name) {
    file_resolver *r;
    const char *path = args->uri->path;

    if (0 != strcmp(args->uri->authority, "")) {
        gpr_log(GPR_ERROR, "authority based file uri's not supported");
        return NULL;
    }

    if (path[0] == '/') {
        ++path;
    }

    r = gpr_malloc(sizeof(file_resolver));
    gpr_log(GPR_DEBUG, "file_resolver_create [%p] [%s]", r, path);
    memset(r, 0, sizeof(*r));
    gpr_ref_init(&r->refs, 1);
    gpr_mu_init(&r->mu);
    grpc_resolver_init(&r->base, &file_resolver_vtable);
    r->name = gpr_strdup(path);
    r->default_port = gpr_strdup(default_port);
    r->client_channel_factory = args->client_channel_factory;
    grpc_client_channel_factory_ref(r->client_channel_factory);
    r->lb_policy_name = gpr_strdup(lb_policy_name);
    return &r->base;
}

/*
 * FACTORY
 */

static void file_resolver_factory_ref(grpc_resolver_factory *factory) {}

static void file_resolver_factory_unref(grpc_resolver_factory *factory) {}

static grpc_resolver *file_resolver_factory_create_resolver(
        grpc_resolver_factory *factory, grpc_resolver_args *args) {
    return file_resolver_create(args, "https", "pick_first");
}

static char *file_resolver_factory_get_default_host_name(grpc_resolver_factory *factory,
                                                         grpc_uri *uri) {
    const char *path = uri->path;
    if (path[0] == '/') {
        ++path;
    }
    return gpr_strdup(path);
}

static const grpc_resolver_factory_vtable file_resolver_factory_vtable = {
        file_resolver_factory_ref, file_resolver_factory_unref,
        file_resolver_factory_create_resolver,
        file_resolver_factory_get_default_host_name, "file"};
static grpc_resolver_factory file_resolver_factory = {&file_resolver_factory_vtable};

static grpc_resolver_factory *file_resolver_factory_create() {
    return &file_resolver_factory;
}

void grpc_file_resolver_native_init(void) {
    grpc_register_resolver_type(file_resolver_factory_create());
}

void grpc_file_resolver_native_shutdown(void) {}

bool grpc_file_resolver_enabled(void) {
    return getenv(GRPC_LOOKUP_FILE) != NULL;
}
