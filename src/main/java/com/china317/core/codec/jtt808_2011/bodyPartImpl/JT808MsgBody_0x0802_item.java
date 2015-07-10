/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x0802_item extends JT808MsgBody
/*     */ {
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
/*     */   private int multimediaID;
/*     */   private byte multimediaType;
/*     */   private byte channelID;
/*     */   private byte eventItemCoding;
/*     */   private JT808MsgBody_0x0200 gpsData;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public void praseBody()
/*     */     throws Exception
/*     */   {
/*  31 */     this.multimediaID = this.bodyBuffer.getInt();
/*  32 */     this.multimediaType = this.bodyBuffer.get();
/*  33 */     this.channelID = this.bodyBuffer.get();
/*  34 */     this.eventItemCoding = this.bodyBuffer.get();
/*  35 */     if (this.bodyBuffer.limit() >= 35) {
/*  36 */       this.gpsData = new JT808MsgBody_0x0200();
/*  37 */       this.gpsData.setBodyBuffer(this.bodyBuffer.getSlice(28));
/*     */     }
/*  39 */     this.bodyBuffer.rewind();
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  44 */     StringBuffer line = new StringBuffer();
/*  45 */     line.append("multimediaID:");
/*  46 */     line.append(this.multimediaID);
/*  47 */     line.append(" multimediaType");
/*  48 */     line.append(this.multimediaType);
/*  49 */     line.append(" channelID");
/*  50 */     line.append(this.channelID);
/*  51 */     line.append(" eventItemCoding");
/*  52 */     line.append(this.eventItemCoding);
/*  53 */     if (this.gpsData != null) {
/*  54 */       line.append("gps point ->time: ");
/*  55 */       line.append(this.gpsData.getTime());
/*  56 */       line.append(" latitude: ");
/*  57 */       line.append(this.gpsData.getLatitude());
/*  58 */       line.append(" longitude: ");
/*  59 */       line.append(this.gpsData.getLangitude());
/*     */     }
/*  61 */     return line.toString();
/*     */   }
/*     */ 
/*     */   public byte getChannelID() {
/*  65 */     return this.channelID;
/*     */   }
/*     */ 
/*     */   public void setChannelID(byte channelID) {
/*  69 */     this.channelID = channelID;
/*     */   }
/*     */ 
/*     */   public int getMultimediaID() {
/*  73 */     return this.multimediaID;
/*     */   }
/*     */ 
/*     */   public void setMultimediaID(int multimediaID) {
/*  77 */     this.multimediaID = multimediaID;
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
/*     */   public JT808MsgBody_0x0200 getGpsData() {
/*  97 */     return this.gpsData;
/*     */   }
/*     */ 
/*     */   public void setGpsData(JT808MsgBody_0x0200 gpsData) {
/* 101 */     this.gpsData = gpsData;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0802_item
 * JD-Core Version:    0.6.1
 */