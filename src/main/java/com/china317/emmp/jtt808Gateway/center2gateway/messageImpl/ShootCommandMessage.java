/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8801;
/*     */ 
/*     */ public class ShootCommandMessage extends BaseDownMessage
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
/*     */   public ShootCommandMessage(String mobileNum, String messageKey, byte channelId, short shotCommand, short shotInterval, byte saveSign, byte resolution, byte quality, byte lightness, byte contrast, byte saturation, byte chroma)
/*     */   {
/*  53 */     setMobileNum(mobileNum);
/*  54 */     setMessageKey(messageKey);
/*  55 */     setChannelID(channelId);
/*  56 */     setShotCommand(shotCommand);
/*  57 */     setShotInterval(shotInterval);
/*  58 */     setSaveSign(saveSign);
/*  59 */     setResolution(resolution);
/*  60 */     setQuality(quality);
/*  61 */     setLighteness(lightness);
/*  62 */     setContrast(contrast);
/*  63 */     setSaturation(saturation);
/*  64 */     setChroma(chroma);
/*  65 */     setCommand("0x8801");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception
/*     */   {
/*  70 */     UnitPackJT808 pack = new UnitPackJT808(34817);
/*  71 */     JT808MsgBody_0x8801 body_0x8801 = new JT808MsgBody_0x8801();
/*  72 */     body_0x8801.setChannelID(getChannelID());
/*  73 */     body_0x8801.setShotCommand(getShotCommand());
/*  74 */     body_0x8801.setShotInterval(getShotInterval());
/*  75 */     body_0x8801.setSaveSign(getSaveSign());
/*  76 */     body_0x8801.setResolution(getResolution());
/*  77 */     body_0x8801.setQuality(getQuality());
/*  78 */     body_0x8801.setLighteness(getLighteness());
/*  79 */     body_0x8801.setContrast(getContrast());
/*  80 */     body_0x8801.setSaturation(getSaturation());
/*  81 */     body_0x8801.setChroma(getChroma());
/*  82 */     body_0x8801.bulidBody();
/*  83 */     pack.setMsgBody(body_0x8801);
/*  84 */     pack.setMsgBody(body_0x8801.getBodyBuffer());
/*  85 */     pack.setMobileNum(getMobileNum());
/*  86 */     pack.setSequenceNum(0);
/*     */ 
/*  88 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getChannelID() {
/*  92 */     return this.channelID;
/*     */   }
/*     */ 
/*     */   public void setChannelID(byte channelID)
/*     */   {
/*  97 */     this.channelID = channelID;
/*     */   }
/*     */ 
/*     */   public short getShotCommand() {
/* 101 */     return this.shotCommand;
/*     */   }
/*     */ 
/*     */   public void setShotCommand(short shotCommand)
/*     */   {
/* 106 */     this.shotCommand = shotCommand;
/*     */   }
/*     */ 
/*     */   public short getShotInterval() {
/* 110 */     return this.shotInterval;
/*     */   }
/*     */ 
/*     */   public void setShotInterval(short shotInterval)
/*     */   {
/* 115 */     this.shotInterval = shotInterval;
/*     */   }
/*     */ 
/*     */   public byte getSaveSign() {
/* 119 */     return this.saveSign;
/*     */   }
/*     */ 
/*     */   public void setSaveSign(byte saveSign)
/*     */   {
/* 124 */     this.saveSign = saveSign;
/*     */   }
/*     */ 
/*     */   public byte getResolution() {
/* 128 */     return this.resolution;
/*     */   }
/*     */ 
/*     */   public void setResolution(byte resolution)
/*     */   {
/* 133 */     this.resolution = resolution;
/*     */   }
/*     */ 
/*     */   public byte getQuality() {
/* 137 */     return this.quality;
/*     */   }
/*     */ 
/*     */   public void setQuality(byte quality)
/*     */   {
/* 142 */     this.quality = quality;
/*     */   }
/*     */ 
/*     */   public byte getLighteness() {
/* 146 */     return this.lighteness;
/*     */   }
/*     */ 
/*     */   public void setLighteness(byte lighteness)
/*     */   {
/* 151 */     this.lighteness = lighteness;
/*     */   }
/*     */ 
/*     */   public byte getContrast() {
/* 155 */     return this.contrast;
/*     */   }
/*     */ 
/*     */   public void setContrast(byte contrast)
/*     */   {
/* 160 */     this.contrast = contrast;
/*     */   }
/*     */ 
/*     */   public byte getSaturation() {
/* 164 */     return this.saturation;
/*     */   }
/*     */ 
/*     */   public void setSaturation(byte saturation)
/*     */   {
/* 169 */     this.saturation = saturation;
/*     */   }
/*     */ 
/*     */   public byte getChroma() {
/* 173 */     return this.chroma;
/*     */   }
/*     */ 
/*     */   public void setChroma(byte chroma)
/*     */   {
/* 178 */     this.chroma = chroma;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ShootCommandMessage
 * JD-Core Version:    0.6.1
 */