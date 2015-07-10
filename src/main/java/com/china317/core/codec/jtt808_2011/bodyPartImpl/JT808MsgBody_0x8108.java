/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8108 extends JT808MsgBody
/*    */ {
/*    */   private byte updateType;
/*    */   private String manufacturerId;
/*    */   private String version;
/*    */   private byte[] datapackage;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!isBuildBody()) {
/* 24 */       this.bodyBuffer = IoBuffer.allocate(7).setAutoExpand(true);
/* 25 */       this.bodyBuffer.put(this.updateType);
/* 26 */       this.bodyBuffer.put(com.china317.core.codec.jtt808_2011.util.ByteUtil.string2BCD(this.manufacturerId, 5));
/* 27 */       this.bodyBuffer.put((byte)this.version.length());
/* 28 */       this.bodyBuffer.put(this.version.getBytes("GBK"));
/* 29 */       this.bodyBuffer.put(com.china317.core.util.ByteUtil.number2Bytes(this.datapackage.length, 4));
/* 30 */       this.bodyBuffer.put(this.datapackage);
/* 31 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 updateDownCMD(String mobileNum, byte updateType, String manufacturerId, String version, byte[] datapackage)
/*    */     throws Exception
/*    */   {
/* 57 */     UnitPackJT808 pack = new UnitPackJT808(33032);
/* 58 */     pack.setMobileNum(mobileNum);
/* 59 */     JT808MsgBody_0x8108 body = new JT808MsgBody_0x8108();
/* 60 */     body.setUpdateType(updateType);
/* 61 */     body.setDatapackage(datapackage);
/* 62 */     body.setManufacturerId(manufacturerId);
/* 63 */     body.setVersion(version);
/* 64 */     pack.setMsgBody(body);
/* 65 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getUpdateType() {
/* 69 */     return this.updateType;
/*    */   }
/*    */ 
/*    */   public void setUpdateType(byte updateType) {
/* 73 */     this.updateType = updateType;
/*    */   }
/*    */ 
/*    */   public String getManufacturerId() {
/* 77 */     return this.manufacturerId;
/*    */   }
/*    */ 
/*    */   public void setManufacturerId(String manufacturerId) {
/* 81 */     this.manufacturerId = manufacturerId;
/*    */   }
/*    */ 
/*    */   public String getVersion() {
/* 85 */     return this.version;
/*    */   }
/*    */ 
/*    */   public void setVersion(String version) {
/* 89 */     this.version = version;
/*    */   }
/*    */ 
/*    */   public byte[] getDatapackage() {
/* 93 */     return this.datapackage;
/*    */   }
/*    */ 
/*    */   public void setDatapackage(byte[] datapackage) {
/* 97 */     this.datapackage = datapackage;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8108
 * JD-Core Version:    0.6.1
 */