/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1openCofferResponse extends F1MsgDataPack
/*    */ {
/*    */   private byte result;
/*    */ 
/*    */   public F1openCofferResponse(byte result)
/*    */   {
/* 14 */     super(32792, 0, null);
/* 15 */     this.result = result;
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void praser() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void bulid() throws Exception
/*    */   {
/* 25 */     IoBuffer bodybuffer = IoBuffer.allocate(1);
/* 26 */     bodybuffer.put(this.result);
/* 27 */     bodybuffer.flip();
/* 28 */     super.bulid(bodybuffer);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1openCofferResponse
 * JD-Core Version:    0.6.1
 */