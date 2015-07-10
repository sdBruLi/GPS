/*    */ package com.china317.core.codec.jtt808_2011;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public abstract class JT808MsgBody
/*    */   implements UnitPackBody
/*    */ {
/*  6 */   protected IoBuffer bodyBuffer = null;
/*    */ 
/*    */   public abstract void bulidBody() throws Exception;
/*    */ 
/*    */   public abstract void praseBody() throws Exception;
/*    */ 
/*    */   public boolean isBuildBody() {
/* 13 */     if (this.bodyBuffer != null) {
/* 14 */       return true;
/*    */     }
/* 16 */     return false;
/*    */   }
/*    */ 
/*    */   public IoBuffer getBodyBuffer()
/*    */   {
/* 21 */     return this.bodyBuffer;
/*    */   }
/*    */ 
/*    */   public void setBodyBuffer(IoBuffer bodyBuffer) {
/* 25 */     this.bodyBuffer = bodyBuffer;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.JT808MsgBody
 * JD-Core Version:    0.6.1
 */