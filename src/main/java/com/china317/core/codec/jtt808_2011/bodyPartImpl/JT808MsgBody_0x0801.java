/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x0801 extends JT808MsgBody
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
/*     */   private int multimediaID;
/*     */   private byte multimediaType;
/*     */   private byte multimediaFormatCoding;
/*     */   private byte eventItemCoding;
/*     */   private byte channelID;
/*     */   private IoBuffer multimediaDataPkg;
/*     */   private JT808MsgBody_0x0200 gpsData;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!isBuildBody()) {
/*  31 */       this.bodyBuffer = IoBuffer.allocate(8).setAutoExpand(true);
/*  32 */       this.bodyBuffer.putInt(this.multimediaID);
/*  33 */       this.bodyBuffer.put(this.multimediaType);
/*  34 */       this.bodyBuffer.put(this.multimediaFormatCoding);
/*  35 */       this.bodyBuffer.put(this.eventItemCoding);
/*  36 */       this.bodyBuffer.put(this.channelID);
/*  37 */       this.bodyBuffer.put(this.multimediaDataPkg);
/*  38 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*     */     try {
/*  45 */       this.multimediaID = this.bodyBuffer.getInt();
/*  46 */       this.multimediaType = this.bodyBuffer.get();
/*  47 */       this.multimediaFormatCoding = this.bodyBuffer.get();
/*  48 */       this.eventItemCoding = this.bodyBuffer.get();
/*  49 */       this.channelID = this.bodyBuffer.get();
/*  50 */       if (this.bodyBuffer.limit() > 36) {
/*  51 */         this.gpsData = new JT808MsgBody_0x0200();
/*  52 */         this.gpsData.setBodyBuffer(this.bodyBuffer.getSlice(28));
/*  53 */         this.multimediaDataPkg = this.bodyBuffer.getSlice(this.bodyBuffer.limit() - 8 - 28);
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {
/*     */     }
/*  58 */     this.bodyBuffer.rewind();
/*     */   }
/*     */ 
/*     */   public int getMultimediaID() {
/*  62 */     return this.multimediaID;
/*     */   }
/*     */ 
/*     */   public void setMultimediaID(int multimediaID) {
/*  66 */     this.multimediaID = multimediaID;
/*     */   }
/*     */ 
/*     */   public byte getMultimediaType() {
/*  70 */     return this.multimediaType;
/*     */   }
/*     */ 
/*     */   public void setMultimediaType(byte multimediaType) {
/*  74 */     this.multimediaType = multimediaType;
/*     */   }
/*     */ 
/*     */   public byte getMultimediaFormatCoding() {
/*  78 */     return this.multimediaFormatCoding;
/*     */   }
/*     */ 
/*     */   public void setMultimediaFormatCoding(byte multimediaFormatCoding) {
/*  82 */     this.multimediaFormatCoding = multimediaFormatCoding;
/*     */   }
/*     */ 
/*     */   public byte getEventItemCoding() {
/*  86 */     return this.eventItemCoding;
/*     */   }
/*     */ 
/*     */   public void setEventItemCoding(byte eventItemCoding) {
/*  90 */     this.eventItemCoding = eventItemCoding;
/*     */   }
/*     */ 
/*     */   public byte getChannelID() {
/*  94 */     return this.channelID;
/*     */   }
/*     */ 
/*     */   public void setChannelID(byte channelID) {
/*  98 */     this.channelID = channelID;
/*     */   }
/*     */ 
/*     */   public IoBuffer getMultimediaDataPkg() {
/* 102 */     return this.multimediaDataPkg;
/*     */   }
/*     */ 
/*     */   public void setMultimediaDataPkg(IoBuffer multimediaDataPkg) {
/* 106 */     this.multimediaDataPkg = multimediaDataPkg;
/*     */   }
/*     */ 
/*     */   public JT808MsgBody_0x0200 getGpsData() {
/* 110 */     return this.gpsData;
/*     */   }
/*     */ 
/*     */   public void setGpsData(JT808MsgBody_0x0200 gpsData) {
/* 114 */     this.gpsData = gpsData;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0801
 * JD-Core Version:    0.6.1
 */