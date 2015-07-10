/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0A00 extends JT808MsgBody
/*    */ {
/*    */   private int e;
/*    */   private byte[] n;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 14 */     if (!isBuildBody()) {
/* 15 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 16 */       this.bodyBuffer.putInt(this.e);
/* 17 */       this.bodyBuffer.put(this.n);
/* 18 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 24 */     this.e = this.bodyBuffer.getInt();
/* 25 */     this.n = new byte[''];
/* 26 */     this.bodyBuffer.get(this.n);
/* 27 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getE() {
/* 31 */     return this.e;
/*    */   }
/*    */ 
/*    */   public void setE(int e) {
/* 35 */     this.e = e;
/*    */   }
/*    */ 
/*    */   public byte[] getN() {
/* 39 */     return this.n;
/*    */   }
/*    */ 
/*    */   public void setN(byte[] n) {
/* 43 */     this.n = n;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0A00
 * JD-Core Version:    0.6.1
 */