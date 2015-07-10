/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpCtrlMsgTextInfoAck_0x1503 extends UpCtrlMsgHead
/*    */ {
/*    */   private int msgId;
/*    */   private byte result;
/*    */ 
/*    */   public int getMsgId()
/*    */   {
/* 13 */     return this.msgId;
/*    */   }
/*    */ 
/*    */   public void setMsgId(int msgId) {
/* 17 */     this.msgId = msgId;
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
/*    */   public UpCtrlMsgTextInfoAck_0x1503()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpCtrlMsgTextInfoAck_0x1503(int msgId) {
/* 33 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 38 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 39 */     parseFirstBody(buffer);
/* 40 */     setMsgId(buffer.getInt());
/* 41 */     setResult(buffer.get());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 46 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 47 */     setDataLength(5);
/* 48 */     buildFirstBody(buffer);
/* 49 */     buffer.putInt(getMsgId());
/* 50 */     buffer.put(getResult());
/* 51 */     buffer.flip();
/* 52 */     byte[] bytes = new byte[buffer.remaining()];
/* 53 */     buffer.get(bytes);
/* 54 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 59 */     return 5379;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 63 */     return super.toString() + ",msgId=" + this.msgId + ",result=" + this.result;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 67 */     UpCtrlMsgTextInfoAck_0x1503 entity = new UpCtrlMsgTextInfoAck_0x1503();
/* 68 */     entity.setVehicleNo("沪A3804");
/* 69 */     entity.setVehicleColor((byte)1);
/* 70 */     entity.setDataType(1);
/*    */ 
/* 72 */     entity.setMsgId(1);
/* 73 */     entity.setResult((byte)1);
/*    */ 
/* 76 */     UpCtrlMsgTextInfoAck_0x1503 entity2 = new UpCtrlMsgTextInfoAck_0x1503();
/* 77 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg.UpCtrlMsgTextInfoAck_0x1503
 * JD-Core Version:    0.6.1
 */