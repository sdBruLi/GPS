/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8804 extends JT808MsgBody
/*    */ {
/*    */   public static final byte RECORD_STOP = 0;
/*    */   public static final byte RECORD_START = 1;
/*    */   public static final byte STORE_REALTIME_UPLOAD = 0;
/*    */   public static final byte STORE_LOCAL = 1;
/*    */   public static final byte FREQUENCY_8K = 0;
/*    */   public static final byte FREQUENCY_11K = 1;
/*    */   public static final byte FREQUENCY_23K = 2;
/*    */   public static final byte FREQUENCY_32K = 3;
/*    */   private byte recordCommand;
/*    */   private short recordTime;
/*    */   private byte storeSign;
/*    */   private byte audioGatherFrequency;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!isBuildBody()) {
/* 28 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 29 */       this.bodyBuffer.put(this.recordCommand);
/* 30 */       this.bodyBuffer.putShort(this.recordTime);
/* 31 */       this.bodyBuffer.put(this.storeSign);
/* 32 */       this.bodyBuffer.put(this.audioGatherFrequency);
/* 33 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 39 */     this.recordCommand = this.bodyBuffer.get();
/* 40 */     this.recordTime = this.bodyBuffer.getShort();
/* 41 */     this.storeSign = this.bodyBuffer.get();
/* 42 */     this.audioGatherFrequency = this.bodyBuffer.get();
/* 43 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createAudioStartCommand(String mobileNum, byte recordCommand, short recordTime, byte storeSign, byte audioGatherFrequency)
/*    */     throws Exception
/*    */   {
/* 58 */     UnitPackJT808 pack = new UnitPackJT808(34820);
/* 59 */     pack.setMobileNum(mobileNum);
/* 60 */     JT808MsgBody_0x8804 body = new JT808MsgBody_0x8804();
/* 61 */     body.setRecordCommand(recordCommand);
/* 62 */     body.setRecordTime(recordTime);
/* 63 */     body.setStoreSign(storeSign);
/* 64 */     body.setAudioGatherFrequency(audioGatherFrequency);
/* 65 */     pack.setMsgBody(body);
/* 66 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getRecordCommand() {
/* 70 */     return this.recordCommand;
/*    */   }
/*    */ 
/*    */   public void setRecordCommand(byte recordCommand) {
/* 74 */     this.recordCommand = recordCommand;
/*    */   }
/*    */ 
/*    */   public short getRecordTime() {
/* 78 */     return this.recordTime;
/*    */   }
/*    */ 
/*    */   public void setRecordTime(short recordTime) {
/* 82 */     this.recordTime = recordTime;
/*    */   }
/*    */ 
/*    */   public byte getStoreSign() {
/* 86 */     return this.storeSign;
/*    */   }
/*    */ 
/*    */   public void setStoreSign(byte storeSign) {
/* 90 */     this.storeSign = storeSign;
/*    */   }
/*    */ 
/*    */   public byte getAudioGatherFrequency() {
/* 94 */     return this.audioGatherFrequency;
/*    */   }
/*    */ 
/*    */   public void setAudioGatherFrequency(byte audioGatherFrequency) {
/* 98 */     this.audioGatherFrequency = audioGatherFrequency;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8804
 * JD-Core Version:    0.6.1
 */