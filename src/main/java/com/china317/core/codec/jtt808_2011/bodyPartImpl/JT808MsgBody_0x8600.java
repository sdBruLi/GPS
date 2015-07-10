/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8600 extends JT808MsgBody
/*    */ {
/*    */   public static final byte SETTING_UPDATE = 0;
/*    */   public static final byte SETTING_ADD = 1;
/*    */   public static final byte SETTING_MODIFY = 2;
/*    */   private byte settingType;
/*    */   private byte regionCount;
/*    */   private List<JT808MsgBody_0x8600_region_item> regionItems;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!isBuildBody()) {
/* 24 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 25 */       this.bodyBuffer.put(this.settingType);
/* 26 */       this.bodyBuffer.put(this.regionCount);
/* 27 */       if (this.regionItems != null) {
/* 28 */         for (JT808MsgBody_0x8600_region_item item : this.regionItems) {
/* 29 */           item.bulidBody();
/* 30 */           this.bodyBuffer.put(item.getBodyBuffer());
/*    */         }
/*    */       }
/* 33 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createCircleRegionPack(String mobileNum, byte settingType, List<JT808MsgBody_0x8600_region_item> regionItems)
/*    */     throws Exception
/*    */   {
/* 51 */     UnitPackJT808 pack = new UnitPackJT808(34304);
/* 52 */     pack.setMobileNum(mobileNum);
/* 53 */     JT808MsgBody_0x8600 body = new JT808MsgBody_0x8600();
/* 54 */     body.setSettingType(settingType);
/* 55 */     if (regionItems != null) {
/* 56 */       body.setRegionCount((byte)regionItems.size());
/*    */     }
/* 58 */     body.setRegionItems(regionItems);
/* 59 */     pack.setMsgBody(body);
/* 60 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getSettingType() {
/* 64 */     return this.settingType;
/*    */   }
/*    */ 
/*    */   public void setSettingType(byte settingType) {
/* 68 */     this.settingType = settingType;
/*    */   }
/*    */ 
/*    */   public byte getRegionCount() {
/* 72 */     return this.regionCount;
/*    */   }
/*    */ 
/*    */   public void setRegionCount(byte regionCount) {
/* 76 */     this.regionCount = regionCount;
/*    */   }
/*    */ 
/*    */   public List<JT808MsgBody_0x8600_region_item> getRegionItems() {
/* 80 */     return this.regionItems;
/*    */   }
/*    */ 
/*    */   public void setRegionItems(List<JT808MsgBody_0x8600_region_item> regionItems) {
/* 84 */     this.regionItems = regionItems;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8600
 * JD-Core Version:    0.6.1
 */