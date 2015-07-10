/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8400;
/*    */ 
/*    */ public class CallBackMessage extends BaseDownMessage
/*    */ {
/*    */   public static final byte PHONE_COMMON = 0;
/*    */   public static final byte PHONE_MONITOR = 1;
/*    */   private byte sign;
/*    */   private String phoneNum;
/*    */ 
/*    */   public CallBackMessage(String mobileNum, String messageKey, byte sign, String phoneNum)
/*    */   {
/* 34 */     setMobileNum(mobileNum);
/* 35 */     setMessageKey(messageKey);
/* 36 */     setSign(sign);
/* 37 */     setPhoneNum(phoneNum);
/* 38 */     setCommand("0x8400");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 43 */     UnitPackJT808 pack = new UnitPackJT808(33792);
/* 44 */     pack.setMobileNum(getMobileNum());
/* 45 */     JT808MsgBody_0x8400 body = new JT808MsgBody_0x8400();
/* 46 */     body.setSign(getSign());
/* 47 */     body.setPhoneNum(getPhoneNum());
/* 48 */     pack.setMsgBody(body);
/* 49 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getSign() {
/* 53 */     return this.sign;
/*    */   }
/*    */ 
/*    */   public void setSign(byte sign)
/*    */   {
/* 58 */     this.sign = sign;
/*    */   }
/*    */ 
/*    */   public String getPhoneNum() {
/* 62 */     return this.phoneNum;
/*    */   }
/*    */ 
/*    */   public void setPhoneNum(String phoneNum)
/*    */   {
/* 67 */     this.phoneNum = phoneNum;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.CallBackMessage
 * JD-Core Version:    0.6.1
 */