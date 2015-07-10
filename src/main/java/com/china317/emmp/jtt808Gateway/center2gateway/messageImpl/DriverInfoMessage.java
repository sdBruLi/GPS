/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0702;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class DriverInfoMessage extends BaseUpMessage
/*    */ {
/* 16 */   private static final Log log = LogFactory.getLog(DriverInfoMessage.class);
/*    */   private String driverName;
/*    */   private String driveridentityCode;
/*    */   private String certificateCode;
/*    */   private String servicesOfficeName;
/*    */ 
/*    */   public DriverInfoMessage()
/*    */   {
/* 23 */     setCommand("0x0702");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack) {
/* 27 */     unpackHeadPart(pack);
/*    */     try {
/* 29 */       JT808MsgBody_0x0702 body = (JT808MsgBody_0x0702)pack.getMsgBody();
/* 30 */       setDriverName(body.getDriverName());
/* 31 */       setDriveridentityCode(body.getDriveridentityCode());
/* 32 */       setCertificateCode(body.getCertificateCode());
/* 33 */       setServicesOfficeName(body.getServicesOfficeName());
/*    */     } catch (Exception e) {
/* 35 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getDriverName() {
/* 40 */     return this.driverName;
/*    */   }
/*    */ 
/*    */   public void setDriverName(String driverName)
/*    */   {
/* 45 */     this.driverName = driverName;
/*    */   }
/*    */ 
/*    */   public String getDriveridentityCode() {
/* 49 */     return this.driveridentityCode;
/*    */   }
/*    */ 
/*    */   public void setDriveridentityCode(String driveridentityCode)
/*    */   {
/* 54 */     this.driveridentityCode = driveridentityCode;
/*    */   }
/*    */ 
/*    */   public String getCertificateCode() {
/* 58 */     return this.certificateCode;
/*    */   }
/*    */ 
/*    */   public void setCertificateCode(String certificateCode)
/*    */   {
/* 63 */     this.certificateCode = certificateCode;
/*    */   }
/*    */ 
/*    */   public String getServicesOfficeName() {
/* 67 */     return this.servicesOfficeName;
/*    */   }
/*    */ 
/*    */   public void setServicesOfficeName(String servicesOfficeName)
/*    */   {
/* 72 */     this.servicesOfficeName = servicesOfficeName;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.DriverInfoMessage
 * JD-Core Version:    0.6.1
 */