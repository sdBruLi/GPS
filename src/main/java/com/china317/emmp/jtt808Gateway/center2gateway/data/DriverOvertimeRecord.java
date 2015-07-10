/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DriverOvertimeRecord
/*    */ {
/*  8 */   private String licenseNum = null;
/*  9 */   private List<OvertimeRecord> records = null;
/*    */ 
/* 11 */   public void parse(byte[] datas) { if (datas != null) {
/* 12 */       byte[] dests = new byte[18];
/* 13 */       System.arraycopy(datas, 0, dests, 0, dests.length);
/*    */       try {
/* 15 */         this.licenseNum = new String(dests, "GBK");
/*    */       } catch (UnsupportedEncodingException e) {
/* 17 */         e.printStackTrace();
/*    */       }
/* 19 */       if (datas.length > 28) {
/* 20 */         int index = 18;
/*    */         do {
/* 22 */           byte[] times = new byte[10];
/* 23 */           System.arraycopy(datas, index, times, 0, 10);
/* 24 */           OvertimeRecord record = new OvertimeRecord();
/* 25 */           record.parse(times);
/* 26 */           if (this.records == null) {
/* 27 */             this.records = new ArrayList();
/*    */           }
/* 29 */           this.records.add(record);
/* 30 */           index += 10;
/* 31 */         }while (datas.length > index);
/*    */       }
/*    */     } }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 37 */     if (this.licenseNum == null) {
/* 38 */       return null;
/*    */     }
/* 40 */     StringBuffer sb = new StringBuffer();
/* 41 */     sb.append("licenseNum:");
/* 42 */     sb.append(this.licenseNum);
/* 43 */     for (OvertimeRecord r : this.records) {
/* 44 */       sb.append(r.toString() + " --- ");
/*    */     }
/* 46 */     return sb.toString();
/*    */   }
/*    */   public List<OvertimeRecord> getRecords() {
/* 49 */     return this.records;
/*    */   }
/*    */   public void setRecords(List<OvertimeRecord> records) {
/* 52 */     this.records = records;
/*    */   }
/*    */   public String getLicenseNum() {
/* 55 */     return this.licenseNum;
/*    */   }
/*    */   public void setLicenseNum(String licenseNum) {
/* 58 */     this.licenseNum = licenseNum;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.DriverOvertimeRecord
 * JD-Core Version:    0.6.1
 */