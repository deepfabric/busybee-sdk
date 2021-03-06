// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * Tenant tenant metadata
 * </pre>
 *
 * Protobuf type {@code metapb.Tenant}
 */
public  final class Tenant extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:metapb.Tenant)
    TenantOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Tenant.newBuilder() to construct.
  private Tenant(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Tenant() {
    id_ = 0L;
    runners_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Tenant(
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
            cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder subBuilder = null;
            if (input_ != null) {
              subBuilder = input_.toBuilder();
            }
            input_ = input.readMessage(cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(input_);
              input_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder subBuilder = null;
            if (output_ != null) {
              subBuilder = output_.toBuilder();
            }
            output_ = input.readMessage(cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(output_);
              output_ = subBuilder.buildPartial();
            }

            break;
          }
          case 32: {

            runners_ = input.readUInt64();
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
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Tenant_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Tenant_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.meta.Tenant.class, cn.infinivision.dataforce.busybee.pb.meta.Tenant.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>uint64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int INPUT_FIELD_NUMBER = 2;
  private cn.infinivision.dataforce.busybee.pb.meta.TenantQueue input_;
  /**
   * <code>.metapb.TenantQueue input = 2;</code>
   */
  public boolean hasInput() {
    return input_ != null;
  }
  /**
   * <code>.metapb.TenantQueue input = 2;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue getInput() {
    return input_ == null ? cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.getDefaultInstance() : input_;
  }
  /**
   * <code>.metapb.TenantQueue input = 2;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder getInputOrBuilder() {
    return getInput();
  }

  public static final int OUTPUT_FIELD_NUMBER = 3;
  private cn.infinivision.dataforce.busybee.pb.meta.TenantQueue output_;
  /**
   * <code>.metapb.TenantQueue output = 3;</code>
   */
  public boolean hasOutput() {
    return output_ != null;
  }
  /**
   * <code>.metapb.TenantQueue output = 3;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue getOutput() {
    return output_ == null ? cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.getDefaultInstance() : output_;
  }
  /**
   * <code>.metapb.TenantQueue output = 3;</code>
   */
  public cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder getOutputOrBuilder() {
    return getOutput();
  }

  public static final int RUNNERS_FIELD_NUMBER = 4;
  private long runners_;
  /**
   * <code>uint64 runners = 4;</code>
   */
  public long getRunners() {
    return runners_;
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
    if (input_ != null) {
      output.writeMessage(2, getInput());
    }
    if (output_ != null) {
      output.writeMessage(3, getOutput());
    }
    if (runners_ != 0L) {
      output.writeUInt64(4, runners_);
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
    if (input_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getInput());
    }
    if (output_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getOutput());
    }
    if (runners_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(4, runners_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.meta.Tenant)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.meta.Tenant other = (cn.infinivision.dataforce.busybee.pb.meta.Tenant) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && (hasInput() == other.hasInput());
    if (hasInput()) {
      result = result && getInput()
          .equals(other.getInput());
    }
    result = result && (hasOutput() == other.hasOutput());
    if (hasOutput()) {
      result = result && getOutput()
          .equals(other.getOutput());
    }
    result = result && (getRunners()
        == other.getRunners());
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
    if (hasInput()) {
      hash = (37 * hash) + INPUT_FIELD_NUMBER;
      hash = (53 * hash) + getInput().hashCode();
    }
    if (hasOutput()) {
      hash = (37 * hash) + OUTPUT_FIELD_NUMBER;
      hash = (53 * hash) + getOutput().hashCode();
    }
    hash = (37 * hash) + RUNNERS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getRunners());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.meta.Tenant prototype) {
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
   * Tenant tenant metadata
   * </pre>
   *
   * Protobuf type {@code metapb.Tenant}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:metapb.Tenant)
      cn.infinivision.dataforce.busybee.pb.meta.TenantOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Tenant_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Tenant_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.meta.Tenant.class, cn.infinivision.dataforce.busybee.pb.meta.Tenant.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.meta.Tenant.newBuilder()
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

      if (inputBuilder_ == null) {
        input_ = null;
      } else {
        input_ = null;
        inputBuilder_ = null;
      }
      if (outputBuilder_ == null) {
        output_ = null;
      } else {
        output_ = null;
        outputBuilder_ = null;
      }
      runners_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Tenant_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Tenant getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.Tenant.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Tenant build() {
      cn.infinivision.dataforce.busybee.pb.meta.Tenant result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Tenant buildPartial() {
      cn.infinivision.dataforce.busybee.pb.meta.Tenant result = new cn.infinivision.dataforce.busybee.pb.meta.Tenant(this);
      result.id_ = id_;
      if (inputBuilder_ == null) {
        result.input_ = input_;
      } else {
        result.input_ = inputBuilder_.build();
      }
      if (outputBuilder_ == null) {
        result.output_ = output_;
      } else {
        result.output_ = outputBuilder_.build();
      }
      result.runners_ = runners_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.meta.Tenant) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.meta.Tenant)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.Tenant other) {
      if (other == cn.infinivision.dataforce.busybee.pb.meta.Tenant.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.hasInput()) {
        mergeInput(other.getInput());
      }
      if (other.hasOutput()) {
        mergeOutput(other.getOutput());
      }
      if (other.getRunners() != 0L) {
        setRunners(other.getRunners());
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
      cn.infinivision.dataforce.busybee.pb.meta.Tenant parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.meta.Tenant) e.getUnfinishedMessage();
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

    private cn.infinivision.dataforce.busybee.pb.meta.TenantQueue input_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.TenantQueue, cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder, cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder> inputBuilder_;
    /**
     * <code>.metapb.TenantQueue input = 2;</code>
     */
    public boolean hasInput() {
      return inputBuilder_ != null || input_ != null;
    }
    /**
     * <code>.metapb.TenantQueue input = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue getInput() {
      if (inputBuilder_ == null) {
        return input_ == null ? cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.getDefaultInstance() : input_;
      } else {
        return inputBuilder_.getMessage();
      }
    }
    /**
     * <code>.metapb.TenantQueue input = 2;</code>
     */
    public Builder setInput(cn.infinivision.dataforce.busybee.pb.meta.TenantQueue value) {
      if (inputBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        input_ = value;
        onChanged();
      } else {
        inputBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.metapb.TenantQueue input = 2;</code>
     */
    public Builder setInput(
        cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder builderForValue) {
      if (inputBuilder_ == null) {
        input_ = builderForValue.build();
        onChanged();
      } else {
        inputBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.metapb.TenantQueue input = 2;</code>
     */
    public Builder mergeInput(cn.infinivision.dataforce.busybee.pb.meta.TenantQueue value) {
      if (inputBuilder_ == null) {
        if (input_ != null) {
          input_ =
            cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.newBuilder(input_).mergeFrom(value).buildPartial();
        } else {
          input_ = value;
        }
        onChanged();
      } else {
        inputBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.metapb.TenantQueue input = 2;</code>
     */
    public Builder clearInput() {
      if (inputBuilder_ == null) {
        input_ = null;
        onChanged();
      } else {
        input_ = null;
        inputBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.metapb.TenantQueue input = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder getInputBuilder() {
      
      onChanged();
      return getInputFieldBuilder().getBuilder();
    }
    /**
     * <code>.metapb.TenantQueue input = 2;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder getInputOrBuilder() {
      if (inputBuilder_ != null) {
        return inputBuilder_.getMessageOrBuilder();
      } else {
        return input_ == null ?
            cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.getDefaultInstance() : input_;
      }
    }
    /**
     * <code>.metapb.TenantQueue input = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.TenantQueue, cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder, cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder> 
        getInputFieldBuilder() {
      if (inputBuilder_ == null) {
        inputBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.meta.TenantQueue, cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder, cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder>(
                getInput(),
                getParentForChildren(),
                isClean());
        input_ = null;
      }
      return inputBuilder_;
    }

    private cn.infinivision.dataforce.busybee.pb.meta.TenantQueue output_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.TenantQueue, cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder, cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder> outputBuilder_;
    /**
     * <code>.metapb.TenantQueue output = 3;</code>
     */
    public boolean hasOutput() {
      return outputBuilder_ != null || output_ != null;
    }
    /**
     * <code>.metapb.TenantQueue output = 3;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue getOutput() {
      if (outputBuilder_ == null) {
        return output_ == null ? cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.getDefaultInstance() : output_;
      } else {
        return outputBuilder_.getMessage();
      }
    }
    /**
     * <code>.metapb.TenantQueue output = 3;</code>
     */
    public Builder setOutput(cn.infinivision.dataforce.busybee.pb.meta.TenantQueue value) {
      if (outputBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        output_ = value;
        onChanged();
      } else {
        outputBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.metapb.TenantQueue output = 3;</code>
     */
    public Builder setOutput(
        cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder builderForValue) {
      if (outputBuilder_ == null) {
        output_ = builderForValue.build();
        onChanged();
      } else {
        outputBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.metapb.TenantQueue output = 3;</code>
     */
    public Builder mergeOutput(cn.infinivision.dataforce.busybee.pb.meta.TenantQueue value) {
      if (outputBuilder_ == null) {
        if (output_ != null) {
          output_ =
            cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.newBuilder(output_).mergeFrom(value).buildPartial();
        } else {
          output_ = value;
        }
        onChanged();
      } else {
        outputBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.metapb.TenantQueue output = 3;</code>
     */
    public Builder clearOutput() {
      if (outputBuilder_ == null) {
        output_ = null;
        onChanged();
      } else {
        output_ = null;
        outputBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.metapb.TenantQueue output = 3;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder getOutputBuilder() {
      
      onChanged();
      return getOutputFieldBuilder().getBuilder();
    }
    /**
     * <code>.metapb.TenantQueue output = 3;</code>
     */
    public cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder getOutputOrBuilder() {
      if (outputBuilder_ != null) {
        return outputBuilder_.getMessageOrBuilder();
      } else {
        return output_ == null ?
            cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.getDefaultInstance() : output_;
      }
    }
    /**
     * <code>.metapb.TenantQueue output = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.infinivision.dataforce.busybee.pb.meta.TenantQueue, cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder, cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder> 
        getOutputFieldBuilder() {
      if (outputBuilder_ == null) {
        outputBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cn.infinivision.dataforce.busybee.pb.meta.TenantQueue, cn.infinivision.dataforce.busybee.pb.meta.TenantQueue.Builder, cn.infinivision.dataforce.busybee.pb.meta.TenantQueueOrBuilder>(
                getOutput(),
                getParentForChildren(),
                isClean());
        output_ = null;
      }
      return outputBuilder_;
    }

    private long runners_ ;
    /**
     * <code>uint64 runners = 4;</code>
     */
    public long getRunners() {
      return runners_;
    }
    /**
     * <code>uint64 runners = 4;</code>
     */
    public Builder setRunners(long value) {
      
      runners_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 runners = 4;</code>
     */
    public Builder clearRunners() {
      
      runners_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:metapb.Tenant)
  }

  // @@protoc_insertion_point(class_scope:metapb.Tenant)
  private static final cn.infinivision.dataforce.busybee.pb.meta.Tenant DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.meta.Tenant();
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Tenant getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Tenant>
      PARSER = new com.google.protobuf.AbstractParser<Tenant>() {
    public Tenant parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Tenant(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Tenant> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Tenant> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.meta.Tenant getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

