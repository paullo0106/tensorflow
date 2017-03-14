// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/debug.proto

package org.tensorflow.framework;

/**
 * <pre>
 * EXPERIMENTAL. Options for initializing DebuggerState.
 * </pre>
 *
 * Protobuf type {@code tensorflow.DebugOptions}
 */
public  final class DebugOptions extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.DebugOptions)
    DebugOptionsOrBuilder {
  // Use DebugOptions.newBuilder() to construct.
  private DebugOptions(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DebugOptions() {
    debugTensorWatchOpts_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private DebugOptions(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              debugTensorWatchOpts_ = new java.util.ArrayList<org.tensorflow.framework.DebugTensorWatch>();
              mutable_bitField0_ |= 0x00000001;
            }
            debugTensorWatchOpts_.add(
                input.readMessage(org.tensorflow.framework.DebugTensorWatch.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        debugTensorWatchOpts_ = java.util.Collections.unmodifiableList(debugTensorWatchOpts_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.tensorflow.framework.DebugProtos.internal_static_tensorflow_DebugOptions_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.framework.DebugProtos.internal_static_tensorflow_DebugOptions_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.framework.DebugOptions.class, org.tensorflow.framework.DebugOptions.Builder.class);
  }

  public static final int DEBUG_TENSOR_WATCH_OPTS_FIELD_NUMBER = 4;
  private java.util.List<org.tensorflow.framework.DebugTensorWatch> debugTensorWatchOpts_;
  /**
   * <pre>
   * Debugging options
   * </pre>
   *
   * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
   */
  public java.util.List<org.tensorflow.framework.DebugTensorWatch> getDebugTensorWatchOptsList() {
    return debugTensorWatchOpts_;
  }
  /**
   * <pre>
   * Debugging options
   * </pre>
   *
   * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
   */
  public java.util.List<? extends org.tensorflow.framework.DebugTensorWatchOrBuilder> 
      getDebugTensorWatchOptsOrBuilderList() {
    return debugTensorWatchOpts_;
  }
  /**
   * <pre>
   * Debugging options
   * </pre>
   *
   * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
   */
  public int getDebugTensorWatchOptsCount() {
    return debugTensorWatchOpts_.size();
  }
  /**
   * <pre>
   * Debugging options
   * </pre>
   *
   * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
   */
  public org.tensorflow.framework.DebugTensorWatch getDebugTensorWatchOpts(int index) {
    return debugTensorWatchOpts_.get(index);
  }
  /**
   * <pre>
   * Debugging options
   * </pre>
   *
   * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
   */
  public org.tensorflow.framework.DebugTensorWatchOrBuilder getDebugTensorWatchOptsOrBuilder(
      int index) {
    return debugTensorWatchOpts_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < debugTensorWatchOpts_.size(); i++) {
      output.writeMessage(4, debugTensorWatchOpts_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < debugTensorWatchOpts_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, debugTensorWatchOpts_.get(i));
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.tensorflow.framework.DebugOptions)) {
      return super.equals(obj);
    }
    org.tensorflow.framework.DebugOptions other = (org.tensorflow.framework.DebugOptions) obj;

    boolean result = true;
    result = result && getDebugTensorWatchOptsList()
        .equals(other.getDebugTensorWatchOptsList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getDebugTensorWatchOptsCount() > 0) {
      hash = (37 * hash) + DEBUG_TENSOR_WATCH_OPTS_FIELD_NUMBER;
      hash = (53 * hash) + getDebugTensorWatchOptsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.framework.DebugOptions parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.DebugOptions parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.DebugOptions parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.DebugOptions parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.DebugOptions parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.DebugOptions parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.DebugOptions parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.DebugOptions parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.DebugOptions parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.DebugOptions parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.tensorflow.framework.DebugOptions prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * EXPERIMENTAL. Options for initializing DebuggerState.
   * </pre>
   *
   * Protobuf type {@code tensorflow.DebugOptions}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.DebugOptions)
      org.tensorflow.framework.DebugOptionsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.framework.DebugProtos.internal_static_tensorflow_DebugOptions_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.framework.DebugProtos.internal_static_tensorflow_DebugOptions_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.framework.DebugOptions.class, org.tensorflow.framework.DebugOptions.Builder.class);
    }

    // Construct using org.tensorflow.framework.DebugOptions.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getDebugTensorWatchOptsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (debugTensorWatchOptsBuilder_ == null) {
        debugTensorWatchOpts_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        debugTensorWatchOptsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.framework.DebugProtos.internal_static_tensorflow_DebugOptions_descriptor;
    }

    public org.tensorflow.framework.DebugOptions getDefaultInstanceForType() {
      return org.tensorflow.framework.DebugOptions.getDefaultInstance();
    }

    public org.tensorflow.framework.DebugOptions build() {
      org.tensorflow.framework.DebugOptions result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.tensorflow.framework.DebugOptions buildPartial() {
      org.tensorflow.framework.DebugOptions result = new org.tensorflow.framework.DebugOptions(this);
      int from_bitField0_ = bitField0_;
      if (debugTensorWatchOptsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          debugTensorWatchOpts_ = java.util.Collections.unmodifiableList(debugTensorWatchOpts_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.debugTensorWatchOpts_ = debugTensorWatchOpts_;
      } else {
        result.debugTensorWatchOpts_ = debugTensorWatchOptsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.tensorflow.framework.DebugOptions) {
        return mergeFrom((org.tensorflow.framework.DebugOptions)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.framework.DebugOptions other) {
      if (other == org.tensorflow.framework.DebugOptions.getDefaultInstance()) return this;
      if (debugTensorWatchOptsBuilder_ == null) {
        if (!other.debugTensorWatchOpts_.isEmpty()) {
          if (debugTensorWatchOpts_.isEmpty()) {
            debugTensorWatchOpts_ = other.debugTensorWatchOpts_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDebugTensorWatchOptsIsMutable();
            debugTensorWatchOpts_.addAll(other.debugTensorWatchOpts_);
          }
          onChanged();
        }
      } else {
        if (!other.debugTensorWatchOpts_.isEmpty()) {
          if (debugTensorWatchOptsBuilder_.isEmpty()) {
            debugTensorWatchOptsBuilder_.dispose();
            debugTensorWatchOptsBuilder_ = null;
            debugTensorWatchOpts_ = other.debugTensorWatchOpts_;
            bitField0_ = (bitField0_ & ~0x00000001);
            debugTensorWatchOptsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getDebugTensorWatchOptsFieldBuilder() : null;
          } else {
            debugTensorWatchOptsBuilder_.addAllMessages(other.debugTensorWatchOpts_);
          }
        }
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.tensorflow.framework.DebugOptions parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.tensorflow.framework.DebugOptions) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<org.tensorflow.framework.DebugTensorWatch> debugTensorWatchOpts_ =
      java.util.Collections.emptyList();
    private void ensureDebugTensorWatchOptsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        debugTensorWatchOpts_ = new java.util.ArrayList<org.tensorflow.framework.DebugTensorWatch>(debugTensorWatchOpts_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.tensorflow.framework.DebugTensorWatch, org.tensorflow.framework.DebugTensorWatch.Builder, org.tensorflow.framework.DebugTensorWatchOrBuilder> debugTensorWatchOptsBuilder_;

    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public java.util.List<org.tensorflow.framework.DebugTensorWatch> getDebugTensorWatchOptsList() {
      if (debugTensorWatchOptsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(debugTensorWatchOpts_);
      } else {
        return debugTensorWatchOptsBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public int getDebugTensorWatchOptsCount() {
      if (debugTensorWatchOptsBuilder_ == null) {
        return debugTensorWatchOpts_.size();
      } else {
        return debugTensorWatchOptsBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public org.tensorflow.framework.DebugTensorWatch getDebugTensorWatchOpts(int index) {
      if (debugTensorWatchOptsBuilder_ == null) {
        return debugTensorWatchOpts_.get(index);
      } else {
        return debugTensorWatchOptsBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public Builder setDebugTensorWatchOpts(
        int index, org.tensorflow.framework.DebugTensorWatch value) {
      if (debugTensorWatchOptsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDebugTensorWatchOptsIsMutable();
        debugTensorWatchOpts_.set(index, value);
        onChanged();
      } else {
        debugTensorWatchOptsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public Builder setDebugTensorWatchOpts(
        int index, org.tensorflow.framework.DebugTensorWatch.Builder builderForValue) {
      if (debugTensorWatchOptsBuilder_ == null) {
        ensureDebugTensorWatchOptsIsMutable();
        debugTensorWatchOpts_.set(index, builderForValue.build());
        onChanged();
      } else {
        debugTensorWatchOptsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public Builder addDebugTensorWatchOpts(org.tensorflow.framework.DebugTensorWatch value) {
      if (debugTensorWatchOptsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDebugTensorWatchOptsIsMutable();
        debugTensorWatchOpts_.add(value);
        onChanged();
      } else {
        debugTensorWatchOptsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public Builder addDebugTensorWatchOpts(
        int index, org.tensorflow.framework.DebugTensorWatch value) {
      if (debugTensorWatchOptsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDebugTensorWatchOptsIsMutable();
        debugTensorWatchOpts_.add(index, value);
        onChanged();
      } else {
        debugTensorWatchOptsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public Builder addDebugTensorWatchOpts(
        org.tensorflow.framework.DebugTensorWatch.Builder builderForValue) {
      if (debugTensorWatchOptsBuilder_ == null) {
        ensureDebugTensorWatchOptsIsMutable();
        debugTensorWatchOpts_.add(builderForValue.build());
        onChanged();
      } else {
        debugTensorWatchOptsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public Builder addDebugTensorWatchOpts(
        int index, org.tensorflow.framework.DebugTensorWatch.Builder builderForValue) {
      if (debugTensorWatchOptsBuilder_ == null) {
        ensureDebugTensorWatchOptsIsMutable();
        debugTensorWatchOpts_.add(index, builderForValue.build());
        onChanged();
      } else {
        debugTensorWatchOptsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public Builder addAllDebugTensorWatchOpts(
        java.lang.Iterable<? extends org.tensorflow.framework.DebugTensorWatch> values) {
      if (debugTensorWatchOptsBuilder_ == null) {
        ensureDebugTensorWatchOptsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, debugTensorWatchOpts_);
        onChanged();
      } else {
        debugTensorWatchOptsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public Builder clearDebugTensorWatchOpts() {
      if (debugTensorWatchOptsBuilder_ == null) {
        debugTensorWatchOpts_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        debugTensorWatchOptsBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public Builder removeDebugTensorWatchOpts(int index) {
      if (debugTensorWatchOptsBuilder_ == null) {
        ensureDebugTensorWatchOptsIsMutable();
        debugTensorWatchOpts_.remove(index);
        onChanged();
      } else {
        debugTensorWatchOptsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public org.tensorflow.framework.DebugTensorWatch.Builder getDebugTensorWatchOptsBuilder(
        int index) {
      return getDebugTensorWatchOptsFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public org.tensorflow.framework.DebugTensorWatchOrBuilder getDebugTensorWatchOptsOrBuilder(
        int index) {
      if (debugTensorWatchOptsBuilder_ == null) {
        return debugTensorWatchOpts_.get(index);  } else {
        return debugTensorWatchOptsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public java.util.List<? extends org.tensorflow.framework.DebugTensorWatchOrBuilder> 
         getDebugTensorWatchOptsOrBuilderList() {
      if (debugTensorWatchOptsBuilder_ != null) {
        return debugTensorWatchOptsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(debugTensorWatchOpts_);
      }
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public org.tensorflow.framework.DebugTensorWatch.Builder addDebugTensorWatchOptsBuilder() {
      return getDebugTensorWatchOptsFieldBuilder().addBuilder(
          org.tensorflow.framework.DebugTensorWatch.getDefaultInstance());
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public org.tensorflow.framework.DebugTensorWatch.Builder addDebugTensorWatchOptsBuilder(
        int index) {
      return getDebugTensorWatchOptsFieldBuilder().addBuilder(
          index, org.tensorflow.framework.DebugTensorWatch.getDefaultInstance());
    }
    /**
     * <pre>
     * Debugging options
     * </pre>
     *
     * <code>repeated .tensorflow.DebugTensorWatch debug_tensor_watch_opts = 4;</code>
     */
    public java.util.List<org.tensorflow.framework.DebugTensorWatch.Builder> 
         getDebugTensorWatchOptsBuilderList() {
      return getDebugTensorWatchOptsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.tensorflow.framework.DebugTensorWatch, org.tensorflow.framework.DebugTensorWatch.Builder, org.tensorflow.framework.DebugTensorWatchOrBuilder> 
        getDebugTensorWatchOptsFieldBuilder() {
      if (debugTensorWatchOptsBuilder_ == null) {
        debugTensorWatchOptsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.tensorflow.framework.DebugTensorWatch, org.tensorflow.framework.DebugTensorWatch.Builder, org.tensorflow.framework.DebugTensorWatchOrBuilder>(
                debugTensorWatchOpts_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        debugTensorWatchOpts_ = null;
      }
      return debugTensorWatchOptsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:tensorflow.DebugOptions)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.DebugOptions)
  private static final org.tensorflow.framework.DebugOptions DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.framework.DebugOptions();
  }

  public static org.tensorflow.framework.DebugOptions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DebugOptions>
      PARSER = new com.google.protobuf.AbstractParser<DebugOptions>() {
    public DebugOptions parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new DebugOptions(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DebugOptions> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DebugOptions> getParserForType() {
    return PARSER;
  }

  public org.tensorflow.framework.DebugOptions getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

