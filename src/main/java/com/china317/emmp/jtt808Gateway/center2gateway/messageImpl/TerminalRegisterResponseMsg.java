/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8100;
/*    */ 
/*    */ public class TerminalRegisterResponseMsg extends BaseDownMessage
/*    */ {
/*    */   public static final byte RESULT_OK = 0;
/*    */   public static final byte RESULT_VEH_HAS_REGISTERED = 1;
/*    */   public static final byte RESULT_DATABASE_NO_VEH = 2;
/*    */   public static final byte RESULT_TERMINAL_HAS_REGISTERED = 3;
/*    */   public static final byte RESULT_DATABASE_NO_TERMINAL = 4;
/*    */   private int responseSequenceNum;
/*    */   private byte result;
/*    */   private String authCode;
/*    */ 
/*    */   public TerminalRegisterResponseMsg(String mobileNum, String messageKey, int responseSequenceNum, int responseMsgID, byte result, String authCode)
/*    */   {
/* 30 */     setMobileNum(mobileNum);
/* 31 */     setMessageKey(messageKey);
/* 32 */     setResponseSequenceNum(responseSequenceNum);
/* 33 */     setResult(result);
/* 34 */     setAuthCode(authCode);
/* 35 */     setCommand("0x8100");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 40 */     UnitPackJT808 pack = new UnitPackJT808(33024);
/* 41 */     pack.setMobileNum(getMobileNum());
/* 42 */     JT808MsgBody_0x8100 body = new JT808MsgBody_0x8100();
/* 43 */     body.setResponseSequenceNum(getResponseSequenceNum());
/* 44 */     body.setResult(getResult());
/* 45 */     body.setAuthCode(getAuthCode());
/* 46 */     pack.setMsgBody(body);
/* 47 */     return pack;
/*    */   }
/*    */ 
/*    */   public int getResponseSequenceNum() {
/* 51 */     return this.responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public void setResponseSequenceNum(int responseSequenceNum)
/*    */   {
/* 56 */     this.responseSequenceNum = responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public byte getResult() {
/* 60 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result)
/*    */   {
/* 65 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public String getAuthCode() {
/* 69 */     return this.authCode;
/*    */   }
/*    */ 
/*    */   public void setAuthCode(String authCode)
/*    */   {
/* 74 */     this.authCode = authCode;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TerminalRegisterResponseMsg
 * JD-Core Version:    0.6.1
 */