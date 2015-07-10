/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8401;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8401_item;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SettingPhoneDirectoryMessage extends BaseDownMessage
/*    */ {
/*    */   public static final byte SETTING_DELETE = 0;
/*    */   public static final byte SETTING_UPDATE = 1;
/*    */   public static final byte SETTING_ADD = 2;
/*    */   public static final byte SETTING_MODIFY = 3;
/*    */   private byte settingType;
/*    */   private byte contactCount;
/*    */   private List<PhoneDirectoryContactItem> contactItems;
/*    */ 
/*    */   public SettingPhoneDirectoryMessage(String mobileNum, String messageKey, byte settingType, List<PhoneDirectoryContactItem> contactItems)
/*    */   {
/* 38 */     setMobileNum(mobileNum);
/* 39 */     setMessageKey(messageKey);
/* 40 */     setSettingType(settingType);
/* 41 */     if (contactItems != null) {
/* 42 */       setContactCount((byte)contactItems.size());
/* 43 */       setContactItems(contactItems);
/*    */     }
/* 45 */     setCommand("0x8401");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 50 */     UnitPackJT808 pack = new UnitPackJT808(33793);
/* 51 */     pack.setMobileNum(getMobileNum());
/* 52 */     JT808MsgBody_0x8401 body = new JT808MsgBody_0x8401();
/* 53 */     body.setSettingType(getSettingType());
/* 54 */     if (this.contactItems != null) {
/* 55 */       body.setContactCount(getContactCount());
/* 56 */       List contactItemList = new ArrayList();
/* 57 */       for (PhoneDirectoryContactItem item : this.contactItems) {
/* 58 */         JT808MsgBody_0x8401_item i = new JT808MsgBody_0x8401_item();
/* 59 */         i.setContact(item.getContact());
/* 60 */         i.setContactLen(item.getContactLen());
/* 61 */         i.setNumberLen(item.getNumberLen());
/* 62 */         i.setPhoneNum(item.getPhoneNum());
/* 63 */         i.setSign(item.getSign());
/* 64 */         contactItemList.add(i);
/*    */       }
/* 66 */       body.setContactItems(contactItemList);
/*    */     }
/*    */ 
/* 69 */     pack.setMsgBody(body);
/* 70 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getSettingType() {
/* 74 */     return this.settingType;
/*    */   }
/*    */ 
/*    */   public void setSettingType(byte settingType)
/*    */   {
/* 79 */     this.settingType = settingType;
/*    */   }
/*    */ 
/*    */   public byte getContactCount() {
/* 83 */     return this.contactCount;
/*    */   }
/*    */ 
/*    */   public void setContactCount(byte contactCount)
/*    */   {
/* 88 */     this.contactCount = contactCount;
/*    */   }
/*    */ 
/*    */   public List<PhoneDirectoryContactItem> getContactItems() {
/* 92 */     return this.contactItems;
/*    */   }
/*    */ 
/*    */   public void setContactItems(List<PhoneDirectoryContactItem> contactItems)
/*    */   {
/* 97 */     this.contactItems = contactItems;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SettingPhoneDirectoryMessage
 * JD-Core Version:    0.6.1
 */