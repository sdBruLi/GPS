/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ 
/*    */ public class PhotoObj extends MultimediaData
/*    */ {
/*    */   public static final byte STATE_INIT = 0;
/*    */   public static final byte STATE_SUCCESS = 1;
/*    */   public static final byte STATE_FAILED = 2;
/*    */   public static final byte STATE_IN_PROGRESS = 3;
/*    */ 
/*    */   public PhotoObj()
/*    */   {
/* 15 */     super.setCreateTime(System.currentTimeMillis());
/*    */   }
/*    */ 
/*    */   public String getCommand()
/*    */   {
/* 20 */     return "0x0801";
/*    */   }
/*    */ 
/*    */   public float currentPercent() {
/* 24 */     double currentSize = getPacketsSize();
/* 25 */     double count = getPacketCount();
/* 26 */     DecimalFormat format = new DecimalFormat("#0.00");
/* 27 */     return Float.parseFloat(format.format(currentSize / count));
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.PhotoObj
 * JD-Core Version:    0.6.1
 */