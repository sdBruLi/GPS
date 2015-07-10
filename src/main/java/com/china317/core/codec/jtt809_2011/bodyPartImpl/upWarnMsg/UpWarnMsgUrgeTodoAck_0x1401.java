/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upWarnMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpWarnMsgUrgeTodoAck_0x1401 extends UpWarnMsgHead
/*    */ {
/*    */   private int supervisionId;
/*    */   private byte result;
/*    */ 
/*    */   public int getSupervisionId()
/*    */   {
/* 13 */     return this.supervisionId;
/*    */   }
/*    */ 
/*    */   public void setSupervisionId(int supervisionId) {
/* 17 */     this.supervisionId = supervisionId;
/*    */   }
/*    */ 
/*    */   public byte getResult()
/*    */   {
/* 22 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 26 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public UpWarnMsgUrgeTodoAck_0x1401()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpWarnMsgUrgeTodoAck_0x1401(int msgId) {
/* 34 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 39 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 40 */     parseFirstBody(buffer);
/* 41 */     setSupervisionId(buffer.getInt());
/* 42 */     setResult(buffer.get());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 47 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 48 */     setDataLength(5);
/* 49 */     buildFirstBody(buffer);
/* 50 */     buffer.putInt(getSupervisionId());
/* 51 */     buffer.put(getResult());
/* 52 */     buffer.flip();
/* 53 */     byte[] bytes = new byte[buffer.remaining()];
/* 54 */     buffer.get(bytes);
/* 55 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 60 */     return 5121;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 64 */     return super.toString() + ",supervisionId=" + this.supervisionId + 
/* 65 */       ",result=" + this.result;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 69 */     UpWarnMsgUrgeTodoAck_0x1401 entity = new UpWarnMsgUrgeTodoAck_0x1401();
/* 70 */     entity.setVehicleNo("沪A3804");
/* 71 */     entity.setVehicleColor((byte)1);
/* 72 */     entity.setDataType(1);
/*    */ 
/* 74 */     entity.setSupervisionId(1);
/* 75 */     entity.setResult((byte)1);
/*    */ 
/* 78 */     UpWarnMsgUrgeTodoAck_0x1401 entity2 = new UpWarnMsgUrgeTodoAck_0x1401();
/* 79 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upWarnMsg.UpWarnMsgUrgeTodoAck_0x1401
 * JD-Core Version:    0.6.1
 */