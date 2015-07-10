/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpExgMsgReturnEndAck_0x1206 extends UpExgMsgHead
/*    */ {
/*    */   public UpExgMsgReturnEndAck_0x1206()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpExgMsgReturnEndAck_0x1206(int msgId)
/*    */   {
/* 11 */     super.setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception
/*    */   {
/* 16 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 17 */     setDatalength(0);
/* 18 */     buildFirstBody(buffer);
/*    */ 
/* 20 */     buffer.flip();
/* 21 */     byte[] bytes = new byte[buffer.remaining()];
/* 22 */     buffer.get(bytes);
/* 23 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 29 */     return 4614;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 34 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 35 */     parseFirstBody(buffer);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgReturnEndAck_0x1206
 * JD-Core Version:    0.6.1
 */