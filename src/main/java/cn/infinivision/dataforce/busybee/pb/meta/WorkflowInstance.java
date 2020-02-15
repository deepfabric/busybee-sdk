// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * WorkflowInstance workflow instance
 * </pre>
 *
 * Protobuf type {@code metapb.WorkflowInstance}
 */
public  final class WorkflowInstance extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:metapb.WorkflowInstance)
    WorkflowInstanceOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WorkflowInstance.newBuilder() to construct.
  private WorkflowInstance(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WorkflowInstance() {
    crowd_ = com.google.protobuf.ByteString.EMPTY;
    workers_ = 0L;
    startedAt_ = 0L;
    stoppedAt_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WorkflowInstance(
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
            cn.infinivision.dataforce.busybee.pb.meta.Workflow.Builder subBuilder = null;
            if (snapshot_ != null) {
              subBuilder = snapshot_.toBuilder();
            }
            snapshot_ = input.readMessage(cn.infinivision.dataforce.busybee.pb.meta.Workflow.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(snapshot_);
              snapshot_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {

            crowd_ = input.readBytes();
            break;
          }
          case 24: {

            workers_ = input.readUInt64();
            break;
          }
          case 32: {

            startedAt_ = input.readInt64();
            break;
          }
          case 40: {

            stoppedAt_ = input.readInt64();
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
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstance_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstance_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.class, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.Builder.class);
  }

  public static final int SNAPSHOT_FIELD_NUMBER = 1;
  private cn.infinivision.dataforce.busybee.pb.meta.Workflow snapshot_;
  /**
   * <code>.metapb.Workflow snapshot = 1;</code>
   */
  public boolean hasSnapshot() {
    return snapshot_ != null;
  }
  /**
   * <code>.metapb.Workflow snapshot = 1;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.Workflow getSnapshot() {
    return snapshot_ == null ? cn.infinivision.dataforce.busybee.pb.meta.Workflow.getDefaultInstance() : snapshot_;
  }
  /**
   * <code>.metapb.Workflow snapshot = 1;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.WorkflowOrBuilder getSnapshotOrBuilder() {
    return getSnapshot();
  }

  public static final int CROWD_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString crowd_;
  /**
   * <code>bytes crowd = 2;</code>
   */
  public com.google.protobuf.ByteString getCrowd() {
    return crowd_;
  }

  public static final int WORKERS_FIELD_NUMBER = 3;
  private long workers_;
  /**
   * <code>uint64 workers = 3;</code>
   */
  public long getWorkers() {
    return workers_;
  }

  public static final int STARTEDAT_FIELD_NUMBER = 4;
  private long startedAt_;
  /**
   * <code>int64 startedAt = 4;</code>
   */
  public long getStartedAt() {
    return startedAt_;
  }

  public static final int STOPPEDAT_FIELD_NUMBER = 5;
  private long stoppedAt_;
  /**
   * <code>int64 stoppedAt = 5;</code>
   */
  public long getStoppedAt() {
    return stoppedAt_;
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
    if (snapshot_ != null) {
      output.writeMessage(1, getSnapshot());
    }
    if (!crowd_.isEmpty()) {
      output.writeBytes(2, crowd_);
    }
    if (workers_ != 0L) {
      output.writeUInt64(3, workers_);
    }
    if (startedAt_ != 0L) {
      output.writeInt64(4, startedAt_);
    }
    if (stoppedAt_ != 0L) {
      output.writeInt64(5, stoppedAt_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (snapshot_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getSnapshot());
    }
    if (!crowd_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, crowd_);
    }
    if (workers_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, workers_);
    }
    if (startedAt_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, startedAt_);
    }
    if (stoppedAt_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, stoppedAt_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance other = (cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance) obj;

    boolean result = true;
    result = result && (hasSnapshot() == other.hasSnapshot());
    if (hasSnapshot()) {
      result = result && getSnapshot()
          .equals(other.getSnapshot());
    }
    result = result && getCrowd()
        .equals(other.getCrowd());
    result = result && (getWorkers()
        == other.getWorkers());
    result = result && (getStartedAt()
        == other.getStartedAt());
    result = result && (getStoppedAt()
        == other.getStoppedAt());
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
    if (hasSnapshot()) {
      hash = (37 * hash) + SNAPSHOT_FIELD_NUMBER;
      hash = (53 * hash) + getSnapshot().hashCode();
    }
    hash = (37 * hash) + CROWD_FIELD_NUMBER;
    hash = (53 * hash) + getCrowd().hashCode();
    hash = (37 * hash) + WORKERS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getWorkers());
    hash = (37 * hash) + STARTEDAT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getStartedAt());
    hash = (37 * hash) + STOPPEDAT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getStoppedAt());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance prototype) {
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
   * WorkflowInstance workflow instance
   * </pre>
   *
   * Protobuf type {@code metapb.WorkflowInstance}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:metapb.WorkflowInstance)
      cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstance_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstance_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.class, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.newBuilder()
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
      if (snapshotBuilder_ == null) {
        snapshot_ = null;
      } else {
        snapshot_ = null;
        snapshotBuilder_ = null;
      }
      crowd_ = com.google.protobuf.ByteString.EMPTY;

      workers_ = 0L;

      startedAt_ = 0L;

      stoppedAt_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstance_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance build() {
      cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance buildPartial() {
      cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance result = new cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance(this);
      if (snapshotBuilder_ == null) {
        result.snapshot_ = snapshot_;
      } else {
        result.snapshot_ = snapshotBuilder_.build();
      }
      result.crowd_ = crowd_;
      result.workers_ = workers_;
      result.startedAt_ = startedAt_;
      result.stoppedAt_ = stoppedAt_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance other) {
      if (other == cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.getDefaultInstance()) return this;
      if (other.hasSnapshot()) {
        mergeSnapshot(other.getSnapshot());
      }
      if (other.getCrowd() != com.google.protobuf.ByteString.EMPTY) {
        setCrowd(other.getCrowd());
      }
      if (other.getWorkers() != 0L) {
        setWorkers(other.getWorkers());
      }
      if (other.getStartedAt() != 0L) {
        setStartedAt(other.getStartedAt());
      }
      if (other.getStoppedAt() != 0L) {
        setStoppedAt(other.getStoppedAt());
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
      cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private cn.infinivision.dataforce.busybee.pb.meta.Workflow snapshot_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.Workflow, cn.infinivision.dataforce.busybee.pb.meta.Workflow.Builder, cn.infinivision.dataforce.busybee.pb.meta.WorkflowOrBuilder> snapshotBuilder_;
    /**
     * <code>.metapb.Workflow snapshot = 1;</code>
     */
    public boolean hasSnapshot() {
      return snapshotBuilder_ != null || snapshot_ != null;
    }
    /**
     * <code>.metapb.Workflow snapshot = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Workflow getSnapshot() {
      if (snapshotBuilder_ == null) {
        return snapshot_ == null ? cn.infinivision.dataforce.busybee.pb.meta.Workflow.getDefaultInstance() : snapshot_;
      } else {
        return snapshotBuilder_.getMessage();
      }
    }
    /**
     * <code>.metapb.Workflow snapshot = 1;</code>
     */
    public Builder setSnapshot(cn.infinivision.dataforce.busybee.pb.meta.Workflow value) {
      if (snapshotBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        snapshot_ = value;
        onChanged();
      } else {
        snapshotBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.metapb.Workflow snapshot = 1;</code>
     */
    public Builder setSnapshot(
        cn.infinivision.dataforce.busybee.pb.meta.Workflow.Builder builderForValue) {
      if (snapshotBuilder_ == null) {
        snapshot_ = builderForValue.build();
        onChanged();
      } else {
        snapshotBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.metapb.Workflow snapshot = 1;</code>
     */
    public Builder mergeSnapshot(cn.infinivision.dataforce.busybee.pb.meta.Workflow value) {
      if (snapshotBuilder_ == null) {
        if (snapshot_ != null) {
          snapshot_ =
            cn.infinivision.dataforce.busybee.pb.meta.Workflow.newBuilder(snapshot_).mergeFrom(value).buildPartial();
        } else {
          snapshot_ = value;
        }
        onChanged();
      } else {
        snapshotBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.metapb.Workflow snapshot = 1;</code>
     */
    public Builder clearSnapshot() {
      if (snapshotBuilder_ == null) {
        snapshot_ = null;
        onChanged();
      } else {
        snapshot_ = null;
        snapshotBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.metapb.Workflow snapshot = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Workflow.Builder getSnapshotBuilder() {
      
      onChanged();
      return getSnapshotFieldBuilder().getBuilder();
    }
    /**
     * <code>.metapb.Workflow snapshot = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowOrBuilder getSnapshotOrBuilder() {
      if (snapshotBuilder_ != null) {
        return snapshotBuilder_.getMessageOrBuilder();
      } else {
        return snapshot_ == null ?
            cn.infinivision.dataforce.busybee.pb.meta.Workflow.getDefaultInstance() : snapshot_;
      }
    }
    /**
     * <code>.metapb.Workflow snapshot = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.Workflow, cn.infinivision.dataforce.busybee.pb.meta.Workflow.Builder, cn.infinivision.dataforce.busybee.pb.meta.WorkflowOrBuilder> 
        getSnapshotFieldBuilder() {
      if (snapshotBuilder_ == null) {
        snapshotBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.meta.Workflow, cn.infinivision.dataforce.busybee.pb.meta.Workflow.Builder, cn.infinivision.dataforce.busybee.pb.meta.WorkflowOrBuilder>(
                getSnapshot(),
                getParentForChildren(),
                isClean());
        snapshot_ = null;
      }
      return snapshotBuilder_;
    }

    private com.google.protobuf.ByteString crowd_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes crowd = 2;</code>
     */
    public com.google.protobuf.ByteString getCrowd() {
      return crowd_;
    }
    /**
     * <code>bytes crowd = 2;</code>
     */
    public Builder setCrowd(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      crowd_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes crowd = 2;</code>
     */
    public Builder clearCrowd() {
      
      crowd_ = getDefaultInstance().getCrowd();
      onChanged();
      return this;
    }

    private long workers_ ;
    /**
     * <code>uint64 workers = 3;</code>
     */
    public long getWorkers() {
      return workers_;
    }
    /**
     * <code>uint64 workers = 3;</code>
     */
    public Builder setWorkers(long value) {
      
      workers_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 workers = 3;</code>
     */
    public Builder clearWorkers() {
      
      workers_ = 0L;
      onChanged();
      return this;
    }

    private long startedAt_ ;
    /**
     * <code>int64 startedAt = 4;</code>
     */
    public long getStartedAt() {
      return startedAt_;
    }
    /**
     * <code>int64 startedAt = 4;</code>
     */
    public Builder setStartedAt(long value) {
      
      startedAt_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 startedAt = 4;</code>
     */
    public Builder clearStartedAt() {
      
      startedAt_ = 0L;
      onChanged();
      return this;
    }

    private long stoppedAt_ ;
    /**
     * <code>int64 stoppedAt = 5;</code>
     */
    public long getStoppedAt() {
      return stoppedAt_;
    }
    /**
     * <code>int64 stoppedAt = 5;</code>
     */
    public Builder setStoppedAt(long value) {
      
      stoppedAt_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 stoppedAt = 5;</code>
     */
    public Builder clearStoppedAt() {
      
      stoppedAt_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:metapb.WorkflowInstance)
  }

  // @@protoc_insertion_point(class_scope:metapb.WorkflowInstance)
  private static final cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance();
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WorkflowInstance>
      PARSER = new com.google.protobuf.AbstractParser<WorkflowInstance>() {
    public WorkflowInstance parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WorkflowInstance(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WorkflowInstance> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WorkflowInstance> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

