/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8401 extends JT808MsgBody
/*    */ {
/*    */   public static final byte SETTING_DELETE = 0;
/*    */   public static final byte SETTING_UPDATE = 1;
/*    */   public static final byte SETTING_ADD = 2;
/*    */   public static final byte SETTING_MODIFY = 3;
/*    */   private byte settingType;
/*    */   private byte contactCount;
/*    */   private List<JT808MsgBody_0x8401_item> contactItems;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!isBuildBody()) {
/* 25 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 26 */       this.bodyBuffer.put(this.settingType);
/* 27 */       this.bodyBuffer.put(this.contactCount);
/* 28 */       if (this.contactItems != null) {
/* 29 */         for (JT808MsgBody_0x8401_item item : this.contactItems) {
/* 30 */           item.bulidBody();
/* 31 */           this.bodyBuffer.put(item.getBodyBuffer());
/*    */         }
/*    */       }
/*    */ 
/* 35 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createPhoneDirectoryPack(String mobileNum, byte settingType, List<JT808MsgBody_0x8401_item> contactItems)
/*    */     throws Exception
/*    */   {
/* 55 */     UnitPackJT808 pack = new UnitPackJT808(33793);
/* 56 */     pack.setMobileNum(mobileNum);
/* 57 */     JT808MsgBody_0x8401 body = new JT808MsgBody_0x8401();
/* 58 */     body.setSettingType(settingType);
/* 59 */     if (contactItems != null) {
/* 60 */       body.setContactCount((byte)contactItems.size());
/*    */     }
/* 62 */     body.setContactItems(contactItems);
/* 63 */     pack.setMsgBody(body);
/* 64 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getSettingType() {
/* 68 */     return this.settingType;
/*    */   }
/*    */ 
/*    */   public void setSettingType(byte settingType) {
/* 72 */     this.settingType = settingType;
/*    */   }
/*    */ 
/*    */   public byte getContactCount() {
/* 76 */     return this.contactCount;
/*    */   }
/*    */ 
/*    */   public void setContactCount(byte contactCount) {
/* 80 */     this.contactCount = contactCount;
/*    */   }
/*    */ 
/*    */   public List<JT808MsgBody_0x8401_item> getContactItems() {
/* 84 */     return this.contactItems;
/*    */   }
/*    */ 
/*    */   public void setContactItems(List<JT808MsgBody_0x8401_item> contactItems) {
/* 88 */     this.contactItems = contactItems;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8401
 * JD-Core Version:    0.6.1
 */