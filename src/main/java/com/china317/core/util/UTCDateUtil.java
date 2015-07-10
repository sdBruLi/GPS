/*    */ package com.china317.core.util;
/*    */ 
/*    */ import java.math.BigInteger;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class UTCDateUtil
/*    */ {
/*    */   public static Date utclong2Date(long utc)
/*    */   {
/* 12 */     BigInteger bi = new BigInteger(utc + "000");
/* 13 */     return new Date(bi.longValue());
/*    */   }
/*    */ 
/*    */   public static long date2Utclong(Date date)
/*    */   {
/* 20 */     return date.getTime() / 1000L;
/*    */   }
/*    */ 
/*    */   public static Date utclong2Date2(long utc) {
/* 24 */     Calendar calendar = Calendar.getInstance();
/* 25 */     calendar.setTimeInMillis(utc);
/* 26 */     return calendar.getTime();
/*    */   }
/*    */ 
/*    */   public static long date2Utclong2(Date date) {
/* 30 */     Calendar calendar = Calendar.getInstance();
/* 31 */     calendar.setTime(date);
/* 32 */     return calendar.getTimeInMillis();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.util.UTCDateUtil
 * JD-Core Version:    0.6.1
 */