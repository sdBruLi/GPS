/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8A00;
/*    */ 
/*    */ public class PlatformRSAMessage extends BaseDownMessage
/*    */ {
/*    */   private int e;
/*    */   private byte[] n;
/*    */ 
/*    */   public PlatformRSAMessage(String mobileNum, String messageKey, int e, byte[] n)
/*    */   {
/* 27 */     setMobileNum(mobileNum);
/* 28 */     setMessageKey(messageKey);
/* 29 */     setE(e);
/* 30 */     setN(n);
/* 31 */     setCommand("0x8A00");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 36 */     UnitPackJT808 pack = new UnitPackJT808(35328);
/* 37 */     pack.setMobileNum(getMobileNum());
/* 38 */     JT808MsgBody_0x8A00 body = new JT808MsgBody_0x8A00();
/* 39 */     body.setE(this.e);
/* 40 */     body.setN(this.n);
/* 41 */     pack.setMsgBody(body);
/* 42 */     return pack;
/*    */   }
/*    */ 
/*    */   public int getE() {
/* 46 */     return this.e;
/*    */   }
/*    */ 
/*    */   public void setE(int e) {
/* 50 */     this.e = e;
/*    */   }
/*    */ 
/*    */   public byte[] getN() {
/* 54 */     return this.n;
/*    */   }
/*    */ 
/*    */   public void setN(byte[] n) {
/* 58 */     this.n = n;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.PlatformRSAMessage
 * JD-Core Version:    0.6.1
 */