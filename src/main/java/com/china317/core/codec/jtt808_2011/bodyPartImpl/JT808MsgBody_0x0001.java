/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0001 extends JT808MsgBody
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
/*    */   public int getResponseSequenceNum()
/*    */   {
/* 21 */     return this.responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public void setResponseSequenceNum(int responseSequenceNum) {
/* 25 */     this.responseSequenceNum = responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public int getResponseMsgID() {
/* 29 */     return this.responseMsgID;
/*    */   }
/*    */ 
/*    */   public void setResponseMsgID(int responseMsgID) {
/* 33 */     this.responseMsgID = responseMsgID;
/*    */   }
/*    */ 
/*    */   public byte getResult() {
/* 37 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 41 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public void bulidBody() throws Exception
/*    */   {
/* 46 */     if (!isBuildBody()) {
/* 47 */       this.bodyBuffer = IoBuffer.allocate(5).setAutoExpand(true);
/* 48 */       this.bodyBuffer.putUnsignedShort(this.responseSequenceNum);
/* 49 */       this.bodyBuffer.putUnsignedShort(this.responseMsgID);
/* 50 */       this.bodyBuffer.put(this.result);
/* 51 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 57 */     this.responseSequenceNum = this.bodyBuffer.getUnsignedShort();
/* 58 */     this.responseMsgID = this.bodyBuffer.getUnsignedShort();
/* 59 */     this.result = this.bodyBuffer.get();
/* 60 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 getCommonResponseOK(UnitPackJT808 requestPack) throws Exception {
/* 64 */     UnitPackJT808 pack = new UnitPackJT808(1);
/* 65 */     pack.setMobileNum(requestPack.getMobileNum());
/* 66 */     JT808MsgBody_0x8001 body = new JT808MsgBody_0x8001();
/* 67 */     body.setResponseSequenceNum(requestPack.getSequenceNum());
/* 68 */     body.setResponseMsgID(requestPack.getMsgID());
/* 69 */     body.setResult((byte)0);
/* 70 */     pack.setMsgBody(body);
/* 71 */     return pack;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0001
 * JD-Core Version:    0.6.1
 */