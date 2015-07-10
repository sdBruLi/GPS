/*    */ package com.china317.core.codec.jtt808Gateway;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DataRow0012
/*    */ {
/*  6 */   private String sessionid = "";
/*  7 */   private int length = 0;
/*  8 */   private IoBuffer rowBuffer = null;
/*    */ 
/*    */   public String getSessionid() {
/* 11 */     return this.sessionid;
/*    */   }
/*    */ 
/*    */   public void setSessionid(String sessionid) {
/* 15 */     this.sessionid = sessionid;
/*    */   }
/*    */ 
/*    */   public int getLength() {
/* 19 */     return this.length;
/*    */   }
/*    */ 
/*    */   public void setLength(int length) {
/* 23 */     this.length = length;
/*    */   }
/*    */ 
/*    */   public IoBuffer getRowBuffer() {
/* 27 */     return this.rowBuffer;
/*    */   }
/*    */ 
/*    */   public void setRowBuffer(IoBuffer rowBuffer) {
/* 31 */     this.rowBuffer = rowBuffer;
/* 32 */     if (this.length == 0)
/* 33 */       this.length = this.rowBuffer.limit();
/*    */   }
/*    */ 
/*    */   public void setRowBuffer(byte[] rowBuffer) {
/* 37 */     this.rowBuffer = IoBuffer.allocate(rowBuffer.length);
/* 38 */     this.rowBuffer.put(rowBuffer);
/* 39 */     this.rowBuffer.flip();
/* 40 */     if (this.length == 0)
/* 41 */       this.length = this.rowBuffer.limit();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.DataRow0012
 * JD-Core Version:    0.6.1
 */