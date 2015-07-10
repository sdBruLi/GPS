/*    */ package com.china317.core.codec.jtt808Gateway.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808Gateway.GatewayBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class GatewayBody_0x0001 extends GatewayBody
/*    */ {
/*    */   private String code;
/*    */   private int type;
/*    */   private int ver;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 16 */     if (!isBuildBody()) {
/* 17 */       this.bodyBuffer = IoBuffer.allocate(19);
/* 18 */       this.bodyBuffer.putString(this.code, 16, DefaultCharset.encoder);
/* 19 */       this.bodyBuffer.putUnsigned(this.type);
/* 20 */       this.bodyBuffer.putUnsignedShort(this.ver);
/* 21 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 27 */     this.code = this.bodyBuffer.getString(16, DefaultCharset.decoder);
/* 28 */     this.type = this.bodyBuffer.getUnsigned();
/* 29 */     this.ver = this.bodyBuffer.getUnsignedShort();
/* 30 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/*    */   }
/*    */ 
/*    */   public String getCode() {
/* 37 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(String code) {
/* 41 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public int getType() {
/* 45 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(int type) {
/* 49 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public int getVer() {
/* 53 */     return this.ver;
/*    */   }
/*    */ 
/*    */   public void setVer(int ver) {
/* 57 */     this.ver = ver;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0001
 * JD-Core Version:    0.6.1
 */