/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8604;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8604_peak_item;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SettingPolygonRegionMessage extends BaseDownMessage
/*     */ {
/*     */   private int regionId;
/*     */   private RegionItemAttri regionAttribute;
/*  21 */   private String startTime = "";
/*  22 */   private String stopTime = "";
/*     */   private short maxSpeed;
/*     */   private byte overspeedTime;
/*     */   private short regionPeakCount;
/*     */   private List<PolygonPeakItem> peakList;
/*     */ 
/*     */   public SettingPolygonRegionMessage(String mobileNum, String messageKey, int regionId, RegionItemAttri regionAttribute, String startTime, String stopTime, short maxSpeed, byte overspeedTime, List<PolygonPeakItem> peakList)
/*     */   {
/*  52 */     setMobileNum(mobileNum);
/*  53 */     setMessageKey(messageKey);
/*  54 */     setRegionId(regionId);
/*  55 */     setRegionAttribute(regionAttribute);
/*  56 */     setStartTime(startTime);
/*  57 */     setStopTime(stopTime);
/*  58 */     setMaxSpeed(maxSpeed);
/*  59 */     setOverspeedTime(overspeedTime);
/*  60 */     setPeakList(peakList);
/*  61 */     setCommand("0x8604");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception
/*     */   {
/*  66 */     UnitPackJT808 pack = new UnitPackJT808(34308);
/*  67 */     pack.setMobileNum(getMobileNum());
/*  68 */     JT808MsgBody_0x8604 body = new JT808MsgBody_0x8604();
/*  69 */     body.setRegionId(getRegionId());
/*  70 */     body.setRegionAttribute(getRegionAttribute().getAttribute());
/*  71 */     if ((getRegionAttribute().getAttribute() & 0x1) == 1) {
/*  72 */       body.setStartTime(this.startTime);
/*  73 */       body.setStopTime(this.stopTime);
/*     */     }
/*  75 */     if ((getRegionAttribute().getAttribute() >> 1 & 0x1) == 1) {
/*  76 */       body.setMaxSpeed(this.maxSpeed);
/*  77 */       body.setOverspeedTime(this.overspeedTime);
/*     */     }
/*     */ 
/*  80 */     if (this.peakList != null) {
/*  81 */       List peakLists = new ArrayList();
/*  82 */       for (PolygonPeakItem item : this.peakList) {
/*  83 */         JT808MsgBody_0x8604_peak_item i = new JT808MsgBody_0x8604_peak_item();
/*  84 */         i.setPeakLatitude(item.getPeakLatitude());
/*  85 */         i.setPeakLongitude(item.getPeakLongitude());
/*  86 */         peakLists.add(i);
/*     */       }
/*  88 */       body.setRegionPeakCount((short)peakLists.size());
/*  89 */       body.setPeakList(peakLists);
/*     */     }
/*  91 */     pack.setMsgBody(body);
/*  92 */     return pack;
/*     */   }
/*     */ 
/*     */   public int getRegionId() {
/*  96 */     return this.regionId;
/*     */   }
/*     */ 
/*     */   public void setRegionId(int regionId)
/*     */   {
/* 101 */     this.regionId = regionId;
/*     */   }
/*     */ 
/*     */   public RegionItemAttri getRegionAttribute() {
/* 105 */     return this.regionAttribute;
/*     */   }
/*     */ 
/*     */   public void setRegionAttribute(RegionItemAttri regionAttribute)
/*     */   {
/* 110 */     this.regionAttribute = regionAttribute;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/* 114 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime)
/*     */   {
/* 119 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 123 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime)
/*     */   {
/* 128 */     this.stopTime = stopTime;
/*     */   }
/*     */ 
/*     */   public short getMaxSpeed() {
/* 132 */     return this.maxSpeed;
/*     */   }
/*     */ 
/*     */   public void setMaxSpeed(short maxSpeed)
/*     */   {
/* 137 */     this.maxSpeed = maxSpeed;
/*     */   }
/*     */ 
/*     */   public byte getOverspeedTime() {
/* 141 */     return this.overspeedTime;
/*     */   }
/*     */ 
/*     */   public void setOverspeedTime(byte overspeedTime)
/*     */   {
/* 146 */     this.overspeedTime = overspeedTime;
/*     */   }
/*     */ 
/*     */   public short getRegionPeakCount() {
/* 150 */     return this.regionPeakCount;
/*     */   }
/*     */ 
/*     */   public void setRegionPeakCount(short regionPeakCount)
/*     */   {
/* 155 */     this.regionPeakCount = regionPeakCount;
/*     */   }
/*     */ 
/*     */   public List<PolygonPeakItem> getPeakList() {
/* 159 */     return this.peakList;
/*     */   }
/*     */ 
/*     */   public void setPeakList(List<PolygonPeakItem> peakList)
/*     */   {
/* 164 */     this.peakList = peakList;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SettingPolygonRegionMessage
 * JD-Core Version:    0.6.1
 */