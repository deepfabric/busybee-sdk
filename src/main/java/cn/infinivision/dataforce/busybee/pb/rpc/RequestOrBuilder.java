// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface RequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.Request)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   */
  long getId();

  /**
   * <code>.rpcpb.Type type = 2;</code>
   */
  int getTypeValue();
  /**
   * <code>.rpcpb.Type type = 2;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.Type getType();

  /**
   * <code>.rpcpb.SetRequest set = 3;</code>
   */
  boolean hasSet();
  /**
   * <code>.rpcpb.SetRequest set = 3;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.SetRequest getSet();
  /**
   * <code>.rpcpb.SetRequest set = 3;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.SetRequestOrBuilder getSetOrBuilder();

  /**
   * <code>.rpcpb.GetRequest get = 4;</code>
   */
  boolean hasGet();
  /**
   * <code>.rpcpb.GetRequest get = 4;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetRequest getGet();
  /**
   * <code>.rpcpb.GetRequest get = 4;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetRequestOrBuilder getGetOrBuilder();

  /**
   * <code>.rpcpb.DeleteRequest delete = 5;</code>
   */
  boolean hasDelete();
  /**
   * <code>.rpcpb.DeleteRequest delete = 5;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.DeleteRequest getDelete();
  /**
   * <code>.rpcpb.DeleteRequest delete = 5;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.DeleteRequestOrBuilder getDeleteOrBuilder();

  /**
   * <code>.rpcpb.BMCreateRequest bmCreate = 6;</code>
   */
  boolean hasBmCreate();
  /**
   * <code>.rpcpb.BMCreateRequest bmCreate = 6;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMCreateRequest getBmCreate();
  /**
   * <code>.rpcpb.BMCreateRequest bmCreate = 6;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMCreateRequestOrBuilder getBmCreateOrBuilder();

  /**
   * <code>.rpcpb.BMAddRequest bmAdd = 7;</code>
   */
  boolean hasBmAdd();
  /**
   * <code>.rpcpb.BMAddRequest bmAdd = 7;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest getBmAdd();
  /**
   * <code>.rpcpb.BMAddRequest bmAdd = 7;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequestOrBuilder getBmAddOrBuilder();

  /**
   * <code>.rpcpb.BMRemoveRequest bmRemove = 8;</code>
   */
  boolean hasBmRemove();
  /**
   * <code>.rpcpb.BMRemoveRequest bmRemove = 8;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMRemoveRequest getBmRemove();
  /**
   * <code>.rpcpb.BMRemoveRequest bmRemove = 8;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMRemoveRequestOrBuilder getBmRemoveOrBuilder();

  /**
   * <code>.rpcpb.BMClearRequest bmClear = 9;</code>
   */
  boolean hasBmClear();
  /**
   * <code>.rpcpb.BMClearRequest bmClear = 9;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMClearRequest getBmClear();
  /**
   * <code>.rpcpb.BMClearRequest bmClear = 9;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMClearRequestOrBuilder getBmClearOrBuilder();

  /**
   * <code>.rpcpb.BMRangeRequest bmRange = 10;</code>
   */
  boolean hasBmRange();
  /**
   * <code>.rpcpb.BMRangeRequest bmRange = 10;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMRangeRequest getBmRange();
  /**
   * <code>.rpcpb.BMRangeRequest bmRange = 10;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMRangeRequestOrBuilder getBmRangeOrBuilder();

  /**
   * <code>.rpcpb.BMCountRequest bmCount = 11;</code>
   */
  boolean hasBmCount();
  /**
   * <code>.rpcpb.BMCountRequest bmCount = 11;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMCountRequest getBmCount();
  /**
   * <code>.rpcpb.BMCountRequest bmCount = 11;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMCountRequestOrBuilder getBmCountOrBuilder();

  /**
   * <code>.rpcpb.BMContainsRequest bmContains = 12;</code>
   */
  boolean hasBmContains();
  /**
   * <code>.rpcpb.BMContainsRequest bmContains = 12;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMContainsRequest getBmContains();
  /**
   * <code>.rpcpb.BMContainsRequest bmContains = 12;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMContainsRequestOrBuilder getBmContainsOrBuilder();

  /**
   * <code>.rpcpb.TenantInitRequest tenantInit = 13;</code>
   */
  boolean hasTenantInit();
  /**
   * <code>.rpcpb.TenantInitRequest tenantInit = 13;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.TenantInitRequest getTenantInit();
  /**
   * <code>.rpcpb.TenantInitRequest tenantInit = 13;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.TenantInitRequestOrBuilder getTenantInitOrBuilder();

  /**
   * <code>.rpcpb.StartingInstanceRequest startInstance = 14;</code>
   */
  boolean hasStartInstance();
  /**
   * <code>.rpcpb.StartingInstanceRequest startInstance = 14;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.StartingInstanceRequest getStartInstance();
  /**
   * <code>.rpcpb.StartingInstanceRequest startInstance = 14;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.StartingInstanceRequestOrBuilder getStartInstanceOrBuilder();

  /**
   * <code>.rpcpb.StopInstanceRequest stopInstance = 15;</code>
   */
  boolean hasStopInstance();
  /**
   * <code>.rpcpb.StopInstanceRequest stopInstance = 15;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.StopInstanceRequest getStopInstance();
  /**
   * <code>.rpcpb.StopInstanceRequest stopInstance = 15;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.StopInstanceRequestOrBuilder getStopInstanceOrBuilder();

  /**
   * <code>.rpcpb.InstanceCountStateRequest countInstance = 16;</code>
   */
  boolean hasCountInstance();
  /**
   * <code>.rpcpb.InstanceCountStateRequest countInstance = 16;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.InstanceCountStateRequest getCountInstance();
  /**
   * <code>.rpcpb.InstanceCountStateRequest countInstance = 16;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.InstanceCountStateRequestOrBuilder getCountInstanceOrBuilder();

  /**
   * <code>.rpcpb.InstanceCrowdStateRequest crowdInstance = 17;</code>
   */
  boolean hasCrowdInstance();
  /**
   * <code>.rpcpb.InstanceCrowdStateRequest crowdInstance = 17;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.InstanceCrowdStateRequest getCrowdInstance();
  /**
   * <code>.rpcpb.InstanceCrowdStateRequest crowdInstance = 17;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.InstanceCrowdStateRequestOrBuilder getCrowdInstanceOrBuilder();

  /**
   * <code>.rpcpb.UpdateMappingRequest updateMapping = 18;</code>
   */
  boolean hasUpdateMapping();
  /**
   * <code>.rpcpb.UpdateMappingRequest updateMapping = 18;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateMappingRequest getUpdateMapping();
  /**
   * <code>.rpcpb.UpdateMappingRequest updateMapping = 18;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateMappingRequestOrBuilder getUpdateMappingOrBuilder();

  /**
   * <code>.rpcpb.GetMappingRequest getMapping = 19;</code>
   */
  boolean hasGetMapping();
  /**
   * <code>.rpcpb.GetMappingRequest getMapping = 19;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest getGetMapping();
  /**
   * <code>.rpcpb.GetMappingRequest getMapping = 19;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequestOrBuilder getGetMappingOrBuilder();

  /**
   * <code>.rpcpb.UpdateProfileRequest updateProfile = 20;</code>
   */
  boolean hasUpdateProfile();
  /**
   * <code>.rpcpb.UpdateProfileRequest updateProfile = 20;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateProfileRequest getUpdateProfile();
  /**
   * <code>.rpcpb.UpdateProfileRequest updateProfile = 20;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateProfileRequestOrBuilder getUpdateProfileOrBuilder();

  /**
   * <code>.rpcpb.GetProfileRequest getProfile = 21;</code>
   */
  boolean hasGetProfile();
  /**
   * <code>.rpcpb.GetProfileRequest getProfile = 21;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetProfileRequest getGetProfile();
  /**
   * <code>.rpcpb.GetProfileRequest getProfile = 21;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetProfileRequestOrBuilder getGetProfileOrBuilder();

  /**
   * <code>.rpcpb.AddEventRequest addEvent = 22;</code>
   */
  boolean hasAddEvent();
  /**
   * <code>.rpcpb.AddEventRequest addEvent = 22;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.AddEventRequest getAddEvent();
  /**
   * <code>.rpcpb.AddEventRequest addEvent = 22;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.AddEventRequestOrBuilder getAddEventOrBuilder();

  /**
   * <code>.rpcpb.FetchNotifyRequest fetchNotify = 23;</code>
   */
  boolean hasFetchNotify();
  /**
   * <code>.rpcpb.FetchNotifyRequest fetchNotify = 23;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.FetchNotifyRequest getFetchNotify();
  /**
   * <code>.rpcpb.FetchNotifyRequest fetchNotify = 23;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.FetchNotifyRequestOrBuilder getFetchNotifyOrBuilder();

  /**
   * <code>.rpcpb.AllocIDRequest allocID = 24;</code>
   */
  boolean hasAllocID();
  /**
   * <code>.rpcpb.AllocIDRequest allocID = 24;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.AllocIDRequest getAllocID();
  /**
   * <code>.rpcpb.AllocIDRequest allocID = 24;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.AllocIDRequestOrBuilder getAllocIDOrBuilder();

  /**
   * <code>.rpcpb.ResetIDRequest resetID = 25;</code>
   */
  boolean hasResetID();
  /**
   * <code>.rpcpb.ResetIDRequest resetID = 25;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ResetIDRequest getResetID();
  /**
   * <code>.rpcpb.ResetIDRequest resetID = 25;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ResetIDRequestOrBuilder getResetIDOrBuilder();

  /**
   * <code>.rpcpb.ScanMappingRequest scanMapping = 26;</code>
   */
  boolean hasScanMapping();
  /**
   * <code>.rpcpb.ScanMappingRequest scanMapping = 26;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ScanMappingRequest getScanMapping();
  /**
   * <code>.rpcpb.ScanMappingRequest scanMapping = 26;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ScanMappingRequestOrBuilder getScanMappingOrBuilder();
}
