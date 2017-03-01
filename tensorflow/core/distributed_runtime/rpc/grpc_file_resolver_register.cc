/* Copyright 2016 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

#include <grpc/grpc.h>

#include "tensorflow/core/distributed_runtime/rpc/grpc_file_resolver.h"

namespace tensorflow {

class GrpcFileResolverRegistrar {
 public:
  GrpcFileResolverRegistrar() {
    grpc_register_plugin(grpc_file_resolver_native_init,
                         grpc_file_resolver_native_shutdown);
  }
};
static GrpcFileResolverRegistrar registrar;

}  // end namespace tensorflow
