/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8602;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8602_region_item;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SettingRectangleRegionMessage extends BaseDownMessage
/*     */ {
/*     */   public static final byte SETTING_UPDATE = 0;
/*     */   public static final byte SETTING_ADD = 1;
/*     */   public static final byte SETTING_MODIFY = 2;
/*     */   private byte settingType;
/*     */   private byte regionCount;
/*     */   private List<RectangleRegionItem> regionItems;
/*     */ 
/*     */   public SettingRectangleRegionMessage(String mobileNum, String messageKey, byte settingType, List<RectangleRegionItem> regionItems)
/*     */   {
/*  40 */     setMobileNum(mobileNum);
/*  41 */     setMessageKey(messageKey);
/*  42 */     setSettingType(settingType);
/*  43 */     if (regionItems != null) {
/*  44 */       setRegionCount((byte)regionItems.size());
/*     */     }
/*  46 */     setRegionItems(regionItems);
/*  47 */     setCommand("0x8602");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception
/*     */   {
/*  52 */     UnitPackJT808 pack = new UnitPackJT808(34306);
/*  53 */     pack.setMobileNum(getMobileNum());
/*  54 */     JT808MsgBody_0x8602 body = new JT808MsgBody_0x8602();
/*  55 */     body.setSettingType(getSettingType());
/*  56 */     body.setRegionCount(getRegionCount());
/*  57 */     List regionItemList = null;
/*  58 */     if (this.regionItems != null) {
/*  59 */       for (RectangleRegionItem item : this.regionItems) {
/*  60 */         if (regionItemList == null) {
/*  61 */           regionItemList = new ArrayList();
/*     */         }
/*  63 */         JT808MsgBody_0x8602_region_item i = new JT808MsgBody_0x8602_region_item();
/*  64 */         i.setLiftUpperLatitude(item.getLiftUpperLatitude());
/*  65 */         i.setLiftUpperLongitude(item.getLiftUpperLongitude());
/*  66 */         i.setMaxSpeed(item.getMaxSpeed());
/*  67 */         i.setOverspeedTime(item.getOverspeedTime());
/*  68 */         i.setRegionAttribute(item.getRegionAttribute().getAttribute());
/*  69 */         i.setRegionId(item.getRegionId());
/*  70 */         i.setRightLowerLatitude(item.getRightLowerLatitude());
/*  71 */         i.setRightLowerLongitude(item.getRightLowerLongitude());
/*  72 */         i.setStartTime(item.getStartTime());
/*  73 */         i.setStopTime(item.getStopTime());
/*  74 */         regionItemList.add(i);
/*     */       }
/*  76 */       body.setRegionItems(regionItemList);
/*     */     }
/*     */ 
/*  79 */     pack.setMsgBody(body);
/*  80 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getSettingType() {
/*  84 */     return this.settingType;
/*     */   }
/*     */ 
/*     */   public void setSettingType(byte settingType)
/*     */   {
/*  89 */     this.settingType = settingType;
/*     */   }
/*     */ 
/*     */   public byte getRegionCount() {
/*  93 */     return this.regionCount;
/*     */   }
/*     */ 
/*     */   public void setRegionCount(byte regionCount)
/*     */   {
/*  98 */     this.regionCount = regionCount;
/*     */   }
/*     */ 
/*     */   public List<RectangleRegionItem> getRegionItems() {
/* 102 */     return this.regionItems;
/*     */   }
/*     */ 
/*     */   public void setRegionItems(List<RectangleRegionItem> regionItems)
/*     */   {
/* 107 */     this.regionItems = regionItems;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SettingRectangleRegionMessage
 * JD-Core Version:    0.6.1
 */