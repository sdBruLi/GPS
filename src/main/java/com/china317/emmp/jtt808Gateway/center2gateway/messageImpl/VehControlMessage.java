/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8500;
/*    */ 
/*    */ public class VehControlMessage extends BaseDownMessage
/*    */ {
/*    */   public static final byte DOOR_UNLOCK = 0;
/*    */   public static final byte DOOR_LOCK = 1;
/*    */   private byte controlSign;
/*    */ 
/*    */   public VehControlMessage(String mobileNum, String messageKey, byte controlSign)
/*    */   {
/* 29 */     setMobileNum(mobileNum);
/* 30 */     setMessageKey(messageKey);
/* 31 */     setControlSign(controlSign);
/* 32 */     setCommand("0x8500");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 37 */     UnitPackJT808 pack = new UnitPackJT808(34048);
/* 38 */     pack.setMobileNum(getMobileNum());
/* 39 */     JT808MsgBody_0x8500 body = new JT808MsgBody_0x8500();
/* 40 */     body.setControlSign(getControlSign());
/* 41 */     pack.setMsgBody(body);
/* 42 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getControlSign() {
/* 46 */     return this.controlSign;
/*    */   }
/*    */ 
/*    */   public void setControlSign(byte controlSign)
/*    */   {
/* 51 */     this.controlSign = controlSign;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.VehControlMessage
 * JD-Core Version:    0.6.1
 */