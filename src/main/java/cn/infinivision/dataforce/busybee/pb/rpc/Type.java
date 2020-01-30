// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

/**
 * Protobuf enum {@code rpcpb.Type}
 */
public enum Type
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>Set = 0;</code>
   */
  Set(0),
  /**
   * <code>Get = 1;</code>
   */
  Get(1),
  /**
   * <code>Delete = 2;</code>
   */
  Delete(2),
  /**
   * <code>BMCreate = 100;</code>
   */
  BMCreate(100),
  /**
   * <code>BMAdd = 101;</code>
   */
  BMAdd(101),
  /**
   * <code>BMRemove = 102;</code>
   */
  BMRemove(102),
  /**
   * <code>BMClear = 103;</code>
   */
  BMClear(103),
  /**
   * <code>BMContains = 104;</code>
   */
  BMContains(104),
  /**
   * <code>BMCount = 105;</code>
   */
  BMCount(105),
  /**
   * <code>BMRange = 106;</code>
   */
  BMRange(106),
  /**
   * <code>StartingInstance = 200;</code>
   */
  StartingInstance(200),
  /**
   * <code>StartedInstance = 201;</code>
   */
  StartedInstance(201),
  /**
   * <code>StopInstance = 202;</code>
   */
  StopInstance(202),
  /**
   * <code>CreateInstanceStateShard = 203;</code>
   */
  CreateInstanceStateShard(203),
  /**
   * <code>UpdateInstanceStateShard = 204;</code>
   */
  UpdateInstanceStateShard(204),
  /**
   * <code>RemoveInstanceStateShard = 205;</code>
   */
  RemoveInstanceStateShard(205),
  /**
   * <code>InstanceCountState = 206;</code>
   */
  InstanceCountState(206),
  /**
   * <code>InstanceCrowdState = 207;</code>
   */
  InstanceCrowdState(207),
  /**
   * <code>QueueAdd = 300;</code>
   */
  QueueAdd(300),
  /**
   * <code>QueueFetch = 301;</code>
   */
  QueueFetch(301),
  /**
   * <code>TenantInit = 400;</code>
   */
  TenantInit(400),
  /**
   * <code>UpdateMapping = 401;</code>
   */
  UpdateMapping(401),
  /**
   * <code>GetMapping = 402;</code>
   */
  GetMapping(402),
  /**
   * <code>UpdateProfile = 403;</code>
   */
  UpdateProfile(403),
  /**
   * <code>GetProfile = 404;</code>
   */
  GetProfile(404),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>Set = 0;</code>
   */
  public static final int Set_VALUE = 0;
  /**
   * <code>Get = 1;</code>
   */
  public static final int Get_VALUE = 1;
  /**
   * <code>Delete = 2;</code>
   */
  public static final int Delete_VALUE = 2;
  /**
   * <code>BMCreate = 100;</code>
   */
  public static final int BMCreate_VALUE = 100;
  /**
   * <code>BMAdd = 101;</code>
   */
  public static final int BMAdd_VALUE = 101;
  /**
   * <code>BMRemove = 102;</code>
   */
  public static final int BMRemove_VALUE = 102;
  /**
   * <code>BMClear = 103;</code>
   */
  public static final int BMClear_VALUE = 103;
  /**
   * <code>BMContains = 104;</code>
   */
  public static final int BMContains_VALUE = 104;
  /**
   * <code>BMCount = 105;</code>
   */
  public static final int BMCount_VALUE = 105;
  /**
   * <code>BMRange = 106;</code>
   */
  public static final int BMRange_VALUE = 106;
  /**
   * <code>StartingInstance = 200;</code>
   */
  public static final int StartingInstance_VALUE = 200;
  /**
   * <code>StartedInstance = 201;</code>
   */
  public static final int StartedInstance_VALUE = 201;
  /**
   * <code>StopInstance = 202;</code>
   */
  public static final int StopInstance_VALUE = 202;
  /**
   * <code>CreateInstanceStateShard = 203;</code>
   */
  public static final int CreateInstanceStateShard_VALUE = 203;
  /**
   * <code>UpdateInstanceStateShard = 204;</code>
   */
  public static final int UpdateInstanceStateShard_VALUE = 204;
  /**
   * <code>RemoveInstanceStateShard = 205;</code>
   */
  public static final int RemoveInstanceStateShard_VALUE = 205;
  /**
   * <code>InstanceCountState = 206;</code>
   */
  public static final int InstanceCountState_VALUE = 206;
  /**
   * <code>InstanceCrowdState = 207;</code>
   */
  public static final int InstanceCrowdState_VALUE = 207;
  /**
   * <code>QueueAdd = 300;</code>
   */
  public static final int QueueAdd_VALUE = 300;
  /**
   * <code>QueueFetch = 301;</code>
   */
  public static final int QueueFetch_VALUE = 301;
  /**
   * <code>TenantInit = 400;</code>
   */
  public static final int TenantInit_VALUE = 400;
  /**
   * <code>UpdateMapping = 401;</code>
   */
  public static final int UpdateMapping_VALUE = 401;
  /**
   * <code>GetMapping = 402;</code>
   */
  public static final int GetMapping_VALUE = 402;
  /**
   * <code>UpdateProfile = 403;</code>
   */
  public static final int UpdateProfile_VALUE = 403;
  /**
   * <code>GetProfile = 404;</code>
   */
  public static final int GetProfile_VALUE = 404;


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
  public static Type valueOf(int value) {
    return forNumber(value);
  }

  public static Type forNumber(int value) {
    switch (value) {
      case 0: return Set;
      case 1: return Get;
      case 2: return Delete;
      case 100: return BMCreate;
      case 101: return BMAdd;
      case 102: return BMRemove;
      case 103: return BMClear;
      case 104: return BMContains;
      case 105: return BMCount;
      case 106: return BMRange;
      case 200: return StartingInstance;
      case 201: return StartedInstance;
      case 202: return StopInstance;
      case 203: return CreateInstanceStateShard;
      case 204: return UpdateInstanceStateShard;
      case 205: return RemoveInstanceStateShard;
      case 206: return InstanceCountState;
      case 207: return InstanceCrowdState;
      case 300: return QueueAdd;
      case 301: return QueueFetch;
      case 400: return TenantInit;
      case 401: return UpdateMapping;
      case 402: return GetMapping;
      case 403: return UpdateProfile;
      case 404: return GetProfile;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Type>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Type> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Type>() {
          public Type findValueByNumber(int number) {
            return Type.forNumber(number);
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
    return cn.infinivision.dataforce.busybee.pb.rpc.PB.getDescriptor().getEnumTypes().get(0);
  }

  private static final Type[] VALUES = values();

  public static Type valueOf(
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

  private Type(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:rpcpb.Type)
}

