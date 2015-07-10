/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8300;
/*    */ 
/*    */ public class SendTextMessage extends BaseDownMessage
/*    */ {
/*    */   public static final byte MSG_TYPE_URGENT = 1;
/*    */   public static final byte MSG_TYPE_COMMON = 0;
/*    */   public static final byte TERMINAL_MONITOR_ON = 1;
/*    */   public static final byte TERMINAL_MONITOR_OFF = 0;
/*    */   public static final byte TTS_ON = 1;
/*    */   public static final byte TTS_OFF = 0;
/*    */   public static final byte ADV_PANEL_ON = 1;
/*    */   public static final byte ADV_PANEL_OFF = 0;
/*    */   private byte sign;
/*    */   private String textMessage;
/*    */ 
/*    */   public SendTextMessage(String mobileNum, String messageKey, String info, byte msgType, byte terminalMonitor, byte tts, byte advPanel)
/*    */   {
/* 40 */     setMobileNum(mobileNum);
/* 41 */     setMessageKey(messageKey);
/* 42 */     setTextMessage(info);
/* 43 */     setSign(getSign(msgType, terminalMonitor, tts, advPanel));
/* 44 */     setCommand("0x8300");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception {
/* 48 */     UnitPackJT808 pack = new UnitPackJT808(33536);
/* 49 */     pack.setMobileNum(getMobileNum());
/* 50 */     JT808MsgBody_0x8300 body = new JT808MsgBody_0x8300();
/* 51 */     body.setSign(getSign());
/* 52 */     body.setTextMessage(getTextMessage());
/* 53 */     pack.setMsgBody(body);
/* 54 */     return pack;
/*    */   }
/*    */ 
/*    */   private static byte getSign(byte msgType, byte terminalMonitor, byte tts, byte advPanel) {
/* 58 */     byte sign = 0;
/* 59 */     sign = (byte)(msgType | terminalMonitor << 2 | tts << 3 | advPanel << 4);
/* 60 */     return sign;
/*    */   }
/*    */ 
/*    */   public byte getSign() {
/* 64 */     return this.sign;
/*    */   }
/*    */ 
/*    */   public void setSign(byte sign)
/*    */   {
/* 69 */     this.sign = sign;
/*    */   }
/*    */ 
/*    */   public String getTextMessage() {
/* 73 */     return this.textMessage;
/*    */   }
/*    */ 
/*    */   public void setTextMessage(String textMessage)
/*    */   {
/* 78 */     this.textMessage = textMessage;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SendTextMessage
 * JD-Core Version:    0.6.1
 */