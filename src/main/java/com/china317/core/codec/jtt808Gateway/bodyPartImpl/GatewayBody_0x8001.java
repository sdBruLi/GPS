/*    */ package com.china317.core.codec.jtt808Gateway.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808Gateway.GatewayBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class GatewayBody_0x8001 extends GatewayBody
/*    */ {
/*    */   public static final byte RESULT_OK = 0;
/*    */   public static final byte RESULT_FAILURE = 1;
/*    */   private int status;
/*    */   private String result;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!isBuildBody()) {
/* 18 */       this.bodyBuffer = IoBuffer.allocate(2 + this.result.getBytes().length);
/* 19 */       this.bodyBuffer.putUnsigned(this.status);
/* 20 */       this.bodyBuffer.putString(this.result, DefaultCharset.encoder);
/* 21 */       this.bodyBuffer.put((byte)0);
/* 22 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 28 */     this.status = this.bodyBuffer.getUnsigned();
/* 29 */     this.result = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 30 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getStatus() {
/* 34 */     return this.status;
/*    */   }
/*    */ 
/*    */   public void setStatus(int status) {
/* 38 */     this.status = status;
/*    */   }
/*    */ 
/*    */   public String getResult() {
/* 42 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(String result) {
/* 46 */     this.result = result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x8001
 * JD-Core Version:    0.6.1
 */