// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

/**
 * <pre>
 * GetMappingRequest get id mapping request
 * </pre>
 *
 * Protobuf type {@code rpcpb.GetMappingRequest}
 */
public  final class GetMappingRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcpb.GetMappingRequest)
    GetMappingRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetMappingRequest.newBuilder() to construct.
  private GetMappingRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetMappingRequest() {
    id_ = 0L;
    to_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetMappingRequest(
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
          case 8: {

            id_ = input.readUInt64();
            break;
          }
          case 18: {
            cn.infinivision.dataforce.busybee.pb.meta.IDValue.Builder subBuilder = null;
            if (from_ != null) {
              subBuilder = from_.toBuilder();
            }
            from_ = input.readMessage(cn.infinivision.dataforce.busybee.pb.meta.IDValue.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(from_);
              from_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            to_ = s;
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
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_GetMappingRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_GetMappingRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>uint64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int FROM_FIELD_NUMBER = 2;
  private cn.infinivision.dataforce.busybee.pb.meta.IDValue from_;
  /**
   * <code>.metapb.IDValue from = 2;</code>
   */
  public boolean hasFrom() {
    return from_ != null;
  }
  /**
   * <code>.metapb.IDValue from = 2;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.IDValue getFrom() {
    return from_ == null ? cn.infinivision.dataforce.busybee.pb.meta.IDValue.getDefaultInstance() : from_;
  }
  /**
   * <code>.metapb.IDValue from = 2;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.IDValueOrBuilder getFromOrBuilder() {
    return getFrom();
  }

  public static final int TO_FIELD_NUMBER = 3;
  private volatile java.lang.Object to_;
  /**
   * <code>string to = 3;</code>
   */
  public java.lang.String getTo() {
    java.lang.Object ref = to_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      to_ = s;
      return s;
    }
  }
  /**
   * <code>string to = 3;</code>
   */
  public com.google.protobuf.ByteString
      getToBytes() {
    java.lang.Object ref = to_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      to_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (id_ != 0L) {
      output.writeUInt64(1, id_);
    }
    if (from_ != null) {
      output.writeMessage(2, getFrom());
    }
    if (!getToBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, to_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, id_);
    }
    if (from_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getFrom());
    }
    if (!getToBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, to_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest other = (cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && (hasFrom() == other.hasFrom());
    if (hasFrom()) {
      result = result && getFrom()
          .equals(other.getFrom());
    }
    result = result && getTo()
        .equals(other.getTo());
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
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    if (hasFrom()) {
      hash = (37 * hash) + FROM_FIELD_NUMBER;
      hash = (53 * hash) + getFrom().hashCode();
    }
    hash = (37 * hash) + TO_FIELD_NUMBER;
    hash = (53 * hash) + getTo().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest prototype) {
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
   * GetMappingRequest get id mapping request
   * </pre>
   *
   * Protobuf type {@code rpcpb.GetMappingRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcpb.GetMappingRequest)
      cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_GetMappingRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_GetMappingRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest.newBuilder()
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
      id_ = 0L;

      if (fromBuilder_ == null) {
        from_ = null;
      } else {
        from_ = null;
        fromBuilder_ = null;
      }
      to_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_GetMappingRequest_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest build() {
      cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest buildPartial() {
      cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest result = new cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest(this);
      result.id_ = id_;
      if (fromBuilder_ == null) {
        result.from_ = from_;
      } else {
        result.from_ = fromBuilder_.build();
      }
      result.to_ = to_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest other) {
      if (other == cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.hasFrom()) {
        mergeFrom(other.getFrom());
      }
      if (!other.getTo().isEmpty()) {
        to_ = other.to_;
        onChanged();
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
      cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long id_ ;
    /**
     * <code>uint64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }
    /**
     * <code>uint64 id = 1;</code>
     */
    public Builder setId(long value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0L;
      onChanged();
      return this;
    }

    private cn.infinivision.dataforce.busybee.pb.meta.IDValue from_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.IDValue, cn.infinivision.dataforce.busybee.pb.meta.IDValue.Builder, cn.infinivision.dataforce.busybee.pb.meta.IDValueOrBuilder> fromBuilder_;
    /**
     * <code>.metapb.IDValue from = 2;</code>
     */
    public boolean hasFrom() {
      return fromBuilder_ != null || from_ != null;
    }
    /**
     * <code>.metapb.IDValue from = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.IDValue getFrom() {
      if (fromBuilder_ == null) {
        return from_ == null ? cn.infinivision.dataforce.busybee.pb.meta.IDValue.getDefaultInstance() : from_;
      } else {
        return fromBuilder_.getMessage();
      }
    }
    /**
     * <code>.metapb.IDValue from = 2;</code>
     */
    public Builder setFrom(cn.infinivision.dataforce.busybee.pb.meta.IDValue value) {
      if (fromBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        from_ = value;
        onChanged();
      } else {
        fromBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.metapb.IDValue from = 2;</code>
     */
    public Builder setFrom(
        cn.infinivision.dataforce.busybee.pb.meta.IDValue.Builder builderForValue) {
      if (fromBuilder_ == null) {
        from_ = builderForValue.build();
        onChanged();
      } else {
        fromBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.metapb.IDValue from = 2;</code>
     */
    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.IDValue value) {
      if (fromBuilder_ == null) {
        if (from_ != null) {
          from_ =
            cn.infinivision.dataforce.busybee.pb.meta.IDValue.newBuilder(from_).mergeFrom(value).buildPartial();
        } else {
          from_ = value;
        }
        onChanged();
      } else {
        fromBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.metapb.IDValue from = 2;</code>
     */
    public Builder clearFrom() {
      if (fromBuilder_ == null) {
        from_ = null;
        onChanged();
      } else {
        from_ = null;
        fromBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.metapb.IDValue from = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.IDValue.Builder getFromBuilder() {
      
      onChanged();
      return getFromFieldBuilder().getBuilder();
    }
    /**
     * <code>.metapb.IDValue from = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.IDValueOrBuilder getFromOrBuilder() {
      if (fromBuilder_ != null) {
        return fromBuilder_.getMessageOrBuilder();
      } else {
        return from_ == null ?
            cn.infinivision.dataforce.busybee.pb.meta.IDValue.getDefaultInstance() : from_;
      }
    }
    /**
     * <code>.metapb.IDValue from = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.IDValue, cn.infinivision.dataforce.busybee.pb.meta.IDValue.Builder, cn.infinivision.dataforce.busybee.pb.meta.IDValueOrBuilder> 
        getFromFieldBuilder() {
      if (fromBuilder_ == null) {
        fromBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.meta.IDValue, cn.infinivision.dataforce.busybee.pb.meta.IDValue.Builder, cn.infinivision.dataforce.busybee.pb.meta.IDValueOrBuilder>(
                getFrom(),
                getParentForChildren(),
                isClean());
        from_ = null;
      }
      return fromBuilder_;
    }

    private java.lang.Object to_ = "";
    /**
     * <code>string to = 3;</code>
     */
    public java.lang.String getTo() {
      java.lang.Object ref = to_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        to_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string to = 3;</code>
     */
    public com.google.protobuf.ByteString
        getToBytes() {
      java.lang.Object ref = to_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        to_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string to = 3;</code>
     */
    public Builder setTo(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      to_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string to = 3;</code>
     */
    public Builder clearTo() {
      
      to_ = getDefaultInstance().getTo();
      onChanged();
      return this;
    }
    /**
     * <code>string to = 3;</code>
     */
    public Builder setToBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      to_ = value;
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


    // @@protoc_insertion_point(builder_scope:rpcpb.GetMappingRequest)
  }

  // @@protoc_insertion_point(class_scope:rpcpb.GetMappingRequest)
  private static final cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest();
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetMappingRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetMappingRequest>() {
    public GetMappingRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetMappingRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetMappingRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetMappingRequest> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

