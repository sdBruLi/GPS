/*    */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.Stack;
/*    */ 
/*    */ class Generator
/*    */ {
/*    */   private Date prefix;
/*    */   private long prefixValidPeriod;
/*    */   private int maxSerialNumber;
/*    */   private int currentSerialNumber;
/*    */   private Stack stack;
/*    */   private int speed;
/*    */ 
/*    */   protected Generator()
/*    */   {
/* 46 */     this.prefix = new Date();
/* 47 */     this.prefixValidPeriod = 10000L;
/* 48 */     this.maxSerialNumber = 99999;
/* 49 */     this.currentSerialNumber = 0;
/* 50 */     this.stack = new Stack();
/* 51 */     this.speed = 99999;
/*    */   }
/*    */ 
/*    */   private String getPrefix() {
/* 55 */     Date now = new Date();
/* 56 */     while (now.getTime() <= this.prefix.getTime()) {
/*    */       try {
/* 58 */         Thread.sleep(1000L);
/*    */       }
/*    */       catch (Exception localException) {
/*    */       }
/* 62 */       now = new Date();
/*    */     }
/* 64 */     this.prefix = now;
/*    */ 
/* 66 */     return new SimpleDateFormat("yyyyMMddHHmmss").format(this.prefix);
/*    */   }
/*    */ 
/*    */   private void produce()
/*    */   {
/* 71 */     String prefixStr = getPrefix();
/* 72 */     for (int i = this.speed; i > 0; i--) {
/* 73 */       String key = prefixStr + new DecimalFormat("00000").format(i);
/* 74 */       this.stack.push(key);
/*    */     }
/*    */   }
/*    */ 
/*    */   protected String get() {
/* 79 */     if (new Date().getTime() - this.prefix.getTime() >= 3600000L) {
/* 80 */       this.stack.clear();
/*    */     }
/* 82 */     if (this.stack.empty())
/*    */     {
/* 84 */       produce();
/*    */     }
/* 86 */     return (String)this.stack.pop();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.Generator
 * JD-Core Version:    0.6.1
 */