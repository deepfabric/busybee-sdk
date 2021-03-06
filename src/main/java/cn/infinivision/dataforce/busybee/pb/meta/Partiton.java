// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * Partiton partition state
 * </pre>
 *
 * Protobuf type {@code metapb.Partiton}
 */
public  final class Partiton extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:metapb.Partiton)
    PartitonOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Partiton.newBuilder() to construct.
  private Partiton(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Partiton() {
    consumer_ = 0;
    version_ = 0L;
    lastFetchTS_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Partiton(
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

            consumer_ = input.readUInt32();
            break;
          }
          case 16: {

            version_ = input.readUInt64();
            break;
          }
          case 24: {

            lastFetchTS_ = input.readInt64();
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
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Partiton_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Partiton_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.infinivision.dataforce.busybee.pb.meta.Partiton.class, cn.infinivision.dataforce.busybee.pb.meta.Partiton.Builder.class);
  }

  public static final int CONSUMER_FIELD_NUMBER = 1;
  private int consumer_;
  /**
   * <code>uint32 consumer = 1;</code>
   */
  public int getConsumer() {
    return consumer_;
  }

  public static final int VERSION_FIELD_NUMBER = 2;
  private long version_;
  /**
   * <code>uint64 version = 2;</code>
   */
  public long getVersion() {
    return version_;
  }

  public static final int LASTFETCHTS_FIELD_NUMBER = 3;
  private long lastFetchTS_;
  /**
   * <code>int64 lastFetchTS = 3;</code>
   */
  public long getLastFetchTS() {
    return lastFetchTS_;
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
    if (consumer_ != 0) {
      output.writeUInt32(1, consumer_);
    }
    if (version_ != 0L) {
      output.writeUInt64(2, version_);
    }
    if (lastFetchTS_ != 0L) {
      output.writeInt64(3, lastFetchTS_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (consumer_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, consumer_);
    }
    if (version_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, version_);
    }
    if (lastFetchTS_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, lastFetchTS_);
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
    if (!(obj instanceof cn.infinivision.dataforce.busybee.pb.meta.Partiton)) {
      return super.equals(obj);
    }
    cn.infinivision.dataforce.busybee.pb.meta.Partiton other = (cn.infinivision.dataforce.busybee.pb.meta.Partiton) obj;

    boolean result = true;
    result = result && (getConsumer()
        == other.getConsumer());
    result = result && (getVersion()
        == other.getVersion());
    result = result && (getLastFetchTS()
        == other.getLastFetchTS());
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
    hash = (37 * hash) + CONSUMER_FIELD_NUMBER;
    hash = (53 * hash) + getConsumer();
    hash = (37 * hash) + VERSION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getVersion());
    hash = (37 * hash) + LASTFETCHTS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLastFetchTS());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton parseFrom(
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
  public static Builder newBuilder(cn.infinivision.dataforce.busybee.pb.meta.Partiton prototype) {
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
   * Partiton partition state
   * </pre>
   *
   * Protobuf type {@code metapb.Partiton}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:metapb.Partiton)
      cn.infinivision.dataforce.busybee.pb.meta.PartitonOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Partiton_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Partiton_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.infinivision.dataforce.busybee.pb.meta.Partiton.class, cn.infinivision.dataforce.busybee.pb.meta.Partiton.Builder.class);
    }

    // Construct using cn.infinivision.dataforce.busybee.pb.meta.Partiton.newBuilder()
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
      consumer_ = 0;

      version_ = 0L;

      lastFetchTS_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.PB.internal_static_metapb_Partiton_descriptor;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Partiton getDefaultInstanceForType() {
      return cn.infinivision.dataforce.busybee.pb.meta.Partiton.getDefaultInstance();
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Partiton build() {
      cn.infinivision.dataforce.busybee.pb.meta.Partiton result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.infinivision.dataforce.busybee.pb.meta.Partiton buildPartial() {
      cn.infinivision.dataforce.busybee.pb.meta.Partiton result = new cn.infinivision.dataforce.busybee.pb.meta.Partiton(this);
      result.consumer_ = consumer_;
      result.version_ = version_;
      result.lastFetchTS_ = lastFetchTS_;
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
      if (other instanceof cn.infinivision.dataforce.busybee.pb.meta.Partiton) {
        return mergeFrom((cn.infinivision.dataforce.busybee.pb.meta.Partiton)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.infinivision.dataforce.busybee.pb.meta.Partiton other) {
      if (other == cn.infinivision.dataforce.busybee.pb.meta.Partiton.getDefaultInstance()) return this;
      if (other.getConsumer() != 0) {
        setConsumer(other.getConsumer());
      }
      if (other.getVersion() != 0L) {
        setVersion(other.getVersion());
      }
      if (other.getLastFetchTS() != 0L) {
        setLastFetchTS(other.getLastFetchTS());
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
      cn.infinivision.dataforce.busybee.pb.meta.Partiton parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.infinivision.dataforce.busybee.pb.meta.Partiton) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int consumer_ ;
    /**
     * <code>uint32 consumer = 1;</code>
     */
    public int getConsumer() {
      return consumer_;
    }
    /**
     * <code>uint32 consumer = 1;</code>
     */
    public Builder setConsumer(int value) {
      
      consumer_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 consumer = 1;</code>
     */
    public Builder clearConsumer() {
      
      consumer_ = 0;
      onChanged();
      return this;
    }

    private long version_ ;
    /**
     * <code>uint64 version = 2;</code>
     */
    public long getVersion() {
      return version_;
    }
    /**
     * <code>uint64 version = 2;</code>
     */
    public Builder setVersion(long value) {
      
      version_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 version = 2;</code>
     */
    public Builder clearVersion() {
      
      version_ = 0L;
      onChanged();
      return this;
    }

    private long lastFetchTS_ ;
    /**
     * <code>int64 lastFetchTS = 3;</code>
     */
    public long getLastFetchTS() {
      return lastFetchTS_;
    }
    /**
     * <code>int64 lastFetchTS = 3;</code>
     */
    public Builder setLastFetchTS(long value) {
      
      lastFetchTS_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 lastFetchTS = 3;</code>
     */
    public Builder clearLastFetchTS() {
      
      lastFetchTS_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:metapb.Partiton)
  }

  // @@protoc_insertion_point(class_scope:metapb.Partiton)
  private static final cn.infinivision.dataforce.busybee.pb.meta.Partiton DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.infinivision.dataforce.busybee.pb.meta.Partiton();
  }

  public static cn.infinivision.dataforce.busybee.pb.meta.Partiton getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Partiton>
      PARSER = new com.google.protobuf.AbstractParser<Partiton>() {
    public Partiton parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Partiton(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Partiton> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Partiton> getParserForType() {
    return PARSER;
  }

  public cn.infinivision.dataforce.busybee.pb.meta.Partiton getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

