/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8400 extends JT808MsgBody
/*    */ {
/*    */   public static final byte PHONE_COMMON = 0;
/*    */   public static final byte PHONE_MONITOR = 1;
/*    */   private byte sign;
/*    */   private String phoneNum;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!isBuildBody()) {
/* 21 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 22 */       this.bodyBuffer.put(this.sign);
/* 23 */       if ((this.phoneNum != null) && (this.phoneNum.length() > 0)) {
/* 24 */         this.bodyBuffer.put(this.phoneNum.getBytes("GBK"));
/*    */       }
/* 26 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 32 */     this.sign = this.bodyBuffer.get();
/* 33 */     this.phoneNum = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 34 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createPhoneCallback(String mobileNum, byte sign, String phoneNum)
/*    */     throws Exception
/*    */   {
/* 47 */     UnitPackJT808 pack = new UnitPackJT808(33792);
/* 48 */     pack.setMobileNum(mobileNum);
/* 49 */     JT808MsgBody_0x8400 body = new JT808MsgBody_0x8400();
/* 50 */     body.setSign(sign);
/* 51 */     body.setPhoneNum(phoneNum);
/* 52 */     pack.setMsgBody(body);
/* 53 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getSign() {
/* 57 */     return this.sign;
/*    */   }
/*    */ 
/*    */   public void setSign(byte sign) {
/* 61 */     this.sign = sign;
/*    */   }
/*    */ 
/*    */   public String getPhoneNum() {
/* 65 */     return this.phoneNum;
/*    */   }
/*    */ 
/*    */   public void setPhoneNum(String phoneNum) {
/* 69 */     this.phoneNum = phoneNum;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8400
 * JD-Core Version:    0.6.1
 */