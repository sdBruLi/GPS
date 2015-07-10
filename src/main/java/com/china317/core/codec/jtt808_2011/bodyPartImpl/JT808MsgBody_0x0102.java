/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0102 extends JT808MsgBody
/*    */ {
/*  9 */   private String authCode = "";
/*    */ 
/*    */   public void bulidBody() throws Exception
/*    */   {
/* 13 */     if (!isBuildBody()) {
/* 14 */       this.bodyBuffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 15 */       if ((this.authCode != null) && (this.authCode.length() > 0)) {
/* 16 */         this.bodyBuffer.put(this.authCode.getBytes("GBK"));
/*    */       }
/* 18 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 24 */     this.authCode = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 25 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public String getAuthCode() {
/* 29 */     return this.authCode;
/*    */   }
/*    */ 
/*    */   public void setAuthCode(String authCode) {
/* 33 */     this.authCode = authCode;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0102
 * JD-Core Version:    0.6.1
 */