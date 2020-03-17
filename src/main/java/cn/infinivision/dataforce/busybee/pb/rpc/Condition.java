// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

/**
 * <pre>
 * Condition condition
 * </pre>
 *
 * Protobuf type {@code rpcpb.Condition}
 */
public  final class Condition extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcpb.Condition)
    ConditionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Condition.newBuilder() to construct.
  private Condition(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Condition() {
    key_ = com.google.protobuf.ByteString.EMPTY;
    cmp_ = 0;
    value_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Condition(
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
            int rawValue = input.readEnum();

            cmp_ = rawValue;
            break;
          }
          case 26: {

            value_ = input.readBytes();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_Condition_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_Condition_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.rpc.Condition.class, cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder.class);
  }

  public static final int KEY_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString key_;
  /**
   * <code>bytes key = 1;</code>
   */
  public com.google.protobuf.ByteString getKey() {
    return key_;
  }

  public static final int CMP_FIELD_NUMBER = 2;
  private int cmp_;
  /**
   * <code>.rpcpb.Cmp cmp = 2;</code>
   */
  public int getCmpValue() {
    return cmp_;
  }
  /**
   * <code>.rpcpb.Cmp cmp = 2;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.rpc.Cmp getCmp() {
    cn.infinivision.dataforce.busybee.pb.rpc.Cmp result = cn.infinivision.dataforce.busybee.pb.rpc.Cmp.valueOf(cmp_);
    return result == null ? cn.infinivision.dataforce.busybee.pb.rpc.Cmp.UNRECOGNIZED : result;
  }

  public static final int VALUE_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString value_;
  /**
   * <code>bytes value = 3;</code>
   */
  public com.google.protobuf.ByteString getValue() {
    return value_;
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
    if (!key_.isEmpty()) {
      output.writeBytes(1, key_);
    }
    if (cmp_ != cn.infinivision.dataforce.busybee.pb.rpc.Cmp.Exists.getNumber()) {
      output.writeEnum(2, cmp_);
    }
    if (!value_.isEmpty()) {
      output.writeBytes(3, value_);
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
    if (cmp_ != cn.infinivision.dataforce.busybee.pb.rpc.Cmp.Exists.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, cmp_);
    }
    if (!value_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, value_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.rpc.Condition)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.rpc.Condition other = (cn.infinivision.dataforce.busybee.pb.rpc.Condition) obj;

    boolean result = true;
    result = result && getKey()
        .equals(other.getKey());
    result = result && cmp_ == other.cmp_;
    result = result && getValue()
        .equals(other.getValue());
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
    hash = (37 * hash) + CMP_FIELD_NUMBER;
    hash = (53 * hash) + cmp_;
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + getValue().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.rpc.Condition prototype) {
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
   * Condition condition
   * </pre>
   *
   * Protobuf type {@code rpcpb.Condition}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcpb.Condition)
      cn.infinivision.dataforce.busybee.pb.rpc.ConditionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_Condition_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_Condition_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.rpc.Condition.class, cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.rpc.Condition.newBuilder()
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

      cmp_ = 0;

      value_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_Condition_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.Condition getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.Condition.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.Condition build() {
      cn.infinivision.dataforce.busybee.pb.rpc.Condition result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.Condition buildPartial() {
      cn.infinivision.dataforce.busybee.pb.rpc.Condition result = new cn.infinivision.dataforce.busybee.pb.rpc.Condition(this);
      result.key_ = key_;
      result.cmp_ = cmp_;
      result.value_ = value_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.rpc.Condition) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.rpc.Condition)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.rpc.Condition other) {
      if (other == cn.infinivision.dataforce.busybee.pb.rpc.Condition.getDefaultInstance()) return this;
      if (other.getKey() != com.google.protobuf.ByteString.EMPTY) {
        setKey(other.getKey());
      }
      if (other.cmp_ != 0) {
        setCmpValue(other.getCmpValue());
      }
      if (other.getValue() != com.google.protobuf.ByteString.EMPTY) {
        setValue(other.getValue());
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
      cn.infinivision.dataforce.busybee.pb.rpc.Condition parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.rpc.Condition) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

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

    private int cmp_ = 0;
    /**
     * <code>.rpcpb.Cmp cmp = 2;</code>
     */
    public int getCmpValue() {
      return cmp_;
    }
    /**
     * <code>.rpcpb.Cmp cmp = 2;</code>
     */
    public Builder setCmpValue(int value) {
      cmp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.rpcpb.Cmp cmp = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.rpc.Cmp getCmp() {
      cn.infinivision.dataforce.busybee.pb.rpc.Cmp result = cn.infinivision.dataforce.busybee.pb.rpc.Cmp.valueOf(cmp_);
      return result == null ? cn.infinivision.dataforce.busybee.pb.rpc.Cmp.UNRECOGNIZED : result;
    }
    /**
     * <code>.rpcpb.Cmp cmp = 2;</code>
     */
    public Builder setCmp(cn.infinivision.dataforce.busybee.pb.rpc.Cmp value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      cmp_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.rpcpb.Cmp cmp = 2;</code>
     */
    public Builder clearCmp() {
      
      cmp_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString value_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes value = 3;</code>
     */
    public com.google.protobuf.ByteString getValue() {
      return value_;
    }
    /**
     * <code>bytes value = 3;</code>
     */
    public Builder setValue(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes value = 3;</code>
     */
    public Builder clearValue() {
      
      value_ = getDefaultInstance().getValue();
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


    // @@protoc_insertion_point(builder_scope:rpcpb.Condition)
  }

  // @@protoc_insertion_point(class_scope:rpcpb.Condition)
  private static final cn.infinivision.dataforce.busybee.pb.rpc.Condition DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.rpc.Condition();
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.Condition getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Condition>
      PARSER = new com.google.protobuf.AbstractParser<Condition>() {
    public Condition parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Condition(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Condition> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Condition> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.rpc.Condition getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

