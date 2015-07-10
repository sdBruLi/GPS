/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8604_peak_item extends JT808MsgBody
/*    */ {
/*    */   private int peakLatitude;
/*    */   private int peakLongitude;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 14 */     if (!isBuildBody()) {
/* 15 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 16 */       this.bodyBuffer.putInt(this.peakLatitude);
/* 17 */       this.bodyBuffer.putInt(this.peakLongitude);
/* 18 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 24 */     this.peakLatitude = this.bodyBuffer.getInt();
/* 25 */     this.peakLongitude = this.bodyBuffer.getInt();
/* 26 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getPeakLatitude() {
/* 30 */     return this.peakLatitude;
/*    */   }
/*    */ 
/*    */   public void setPeakLatitude(int peakLatitude) {
/* 34 */     this.peakLatitude = peakLatitude;
/*    */   }
/*    */ 
/*    */   public int getPeakLongitude() {
/* 38 */     return this.peakLongitude;
/*    */   }
/*    */ 
/*    */   public void setPeakLongitude(int peakLongitude) {
/* 42 */     this.peakLongitude = peakLongitude;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8604_peak_item
 * JD-Core Version:    0.6.1
 */