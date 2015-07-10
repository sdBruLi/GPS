/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ public class RectangleRegionItem
/*     */ {
/*     */   private int regionId;
/*     */   private RegionItemAttri regionAttribute;
/*     */   private int liftUpperLatitude;
/*     */   private int liftUpperLongitude;
/*     */   private int rightLowerLatitude;
/*     */   private int rightLowerLongitude;
/*  11 */   private String startTime = "";
/*  12 */   private String stopTime = "";
/*     */   private short maxSpeed;
/*     */   private byte overspeedTime;
/*     */ 
/*     */   public RectangleRegionItem(int regionId, RegionItemAttri regionAttribute, int liftUpperLatitude, int liftUpperLongitude, int rightLowerLatitude, int rightLowerLongitude, String startTime, String stopTime, short maxSpeed, byte overspeedTime)
/*     */   {
/*  20 */     this.regionId = regionId;
/*  21 */     this.regionAttribute = regionAttribute;
/*  22 */     this.liftUpperLatitude = liftUpperLatitude;
/*  23 */     this.liftUpperLongitude = liftUpperLongitude;
/*  24 */     this.rightLowerLatitude = rightLowerLatitude;
/*  25 */     this.rightLowerLongitude = rightLowerLongitude;
/*  26 */     this.startTime = startTime;
/*  27 */     this.stopTime = stopTime;
/*  28 */     this.maxSpeed = maxSpeed;
/*  29 */     this.overspeedTime = overspeedTime;
/*     */   }
/*     */ 
/*     */   public int getRegionId() {
/*  33 */     return this.regionId;
/*     */   }
/*     */ 
/*     */   public void setRegionId(int regionId) {
/*  37 */     this.regionId = regionId;
/*     */   }
/*     */ 
/*     */   public RegionItemAttri getRegionAttribute() {
/*  41 */     return this.regionAttribute;
/*     */   }
/*     */ 
/*     */   public void setRegionAttribute(RegionItemAttri regionAttribute) {
/*  45 */     this.regionAttribute = regionAttribute;
/*     */   }
/*     */ 
/*     */   public int getLiftUpperLatitude() {
/*  49 */     return this.liftUpperLatitude;
/*     */   }
/*     */ 
/*     */   public void setLiftUpperLatitude(int liftUpperLatitude) {
/*  53 */     this.liftUpperLatitude = liftUpperLatitude;
/*     */   }
/*     */ 
/*     */   public int getLiftUpperLongitude() {
/*  57 */     return this.liftUpperLongitude;
/*     */   }
/*     */ 
/*     */   public void setLiftUpperLongitude(int liftUpperLongitude) {
/*  61 */     this.liftUpperLongitude = liftUpperLongitude;
/*     */   }
/*     */ 
/*     */   public int getRightLowerLatitude() {
/*  65 */     return this.rightLowerLatitude;
/*     */   }
/*     */ 
/*     */   public void setRightLowerLatitude(int rightLowerLatitude) {
/*  69 */     this.rightLowerLatitude = rightLowerLatitude;
/*     */   }
/*     */ 
/*     */   public int getRightLowerLongitude() {
/*  73 */     return this.rightLowerLongitude;
/*     */   }
/*     */ 
/*     */   public void setRightLowerLongitude(int rightLowerLongitude) {
/*  77 */     this.rightLowerLongitude = rightLowerLongitude;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/*  81 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime) {
/*  85 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/*  89 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime) {
/*  93 */     this.stopTime = stopTime;
/*     */   }
/*     */ 
/*     */   public short getMaxSpeed() {
/*  97 */     return this.maxSpeed;
/*     */   }
/*     */ 
/*     */   public void setMaxSpeed(short maxSpeed) {
/* 101 */     this.maxSpeed = maxSpeed;
/*     */   }
/*     */ 
/*     */   public byte getOverspeedTime() {
/* 105 */     return this.overspeedTime;
/*     */   }
/*     */ 
/*     */   public void setOverspeedTime(byte overspeedTime) {
/* 109 */     this.overspeedTime = overspeedTime;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.RectangleRegionItem
 * JD-Core Version:    0.6.1
 */