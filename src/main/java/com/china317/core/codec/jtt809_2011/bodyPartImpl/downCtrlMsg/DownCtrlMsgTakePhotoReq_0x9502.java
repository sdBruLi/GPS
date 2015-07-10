/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownCtrlMsgTakePhotoReq_0x9502 extends DownCtrlMsgHead
/*    */ {
/*    */   private byte lensId;
/*    */   private byte size;
/*    */ 
/*    */   public byte getLensId()
/*    */   {
/* 13 */     return this.lensId;
/*    */   }
/*    */ 
/*    */   public void setLensId(byte lensId) {
/* 17 */     this.lensId = lensId;
/*    */   }
/*    */ 
/*    */   public byte getSize() {
/* 21 */     return this.size;
/*    */   }
/*    */ 
/*    */   public void setSize(byte size) {
/* 25 */     this.size = size;
/*    */   }
/*    */ 
/*    */   public DownCtrlMsgTakePhotoReq_0x9502()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownCtrlMsgTakePhotoReq_0x9502(int msgId) {
/* 33 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 38 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 39 */     parseFirstBody(buffer);
/* 40 */     setLensId(buffer.get());
/* 41 */     setSize(buffer.get());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 46 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 47 */     setDataLength(2);
/* 48 */     buildFirstBody(buffer);
/* 49 */     buffer.put(getLensId());
/* 50 */     buffer.put(getSize());
/* 51 */     buffer.flip();
/* 52 */     byte[] bytes = new byte[buffer.remaining()];
/* 53 */     buffer.get(bytes);
/* 54 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 59 */     return 38146;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 63 */     return super.toString() + ",lensId=" + this.lensId + ",size=" + this.size;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 67 */     DownCtrlMsgTakePhotoReq_0x9502 entity = new DownCtrlMsgTakePhotoReq_0x9502();
/* 68 */     entity.setVehicleNo("沪A3804");
/* 69 */     entity.setVehicleColor((byte)1);
/* 70 */     entity.setDataType(1);
/*    */ 
/* 72 */     entity.setLensId((byte)1);
/* 73 */     entity.setSize((byte)1);
/*    */ 
/* 76 */     DownCtrlMsgTakePhotoReq_0x9502 entity2 = new DownCtrlMsgTakePhotoReq_0x9502();
/* 77 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgTakePhotoReq_0x9502
 * JD-Core Version:    0.6.1
 */