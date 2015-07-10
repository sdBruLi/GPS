/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8802;
/*     */ 
/*     */ public class StoreMultiDataSearchMsg extends BaseDownMessage
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
/*     */   private byte multimediaType;
/*     */   private byte channelID;
/*     */   private byte eventItemCoding;
/*     */   private String startTime;
/*     */   private String stopTime;
/*     */ 
/*     */   public StoreMultiDataSearchMsg(String mobileNum, String messageKey, byte multimediaType, byte channelID, byte eventItemCoding, String startTime, String stopTime)
/*     */   {
/*  50 */     setMobileNum(mobileNum);
/*  51 */     setMessageKey(messageKey);
/*  52 */     setChannelID(channelID);
/*  53 */     setEventItemCoding(eventItemCoding);
/*  54 */     setMultimediaType(multimediaType);
/*  55 */     setStartTime(startTime);
/*  56 */     setStopTime(stopTime);
/*  57 */     setCommand("0x8802");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception
/*     */   {
/*  62 */     UnitPackJT808 pack = new UnitPackJT808(34818);
/*  63 */     pack.setMobileNum(getMobileNum());
/*  64 */     JT808MsgBody_0x8802 body = new JT808MsgBody_0x8802();
/*  65 */     body.setMultimediaType(getMultimediaType());
/*  66 */     body.setChannelID(getChannelID());
/*  67 */     body.setEventItemCoding(getEventItemCoding());
/*  68 */     body.setStartTime(getStartTime());
/*  69 */     body.setStopTime(getStopTime());
/*  70 */     pack.setMsgBody(body);
/*  71 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getMultimediaType() {
/*  75 */     return this.multimediaType;
/*     */   }
/*     */ 
/*     */   public void setMultimediaType(byte multimediaType)
/*     */   {
/*  80 */     this.multimediaType = multimediaType;
/*     */   }
/*     */ 
/*     */   public byte getEventItemCoding() {
/*  84 */     return this.eventItemCoding;
/*     */   }
/*     */ 
/*     */   public void setEventItemCoding(byte eventItemCoding)
/*     */   {
/*  89 */     this.eventItemCoding = eventItemCoding;
/*     */   }
/*     */ 
/*     */   public byte getChannelID() {
/*  93 */     return this.channelID;
/*     */   }
/*     */ 
/*     */   public void setChannelID(byte channelID)
/*     */   {
/*  98 */     this.channelID = channelID;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/* 102 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime)
/*     */   {
/* 107 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 111 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime)
/*     */   {
/* 116 */     this.stopTime = stopTime;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.StoreMultiDataSearchMsg
 * JD-Core Version:    0.6.1
 */