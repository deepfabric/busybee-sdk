// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

/**
 * <pre>
 * QueueScanRequest queue scan request
 * </pre>
 *
 * Protobuf type {@code rpcpb.QueueScanRequest}
 */
public  final class QueueScanRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcpb.QueueScanRequest)
    QueueScanRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use QueueScanRequest.newBuilder() to construct.
  private QueueScanRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QueueScanRequest() {
    id_ = 0L;
    key_ = com.google.protobuf.ByteString.EMPTY;
    partition_ = 0;
    consumer_ = com.google.protobuf.ByteString.EMPTY;
    completedOffset_ = 0L;
    count_ = 0L;
    maxBytes_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private QueueScanRequest(
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

            key_ = input.readBytes();
            break;
          }
          case 24: {

            partition_ = input.readUInt32();
            break;
          }
          case 34: {

            consumer_ = input.readBytes();
            break;
          }
          case 40: {

            completedOffset_ = input.readUInt64();
            break;
          }
          case 48: {

            count_ = input.readUInt64();
            break;
          }
          case 56: {

            maxBytes_ = input.readUInt64();
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
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueScanRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueScanRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>uint64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int KEY_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString key_;
  /**
   * <code>bytes key = 2;</code>
   */
  public com.google.protobuf.ByteString getKey() {
    return key_;
  }

  public static final int PARTITION_FIELD_NUMBER = 3;
  private int partition_;
  /**
   * <code>uint32 partition = 3;</code>
   */
  public int getPartition() {
    return partition_;
  }

  public static final int CONSUMER_FIELD_NUMBER = 4;
  private com.google.protobuf.ByteString consumer_;
  /**
   * <code>bytes consumer = 4;</code>
   */
  public com.google.protobuf.ByteString getConsumer() {
    return consumer_;
  }

  public static final int COMPLETEDOFFSET_FIELD_NUMBER = 5;
  private long completedOffset_;
  /**
   * <code>uint64 completedOffset = 5;</code>
   */
  public long getCompletedOffset() {
    return completedOffset_;
  }

  public static final int COUNT_FIELD_NUMBER = 6;
  private long count_;
  /**
   * <code>uint64 count = 6;</code>
   */
  public long getCount() {
    return count_;
  }

  public static final int MAXBYTES_FIELD_NUMBER = 7;
  private long maxBytes_;
  /**
   * <code>uint64 maxBytes = 7;</code>
   */
  public long getMaxBytes() {
    return maxBytes_;
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
    if (!key_.isEmpty()) {
      output.writeBytes(2, key_);
    }
    if (partition_ != 0) {
      output.writeUInt32(3, partition_);
    }
    if (!consumer_.isEmpty()) {
      output.writeBytes(4, consumer_);
    }
    if (completedOffset_ != 0L) {
      output.writeUInt64(5, completedOffset_);
    }
    if (count_ != 0L) {
      output.writeUInt64(6, count_);
    }
    if (maxBytes_ != 0L) {
      output.writeUInt64(7, maxBytes_);
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
    if (!key_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, key_);
    }
    if (partition_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, partition_);
    }
    if (!consumer_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(4, consumer_);
    }
    if (completedOffset_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(5, completedOffset_);
    }
    if (count_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(6, count_);
    }
    if (maxBytes_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(7, maxBytes_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest other = (cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && getKey()
        .equals(other.getKey());
    result = result && (getPartition()
        == other.getPartition());
    result = result && getConsumer()
        .equals(other.getConsumer());
    result = result && (getCompletedOffset()
        == other.getCompletedOffset());
    result = result && (getCount()
        == other.getCount());
    result = result && (getMaxBytes()
        == other.getMaxBytes());
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
    hash = (37 * hash) + KEY_FIELD_NUMBER;
    hash = (53 * hash) + getKey().hashCode();
    hash = (37 * hash) + PARTITION_FIELD_NUMBER;
    hash = (53 * hash) + getPartition();
    hash = (37 * hash) + CONSUMER_FIELD_NUMBER;
    hash = (53 * hash) + getConsumer().hashCode();
    hash = (37 * hash) + COMPLETEDOFFSET_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCompletedOffset());
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCount());
    hash = (37 * hash) + MAXBYTES_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMaxBytes());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest prototype) {
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
   * QueueScanRequest queue scan request
   * </pre>
   *
   * Protobuf type {@code rpcpb.QueueScanRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcpb.QueueScanRequest)
      cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueScanRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueScanRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest.newBuilder()
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

      key_ = com.google.protobuf.ByteString.EMPTY;

      partition_ = 0;

      consumer_ = com.google.protobuf.ByteString.EMPTY;

      completedOffset_ = 0L;

      count_ = 0L;

      maxBytes_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueScanRequest_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest build() {
      cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest buildPartial() {
      cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest result = new cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest(this);
      result.id_ = id_;
      result.key_ = key_;
      result.partition_ = partition_;
      result.consumer_ = consumer_;
      result.completedOffset_ = completedOffset_;
      result.count_ = count_;
      result.maxBytes_ = maxBytes_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest other) {
      if (other == cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.getKey() != com.google.protobuf.ByteString.EMPTY) {
        setKey(other.getKey());
      }
      if (other.getPartition() != 0) {
        setPartition(other.getPartition());
      }
      if (other.getConsumer() != com.google.protobuf.ByteString.EMPTY) {
        setConsumer(other.getConsumer());
      }
      if (other.getCompletedOffset() != 0L) {
        setCompletedOffset(other.getCompletedOffset());
      }
      if (other.getCount() != 0L) {
        setCount(other.getCount());
      }
      if (other.getMaxBytes() != 0L) {
        setMaxBytes(other.getMaxBytes());
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
      cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest) e.getUnfinishedMessage();
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

    private com.google.protobuf.ByteString key_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes key = 2;</code>
     */
    public com.google.protobuf.ByteString getKey() {
      return key_;
    }
    /**
     * <code>bytes key = 2;</code>
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
     * <code>bytes key = 2;</code>
     */
    public Builder clearKey() {
      
      key_ = getDefaultInstance().getKey();
      onChanged();
      return this;
    }

    private int partition_ ;
    /**
     * <code>uint32 partition = 3;</code>
     */
    public int getPartition() {
      return partition_;
    }
    /**
     * <code>uint32 partition = 3;</code>
     */
    public Builder setPartition(int value) {
      
      partition_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 partition = 3;</code>
     */
    public Builder clearPartition() {
      
      partition_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString consumer_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes consumer = 4;</code>
     */
    public com.google.protobuf.ByteString getConsumer() {
      return consumer_;
    }
    /**
     * <code>bytes consumer = 4;</code>
     */
    public Builder setConsumer(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      consumer_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes consumer = 4;</code>
     */
    public Builder clearConsumer() {
      
      consumer_ = getDefaultInstance().getConsumer();
      onChanged();
      return this;
    }

    private long completedOffset_ ;
    /**
     * <code>uint64 completedOffset = 5;</code>
     */
    public long getCompletedOffset() {
      return completedOffset_;
    }
    /**
     * <code>uint64 completedOffset = 5;</code>
     */
    public Builder setCompletedOffset(long value) {
      
      completedOffset_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 completedOffset = 5;</code>
     */
    public Builder clearCompletedOffset() {
      
      completedOffset_ = 0L;
      onChanged();
      return this;
    }

    private long count_ ;
    /**
     * <code>uint64 count = 6;</code>
     */
    public long getCount() {
      return count_;
    }
    /**
     * <code>uint64 count = 6;</code>
     */
    public Builder setCount(long value) {
      
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 count = 6;</code>
     */
    public Builder clearCount() {
      
      count_ = 0L;
      onChanged();
      return this;
    }

    private long maxBytes_ ;
    /**
     * <code>uint64 maxBytes = 7;</code>
     */
    public long getMaxBytes() {
      return maxBytes_;
    }
    /**
     * <code>uint64 maxBytes = 7;</code>
     */
    public Builder setMaxBytes(long value) {
      
      maxBytes_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 maxBytes = 7;</code>
     */
    public Builder clearMaxBytes() {
      
      maxBytes_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:rpcpb.QueueScanRequest)
  }

  // @@protoc_insertion_point(class_scope:rpcpb.QueueScanRequest)
  private static final cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest();
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QueueScanRequest>
      PARSER = new com.google.protobuf.AbstractParser<QueueScanRequest>() {
    public QueueScanRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new QueueScanRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<QueueScanRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<QueueScanRequest> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

