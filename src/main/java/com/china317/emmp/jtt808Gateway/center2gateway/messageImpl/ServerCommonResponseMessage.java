/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8001;
/*    */ 
/*    */ public class ServerCommonResponseMessage extends BaseDownMessage
/*    */ {
/*    */   public static final byte RESULT_OK = 0;
/*    */   public static final byte RESULT_FAILURE = 1;
/*    */   public static final byte RESULT_MSG_ERROR = 2;
/*    */   public static final byte RESULT_NONSUPPORT = 3;
/*    */   public static final byte RESULT_ALARM_CONFIRM = 4;
/*    */   private int responseSequenceNum;
/*    */   private int responseMsgID;
/*    */   private byte result;
/*    */ 
/*    */   public ServerCommonResponseMessage(String mobileNum, String messageKey, int responseSequenceNum, int responseMsgID, byte result)
/*    */   {
/* 31 */     setMobileNum(mobileNum);
/* 32 */     setMessageKey(messageKey);
/* 33 */     setResponseMsgID(responseMsgID);
/* 34 */     setResponseSequenceNum(responseSequenceNum);
/* 35 */     setResult(result);
/* 36 */     setCommand("0x8001");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 41 */     UnitPackJT808 pack = new UnitPackJT808(32769);
/* 42 */     pack.setMobileNum(getMobileNum());
/* 43 */     JT808MsgBody_0x8001 body = new JT808MsgBody_0x8001();
/* 44 */     body.setResponseSequenceNum(this.responseSequenceNum);
/* 45 */     body.setResponseMsgID(this.responseMsgID);
/* 46 */     body.setResult(this.result);
/* 47 */     pack.setMsgBody(body);
/* 48 */     return pack;
/*    */   }
/*    */ 
/*    */   public void setResponseSequenceNum(int responseSequenceNum)
/*    */   {
/* 53 */     this.responseSequenceNum = responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public void setResponseMsgID(int responseMsgID) {
/* 57 */     this.responseMsgID = responseMsgID;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 61 */     this.result = result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ServerCommonResponseMessage
 * JD-Core Version:    0.6.1
 */