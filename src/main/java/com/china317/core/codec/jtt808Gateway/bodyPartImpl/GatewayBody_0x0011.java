/*    */ package com.china317.core.codec.jtt808Gateway.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808Gateway.GatewayBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class GatewayBody_0x0011 extends GatewayBody
/*    */ {
/* 10 */   private String messageId = "";
/* 11 */   private String sessionid = "";
/* 12 */   private int length = 0;
/* 13 */   private IoBuffer rowBuffer = null;
/*    */ 
/*    */   public void bulidBody() throws Exception
/*    */   {
/* 17 */     if (!isBuildBody()) {
/* 18 */       this.bodyBuffer = IoBuffer.allocate(100).setAutoExpand(true);
/* 19 */       this.bodyBuffer.putString(this.messageId, 20, DefaultCharset.encoder);
/* 20 */       this.bodyBuffer.putString(this.sessionid, 12, DefaultCharset.encoder);
/* 21 */       this.bodyBuffer.putUnsignedShort(this.length);
/* 22 */       this.bodyBuffer.put(this.rowBuffer);
/* 23 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 29 */     this.messageId = this.bodyBuffer.getString(20, DefaultCharset.decoder);
/* 30 */     this.sessionid = this.bodyBuffer.getString(12, DefaultCharset.decoder);
/* 31 */     this.length = this.bodyBuffer.getUnsignedShort();
/* 32 */     this.rowBuffer = this.bodyBuffer.getSlice(this.length);
/* 33 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/*    */   }
/*    */ 
/*    */   public String getSessionid() {
/* 40 */     return this.sessionid;
/*    */   }
/*    */ 
/*    */   public void setSessionid(String sessionid) {
/* 44 */     this.sessionid = sessionid;
/*    */   }
/*    */ 
/*    */   public int getLength() {
/* 48 */     return this.length;
/*    */   }
/*    */ 
/*    */   public void setLength(int length) {
/* 52 */     this.length = length;
/*    */   }
/*    */ 
/*    */   public IoBuffer getRowBuffer() {
/* 56 */     return this.rowBuffer;
/*    */   }
/*    */ 
/*    */   public void setRowBuffer(IoBuffer rowBuffer) {
/* 60 */     this.rowBuffer = rowBuffer;
/* 61 */     if (this.length == 0)
/* 62 */       this.length = this.rowBuffer.limit();
/*    */   }
/*    */ 
/*    */   public String getMessageId()
/*    */   {
/* 67 */     return this.messageId;
/*    */   }
/*    */ 
/*    */   public void setMessageId(String messageId) {
/* 71 */     this.messageId = messageId;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0011
 * JD-Core Version:    0.6.1
 */