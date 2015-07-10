/*    */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*    */ 
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class DownMessageParser
/*    */ {
/*  7 */   private static final Log log = LogFactory.getLog(DownMessageParser.class);
/*    */ 
/*    */   public static DownMessageParser getInstance()
/*    */   {
/* 15 */     return DownMessageParserHolder.instance;
/*    */   }
/*    */ 
/*    */   public DownMessageAdapter parseMessage(DownMessage downMessage) {
/*    */     try {
/* 20 */       return new DownMessageAdapter(downMessage, downMessage.pack());
/*    */     } catch (Exception e) {
/* 22 */       log.error("DownMessageParser error : from DownMessage to DownMessageImpl", e);
/*    */     }
/* 24 */     return null;
/*    */   }
/*    */ 
/*    */   static class DownMessageParserHolder
/*    */   {
/* 11 */     static DownMessageParser instance = new DownMessageParser();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.DownMessageParser
 * JD-Core Version:    0.6.1
 */