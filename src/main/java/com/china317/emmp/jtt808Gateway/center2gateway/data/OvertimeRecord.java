/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ 
/*    */ public class OvertimeRecord
/*    */ {
/*    */   private String startTime;
/*    */   private String stopTime;
/*    */ 
/*    */   public void parse(byte[] datas)
/*    */   {
/* 10 */     byte[] timebytes = new byte[6];
/* 11 */     System.arraycopy(datas, 0, timebytes, 0, 5);
/* 12 */     this.startTime = ByteUtil.getHexString(timebytes);
/* 13 */     System.arraycopy(datas, 5, timebytes, 0, 5);
/* 14 */     this.stopTime = ByteUtil.getHexString(timebytes);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 19 */     return "startTime :" + this.startTime + " stopTime" + this.stopTime;
/*    */   }
/*    */ 
/*    */   public String getStartTime() {
/* 23 */     return this.startTime;
/*    */   }
/*    */   public void setStartTime(String startTime) {
/* 26 */     this.startTime = startTime;
/*    */   }
/*    */   public String getStopTime() {
/* 29 */     return this.stopTime;
/*    */   }
/*    */   public void setStopTime(String stopTime) {
/* 32 */     this.stopTime = stopTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.OvertimeRecord
 * JD-Core Version:    0.6.1
 */