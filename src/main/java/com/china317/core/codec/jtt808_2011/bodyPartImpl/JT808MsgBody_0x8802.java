/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8802 extends JT808MsgBody
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
/*  27 */   private String startTime = "";
/*  28 */   private String stopTime = "";
/*     */ 
/*     */   public void bulidBody() throws Exception {
/*  31 */     if (!isBuildBody()) {
/*  32 */       this.bodyBuffer = IoBuffer.allocate(8).setAutoExpand(true);
/*  33 */       this.bodyBuffer.put(this.multimediaType);
/*  34 */       this.bodyBuffer.put(this.channelID);
/*  35 */       this.bodyBuffer.put(this.eventItemCoding);
/*  36 */       this.bodyBuffer.put(ByteUtil.string2BCD(this.startTime, 6));
/*  37 */       this.bodyBuffer.put(ByteUtil.string2BCD(this.stopTime, 6));
/*  38 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public static UnitPackJT808 createStoreMultiDataSearch(String mobileNum, byte multimediaType, byte channelID, byte eventItemCoding, String startTime, String stopTime)
/*     */     throws Exception
/*     */   {
/*  60 */     UnitPackJT808 pack = new UnitPackJT808(34818);
/*  61 */     pack.setMobileNum(mobileNum);
/*  62 */     JT808MsgBody_0x8802 body = new JT808MsgBody_0x8802();
/*  63 */     body.setMultimediaType(multimediaType);
/*  64 */     body.setChannelID(channelID);
/*  65 */     body.setEventItemCoding(eventItemCoding);
/*  66 */     body.setStartTime(startTime);
/*  67 */     body.setStopTime(stopTime);
/*  68 */     pack.setMsgBody(body);
/*  69 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getMultimediaType() {
/*  73 */     return this.multimediaType;
/*     */   }
/*     */ 
/*     */   public void setMultimediaType(byte multimediaType) {
/*  77 */     this.multimediaType = multimediaType;
/*     */   }
/*     */ 
/*     */   public byte getEventItemCoding() {
/*  81 */     return this.eventItemCoding;
/*     */   }
/*     */ 
/*     */   public void setEventItemCoding(byte eventItemCoding) {
/*  85 */     this.eventItemCoding = eventItemCoding;
/*     */   }
/*     */ 
/*     */   public byte getChannelID() {
/*  89 */     return this.channelID;
/*     */   }
/*     */ 
/*     */   public void setChannelID(byte channelID) {
/*  93 */     this.channelID = channelID;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/*  97 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime) {
/* 101 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 105 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime) {
/* 109 */     this.stopTime = stopTime;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8802
 * JD-Core Version:    0.6.1
 */