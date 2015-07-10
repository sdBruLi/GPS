/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownLinktestReq_0x9005 extends DataPacketBodyPart
/*    */ {
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 23 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*    */ 
/* 25 */     buffer.flip();
/* 26 */     byte[] bytes = new byte[buffer.remaining()];
/* 27 */     buffer.get(bytes);
/* 28 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 33 */     return 36869;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 37 */     return super.toString();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 41 */     DownLinktestReq_0x9005 entity = new DownLinktestReq_0x9005();
/*    */ 
/* 44 */     DownLinktestReq_0x9005 entity2 = new DownLinktestReq_0x9005();
/* 45 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.DownLinktestReq_0x9005
 * JD-Core Version:    0.6.1
 */