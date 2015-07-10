/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8202 extends JT808MsgBody
/*    */ {
/*    */   public static final byte STOP_TRACE = 0;
/*    */   private short interval;
/*    */   private int availablePeriod;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 19 */     if (!isBuildBody()) {
/* 20 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 21 */       this.bodyBuffer.putShort(this.interval);
/* 22 */       if (this.interval != 0) {
/* 23 */         this.bodyBuffer.putInt(this.availablePeriod);
/*    */       }
/* 25 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 31 */     this.interval = (short)this.bodyBuffer.getUnsignedShort();
/* 32 */     this.availablePeriod = this.bodyBuffer.getInt();
/* 33 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 traceTemporaryPostion(String mobileNum, short interval, int availablePeriod)
/*    */     throws Exception
/*    */   {
/* 45 */     UnitPackJT808 pack = new UnitPackJT808(33282);
/* 46 */     pack.setMobileNum(mobileNum);
/* 47 */     JT808MsgBody_0x8202 body = new JT808MsgBody_0x8202();
/* 48 */     body.setInterval(interval);
/* 49 */     body.setAvailablePeriod(availablePeriod);
/* 50 */     pack.setMsgBody(body);
/* 51 */     return pack;
/*    */   }
/*    */ 
/*    */   public short getInterval() {
/* 55 */     return this.interval;
/*    */   }
/*    */ 
/*    */   public void setInterval(short interval) {
/* 59 */     this.interval = interval;
/*    */   }
/*    */ 
/*    */   public int getAvailablePeriod() {
/* 63 */     return this.availablePeriod;
/*    */   }
/*    */ 
/*    */   public void setAvailablePeriod(int availablePeriod) {
/* 67 */     this.availablePeriod = availablePeriod;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8202
 * JD-Core Version:    0.6.1
 */