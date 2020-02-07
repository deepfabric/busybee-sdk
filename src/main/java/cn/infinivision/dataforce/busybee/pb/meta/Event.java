// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * Event is process definition
 * </pre>
 *
 * Protobuf type {@code metapb.Event}
 */
public  final class Event extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:metapb.Event)
    EventOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Event.newBuilder() to construct.
  private Event(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Event() {
    userID_ = 0L;
    tenantID_ = 0L;
    workflowID_ = 0L;
    data_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Event(
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

            userID_ = input.readUInt64();
            break;
          }
          case 16: {

            tenantID_ = input.readUInt64();
            break;
          }
          case 24: {

            workflowID_ = input.readUInt64();
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              data_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.meta.KV>();
              mutable_bitField0_ |= 0x00000008;
            }
            data_.add(
                input.readMessage(cn.infinivision.dataforce.busybee.pb.meta.KV.parser(), extensionRegistry));
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
        data_ = java.util.Collections.unmodifiableList(data_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Event_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Event_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.meta.Event.class, cn.infinivision.dataforce.busybee.pb.meta.Event.Builder.class);
  }

  private int bitField0_;
  public static final int USERID_FIELD_NUMBER = 1;
  private long userID_;
  /**
   * <code>uint64 userID = 1;</code>
   */
  public long getUserID() {
    return userID_;
  }

  public static final int TENANTID_FIELD_NUMBER = 2;
  private long tenantID_;
  /**
   * <code>uint64 tenantID = 2;</code>
   */
  public long getTenantID() {
    return tenantID_;
  }

  public static final int WORKFLOWID_FIELD_NUMBER = 3;
  private long workflowID_;
  /**
   * <code>uint64 workflowID = 3;</code>
   */
  public long getWorkflowID() {
    return workflowID_;
  }

  public static final int DATA_FIELD_NUMBER = 4;
  private java.util.List<cn.infinivision.dataforce.busybee.pb.meta.KV> data_;
  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.KV> getDataList() {
    return data_;
  }
  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.KVOrBuilder> 
      getDataOrBuilderList() {
    return data_;
  }
  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  public int getDataCount() {
    return data_.size();
  }
  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.KV getData(int index) {
    return data_.get(index);
  }
  /**
   * <code>repeated .metapb.KV data = 4;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.KVOrBuilder getDataOrBuilder(
      int index) {
    return data_.get(index);
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
    if (userID_ != 0L) {
      output.writeUInt64(1, userID_);
    }
    if (tenantID_ != 0L) {
      output.writeUInt64(2, tenantID_);
    }
    if (workflowID_ != 0L) {
      output.writeUInt64(3, workflowID_);
    }
    for (int i = 0; i < data_.size(); i++) {
      output.writeMessage(4, data_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userID_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(1, userID_);
    }
    if (tenantID_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, tenantID_);
    }
    if (workflowID_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(3, workflowID_);
    }
    for (int i = 0; i < data_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, data_.get(i));
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.meta.Event)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.meta.Event other = (cn.infinivision.dataforce.busybee.pb.meta.Event) obj;

    boolean result = true;
    result = result && (getUserID()
        == other.getUserID());
    result = result && (getTenantID()
        == other.getTenantID());
    result = result && (getWorkflowID()
        == other.getWorkflowID());
    result = result && getDataList()
        .equals(other.getDataList());
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
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserID());
    hash = (37 * hash) + TENANTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTenantID());
    hash = (37 * hash) + WORKFLOWID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getWorkflowID());
    if (getDataCount() > 0) {
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getDataList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Event parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.meta.Event prototype) {
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
   * Event is process definition
   * </pre>
   *
   * Protobuf type {@code metapb.Event}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:metapb.Event)
      cn.infinivision.dataforce.busybee.pb.meta.EventOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Event_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Event_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.meta.Event.class, cn.infinivision.dataforce.busybee.pb.meta.Event.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.meta.Event.newBuilder()
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
        getDataFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      userID_ = 0L;

      tenantID_ = 0L;

      workflowID_ = 0L;

      if (dataBuilder_ == null) {
        data_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
      } else {
        dataBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Event_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Event getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.Event.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Event build() {
      cn.infinivision.dataforce.busybee.pb.meta.Event result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Event buildPartial() {
      cn.infinivision.dataforce.busybee.pb.meta.Event result = new cn.infinivision.dataforce.busybee.pb.meta.Event(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.userID_ = userID_;
      result.tenantID_ = tenantID_;
      result.workflowID_ = workflowID_;
      if (dataBuilder_ == null) {
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          data_ = java.util.Collections.unmodifiableList(data_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.data_ = data_;
      } else {
        result.data_ = dataBuilder_.build();
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.meta.Event) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.meta.Event)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.Event other) {
      if (other == cn.infinivision.dataforce.busybee.pb.meta.Event.getDefaultInstance()) return this;
      if (other.getUserID() != 0L) {
        setUserID(other.getUserID());
      }
      if (other.getTenantID() != 0L) {
        setTenantID(other.getTenantID());
      }
      if (other.getWorkflowID() != 0L) {
        setWorkflowID(other.getWorkflowID());
      }
      if (dataBuilder_ == null) {
        if (!other.data_.isEmpty()) {
          if (data_.isEmpty()) {
            data_ = other.data_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureDataIsMutable();
            data_.addAll(other.data_);
          }
          onChanged();
        }
      } else {
        if (!other.data_.isEmpty()) {
          if (dataBuilder_.isEmpty()) {
            dataBuilder_.dispose();
            dataBuilder_ = null;
            data_ = other.data_;
            bitField0_ = (bitField0_ & ~0x00000008);
            dataBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getDataFieldBuilder() : null;
          } else {
            dataBuilder_.addAllMessages(other.data_);
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
      cn.infinivision.dataforce.busybee.pb.meta.Event parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.meta.Event) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long userID_ ;
    /**
     * <code>uint64 userID = 1;</code>
     */
    public long getUserID() {
      return userID_;
    }
    /**
     * <code>uint64 userID = 1;</code>
     */
    public Builder setUserID(long value) {
      
      userID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 userID = 1;</code>
     */
    public Builder clearUserID() {
      
      userID_ = 0L;
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

    private long workflowID_ ;
    /**
     * <code>uint64 workflowID = 3;</code>
     */
    public long getWorkflowID() {
      return workflowID_;
    }
    /**
     * <code>uint64 workflowID = 3;</code>
     */
    public Builder setWorkflowID(long value) {
      
      workflowID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 workflowID = 3;</code>
     */
    public Builder clearWorkflowID() {
      
      workflowID_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<cn.infinivision.dataforce.busybee.pb.meta.KV> data_ =
      java.util.Collections.emptyList();
    private void ensureDataIsMutable() {
      if (!((bitField0_ & 0x00000008) == 0x00000008)) {
        data_ = new java.util.ArrayList<cn.infinivision.dataforce.busybee.pb.meta.KV>(data_);
        bitField0_ |= 0x00000008;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.KV, cn.infinivision.dataforce.busybee.pb.meta.KV.Builder, cn.infinivision.dataforce.busybee.pb.meta.KVOrBuilder> dataBuilder_;

    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.KV> getDataList() {
      if (dataBuilder_ == null) {
        return java.util.Collections.unmodifiableList(data_);
      } else {
        return dataBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public int getDataCount() {
      if (dataBuilder_ == null) {
        return data_.size();
      } else {
        return dataBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.KV getData(int index) {
      if (dataBuilder_ == null) {
        return data_.get(index);
      } else {
        return dataBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public Builder setData(
        int index, cn.infinivision.dataforce.busybee.pb.meta.KV value) {
      if (dataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDataIsMutable();
        data_.set(index, value);
        onChanged();
      } else {
        dataBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public Builder setData(
        int index, cn.infinivision.dataforce.busybee.pb.meta.KV.Builder builderForValue) {
      if (dataBuilder_ == null) {
        ensureDataIsMutable();
        data_.set(index, builderForValue.build());
        onChanged();
      } else {
        dataBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public Builder addData(cn.infinivision.dataforce.busybee.pb.meta.KV value) {
      if (dataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDataIsMutable();
        data_.add(value);
        onChanged();
      } else {
        dataBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public Builder addData(
        int index, cn.infinivision.dataforce.busybee.pb.meta.KV value) {
      if (dataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDataIsMutable();
        data_.add(index, value);
        onChanged();
      } else {
        dataBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public Builder addData(
        cn.infinivision.dataforce.busybee.pb.meta.KV.Builder builderForValue) {
      if (dataBuilder_ == null) {
        ensureDataIsMutable();
        data_.add(builderForValue.build());
        onChanged();
      } else {
        dataBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public Builder addData(
        int index, cn.infinivision.dataforce.busybee.pb.meta.KV.Builder builderForValue) {
      if (dataBuilder_ == null) {
        ensureDataIsMutable();
        data_.add(index, builderForValue.build());
        onChanged();
      } else {
        dataBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public Builder addAllData(
        java.lang.Iterable<? extends cn.infinivision.dataforce.busybee.pb.meta.KV> values) {
      if (dataBuilder_ == null) {
        ensureDataIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, data_);
        onChanged();
      } else {
        dataBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public Builder clearData() {
      if (dataBuilder_ == null) {
        data_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
      } else {
        dataBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public Builder removeData(int index) {
      if (dataBuilder_ == null) {
        ensureDataIsMutable();
        data_.remove(index);
        onChanged();
      } else {
        dataBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.KV.Builder getDataBuilder(
        int index) {
      return getDataFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.KVOrBuilder getDataOrBuilder(
        int index) {
      if (dataBuilder_ == null) {
        return data_.get(index);  } else {
        return dataBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public java.util.List<? extends cn.infinivision.dataforce.busybee.pb.meta.KVOrBuilder> 
         getDataOrBuilderList() {
      if (dataBuilder_ != null) {
        return dataBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(data_);
      }
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.KV.Builder addDataBuilder() {
      return getDataFieldBuilder().addBuilder(
          cn.infinivision.dataforce.busybee.pb.meta.KV.getDefaultInstance());
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.KV.Builder addDataBuilder(
        int index) {
      return getDataFieldBuilder().addBuilder(
          index, cn.infinivision.dataforce.busybee.pb.meta.KV.getDefaultInstance());
    }
    /**
     * <code>repeated .metapb.KV data = 4;</code>
     */
    public java.util.List<cn.infinivision.dataforce.busybee.pb.meta.KV.Builder> 
         getDataBuilderList() {
      return getDataFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.KV, cn.infinivision.dataforce.busybee.pb.meta.KV.Builder, cn.infinivision.dataforce.busybee.pb.meta.KVOrBuilder> 
        getDataFieldBuilder() {
      if (dataBuilder_ == null) {
        dataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.meta.KV, cn.infinivision.dataforce.busybee.pb.meta.KV.Builder, cn.infinivision.dataforce.busybee.pb.meta.KVOrBuilder>(
                data_,
                ((bitField0_ & 0x00000008) == 0x00000008),
                getParentForChildren(),
                isClean());
        data_ = null;
      }
      return dataBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:metapb.Event)
  }

  // @@protoc_insertion_point(class_scope:metapb.Event)
  private static final cn.infinivision.dataforce.busybee.pb.meta.Event DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.meta.Event();
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Event getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Event>
      PARSER = new com.google.protobuf.AbstractParser<Event>() {
    public Event parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Event(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Event> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Event> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.meta.Event getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

