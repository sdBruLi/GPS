/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0200_item_sensorSpeed extends JT808MsgBody
/*    */ {
/*    */   private short sensorSpeed;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 14 */     this.sensorSpeed = this.bodyBuffer.getShort();
/* 15 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getSensorSpeed() {
/* 19 */     return this.sensorSpeed;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_sensorSpeed
 * JD-Core Version:    0.6.1
 */