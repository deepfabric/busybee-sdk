// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

/**
 * <pre>
 * ConditionGroup condition groups
 * </pre>
 *
 * Protobuf type {@code rpcpb.ConditionGroup}
 */
public  final class ConditionGroup extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcpb.ConditionGroup)
    ConditionGroupOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ConditionGroup.newBuilder() to construct.
  private ConditionGroup(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ConditionGroup() {
    conditions_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ConditionGroup(
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
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              conditions_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.rpc.Condition>();
              mutable_bitField0_ |= 0x00000001;
            }
            conditions_.add(
                input.readMessage(cn.infinivision.dataforce.busybee.pb.rpc.Condition.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        conditions_ = java.util.Collections.unmodifiableList(conditions_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_ConditionGroup_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_ConditionGroup_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup.class, cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup.Builder.class);
  }

  public static final int CONDITIONS_FIELD_NUMBER = 1;
  private java.util.List<cn.infinivision.dataforce.busybee.pb.rpc.Condition> conditions_;
  /**
   * <code>repeated .rpcpb.Condition conditions = 1;</code>
   */
  public java.util.List<cn.infinivision.dataforce.busybee.pb.rpc.Condition> getConditionsList() {
    return conditions_;
  }
  /**
   * <code>repeated .rpcpb.Condition conditions = 1;</code>
   */
  public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.rpc.ConditionOrBuilder> 
      getConditionsOrBuilderList() {
    return conditions_;
  }
  /**
   * <code>repeated .rpcpb.Condition conditions = 1;</code>
   */
  public int getConditionsCount() {
    return conditions_.size();
  }
  /**
   * <code>repeated .rpcpb.Condition conditions = 1;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.rpc.Condition getConditions(int index) {
    return conditions_.get(index);
  }
  /**
   * <code>repeated .rpcpb.Condition conditions = 1;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.rpc.ConditionOrBuilder getConditionsOrBuilder(
      int index) {
    return conditions_.get(index);
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
    for (int i = 0; i < conditions_.size(); i++) {
      output.writeMessage(1, conditions_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < conditions_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, conditions_.get(i));
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup other = (cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup) obj;

    boolean result = true;
    result = result && getConditionsList()
        .equals(other.getConditionsList());
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
    if (getConditionsCount() > 0) {
      hash = (37 * hash) + CONDITIONS_FIELD_NUMBER;
      hash = (53 * hash) + getConditionsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup prototype) {
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
   * ConditionGroup condition groups
   * </pre>
   *
   * Protobuf type {@code rpcpb.ConditionGroup}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcpb.ConditionGroup)
      cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroupOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_ConditionGroup_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_ConditionGroup_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup.class, cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup.newBuilder()
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
        getConditionsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (conditionsBuilder_ == null) {
        conditions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        conditionsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.PB.internal_static_rpcpb_ConditionGroup_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup build() {
      cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup buildPartial() {
      cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup result = new cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup(this);
      int from_bitField0_ = bitField0_;
      if (conditionsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          conditions_ = java.util.Collections.unmodifiableList(conditions_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.conditions_ = conditions_;
      } else {
        result.conditions_ = conditionsBuilder_.build();
      }
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup other) {
      if (other == cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup.getDefaultInstance()) return this;
      if (conditionsBuilder_ == null) {
        if (!other.conditions_.isEmpty()) {
          if (conditions_.isEmpty()) {
            conditions_ = other.conditions_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureConditionsIsMutable();
            conditions_.addAll(other.conditions_);
          }
          onChanged();
        }
      } else {
        if (!other.conditions_.isEmpty()) {
          if (conditionsBuilder_.isEmpty()) {
            conditionsBuilder_.dispose();
            conditionsBuilder_ = null;
            conditions_ = other.conditions_;
            bitField0_ = (bitField0_ & ~0x00000001);
            conditionsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getConditionsFieldBuilder() : null;
          } else {
            conditionsBuilder_.addAllMessages(other.conditions_);
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
      cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<cn.infinivision.dataforce.busybee.pb.rpc.Condition> conditions_ =
      java.util.Collections.emptyList();
    private void ensureConditionsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        conditions_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.rpc.Condition>(conditions_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.rpc.Condition, cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder, cn.infinivision.dataforce.busybee.pb.rpc.ConditionOrBuilder> conditionsBuilder_;

    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.rpc.Condition> getConditionsList() {
      if (conditionsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(conditions_);
      } else {
        return conditionsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public int getConditionsCount() {
      if (conditionsBuilder_ == null) {
        return conditions_.size();
      } else {
        return conditionsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.rpc.Condition getConditions(int index) {
      if (conditionsBuilder_ == null) {
        return conditions_.get(index);
      } else {
        return conditionsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public Builder setConditions(
        int index, cn.infinivision.dataforce.busybee.pb.rpc.Condition value) {
      if (conditionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureConditionsIsMutable();
        conditions_.set(index, value);
        onChanged();
      } else {
        conditionsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public Builder setConditions(
        int index, cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder builderForValue) {
      if (conditionsBuilder_ == null) {
        ensureConditionsIsMutable();
        conditions_.set(index, builderForValue.build());
        onChanged();
      } else {
        conditionsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public Builder addConditions(cn.infinivision.dataforce.busybee.pb.rpc.Condition value) {
      if (conditionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureConditionsIsMutable();
        conditions_.add(value);
        onChanged();
      } else {
        conditionsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public Builder addConditions(
        int index, cn.infinivision.dataforce.busybee.pb.rpc.Condition value) {
      if (conditionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureConditionsIsMutable();
        conditions_.add(index, value);
        onChanged();
      } else {
        conditionsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public Builder addConditions(
        cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder builderForValue) {
      if (conditionsBuilder_ == null) {
        ensureConditionsIsMutable();
        conditions_.add(builderForValue.build());
        onChanged();
      } else {
        conditionsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public Builder addConditions(
        int index, cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder builderForValue) {
      if (conditionsBuilder_ == null) {
        ensureConditionsIsMutable();
        conditions_.add(index, builderForValue.build());
        onChanged();
      } else {
        conditionsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public Builder addAllConditions(
        java.lang.Iterable<? extends cn.infinivision.dataforce.busybee.pb.rpc.Condition> values) {
      if (conditionsBuilder_ == null) {
        ensureConditionsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, conditions_);
        onChanged();
      } else {
        conditionsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public Builder clearConditions() {
      if (conditionsBuilder_ == null) {
        conditions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        conditionsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public Builder removeConditions(int index) {
      if (conditionsBuilder_ == null) {
        ensureConditionsIsMutable();
        conditions_.remove(index);
        onChanged();
      } else {
        conditionsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder getConditionsBuilder(
        int index) {
      return getConditionsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.rpc.ConditionOrBuilder getConditionsOrBuilder(
        int index) {
      if (conditionsBuilder_ == null) {
        return conditions_.get(index);  } else {
        return conditionsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.rpc.ConditionOrBuilder> 
         getConditionsOrBuilderList() {
      if (conditionsBuilder_ != null) {
        return conditionsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(conditions_);
      }
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder addConditionsBuilder() {
      return getConditionsFieldBuilder().addBuilder(
          cn.infinivision.dataforce.busybee.pb.rpc.Condition.getDefaultInstance());
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder addConditionsBuilder(
        int index) {
      return getConditionsFieldBuilder().addBuilder(
          index, cn.infinivision.dataforce.busybee.pb.rpc.Condition.getDefaultInstance());
    }
    /**
     * <code>repeated .rpcpb.Condition conditions = 1;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder> 
         getConditionsBuilderList() {
      return getConditionsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.rpc.Condition, cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder, cn.infinivision.dataforce.busybee.pb.rpc.ConditionOrBuilder> 
        getConditionsFieldBuilder() {
      if (conditionsBuilder_ == null) {
        conditionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.rpc.Condition, cn.infinivision.dataforce.busybee.pb.rpc.Condition.Builder, cn.infinivision.dataforce.busybee.pb.rpc.ConditionOrBuilder>(
                conditions_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        conditions_ = null;
      }
      return conditionsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:rpcpb.ConditionGroup)
  }

  // @@protoc_insertion_point(class_scope:rpcpb.ConditionGroup)
  private static final cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup();
  }

  public static cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ConditionGroup>
      PARSER = new com.google.protobuf.AbstractParser<ConditionGroup>() {
    public ConditionGroup parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ConditionGroup(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ConditionGroup> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ConditionGroup> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.rpc.ConditionGroup getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

