/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ 
/*    */ public class TotalMileage
/*    */ {
/*    */   private long mileage;
/*    */   private String time;
/*    */ 
/*    */   public long getMileage()
/*    */   {
/* 10 */     return this.mileage;
/*    */   }
/*    */   public void setMileage(long mileage) {
/* 13 */     this.mileage = mileage;
/*    */   }
/*    */   public String getTime() {
/* 16 */     return this.time;
/*    */   }
/*    */   public void setTime(String time) {
/* 19 */     this.time = time;
/*    */   }
/*    */   public void parse(byte[] datas) {
/* 22 */     String m = "";
/* 23 */     byte[] ms = new byte[3];
/* 24 */     System.arraycopy(datas, 0, ms, 0, 3);
/* 25 */     m = ByteUtil.getHexString(ms);
/* 26 */     this.mileage = (Long.parseLong(m) * 10L);
/* 27 */     byte[] timebytes = new byte[6];
/* 28 */     System.arraycopy(datas, 3, timebytes, 0, 5);
/* 29 */     this.time = ByteUtil.getHexString(timebytes);
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 33 */     return "time:" + this.time + " mileage:" + this.mileage;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.TotalMileage
 * JD-Core Version:    0.6.1
 */