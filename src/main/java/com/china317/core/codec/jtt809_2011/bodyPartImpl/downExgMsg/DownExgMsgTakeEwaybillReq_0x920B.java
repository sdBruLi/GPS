/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg;
/*    */ 
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownExgMsgTakeEwaybillReq_0x920B extends DownExgMsgHead
/*    */ {
/*    */   public DownExgMsgTakeEwaybillReq_0x920B()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownExgMsgTakeEwaybillReq_0x920B(int msgId)
/*    */   {
/* 14 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception {
/* 18 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 19 */     setDatalength(0);
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
/*    */   private void buildLastBody(IoBuffer buffer)
/*    */     throws CharacterCodingException
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 38 */     return 37387;
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
/*    */   }
/*    */ 
/*    */   private void initBytes()
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgTakeEwaybillReq_0x920B
 * JD-Core Version:    0.6.1
 */