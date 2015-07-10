/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8801 extends JT808MsgBody
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
/*     */   private byte channelID;
/*     */   private short shotCommand;
/*     */   private short shotInterval;
/*     */   private byte saveSign;
/*     */   private byte resolution;
/*     */   private byte quality;
/*     */   private byte lighteness;
/*     */   private byte contrast;
/*     */   private byte saturation;
/*     */   private byte chroma;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!isBuildBody()) {
/*  37 */       this.bodyBuffer = IoBuffer.allocate(12);
/*  38 */       this.bodyBuffer.put(this.channelID);
/*  39 */       this.bodyBuffer.putUnsignedShort(this.shotCommand);
/*  40 */       this.bodyBuffer.putUnsignedShort(this.shotInterval);
/*  41 */       this.bodyBuffer.put(this.saveSign);
/*  42 */       this.bodyBuffer.put(this.resolution);
/*  43 */       this.bodyBuffer.put(this.quality);
/*  44 */       this.bodyBuffer.put(this.lighteness);
/*  45 */       this.bodyBuffer.put(this.contrast);
/*  46 */       this.bodyBuffer.put(this.saturation);
/*  47 */       this.bodyBuffer.put(this.chroma);
/*  48 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*  54 */     this.channelID = this.bodyBuffer.get();
/*  55 */     this.shotCommand = (short)this.bodyBuffer.getUnsignedShort();
/*  56 */     this.shotInterval = (short)this.bodyBuffer.getUnsignedShort();
/*  57 */     this.saveSign = this.bodyBuffer.get();
/*  58 */     this.resolution = this.bodyBuffer.get();
/*  59 */     this.quality = this.bodyBuffer.get();
/*  60 */     this.lighteness = this.bodyBuffer.get();
/*  61 */     this.contrast = this.bodyBuffer.get();
/*  62 */     this.saturation = this.bodyBuffer.get();
/*  63 */     this.chroma = this.bodyBuffer.get();
/*  64 */     this.bodyBuffer.rewind();
/*     */   }
/*     */ 
/*     */   public static UnitPackJT808 createMultimediaRequestPack(String mobileNum, byte channelId, short shotCommand, short shotInterval, byte saveSign, byte resolution, byte quality, byte lightness, byte contrast, byte saturation, byte chroma)
/*     */     throws Exception
/*     */   {
/*  70 */     UnitPackJT808 pack = new UnitPackJT808(
/*  71 */       34817);
/*  72 */     JT808MsgBody_0x8801 body_0x8801 = new JT808MsgBody_0x8801();
/*  73 */     body_0x8801.setChannelID(channelId);
/*  74 */     body_0x8801.setShotCommand(shotCommand);
/*  75 */     body_0x8801.setShotInterval(shotInterval);
/*  76 */     body_0x8801.setSaveSign(saveSign);
/*  77 */     body_0x8801.setResolution(resolution);
/*  78 */     body_0x8801.setQuality(quality);
/*  79 */     body_0x8801.setLighteness(lightness);
/*  80 */     body_0x8801.setContrast(contrast);
/*  81 */     body_0x8801.setSaturation(saturation);
/*  82 */     body_0x8801.setChroma(chroma);
/*  83 */     body_0x8801.bulidBody();
/*  84 */     pack.setMsgBody(body_0x8801);
/*  85 */     pack.setMsgBody(body_0x8801.getBodyBuffer());
/*  86 */     pack.setMobileNum(mobileNum);
/*  87 */     pack.setSequenceNum(0);
/*     */ 
/*  89 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getChannelID() {
/*  93 */     return this.channelID;
/*     */   }
/*     */ 
/*     */   public void setChannelID(byte channelID) {
/*  97 */     this.channelID = channelID;
/*     */   }
/*     */ 
/*     */   public short getShotCommand() {
/* 101 */     return this.shotCommand;
/*     */   }
/*     */ 
/*     */   public void setShotCommand(short shotCommand) {
/* 105 */     this.shotCommand = shotCommand;
/*     */   }
/*     */ 
/*     */   public short getShotInterval() {
/* 109 */     return this.shotInterval;
/*     */   }
/*     */ 
/*     */   public void setShotInterval(short shotInterval) {
/* 113 */     this.shotInterval = shotInterval;
/*     */   }
/*     */ 
/*     */   public byte getSaveSign() {
/* 117 */     return this.saveSign;
/*     */   }
/*     */ 
/*     */   public void setSaveSign(byte saveSign) {
/* 121 */     this.saveSign = saveSign;
/*     */   }
/*     */ 
/*     */   public byte getResolution() {
/* 125 */     return this.resolution;
/*     */   }
/*     */ 
/*     */   public void setResolution(byte resolution) {
/* 129 */     this.resolution = resolution;
/*     */   }
/*     */ 
/*     */   public byte getQuality() {
/* 133 */     return this.quality;
/*     */   }
/*     */ 
/*     */   public void setQuality(byte quality) {
/* 137 */     this.quality = quality;
/*     */   }
/*     */ 
/*     */   public byte getLighteness() {
/* 141 */     return this.lighteness;
/*     */   }
/*     */ 
/*     */   public void setLighteness(byte lighteness) {
/* 145 */     this.lighteness = lighteness;
/*     */   }
/*     */ 
/*     */   public byte getContrast() {
/* 149 */     return this.contrast;
/*     */   }
/*     */ 
/*     */   public void setContrast(byte contrast) {
/* 153 */     this.contrast = contrast;
/*     */   }
/*     */ 
/*     */   public byte getSaturation() {
/* 157 */     return this.saturation;
/*     */   }
/*     */ 
/*     */   public void setSaturation(byte saturation) {
/* 161 */     this.saturation = saturation;
/*     */   }
/*     */ 
/*     */   public byte getChroma() {
/* 165 */     return this.chroma;
/*     */   }
/*     */ 
/*     */   public void setChroma(byte chroma) {
/* 169 */     this.chroma = chroma;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8801
 * JD-Core Version:    0.6.1
 */