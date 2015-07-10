/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ public class RouteInflexionItem
/*     */ {
/*     */   private int inflexionId;
/*     */   private int roadId;
/*     */   private int inflexionLatitude;
/*     */   private int inflexionLongitude;
/*     */   private byte roadWide;
/*     */   private InflexionRoadAttri roadAttribute;
/*     */   private short roadRunOverlength;
/*     */   private short roadRunShortness;
/*     */   private short maxSpeed;
/*     */   private byte overspeedTime;
/*     */ 
/*     */   public RouteInflexionItem(int inflexionId, int roadId, int inflexionLatitude, int inflexionLongitude, byte roadWide, InflexionRoadAttri roadAttribute, short roadRunOverlength, short roadRunShortness, short maxSpeed, byte overspeedTime)
/*     */   {
/*  19 */     setInflexionId(inflexionId);
/*  20 */     setRoadId(roadId);
/*  21 */     setInflexionLatitude(inflexionLatitude);
/*  22 */     setInflexionLongitude(inflexionLongitude);
/*  23 */     setRoadWide(roadWide);
/*  24 */     setRoadAttribute(roadAttribute);
/*  25 */     setRoadRunOverlength(roadRunOverlength);
/*  26 */     setRoadRunShortness(roadRunShortness);
/*  27 */     setMaxSpeed(maxSpeed);
/*  28 */     setOverspeedTime(overspeedTime);
/*     */   }
/*     */ 
/*     */   public int getInflexionId() {
/*  32 */     return this.inflexionId;
/*     */   }
/*     */ 
/*     */   public void setInflexionId(int inflexionId) {
/*  36 */     this.inflexionId = inflexionId;
/*     */   }
/*     */ 
/*     */   public int getRoadId() {
/*  40 */     return this.roadId;
/*     */   }
/*     */ 
/*     */   public void setRoadId(int roadId) {
/*  44 */     this.roadId = roadId;
/*     */   }
/*     */ 
/*     */   public int getInflexionLatitude() {
/*  48 */     return this.inflexionLatitude;
/*     */   }
/*     */ 
/*     */   public void setInflexionLatitude(int inflexionLatitude) {
/*  52 */     this.inflexionLatitude = inflexionLatitude;
/*     */   }
/*     */ 
/*     */   public int getInflexionLongitude() {
/*  56 */     return this.inflexionLongitude;
/*     */   }
/*     */ 
/*     */   public void setInflexionLongitude(int inflexionLongitude) {
/*  60 */     this.inflexionLongitude = inflexionLongitude;
/*     */   }
/*     */ 
/*     */   public byte getRoadWide() {
/*  64 */     return this.roadWide;
/*     */   }
/*     */ 
/*     */   public void setRoadWide(byte roadWide) {
/*  68 */     this.roadWide = roadWide;
/*     */   }
/*     */ 
/*     */   public InflexionRoadAttri getRoadAttribute() {
/*  72 */     return this.roadAttribute;
/*     */   }
/*     */ 
/*     */   public void setRoadAttribute(InflexionRoadAttri roadAttribute) {
/*  76 */     this.roadAttribute = roadAttribute;
/*     */   }
/*     */ 
/*     */   public short getRoadRunOverlength() {
/*  80 */     return this.roadRunOverlength;
/*     */   }
/*     */ 
/*     */   public void setRoadRunOverlength(short roadRunOverlength) {
/*  84 */     this.roadRunOverlength = roadRunOverlength;
/*     */   }
/*     */ 
/*     */   public short getRoadRunShortness() {
/*  88 */     return this.roadRunShortness;
/*     */   }
/*     */ 
/*     */   public void setRoadRunShortness(short roadRunShortness) {
/*  92 */     this.roadRunShortness = roadRunShortness;
/*     */   }
/*     */ 
/*     */   public short getMaxSpeed() {
/*  96 */     return this.maxSpeed;
/*     */   }
/*     */ 
/*     */   public void setMaxSpeed(short maxSpeed) {
/* 100 */     this.maxSpeed = maxSpeed;
/*     */   }
/*     */ 
/*     */   public byte getOverspeedTime() {
/* 104 */     return this.overspeedTime;
/*     */   }
/*     */ 
/*     */   public void setOverspeedTime(byte overspeedTime) {
/* 108 */     this.overspeedTime = overspeedTime;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.RouteInflexionItem
 * JD-Core Version:    0.6.1
 */