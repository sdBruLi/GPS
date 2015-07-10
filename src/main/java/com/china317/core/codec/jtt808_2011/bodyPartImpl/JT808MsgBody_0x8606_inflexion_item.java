/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8606_inflexion_item extends JT808MsgBody
/*     */ {
/*     */   private int inflexionId;
/*     */   private int roadId;
/*     */   private int inflexionLatitude;
/*     */   private int inflexionLongitude;
/*     */   private byte roadWide;
/*     */   private byte roadAttribute;
/*     */   private short roadRunOverlength;
/*     */   private short roadRunShortness;
/*     */   private short maxSpeed;
/*     */   private byte overspeedTime;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  22 */     if (!isBuildBody()) {
/*  23 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/*  24 */       this.bodyBuffer.putInt(this.inflexionId);
/*  25 */       this.bodyBuffer.putInt(this.roadId);
/*  26 */       this.bodyBuffer.putInt(this.inflexionLatitude);
/*  27 */       this.bodyBuffer.putInt(this.inflexionLongitude);
/*  28 */       this.bodyBuffer.put(this.roadWide);
/*  29 */       this.bodyBuffer.put(this.roadAttribute);
/*  30 */       if ((this.roadAttribute & 0x1) == 1) {
/*  31 */         this.bodyBuffer.putShort(this.roadRunOverlength);
/*  32 */         this.bodyBuffer.putShort(this.roadRunShortness);
/*     */       }
/*  34 */       if ((this.roadAttribute >> 1 & 0x1) == 1) {
/*  35 */         this.bodyBuffer.putShort(this.maxSpeed);
/*  36 */         this.bodyBuffer.put(this.overspeedTime);
/*     */       }
/*  38 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public int getInflexionId() {
/*  47 */     return this.inflexionId;
/*     */   }
/*     */ 
/*     */   public void setInflexionId(int inflexionId) {
/*  51 */     this.inflexionId = inflexionId;
/*     */   }
/*     */ 
/*     */   public int getRoadId() {
/*  55 */     return this.roadId;
/*     */   }
/*     */ 
/*     */   public void setRoadId(int roadId) {
/*  59 */     this.roadId = roadId;
/*     */   }
/*     */ 
/*     */   public int getInflexionLatitude() {
/*  63 */     return this.inflexionLatitude;
/*     */   }
/*     */ 
/*     */   public void setInflexionLatitude(int inflexionLatitude) {
/*  67 */     this.inflexionLatitude = inflexionLatitude;
/*     */   }
/*     */ 
/*     */   public int getInflexionLongitude() {
/*  71 */     return this.inflexionLongitude;
/*     */   }
/*     */ 
/*     */   public void setInflexionLongitude(int inflexionLongitude) {
/*  75 */     this.inflexionLongitude = inflexionLongitude;
/*     */   }
/*     */ 
/*     */   public byte getRoadWide() {
/*  79 */     return this.roadWide;
/*     */   }
/*     */ 
/*     */   public void setRoadWide(byte roadWide) {
/*  83 */     this.roadWide = roadWide;
/*     */   }
/*     */ 
/*     */   public byte getRoadAttribute() {
/*  87 */     return this.roadAttribute;
/*     */   }
/*     */ 
/*     */   public void setRoadAttribute(byte roadAttribute) {
/*  91 */     this.roadAttribute = roadAttribute;
/*     */   }
/*     */ 
/*     */   public short getRoadRunOverlength() {
/*  95 */     return this.roadRunOverlength;
/*     */   }
/*     */ 
/*     */   public void setRoadRunOverlength(short roadRunOverlength) {
/*  99 */     this.roadRunOverlength = roadRunOverlength;
/*     */   }
/*     */ 
/*     */   public short getRoadRunShortness() {
/* 103 */     return this.roadRunShortness;
/*     */   }
/*     */ 
/*     */   public void setRoadRunShortness(short roadRunShortness) {
/* 107 */     this.roadRunShortness = roadRunShortness;
/*     */   }
/*     */ 
/*     */   public short getMaxSpeed() {
/* 111 */     return this.maxSpeed;
/*     */   }
/*     */ 
/*     */   public void setMaxSpeed(short maxSpeed) {
/* 115 */     this.maxSpeed = maxSpeed;
/*     */   }
/*     */ 
/*     */   public byte getOverspeedTime() {
/* 119 */     return this.overspeedTime;
/*     */   }
/*     */ 
/*     */   public void setOverspeedTime(byte overspeedTime) {
/* 123 */     this.overspeedTime = overspeedTime;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8606_inflexion_item
 * JD-Core Version:    0.6.1
 */