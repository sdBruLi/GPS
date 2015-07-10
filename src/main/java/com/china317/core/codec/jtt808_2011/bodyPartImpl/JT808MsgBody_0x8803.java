/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8803 extends JT808MsgBody
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
/*  30 */   private String startTime = "";
/*  31 */   private String stopTime = "";
/*     */   private byte delSign;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!isBuildBody()) {
/*  37 */       this.bodyBuffer = IoBuffer.allocate(8).setAutoExpand(true);
/*  38 */       this.bodyBuffer.put(this.multimediaType);
/*  39 */       this.bodyBuffer.put(this.eventItemCoding);
/*  40 */       this.bodyBuffer.put(this.channelID);
/*  41 */       this.bodyBuffer.put(ByteUtil.string2BCD(this.startTime, 6));
/*  42 */       this.bodyBuffer.put(ByteUtil.string2BCD(this.stopTime, 6));
/*  43 */       this.bodyBuffer.put(this.delSign);
/*  44 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public static UnitPackJT808 createStoreMultiDataUpload(String mobileNum, byte multimediaType, byte channelID, byte eventItemCoding, String startTime, String stopTime, byte delSign)
/*     */     throws Exception
/*     */   {
/*  67 */     UnitPackJT808 pack = new UnitPackJT808(34819);
/*  68 */     pack.setMobileNum(mobileNum);
/*  69 */     JT808MsgBody_0x8803 body = new JT808MsgBody_0x8803();
/*  70 */     body.setMultimediaType(multimediaType);
/*  71 */     body.setChannelID(channelID);
/*  72 */     body.setEventItemCoding(eventItemCoding);
/*  73 */     body.setStartTime(startTime);
/*  74 */     body.setStopTime(stopTime);
/*  75 */     body.setDelSign(delSign);
/*  76 */     pack.setMsgBody(body);
/*  77 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getMultimediaType() {
/*  81 */     return this.multimediaType;
/*     */   }
/*     */ 
/*     */   public void setMultimediaType(byte multimediaType) {
/*  85 */     this.multimediaType = multimediaType;
/*     */   }
/*     */ 
/*     */   public byte getEventItemCoding() {
/*  89 */     return this.eventItemCoding;
/*     */   }
/*     */ 
/*     */   public void setEventItemCoding(byte eventItemCoding) {
/*  93 */     this.eventItemCoding = eventItemCoding;
/*     */   }
/*     */ 
/*     */   public byte getChannelID() {
/*  97 */     return this.channelID;
/*     */   }
/*     */ 
/*     */   public void setChannelID(byte channelID) {
/* 101 */     this.channelID = channelID;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/* 105 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime) {
/* 109 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 113 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime) {
/* 117 */     this.stopTime = stopTime;
/*     */   }
/*     */ 
/*     */   public byte getDelSign() {
/* 121 */     return this.delSign;
/*     */   }
/*     */ 
/*     */   public void setDelSign(byte delSign) {
/* 125 */     this.delSign = delSign;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8803
 * JD-Core Version:    0.6.1
 */