/*    */ package com.china317.core.util;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ 
/*    */ public class BytesUtil
/*    */ {
/*    */   public static final long byte4ToLong(byte[] source, boolean littleEndian)
/*    */   {
/*  8 */     long[] tmpArray = new long[4];
/*  9 */     if (source.length != 4) {
/* 10 */       return -1L;
/*    */     }
/* 12 */     if (littleEndian) {
/* 13 */       for (int i = 0; i < 4; i++) {
/* 14 */         if (source[i] < 0)
/* 15 */           tmpArray[i] = source[i] + 256;
/*    */         else
/* 17 */           tmpArray[i] = source[i];
/*    */       }
/*    */     }
/*    */     else {
/* 21 */       for (int i = 0; i < 4; i++) {
/* 22 */         if (source[i] < 0)
/* 23 */           tmpArray[(3 - i)] = source[i] + 256;
/*    */         else {
/* 25 */           tmpArray[(3 - i)] = source[i];
/*    */         }
/*    */       }
/*    */     }
/* 29 */     long tmp2 = (tmpArray[3] << 24) + (
/* 30 */       tmpArray[2] << 16) + (tmpArray[1] << 8) + tmpArray[0];
/*    */ 
/* 32 */     return tmp2;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 36 */     String s = "7FFFFFFE";
/*    */ 
/* 38 */     byte[] asd = ByteUtil.hexString2byteArray(s);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.util.BytesUtil
 * JD-Core Version:    0.6.1
 */