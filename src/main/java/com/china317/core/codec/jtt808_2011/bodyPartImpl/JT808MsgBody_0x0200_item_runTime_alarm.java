/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0200_item_runTime_alarm extends JT808MsgBody
/*    */ {
/*    */   private int regionId;
/*    */   private short runTime;
/*    */   private byte result;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 16 */     this.regionId = this.bodyBuffer.getInt();
/* 17 */     this.runTime = this.bodyBuffer.getShort();
/* 18 */     this.result = this.bodyBuffer.get();
/* 19 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getRegionId() {
/* 23 */     return this.regionId;
/*    */   }
/*    */ 
/*    */   public byte getResult() {
/* 27 */     return this.result;
/*    */   }
/*    */ 
/*    */   public short getRunTime() {
/* 31 */     return this.runTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_runTime_alarm
 * JD-Core Version:    0.6.1
 */