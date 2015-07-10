/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8100 extends JT808MsgBody
/*    */ {
/*    */   public static final byte RESULT_OK = 0;
/*    */   public static final byte RESULT_VEH_HAS_REGISTERED = 1;
/*    */   public static final byte RESULT_DATABASE_NO_VEH = 2;
/*    */   public static final byte RESULT_TERMINAL_HAS_REGISTERED = 3;
/*    */   public static final byte RESULT_DATABASE_NO_TERMINAL = 4;
/*    */   private int responseSequenceNum;
/*    */   private byte result;
/* 19 */   private String authCode = "";
/*    */ 
/*    */   public int getResponseSequenceNum() {
/* 22 */     return this.responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public void setResponseSequenceNum(int responseSequenceNum) {
/* 26 */     this.responseSequenceNum = responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public byte getResult() {
/* 30 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 34 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public String getAuthCode() {
/* 38 */     return this.authCode;
/*    */   }
/*    */ 
/*    */   public void setAuthCode(String authCode) {
/* 42 */     this.authCode = authCode;
/*    */   }
/*    */ 
/*    */   public void bulidBody() throws Exception
/*    */   {
/* 47 */     if (!isBuildBody()) {
/* 48 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 49 */       this.bodyBuffer.putUnsignedShort(this.responseSequenceNum);
/* 50 */       this.bodyBuffer.put(this.result);
/* 51 */       if ((this.authCode != null) && (this.authCode.length() > 0)) {
/* 52 */         this.bodyBuffer.put(this.authCode.getBytes("GBK"));
/*    */       }
/* 54 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 60 */     this.responseSequenceNum = this.bodyBuffer.getUnsignedShort();
/* 61 */     this.result = this.bodyBuffer.get();
/* 62 */     this.authCode = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 63 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createRegisterResponsePack(String mobileNum, byte result, int responseSeqnum, String authCode) throws Exception {
/* 67 */     UnitPackJT808 pack = new UnitPackJT808(
/* 68 */       33024);
/* 69 */     pack.setMobileNum(mobileNum);
/* 70 */     JT808MsgBody_0x8100 body = new JT808MsgBody_0x8100();
/* 71 */     body.setResponseSequenceNum(responseSeqnum);
/* 72 */     body.setResult(result);
/* 73 */     body.setAuthCode(authCode);
/* 74 */     pack.setMsgBody(body);
/* 75 */     return pack;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8100
 * JD-Core Version:    0.6.1
 */