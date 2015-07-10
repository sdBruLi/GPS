/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8303 extends JT808MsgBody
/*    */ {
/*    */   public static final byte SETTING_DELETE = 0;
/*    */   public static final byte SETTING_UPDATE = 1;
/*    */   public static final byte SETTING_ADD = 2;
/*    */   public static final byte SETTING_MODIFY = 3;
/*    */   private byte settingType;
/*    */   private byte infoItemCount;
/*    */   private List<JT808MsgBody_0x8303_item> infoItems;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!isBuildBody()) {
/* 25 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 26 */       this.bodyBuffer.put(this.settingType);
/* 27 */       this.bodyBuffer.put(this.infoItemCount);
/* 28 */       if (this.infoItems != null) {
/* 29 */         for (JT808MsgBody_0x8303_item item : this.infoItems) {
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
/*    */   public static UnitPackJT808 createInfoOrderMenuSetting(String mobileNum, byte settingType, List<JT808MsgBody_0x8303_item> infoItems)
/*    */     throws Exception
/*    */   {
/* 55 */     UnitPackJT808 pack = new UnitPackJT808(33539);
/* 56 */     pack.setMobileNum(mobileNum);
/* 57 */     JT808MsgBody_0x8303 body = new JT808MsgBody_0x8303();
/* 58 */     body.setSettingType(settingType);
/* 59 */     if (infoItems != null) {
/* 60 */       body.setInfoItemCount((byte)infoItems.size());
/*    */     }
/* 62 */     body.setInfoItems(infoItems);
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
/*    */   public byte getInfoItemCount() {
/* 76 */     return this.infoItemCount;
/*    */   }
/*    */ 
/*    */   public void setInfoItemCount(byte infoItemCount) {
/* 80 */     this.infoItemCount = infoItemCount;
/*    */   }
/*    */ 
/*    */   public List<JT808MsgBody_0x8303_item> getInfoItems() {
/* 84 */     return this.infoItems;
/*    */   }
/*    */ 
/*    */   public void setInfoItems(List<JT808MsgBody_0x8303_item> infoItems) {
/* 88 */     this.infoItems = infoItems;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8303
 * JD-Core Version:    0.6.1
 */