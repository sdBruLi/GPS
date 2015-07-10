/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg;
/*    */ 
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownExgMsgApplyHisgnssdataAck_0x9209 extends DownExgMsgHead
/*    */ {
/*    */   private byte result;
/*    */ 
/*    */   public DownExgMsgApplyHisgnssdataAck_0x9209()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownExgMsgApplyHisgnssdataAck_0x9209(int msgId)
/*    */   {
/* 14 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception
/*    */   {
/* 19 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 20 */     setDatalength(36);
/*    */ 
/* 22 */     buildFirstBody(buffer);
/*    */ 
/* 24 */     buildLastBody(buffer);
/*    */ 
/* 26 */     buffer.flip();
/* 27 */     byte[] bytes = new byte[buffer.remaining()];
/* 28 */     buffer.get(bytes);
/* 29 */     return bytes;
/*    */   }
/*    */ 
/*    */   private void buildLastBody(IoBuffer buffer) throws CharacterCodingException {
/* 33 */     buffer.put(getResult());
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 39 */     return 37385;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 44 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 45 */     parseFirstBody(buffer);
/*    */ 
/* 47 */     parseLocationBody(buffer);
/*    */   }
/*    */ 
/*    */   public void parseLocationBody(IoBuffer buffer)
/*    */     throws CharacterCodingException
/*    */   {
/* 53 */     initBytes();
/* 54 */     setResult(buffer.get());
/*    */   }
/*    */ 
/*    */   private void initBytes()
/*    */   {
/*    */   }
/*    */ 
/*    */   public byte getResult()
/*    */   {
/* 64 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 68 */     this.result = result;
/*    */   }
/*    */   public String toString() {
/* 71 */     return super.toString() + ",result=" + this.result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgApplyHisgnssdataAck_0x9209
 * JD-Core Version:    0.6.1
 */