/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpLinkTestRsp_0x1006 extends DataPacketBodyPart
/*    */ {
/*    */   public byte[] buildBody()
/*    */   {
/* 12 */     IoBuffer buffer = IoBuffer.allocate(1).setAutoExpand(true);
/* 13 */     buffer.flip();
/* 14 */     byte[] bytes = new byte[buffer.remaining()];
/* 15 */     buffer.get(bytes);
/* 16 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 22 */     return 4102;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.UpLinkTestRsp_0x1006
 * JD-Core Version:    0.6.1
 */