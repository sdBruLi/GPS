/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8301_item extends JT808MsgBody
/*    */ {
/*    */   private int eventId;
/*    */   private byte eventContentLen;
/*    */   private String eventContent;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 16 */     if (!isBuildBody()) {
/* 17 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 18 */       this.bodyBuffer.putUnsigned(this.eventId);
/* 19 */       this.bodyBuffer.put(this.eventContentLen);
/* 20 */       if ((this.eventContentLen > 0) && (this.eventContent != null) && (this.eventContent.length() > 0)) {
/* 21 */         this.bodyBuffer.put(this.eventContent.getBytes("GBK"));
/*    */       }
/* 23 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 29 */     this.eventId = this.bodyBuffer.get();
/* 30 */     this.eventContentLen = this.bodyBuffer.get();
/* 31 */     this.eventContent = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 32 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getEventId() {
/* 36 */     return this.eventId;
/*    */   }
/*    */ 
/*    */   public void setEventId(int eventId) {
/* 40 */     this.eventId = eventId;
/*    */   }
/*    */ 
/*    */   public byte getEventContentLen() {
/* 44 */     return this.eventContentLen;
/*    */   }
/*    */ 
/*    */   public void setEventContentLen(byte eventContentLen) {
/* 48 */     this.eventContentLen = eventContentLen;
/*    */   }
/*    */ 
/*    */   public String getEventContent() {
/* 52 */     return this.eventContent;
/*    */   }
/*    */ 
/*    */   public void setEventContent(String eventContent) {
/* 56 */     this.eventContent = eventContent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8301_item
 * JD-Core Version:    0.6.1
 */