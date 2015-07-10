/*     */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*     */ 
/*     */ class VehSession
/*     */ {
/*     */   private long lastTime;
/*     */   public String sessionId;
/*     */   public String mobileNum;
/*     */ 
/*     */   public VehSession(String id)
/*     */   {
/* 318 */     this.lastTime = System.currentTimeMillis();
/* 319 */     this.sessionId = id;
/*     */   }
/*     */ 
/*     */   public void resetSessionId(String id) {
/* 323 */     this.lastTime = System.currentTimeMillis();
/* 324 */     this.sessionId = id;
/*     */   }
/*     */ 
/*     */   public void resetTime()
/*     */   {
/* 338 */     this.lastTime = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   public boolean isTimeout()
/*     */   {
/* 343 */     if (System.currentTimeMillis() - this.lastTime > 300000L) {
/* 344 */       return true;
/*     */     }
/* 346 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.VehSession
 * JD-Core Version:    0.6.1
 */