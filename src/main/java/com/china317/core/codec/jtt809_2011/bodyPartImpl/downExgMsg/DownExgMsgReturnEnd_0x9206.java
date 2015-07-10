/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg;
/*    */ 
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownExgMsgReturnEnd_0x9206 extends DownExgMsgHead
/*    */ {
/*    */   private byte reasonCode;
/*    */ 
/*    */   public DownExgMsgReturnEnd_0x9206()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownExgMsgReturnEnd_0x9206(int msgId)
/*    */   {
/* 14 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception {
/* 18 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 19 */     setDatalength(1);
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
/* 32 */     buffer.put(getReasonCode());
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 38 */     return 37382;
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
/* 53 */     setReasonCode(buffer.get());
/*    */   }
/*    */ 
/*    */   private void initBytes()
/*    */   {
/*    */   }
/*    */ 
/*    */   public byte getReasonCode()
/*    */   {
/* 63 */     return this.reasonCode;
/*    */   }
/*    */ 
/*    */   public void setReasonCode(byte reasonCode) {
/* 67 */     this.reasonCode = reasonCode;
/*    */   }
/*    */   public String toString() {
/* 70 */     return super.toString() + ",reasonCode=" + this.reasonCode;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgReturnEnd_0x9206
 * JD-Core Version:    0.6.1
 */