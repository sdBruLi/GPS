/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0200_item_overspeed_alarm extends JT808MsgBody
/*    */ {
/*    */   private byte positonType;
/*    */   private int regionId;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 15 */     this.positonType = this.bodyBuffer.get();
/* 16 */     if (this.positonType != 0) {
/* 17 */       this.regionId = this.bodyBuffer.getInt();
/*    */     }
/* 19 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public byte getPositonType() {
/* 23 */     return this.positonType;
/*    */   }
/*    */ 
/*    */   public int getRegionId() {
/* 27 */     return this.regionId;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_overspeed_alarm
 * JD-Core Version:    0.6.1
 */