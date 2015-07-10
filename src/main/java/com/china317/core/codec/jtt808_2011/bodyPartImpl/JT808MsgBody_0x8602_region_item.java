/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8602_region_item extends JT808MsgBody
/*     */ {
/*     */   private int regionId;
/*     */   private short regionAttribute;
/*     */   private int liftUpperLatitude;
/*     */   private int liftUpperLongitude;
/*     */   private int rightLowerLatitude;
/*     */   private int rightLowerLongitude;
/*  16 */   private String startTime = "";
/*  17 */   private String stopTime = "";
/*     */   private short maxSpeed;
/*     */   private byte overspeedTime;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  23 */     if (!isBuildBody()) {
/*  24 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/*  25 */       this.bodyBuffer.putInt(this.regionId);
/*  26 */       this.bodyBuffer.putShort(this.regionAttribute);
/*  27 */       this.bodyBuffer.putInt(this.liftUpperLatitude);
/*  28 */       this.bodyBuffer.putInt(this.liftUpperLongitude);
/*  29 */       this.bodyBuffer.putInt(this.rightLowerLatitude);
/*  30 */       this.bodyBuffer.putInt(this.rightLowerLongitude);
/*     */ 
/*  32 */       if ((this.regionAttribute & 0x1) == 1) {
/*  33 */         this.bodyBuffer.put(ByteUtil.string2BCD(this.startTime, 6));
/*  34 */         this.bodyBuffer.put(ByteUtil.string2BCD(this.stopTime, 6));
/*     */       }
/*     */ 
/*  37 */       if ((this.regionAttribute >> 1 & 0x1) == 1) {
/*  38 */         this.bodyBuffer.putShort(this.maxSpeed);
/*  39 */         this.bodyBuffer.put(this.overspeedTime);
/*     */       }
/*  41 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*  47 */     this.regionId = this.bodyBuffer.getInt();
/*  48 */     this.regionAttribute = this.bodyBuffer.getShort();
/*  49 */     this.liftUpperLatitude = this.bodyBuffer.getInt();
/*  50 */     this.liftUpperLongitude = this.bodyBuffer.getInt();
/*  51 */     this.rightLowerLatitude = this.bodyBuffer.getInt();
/*  52 */     this.rightLowerLongitude = this.bodyBuffer.getInt();
/*     */ 
/*  54 */     if ((this.regionAttribute & 0x1) == 1) {
/*  55 */       byte[] timebytes = new byte[6];
/*  56 */       this.bodyBuffer.get(timebytes);
/*  57 */       this.startTime = ByteUtil.getHexString(timebytes);
/*  58 */       byte[] timebytes2 = new byte[6];
/*  59 */       this.bodyBuffer.get(timebytes2);
/*  60 */       this.stopTime = ByteUtil.getHexString(timebytes2);
/*     */     }
/*     */ 
/*  63 */     if ((this.regionAttribute >> 1 & 0x1) == 1) {
/*  64 */       this.maxSpeed = this.bodyBuffer.getShort();
/*  65 */       this.overspeedTime = this.bodyBuffer.get();
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getRegionId() {
/*  70 */     return this.regionId;
/*     */   }
/*     */ 
/*     */   public void setRegionId(int regionId) {
/*  74 */     this.regionId = regionId;
/*     */   }
/*     */ 
/*     */   public short getRegionAttribute() {
/*  78 */     return this.regionAttribute;
/*     */   }
/*     */ 
/*     */   public void setRegionAttribute(short regionAttribute) {
/*  82 */     this.regionAttribute = regionAttribute;
/*     */   }
/*     */ 
/*     */   public int getLiftUpperLatitude() {
/*  86 */     return this.liftUpperLatitude;
/*     */   }
/*     */ 
/*     */   public void setLiftUpperLatitude(int liftUpperLatitude) {
/*  90 */     this.liftUpperLatitude = liftUpperLatitude;
/*     */   }
/*     */ 
/*     */   public int getLiftUpperLongitude() {
/*  94 */     return this.liftUpperLongitude;
/*     */   }
/*     */ 
/*     */   public void setLiftUpperLongitude(int liftUpperLongitude) {
/*  98 */     this.liftUpperLongitude = liftUpperLongitude;
/*     */   }
/*     */ 
/*     */   public int getRightLowerLatitude() {
/* 102 */     return this.rightLowerLatitude;
/*     */   }
/*     */ 
/*     */   public void setRightLowerLatitude(int rightLowerLatitude) {
/* 106 */     this.rightLowerLatitude = rightLowerLatitude;
/*     */   }
/*     */ 
/*     */   public int getRightLowerLongitude() {
/* 110 */     return this.rightLowerLongitude;
/*     */   }
/*     */ 
/*     */   public void setRightLowerLongitude(int rightLowerLongitude) {
/* 114 */     this.rightLowerLongitude = rightLowerLongitude;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/* 118 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime) {
/* 122 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 126 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime) {
/* 130 */     this.stopTime = stopTime;
/*     */   }
/*     */ 
/*     */   public short getMaxSpeed() {
/* 134 */     return this.maxSpeed;
/*     */   }
/*     */ 
/*     */   public void setMaxSpeed(short maxSpeed) {
/* 138 */     this.maxSpeed = maxSpeed;
/*     */   }
/*     */ 
/*     */   public byte getOverspeedTime() {
/* 142 */     return this.overspeedTime;
/*     */   }
/*     */ 
/*     */   public void setOverspeedTime(byte overspeedTime) {
/* 146 */     this.overspeedTime = overspeedTime;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8602_region_item
 * JD-Core Version:    0.6.1
 */