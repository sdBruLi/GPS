/*    */ package com.china317.core.codec.jtt808Gateway;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public abstract class GatewayBody
/*    */   implements UnitPackBody
/*    */ {
/*  8 */   protected IoBuffer bodyBuffer = null;
/*    */ 
/*    */   public abstract void bulidBody() throws Exception;
/*    */ 
/*    */   public abstract void praseBody() throws Exception;
/*    */ 
/*    */   public boolean isBuildBody() {
/* 15 */     if (this.bodyBuffer != null) {
/* 16 */       return true;
/*    */     }
/* 18 */     return false;
/*    */   }
/*    */ 
/*    */   public IoBuffer getBodyBuffer()
/*    */   {
/* 23 */     return this.bodyBuffer;
/*    */   }
/*    */ 
/*    */   public void setBodyBuffer(IoBuffer bodyBuffer) {
/* 27 */     this.bodyBuffer = bodyBuffer;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.GatewayBody
 * JD-Core Version:    0.6.1
 */