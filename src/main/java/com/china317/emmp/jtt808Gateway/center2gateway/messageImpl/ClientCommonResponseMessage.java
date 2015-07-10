/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0001;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class ClientCommonResponseMessage extends BaseUpMessage
/*    */ {
/* 16 */   private static final Log log = LogFactory.getLog(ClientCommonResponseMessage.class);
/*    */   public static final byte RESULT_OK = 0;
/*    */   public static final byte RESULT_FAILURE = 1;
/*    */   public static final byte RESULT_MSG_ERROR = 2;
/*    */   public static final byte RESULT_NONSUPPORT = 3;
/*    */   public static final byte RESULT_ALARM_CONFIRM = 4;
/*    */   private int responseSequenceNum;
/*    */   private int responseMsgID;
/*    */   private byte result;
/*    */ 
/*    */   public ClientCommonResponseMessage()
/*    */   {
/* 33 */     setCommand("0x0001");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 38 */     unpackHeadPart(pack);
/*    */     try {
/* 40 */       JT808MsgBody_0x0001 body = (JT808MsgBody_0x0001)pack.getMsgBody();
/* 41 */       setResponseMsgID(body.getResponseMsgID());
/* 42 */       setResponseSequenceNum(body.getResponseSequenceNum());
/* 43 */       setResult(body.getResult());
/*    */     } catch (Exception e) {
/* 45 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getResponseSequenceNum() {
/* 50 */     return this.responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public void setResponseSequenceNum(int responseSequenceNum)
/*    */   {
/* 55 */     this.responseSequenceNum = responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public int getResponseMsgID() {
/* 59 */     return this.responseMsgID;
/*    */   }
/*    */ 
/*    */   public void setResponseMsgID(int responseMsgID)
/*    */   {
/* 64 */     this.responseMsgID = responseMsgID;
/*    */   }
/*    */ 
/*    */   public byte getResult() {
/* 68 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result)
/*    */   {
/* 73 */     this.result = result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ClientCommonResponseMessage
 * JD-Core Version:    0.6.1
 */