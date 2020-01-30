// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * Workflow is process definition
 * </pre>
 *
 * Protobuf type {@code metapb.Workflow}
 */
public  final class Workflow extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:metapb.Workflow)
    WorkflowOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Workflow.newBuilder() to construct.
  private Workflow(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Workflow() {
    id_ = 0L;
    tenantID_ = 0L;
    name_ = "";
    steps_ = java.util.Collections.emptyList();
    duration_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Workflow(
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
          case 16: {

            tenantID_ = input.readUInt64();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              steps_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.meta.Step>();
              mutable_bitField0_ |= 0x00000008;
            }
            steps_.add(
                input.readMessage(cn.infinivision.dataforce.busybee.pb.meta.Step.parser(), extensionRegistry));
            break;
          }
          case 40: {

            duration_ = input.readInt64();
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
      if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
        steps_ = java.util.Collections.unmodifiableList(steps_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Workflow_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Workflow_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.meta.Workflow.class, cn.infinivision.dataforce.busybee.pb.meta.Workflow.Builder.class);
  }

  private int bitField0_;
  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>uint64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int TENANTID_FIELD_NUMBER = 2;
  private long tenantID_;
  /**
   * <code>uint64 tenantID = 2;</code>
   */
  public long getTenantID() {
    return tenantID_;
  }

  public static final int NAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 3;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 3;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STEPS_FIELD_NUMBER = 4;
  private java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Step> steps_;
  /**
   * <code>repeated .metapb.Step steps = 4;</code>
   */
  public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Step> getStepsList() {
    return steps_;
  }
  /**
   * <code>repeated .metapb.Step steps = 4;</code>
   */
  public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.StepOrBuilder> 
      getStepsOrBuilderList() {
    return steps_;
  }
  /**
   * <code>repeated .metapb.Step steps = 4;</code>
   */
  public int getStepsCount() {
    return steps_.size();
  }
  /**
   * <code>repeated .metapb.Step steps = 4;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.Step getSteps(int index) {
    return steps_.get(index);
  }
  /**
   * <code>repeated .metapb.Step steps = 4;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.StepOrBuilder getStepsOrBuilder(
      int index) {
    return steps_.get(index);
  }

  public static final int DURATION_FIELD_NUMBER = 5;
  private long duration_;
  /**
   * <code>int64 duration = 5;</code>
   */
  public long getDuration() {
    return duration_;
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
    if (tenantID_ != 0L) {
      output.writeUInt64(2, tenantID_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, name_);
    }
    for (int i = 0; i < steps_.size(); i++) {
      output.writeMessage(4, steps_.get(i));
    }
    if (duration_ != 0L) {
      output.writeInt64(5, duration_);
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
    if (tenantID_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, tenantID_);
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, name_);
    }
    for (int i = 0; i < steps_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, steps_.get(i));
    }
    if (duration_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, duration_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.meta.Workflow)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.meta.Workflow other = (cn.infinivision.dataforce.busybee.pb.meta.Workflow) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && (getTenantID()
        == other.getTenantID());
    result = result && getName()
        .equals(other.getName());
    result = result && getStepsList()
        .equals(other.getStepsList());
    result = result && (getDuration()
        == other.getDuration());
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
    hash = (37 * hash) + TENANTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTenantID());
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    if (getStepsCount() > 0) {
      hash = (37 * hash) + STEPS_FIELD_NUMBER;
      hash = (53 * hash) + getStepsList().hashCode();
    }
    hash = (37 * hash) + DURATION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getDuration());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.meta.Workflow prototype) {
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
   * Workflow is process definition
   * </pre>
   *
   * Protobuf type {@code metapb.Workflow}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:metapb.Workflow)
      cn.infinivision.dataforce.busybee.pb.meta.WorkflowOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Workflow_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Workflow_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.meta.Workflow.class, cn.infinivision.dataforce.busybee.pb.meta.Workflow.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.meta.Workflow.newBuilder()
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
        getStepsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0L;

      tenantID_ = 0L;

      name_ = "";

      if (stepsBuilder_ == null) {
        steps_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
      } else {
        stepsBuilder_.clear();
      }
      duration_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Workflow_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Workflow getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.Workflow.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Workflow build() {
      cn.infinivision.dataforce.busybee.pb.meta.Workflow result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Workflow buildPartial() {
      cn.infinivision.dataforce.busybee.pb.meta.Workflow result = new cn.infinivision.dataforce.busybee.pb.meta.Workflow(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.id_ = id_;
      result.tenantID_ = tenantID_;
      result.name_ = name_;
      if (stepsBuilder_ == null) {
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          steps_ = java.util.Collections.unmodifiableList(steps_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.steps_ = steps_;
      } else {
        result.steps_ = stepsBuilder_.build();
      }
      result.duration_ = duration_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.meta.Workflow) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.meta.Workflow)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.Workflow other) {
      if (other == cn.infinivision.dataforce.busybee.pb.meta.Workflow.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.getTenantID() != 0L) {
        setTenantID(other.getTenantID());
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (stepsBuilder_ == null) {
        if (!other.steps_.isEmpty()) {
          if (steps_.isEmpty()) {
            steps_ = other.steps_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureStepsIsMutable();
            steps_.addAll(other.steps_);
          }
          onChanged();
        }
      } else {
        if (!other.steps_.isEmpty()) {
          if (stepsBuilder_.isEmpty()) {
            stepsBuilder_.dispose();
            stepsBuilder_ = null;
            steps_ = other.steps_;
            bitField0_ = (bitField0_ & ~0x00000008);
            stepsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getStepsFieldBuilder() : null;
          } else {
            stepsBuilder_.addAllMessages(other.steps_);
          }
        }
      }
      if (other.getDuration() != 0L) {
        setDuration(other.getDuration());
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
      cn.infinivision.dataforce.busybee.pb.meta.Workflow parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.meta.Workflow) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

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

    private long tenantID_ ;
    /**
     * <code>uint64 tenantID = 2;</code>
     */
    public long getTenantID() {
      return tenantID_;
    }
    /**
     * <code>uint64 tenantID = 2;</code>
     */
    public Builder setTenantID(long value) {
      
      tenantID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 tenantID = 2;</code>
     */
    public Builder clearTenantID() {
      
      tenantID_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 3;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 3;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 3;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 3;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 3;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Step> steps_ =
      java.util.Collections.emptyList();
    private void ensureStepsIsMutable() {
      if (!((bitField0_ & 0x00000008) == 0x00000008)) {
        steps_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.meta.Step>(steps_);
        bitField0_ |= 0x00000008;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.Step, cn.infinivision.dataforce.busybee.pb.meta.Step.Builder, cn.infinivision.dataforce.busybee.pb.meta.StepOrBuilder> stepsBuilder_;

    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Step> getStepsList() {
      if (stepsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(steps_);
      } else {
        return stepsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public int getStepsCount() {
      if (stepsBuilder_ == null) {
        return steps_.size();
      } else {
        return stepsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Step getSteps(int index) {
      if (stepsBuilder_ == null) {
        return steps_.get(index);
      } else {
        return stepsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public Builder setSteps(
        int index, cn.infinivision.dataforce.busybee.pb.meta.Step value) {
      if (stepsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStepsIsMutable();
        steps_.set(index, value);
        onChanged();
      } else {
        stepsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public Builder setSteps(
        int index, cn.infinivision.dataforce.busybee.pb.meta.Step.Builder builderForValue) {
      if (stepsBuilder_ == null) {
        ensureStepsIsMutable();
        steps_.set(index, builderForValue.build());
        onChanged();
      } else {
        stepsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public Builder addSteps(cn.infinivision.dataforce.busybee.pb.meta.Step value) {
      if (stepsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStepsIsMutable();
        steps_.add(value);
        onChanged();
      } else {
        stepsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public Builder addSteps(
        int index, cn.infinivision.dataforce.busybee.pb.meta.Step value) {
      if (stepsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStepsIsMutable();
        steps_.add(index, value);
        onChanged();
      } else {
        stepsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public Builder addSteps(
        cn.infinivision.dataforce.busybee.pb.meta.Step.Builder builderForValue) {
      if (stepsBuilder_ == null) {
        ensureStepsIsMutable();
        steps_.add(builderForValue.build());
        onChanged();
      } else {
        stepsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public Builder addSteps(
        int index, cn.infinivision.dataforce.busybee.pb.meta.Step.Builder builderForValue) {
      if (stepsBuilder_ == null) {
        ensureStepsIsMutable();
        steps_.add(index, builderForValue.build());
        onChanged();
      } else {
        stepsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public Builder addAllSteps(
        java.lang.Iterable<? extends cn.infinivision.dataforce.busybee.pb.meta.Step> values) {
      if (stepsBuilder_ == null) {
        ensureStepsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, steps_);
        onChanged();
      } else {
        stepsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public Builder clearSteps() {
      if (stepsBuilder_ == null) {
        steps_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
      } else {
        stepsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public Builder removeSteps(int index) {
      if (stepsBuilder_ == null) {
        ensureStepsIsMutable();
        steps_.remove(index);
        onChanged();
      } else {
        stepsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Step.Builder getStepsBuilder(
        int index) {
      return getStepsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.StepOrBuilder getStepsOrBuilder(
        int index) {
      if (stepsBuilder_ == null) {
        return steps_.get(index);  } else {
        return stepsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.StepOrBuilder> 
         getStepsOrBuilderList() {
      if (stepsBuilder_ != null) {
        return stepsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(steps_);
      }
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Step.Builder addStepsBuilder() {
      return getStepsFieldBuilder().addBuilder(
          cn.infinivision.dataforce.busybee.pb.meta.Step.getDefaultInstance());
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Step.Builder addStepsBuilder(
        int index) {
      return getStepsFieldBuilder().addBuilder(
          index, cn.infinivision.dataforce.busybee.pb.meta.Step.getDefaultInstance());
    }
    /**
     * <code>repeated .metapb.Step steps = 4;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Step.Builder> 
         getStepsBuilderList() {
      return getStepsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.Step, cn.infinivision.dataforce.busybee.pb.meta.Step.Builder, cn.infinivision.dataforce.busybee.pb.meta.StepOrBuilder> 
        getStepsFieldBuilder() {
      if (stepsBuilder_ == null) {
        stepsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.meta.Step, cn.infinivision.dataforce.busybee.pb.meta.Step.Builder, cn.infinivision.dataforce.busybee.pb.meta.StepOrBuilder>(
                steps_,
                ((bitField0_ & 0x00000008) == 0x00000008),
                getParentForChildren(),
                isClean());
        steps_ = null;
      }
      return stepsBuilder_;
    }

    private long duration_ ;
    /**
     * <code>int64 duration = 5;</code>
     */
    public long getDuration() {
      return duration_;
    }
    /**
     * <code>int64 duration = 5;</code>
     */
    public Builder setDuration(long value) {
      
      duration_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 duration = 5;</code>
     */
    public Builder clearDuration() {
      
      duration_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:metapb.Workflow)
  }

  // @@protoc_insertion_point(class_scope:metapb.Workflow)
  private static final cn.infinivision.dataforce.busybee.pb.meta.Workflow DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.meta.Workflow();
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Workflow getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Workflow>
      PARSER = new com.google.protobuf.AbstractParser<Workflow>() {
    public Workflow parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Workflow(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Workflow> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Workflow> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.meta.Workflow getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

