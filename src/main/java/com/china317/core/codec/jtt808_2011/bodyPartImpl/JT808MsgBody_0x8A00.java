/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8A00 extends JT808MsgBody
/*    */ {
/*    */   private int e;
/*    */   private byte[] n;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 16 */     if (!isBuildBody()) {
/* 17 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 18 */       this.bodyBuffer.putInt(this.e);
/* 19 */       this.bodyBuffer.put(this.n);
/* 20 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 26 */     this.e = this.bodyBuffer.getInt();
/* 27 */     this.n = new byte[''];
/* 28 */     this.bodyBuffer.get(this.n);
/* 29 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createPlatformRSA(String mobileNum, int e, byte[] n)
/*    */     throws Exception
/*    */   {
/* 41 */     UnitPackJT808 pack = new UnitPackJT808(35328);
/* 42 */     pack.setMobileNum(mobileNum);
/* 43 */     JT808MsgBody_0x8A00 body = new JT808MsgBody_0x8A00();
/* 44 */     body.setE(e);
/* 45 */     body.setN(n);
/* 46 */     pack.setMsgBody(body);
/* 47 */     return pack;
/*    */   }
/*    */   public int getE() {
/* 50 */     return this.e;
/*    */   }
/*    */ 
/*    */   public void setE(int e) {
/* 54 */     this.e = e;
/*    */   }
/*    */ 
/*    */   public byte[] getN() {
/* 58 */     return this.n;
/*    */   }
/*    */ 
/*    */   public void setN(byte[] n) {
/* 62 */     this.n = n;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8A00
 * JD-Core Version:    0.6.1
 */