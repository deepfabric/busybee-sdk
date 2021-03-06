// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * ParallelExecution is a parallel execution
 * </pre>
 *
 * Protobuf type {@code metapb.ParallelExecution}
 */
public  final class ParallelExecution extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:metapb.ParallelExecution)
    ParallelExecutionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ParallelExecution.newBuilder() to construct.
  private ParallelExecution(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ParallelExecution() {
    nextStep_ = "";
    parallels_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ParallelExecution(
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
            java.lang.String s = input.readStringRequireUtf8();

            nextStep_ = s;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              parallels_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.meta.Execution>();
              mutable_bitField0_ |= 0x00000002;
            }
            parallels_.add(
                input.readMessage(cn.infinivision.dataforce.busybee.pb.meta.Execution.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        parallels_ = java.util.Collections.unmodifiableList(parallels_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_ParallelExecution_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_ParallelExecution_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution.class, cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution.Builder.class);
  }

  private int bitField0_;
  public static final int NEXTSTEP_FIELD_NUMBER = 1;
  private volatile java.lang.Object nextStep_;
  /**
   * <code>string nextStep = 1;</code>
   */
  public java.lang.String getNextStep() {
    java.lang.Object ref = nextStep_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nextStep_ = s;
      return s;
    }
  }
  /**
   * <code>string nextStep = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNextStepBytes() {
    java.lang.Object ref = nextStep_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nextStep_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PARALLELS_FIELD_NUMBER = 2;
  private java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Execution> parallels_;
  /**
   * <code>repeated .metapb.Execution parallels = 2;</code>
   */
  public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Execution> getParallelsList() {
    return parallels_;
  }
  /**
   * <code>repeated .metapb.Execution parallels = 2;</code>
   */
  public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.ExecutionOrBuilder> 
      getParallelsOrBuilderList() {
    return parallels_;
  }
  /**
   * <code>repeated .metapb.Execution parallels = 2;</code>
   */
  public int getParallelsCount() {
    return parallels_.size();
  }
  /**
   * <code>repeated .metapb.Execution parallels = 2;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.Execution getParallels(int index) {
    return parallels_.get(index);
  }
  /**
   * <code>repeated .metapb.Execution parallels = 2;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.ExecutionOrBuilder getParallelsOrBuilder(
      int index) {
    return parallels_.get(index);
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
    if (!getNextStepBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, nextStep_);
    }
    for (int i = 0; i < parallels_.size(); i++) {
      output.writeMessage(2, parallels_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNextStepBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, nextStep_);
    }
    for (int i = 0; i < parallels_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, parallels_.get(i));
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution other = (cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution) obj;

    boolean result = true;
    result = result && getNextStep()
        .equals(other.getNextStep());
    result = result && getParallelsList()
        .equals(other.getParallelsList());
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
    hash = (37 * hash) + NEXTSTEP_FIELD_NUMBER;
    hash = (53 * hash) + getNextStep().hashCode();
    if (getParallelsCount() > 0) {
      hash = (37 * hash) + PARALLELS_FIELD_NUMBER;
      hash = (53 * hash) + getParallelsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution prototype) {
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
   * ParallelExecution is a parallel execution
   * </pre>
   *
   * Protobuf type {@code metapb.ParallelExecution}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:metapb.ParallelExecution)
      cn.infinivision.dataforce.busybee.pb.meta.ParallelExecutionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_ParallelExecution_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_ParallelExecution_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution.class, cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution.newBuilder()
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
        getParallelsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      nextStep_ = "";

      if (parallelsBuilder_ == null) {
        parallels_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        parallelsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_ParallelExecution_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution build() {
      cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution buildPartial() {
      cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution result = new cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.nextStep_ = nextStep_;
      if (parallelsBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          parallels_ = java.util.Collections.unmodifiableList(parallels_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.parallels_ = parallels_;
      } else {
        result.parallels_ = parallelsBuilder_.build();
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution other) {
      if (other == cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution.getDefaultInstance()) return this;
      if (!other.getNextStep().isEmpty()) {
        nextStep_ = other.nextStep_;
        onChanged();
      }
      if (parallelsBuilder_ == null) {
        if (!other.parallels_.isEmpty()) {
          if (parallels_.isEmpty()) {
            parallels_ = other.parallels_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureParallelsIsMutable();
            parallels_.addAll(other.parallels_);
          }
          onChanged();
        }
      } else {
        if (!other.parallels_.isEmpty()) {
          if (parallelsBuilder_.isEmpty()) {
            parallelsBuilder_.dispose();
            parallelsBuilder_ = null;
            parallels_ = other.parallels_;
            bitField0_ = (bitField0_ & ~0x00000002);
            parallelsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getParallelsFieldBuilder() : null;
          } else {
            parallelsBuilder_.addAllMessages(other.parallels_);
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
      cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object nextStep_ = "";
    /**
     * <code>string nextStep = 1;</code>
     */
    public java.lang.String getNextStep() {
      java.lang.Object ref = nextStep_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nextStep_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string nextStep = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNextStepBytes() {
      java.lang.Object ref = nextStep_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nextStep_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string nextStep = 1;</code>
     */
    public Builder setNextStep(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nextStep_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string nextStep = 1;</code>
     */
    public Builder clearNextStep() {
      
      nextStep_ = getDefaultInstance().getNextStep();
      onChanged();
      return this;
    }
    /**
     * <code>string nextStep = 1;</code>
     */
    public Builder setNextStepBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nextStep_ = value;
      onChanged();
      return this;
    }

    private java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Execution> parallels_ =
      java.util.Collections.emptyList();
    private void ensureParallelsIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        parallels_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.meta.Execution>(parallels_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.Execution, cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder, cn.infinivision.dataforce.busybee.pb.meta.ExecutionOrBuilder> parallelsBuilder_;

    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Execution> getParallelsList() {
      if (parallelsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(parallels_);
      } else {
        return parallelsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public int getParallelsCount() {
      if (parallelsBuilder_ == null) {
        return parallels_.size();
      } else {
        return parallelsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Execution getParallels(int index) {
      if (parallelsBuilder_ == null) {
        return parallels_.get(index);
      } else {
        return parallelsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public Builder setParallels(
        int index, cn.infinivision.dataforce.busybee.pb.meta.Execution value) {
      if (parallelsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureParallelsIsMutable();
        parallels_.set(index, value);
        onChanged();
      } else {
        parallelsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public Builder setParallels(
        int index, cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder builderForValue) {
      if (parallelsBuilder_ == null) {
        ensureParallelsIsMutable();
        parallels_.set(index, builderForValue.build());
        onChanged();
      } else {
        parallelsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public Builder addParallels(cn.infinivision.dataforce.busybee.pb.meta.Execution value) {
      if (parallelsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureParallelsIsMutable();
        parallels_.add(value);
        onChanged();
      } else {
        parallelsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public Builder addParallels(
        int index, cn.infinivision.dataforce.busybee.pb.meta.Execution value) {
      if (parallelsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureParallelsIsMutable();
        parallels_.add(index, value);
        onChanged();
      } else {
        parallelsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public Builder addParallels(
        cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder builderForValue) {
      if (parallelsBuilder_ == null) {
        ensureParallelsIsMutable();
        parallels_.add(builderForValue.build());
        onChanged();
      } else {
        parallelsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public Builder addParallels(
        int index, cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder builderForValue) {
      if (parallelsBuilder_ == null) {
        ensureParallelsIsMutable();
        parallels_.add(index, builderForValue.build());
        onChanged();
      } else {
        parallelsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public Builder addAllParallels(
        java.lang.Iterable<? extends cn.infinivision.dataforce.busybee.pb.meta.Execution> values) {
      if (parallelsBuilder_ == null) {
        ensureParallelsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, parallels_);
        onChanged();
      } else {
        parallelsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public Builder clearParallels() {
      if (parallelsBuilder_ == null) {
        parallels_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        parallelsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public Builder removeParallels(int index) {
      if (parallelsBuilder_ == null) {
        ensureParallelsIsMutable();
        parallels_.remove(index);
        onChanged();
      } else {
        parallelsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder getParallelsBuilder(
        int index) {
      return getParallelsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.ExecutionOrBuilder getParallelsOrBuilder(
        int index) {
      if (parallelsBuilder_ == null) {
        return parallels_.get(index);  } else {
        return parallelsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.ExecutionOrBuilder> 
         getParallelsOrBuilderList() {
      if (parallelsBuilder_ != null) {
        return parallelsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(parallels_);
      }
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder addParallelsBuilder() {
      return getParallelsFieldBuilder().addBuilder(
          cn.infinivision.dataforce.busybee.pb.meta.Execution.getDefaultInstance());
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder addParallelsBuilder(
        int index) {
      return getParallelsFieldBuilder().addBuilder(
          index, cn.infinivision.dataforce.busybee.pb.meta.Execution.getDefaultInstance());
    }
    /**
     * <code>repeated .metapb.Execution parallels = 2;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder> 
         getParallelsBuilderList() {
      return getParallelsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.Execution, cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder, cn.infinivision.dataforce.busybee.pb.meta.ExecutionOrBuilder> 
        getParallelsFieldBuilder() {
      if (parallelsBuilder_ == null) {
        parallelsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.meta.Execution, cn.infinivision.dataforce.busybee.pb.meta.Execution.Builder, cn.infinivision.dataforce.busybee.pb.meta.ExecutionOrBuilder>(
                parallels_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        parallels_ = null;
      }
      return parallelsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:metapb.ParallelExecution)
  }

  // @@protoc_insertion_point(class_scope:metapb.ParallelExecution)
  private static final cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution();
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ParallelExecution>
      PARSER = new com.google.protobuf.AbstractParser<ParallelExecution>() {
    public ParallelExecution parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ParallelExecution(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ParallelExecution> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ParallelExecution> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.meta.ParallelExecution getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

