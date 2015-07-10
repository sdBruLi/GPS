/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0100;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class RegisterMessage extends BaseUpMessage
/*     */ {
/*  17 */   private static final Log log = LogFactory.getLog(RegisterMessage.class);
/*     */   private short provinceId;
/*     */   private short cityId;
/*     */   private String manufacturerId;
/*     */   private String terminalModel;
/*     */   private String terminalId;
/*     */   private String licensePlatesColor;
/*     */   private String licensePlates;
/*     */ 
/*     */   public RegisterMessage()
/*     */   {
/*  19 */     setCommand("0x0100");
/*     */   }
/*     */ 
/*     */   public void unpack(UnitPackJT808 pack)
/*     */   {
/*  24 */     unpackHeadPart(pack);
/*     */     try {
/*  26 */       JT808MsgBody_0x0100 body = (JT808MsgBody_0x0100)pack.getMsgBody();
/*     */ 
/*  28 */       setProvinceId(body.getProvinceId());
/*  29 */       setCityId(body.getCityId());
/*  30 */       setManufacturerId(body.getManufacturerId());
/*  31 */       setTerminalModel(body.getTerminalModel());
/*  32 */       setTerminalId(body.getTerminalId());
/*  33 */       setLicensePlatesColor(String.valueOf(body.getLicensePlatesColor()));
/*  34 */       setLicensePlates(body.getLicensePlates());
/*     */     } catch (Exception e) {
/*  36 */       log.debug("unpack fail ", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public short getProvinceId()
/*     */   {
/*  51 */     return this.provinceId;
/*     */   }
/*     */ 
/*     */   public void setProvinceId(short provinceId)
/*     */   {
/*  56 */     this.provinceId = provinceId;
/*     */   }
/*     */ 
/*     */   public short getCityId() {
/*  60 */     return this.cityId;
/*     */   }
/*     */ 
/*     */   public void setCityId(short cityId)
/*     */   {
/*  65 */     this.cityId = cityId;
/*     */   }
/*     */ 
/*     */   public String getManufacturerId() {
/*  69 */     return this.manufacturerId;
/*     */   }
/*     */ 
/*     */   public void setManufacturerId(String manufacturerId)
/*     */   {
/*  74 */     this.manufacturerId = manufacturerId;
/*     */   }
/*     */ 
/*     */   public String getTerminalModel() {
/*  78 */     return this.terminalModel;
/*     */   }
/*     */ 
/*     */   public void setTerminalModel(String terminalModel)
/*     */   {
/*  83 */     this.terminalModel = terminalModel;
/*     */   }
/*     */ 
/*     */   public String getTerminalId() {
/*  87 */     return this.terminalId;
/*     */   }
/*     */ 
/*     */   public void setTerminalId(String terminalId)
/*     */   {
/*  92 */     this.terminalId = terminalId;
/*     */   }
/*     */ 
/*     */   public String getLicensePlatesColor() {
/*  96 */     return this.licensePlatesColor;
/*     */   }
/*     */ 
/*     */   public void setLicensePlatesColor(String licensePlatesColor)
/*     */   {
/* 101 */     this.licensePlatesColor = licensePlatesColor;
/*     */   }
/*     */ 
/*     */   public String getLicensePlates() {
/* 105 */     return this.licensePlates;
/*     */   }
/*     */ 
/*     */   public void setLicensePlates(String licensePlates)
/*     */   {
/* 110 */     this.licensePlates = licensePlates;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.RegisterMessage
 * JD-Core Version:    0.6.1
 */