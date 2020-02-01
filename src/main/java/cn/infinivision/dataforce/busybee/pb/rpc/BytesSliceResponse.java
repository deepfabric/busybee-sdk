// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

/**
 * <pre>
 * BytesSliceResponse response
 * </pre>
 *
 * Protobuf type {@code rpcpb.BytesSliceResponse}
 */
public  final class BytesSliceResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcpb.BytesSliceResponse)
    BytesSliceResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BytesSliceResponse.newBuilder() to construct.
  private BytesSliceResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BytesSliceResponse() {
    items_ = java.util.Collections.emptyList();
    lastOffset_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BytesSliceResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              items_ = new java.util.ArrayList<com.google.protobuf.ByteString>();
              mutable_bitField0_ |= 0x00000001;
            }
            items_.add(input.readBytes());
            break;
          }
          case 16: {

            lastOffset_ = input.readUInt64();
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
        items_ = java.util.Collections.unmodifiableList(items_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BytesSliceResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BytesSliceResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse.class, cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse.Builder.class);
  }

  private int bitField0_;
  public static final int ITEMS_FIELD_NUMBER = 1;
  private java.util.List<com.google.protobuf.ByteString> items_;
  /**
   * <code>repeated bytes items = 1;</code>
   */
  public java.util.List<com.google.protobuf.ByteString>
      getItemsList() {
    return items_;
  }
  /**
   * <code>repeated bytes items = 1;</code>
   */
  public int getItemsCount() {
    return items_.size();
  }
  /**
   * <code>repeated bytes items = 1;</code>
   */
  public com.google.protobuf.ByteString getItems(int index) {
    return items_.get(index);
  }

  public static final int LASTOFFSET_FIELD_NUMBER = 2;
  private long lastOffset_;
  /**
   * <code>uint64 lastOffset = 2;</code>
   */
  public long getLastOffset() {
    return lastOffset_;
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
    for (int i = 0; i < items_.size(); i++) {
      output.writeBytes(1, items_.get(i));
    }
    if (lastOffset_ != 0L) {
      output.writeUInt64(2, lastOffset_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < items_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeBytesSizeNoTag(items_.get(i));
      }
      size += dataSize;
      size += 1 * getItemsList().size();
    }
    if (lastOffset_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, lastOffset_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse other = (cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse) obj;

    boolean result = true;
    result = result && getItemsList()
        .equals(other.getItemsList());
    result = result && (getLastOffset()
        == other.getLastOffset());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getItemsCount() > 0) {
      hash = (37 * hash) + ITEMS_FIELD_NUMBER;
      hash = (53 * hash) + getItemsList().hashCode();
    }
    hash = (37 * hash) + LASTOFFSET_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLastOffset());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse prototype) {
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
   * BytesSliceResponse response
   * </pre>
   *
   * Protobuf type {@code rpcpb.BytesSliceResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcpb.BytesSliceResponse)
      cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BytesSliceResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BytesSliceResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse.class, cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse.newBuilder()
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
      items_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      lastOffset_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BytesSliceResponse_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse build() {
      cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse buildPartial() {
      cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse result = new cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        items_ = java.util.Collections.unmodifiableList(items_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.items_ = items_;
      result.lastOffset_ = lastOffset_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
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
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse other) {
      if (other == cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse.getDefaultInstance()) return this;
      if (!other.items_.isEmpty()) {
        if (items_.isEmpty()) {
          items_ = other.items_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureItemsIsMutable();
          items_.addAll(other.items_);
        }
        onChanged();
      }
      if (other.getLastOffset() != 0L) {
        setLastOffset(other.getLastOffset());
      }
      this.mergeUnknownFields(other.unknownFields);
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
      cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.google.protobuf.ByteString> items_ = java.util.Collections.emptyList();
    private void ensureItemsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        items_ = new java.util.ArrayList<com.google.protobuf.ByteString>(items_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated bytes items = 1;</code>
     */
    public java.util.List<com.google.protobuf.ByteString>
        getItemsList() {
      return java.util.Collections.unmodifiableList(items_);
    }
    /**
     * <code>repeated bytes items = 1;</code>
     */
    public int getItemsCount() {
      return items_.size();
    }
    /**
     * <code>repeated bytes items = 1;</code>
     */
    public com.google.protobuf.ByteString getItems(int index) {
      return items_.get(index);
    }
    /**
     * <code>repeated bytes items = 1;</code>
     */
    public Builder setItems(
        int index, com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureItemsIsMutable();
      items_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated bytes items = 1;</code>
     */
    public Builder addItems(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureItemsIsMutable();
      items_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated bytes items = 1;</code>
     */
    public Builder addAllItems(
        java.lang.Iterable<? extends com.google.protobuf.ByteString> values) {
      ensureItemsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, items_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated bytes items = 1;</code>
     */
    public Builder clearItems() {
      items_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private long lastOffset_ ;
    /**
     * <code>uint64 lastOffset = 2;</code>
     */
    public long getLastOffset() {
      return lastOffset_;
    }
    /**
     * <code>uint64 lastOffset = 2;</code>
     */
    public Builder setLastOffset(long value) {
      
      lastOffset_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 lastOffset = 2;</code>
     */
    public Builder clearLastOffset() {
      
      lastOffset_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:rpcpb.BytesSliceResponse)
  }

  // @@protoc_insertion_point(class_scope:rpcpb.BytesSliceResponse)
  private static final cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse();
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BytesSliceResponse>
      PARSER = new com.google.protobuf.AbstractParser<BytesSliceResponse>() {
    public BytesSliceResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BytesSliceResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BytesSliceResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BytesSliceResponse> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.rpc.BytesSliceResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
