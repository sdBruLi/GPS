/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ public class CircleRegionItem
/*    */ {
/*    */   private int regionId;
/*    */   private RegionItemAttri regionAttribute;
/*    */   private int centerLatitude;
/*    */   private int centerLongitude;
/*    */   private int radius;
/* 10 */   private String startTime = "";
/* 11 */   private String stopTime = "";
/*    */   private short maxSpeed;
/*    */   private byte overspeedTime;
/*    */ 
/*    */   public CircleRegionItem(int regionId, RegionItemAttri regionAttribute, int centerLatitude, int centerLongitude, int radius, String startTime, String stopTime, short maxSpeed, byte overspeedTime)
/*    */   {
/* 19 */     this.regionId = regionId;
/* 20 */     this.regionAttribute = regionAttribute;
/* 21 */     this.centerLatitude = centerLatitude;
/* 22 */     this.centerLongitude = centerLongitude;
/* 23 */     this.radius = radius;
/* 24 */     this.startTime = startTime;
/* 25 */     this.stopTime = stopTime;
/* 26 */     this.maxSpeed = maxSpeed;
/* 27 */     this.overspeedTime = overspeedTime;
/*    */   }
/*    */   public int getRegionId() {
/* 30 */     return this.regionId;
/*    */   }
/*    */ 
/*    */   public void setRegionId(int regionId) {
/* 34 */     this.regionId = regionId;
/*    */   }
/*    */ 
/*    */   public RegionItemAttri getRegionAttribute() {
/* 38 */     return this.regionAttribute;
/*    */   }
/*    */ 
/*    */   public void setRegionAttribute(RegionItemAttri regionAttribute) {
/* 42 */     this.regionAttribute = regionAttribute;
/*    */   }
/*    */ 
/*    */   public int getCenterLatitude() {
/* 46 */     return this.centerLatitude;
/*    */   }
/*    */ 
/*    */   public void setCenterLatitude(int centerLatitude) {
/* 50 */     this.centerLatitude = centerLatitude;
/*    */   }
/*    */ 
/*    */   public int getCenterLongitude() {
/* 54 */     return this.centerLongitude;
/*    */   }
/*    */ 
/*    */   public void setCenterLongitude(int centerLongitude) {
/* 58 */     this.centerLongitude = centerLongitude;
/*    */   }
/*    */ 
/*    */   public int getRadius() {
/* 62 */     return this.radius;
/*    */   }
/*    */ 
/*    */   public void setRadius(int radius) {
/* 66 */     this.radius = radius;
/*    */   }
/*    */ 
/*    */   public String getStartTime() {
/* 70 */     return this.startTime;
/*    */   }
/*    */ 
/*    */   public void setStartTime(String startTime) {
/* 74 */     this.startTime = startTime;
/*    */   }
/*    */ 
/*    */   public String getStopTime() {
/* 78 */     return this.stopTime;
/*    */   }
/*    */ 
/*    */   public void setStopTime(String stopTime) {
/* 82 */     this.stopTime = stopTime;
/*    */   }
/*    */ 
/*    */   public short getMaxSpeed() {
/* 86 */     return this.maxSpeed;
/*    */   }
/*    */ 
/*    */   public void setMaxSpeed(short maxSpeed) {
/* 90 */     this.maxSpeed = maxSpeed;
/*    */   }
/*    */ 
/*    */   public byte getOverspeedTime() {
/* 94 */     return this.overspeedTime;
/*    */   }
/*    */ 
/*    */   public void setOverspeedTime(byte overspeedTime) {
/* 98 */     this.overspeedTime = overspeedTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.CircleRegionItem
 * JD-Core Version:    0.6.1
 */