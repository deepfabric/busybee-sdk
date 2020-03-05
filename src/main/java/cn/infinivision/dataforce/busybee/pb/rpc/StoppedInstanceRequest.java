// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

/**
 * <pre>
 * StoppedInstanceRequest workflow stopped
 * </pre>
 *
 * Protobuf type {@code rpcpb.StoppedInstanceRequest}
 */
public  final class StoppedInstanceRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcpb.StoppedInstanceRequest)
    StoppedInstanceRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StoppedInstanceRequest.newBuilder() to construct.
  private StoppedInstanceRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StoppedInstanceRequest() {
    workflowID_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StoppedInstanceRequest(
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

            workflowID_ = input.readUInt64();
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
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_StoppedInstanceRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_StoppedInstanceRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest.Builder.class);
  }

  public static final int WORKFLOWID_FIELD_NUMBER = 1;
  private long workflowID_;
  /**
   * <code>uint64 workflowID = 1;</code>
   */
  public long getWorkflowID() {
    return workflowID_;
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
    if (workflowID_ != 0L) {
      output.writeUInt64(1, workflowID_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (workflowID_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, workflowID_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest other = (cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest) obj;

    boolean result = true;
    result = result && (getWorkflowID()
        == other.getWorkflowID());
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
    hash = (37 * hash) + WORKFLOWID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getWorkflowID());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest prototype) {
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
   * StoppedInstanceRequest workflow stopped
   * </pre>
   *
   * Protobuf type {@code rpcpb.StoppedInstanceRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcpb.StoppedInstanceRequest)
      cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_StoppedInstanceRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_StoppedInstanceRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest.newBuilder()
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
      workflowID_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_StoppedInstanceRequest_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest build() {
      cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest buildPartial() {
      cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest result = new cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest(this);
      result.workflowID_ = workflowID_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest other) {
      if (other == cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest.getDefaultInstance()) return this;
      if (other.getWorkflowID() != 0L) {
        setWorkflowID(other.getWorkflowID());
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
      cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long workflowID_ ;
    /**
     * <code>uint64 workflowID = 1;</code>
     */
    public long getWorkflowID() {
      return workflowID_;
    }
    /**
     * <code>uint64 workflowID = 1;</code>
     */
    public Builder setWorkflowID(long value) {
      
      workflowID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 workflowID = 1;</code>
     */
    public Builder clearWorkflowID() {
      
      workflowID_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:rpcpb.StoppedInstanceRequest)
  }

  // @@protoc_insertion_point(class_scope:rpcpb.StoppedInstanceRequest)
  private static final cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest();
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StoppedInstanceRequest>
      PARSER = new com.google.protobuf.AbstractParser<StoppedInstanceRequest>() {
    public StoppedInstanceRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StoppedInstanceRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StoppedInstanceRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StoppedInstanceRequest> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.rpc.StoppedInstanceRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

