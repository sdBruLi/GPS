/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0901 extends JT808MsgBody
/*    */ {
/*    */   private int compressionDataLen;
/*    */   private IoBuffer compressionData;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 14 */     if (!isBuildBody()) {
/* 15 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 16 */       this.bodyBuffer.putInt(this.compressionDataLen);
/* 17 */       this.bodyBuffer.put(this.compressionData);
/* 18 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 24 */     this.compressionDataLen = this.bodyBuffer.getInt();
/* 25 */     this.compressionData = this.bodyBuffer.getSlice(this.bodyBuffer.limit() - 4);
/* 26 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getCompressionDataLen() {
/* 30 */     return this.compressionDataLen;
/*    */   }
/*    */ 
/*    */   public void setCompressionDataLen(int compressionDataLen) {
/* 34 */     this.compressionDataLen = compressionDataLen;
/*    */   }
/*    */ 
/*    */   public IoBuffer getCompressionData() {
/* 38 */     return this.compressionData;
/*    */   }
/*    */ 
/*    */   public void setCompressionData(IoBuffer compressionData) {
/* 42 */     this.compressionData = compressionData;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0901
 * JD-Core Version:    0.6.1
 */