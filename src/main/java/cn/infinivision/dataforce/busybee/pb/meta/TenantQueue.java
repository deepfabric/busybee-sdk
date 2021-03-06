// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * TenantQueue queue metadata
 * </pre>
 *
 * Protobuf type {@code metapb.TenantQueue}
 */
public  final class TenantQueue extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:metapb.TenantQueue)
    TenantQueueOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TenantQueue.newBuilder() to construct.
  private TenantQueue(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TenantQueue() {
    partitions_ = 0;
    consumerTimeout_ = 0L;
    maxAlive_ = 0L;
    cleanBatch_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TenantQueue(
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

            partitions_ = input.readUInt32();
            break;
          }
          case 16: {

            consumerTimeout_ = input.readInt64();
            break;
          }
          case 24: {

            maxAlive_ = input.readInt64();
            break;
          }
          case 32: {

            cleanBatch_ = input.readUInt64();
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
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_TenantQueue_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_TenantQueue_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.class, cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder.class);
  }

  public static final int PARTITIONS_FIELD_NUMBER = 1;
  private int partitions_;
  /**
   * <code>uint32 partitions = 1;</code>
   */
  public int getPartitions() {
    return partitions_;
  }

  public static final int CONSUMERTIMEOUT_FIELD_NUMBER = 2;
  private long consumerTimeout_;
  /**
   * <code>int64 consumerTimeout = 2;</code>
   */
  public long getConsumerTimeout() {
    return consumerTimeout_;
  }

  public static final int MAXALIVE_FIELD_NUMBER = 3;
  private long maxAlive_;
  /**
   * <code>int64 maxAlive = 3;</code>
   */
  public long getMaxAlive() {
    return maxAlive_;
  }

  public static final int CLEANBATCH_FIELD_NUMBER = 4;
  private long cleanBatch_;
  /**
   * <code>uint64 cleanBatch = 4;</code>
   */
  public long getCleanBatch() {
    return cleanBatch_;
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
    if (partitions_ != 0) {
      output.writeUInt32(1, partitions_);
    }
    if (consumerTimeout_ != 0L) {
      output.writeInt64(2, consumerTimeout_);
    }
    if (maxAlive_ != 0L) {
      output.writeInt64(3, maxAlive_);
    }
    if (cleanBatch_ != 0L) {
      output.writeUInt64(4, cleanBatch_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (partitions_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, partitions_);
    }
    if (consumerTimeout_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, consumerTimeout_);
    }
    if (maxAlive_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, maxAlive_);
    }
    if (cleanBatch_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(4, cleanBatch_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.meta.TenantQueue)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.meta.TenantQueue other = (cn.infinivision.dataforce.busybee.pb.meta.TenantQueue) obj;

    boolean result = true;
    result = result && (getPartitions()
        == other.getPartitions());
    result = result && (getConsumerTimeout()
        == other.getConsumerTimeout());
    result = result && (getMaxAlive()
        == other.getMaxAlive());
    result = result && (getCleanBatch()
        == other.getCleanBatch());
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
    hash = (37 * hash) + PARTITIONS_FIELD_NUMBER;
    hash = (53 * hash) + getPartitions();
    hash = (37 * hash) + CONSUMERTIMEOUT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getConsumerTimeout());
    hash = (37 * hash) + MAXALIVE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMaxAlive());
    hash = (37 * hash) + CLEANBATCH_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCleanBatch());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.meta.TenantQueue prototype) {
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
   * TenantQueue queue metadata
   * </pre>
   *
   * Protobuf type {@code metapb.TenantQueue}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:metapb.TenantQueue)
      cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_TenantQueue_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_TenantQueue_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.class, cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.newBuilder()
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
      partitions_ = 0;

      consumerTimeout_ = 0L;

      maxAlive_ = 0L;

      cleanBatch_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_TenantQueue_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue build() {
      cn.infinivision.dataforce.busybee.pb.meta.TenantQueue result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue buildPartial() {
      cn.infinivision.dataforce.busybee.pb.meta.TenantQueue result = new cn.infinivision.dataforce.busybee.pb.meta.TenantQueue(this);
      result.partitions_ = partitions_;
      result.consumerTimeout_ = consumerTimeout_;
      result.maxAlive_ = maxAlive_;
      result.cleanBatch_ = cleanBatch_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.meta.TenantQueue) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.meta.TenantQueue)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.TenantQueue other) {
      if (other == cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.getDefaultInstance()) return this;
      if (other.getPartitions() != 0) {
        setPartitions(other.getPartitions());
      }
      if (other.getConsumerTimeout() != 0L) {
        setConsumerTimeout(other.getConsumerTimeout());
      }
      if (other.getMaxAlive() != 0L) {
        setMaxAlive(other.getMaxAlive());
      }
      if (other.getCleanBatch() != 0L) {
        setCleanBatch(other.getCleanBatch());
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
      cn.infinivision.dataforce.busybee.pb.meta.TenantQueue parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.meta.TenantQueue) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int partitions_ ;
    /**
     * <code>uint32 partitions = 1;</code>
     */
    public int getPartitions() {
      return partitions_;
    }
    /**
     * <code>uint32 partitions = 1;</code>
     */
    public Builder setPartitions(int value) {
      
      partitions_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 partitions = 1;</code>
     */
    public Builder clearPartitions() {
      
      partitions_ = 0;
      onChanged();
      return this;
    }

    private long consumerTimeout_ ;
    /**
     * <code>int64 consumerTimeout = 2;</code>
     */
    public long getConsumerTimeout() {
      return consumerTimeout_;
    }
    /**
     * <code>int64 consumerTimeout = 2;</code>
     */
    public Builder setConsumerTimeout(long value) {
      
      consumerTimeout_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 consumerTimeout = 2;</code>
     */
    public Builder clearConsumerTimeout() {
      
      consumerTimeout_ = 0L;
      onChanged();
      return this;
    }

    private long maxAlive_ ;
    /**
     * <code>int64 maxAlive = 3;</code>
     */
    public long getMaxAlive() {
      return maxAlive_;
    }
    /**
     * <code>int64 maxAlive = 3;</code>
     */
    public Builder setMaxAlive(long value) {
      
      maxAlive_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 maxAlive = 3;</code>
     */
    public Builder clearMaxAlive() {
      
      maxAlive_ = 0L;
      onChanged();
      return this;
    }

    private long cleanBatch_ ;
    /**
     * <code>uint64 cleanBatch = 4;</code>
     */
    public long getCleanBatch() {
      return cleanBatch_;
    }
    /**
     * <code>uint64 cleanBatch = 4;</code>
     */
    public Builder setCleanBatch(long value) {
      
      cleanBatch_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 cleanBatch = 4;</code>
     */
    public Builder clearCleanBatch() {
      
      cleanBatch_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:metapb.TenantQueue)
  }

  // @@protoc_insertion_point(class_scope:metapb.TenantQueue)
  private static final cn.infinivision.dataforce.busybee.pb.meta.TenantQueue DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.meta.TenantQueue();
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.TenantQueue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TenantQueue>
      PARSER = new com.google.protobuf.AbstractParser<TenantQueue>() {
    public TenantQueue parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TenantQueue(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TenantQueue> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TenantQueue> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

