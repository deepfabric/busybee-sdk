// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package cn.infinivision.dataforce.busybee.pb.rpc;

public interface NotifyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcpb.Notify)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 userID = 1;</code>
   */
  long getUserID();

  /**
   * <code>bytes crowd = 2;</code>
   */
  com.google.protobuf.ByteString getCrowd();

  /**
   * <code>uint64 tenantID = 3;</code>
   */
  long getTenantID();

  /**
   * <code>uint64 workflowID = 4;</code>
   */
  long getWorkflowID();

  /**
   * <code>string fromStep = 5;</code>
   */
  java.lang.String getFromStep();
  /**
   * <code>string fromStep = 5;</code>
   */
  com.google.protobuf.ByteString
      getFromStepBytes();

  /**
   * <code>string fromAction = 6;</code>
   */
  java.lang.String getFromAction();
  /**
   * <code>string fromAction = 6;</code>
   */
  com.google.protobuf.ByteString
      getFromActionBytes();

  /**
   * <code>string toStep = 7;</code>
   */
  java.lang.String getToStep();
  /**
   * <code>string toStep = 7;</code>
   */
  com.google.protobuf.ByteString
      getToStepBytes();

  /**
   * <code>string toAction = 8;</code>
   */
  java.lang.String getToAction();
  /**
   * <code>string toAction = 8;</code>
   */
  com.google.protobuf.ByteString
      getToActionBytes();
}
