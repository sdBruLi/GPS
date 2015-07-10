/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpCtrlMsgMonitorVehicleAck_0x1501 extends UpCtrlMsgHead
/*    */ {
/*    */   private byte result;
/*    */ 
/*    */   public byte getResult()
/*    */   {
/* 12 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 16 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public UpCtrlMsgMonitorVehicleAck_0x1501()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpCtrlMsgMonitorVehicleAck_0x1501(int msgId) {
/* 24 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 29 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 30 */     parseFirstBody(buffer);
/* 31 */     setResult(buffer.get());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 36 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 37 */     setDataLength(1);
/* 38 */     buildFirstBody(buffer);
/* 39 */     buffer.put(getResult());
/* 40 */     buffer.flip();
/* 41 */     byte[] bytes = new byte[buffer.remaining()];
/* 42 */     buffer.get(bytes);
/* 43 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 48 */     return 5377;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 52 */     return super.toString() + ",result=" + this.result;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 56 */     UpCtrlMsgMonitorVehicleAck_0x1501 entity = new UpCtrlMsgMonitorVehicleAck_0x1501();
/* 57 */     entity.setVehicleNo("沪A3804");
/* 58 */     entity.setVehicleColor((byte)1);
/* 59 */     entity.setDataType(1);
/*    */ 
/* 61 */     entity.setResult((byte)1);
/*    */ 
/* 64 */     UpCtrlMsgMonitorVehicleAck_0x1501 entity2 = new UpCtrlMsgMonitorVehicleAck_0x1501();
/* 65 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg.UpCtrlMsgMonitorVehicleAck_0x1501
 * JD-Core Version:    0.6.1
 */