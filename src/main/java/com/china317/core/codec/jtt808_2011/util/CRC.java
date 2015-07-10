/*    */ package com.china317.core.codec.jtt808_2011.util;
/*    */ 
/*    */ public class CRC
/*    */ {
/*    */   public static byte getCRC(byte[] mesg, int from, int len)
/*    */   {
/*  6 */     byte ret = mesg[from];
/*  7 */     for (int i = from + 1; i < from + len; i++) {
/*  8 */       ret = (byte)(ret ^ mesg[i]);
/*    */     }
/* 10 */     return ret;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.util.CRC
 * JD-Core Version:    0.6.1
 */