/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8301;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8301_item;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class EventSettingMessage extends BaseDownMessage
/*    */ {
/*    */   public static final byte SETTING_DELETE = 0;
/*    */   public static final byte SETTING_UPDATE = 1;
/*    */   public static final byte SETTING_ADD = 2;
/*    */   public static final byte SETTING_MODIFY = 3;
/*    */   public static final byte SETTING_DEL_ITEMS = 4;
/*    */   private byte settingType;
/*    */   private byte count;
/*    */   private List<EventItem> eventItems;
/*    */ 
/*    */   public EventSettingMessage(String mobileNum, String messageKey, byte settingType, List<EventItem> eventItems)
/*    */   {
/* 42 */     setMobileNum(mobileNum);
/* 43 */     setMessageKey(messageKey);
/* 44 */     setSettingType(settingType);
/* 45 */     setEventItems(eventItems);
/* 46 */     setCommand("0x8301");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 51 */     UnitPackJT808 pack = new UnitPackJT808(33537);
/* 52 */     pack.setMobileNum(getMobileNum());
/* 53 */     JT808MsgBody_0x8301 body = new JT808MsgBody_0x8301();
/* 54 */     body.setSettingType(this.settingType);
/* 55 */     List eventList = null;
/* 56 */     if (this.eventItems != null) {
/* 57 */       body.setCount((byte)this.eventItems.size());
/* 58 */       for (EventItem i : this.eventItems) {
/* 59 */         if (eventList == null) {
/* 60 */           eventList = new ArrayList();
/*    */         }
/* 62 */         JT808MsgBody_0x8301_item item = new JT808MsgBody_0x8301_item();
/* 63 */         item.setEventId(i.getEventId());
/* 64 */         item.setEventContent(i.getEventContent());
/* 65 */         item.setEventContentLen((byte)i.getEventContent().getBytes("GBK").length);
/* 66 */         eventList.add(item);
/*    */       }
/* 68 */       body.setEventItems(eventList);
/*    */     }
/* 70 */     pack.setMsgBody(body);
/* 71 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getSettingType() {
/* 75 */     return this.settingType;
/*    */   }
/*    */ 
/*    */   public void setSettingType(byte settingType)
/*    */   {
/* 80 */     this.settingType = settingType;
/*    */   }
/*    */ 
/*    */   public byte getCount() {
/* 84 */     return this.count;
/*    */   }
/*    */ 
/*    */   public void setCount(byte count)
/*    */   {
/* 89 */     this.count = count;
/*    */   }
/*    */ 
/*    */   public List<EventItem> getEventItems() {
/* 93 */     return this.eventItems;
/*    */   }
/*    */ 
/*    */   public void setEventItems(List<EventItem> eventItems)
/*    */   {
/* 98 */     this.eventItems = eventItems;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.EventSettingMessage
 * JD-Core Version:    0.6.1
 */