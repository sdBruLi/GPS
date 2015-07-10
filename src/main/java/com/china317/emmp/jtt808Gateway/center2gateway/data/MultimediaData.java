/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.codecExt.ObjectDataJT808;
/*     */ 
/*     */ public abstract class MultimediaData extends ObjectDataJT808
/*     */ {
/*     */   public static final byte Multimedia_TYPE_IMAGE = 1;
/*     */   public static final byte Multimedia_TYPE_AUDIO = 2;
/*     */   public static final byte Multimedia_TYPE_VIDEO = 3;
/*     */   public static final byte Multimedia_TYPE_ACCIDENTPOINT = 10;
/*     */   public static final byte Multimedia_TYPE_JT808PACK = 11;
/*     */   public static final short SHOT_COMMAND_STOP = 0;
/*     */   public static final short SHOT_COMMAND_VIDEO = -1;
/*     */   public static final byte SAVE_SIGN_SAVE = 1;
/*     */   public static final byte SAVE_SIGN_UPLOAD = 0;
/*     */   public static final byte RESOLUTION_320_240 = 1;
/*     */   public static final byte RESOLUTION_640_480 = 2;
/*     */   public static final byte RESOLUTION_800_600 = 3;
/*     */   public static final byte RESOLUTION_1024_768 = 4;
/*     */   public static final byte RESOLUTION_QCIF_176_144 = 5;
/*     */   public static final byte RESOLUTION_CIF_352_288 = 6;
/*     */   public static final byte RESOLUTION_HALF_D1_704_288 = 7;
/*     */   public static final byte RESOLUTION_D1_704_576 = 8;
/*     */   private long createTime;
/*     */   private int multimediaID;
/*     */   private byte multimediaType;
/*     */   private byte multimediaFormatCoding;
/*     */   private byte eventItemCoding;
/*  34 */   private JT808MsgBody_0x0200 gpsData = new JT808MsgBody_0x0200();
/*  35 */   private int state = 0;
/*     */   private String vehDesc;
/*     */   private byte channelID;
/*     */ 
/*     */   public int getState()
/*     */   {
/*  40 */     return this.state;
/*     */   }
/*     */   public void setState(int state) {
/*  43 */     this.state = state;
/*     */   }
/*     */   public String getVehDesc() {
/*  46 */     return this.vehDesc;
/*     */   }
/*     */   public void setVehDesc(String vehDesc) {
/*  49 */     this.vehDesc = vehDesc;
/*     */   }
/*     */   public byte getChannelID() {
/*  52 */     return this.channelID;
/*     */   }
/*     */   public void setChannelID(byte channelID) {
/*  55 */     this.channelID = channelID;
/*     */   }
/*     */   public byte getMultimediaFormatCoding() {
/*  58 */     return this.multimediaFormatCoding;
/*     */   }
/*     */   public void setMultimediaFormatCoding(byte multimediaFormatCoding) {
/*  61 */     this.multimediaFormatCoding = multimediaFormatCoding;
/*     */   }
/*     */   public byte getEventItemCoding() {
/*  64 */     return this.eventItemCoding;
/*     */   }
/*     */   public void setEventItemCoding(byte eventItemCoding) {
/*  67 */     this.eventItemCoding = eventItemCoding;
/*     */   }
/*     */   public int getMultimediaID() {
/*  70 */     return this.multimediaID;
/*     */   }
/*     */ 
/*     */   public void setMultimediaID(int multimediaID) {
/*  74 */     this.multimediaID = multimediaID;
/*     */   }
/*     */ 
/*     */   public long getCreateTime()
/*     */   {
/*  79 */     return this.createTime;
/*     */   }
/*     */ 
/*     */   public void setCreateTime(long createTime)
/*     */   {
/*  84 */     this.createTime = createTime;
/*     */   }
/*     */ 
/*     */   public JT808MsgBody_0x0200 getGpsData() {
/*  88 */     return this.gpsData;
/*     */   }
/*     */ 
/*     */   public void setGpsData(JT808MsgBody_0x0200 gpsData) {
/*  92 */     this.gpsData = gpsData;
/*     */   }
/*     */ 
/*     */   public byte getMultimediaType()
/*     */   {
/* 102 */     return this.multimediaType;
/*     */   }
/*     */   public void setMultimediaType(byte multimediaType) {
/* 105 */     this.multimediaType = multimediaType;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.MultimediaData
 * JD-Core Version:    0.6.1
 */