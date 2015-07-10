/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8804;
/*     */ 
/*     */ public class RecordingStartMessage extends BaseDownMessage
/*     */ {
/*     */   public static final byte RECORD_STOP = 0;
/*     */   public static final byte RECORD_START = 1;
/*     */   public static final byte STORE_REALTIME_UPLOAD = 0;
/*     */   public static final byte STORE_LOCAL = 1;
/*     */   public static final byte FREQUENCY_8K = 0;
/*     */   public static final byte FREQUENCY_11K = 1;
/*     */   public static final byte FREQUENCY_23K = 2;
/*     */   public static final byte FREQUENCY_32K = 3;
/*     */   private byte recordCommand;
/*     */   private short recordTime;
/*     */   private byte storeSign;
/*     */   private byte audioGatherFrequency;
/*     */ 
/*     */   public RecordingStartMessage(String mobileNum, String messageKey, byte recordCommand, short recordTime, byte storeSign, byte audioGatherFrequency)
/*     */   {
/*  48 */     setMobileNum(mobileNum);
/*  49 */     setMessageKey(messageKey);
/*  50 */     setRecordCommand(recordCommand);
/*  51 */     setRecordTime(recordTime);
/*  52 */     setStoreSign(storeSign);
/*  53 */     setAudioGatherFrequency(audioGatherFrequency);
/*  54 */     setCommand("0x8804");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception
/*     */   {
/*  59 */     UnitPackJT808 pack = new UnitPackJT808(34820);
/*  60 */     pack.setMobileNum(getMobileNum());
/*  61 */     JT808MsgBody_0x8804 body = new JT808MsgBody_0x8804();
/*  62 */     body.setRecordCommand(this.recordCommand);
/*  63 */     body.setRecordTime(this.recordTime);
/*  64 */     body.setStoreSign(this.storeSign);
/*  65 */     body.setAudioGatherFrequency(this.audioGatherFrequency);
/*  66 */     pack.setMsgBody(body);
/*  67 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getRecordCommand() {
/*  71 */     return this.recordCommand;
/*     */   }
/*     */ 
/*     */   public void setRecordCommand(byte recordCommand)
/*     */   {
/*  76 */     this.recordCommand = recordCommand;
/*     */   }
/*     */ 
/*     */   public short getRecordTime() {
/*  80 */     return this.recordTime;
/*     */   }
/*     */ 
/*     */   public void setRecordTime(short recordTime)
/*     */   {
/*  85 */     this.recordTime = recordTime;
/*     */   }
/*     */ 
/*     */   public byte getStoreSign() {
/*  89 */     return this.storeSign;
/*     */   }
/*     */ 
/*     */   public void setStoreSign(byte storeSign)
/*     */   {
/*  94 */     this.storeSign = storeSign;
/*     */   }
/*     */ 
/*     */   public byte getAudioGatherFrequency() {
/*  98 */     return this.audioGatherFrequency;
/*     */   }
/*     */ 
/*     */   public void setAudioGatherFrequency(byte audioGatherFrequency)
/*     */   {
/* 103 */     this.audioGatherFrequency = audioGatherFrequency;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.RecordingStartMessage
 * JD-Core Version:    0.6.1
 */