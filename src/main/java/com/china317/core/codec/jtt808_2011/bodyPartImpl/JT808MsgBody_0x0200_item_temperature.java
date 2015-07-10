/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0200_item_temperature extends JT808MsgBody
/*    */ {
/*    */   private float temperature;
/*    */   private short sign;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 15 */     this.temperature = this.bodyBuffer.getShort();
/* 16 */     this.sign = (short)(this.bodyBuffer.get() & 0xFF);
/*    */ 
/* 18 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public float getTemperature() {
/* 22 */     return this.temperature;
/*    */   }
/*    */ 
/*    */   public short getSign() {
/* 26 */     return this.sign;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_temperature
 * JD-Core Version:    0.6.1
 */