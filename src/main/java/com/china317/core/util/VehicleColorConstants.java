/*    */ package com.china317.core.util;
/*    */ 
/*    */ public class VehicleColorConstants
/*    */ {
/*    */   private static final String Color_Blue_Line = "蓝";
/*    */   private static final String Color_Yellow_Line = "黄";
/*    */   private static final String Color_Black_Line = "黑";
/*    */   private static final String Color_White_Line = "白";
/*    */   private static final String Color_Other_Line = "其他";
/*    */   private static final byte Color_Blue_Value = 1;
/*    */   private static final byte Color_Yellow_Value = 2;
/*    */   private static final byte Color_Black_Value = 3;
/*    */   private static final byte Color_White_Value = 4;
/*    */   private static final byte Color_Other_Value = 9;
/*    */ 
/*    */   public static byte getVehicleColorValue(String vehicleColor)
/*    */   {
/* 17 */     byte colorValue = 0;
/* 18 */     if ("蓝".equals(vehicleColor))
/* 19 */       colorValue = 1;
/* 20 */     else if ("黄".equals(vehicleColor))
/* 21 */       colorValue = 2;
/* 22 */     else if ("黑".equals(vehicleColor))
/* 23 */       colorValue = 3;
/* 24 */     else if ("白".equals(vehicleColor))
/* 25 */       colorValue = 4;
/* 26 */     else if ("其他".equals(vehicleColor)) {
/* 27 */       colorValue = 9;
/*    */     }
/* 29 */     return colorValue;
/*    */   }
/*    */ 
/*    */   public static String getVehicleColorLine(byte vehicleColor) {
/* 33 */     String colorLine = "";
/* 34 */     switch (vehicleColor) {
/*    */     case 1:
/* 36 */       colorLine = "蓝";
/* 37 */       break;
/*    */     case 2:
/* 39 */       colorLine = "黄";
/* 40 */       break;
/*    */     case 3:
/* 42 */       colorLine = "黑";
/* 43 */       break;
/*    */     case 4:
/* 45 */       colorLine = "白";
/* 46 */       break;
/*    */     case 9:
/* 48 */       colorLine = "其他";
/*    */     case 5:
/*    */     case 6:
/*    */     case 7:
/* 51 */     case 8: } return colorLine;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.util.VehicleColorConstants
 * JD-Core Version:    0.6.1
 */