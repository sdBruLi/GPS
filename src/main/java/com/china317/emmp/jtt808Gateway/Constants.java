/*    */ package com.china317.emmp.jtt808Gateway;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class Constants
/*    */ {
/* 15 */   private static Log log = LogFactory.getLog(Constants.class);
/* 16 */   public static boolean NEED_AUTHENTICATION = true;
/* 17 */   public static int OUTOFMEMORY = 5000;
/*    */   protected static Properties properties;
/*    */ 
/*    */   public static boolean init()
/*    */   {
/*    */     try
/*    */     {
/* 23 */       properties = new Properties();
/* 24 */       properties.load(new FileInputStream("setting.properties"));
/*    */ 
/* 26 */       NEED_AUTHENTICATION = Boolean.valueOf(properties.getProperty(
/* 27 */         "NEED_AUTHENTICATION", "true")).booleanValue();
/*    */ 
/* 28 */       OUTOFMEMORY = Integer.parseInt(properties.getProperty(
/* 29 */         "OUTOFMEMORY", "5000"));
/*    */     } catch (Exception e) {
/* 31 */       log.error(e);
/* 32 */       return false;
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.Constants
 * JD-Core Version:    0.6.1
 */