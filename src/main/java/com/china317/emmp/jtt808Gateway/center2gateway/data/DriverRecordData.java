/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*     */ 
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.codecExt.ObjectDataJT808;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class DriverRecordData extends ObjectDataJT808
/*     */ {
/*     */   private byte commandRecord;
/*     */   private byte[] datas;
/*     */ 
/*     */   public String getCommand()
/*     */   {
/*  16 */     return "0x0700";
/*     */   }
/*     */   public Object getRecord() throws Exception {
/*  19 */     this.datas = getBytes();
/*  20 */     int index = 0;
/*  21 */     int currentIndex = 0;
/*  22 */     if ((this.datas != null) && (this.datas.length > 2) && 
/*  23 */       (this.datas[0] == 85) && (this.datas[1] == 122)) {
/*  24 */       if (this.datas.length < 5)
/*     */       {
/*  26 */         this.datas = null;
/*     */       } else {
/*  28 */         int len = ((this.datas[3] & 0xFF) << 8) + (this.datas[4] & 0xFF) & 0xFFFF;
/*  29 */         if (len > 0) {
/*  30 */           byte[] datas2 = new byte[len];
/*  31 */           System.arraycopy(this.datas, 6, datas2, 0, len);
/*  32 */           this.datas = datas2;
/*     */         } else {
/*  34 */           this.datas = null;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  41 */     if ((this.datas != null) && (this.datas.length > 0)) {
/*  42 */       index = this.datas.length;
/*  43 */       switch (this.commandRecord) {
/*     */       case 1:
/*  45 */         DriverCodeLicenseNum driverCodeLicenseNum = new DriverCodeLicenseNum();
/*  46 */         driverCodeLicenseNum.parse(this.datas);
/*  47 */         return driverCodeLicenseNum;
/*     */       case 2:
/*  49 */         TerminalRealtime teminalRealtime = new TerminalRealtime();
/*  50 */         teminalRealtime.parse(this.datas);
/*  51 */         return teminalRealtime;
/*     */       case 3:
/*  53 */         TotalMileage totalMileage = new TotalMileage();
/*  54 */         totalMileage.parse(this.datas);
/*  55 */         return totalMileage;
/*     */       case 4:
/*  57 */         VehCharacteristicCoefficients cc = new VehCharacteristicCoefficients();
/*  58 */         cc.parse(this.datas);
/*  59 */         return cc;
/*     */       case 5:
/*  61 */         SpeedBlock360h speedBlock360h = new SpeedBlock360h();
/*  62 */         speedBlock360h.parse(this.datas);
/*  63 */         return speedBlock360h;
/*     */       case 6:
/*  65 */         VehInfo vehInfo = new VehInfo();
/*  66 */         vehInfo.parse(this.datas);
/*  67 */         return vehInfo;
/*     */       case 7:
/*  69 */         List points = new ArrayList();
/*     */         do {
/*  71 */           AccidentDoubtfulPoint accidentDoubtfulPoint = new AccidentDoubtfulPoint();
/*  72 */           currentIndex = accidentDoubtfulPoint.parse(currentIndex, this.datas);
/*  73 */           points.add(accidentDoubtfulPoint);
/*  74 */         }while (index - currentIndex > 0);
/*  75 */         return points;
/*     */       case 8:
/*  77 */         TotalMileage totalMileage2d = new TotalMileage();
/*  78 */         totalMileage2d.parse(this.datas);
/*  79 */         return totalMileage2d;
/*     */       case 9:
/*  81 */         SpeedBlock360h speedBlock360h2d = new SpeedBlock360h();
/*  82 */         speedBlock360h2d.parse(this.datas);
/*  83 */         return speedBlock360h2d;
/*     */       case 17:
/*  85 */         DriverOvertimeRecord overtimeRecord = new DriverOvertimeRecord();
/*  86 */         overtimeRecord.parse(this.datas);
/*  87 */         return overtimeRecord;
/*     */       case 10:
/*     */       case 11:
/*     */       case 12:
/*     */       case 13:
/*     */       case 14:
/*     */       case 15:
/*  90 */       case 16: }  } return null;
/*     */   }
/*     */   public byte getCommandRecord() {
/*  93 */     return this.commandRecord;
/*     */   }
/*     */ 
/*     */   public void setCommandRecord(byte commandRecord) {
/*  97 */     this.commandRecord = commandRecord;
/*     */   }
/*     */ 
/*     */   public byte[] getDatas() {
/* 101 */     return this.datas;
/*     */   }
/*     */ 
/*     */   public void setDatas(byte[] datas) {
/* 105 */     this.datas = datas;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.DriverRecordData
 * JD-Core Version:    0.6.1
 */