/*    */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*    */ 
/*    */ public class MessageKeyGenerator
/*    */ {
/* 20 */   protected static Integer upLockFlag = new Integer(0);
/*    */ 
/* 27 */   private static final Generator instance = new Generator();
/*    */ 
/*    */   public static String fetch()
/*    */   {
/* 24 */     return instance.get();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */     throws Exception
/*    */   {
/* 30 */     for (int i = 0; i < 100; i++)
/* 31 */       Thread.sleep(2000L);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.MessageKeyGenerator
 * JD-Core Version:    0.6.1
 */