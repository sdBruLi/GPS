/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg;
/*    */ 
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownExgMsgReportDriverInfo_0x920A extends DownExgMsgHead
/*    */ {
/*    */   public DownExgMsgReportDriverInfo_0x920A()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownExgMsgReportDriverInfo_0x920A(int msgId)
/*    */   {
/* 13 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception {
/* 17 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 18 */     setDatalength(0);
/*    */ 
/* 20 */     buildFirstBody(buffer);
/*    */ 
/* 22 */     buildLastBody(buffer);
/*    */ 
/* 24 */     buffer.flip();
/* 25 */     byte[] bytes = new byte[buffer.remaining()];
/* 26 */     buffer.get(bytes);
/* 27 */     return bytes;
/*    */   }
/*    */ 
/*    */   private void buildLastBody(IoBuffer buffer)
/*    */     throws CharacterCodingException
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 37 */     return 37386;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 42 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 43 */     parseFirstBody(buffer);
/*    */ 
/* 45 */     parseLocationBody(buffer);
/*    */   }
/*    */ 
/*    */   public void parseLocationBody(IoBuffer buffer)
/*    */     throws CharacterCodingException
/*    */   {
/* 51 */     initBytes();
/*    */   }
/*    */ 
/*    */   private void initBytes()
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgReportDriverInfo_0x920A
 * JD-Core Version:    0.6.1
 */