/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpExgMsgApplyForMonitorEnd_0x1208 extends UpExgMsgHead
/*    */ {
/*    */   public UpExgMsgApplyForMonitorEnd_0x1208()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpExgMsgApplyForMonitorEnd_0x1208(int dataType)
/*    */   {
/* 12 */     super(dataType);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception
/*    */   {
/* 17 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 18 */     setDatalength(0);
/* 19 */     buildFirstBody(buffer);
/*    */ 
/* 21 */     buffer.flip();
/* 22 */     byte[] bytes = new byte[buffer.remaining()];
/* 23 */     buffer.get(bytes);
/* 24 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 30 */     return 4616;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 35 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 36 */     parseFirstBody(buffer);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgApplyForMonitorEnd_0x1208
 * JD-Core Version:    0.6.1
 */