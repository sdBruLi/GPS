/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import java.util.List;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8604 extends JT808MsgBody
/*     */ {
/*     */   private int regionId;
/*     */   private short regionAttribute;
/*  16 */   private String startTime = "";
/*  17 */   private String stopTime = "";
/*     */   private short maxSpeed;
/*     */   private byte overspeedTime;
/*     */   private short regionPeakCount;
/*     */   private List<JT808MsgBody_0x8604_peak_item> peakList;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  25 */     if (!isBuildBody()) {
/*  26 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/*  27 */       this.bodyBuffer.putInt(this.regionId);
/*  28 */       this.bodyBuffer.putShort(this.regionAttribute);
/*  29 */       if ((this.regionAttribute & 0x1) == 1) {
/*  30 */         this.bodyBuffer.put(ByteUtil.string2BCD(this.startTime, 6));
/*  31 */         this.bodyBuffer.put(ByteUtil.string2BCD(this.stopTime, 6));
/*     */       }
/*     */ 
/*  34 */       if ((this.regionAttribute >> 1 & 0x1) == 1) {
/*  35 */         this.bodyBuffer.putShort(this.maxSpeed);
/*  36 */         this.bodyBuffer.put(this.overspeedTime);
/*     */       }
/*  38 */       this.bodyBuffer.putShort(this.regionPeakCount);
/*  39 */       if (this.peakList != null) {
/*  40 */         for (JT808MsgBody_0x8604_peak_item item : this.peakList) {
/*  41 */           item.bulidBody();
/*  42 */           this.bodyBuffer.put(item.getBodyBuffer());
/*     */         }
/*     */       }
/*  45 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public static UnitPackJT808 createPolygonRegionPack(String mobileNum, int regionId, short regionAttribute, String startTime, String stopTime, short maxSpeed, byte overspeedTime, List<JT808MsgBody_0x8604_peak_item> peakList)
/*     */     throws Exception
/*     */   {
/*  71 */     UnitPackJT808 pack = new UnitPackJT808(34308);
/*  72 */     pack.setMobileNum(mobileNum);
/*  73 */     JT808MsgBody_0x8604 body = new JT808MsgBody_0x8604();
/*  74 */     body.setRegionId(regionId);
/*  75 */     body.setRegionAttribute(regionAttribute);
/*  76 */     if ((regionAttribute & 0x1) == 1) {
/*  77 */       body.setStartTime(startTime);
/*  78 */       body.setStopTime(stopTime);
/*     */     }
/*  80 */     if ((regionAttribute >> 1 & 0x1) == 1) {
/*  81 */       body.setMaxSpeed(maxSpeed);
/*  82 */       body.setOverspeedTime(overspeedTime);
/*     */     }
/*     */ 
/*  85 */     if (peakList != null) {
/*  86 */       body.setRegionPeakCount((short)peakList.size());
/*  87 */       body.setPeakList(peakList);
/*     */     }
/*  89 */     pack.setMsgBody(body);
/*  90 */     return pack;
/*     */   }
/*     */ 
/*     */   public int getRegionId() {
/*  94 */     return this.regionId;
/*     */   }
/*     */ 
/*     */   public void setRegionId(int regionId) {
/*  98 */     this.regionId = regionId;
/*     */   }
/*     */ 
/*     */   public short getRegionAttribute() {
/* 102 */     return this.regionAttribute;
/*     */   }
/*     */ 
/*     */   public void setRegionAttribute(short regionAttribute) {
/* 106 */     this.regionAttribute = regionAttribute;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/* 110 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime) {
/* 114 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 118 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime) {
/* 122 */     this.stopTime = stopTime;
/*     */   }
/*     */ 
/*     */   public short getMaxSpeed() {
/* 126 */     return this.maxSpeed;
/*     */   }
/*     */ 
/*     */   public void setMaxSpeed(short maxSpeed) {
/* 130 */     this.maxSpeed = maxSpeed;
/*     */   }
/*     */ 
/*     */   public byte getOverspeedTime() {
/* 134 */     return this.overspeedTime;
/*     */   }
/*     */ 
/*     */   public void setOverspeedTime(byte overspeedTime) {
/* 138 */     this.overspeedTime = overspeedTime;
/*     */   }
/*     */ 
/*     */   public short getRegionPeakCount() {
/* 142 */     return this.regionPeakCount;
/*     */   }
/*     */ 
/*     */   public void setRegionPeakCount(short regionPeakCount) {
/* 146 */     this.regionPeakCount = regionPeakCount;
/*     */   }
/*     */ 
/*     */   public List<JT808MsgBody_0x8604_peak_item> getPeakList() {
/* 150 */     return this.peakList;
/*     */   }
/*     */ 
/*     */   public void setPeakList(List<JT808MsgBody_0x8604_peak_item> peakList) {
/* 154 */     this.peakList = peakList;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8604
 * JD-Core Version:    0.6.1
 */