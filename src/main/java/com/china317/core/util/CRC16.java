/*    */ package com.china317.core.util;
/*    */ 
/*    */ public class CRC16
/*    */ {
/*    */   private static int getCRC(String buf)
/*    */   {
/* 17 */     int crc = 65535;
/* 18 */     int polynomial = 4129;
/*    */ 
/* 20 */     for (int j = 0; j < buf.length(); j++) {
/* 21 */       char b = buf.charAt(j);
/*    */ 
/* 23 */       for (int i = 0; i < 8; i++) {
/* 24 */         boolean bit = (b >> 7 - i & 0x1) == 1;
/* 25 */         boolean c15 = (crc >> 15 & 0x1) == 1;
/* 26 */         crc <<= 1;
/* 27 */         if ((c15 ^ bit)) {
/* 28 */           crc ^= polynomial;
/*    */         }
/*    */       }
/*    */     }
/* 32 */     crc &= 65535;
/* 33 */     return crc;
/*    */   }
/*    */ 
/*    */   private static String getCRCString(String buf)
/*    */   {
/* 42 */     int crc = 65535;
/* 43 */     int polynomial = 4129;
/*    */ 
/* 45 */     for (int j = 0; j < buf.length(); j++) {
/* 46 */       char b = buf.charAt(j);
/* 47 */       for (int i = 0; i < 8; i++) {
/* 48 */         boolean bit = (b >> 7 - i & 0x1) == 1;
/* 49 */         boolean c15 = (crc >> 15 & 0x1) == 1;
/* 50 */         crc <<= 1;
/* 51 */         if ((c15 ^ bit)) {
/* 52 */           crc ^= polynomial;
/*    */         }
/*    */       }
/*    */     }
/* 56 */     crc &= 65535;
/* 57 */     String str = String.valueOf((char)(crc / 256) + (char)(crc % 256));
/* 58 */     return str;
/*    */   }
/*    */ 
/*    */   public static int getCRC(byte[] bytes) {
/* 62 */     int crc = 65535;
/* 63 */     int polynomial = 4129;
/*    */ 
/* 65 */     for (int j = 0; j < bytes.length; j++) {
/* 66 */       byte b = bytes[j];
/* 67 */       for (int i = 0; i < 8; i++) {
/* 68 */         boolean bit = (b >> 7 - i & 0x1) == 1;
/* 69 */         boolean c15 = (crc >> 15 & 0x1) == 1;
/* 70 */         crc <<= 1;
/* 71 */         if ((c15 ^ bit)) {
/* 72 */           crc ^= polynomial;
/*    */         }
/*    */       }
/*    */     }
/* 76 */     crc &= 65535;
/* 77 */     return crc;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */     throws Exception
/*    */   {
/* 92 */     byte[] bs = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.util.CRC16
 * JD-Core Version:    0.6.1
 */