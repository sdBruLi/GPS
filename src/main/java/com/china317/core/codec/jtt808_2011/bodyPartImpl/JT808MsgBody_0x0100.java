/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x0100 extends JT808MsgBody
/*     */ {
/*     */   private short provinceId;
/*     */   private short cityId;
/*     */   private String manufacturerId;
/*     */   private String terminalModel;
/*     */   private String terminalId;
/*     */   private byte licensePlatesColor;
/*  17 */   private String licensePlates = "";
/*     */ 
/*     */   public void bulidBody() throws Exception
/*     */   {
/*  21 */     if (!isBuildBody()) {
/*  22 */       this.bodyBuffer = IoBuffer.allocate(28);
/*  23 */       this.bodyBuffer.putUnsignedShort(this.provinceId);
/*  24 */       this.bodyBuffer.putUnsignedShort(this.cityId);
/*  25 */       this.bodyBuffer.put(this.manufacturerId.getBytes("GBK"));
/*  26 */       this.bodyBuffer.put(this.terminalModel.getBytes("GBK"));
/*  27 */       this.bodyBuffer.put(this.terminalId.getBytes("GBK"));
/*  28 */       this.bodyBuffer.put(this.licensePlatesColor);
/*  29 */       this.bodyBuffer.put(this.licensePlates.getBytes("GBK"));
/*  30 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*     */     try {
/*  37 */       this.provinceId = this.bodyBuffer.getShort();
/*  38 */       this.cityId = this.bodyBuffer.getShort();
/*  39 */       byte[] manufacturerIds = new byte[5];
/*  40 */       this.bodyBuffer.get(manufacturerIds);
/*  41 */       this.manufacturerId = ByteUtil.getHexString(manufacturerIds);
/*  42 */       byte[] terminalModels = new byte[20];
/*  43 */       this.bodyBuffer.get(terminalModels);
/*  44 */       this.terminalModel = ByteUtil.getHexString(terminalModels);
/*  45 */       byte[] terminalIds = new byte[7];
/*  46 */       this.bodyBuffer.get(terminalIds);
/*  47 */       this.terminalId = ByteUtil.getHexString(terminalIds);
/*  48 */       this.licensePlatesColor = this.bodyBuffer.get();
/*  49 */       byte[] platesbytes = new byte[this.bodyBuffer.limit() - 37];
/*  50 */       this.bodyBuffer.get(platesbytes);
/*  51 */       this.licensePlates = new String(platesbytes, "gbk");
/*     */     } catch (BufferUnderflowException e) {
/*  53 */       this.bodyBuffer.rewind();
/*     */ 
/*  55 */       this.provinceId = this.bodyBuffer.getShort();
/*  56 */       this.cityId = this.bodyBuffer.getShort();
/*  57 */       byte[] manufacturerIds = new byte[5];
/*  58 */       this.bodyBuffer.get(manufacturerIds);
/*  59 */       this.manufacturerId = ByteUtil.getHexString(manufacturerIds);
/*     */ 
/*  62 */       byte[] terminalModels = new byte[8];
/*  63 */       this.bodyBuffer.get(terminalModels);
/*  64 */       this.terminalModel = ByteUtil.getHexString(terminalModels);
/*  65 */       byte[] terminalIds = new byte[7];
/*  66 */       this.bodyBuffer.get(terminalIds);
/*  67 */       this.terminalId = ByteUtil.getHexString(terminalIds);
/*  68 */       this.licensePlatesColor = this.bodyBuffer.get();
/*  69 */       byte[] platesbytes = new byte[this.bodyBuffer.limit() - 25];
/*  70 */       this.bodyBuffer.get(platesbytes);
/*  71 */       this.licensePlates = ByteUtil.getHexString(platesbytes);
/*     */     }
/*     */ 
/*  74 */     this.bodyBuffer.rewind();
/*     */   }
/*     */ 
/*     */   public short getProvinceId() {
/*  78 */     return this.provinceId;
/*     */   }
/*     */ 
/*     */   public void setProvinceId(short provinceId) {
/*  82 */     this.provinceId = provinceId;
/*     */   }
/*     */ 
/*     */   public short getCityId() {
/*  86 */     return this.cityId;
/*     */   }
/*     */ 
/*     */   public void setCityId(short cityId) {
/*  90 */     this.cityId = cityId;
/*     */   }
/*     */ 
/*     */   public String getManufacturerId() {
/*  94 */     return this.manufacturerId;
/*     */   }
/*     */ 
/*     */   public void setManufacturerId(String manufacturerId) {
/*  98 */     this.manufacturerId = manufacturerId;
/*     */   }
/*     */ 
/*     */   public String getTerminalModel() {
/* 102 */     return this.terminalModel;
/*     */   }
/*     */ 
/*     */   public void setTerminalModel(String terminalModel) {
/* 106 */     this.terminalModel = terminalModel;
/*     */   }
/*     */ 
/*     */   public String getTerminalId() {
/* 110 */     return this.terminalId;
/*     */   }
/*     */ 
/*     */   public void setTerminalId(String terminalId) {
/* 114 */     this.terminalId = terminalId;
/*     */   }
/*     */ 
/*     */   public byte getLicensePlatesColor() {
/* 118 */     return this.licensePlatesColor;
/*     */   }
/*     */ 
/*     */   public void setLicensePlatesColor(byte licensePlatesColor) {
/* 122 */     this.licensePlatesColor = licensePlatesColor;
/*     */   }
/*     */ 
/*     */   public String getLicensePlates() {
/* 126 */     return this.licensePlates;
/*     */   }
/*     */ 
/*     */   public void setLicensePlates(String licensePlates) {
/* 130 */     this.licensePlates = licensePlates;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0100
 * JD-Core Version:    0.6.1
 */