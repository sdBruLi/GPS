/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8600_region_item extends JT808MsgBody
/*     */ {
/*     */   private int regionId;
/*     */   private short regionAttribute;
/*     */   private int centerLatitude;
/*     */   private int centerLongitude;
/*     */   private int radius;
/*  15 */   private String startTime = "";
/*  16 */   private String stopTime = "";
/*     */   private short maxSpeed;
/*     */   private byte overspeedTime;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  22 */     if (!isBuildBody()) {
/*  23 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/*  24 */       this.bodyBuffer.putInt(this.regionId);
/*  25 */       this.bodyBuffer.putShort(this.regionAttribute);
/*  26 */       this.bodyBuffer.putInt(this.centerLatitude);
/*  27 */       this.bodyBuffer.putInt(this.centerLongitude);
/*  28 */       this.bodyBuffer.putInt(this.radius);
/*  29 */       if ((this.regionAttribute & 0x1) == 1) {
/*  30 */         this.bodyBuffer.put(ByteUtil.string2BCD(this.startTime, 6));
/*  31 */         this.bodyBuffer.put(ByteUtil.string2BCD(this.stopTime, 6));
/*     */       }
/*  33 */       if ((this.regionAttribute >> 1 & 0x1) == 1) {
/*  34 */         this.bodyBuffer.putShort(this.maxSpeed);
/*  35 */         this.bodyBuffer.put(this.overspeedTime);
/*     */       }
/*  37 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*  43 */     this.regionId = this.bodyBuffer.getInt();
/*  44 */     this.regionAttribute = this.bodyBuffer.getShort();
/*  45 */     this.centerLatitude = this.bodyBuffer.getInt();
/*  46 */     this.centerLongitude = this.bodyBuffer.getInt();
/*  47 */     this.radius = this.bodyBuffer.getInt();
/*  48 */     byte[] timebytes = new byte[6];
/*  49 */     this.bodyBuffer.get(timebytes);
/*  50 */     this.startTime = ByteUtil.getHexString(timebytes);
/*  51 */     byte[] timebytes2 = new byte[6];
/*  52 */     this.bodyBuffer.get(timebytes2);
/*  53 */     this.stopTime = ByteUtil.getHexString(timebytes2);
/*  54 */     this.maxSpeed = this.bodyBuffer.getShort();
/*  55 */     this.overspeedTime = this.bodyBuffer.get();
/*     */   }
/*     */ 
/*     */   public int getRegionId() {
/*  59 */     return this.regionId;
/*     */   }
/*     */ 
/*     */   public void setRegionId(int regionId) {
/*  63 */     this.regionId = regionId;
/*     */   }
/*     */ 
/*     */   public short getRegionAttribute() {
/*  67 */     return this.regionAttribute;
/*     */   }
/*     */ 
/*     */   public void setRegionAttribute(short regionAttribute) {
/*  71 */     this.regionAttribute = regionAttribute;
/*     */   }
/*     */ 
/*     */   public int getCenterLatitude() {
/*  75 */     return this.centerLatitude;
/*     */   }
/*     */ 
/*     */   public void setCenterLatitude(int centerLatitude) {
/*  79 */     this.centerLatitude = centerLatitude;
/*     */   }
/*     */ 
/*     */   public int getCenterLongitude() {
/*  83 */     return this.centerLongitude;
/*     */   }
/*     */ 
/*     */   public void setCenterLongitude(int centerLongitude) {
/*  87 */     this.centerLongitude = centerLongitude;
/*     */   }
/*     */ 
/*     */   public int getRadius() {
/*  91 */     return this.radius;
/*     */   }
/*     */ 
/*     */   public void setRadius(int radius) {
/*  95 */     this.radius = radius;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/*  99 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime) {
/* 103 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 107 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime) {
/* 111 */     this.stopTime = stopTime;
/*     */   }
/*     */ 
/*     */   public short getMaxSpeed() {
/* 115 */     return this.maxSpeed;
/*     */   }
/*     */ 
/*     */   public void setMaxSpeed(short maxSpeed) {
/* 119 */     this.maxSpeed = maxSpeed;
/*     */   }
/*     */ 
/*     */   public byte getOverspeedTime() {
/* 123 */     return this.overspeedTime;
/*     */   }
/*     */ 
/*     */   public void setOverspeedTime(byte overspeedTime) {
/* 127 */     this.overspeedTime = overspeedTime;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8600_region_item
 * JD-Core Version:    0.6.1
 */