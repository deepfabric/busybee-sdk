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
   * <code>.rpcpb.ScanRequest scan = 6;</code>
   */
  boolean hasScan();
  /**
   * <code>.rpcpb.ScanRequest scan = 6;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ScanRequest getScan();
  /**
   * <code>.rpcpb.ScanRequest scan = 6;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ScanRequestOrBuilder getScanOrBuilder();

  /**
   * <code>.rpcpb.BMCreateRequest bmCreate = 7;</code>
   */
  boolean hasBmCreate();
  /**
   * <code>.rpcpb.BMCreateRequest bmCreate = 7;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMCreateRequest getBmCreate();
  /**
   * <code>.rpcpb.BMCreateRequest bmCreate = 7;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMCreateRequestOrBuilder getBmCreateOrBuilder();

  /**
   * <code>.rpcpb.BMAddRequest bmAdd = 8;</code>
   */
  boolean hasBmAdd();
  /**
   * <code>.rpcpb.BMAddRequest bmAdd = 8;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequest getBmAdd();
  /**
   * <code>.rpcpb.BMAddRequest bmAdd = 8;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMAddRequestOrBuilder getBmAddOrBuilder();

  /**
   * <code>.rpcpb.BMRemoveRequest bmRemove = 9;</code>
   */
  boolean hasBmRemove();
  /**
   * <code>.rpcpb.BMRemoveRequest bmRemove = 9;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMRemoveRequest getBmRemove();
  /**
   * <code>.rpcpb.BMRemoveRequest bmRemove = 9;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMRemoveRequestOrBuilder getBmRemoveOrBuilder();

  /**
   * <code>.rpcpb.BMClearRequest bmClear = 10;</code>
   */
  boolean hasBmClear();
  /**
   * <code>.rpcpb.BMClearRequest bmClear = 10;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMClearRequest getBmClear();
  /**
   * <code>.rpcpb.BMClearRequest bmClear = 10;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMClearRequestOrBuilder getBmClearOrBuilder();

  /**
   * <code>.rpcpb.BMRangeRequest bmRange = 11;</code>
   */
  boolean hasBmRange();
  /**
   * <code>.rpcpb.BMRangeRequest bmRange = 11;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMRangeRequest getBmRange();
  /**
   * <code>.rpcpb.BMRangeRequest bmRange = 11;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMRangeRequestOrBuilder getBmRangeOrBuilder();

  /**
   * <code>.rpcpb.BMCountRequest bmCount = 12;</code>
   */
  boolean hasBmCount();
  /**
   * <code>.rpcpb.BMCountRequest bmCount = 12;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMCountRequest getBmCount();
  /**
   * <code>.rpcpb.BMCountRequest bmCount = 12;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMCountRequestOrBuilder getBmCountOrBuilder();

  /**
   * <code>.rpcpb.BMContainsRequest bmContains = 13;</code>
   */
  boolean hasBmContains();
  /**
   * <code>.rpcpb.BMContainsRequest bmContains = 13;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMContainsRequest getBmContains();
  /**
   * <code>.rpcpb.BMContainsRequest bmContains = 13;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.BMContainsRequestOrBuilder getBmContainsOrBuilder();

  /**
   * <code>.rpcpb.TenantInitRequest tenantInit = 14;</code>
   */
  boolean hasTenantInit();
  /**
   * <code>.rpcpb.TenantInitRequest tenantInit = 14;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.TenantInitRequest getTenantInit();
  /**
   * <code>.rpcpb.TenantInitRequest tenantInit = 14;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.TenantInitRequestOrBuilder getTenantInitOrBuilder();

  /**
   * <code>.rpcpb.StartingInstanceRequest startInstance = 15;</code>
   */
  boolean hasStartInstance();
  /**
   * <code>.rpcpb.StartingInstanceRequest startInstance = 15;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.StartingInstanceRequest getStartInstance();
  /**
   * <code>.rpcpb.StartingInstanceRequest startInstance = 15;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.StartingInstanceRequestOrBuilder getStartInstanceOrBuilder();

  /**
   * <code>.rpcpb.LastInstanceRequest lastInstance = 16;</code>
   */
  boolean hasLastInstance();
  /**
   * <code>.rpcpb.LastInstanceRequest lastInstance = 16;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.LastInstanceRequest getLastInstance();
  /**
   * <code>.rpcpb.LastInstanceRequest lastInstance = 16;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.LastInstanceRequestOrBuilder getLastInstanceOrBuilder();

  /**
   * <code>.rpcpb.HistoryInstanceRequest historyInstance = 17;</code>
   */
  boolean hasHistoryInstance();
  /**
   * <code>.rpcpb.HistoryInstanceRequest historyInstance = 17;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.HistoryInstanceRequest getHistoryInstance();
  /**
   * <code>.rpcpb.HistoryInstanceRequest historyInstance = 17;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.HistoryInstanceRequestOrBuilder getHistoryInstanceOrBuilder();

  /**
   * <code>.rpcpb.UpdateCrowdRequest updateCrowd = 18;</code>
   */
  boolean hasUpdateCrowd();
  /**
   * <code>.rpcpb.UpdateCrowdRequest updateCrowd = 18;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateCrowdRequest getUpdateCrowd();
  /**
   * <code>.rpcpb.UpdateCrowdRequest updateCrowd = 18;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateCrowdRequestOrBuilder getUpdateCrowdOrBuilder();

  /**
   * <code>.rpcpb.UpdateWorkflowRequest updateWorkflow = 19;</code>
   */
  boolean hasUpdateWorkflow();
  /**
   * <code>.rpcpb.UpdateWorkflowRequest updateWorkflow = 19;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateWorkflowRequest getUpdateWorkflow();
  /**
   * <code>.rpcpb.UpdateWorkflowRequest updateWorkflow = 19;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateWorkflowRequestOrBuilder getUpdateWorkflowOrBuilder();

  /**
   * <code>.rpcpb.StopInstanceRequest stopInstance = 20;</code>
   */
  boolean hasStopInstance();
  /**
   * <code>.rpcpb.StopInstanceRequest stopInstance = 20;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.StopInstanceRequest getStopInstance();
  /**
   * <code>.rpcpb.StopInstanceRequest stopInstance = 20;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.StopInstanceRequestOrBuilder getStopInstanceOrBuilder();

  /**
   * <code>.rpcpb.InstanceCountStateRequest countInstance = 21;</code>
   */
  boolean hasCountInstance();
  /**
   * <code>.rpcpb.InstanceCountStateRequest countInstance = 21;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.InstanceCountStateRequest getCountInstance();
  /**
   * <code>.rpcpb.InstanceCountStateRequest countInstance = 21;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.InstanceCountStateRequestOrBuilder getCountInstanceOrBuilder();

  /**
   * <code>.rpcpb.InstanceCrowdStateRequest crowdInstance = 22;</code>
   */
  boolean hasCrowdInstance();
  /**
   * <code>.rpcpb.InstanceCrowdStateRequest crowdInstance = 22;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.InstanceCrowdStateRequest getCrowdInstance();
  /**
   * <code>.rpcpb.InstanceCrowdStateRequest crowdInstance = 22;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.InstanceCrowdStateRequestOrBuilder getCrowdInstanceOrBuilder();

  /**
   * <code>.rpcpb.UpdateMappingRequest updateMapping = 23;</code>
   */
  boolean hasUpdateMapping();
  /**
   * <code>.rpcpb.UpdateMappingRequest updateMapping = 23;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateMappingRequest getUpdateMapping();
  /**
   * <code>.rpcpb.UpdateMappingRequest updateMapping = 23;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateMappingRequestOrBuilder getUpdateMappingOrBuilder();

  /**
   * <code>.rpcpb.GetMappingRequest getMapping = 24;</code>
   */
  boolean hasGetMapping();
  /**
   * <code>.rpcpb.GetMappingRequest getMapping = 24;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequest getGetMapping();
  /**
   * <code>.rpcpb.GetMappingRequest getMapping = 24;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetMappingRequestOrBuilder getGetMappingOrBuilder();

  /**
   * <code>.rpcpb.UpdateProfileRequest updateProfile = 25;</code>
   */
  boolean hasUpdateProfile();
  /**
   * <code>.rpcpb.UpdateProfileRequest updateProfile = 25;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateProfileRequest getUpdateProfile();
  /**
   * <code>.rpcpb.UpdateProfileRequest updateProfile = 25;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.UpdateProfileRequestOrBuilder getUpdateProfileOrBuilder();

  /**
   * <code>.rpcpb.GetProfileRequest getProfile = 26;</code>
   */
  boolean hasGetProfile();
  /**
   * <code>.rpcpb.GetProfileRequest getProfile = 26;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetProfileRequest getGetProfile();
  /**
   * <code>.rpcpb.GetProfileRequest getProfile = 26;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetProfileRequestOrBuilder getGetProfileOrBuilder();

  /**
   * <code>.rpcpb.AddEventRequest addEvent = 27;</code>
   */
  boolean hasAddEvent();
  /**
   * <code>.rpcpb.AddEventRequest addEvent = 27;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.AddEventRequest getAddEvent();
  /**
   * <code>.rpcpb.AddEventRequest addEvent = 27;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.AddEventRequestOrBuilder getAddEventOrBuilder();

  /**
   * <code>.rpcpb.QueueJoinGroupRequest queueJoin = 28;</code>
   */
  boolean hasQueueJoin();
  /**
   * <code>.rpcpb.QueueJoinGroupRequest queueJoin = 28;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueJoinGroupRequest getQueueJoin();
  /**
   * <code>.rpcpb.QueueJoinGroupRequest queueJoin = 28;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueJoinGroupRequestOrBuilder getQueueJoinOrBuilder();

  /**
   * <code>.rpcpb.QueueFetchRequest queueFetch = 29;</code>
   */
  boolean hasQueueFetch();
  /**
   * <code>.rpcpb.QueueFetchRequest queueFetch = 29;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequest getQueueFetch();
  /**
   * <code>.rpcpb.QueueFetchRequest queueFetch = 29;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueFetchRequestOrBuilder getQueueFetchOrBuilder();

  /**
   * <code>.rpcpb.AllocIDRequest allocID = 30;</code>
   */
  boolean hasAllocID();
  /**
   * <code>.rpcpb.AllocIDRequest allocID = 30;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.AllocIDRequest getAllocID();
  /**
   * <code>.rpcpb.AllocIDRequest allocID = 30;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.AllocIDRequestOrBuilder getAllocIDOrBuilder();

  /**
   * <code>.rpcpb.ResetIDRequest resetID = 31;</code>
   */
  boolean hasResetID();
  /**
   * <code>.rpcpb.ResetIDRequest resetID = 31;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ResetIDRequest getResetID();
  /**
   * <code>.rpcpb.ResetIDRequest resetID = 31;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ResetIDRequestOrBuilder getResetIDOrBuilder();

  /**
   * <code>.rpcpb.ScanMappingRequest scanMapping = 32;</code>
   */
  boolean hasScanMapping();
  /**
   * <code>.rpcpb.ScanMappingRequest scanMapping = 32;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ScanMappingRequest getScanMapping();
  /**
   * <code>.rpcpb.ScanMappingRequest scanMapping = 32;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.ScanMappingRequestOrBuilder getScanMappingOrBuilder();

  /**
   * <code>.rpcpb.GetIDSetRequest getIDSet = 33;</code>
   */
  boolean hasGetIDSet();
  /**
   * <code>.rpcpb.GetIDSetRequest getIDSet = 33;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetIDSetRequest getGetIDSet();
  /**
   * <code>.rpcpb.GetIDSetRequest getIDSet = 33;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.GetIDSetRequestOrBuilder getGetIDSetOrBuilder();

  /**
   * <code>.rpcpb.SetIfRequest setIf = 34;</code>
   */
  boolean hasSetIf();
  /**
   * <code>.rpcpb.SetIfRequest setIf = 34;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.SetIfRequest getSetIf();
  /**
   * <code>.rpcpb.SetIfRequest setIf = 34;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.SetIfRequestOrBuilder getSetIfOrBuilder();

  /**
   * <code>.rpcpb.DeleteIfRequest deleteIf = 35;</code>
   */
  boolean hasDeleteIf();
  /**
   * <code>.rpcpb.DeleteIfRequest deleteIf = 35;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.DeleteIfRequest getDeleteIf();
  /**
   * <code>.rpcpb.DeleteIfRequest deleteIf = 35;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.DeleteIfRequestOrBuilder getDeleteIfOrBuilder();

  /**
   * <code>.rpcpb.QueueScanRequest queueScan = 36;</code>
   */
  boolean hasQueueScan();
  /**
   * <code>.rpcpb.QueueScanRequest queueScan = 36;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequest getQueueScan();
  /**
   * <code>.rpcpb.QueueScanRequest queueScan = 36;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueScanRequestOrBuilder getQueueScanOrBuilder();

  /**
   * <code>.rpcpb.QueueCommitRequest queueCommit = 37;</code>
   */
  boolean hasQueueCommit();
  /**
   * <code>.rpcpb.QueueCommitRequest queueCommit = 37;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueCommitRequest getQueueCommit();
  /**
   * <code>.rpcpb.QueueCommitRequest queueCommit = 37;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueCommitRequestOrBuilder getQueueCommitOrBuilder();

  /**
   * <code>.rpcpb.QueueDeleteRequest queueDelete = 38;</code>
   */
  boolean hasQueueDelete();
  /**
   * <code>.rpcpb.QueueDeleteRequest queueDelete = 38;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueDeleteRequest getQueueDelete();
  /**
   * <code>.rpcpb.QueueDeleteRequest queueDelete = 38;</code>
   */
  cn.infinivision.dataforce.busybee.pb.rpc.QueueDeleteRequestOrBuilder getQueueDeleteOrBuilder();
}
