// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/master.proto

package org.tensorflow.distruntime;

/**
 * Protobuf type {@code tensorflow.ResetRequest}
 */
public  final class ResetRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.ResetRequest)
    ResetRequestOrBuilder {
  // Use ResetRequest.newBuilder() to construct.
  private ResetRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ResetRequest() {
    container_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ResetRequest(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              container_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            container_.add(s);
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
        container_ = container_.getUnmodifiableView();
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.tensorflow.distruntime.DistributedRuntimeProtos.internal_static_tensorflow_ResetRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.distruntime.DistributedRuntimeProtos.internal_static_tensorflow_ResetRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.distruntime.ResetRequest.class, org.tensorflow.distruntime.ResetRequest.Builder.class);
  }

  public static final int CONTAINER_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList container_;
  /**
   * <pre>
   * A list of container names, which may be empty.
   * If 'container' is not empty, releases resoures in the given
   * containers in all devices.
   * If 'container' is empty, releases resources in the default
   * container in all devices.
   * </pre>
   *
   * <code>repeated string container = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getContainerList() {
    return container_;
  }
  /**
   * <pre>
   * A list of container names, which may be empty.
   * If 'container' is not empty, releases resoures in the given
   * containers in all devices.
   * If 'container' is empty, releases resources in the default
   * container in all devices.
   * </pre>
   *
   * <code>repeated string container = 1;</code>
   */
  public int getContainerCount() {
    return container_.size();
  }
  /**
   * <pre>
   * A list of container names, which may be empty.
   * If 'container' is not empty, releases resoures in the given
   * containers in all devices.
   * If 'container' is empty, releases resources in the default
   * container in all devices.
   * </pre>
   *
   * <code>repeated string container = 1;</code>
   */
  public java.lang.String getContainer(int index) {
    return container_.get(index);
  }
  /**
   * <pre>
   * A list of container names, which may be empty.
   * If 'container' is not empty, releases resoures in the given
   * containers in all devices.
   * If 'container' is empty, releases resources in the default
   * container in all devices.
   * </pre>
   *
   * <code>repeated string container = 1;</code>
   */
  public com.google.protobuf.ByteString
      getContainerBytes(int index) {
    return container_.getByteString(index);
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
    for (int i = 0; i < container_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, container_.getRaw(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < container_.size(); i++) {
        dataSize += computeStringSizeNoTag(container_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getContainerList().size();
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
    if (!(obj instanceof org.tensorflow.distruntime.ResetRequest)) {
      return super.equals(obj);
    }
    org.tensorflow.distruntime.ResetRequest other = (org.tensorflow.distruntime.ResetRequest) obj;

    boolean result = true;
    result = result && getContainerList()
        .equals(other.getContainerList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getContainerCount() > 0) {
      hash = (37 * hash) + CONTAINER_FIELD_NUMBER;
      hash = (53 * hash) + getContainerList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.distruntime.ResetRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.distruntime.ResetRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.distruntime.ResetRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.distruntime.ResetRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.distruntime.ResetRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.distruntime.ResetRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.distruntime.ResetRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.distruntime.ResetRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.distruntime.ResetRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.distruntime.ResetRequest parseFrom(
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
  public static Builder newBuilder(org.tensorflow.distruntime.ResetRequest prototype) {
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
   * Protobuf type {@code tensorflow.ResetRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.ResetRequest)
      org.tensorflow.distruntime.ResetRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.distruntime.DistributedRuntimeProtos.internal_static_tensorflow_ResetRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.distruntime.DistributedRuntimeProtos.internal_static_tensorflow_ResetRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.distruntime.ResetRequest.class, org.tensorflow.distruntime.ResetRequest.Builder.class);
    }

    // Construct using org.tensorflow.distruntime.ResetRequest.newBuilder()
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
      }
    }
    public Builder clear() {
      super.clear();
      container_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.distruntime.DistributedRuntimeProtos.internal_static_tensorflow_ResetRequest_descriptor;
    }

    public org.tensorflow.distruntime.ResetRequest getDefaultInstanceForType() {
      return org.tensorflow.distruntime.ResetRequest.getDefaultInstance();
    }

    public org.tensorflow.distruntime.ResetRequest build() {
      org.tensorflow.distruntime.ResetRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.tensorflow.distruntime.ResetRequest buildPartial() {
      org.tensorflow.distruntime.ResetRequest result = new org.tensorflow.distruntime.ResetRequest(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        container_ = container_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.container_ = container_;
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
      if (other instanceof org.tensorflow.distruntime.ResetRequest) {
        return mergeFrom((org.tensorflow.distruntime.ResetRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.distruntime.ResetRequest other) {
      if (other == org.tensorflow.distruntime.ResetRequest.getDefaultInstance()) return this;
      if (!other.container_.isEmpty()) {
        if (container_.isEmpty()) {
          container_ = other.container_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureContainerIsMutable();
          container_.addAll(other.container_);
        }
        onChanged();
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
      org.tensorflow.distruntime.ResetRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.tensorflow.distruntime.ResetRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList container_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureContainerIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        container_ = new com.google.protobuf.LazyStringArrayList(container_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * A list of container names, which may be empty.
     * If 'container' is not empty, releases resoures in the given
     * containers in all devices.
     * If 'container' is empty, releases resources in the default
     * container in all devices.
     * </pre>
     *
     * <code>repeated string container = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getContainerList() {
      return container_.getUnmodifiableView();
    }
    /**
     * <pre>
     * A list of container names, which may be empty.
     * If 'container' is not empty, releases resoures in the given
     * containers in all devices.
     * If 'container' is empty, releases resources in the default
     * container in all devices.
     * </pre>
     *
     * <code>repeated string container = 1;</code>
     */
    public int getContainerCount() {
      return container_.size();
    }
    /**
     * <pre>
     * A list of container names, which may be empty.
     * If 'container' is not empty, releases resoures in the given
     * containers in all devices.
     * If 'container' is empty, releases resources in the default
     * container in all devices.
     * </pre>
     *
     * <code>repeated string container = 1;</code>
     */
    public java.lang.String getContainer(int index) {
      return container_.get(index);
    }
    /**
     * <pre>
     * A list of container names, which may be empty.
     * If 'container' is not empty, releases resoures in the given
     * containers in all devices.
     * If 'container' is empty, releases resources in the default
     * container in all devices.
     * </pre>
     *
     * <code>repeated string container = 1;</code>
     */
    public com.google.protobuf.ByteString
        getContainerBytes(int index) {
      return container_.getByteString(index);
    }
    /**
     * <pre>
     * A list of container names, which may be empty.
     * If 'container' is not empty, releases resoures in the given
     * containers in all devices.
     * If 'container' is empty, releases resources in the default
     * container in all devices.
     * </pre>
     *
     * <code>repeated string container = 1;</code>
     */
    public Builder setContainer(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureContainerIsMutable();
      container_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * A list of container names, which may be empty.
     * If 'container' is not empty, releases resoures in the given
     * containers in all devices.
     * If 'container' is empty, releases resources in the default
     * container in all devices.
     * </pre>
     *
     * <code>repeated string container = 1;</code>
     */
    public Builder addContainer(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureContainerIsMutable();
      container_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * A list of container names, which may be empty.
     * If 'container' is not empty, releases resoures in the given
     * containers in all devices.
     * If 'container' is empty, releases resources in the default
     * container in all devices.
     * </pre>
     *
     * <code>repeated string container = 1;</code>
     */
    public Builder addAllContainer(
        java.lang.Iterable<java.lang.String> values) {
      ensureContainerIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, container_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * A list of container names, which may be empty.
     * If 'container' is not empty, releases resoures in the given
     * containers in all devices.
     * If 'container' is empty, releases resources in the default
     * container in all devices.
     * </pre>
     *
     * <code>repeated string container = 1;</code>
     */
    public Builder clearContainer() {
      container_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * A list of container names, which may be empty.
     * If 'container' is not empty, releases resoures in the given
     * containers in all devices.
     * If 'container' is empty, releases resources in the default
     * container in all devices.
     * </pre>
     *
     * <code>repeated string container = 1;</code>
     */
    public Builder addContainerBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureContainerIsMutable();
      container_.add(value);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:tensorflow.ResetRequest)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.ResetRequest)
  private static final org.tensorflow.distruntime.ResetRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.distruntime.ResetRequest();
  }

  public static org.tensorflow.distruntime.ResetRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ResetRequest>
      PARSER = new com.google.protobuf.AbstractParser<ResetRequest>() {
    public ResetRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ResetRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ResetRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ResetRequest> getParserForType() {
    return PARSER;
  }

  public org.tensorflow.distruntime.ResetRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

