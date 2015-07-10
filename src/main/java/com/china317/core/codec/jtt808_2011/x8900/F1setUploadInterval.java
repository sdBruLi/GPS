/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1setUploadInterval extends F1MsgDataPack
/*    */ {
/*    */   private short interval;
/*    */ 
/*    */   public F1setUploadInterval(short interval)
/*    */   {
/* 17 */     super(32787, 0, null);
/* 18 */     this.interval = interval;
/*    */   }
/*    */ 
/*    */   public F1setUploadInterval(short interval, boolean f)
/*    */   {
/* 26 */     super(32771, 0, null);
/* 27 */     this.interval = interval;
/*    */   }
/*    */ 
/*    */   public short getInterval() {
/* 31 */     return this.interval;
/*    */   }
/*    */   public F1setUploadInterval(int len, IoBuffer data) {
/* 34 */     super(32771, len, data);
/*    */   }
/*    */   public F1setUploadInterval(int len, IoBuffer data, boolean f) {
/* 37 */     super(32787, len, data);
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void praser() throws Exception
/*    */   {
/* 43 */     this.interval = (short)this.data.getUnsignedShort();
/*    */   }
/*    */ 
/*    */   public void bulid() throws Exception
/*    */   {
/* 48 */     IoBuffer bodybuffer = IoBuffer.allocate(2);
/* 49 */     bodybuffer.putUnsignedShort(this.interval);
/* 50 */     bodybuffer.flip();
/* 51 */     super.bulid(bodybuffer);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1setUploadInterval
 * JD-Core Version:    0.6.1
 */