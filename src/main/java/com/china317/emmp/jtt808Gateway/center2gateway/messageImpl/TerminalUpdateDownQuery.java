/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8108;
/*    */ 
/*    */ public class TerminalUpdateDownQuery extends BaseDownMessage
/*    */ {
/*    */   private byte updateType;
/*    */   private String manufacturerId;
/*    */   private String version;
/*    */   private byte[] datapackage;
/*    */ 
/*    */   public TerminalUpdateDownQuery(String mobileNum, String messageKey, byte updateType, String manufacturerId, String version, byte[] datapackage)
/*    */   {
/* 20 */     setCommand("0x8108");
/* 21 */     setMobileNum(mobileNum);
/* 22 */     setMessageKey(messageKey);
/* 23 */     this.updateType = updateType;
/* 24 */     this.datapackage = datapackage;
/* 25 */     this.version = version;
/* 26 */     this.manufacturerId = manufacturerId;
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 31 */     UnitPackJT808 pack = new UnitPackJT808(33032);
/* 32 */     pack.setMobileNum(getMobileNum());
/* 33 */     JT808MsgBody_0x8108 body = new JT808MsgBody_0x8108();
/* 34 */     body.setUpdateType(this.updateType);
/* 35 */     body.setDatapackage(this.datapackage);
/* 36 */     body.setManufacturerId(this.manufacturerId);
/* 37 */     body.setVersion(this.version);
/* 38 */     pack.setMsgBody(body);
/* 39 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getUpdateType() {
/* 43 */     return this.updateType;
/*    */   }
/*    */ 
/*    */   public void setUpdateType(byte updateType) {
/* 47 */     this.updateType = updateType;
/*    */   }
/*    */ 
/*    */   public String getManufacturerId() {
/* 51 */     return this.manufacturerId;
/*    */   }
/*    */ 
/*    */   public void setManufacturerId(String manufacturerId) {
/* 55 */     this.manufacturerId = manufacturerId;
/*    */   }
/*    */ 
/*    */   public String getVersion() {
/* 59 */     return this.version;
/*    */   }
/*    */ 
/*    */   public void setVersion(String version) {
/* 63 */     this.version = version;
/*    */   }
/*    */ 
/*    */   public byte[] getDatapackage() {
/* 67 */     return this.datapackage;
/*    */   }
/*    */ 
/*    */   public void setDatapackage(byte[] datapackage) {
/* 71 */     this.datapackage = datapackage;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TerminalUpdateDownQuery
 * JD-Core Version:    0.6.1
 */