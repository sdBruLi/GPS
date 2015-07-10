/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0200_item_alarmId_ack extends JT808MsgBody
/*    */ {
/*    */   private short alarmId;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 14 */     this.alarmId = this.bodyBuffer.getShort();
/* 15 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public short getAlarmId() {
/* 19 */     return this.alarmId;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_alarmId_ack
 * JD-Core Version:    0.6.1
 */