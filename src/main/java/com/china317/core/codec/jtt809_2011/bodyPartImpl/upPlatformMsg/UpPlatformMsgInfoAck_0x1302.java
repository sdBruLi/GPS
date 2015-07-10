/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upPlatformMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpPlatformMsgInfoAck_0x1302 extends UpPlatformMsgHead
/*    */ {
/*    */   private int infoId;
/*    */ 
/*    */   public int getInfoId()
/*    */   {
/* 12 */     return this.infoId;
/*    */   }
/*    */ 
/*    */   public void setInfoId(int infoId) {
/* 16 */     this.infoId = infoId;
/*    */   }
/*    */ 
/*    */   public UpPlatformMsgInfoAck_0x1302()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpPlatformMsgInfoAck_0x1302(int msgId) {
/* 24 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 29 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 30 */     parseFirstBody(buffer);
/* 31 */     setInfoId(buffer.getInt());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 36 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 37 */     setDataLength(4);
/* 38 */     buildFirstBody(buffer);
/* 39 */     buffer.putInt(getInfoId());
/* 40 */     buffer.flip();
/* 41 */     byte[] bytes = new byte[buffer.remaining()];
/* 42 */     buffer.get(bytes);
/* 43 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 48 */     return 4866;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 52 */     return super.toString() + ",infoId=" + this.infoId;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 56 */     UpPlatformMsgInfoAck_0x1302 entity = new UpPlatformMsgInfoAck_0x1302();
/* 57 */     entity.setDataType(1);
/*    */ 
/* 59 */     entity.setInfoId(1);
/*    */ 
/* 62 */     UpPlatformMsgInfoAck_0x1302 entity2 = new UpPlatformMsgInfoAck_0x1302();
/* 63 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upPlatformMsg.UpPlatformMsgInfoAck_0x1302
 * JD-Core Version:    0.6.1
 */