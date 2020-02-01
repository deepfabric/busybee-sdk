// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * Expr expr
 * </pre>
 *
 * Protobuf type {@code metapb.Expr}
 */
public  final class Expr extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:metapb.Expr)
    ExprOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Expr.newBuilder() to construct.
  private Expr(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Expr() {
    value_ = com.google.protobuf.ByteString.EMPTY;
    type_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Expr(
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

            value_ = input.readBytes();
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            type_ = rawValue;
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
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Expr_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Expr_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.meta.Expr.class, cn.infinivision.dataforce.busybee.pb.meta.Expr.Builder.class);
  }

  public static final int VALUE_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString value_;
  /**
   * <code>bytes value = 1;</code>
   */
  public com.google.protobuf.ByteString getValue() {
    return value_;
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private int type_;
  /**
   * <code>.metapb.ExprResultType type = 2;</code>
   */
  public int getTypeValue() {
    return type_;
  }
  /**
   * <code>.metapb.ExprResultType type = 2;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.ExprResultType getType() {
    cn.infinivision.dataforce.busybee.pb.meta.ExprResultType result = cn.infinivision.dataforce.busybee.pb.meta.ExprResultType.valueOf(type_);
    return result == null ? cn.infinivision.dataforce.busybee.pb.meta.ExprResultType.UNRECOGNIZED : result;
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
    if (!value_.isEmpty()) {
      output.writeBytes(1, value_);
    }
    if (type_ != cn.infinivision.dataforce.busybee.pb.meta.ExprResultType.BoolResult.getNumber()) {
      output.writeEnum(2, type_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!value_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, value_);
    }
    if (type_ != cn.infinivision.dataforce.busybee.pb.meta.ExprResultType.BoolResult.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, type_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.meta.Expr)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.meta.Expr other = (cn.infinivision.dataforce.busybee.pb.meta.Expr) obj;

    boolean result = true;
    result = result && getValue()
        .equals(other.getValue());
    result = result && type_ == other.type_;
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
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + getValue().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Expr parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.meta.Expr prototype) {
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
   * Expr expr
   * </pre>
   *
   * Protobuf type {@code metapb.Expr}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:metapb.Expr)
      cn.infinivision.dataforce.busybee.pb.meta.ExprOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Expr_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Expr_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.meta.Expr.class, cn.infinivision.dataforce.busybee.pb.meta.Expr.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.meta.Expr.newBuilder()
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
      value_ = com.google.protobuf.ByteString.EMPTY;

      type_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Expr_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Expr getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.Expr.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Expr build() {
      cn.infinivision.dataforce.busybee.pb.meta.Expr result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Expr buildPartial() {
      cn.infinivision.dataforce.busybee.pb.meta.Expr result = new cn.infinivision.dataforce.busybee.pb.meta.Expr(this);
      result.value_ = value_;
      result.type_ = type_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.meta.Expr) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.meta.Expr)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.Expr other) {
      if (other == cn.infinivision.dataforce.busybee.pb.meta.Expr.getDefaultInstance()) return this;
      if (other.getValue() != com.google.protobuf.ByteString.EMPTY) {
        setValue(other.getValue());
      }
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
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
      cn.infinivision.dataforce.busybee.pb.meta.Expr parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.meta.Expr) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.ByteString value_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes value = 1;</code>
     */
    public com.google.protobuf.ByteString getValue() {
      return value_;
    }
    /**
     * <code>bytes value = 1;</code>
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
     * <code>bytes value = 1;</code>
     */
    public Builder clearValue() {
      
      value_ = getDefaultInstance().getValue();
      onChanged();
      return this;
    }

    private int type_ = 0;
    /**
     * <code>.metapb.ExprResultType type = 2;</code>
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.metapb.ExprResultType type = 2;</code>
     */
    public Builder setTypeValue(int value) {
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.metapb.ExprResultType type = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.ExprResultType getType() {
      cn.infinivision.dataforce.busybee.pb.meta.ExprResultType result = cn.infinivision.dataforce.busybee.pb.meta.ExprResultType.valueOf(type_);
      return result == null ? cn.infinivision.dataforce.busybee.pb.meta.ExprResultType.UNRECOGNIZED : result;
    }
    /**
     * <code>.metapb.ExprResultType type = 2;</code>
     */
    public Builder setType(cn.infinivision.dataforce.busybee.pb.meta.ExprResultType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.metapb.ExprResultType type = 2;</code>
     */
    public Builder clearType() {
      
      type_ = 0;
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


    // @@protoc_insertion_point(builder_scope:metapb.Expr)
  }

  // @@protoc_insertion_point(class_scope:metapb.Expr)
  private static final cn.infinivision.dataforce.busybee.pb.meta.Expr DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.meta.Expr();
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Expr getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Expr>
      PARSER = new com.google.protobuf.AbstractParser<Expr>() {
    public Expr parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Expr(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Expr> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Expr> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.meta.Expr getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
