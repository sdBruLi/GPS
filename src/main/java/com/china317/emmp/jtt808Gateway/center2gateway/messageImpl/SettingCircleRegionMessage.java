/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8600;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8600_region_item;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SettingCircleRegionMessage extends BaseDownMessage
/*     */ {
/*     */   public static final byte SETTING_UPDATE = 0;
/*     */   public static final byte SETTING_ADD = 1;
/*     */   public static final byte SETTING_MODIFY = 2;
/*     */   private byte settingType;
/*     */   private byte regionCount;
/*     */   private List<CircleRegionItem> regionItems;
/*     */ 
/*     */   public SettingCircleRegionMessage(String mobileNum, String messageKey, byte settingType, List<CircleRegionItem> regionItems)
/*     */   {
/*  40 */     setMobileNum(mobileNum);
/*  41 */     setMessageKey(messageKey);
/*  42 */     if (regionItems != null) {
/*  43 */       setRegionCount((byte)regionItems.size());
/*     */     }
/*  45 */     setSettingType(settingType);
/*  46 */     setRegionItems(regionItems);
/*  47 */     setCommand("0x8600");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception
/*     */   {
/*  52 */     UnitPackJT808 pack = new UnitPackJT808(34304);
/*  53 */     pack.setMobileNum(getMobileNum());
/*  54 */     JT808MsgBody_0x8600 body = new JT808MsgBody_0x8600();
/*  55 */     body.setSettingType(getSettingType());
/*  56 */     body.setRegionCount(getRegionCount());
/*  57 */     List regionItemList = null;
/*  58 */     if (this.regionItems != null) {
/*  59 */       for (CircleRegionItem item : this.regionItems) {
/*  60 */         if (regionItemList == null) {
/*  61 */           regionItemList = new ArrayList();
/*     */         }
/*  63 */         JT808MsgBody_0x8600_region_item i = new JT808MsgBody_0x8600_region_item();
/*  64 */         i.setCenterLatitude(item.getCenterLatitude());
/*  65 */         i.setCenterLongitude(item.getCenterLongitude());
/*  66 */         i.setMaxSpeed(item.getMaxSpeed());
/*  67 */         i.setOverspeedTime(item.getOverspeedTime());
/*  68 */         i.setRadius(item.getRadius());
/*  69 */         i.setRegionId(item.getRegionId());
/*  70 */         i.setRegionAttribute(item.getRegionAttribute().getAttribute());
/*  71 */         i.setStartTime(item.getStartTime());
/*  72 */         i.setStopTime(item.getStopTime());
/*     */ 
/*  74 */         regionItemList.add(i);
/*     */       }
/*  76 */       body.setRegionItems(regionItemList);
/*     */     }
/*  78 */     pack.setMsgBody(body);
/*  79 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getSettingType() {
/*  83 */     return this.settingType;
/*     */   }
/*     */ 
/*     */   public void setSettingType(byte settingType)
/*     */   {
/*  88 */     this.settingType = settingType;
/*     */   }
/*     */ 
/*     */   public byte getRegionCount() {
/*  92 */     return this.regionCount;
/*     */   }
/*     */ 
/*     */   public void setRegionCount(byte regionCount)
/*     */   {
/*  97 */     this.regionCount = regionCount;
/*     */   }
/*     */ 
/*     */   public List<CircleRegionItem> getRegionItems() {
/* 101 */     return this.regionItems;
/*     */   }
/*     */ 
/*     */   public void setRegionItems(List<CircleRegionItem> regionItems)
/*     */   {
/* 106 */     this.regionItems = regionItems;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SettingCircleRegionMessage
 * JD-Core Version:    0.6.1
 */