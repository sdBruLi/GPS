/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8302_AnswerItem extends JT808MsgBody
/*    */ {
/*    */   private byte answerId;
/*    */   private short answerContentLen;
/*    */   private String answerContent;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 16 */     if (!isBuildBody()) {
/* 17 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 18 */       this.bodyBuffer.put(this.answerId);
/* 19 */       this.bodyBuffer.putShort(this.answerContentLen);
/* 20 */       if ((this.answerContent != null) && (this.answerContent.length() > 0)) {
/* 21 */         this.bodyBuffer.put(this.answerContent.getBytes("GBK"));
/*    */       }
/* 23 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 29 */     this.answerId = this.bodyBuffer.get();
/* 30 */     this.answerContentLen = this.bodyBuffer.getShort();
/* 31 */     this.answerContent = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 32 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public byte getAnswerId() {
/* 36 */     return this.answerId;
/*    */   }
/*    */ 
/*    */   public void setAnswerId(byte answerId) {
/* 40 */     this.answerId = answerId;
/*    */   }
/*    */ 
/*    */   public short getAnswerContentLen() {
/* 44 */     return this.answerContentLen;
/*    */   }
/*    */ 
/*    */   public void setAnswerContentLen(short answerContentLen) {
/* 48 */     this.answerContentLen = answerContentLen;
/*    */   }
/*    */ 
/*    */   public String getAnswerContent() {
/* 52 */     return this.answerContent;
/*    */   }
/*    */ 
/*    */   public void setAnswerContent(String answerContent) {
/* 56 */     this.answerContent = answerContent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8302_AnswerItem
 * JD-Core Version:    0.6.1
 */