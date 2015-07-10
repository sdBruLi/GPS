/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x0107 extends JT808MsgBody
/*     */ {
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
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public void praseBody()
/*     */     throws Exception
/*     */   {
/*  44 */     int type = this.bodyBuffer.getUnsignedShort();
/*  45 */     this.vehicle4passenger = (type & 0x1);
/*  46 */     this.vehicle4dangerous = (type >> 1 & 0x1);
/*  47 */     this.vehicle4freight = (type >> 2 & 0x1);
/*  48 */     this.vehicle4taxi = (type >> 3 & 0x1);
/*  49 */     this.HDDvideo = (type >> 6 & 0x1);
/*  50 */     this.splittype = (type >> 7 & 0x1);
/*     */ 
/*  52 */     byte[] temp = new byte[5];
/*  53 */     this.bodyBuffer.get(temp);
/*  54 */     this.manufacturerId = ByteUtil.getHexString(temp);
/*     */ 
/*  56 */     temp = new byte[20];
/*  57 */     this.bodyBuffer.get(temp);
/*  58 */     this.terminalModel = ByteUtil.getHexString(temp);
/*     */ 
/*  60 */     temp = new byte[7];
/*  61 */     this.bodyBuffer.get(temp);
/*  62 */     this.terminalId = ByteUtil.getHexString(temp);
/*     */ 
/*  64 */     temp = new byte[10];
/*  65 */     this.bodyBuffer.get(temp);
/*  66 */     this.iccard = ByteUtil.getHexString(temp);
/*     */ 
/*  68 */     int len = this.bodyBuffer.get();
/*     */ 
/*  70 */     temp = new byte[len];
/*  71 */     this.bodyBuffer.get(temp);
/*  72 */     this.hwversion = new String(temp, "gbk");
/*     */ 
/*  74 */     len = this.bodyBuffer.get();
/*     */ 
/*  76 */     this.bodyBuffer.get(temp);
/*  77 */     this.fwversion = new String(temp, "gbk");
/*     */ 
/*  79 */     type = this.bodyBuffer.get();
/*  80 */     this.gnss_gps_support = (type & 0x1);
/*  81 */     this.gnss_beidou_support = (type >> 1 & 0x1);
/*  82 */     this.gnss_glonass_support = (type >> 2 & 0x1);
/*  83 */     this.gnss_galileo_support = (type >> 3 & 0x1);
/*     */ 
/*  85 */     type = this.bodyBuffer.get();
/*  86 */     this.GPRS_support = (type & 0x1);
/*  87 */     this.CDMA_support = (type >> 1 & 0x1);
/*  88 */     this.TDCDMA_support = (type >> 2 & 0x1);
/*  89 */     this.WCDMA_support = (type >> 3 & 0x1);
/*  90 */     this.CDMA2000_support = (type >> 4 & 0x1);
/*  91 */     this.TDLTE_support = (type >> 5 & 0x1);
/*  92 */     this.other_support = (type >> 7 & 0x1);
/*     */   }
/*     */ 
/*     */   public int getVehicle4passenger() {
/*  96 */     return this.vehicle4passenger;
/*     */   }
/*     */ 
/*     */   public void setVehicle4passenger(int vehicle4passenger) {
/* 100 */     this.vehicle4passenger = vehicle4passenger;
/*     */   }
/*     */ 
/*     */   public int getVehicle4dangerous() {
/* 104 */     return this.vehicle4dangerous;
/*     */   }
/*     */ 
/*     */   public void setVehicle4dangerous(int vehicle4dangerous) {
/* 108 */     this.vehicle4dangerous = vehicle4dangerous;
/*     */   }
/*     */ 
/*     */   public int getVehicle4freight() {
/* 112 */     return this.vehicle4freight;
/*     */   }
/*     */ 
/*     */   public void setVehicle4freight(int vehicle4freight) {
/* 116 */     this.vehicle4freight = vehicle4freight;
/*     */   }
/*     */ 
/*     */   public int getVehicle4taxi() {
/* 120 */     return this.vehicle4taxi;
/*     */   }
/*     */ 
/*     */   public void setVehicle4taxi(int vehicle4taxi) {
/* 124 */     this.vehicle4taxi = vehicle4taxi;
/*     */   }
/*     */ 
/*     */   public int getHDDvideo() {
/* 128 */     return this.HDDvideo;
/*     */   }
/*     */ 
/*     */   public void setHDDvideo(int dvideo) {
/* 132 */     this.HDDvideo = dvideo;
/*     */   }
/*     */ 
/*     */   public int getSplittype() {
/* 136 */     return this.splittype;
/*     */   }
/*     */ 
/*     */   public void setSplittype(int splittype) {
/* 140 */     this.splittype = splittype;
/*     */   }
/*     */ 
/*     */   public String getManufacturerId() {
/* 144 */     return this.manufacturerId;
/*     */   }
/*     */ 
/*     */   public void setManufacturerId(String manufacturerId) {
/* 148 */     this.manufacturerId = manufacturerId;
/*     */   }
/*     */ 
/*     */   public String getTerminalModel() {
/* 152 */     return this.terminalModel;
/*     */   }
/*     */ 
/*     */   public void setTerminalModel(String terminalModel) {
/* 156 */     this.terminalModel = terminalModel;
/*     */   }
/*     */ 
/*     */   public String getTerminalId() {
/* 160 */     return this.terminalId;
/*     */   }
/*     */ 
/*     */   public void setTerminalId(String terminalId) {
/* 164 */     this.terminalId = terminalId;
/*     */   }
/*     */ 
/*     */   public String getIccard() {
/* 168 */     return this.iccard;
/*     */   }
/*     */ 
/*     */   public void setIccard(String iccard) {
/* 172 */     this.iccard = iccard;
/*     */   }
/*     */ 
/*     */   public String getHwversion() {
/* 176 */     return this.hwversion;
/*     */   }
/*     */ 
/*     */   public void setHwversion(String hwversion) {
/* 180 */     this.hwversion = hwversion;
/*     */   }
/*     */ 
/*     */   public String getFwversion() {
/* 184 */     return this.fwversion;
/*     */   }
/*     */ 
/*     */   public void setFwversion(String fwversion) {
/* 188 */     this.fwversion = fwversion;
/*     */   }
/*     */ 
/*     */   public int getGnss_gps_support() {
/* 192 */     return this.gnss_gps_support;
/*     */   }
/*     */ 
/*     */   public void setGnss_gps_support(int gnss_gps_support) {
/* 196 */     this.gnss_gps_support = gnss_gps_support;
/*     */   }
/*     */ 
/*     */   public int getGnss_beidou_support() {
/* 200 */     return this.gnss_beidou_support;
/*     */   }
/*     */ 
/*     */   public void setGnss_beidou_support(int gnss_beidou_support) {
/* 204 */     this.gnss_beidou_support = gnss_beidou_support;
/*     */   }
/*     */ 
/*     */   public int getGnss_glonass_support() {
/* 208 */     return this.gnss_glonass_support;
/*     */   }
/*     */ 
/*     */   public void setGnss_glonass_support(int gnss_glonass_support) {
/* 212 */     this.gnss_glonass_support = gnss_glonass_support;
/*     */   }
/*     */ 
/*     */   public int getGnss_galileo_support() {
/* 216 */     return this.gnss_galileo_support;
/*     */   }
/*     */ 
/*     */   public void setGnss_galileo_support(int gnss_galileo_support) {
/* 220 */     this.gnss_galileo_support = gnss_galileo_support;
/*     */   }
/*     */ 
/*     */   public int getGPRS_support() {
/* 224 */     return this.GPRS_support;
/*     */   }
/*     */ 
/*     */   public void setGPRS_support(int gprs_support) {
/* 228 */     this.GPRS_support = gprs_support;
/*     */   }
/*     */ 
/*     */   public int getCDMA_support() {
/* 232 */     return this.CDMA_support;
/*     */   }
/*     */ 
/*     */   public void setCDMA_support(int cdma_support) {
/* 236 */     this.CDMA_support = cdma_support;
/*     */   }
/*     */ 
/*     */   public int getTDCDMA_support() {
/* 240 */     return this.TDCDMA_support;
/*     */   }
/*     */ 
/*     */   public void setTDCDMA_support(int tdcdma_support) {
/* 244 */     this.TDCDMA_support = tdcdma_support;
/*     */   }
/*     */ 
/*     */   public int getWCDMA_support() {
/* 248 */     return this.WCDMA_support;
/*     */   }
/*     */ 
/*     */   public void setWCDMA_support(int wcdma_support) {
/* 252 */     this.WCDMA_support = wcdma_support;
/*     */   }
/*     */ 
/*     */   public int getCDMA2000_support() {
/* 256 */     return this.CDMA2000_support;
/*     */   }
/*     */ 
/*     */   public void setCDMA2000_support(int cdma2000_support) {
/* 260 */     this.CDMA2000_support = cdma2000_support;
/*     */   }
/*     */ 
/*     */   public int getTDLTE_support() {
/* 264 */     return this.TDLTE_support;
/*     */   }
/*     */ 
/*     */   public void setTDLTE_support(int tdlte_support) {
/* 268 */     this.TDLTE_support = tdlte_support;
/*     */   }
/*     */ 
/*     */   public int getOther_support() {
/* 272 */     return this.other_support;
/*     */   }
/*     */ 
/*     */   public void setOther_support(int other_support) {
/* 276 */     this.other_support = other_support;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0107
 * JD-Core Version:    0.6.1
 */