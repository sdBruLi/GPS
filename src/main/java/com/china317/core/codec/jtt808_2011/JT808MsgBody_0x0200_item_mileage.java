/*    */ package com.china317.core.codec.jtt808_2011;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0200_item_mileage extends JT808MsgBody
/*    */ {
/*    */   private int mileage;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 12 */     this.bodyBuffer = IoBuffer.allocate(4);
/* 13 */     this.bodyBuffer.putInt(this.mileage);
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 18 */     this.mileage = this.bodyBuffer.getInt();
/* 19 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getMileage() {
/* 23 */     return this.mileage;
/*    */   }
/*    */ 
/*    */   public void setMileage(int mileage) {
/* 27 */     this.mileage = mileage;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.JT808MsgBody_0x0200_item_mileage
 * JD-Core Version:    0.6.1
 */