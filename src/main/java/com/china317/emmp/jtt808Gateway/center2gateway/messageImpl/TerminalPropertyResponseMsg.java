/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0107;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class TerminalPropertyResponseMsg extends BaseUpMessage
/*     */ {
/*  15 */   private static final Log log = LogFactory.getLog(TerminalPropertyResponseMsg.class);
/*     */   private int vehicle4passenger;
/*     */   private int vehicle4dangerous;
/*     */   private int vehicle4freight;
/*     */   private int vehicle4taxi;
/*     */   private int HDDvideo;
/*     */   private int splittype;
/*     */   private String manufacturerId;
/*     */   private String terminalModel;
/*     */   private String terminalId;
/*     */   private String iccard;
/*     */   private String hwversion;
/*     */   private String fwversion;
/*     */   private int gnss_gps_support;
/*     */   private int gnss_beidou_support;
/*     */   private int gnss_glonass_support;
/*     */   private int gnss_galileo_support;
/*     */   private int GPRS_support;
/*     */   private int CDMA_support;
/*     */   private int TDCDMA_support;
/*     */   private int WCDMA_support;
/*     */   private int CDMA2000_support;
/*     */   private int TDLTE_support;
/*     */   private int other_support;
/*     */ 
/*     */   public void unpack(UnitPackJT808 pack)
/*     */   {
/*  42 */     unpackHeadPart(pack);
/*     */     try {
/*  44 */       JT808MsgBody_0x0107 body = (JT808MsgBody_0x0107)pack.getMsgBody();
/*  45 */       this.vehicle4passenger = body.getVehicle4passenger();
/*  46 */       this.vehicle4dangerous = body.getVehicle4dangerous();
/*  47 */       this.vehicle4freight = body.getVehicle4freight();
/*  48 */       this.vehicle4taxi = body.getVehicle4taxi();
/*  49 */       this.HDDvideo = body.getHDDvideo();
/*  50 */       this.splittype = body.getSplittype();
/*  51 */       this.manufacturerId = body.getManufacturerId();
/*  52 */       this.terminalModel = body.getTerminalModel();
/*  53 */       this.terminalId = body.getTerminalId();
/*  54 */       this.iccard = body.getIccard();
/*  55 */       this.hwversion = body.getHwversion();
/*  56 */       this.fwversion = body.getFwversion();
/*  57 */       this.gnss_gps_support = body.getGnss_gps_support();
/*  58 */       this.gnss_beidou_support = body.getGnss_beidou_support();
/*  59 */       this.gnss_glonass_support = body.getGnss_glonass_support();
/*  60 */       this.gnss_galileo_support = body.getGnss_galileo_support();
/*  61 */       this.GPRS_support = body.getGPRS_support();
/*  62 */       this.CDMA_support = body.getCDMA_support();
/*  63 */       this.TDCDMA_support = body.getTDCDMA_support();
/*  64 */       this.WCDMA_support = body.getWCDMA_support();
/*  65 */       this.CDMA2000_support = body.getCDMA2000_support();
/*  66 */       this.TDLTE_support = body.getTDLTE_support();
/*  67 */       this.other_support = body.getOther_support();
/*     */     }
/*     */     catch (Exception e) {
/*  70 */       log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getVehicle4passenger() {
/*  75 */     return this.vehicle4passenger;
/*     */   }
/*     */ 
/*     */   public void setVehicle4passenger(int vehicle4passenger) {
/*  79 */     this.vehicle4passenger = vehicle4passenger;
/*     */   }
/*     */ 
/*     */   public int getVehicle4dangerous() {
/*  83 */     return this.vehicle4dangerous;
/*     */   }
/*     */ 
/*     */   public void setVehicle4dangerous(int vehicle4dangerous) {
/*  87 */     this.vehicle4dangerous = vehicle4dangerous;
/*     */   }
/*     */ 
/*     */   public int getVehicle4freight() {
/*  91 */     return this.vehicle4freight;
/*     */   }
/*     */ 
/*     */   public void setVehicle4freight(int vehicle4freight) {
/*  95 */     this.vehicle4freight = vehicle4freight;
/*     */   }
/*     */ 
/*     */   public int getVehicle4taxi() {
/*  99 */     return this.vehicle4taxi;
/*     */   }
/*     */ 
/*     */   public void setVehicle4taxi(int vehicle4taxi) {
/* 103 */     this.vehicle4taxi = vehicle4taxi;
/*     */   }
/*     */ 
/*     */   public int getHDDvideo() {
/* 107 */     return this.HDDvideo;
/*     */   }
/*     */ 
/*     */   public void setHDDvideo(int dvideo) {
/* 111 */     this.HDDvideo = dvideo;
/*     */   }
/*     */ 
/*     */   public int getSplittype() {
/* 115 */     return this.splittype;
/*     */   }
/*     */ 
/*     */   public void setSplittype(int splittype) {
/* 119 */     this.splittype = splittype;
/*     */   }
/*     */ 
/*     */   public String getManufacturerId() {
/* 123 */     return this.manufacturerId;
/*     */   }
/*     */ 
/*     */   public void setManufacturerId(String manufacturerId) {
/* 127 */     this.manufacturerId = manufacturerId;
/*     */   }
/*     */ 
/*     */   public String getTerminalModel() {
/* 131 */     return this.terminalModel;
/*     */   }
/*     */ 
/*     */   public void setTerminalModel(String terminalModel) {
/* 135 */     this.terminalModel = terminalModel;
/*     */   }
/*     */ 
/*     */   public String getTerminalId() {
/* 139 */     return this.terminalId;
/*     */   }
/*     */ 
/*     */   public void setTerminalId(String terminalId) {
/* 143 */     this.terminalId = terminalId;
/*     */   }
/*     */ 
/*     */   public String getIccard() {
/* 147 */     return this.iccard;
/*     */   }
/*     */ 
/*     */   public void setIccard(String iccard) {
/* 151 */     this.iccard = iccard;
/*     */   }
/*     */ 
/*     */   public String getHwversion() {
/* 155 */     return this.hwversion;
/*     */   }
/*     */ 
/*     */   public void setHwversion(String hwversion) {
/* 159 */     this.hwversion = hwversion;
/*     */   }
/*     */ 
/*     */   public String getFwversion() {
/* 163 */     return this.fwversion;
/*     */   }
/*     */ 
/*     */   public void setFwversion(String fwversion) {
/* 167 */     this.fwversion = fwversion;
/*     */   }
/*     */ 
/*     */   public int getGnss_gps_support() {
/* 171 */     return this.gnss_gps_support;
/*     */   }
/*     */ 
/*     */   public void setGnss_gps_support(int gnss_gps_support) {
/* 175 */     this.gnss_gps_support = gnss_gps_support;
/*     */   }
/*     */ 
/*     */   public int getGnss_beidou_support() {
/* 179 */     return this.gnss_beidou_support;
/*     */   }
/*     */ 
/*     */   public void setGnss_beidou_support(int gnss_beidou_support) {
/* 183 */     this.gnss_beidou_support = gnss_beidou_support;
/*     */   }
/*     */ 
/*     */   public int getGnss_glonass_support() {
/* 187 */     return this.gnss_glonass_support;
/*     */   }
/*     */ 
/*     */   public void setGnss_glonass_support(int gnss_glonass_support) {
/* 191 */     this.gnss_glonass_support = gnss_glonass_support;
/*     */   }
/*     */ 
/*     */   public int getGnss_galileo_support() {
/* 195 */     return this.gnss_galileo_support;
/*     */   }
/*     */ 
/*     */   public void setGnss_galileo_support(int gnss_galileo_support) {
/* 199 */     this.gnss_galileo_support = gnss_galileo_support;
/*     */   }
/*     */ 
/*     */   public int getGPRS_support() {
/* 203 */     return this.GPRS_support;
/*     */   }
/*     */ 
/*     */   public void setGPRS_support(int gprs_support) {
/* 207 */     this.GPRS_support = gprs_support;
/*     */   }
/*     */ 
/*     */   public int getCDMA_support() {
/* 211 */     return this.CDMA_support;
/*     */   }
/*     */ 
/*     */   public void setCDMA_support(int cdma_support) {
/* 215 */     this.CDMA_support = cdma_support;
/*     */   }
/*     */ 
/*     */   public int getTDCDMA_support() {
/* 219 */     return this.TDCDMA_support;
/*     */   }
/*     */ 
/*     */   public void setTDCDMA_support(int tdcdma_support) {
/* 223 */     this.TDCDMA_support = tdcdma_support;
/*     */   }
/*     */ 
/*     */   public int getWCDMA_support() {
/* 227 */     return this.WCDMA_support;
/*     */   }
/*     */ 
/*     */   public void setWCDMA_support(int wcdma_support) {
/* 231 */     this.WCDMA_support = wcdma_support;
/*     */   }
/*     */ 
/*     */   public int getCDMA2000_support() {
/* 235 */     return this.CDMA2000_support;
/*     */   }
/*     */ 
/*     */   public void setCDMA2000_support(int cdma2000_support) {
/* 239 */     this.CDMA2000_support = cdma2000_support;
/*     */   }
/*     */ 
/*     */   public int getTDLTE_support() {
/* 243 */     return this.TDLTE_support;
/*     */   }
/*     */ 
/*     */   public void setTDLTE_support(int tdlte_support) {
/* 247 */     this.TDLTE_support = tdlte_support;
/*     */   }
/*     */ 
/*     */   public int getOther_support() {
/* 251 */     return this.other_support;
/*     */   }
/*     */ 
/*     */   public void setOther_support(int other_support) {
/* 255 */     this.other_support = other_support;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TerminalPropertyResponseMsg
 * JD-Core Version:    0.6.1
 */