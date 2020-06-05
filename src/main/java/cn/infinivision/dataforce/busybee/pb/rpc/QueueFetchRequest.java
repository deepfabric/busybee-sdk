// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

/**
 * <pre>
 * QueueFetchRequest fetch items from a queue
 * </pre>
 *
 * Protobuf type {@code rpcpb.QueueFetchRequest}
 */
public  final class QueueFetchRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcpb.QueueFetchRequest)
    QueueFetchRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use QueueFetchRequest.newBuilder() to construct.
  private QueueFetchRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private QueueFetchRequest() {
    id_ = 0L;
    key_ = com.google.protobuf.ByteString.EMPTY;
    group_ = com.google.protobuf.ByteString.EMPTY;
    partition_ = 0;
    consumer_ = 0;
    version_ = 0L;
    completedOffset_ = 0L;
    count_ = 0L;
    maxBytes_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private QueueFetchRequest(
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
          case 26: {

            group_ = input.readBytes();
            break;
          }
          case 32: {

            partition_ = input.readUInt32();
            break;
          }
          case 40: {

            consumer_ = input.readUInt32();
            break;
          }
          case 48: {

            version_ = input.readUInt64();
            break;
          }
          case 56: {

            completedOffset_ = input.readUInt64();
            break;
          }
          case 64: {

            count_ = input.readUInt64();
            break;
          }
          case 72: {

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
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueFetchRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueFetchRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest.Builder.class);
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

  public static final int GROUP_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString group_;
  /**
   * <code>bytes group = 3;</code>
   */
  public com.google.protobuf.ByteString getGroup() {
    return group_;
  }

  public static final int PARTITION_FIELD_NUMBER = 4;
  private int partition_;
  /**
   * <code>uint32 partition = 4;</code>
   */
  public int getPartition() {
    return partition_;
  }

  public static final int CONSUMER_FIELD_NUMBER = 5;
  private int consumer_;
  /**
   * <code>uint32 consumer = 5;</code>
   */
  public int getConsumer() {
    return consumer_;
  }

  public static final int VERSION_FIELD_NUMBER = 6;
  private long version_;
  /**
   * <code>uint64 version = 6;</code>
   */
  public long getVersion() {
    return version_;
  }

  public static final int COMPLETEDOFFSET_FIELD_NUMBER = 7;
  private long completedOffset_;
  /**
   * <code>uint64 completedOffset = 7;</code>
   */
  public long getCompletedOffset() {
    return completedOffset_;
  }

  public static final int COUNT_FIELD_NUMBER = 8;
  private long count_;
  /**
   * <code>uint64 count = 8;</code>
   */
  public long getCount() {
    return count_;
  }

  public static final int MAXBYTES_FIELD_NUMBER = 9;
  private long maxBytes_;
  /**
   * <code>uint64 maxBytes = 9;</code>
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
    if (!group_.isEmpty()) {
      output.writeBytes(3, group_);
    }
    if (partition_ != 0) {
      output.writeUInt32(4, partition_);
    }
    if (consumer_ != 0) {
      output.writeUInt32(5, consumer_);
    }
    if (version_ != 0L) {
      output.writeUInt64(6, version_);
    }
    if (completedOffset_ != 0L) {
      output.writeUInt64(7, completedOffset_);
    }
    if (count_ != 0L) {
      output.writeUInt64(8, count_);
    }
    if (maxBytes_ != 0L) {
      output.writeUInt64(9, maxBytes_);
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
    if (!group_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, group_);
    }
    if (partition_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(4, partition_);
    }
    if (consumer_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(5, consumer_);
    }
    if (version_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(6, version_);
    }
    if (completedOffset_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(7, completedOffset_);
    }
    if (count_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(8, count_);
    }
    if (maxBytes_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(9, maxBytes_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest other = (cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && getKey()
        .equals(other.getKey());
    result = result && getGroup()
        .equals(other.getGroup());
    result = result && (getPartition()
        == other.getPartition());
    result = result && (getConsumer()
        == other.getConsumer());
    result = result && (getVersion()
        == other.getVersion());
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
    hash = (37 * hash) + GROUP_FIELD_NUMBER;
    hash = (53 * hash) + getGroup().hashCode();
    hash = (37 * hash) + PARTITION_FIELD_NUMBER;
    hash = (53 * hash) + getPartition();
    hash = (37 * hash) + CONSUMER_FIELD_NUMBER;
    hash = (53 * hash) + getConsumer();
    hash = (37 * hash) + VERSION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getVersion());
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

  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest prototype) {
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
   * QueueFetchRequest fetch items from a queue
   * </pre>
   *
   * Protobuf type {@code rpcpb.QueueFetchRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcpb.QueueFetchRequest)
      cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueFetchRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueFetchRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest.class, cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest.newBuilder()
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

      group_ = com.google.protobuf.ByteString.EMPTY;

      partition_ = 0;

      consumer_ = 0;

      version_ = 0L;

      completedOffset_ = 0L;

      count_ = 0L;

      maxBytes_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_QueueFetchRequest_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest build() {
      cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest buildPartial() {
      cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest result = new cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest(this);
      result.id_ = id_;
      result.key_ = key_;
      result.group_ = group_;
      result.partition_ = partition_;
      result.consumer_ = consumer_;
      result.version_ = version_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest other) {
      if (other == cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.getKey() != com.google.protobuf.ByteString.EMPTY) {
        setKey(other.getKey());
      }
      if (other.getGroup() != com.google.protobuf.ByteString.EMPTY) {
        setGroup(other.getGroup());
      }
      if (other.getPartition() != 0) {
        setPartition(other.getPartition());
      }
      if (other.getConsumer() != 0) {
        setConsumer(other.getConsumer());
      }
      if (other.getVersion() != 0L) {
        setVersion(other.getVersion());
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
      cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest) e.getUnfinishedMessage();
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

    private com.google.protobuf.ByteString group_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes group = 3;</code>
     */
    public com.google.protobuf.ByteString getGroup() {
      return group_;
    }
    /**
     * <code>bytes group = 3;</code>
     */
    public Builder setGroup(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      group_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes group = 3;</code>
     */
    public Builder clearGroup() {
      
      group_ = getDefaultInstance().getGroup();
      onChanged();
      return this;
    }

    private int partition_ ;
    /**
     * <code>uint32 partition = 4;</code>
     */
    public int getPartition() {
      return partition_;
    }
    /**
     * <code>uint32 partition = 4;</code>
     */
    public Builder setPartition(int value) {
      
      partition_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 partition = 4;</code>
     */
    public Builder clearPartition() {
      
      partition_ = 0;
      onChanged();
      return this;
    }

    private int consumer_ ;
    /**
     * <code>uint32 consumer = 5;</code>
     */
    public int getConsumer() {
      return consumer_;
    }
    /**
     * <code>uint32 consumer = 5;</code>
     */
    public Builder setConsumer(int value) {
      
      consumer_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 consumer = 5;</code>
     */
    public Builder clearConsumer() {
      
      consumer_ = 0;
      onChanged();
      return this;
    }

    private long version_ ;
    /**
     * <code>uint64 version = 6;</code>
     */
    public long getVersion() {
      return version_;
    }
    /**
     * <code>uint64 version = 6;</code>
     */
    public Builder setVersion(long value) {
      
      version_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 version = 6;</code>
     */
    public Builder clearVersion() {
      
      version_ = 0L;
      onChanged();
      return this;
    }

    private long completedOffset_ ;
    /**
     * <code>uint64 completedOffset = 7;</code>
     */
    public long getCompletedOffset() {
      return completedOffset_;
    }
    /**
     * <code>uint64 completedOffset = 7;</code>
     */
    public Builder setCompletedOffset(long value) {
      
      completedOffset_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 completedOffset = 7;</code>
     */
    public Builder clearCompletedOffset() {
      
      completedOffset_ = 0L;
      onChanged();
      return this;
    }

    private long count_ ;
    /**
     * <code>uint64 count = 8;</code>
     */
    public long getCount() {
      return count_;
    }
    /**
     * <code>uint64 count = 8;</code>
     */
    public Builder setCount(long value) {
      
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 count = 8;</code>
     */
    public Builder clearCount() {
      
      count_ = 0L;
      onChanged();
      return this;
    }

    private long maxBytes_ ;
    /**
     * <code>uint64 maxBytes = 9;</code>
     */
    public long getMaxBytes() {
      return maxBytes_;
    }
    /**
     * <code>uint64 maxBytes = 9;</code>
     */
    public Builder setMaxBytes(long value) {
      
      maxBytes_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 maxBytes = 9;</code>
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


    // @@protoc_insertion_point(builder_scope:rpcpb.QueueFetchRequest)
  }

  // @@protoc_insertion_point(class_scope:rpcpb.QueueFetchRequest)
  private static final cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest();
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QueueFetchRequest>
      PARSER = new com.google.protobuf.AbstractParser<QueueFetchRequest>() {
    public QueueFetchRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new QueueFetchRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<QueueFetchRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<QueueFetchRequest> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

