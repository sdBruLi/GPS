/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0301 extends JT808MsgBody
/*    */ {
/*    */   private int eventId;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 14 */     this.eventId = this.bodyBuffer.getUnsigned();
/* 15 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getEventId() {
/* 19 */     return this.eventId;
/*    */   }
/*    */ 
/*    */   public void setEventId(int eventId) {
/* 23 */     this.eventId = eventId;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0301
 * JD-Core Version:    0.6.1
 */