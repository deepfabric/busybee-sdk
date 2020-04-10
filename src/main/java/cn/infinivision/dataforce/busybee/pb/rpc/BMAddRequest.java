// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

/**
 * <pre>
 * BMAddRequest add some uint64 to a bitmap
 * </pre>
 *
 * Protobuf type {@code rpcpb.BMAddRequest}
 */
public  final class BMAddRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcpb.BMAddRequest)
    BMAddRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BMAddRequest.newBuilder() to construct.
  private BMAddRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BMAddRequest() {
    key_ = com.google.protobuf.ByteString.EMPTY;
    value_ = java.util.Collections.emptyList();
    mod_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BMAddRequest(
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

            key_ = input.readBytes();
            break;
          }
          case 16: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              value_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000002;
            }
            value_.add(input.readUInt64());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
              value_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000002;
            }
            while (input.getBytesUntilLimit() > 0) {
              value_.add(input.readUInt64());
            }
            input.popLimit(limit);
            break;
          }
          case 24: {

            mod_ = input.readUInt64();
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
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        value_ = java.util.Collections.unmodifiableList(value_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BMAddRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BMAddRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest.Builder.class);
  }

  private int bitField0_;
  public static final int KEY_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString key_;
  /**
   * <code>bytes key = 1;</code>
   */
  public com.google.protobuf.ByteString getKey() {
    return key_;
  }

  public static final int VALUE_FIELD_NUMBER = 2;
  private java.util.List<java.lang.Long> value_;
  /**
   * <code>repeated uint64 value = 2;</code>
   */
  public java.util.List<java.lang.Long>
      getValueList() {
    return value_;
  }
  /**
   * <code>repeated uint64 value = 2;</code>
   */
  public int getValueCount() {
    return value_.size();
  }
  /**
   * <code>repeated uint64 value = 2;</code>
   */
  public long getValue(int index) {
    return value_.get(index);
  }
  private int valueMemoizedSerializedSize = -1;

  public static final int MOD_FIELD_NUMBER = 3;
  private long mod_;
  /**
   * <code>uint64 mod = 3;</code>
   */
  public long getMod() {
    return mod_;
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
    getSerializedSize();
    if (!key_.isEmpty()) {
      output.writeBytes(1, key_);
    }
    if (getValueList().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(valueMemoizedSerializedSize);
    }
    for (int i = 0; i < value_.size(); i++) {
      output.writeUInt64NoTag(value_.get(i));
    }
    if (mod_ != 0L) {
      output.writeUInt64(3, mod_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!key_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, key_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < value_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt64SizeNoTag(value_.get(i));
      }
      size += dataSize;
      if (!getValueList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      valueMemoizedSerializedSize = dataSize;
    }
    if (mod_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, mod_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest other = (cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest) obj;

    boolean result = true;
    result = result && getKey()
        .equals(other.getKey());
    result = result && getValueList()
        .equals(other.getValueList());
    result = result && (getMod()
        == other.getMod());
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
    hash = (37 * hash) + KEY_FIELD_NUMBER;
    hash = (53 * hash) + getKey().hashCode();
    if (getValueCount() > 0) {
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValueList().hashCode();
    }
    hash = (37 * hash) + MOD_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMod());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest prototype) {
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
   * BMAddRequest add some uint64 to a bitmap
   * </pre>
   *
   * Protobuf type {@code rpcpb.BMAddRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcpb.BMAddRequest)
      cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BMAddRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BMAddRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest.newBuilder()
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
      key_ = com.google.protobuf.ByteString.EMPTY;

      value_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      mod_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_BMAddRequest_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest build() {
      cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest buildPartial() {
      cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest result = new cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.key_ = key_;
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        value_ = java.util.Collections.unmodifiableList(value_);
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.value_ = value_;
      result.mod_ = mod_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest other) {
      if (other == cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest.getDefaultInstance()) return this;
      if (other.getKey() != com.google.protobuf.ByteString.EMPTY) {
        setKey(other.getKey());
      }
      if (!other.value_.isEmpty()) {
        if (value_.isEmpty()) {
          value_ = other.value_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureValueIsMutable();
          value_.addAll(other.value_);
        }
        onChanged();
      }
      if (other.getMod() != 0L) {
        setMod(other.getMod());
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
      cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.ByteString key_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes key = 1;</code>
     */
    public com.google.protobuf.ByteString getKey() {
      return key_;
    }
    /**
     * <code>bytes key = 1;</code>
     */
    public Builder setKey(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      key_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes key = 1;</code>
     */
    public Builder clearKey() {
      
      key_ = getDefaultInstance().getKey();
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Long> value_ = java.util.Collections.emptyList();
    private void ensureValueIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        value_ = new java.util.ArrayList<java.lang.Long>(value_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated uint64 value = 2;</code>
     */
    public java.util.List<java.lang.Long>
        getValueList() {
      return java.util.Collections.unmodifiableList(value_);
    }
    /**
     * <code>repeated uint64 value = 2;</code>
     */
    public int getValueCount() {
      return value_.size();
    }
    /**
     * <code>repeated uint64 value = 2;</code>
     */
    public long getValue(int index) {
      return value_.get(index);
    }
    /**
     * <code>repeated uint64 value = 2;</code>
     */
    public Builder setValue(
        int index, long value) {
      ensureValueIsMutable();
      value_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 value = 2;</code>
     */
    public Builder addValue(long value) {
      ensureValueIsMutable();
      value_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 value = 2;</code>
     */
    public Builder addAllValue(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureValueIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, value_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 value = 2;</code>
     */
    public Builder clearValue() {
      value_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }

    private long mod_ ;
    /**
     * <code>uint64 mod = 3;</code>
     */
    public long getMod() {
      return mod_;
    }
    /**
     * <code>uint64 mod = 3;</code>
     */
    public Builder setMod(long value) {
      
      mod_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 mod = 3;</code>
     */
    public Builder clearMod() {
      
      mod_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:rpcpb.BMAddRequest)
  }

  // @@protoc_insertion_point(class_scope:rpcpb.BMAddRequest)
  private static final cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest();
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BMAddRequest>
      PARSER = new com.google.protobuf.AbstractParser<BMAddRequest>() {
    public BMAddRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BMAddRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BMAddRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BMAddRequest> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

