/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8303;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8303_item;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SettingInfoOrderMenuMsg extends BaseDownMessage
/*     */ {
/*     */   public static final byte SETTING_DELETE = 0;
/*     */   public static final byte SETTING_UPDATE = 1;
/*     */   public static final byte SETTING_ADD = 2;
/*     */   public static final byte SETTING_MODIFY = 3;
/*     */   private byte settingType;
/*     */   private byte infoItemCount;
/*     */   private List<OrderInfoItem> infoItems;
/*     */ 
/*     */   public SettingInfoOrderMenuMsg(String mobileNum, String messageKey, byte settingType, List<OrderInfoItem> infoItems)
/*     */   {
/*  44 */     setMobileNum(mobileNum);
/*  45 */     setMessageKey(messageKey);
/*  46 */     setSettingType(settingType);
/*  47 */     if (infoItems != null) {
/*  48 */       setInfoItemCount((byte)infoItems.size());
/*  49 */       setInfoItems(infoItems);
/*     */     }
/*     */ 
/*  52 */     setCommand("0x8303");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception
/*     */   {
/*  57 */     UnitPackJT808 pack = new UnitPackJT808(33539);
/*  58 */     pack.setMobileNum(getMobileNum());
/*  59 */     JT808MsgBody_0x8303 body = new JT808MsgBody_0x8303();
/*  60 */     body.setSettingType(getSettingType());
/*  61 */     if (this.infoItems != null) {
/*  62 */       body.setInfoItemCount((byte)this.infoItems.size());
/*  63 */       List infoItemList = new ArrayList();
/*  64 */       for (OrderInfoItem item : this.infoItems) {
/*  65 */         JT808MsgBody_0x8303_item i = new JT808MsgBody_0x8303_item();
/*  66 */         i.setInfoName(item.getInfoName());
/*  67 */         i.setInfoNameLen(item.getInfoNameLen());
/*  68 */         i.setInfoType(item.getInfoType());
/*  69 */         infoItemList.add(i);
/*     */       }
/*  71 */       body.setInfoItems(infoItemList);
/*     */     }
/*     */ 
/*  74 */     pack.setMsgBody(body);
/*  75 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getSettingType() {
/*  79 */     return this.settingType;
/*     */   }
/*     */ 
/*     */   public void setSettingType(byte settingType)
/*     */   {
/*  84 */     this.settingType = settingType;
/*     */   }
/*     */ 
/*     */   public byte getInfoItemCount() {
/*  88 */     return this.infoItemCount;
/*     */   }
/*     */ 
/*     */   public void setInfoItemCount(byte infoItemCount)
/*     */   {
/*  93 */     this.infoItemCount = infoItemCount;
/*     */   }
/*     */ 
/*     */   public List<OrderInfoItem> getInfoItems() {
/*  97 */     return this.infoItems;
/*     */   }
/*     */ 
/*     */   public void setInfoItems(List<OrderInfoItem> infoItems)
/*     */   {
/* 102 */     this.infoItems = infoItems;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SettingInfoOrderMenuMsg
 * JD-Core Version:    0.6.1
 */