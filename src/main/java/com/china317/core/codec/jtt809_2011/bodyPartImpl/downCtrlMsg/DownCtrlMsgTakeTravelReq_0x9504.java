/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownCtrlMsgTakeTravelReq_0x9504 extends DownCtrlMsgHead
/*    */ {
/*    */   private byte commandType;
/*    */ 
/*    */   public DownCtrlMsgTakeTravelReq_0x9504()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownCtrlMsgTakeTravelReq_0x9504(int msgId)
/*    */   {
/* 33 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 38 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 39 */     parseFirstBody(buffer);
/* 40 */     setCommandType(buffer.get());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 47 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 48 */     setDataLength(1);
/* 49 */     buildFirstBody(buffer);
/* 50 */     buffer.put(this.commandType);
/*    */ 
/* 53 */     buffer.flip();
/* 54 */     byte[] bytes = new byte[buffer.remaining()];
/* 55 */     buffer.get(bytes);
/* 56 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 61 */     return 38148;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 65 */     return super.toString() + ",commandType=" + this.commandType;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 69 */     DownCtrlMsgTakeTravelReq_0x9504 entity = new DownCtrlMsgTakeTravelReq_0x9504();
/* 70 */     entity.setVehicleNo("沪A3804");
/* 71 */     entity.setVehicleColor((byte)1);
/* 72 */     entity.setDataType(1);
/*    */ 
/* 79 */     DownCtrlMsgTakeTravelReq_0x9504 entity2 = new DownCtrlMsgTakeTravelReq_0x9504();
/* 80 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ 
/*    */   public byte getCommandType()
/*    */   {
/* 85 */     return this.commandType;
/*    */   }
/*    */ 
/*    */   public void setCommandType(byte commandType) {
/* 89 */     this.commandType = commandType;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgTakeTravelReq_0x9504
 * JD-Core Version:    0.6.1
 */