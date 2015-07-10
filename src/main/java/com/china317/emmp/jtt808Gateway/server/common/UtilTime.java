/*    */ package com.china317.emmp.jtt808Gateway.server.common;
/*    */ 
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class UtilTime
/*    */ {
/*    */   public static String BCDTimeToCommon(String time)
/*    */   {
/*  9 */     StringBuffer sb = new StringBuffer("20");
/* 10 */     sb.append(time.substring(0, 2));
/* 11 */     sb.append("-");
/* 12 */     sb.append(time.substring(2, 4));
/* 13 */     sb.append("-");
/* 14 */     sb.append(time.substring(4, 6));
/* 15 */     sb.append(" ");
/* 16 */     sb.append(time.substring(6, 8));
/* 17 */     sb.append(":");
/* 18 */     sb.append(time.substring(8, 10));
/* 19 */     sb.append(":");
/* 20 */     sb.append(time.substring(10, 12));
/*    */ 
/* 22 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   public static Date parse2Date(String dateStr, String fmt) {
/* 26 */     if (fmt == null) {
/* 27 */       fmt = "yyMMddHHmmss";
/*    */     }
/* 29 */     SimpleDateFormat sdf = new SimpleDateFormat(fmt);
/* 30 */     Date date = null;
/*    */     try {
/* 32 */       date = sdf.parse(dateStr);
/*    */     } catch (ParseException e) {
/* 34 */       e.printStackTrace();
/*    */     }
/* 36 */     return date;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.common.UtilTime
 * JD-Core Version:    0.6.1
 */