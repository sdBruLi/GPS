/*    */ package com.china317.core.util;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class Encrypt
/*    */ {
/*    */   public static byte[] encrypt(long M1, long IA1, long IC1, long key, byte[] bytes)
/*    */   {
/*  9 */     if (0L == key) {
/* 10 */       key = 1L;
/*    */     }
/* 12 */     if (0L == M1) {
/* 13 */       M1 = 1L;
/*    */     }
/* 15 */     int index = 0;
/* 16 */     byte[] result = new byte[bytes.length];
/* 17 */     while (index < bytes.length) {
/* 18 */       long temp = IA1 * (key % M1);
/* 19 */       if (temp > 4294967295L) {
/* 20 */         temp = temp << 32 >>> 32;
/*    */       }
/* 22 */       key = temp + IC1;
/* 23 */       if (key > 4294967295L) {
/* 24 */         key = key << 32 >>> 32;
/*    */       }
/* 26 */       result[index] = (byte)(bytes[index] ^ (byte)(int)(key >> 20 & 0xFF));
/* 27 */       index++;
/*    */     }
/* 29 */     return result;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 33 */     long key = 18468L;
/* 34 */     long M1 = 10000000L;
/* 35 */     long IA1 = 20000000L;
/* 36 */     long IC1 = 30000000L;
/*    */ 
/* 51 */     String code = "15 F8 42 68 A0 D7 5D C0 51 93 A4 A3 84 44 ED CE 27 AF D6 E4 26 3F 79 1C E8 FA 9F 29 7A 51 A6 69 40 4B FC A4 09 C9 14 4C 88 03 16 7C E3 A9 ";
/* 52 */     code = code.replaceAll(" ", "");
/* 53 */     byte[] b = ByteUtil.getDecodeData(code);
/* 54 */     byte[] bytes6 = encrypt(M1, IA1, IC1, key, b);
/* 55 */     IoBuffer ioBuffer6 = IoBuffer.wrap(bytes6);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.util.Encrypt
 * JD-Core Version:    0.6.1
 */