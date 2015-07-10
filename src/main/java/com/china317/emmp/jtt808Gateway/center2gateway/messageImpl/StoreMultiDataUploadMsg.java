/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8803;
/*     */ 
/*     */ public class StoreMultiDataUploadMsg extends BaseDownMessage
/*     */ {
/*     */   public static final byte MULTIMEDIA_TYPE_IMAGE = 0;
/*     */   public static final byte MULTIMEDIA_TYPE_AUDIO = 1;
/*     */   public static final byte MULTIMEDIA_TYPE_VIDEO = 2;
/*     */   public static final byte MULTIMEDIA_FORMAT_JPEG = 0;
/*     */   public static final byte MULTIMEDIA_FORMAT_TIF = 1;
/*     */   public static final byte MULTIMEDIA_FORMAT_MP3 = 2;
/*     */   public static final byte MULTIMEDIA_FORMAT_WAV = 3;
/*     */   public static final byte MULTIMEDIA_FORMAT_WMV = 4;
/*     */   public static final byte EVENT_ITEM_CODING_PLATFORM = 0;
/*     */   public static final byte EVENT_ITEM_CODING_TIMING = 1;
/*     */   public static final byte EVENT_ITEM_CODING_ALERT_ROBBERY = 2;
/*     */   public static final byte EVENT_ITEM_CODING_CRASH = 3;
/*     */   public static final byte DEL_SIGN_ON = 1;
/*     */   public static final byte DEL_SIGN_OFF = 0;
/*     */   private byte multimediaType;
/*     */   private byte channelID;
/*     */   private byte eventItemCoding;
/*     */   private String startTime;
/*     */   private String stopTime;
/*     */   private byte delSign;
/*     */ 
/*     */   public StoreMultiDataUploadMsg(String mobileNum, String messageKey, byte multimediaType, byte channelID, byte eventItemCoding, String startTime, String stopTime, byte delSign)
/*     */   {
/*  56 */     setMobileNum(mobileNum);
/*  57 */     setMessageKey(messageKey);
/*  58 */     setChannelID(channelID);
/*  59 */     setEventItemCoding(eventItemCoding);
/*  60 */     setMultimediaType(multimediaType);
/*  61 */     setStartTime(startTime);
/*  62 */     setStopTime(stopTime);
/*  63 */     setDelSign(delSign);
/*  64 */     setCommand("0x8803");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception
/*     */   {
/*  69 */     UnitPackJT808 pack = new UnitPackJT808(34819);
/*  70 */     pack.setMobileNum(getMobileNum());
/*  71 */     JT808MsgBody_0x8803 body = new JT808MsgBody_0x8803();
/*  72 */     body.setMultimediaType(this.multimediaType);
/*  73 */     body.setChannelID(this.channelID);
/*  74 */     body.setEventItemCoding(this.eventItemCoding);
/*  75 */     body.setStartTime(this.startTime);
/*  76 */     body.setStopTime(this.stopTime);
/*  77 */     body.setDelSign(this.delSign);
/*  78 */     pack.setMsgBody(body);
/*  79 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getMultimediaType() {
/*  83 */     return this.multimediaType;
/*     */   }
/*     */ 
/*     */   public void setMultimediaType(byte multimediaType)
/*     */   {
/*  88 */     this.multimediaType = multimediaType;
/*     */   }
/*     */ 
/*     */   public byte getEventItemCoding() {
/*  92 */     return this.eventItemCoding;
/*     */   }
/*     */ 
/*     */   public void setEventItemCoding(byte eventItemCoding)
/*     */   {
/*  97 */     this.eventItemCoding = eventItemCoding;
/*     */   }
/*     */ 
/*     */   public byte getChannelID() {
/* 101 */     return this.channelID;
/*     */   }
/*     */ 
/*     */   public void setChannelID(byte channelID)
/*     */   {
/* 106 */     this.channelID = channelID;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/* 110 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime)
/*     */   {
/* 115 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 119 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime)
/*     */   {
/* 124 */     this.stopTime = stopTime;
/*     */   }
/*     */ 
/*     */   public byte getDelSign() {
/* 128 */     return this.delSign;
/*     */   }
/*     */ 
/*     */   public void setDelSign(byte delSign)
/*     */   {
/* 133 */     this.delSign = delSign;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.StoreMultiDataUploadMsg
 * JD-Core Version:    0.6.1
 */