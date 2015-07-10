/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8301 extends JT808MsgBody
/*     */ {
/*     */   public static final byte SETTING_DELETE = 0;
/*     */   public static final byte SETTING_UPDATE = 1;
/*     */   public static final byte SETTING_ADD = 2;
/*     */   public static final byte SETTING_MODIFY = 3;
/*     */   public static final byte SETTING_DEL_ITEMS = 4;
/*     */   private byte settingType;
/*     */   private byte count;
/*     */   private List<JT808MsgBody_0x8301_item> eventItems;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  27 */     if (!isBuildBody()) {
/*  28 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/*  29 */       this.bodyBuffer.put(this.settingType);
/*  30 */       if (this.settingType != 0) {
/*  31 */         this.bodyBuffer.put(this.count);
/*  32 */         if ((this.eventItems != null) && (this.eventItems.size() > 0)) {
/*  33 */           for (JT808MsgBody_0x8301_item item : this.eventItems) {
/*  34 */             item.bulidBody();
/*  35 */             this.bodyBuffer.put(item.getBodyBuffer());
/*     */           }
/*     */         }
/*     */       }
/*  39 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*  45 */     this.settingType = this.bodyBuffer.get();
/*  46 */     if (this.settingType != 0) {
/*  47 */       this.count = this.bodyBuffer.get();
/*  48 */       for (int i = 0; i < this.count; i++) {
/*  49 */         if (this.eventItems == null) {
/*  50 */           this.eventItems = new ArrayList();
/*     */         }
/*  52 */         JT808MsgBody_0x8301_item item = new JT808MsgBody_0x8301_item();
/*  53 */         item.setEventId(this.bodyBuffer.get());
/*  54 */         item.setEventContentLen(this.bodyBuffer.get());
/*  55 */         item.setEventContent(this.bodyBuffer.getString(item.getEventContentLen(), DefaultCharset.decoder));
/*     */ 
/*  57 */         this.eventItems.add(item);
/*     */       }
/*     */     }
/*  60 */     this.bodyBuffer.rewind();
/*     */   }
/*     */ 
/*     */   public static UnitPackJT808 createSettingPack(String mobileNum, byte settingType, List<JT808MsgBody_0x8301_item> eventItems)
/*     */     throws Exception
/*     */   {
/*  74 */     UnitPackJT808 pack = new UnitPackJT808(33537);
/*  75 */     pack.setMobileNum(mobileNum);
/*  76 */     JT808MsgBody_0x8301 body = new JT808MsgBody_0x8301();
/*  77 */     body.setSettingType(settingType);
/*  78 */     if (eventItems != null) {
/*  79 */       body.setCount((byte)eventItems.size());
/*     */     }
/*  81 */     body.setEventItems(eventItems);
/*  82 */     pack.setMsgBody(body);
/*  83 */     return pack;
/*     */   }
/*     */ 
/*     */   public byte getSettingType() {
/*  87 */     return this.settingType;
/*     */   }
/*     */ 
/*     */   public void setSettingType(byte settingType) {
/*  91 */     this.settingType = settingType;
/*     */   }
/*     */ 
/*     */   public byte getCount() {
/*  95 */     return this.count;
/*     */   }
/*     */ 
/*     */   public void setCount(byte count) {
/*  99 */     this.count = count;
/*     */   }
/*     */ 
/*     */   public List<JT808MsgBody_0x8301_item> getEventItems() {
/* 103 */     return this.eventItems;
/*     */   }
/*     */ 
/*     */   public void setEventItems(List<JT808MsgBody_0x8301_item> eventItems) {
/* 107 */     this.eventItems = eventItems;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8301
 * JD-Core Version:    0.6.1
 */