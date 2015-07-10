/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg;
/*    */ 
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownExgMsgApplyForMonitorStartupAck_0x9207 extends DownExgMsgHead
/*    */ {
/*    */   private byte result;
/*    */ 
/*    */   public DownExgMsgApplyForMonitorStartupAck_0x9207()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownExgMsgApplyForMonitorStartupAck_0x9207(int msgId)
/*    */   {
/* 14 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception {
/* 18 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 19 */     setDatalength(36);
/*    */ 
/* 21 */     buildFirstBody(buffer);
/*    */ 
/* 23 */     buildLastBody(buffer);
/*    */ 
/* 25 */     buffer.flip();
/* 26 */     byte[] bytes = new byte[buffer.remaining()];
/* 27 */     buffer.get(bytes);
/* 28 */     return bytes;
/*    */   }
/*    */ 
/*    */   private void buildLastBody(IoBuffer buffer) throws CharacterCodingException {
/* 32 */     buffer.put(getResult());
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 38 */     return 37383;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 43 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 44 */     parseFirstBody(buffer);
/*    */ 
/* 46 */     parseLocationBody(buffer);
/*    */   }
/*    */ 
/*    */   public void parseLocationBody(IoBuffer buffer)
/*    */     throws CharacterCodingException
/*    */   {
/* 52 */     initBytes();
/* 53 */     setResult(buffer.get());
/*    */   }
/*    */ 
/*    */   private void initBytes()
/*    */   {
/*    */   }
/*    */ 
/*    */   public byte getResult()
/*    */   {
/* 63 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 67 */     this.result = result;
/*    */   }
/*    */   public String toString() {
/* 70 */     return super.toString() + ",result=" + this.result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgApplyForMonitorStartupAck_0x9207
 * JD-Core Version:    0.6.1
 */