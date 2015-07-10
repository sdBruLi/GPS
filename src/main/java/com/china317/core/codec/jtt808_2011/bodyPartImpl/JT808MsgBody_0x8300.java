/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8300 extends JT808MsgBody
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
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!isBuildBody()) {
/* 30 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 31 */       this.bodyBuffer.put(this.sign);
/* 32 */       if ((this.textMessage != null) && (this.textMessage.length() > 0)) {
/* 33 */         this.bodyBuffer.put(this.textMessage.getBytes("GBK"));
/*    */       }
/* 35 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 41 */     this.sign = this.bodyBuffer.get();
/* 42 */     this.textMessage = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 43 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createTextMessage(String mobileNum, String info, byte msgType, byte terminalMonitor, byte tts, byte advPanel)
/*    */     throws Exception
/*    */   {
/* 59 */     UnitPackJT808 pack = new UnitPackJT808(33536);
/* 60 */     pack.setMobileNum(mobileNum);
/* 61 */     JT808MsgBody_0x8300 body = new JT808MsgBody_0x8300();
/* 62 */     body.setSign(getSign(msgType, terminalMonitor, tts, advPanel));
/* 63 */     body.setTextMessage(info);
/* 64 */     pack.setMsgBody(body);
/* 65 */     return pack;
/*    */   }
/*    */ 
/*    */   private static byte getSign(byte msgType, byte terminalMonitor, byte tts, byte advPanel) {
/* 69 */     byte sign = 0;
/* 70 */     sign = (byte)(msgType | terminalMonitor << 2 | tts << 3 | advPanel << 4);
/* 71 */     return sign;
/*    */   }
/*    */ 
/*    */   public byte getSign() {
/* 75 */     return this.sign;
/*    */   }
/*    */ 
/*    */   public void setSign(byte sign) {
/* 79 */     this.sign = sign;
/*    */   }
/*    */ 
/*    */   public String getTextMessage() {
/* 83 */     return this.textMessage;
/*    */   }
/*    */ 
/*    */   public void setTextMessage(String textMessage) {
/* 87 */     this.textMessage = textMessage;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8300
 * JD-Core Version:    0.6.1
 */