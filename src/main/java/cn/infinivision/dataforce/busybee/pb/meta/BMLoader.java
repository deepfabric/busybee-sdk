// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: meta.proto

package cn.infinivision.dataforce.busybee.pb.meta;

/**
 * <pre>
 * BMLoader bitmap loader type
 * </pre>
 *
 * Protobuf enum {@code metapb.BMLoader}
 */
public enum BMLoader
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>RawLoader = 0;</code>
   */
  RawLoader(0),
  /**
   * <code>KVLoader = 1;</code>
   */
  KVLoader(1),
  /**
   * <code>KVShardLoader = 2;</code>
   */
  KVShardLoader(2),
  /**
   * <code>ClickhouseLoader = 3;</code>
   */
  ClickhouseLoader(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>RawLoader = 0;</code>
   */
  public static final int RawLoader_VALUE = 0;
  /**
   * <code>KVLoader = 1;</code>
   */
  public static final int KVLoader_VALUE = 1;
  /**
   * <code>KVShardLoader = 2;</code>
   */
  public static final int KVShardLoader_VALUE = 2;
  /**
   * <code>ClickhouseLoader = 3;</code>
   */
  public static final int ClickhouseLoader_VALUE = 3;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static BMLoader valueOf(int value) {
    return forNumber(value);
  }

  public static BMLoader forNumber(int value) {
    switch (value) {
      case 0: return RawLoader;
      case 1: return KVLoader;
      case 2: return KVShardLoader;
      case 3: return ClickhouseLoader;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<BMLoader>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      BMLoader> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<BMLoader>() {
          public BMLoader findValueByNumber(int number) {
            return BMLoader.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return cn.infinivision.dataforce.busybee.pb.meta.PB.getDescriptor().getEnumTypes().get(0);
  }

  private static final BMLoader[] VALUES = values();

  public static BMLoader valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private BMLoader(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:metapb.BMLoader)
}

