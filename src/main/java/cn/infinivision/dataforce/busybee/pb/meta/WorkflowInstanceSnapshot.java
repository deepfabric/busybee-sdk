// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * WorkflowInstanceSnapshot workflow instance snapshpot
 * </pre>
 *
 * Protobuf type {@code metapb.WorkflowInstanceSnapshot}
 */
public  final class WorkflowInstanceSnapshot extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:metapb.WorkflowInstanceSnapshot)
    WorkflowInstanceSnapshotOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WorkflowInstanceSnapshot.newBuilder() to construct.
  private WorkflowInstanceSnapshot(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WorkflowInstanceSnapshot() {
    timestamp_ = 0L;
    states_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WorkflowInstanceSnapshot(
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
            cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.Builder subBuilder = null;
            if (snapshot_ != null) {
              subBuilder = snapshot_.toBuilder();
            }
            snapshot_ = input.readMessage(cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(snapshot_);
              snapshot_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            timestamp_ = input.readInt64();
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              states_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.meta.StepState>();
              mutable_bitField0_ |= 0x00000004;
            }
            states_.add(
                input.readMessage(cn.infinivision.dataforce.busybee.pb.meta.StepState.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        states_ = java.util.Collections.unmodifiableList(states_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstanceSnapshot_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstanceSnapshot_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot.class, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot.Builder.class);
  }

  private int bitField0_;
  public static final int SNAPSHOT_FIELD_NUMBER = 1;
  private cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance snapshot_;
  /**
   * <code>.metapb.WorkflowInstance snapshot = 1;</code>
   */
  public boolean hasSnapshot() {
    return snapshot_ != null;
  }
  /**
   * <code>.metapb.WorkflowInstance snapshot = 1;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance getSnapshot() {
    return snapshot_ == null ? cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.getDefaultInstance() : snapshot_;
  }
  /**
   * <code>.metapb.WorkflowInstance snapshot = 1;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceOrBuilder getSnapshotOrBuilder() {
    return getSnapshot();
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 2;
  private long timestamp_;
  /**
   * <code>int64 timestamp = 2;</code>
   */
  public long getTimestamp() {
    return timestamp_;
  }

  public static final int STATES_FIELD_NUMBER = 3;
  private java.util.List<cn.infinivision.dataforce.busybee.pb.meta.StepState> states_;
  /**
   * <code>repeated .metapb.StepState states = 3;</code>
   */
  public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.StepState> getStatesList() {
    return states_;
  }
  /**
   * <code>repeated .metapb.StepState states = 3;</code>
   */
  public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.StepStateOrBuilder> 
      getStatesOrBuilderList() {
    return states_;
  }
  /**
   * <code>repeated .metapb.StepState states = 3;</code>
   */
  public int getStatesCount() {
    return states_.size();
  }
  /**
   * <code>repeated .metapb.StepState states = 3;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.StepState getStates(int index) {
    return states_.get(index);
  }
  /**
   * <code>repeated .metapb.StepState states = 3;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.StepStateOrBuilder getStatesOrBuilder(
      int index) {
    return states_.get(index);
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
    if (timestamp_ != 0L) {
      output.writeInt64(2, timestamp_);
    }
    for (int i = 0; i < states_.size(); i++) {
      output.writeMessage(3, states_.get(i));
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
    if (timestamp_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, timestamp_);
    }
    for (int i = 0; i < states_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, states_.get(i));
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot other = (cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot) obj;

    boolean result = true;
    result = result && (hasSnapshot() == other.hasSnapshot());
    if (hasSnapshot()) {
      result = result && getSnapshot()
          .equals(other.getSnapshot());
    }
    result = result && (getTimestamp()
        == other.getTimestamp());
    result = result && getStatesList()
        .equals(other.getStatesList());
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
    hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTimestamp());
    if (getStatesCount() > 0) {
      hash = (37 * hash) + STATES_FIELD_NUMBER;
      hash = (53 * hash) + getStatesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot prototype) {
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
   * WorkflowInstanceSnapshot workflow instance snapshpot
   * </pre>
   *
   * Protobuf type {@code metapb.WorkflowInstanceSnapshot}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:metapb.WorkflowInstanceSnapshot)
      cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshotOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstanceSnapshot_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstanceSnapshot_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot.class, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot.newBuilder()
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
        getStatesFieldBuilder();
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
      timestamp_ = 0L;

      if (statesBuilder_ == null) {
        states_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        statesBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_WorkflowInstanceSnapshot_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot build() {
      cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot buildPartial() {
      cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot result = new cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (snapshotBuilder_ == null) {
        result.snapshot_ = snapshot_;
      } else {
        result.snapshot_ = snapshotBuilder_.build();
      }
      result.timestamp_ = timestamp_;
      if (statesBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          states_ = java.util.Collections.unmodifiableList(states_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.states_ = states_;
      } else {
        result.states_ = statesBuilder_.build();
      }
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot other) {
      if (other == cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot.getDefaultInstance()) return this;
      if (other.hasSnapshot()) {
        mergeSnapshot(other.getSnapshot());
      }
      if (other.getTimestamp() != 0L) {
        setTimestamp(other.getTimestamp());
      }
      if (statesBuilder_ == null) {
        if (!other.states_.isEmpty()) {
          if (states_.isEmpty()) {
            states_ = other.states_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureStatesIsMutable();
            states_.addAll(other.states_);
          }
          onChanged();
        }
      } else {
        if (!other.states_.isEmpty()) {
          if (statesBuilder_.isEmpty()) {
            statesBuilder_.dispose();
            statesBuilder_ = null;
            states_ = other.states_;
            bitField0_ = (bitField0_ & ~0x00000004);
            statesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getStatesFieldBuilder() : null;
          } else {
            statesBuilder_.addAllMessages(other.states_);
          }
        }
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
      cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance snapshot_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.Builder, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceOrBuilder> snapshotBuilder_;
    /**
     * <code>.metapb.WorkflowInstance snapshot = 1;</code>
     */
    public boolean hasSnapshot() {
      return snapshotBuilder_ != null || snapshot_ != null;
    }
    /**
     * <code>.metapb.WorkflowInstance snapshot = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance getSnapshot() {
      if (snapshotBuilder_ == null) {
        return snapshot_ == null ? cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.getDefaultInstance() : snapshot_;
      } else {
        return snapshotBuilder_.getMessage();
      }
    }
    /**
     * <code>.metapb.WorkflowInstance snapshot = 1;</code>
     */
    public Builder setSnapshot(cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance value) {
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
     * <code>.metapb.WorkflowInstance snapshot = 1;</code>
     */
    public Builder setSnapshot(
        cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.Builder builderForValue) {
      if (snapshotBuilder_ == null) {
        snapshot_ = builderForValue.build();
        onChanged();
      } else {
        snapshotBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.metapb.WorkflowInstance snapshot = 1;</code>
     */
    public Builder mergeSnapshot(cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance value) {
      if (snapshotBuilder_ == null) {
        if (snapshot_ != null) {
          snapshot_ =
            cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.newBuilder(snapshot_).mergeFrom(value).buildPartial();
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
     * <code>.metapb.WorkflowInstance snapshot = 1;</code>
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
     * <code>.metapb.WorkflowInstance snapshot = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.Builder getSnapshotBuilder() {
      
      onChanged();
      return getSnapshotFieldBuilder().getBuilder();
    }
    /**
     * <code>.metapb.WorkflowInstance snapshot = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceOrBuilder getSnapshotOrBuilder() {
      if (snapshotBuilder_ != null) {
        return snapshotBuilder_.getMessageOrBuilder();
      } else {
        return snapshot_ == null ?
            cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.getDefaultInstance() : snapshot_;
      }
    }
    /**
     * <code>.metapb.WorkflowInstance snapshot = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.Builder, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceOrBuilder> 
        getSnapshotFieldBuilder() {
      if (snapshotBuilder_ == null) {
        snapshotBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstance.Builder, cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceOrBuilder>(
                getSnapshot(),
                getParentForChildren(),
                isClean());
        snapshot_ = null;
      }
      return snapshotBuilder_;
    }

    private long timestamp_ ;
    /**
     * <code>int64 timestamp = 2;</code>
     */
    public long getTimestamp() {
      return timestamp_;
    }
    /**
     * <code>int64 timestamp = 2;</code>
     */
    public Builder setTimestamp(long value) {
      
      timestamp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 timestamp = 2;</code>
     */
    public Builder clearTimestamp() {
      
      timestamp_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<cn.infinivision.dataforce.busybee.pb.meta.StepState> states_ =
      java.util.Collections.emptyList();
    private void ensureStatesIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        states_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.meta.StepState>(states_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.StepState, cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder, cn.infinivision.dataforce.busybee.pb.meta.StepStateOrBuilder> statesBuilder_;

    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.StepState> getStatesList() {
      if (statesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(states_);
      } else {
        return statesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public int getStatesCount() {
      if (statesBuilder_ == null) {
        return states_.size();
      } else {
        return statesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.StepState getStates(int index) {
      if (statesBuilder_ == null) {
        return states_.get(index);
      } else {
        return statesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public Builder setStates(
        int index, cn.infinivision.dataforce.busybee.pb.meta.StepState value) {
      if (statesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStatesIsMutable();
        states_.set(index, value);
        onChanged();
      } else {
        statesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public Builder setStates(
        int index, cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder builderForValue) {
      if (statesBuilder_ == null) {
        ensureStatesIsMutable();
        states_.set(index, builderForValue.build());
        onChanged();
      } else {
        statesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public Builder addStates(cn.infinivision.dataforce.busybee.pb.meta.StepState value) {
      if (statesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStatesIsMutable();
        states_.add(value);
        onChanged();
      } else {
        statesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public Builder addStates(
        int index, cn.infinivision.dataforce.busybee.pb.meta.StepState value) {
      if (statesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStatesIsMutable();
        states_.add(index, value);
        onChanged();
      } else {
        statesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public Builder addStates(
        cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder builderForValue) {
      if (statesBuilder_ == null) {
        ensureStatesIsMutable();
        states_.add(builderForValue.build());
        onChanged();
      } else {
        statesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public Builder addStates(
        int index, cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder builderForValue) {
      if (statesBuilder_ == null) {
        ensureStatesIsMutable();
        states_.add(index, builderForValue.build());
        onChanged();
      } else {
        statesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public Builder addAllStates(
        java.lang.Iterable<? extends cn.infinivision.dataforce.busybee.pb.meta.StepState> values) {
      if (statesBuilder_ == null) {
        ensureStatesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, states_);
        onChanged();
      } else {
        statesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public Builder clearStates() {
      if (statesBuilder_ == null) {
        states_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        statesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public Builder removeStates(int index) {
      if (statesBuilder_ == null) {
        ensureStatesIsMutable();
        states_.remove(index);
        onChanged();
      } else {
        statesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder getStatesBuilder(
        int index) {
      return getStatesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.StepStateOrBuilder getStatesOrBuilder(
        int index) {
      if (statesBuilder_ == null) {
        return states_.get(index);  } else {
        return statesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.StepStateOrBuilder> 
         getStatesOrBuilderList() {
      if (statesBuilder_ != null) {
        return statesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(states_);
      }
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder addStatesBuilder() {
      return getStatesFieldBuilder().addBuilder(
          cn.infinivision.dataforce.busybee.pb.meta.StepState.getDefaultInstance());
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder addStatesBuilder(
        int index) {
      return getStatesFieldBuilder().addBuilder(
          index, cn.infinivision.dataforce.busybee.pb.meta.StepState.getDefaultInstance());
    }
    /**
     * <code>repeated .metapb.StepState states = 3;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder> 
         getStatesBuilderList() {
      return getStatesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.StepState, cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder, cn.infinivision.dataforce.busybee.pb.meta.StepStateOrBuilder> 
        getStatesFieldBuilder() {
      if (statesBuilder_ == null) {
        statesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.meta.StepState, cn.infinivision.dataforce.busybee.pb.meta.StepState.Builder, cn.infinivision.dataforce.busybee.pb.meta.StepStateOrBuilder>(
                states_,
                ((bitField0_ & 0x00000004) == 0x00000004),
                getParentForChildren(),
                isClean());
        states_ = null;
      }
      return statesBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:metapb.WorkflowInstanceSnapshot)
  }

  // @@protoc_insertion_point(class_scope:metapb.WorkflowInstanceSnapshot)
  private static final cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot();
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WorkflowInstanceSnapshot>
      PARSER = new com.google.protobuf.AbstractParser<WorkflowInstanceSnapshot>() {
    public WorkflowInstanceSnapshot parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WorkflowInstanceSnapshot(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WorkflowInstanceSnapshot> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WorkflowInstanceSnapshot> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.meta.WorkflowInstanceSnapshot getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
