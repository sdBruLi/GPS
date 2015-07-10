/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upWarnMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpWarnMsgAdptTodoInfo_0x1403 extends UpWarnMsgHead
/*    */ {
/*    */   private int alarmId;
/*    */   private byte result;
/*    */ 
/*    */   public int getAlarmId()
/*    */   {
/* 13 */     return this.alarmId;
/*    */   }
/*    */ 
/*    */   public void setAlarmId(int alarmId) {
/* 17 */     this.alarmId = alarmId;
/*    */   }
/*    */ 
/*    */   public byte getResult() {
/* 21 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 25 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public UpWarnMsgAdptTodoInfo_0x1403()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpWarnMsgAdptTodoInfo_0x1403(int msgId) {
/* 33 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 38 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 39 */     parseFirstBody(buffer);
/* 40 */     setAlarmId(buffer.getInt());
/* 41 */     setResult(buffer.get());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 46 */     IoBuffer buffer = IoBuffer.allocate(1).setAutoExpand(true);
/* 47 */     setDataLength(5);
/* 48 */     buildFirstBody(buffer);
/* 49 */     buffer.putInt(this.alarmId);
/* 50 */     buffer.put(this.result);
/* 51 */     buffer.flip();
/* 52 */     byte[] bytes = new byte[buffer.remaining()];
/* 53 */     buffer.get(bytes);
/* 54 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 59 */     return 5122;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 63 */     return super.toString() + ",alarmId=" + this.alarmId + 
/* 64 */       ",result=" + this.result;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 68 */     UpWarnMsgAdptTodoInfo_0x1403 entity = new UpWarnMsgAdptTodoInfo_0x1403();
/* 69 */     entity.setVehicleNo("沪A3804");
/* 70 */     entity.setVehicleColor((byte)1);
/* 71 */     entity.setDataType(1);
/*    */ 
/* 80 */     UpWarnMsgAdptTodoInfo_0x1403 entity2 = new UpWarnMsgAdptTodoInfo_0x1403();
/* 81 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upWarnMsg.UpWarnMsgAdptTodoInfo_0x1403
 * JD-Core Version:    0.6.1
 */