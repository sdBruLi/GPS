/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x0702 extends JT808MsgBody
/*     */ {
/*     */   private byte driverNameLen;
/*     */   private String driverName;
/*     */   private String driveridentityCode;
/*     */   private String certificateCode;
/*     */   private byte servicesOfficeLen;
/*  13 */   private String servicesOfficeName = "";
/*     */ 
/*     */   public void bulidBody() throws Exception
/*     */   {
/*  17 */     if (!isBuildBody()) {
/*  18 */       this.bodyBuffer = IoBuffer.allocate(28);
/*  19 */       this.bodyBuffer.put(this.driverNameLen);
/*  20 */       if ((this.driverName != null) && (this.driverName.length() > 0)) {
/*  21 */         this.bodyBuffer.put(this.driverName.getBytes("GBK"));
/*     */       }
/*  23 */       if ((this.driveridentityCode != null) && (this.driveridentityCode.length() > 0)) {
/*  24 */         this.bodyBuffer.put(this.driveridentityCode.getBytes("GBK"));
/*     */       }
/*  26 */       if ((this.certificateCode != null) && (this.certificateCode.length() > 0)) {
/*  27 */         this.bodyBuffer.put(this.certificateCode.getBytes("GBK"));
/*     */       }
/*  29 */       this.bodyBuffer.put(this.servicesOfficeLen);
/*  30 */       if ((this.servicesOfficeName != null) && (this.servicesOfficeName.length() > 0)) {
/*  31 */         this.bodyBuffer.put(this.servicesOfficeName.getBytes("GBK"));
/*     */       }
/*  33 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*  39 */     this.driverNameLen = this.bodyBuffer.get();
/*  40 */     byte[] driverNames = new byte[this.driverNameLen];
/*  41 */     this.bodyBuffer.get(driverNames);
/*  42 */     this.driverName = new String(driverNames, "GBK");
/*     */ 
/*  44 */     byte[] driveridentityCodes = new byte[20];
/*  45 */     this.bodyBuffer.get(driveridentityCodes);
/*  46 */     this.driveridentityCode = new String(driveridentityCodes, "GBK");
/*     */ 
/*  48 */     byte[] certificateCodes = new byte[40];
/*  49 */     this.bodyBuffer.get(certificateCodes);
/*  50 */     this.certificateCode = new String(certificateCodes, "GBK");
/*     */ 
/*  52 */     this.servicesOfficeLen = this.bodyBuffer.get();
/*  53 */     byte[] servicesOfficeNames = new byte[this.servicesOfficeLen];
/*  54 */     this.bodyBuffer.get(servicesOfficeNames);
/*  55 */     this.servicesOfficeName = new String(servicesOfficeNames, "GBK");
/*     */ 
/*  57 */     this.bodyBuffer.rewind();
/*     */   }
/*     */ 
/*     */   public byte getDriverNameLen() {
/*  61 */     return this.driverNameLen;
/*     */   }
/*     */ 
/*     */   public void setDriverNameLen(byte driverNameLen) {
/*  65 */     this.driverNameLen = driverNameLen;
/*     */   }
/*     */ 
/*     */   public String getDriverName() {
/*  69 */     return this.driverName;
/*     */   }
/*     */ 
/*     */   public void setDriverName(String driverName) {
/*  73 */     this.driverName = driverName;
/*     */   }
/*     */ 
/*     */   public String getDriveridentityCode() {
/*  77 */     return this.driveridentityCode;
/*     */   }
/*     */ 
/*     */   public void setDriveridentityCode(String driveridentityCode) {
/*  81 */     this.driveridentityCode = driveridentityCode;
/*     */   }
/*     */ 
/*     */   public String getCertificateCode() {
/*  85 */     return this.certificateCode;
/*     */   }
/*     */ 
/*     */   public void setCertificateCode(String certificateCode) {
/*  89 */     this.certificateCode = certificateCode;
/*     */   }
/*     */ 
/*     */   public byte getServicesOfficeLen() {
/*  93 */     return this.servicesOfficeLen;
/*     */   }
/*     */ 
/*     */   public void setServicesOfficeLen(byte servicesOfficeLen) {
/*  97 */     this.servicesOfficeLen = servicesOfficeLen;
/*     */   }
/*     */ 
/*     */   public String getServicesOfficeName() {
/* 101 */     return this.servicesOfficeName;
/*     */   }
/*     */ 
/*     */   public void setServicesOfficeName(String servicesOfficeName) {
/* 105 */     this.servicesOfficeName = servicesOfficeName;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0702
 * JD-Core Version:    0.6.1
 */