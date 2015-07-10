/*     */ package com.china317.emmp.jtt808Gateway.server.transport;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class VehSessionManager
/*     */ {
/*  11 */   private Log log = LogFactory.getLog(VehSessionManager.class);
/*  12 */   private ConcurrentHashMap<String, VehSession> vehSessionMap = new ConcurrentHashMap();
/*     */   private static Thread s;
/*     */ 
/*     */   public VehSessionManager()
/*     */   {
/*  21 */     if (s == null) {
/*  22 */       s = new Thread()
/*     */       {
/*     */         public void run() {
/*     */           while (true) {
/*     */             try {
/*  27 */               sleep(20000L);
/*     */             } catch (Throwable ex) {
/*  29 */               ex.printStackTrace();
/*     */             }
/*  31 */             VehSessionManager.this.log.info("++++++ ConcurrentHashMap " + VehSessionManager.this.vehSessionMap.size());
/*     */           }
/*     */         }
/*     */       };
/*  35 */       s.start();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static VehSessionManager getInstance() {
/*  40 */     return VehSessionManagerHolder.instance;
/*     */   }
/*     */ 
/*     */   public void updVehSessionId(String mobileNum, long id) {
/*  44 */     Long currentId = getVehSessionId(mobileNum);
/*  45 */     if ((currentId == null) || (currentId.longValue() != id)) {
/*  46 */       putVehSession(mobileNum, id);
/*  47 */       this.log.debug("Upd vehSessionId of VehSessionManager, MobileNum[" + mobileNum + "] sessionId[" + id + "]");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void putVehSession(String mobileNum, long id) {
/*  52 */     VehSession vehSession = (VehSession)this.vehSessionMap.get(mobileNum);
/*  53 */     if (vehSession == null) {
/*  54 */       this.vehSessionMap.put(mobileNum, new VehSession(id, mobileNum));
/*     */     }
/*  56 */     else if (vehSession.sessionId != id) {
/*  57 */       vehSession.resetSessionId(id, mobileNum);
/*     */     }
/*     */ 
/*  60 */     clearVehSession();
/*     */   }
/*     */ 
/*     */   private void clearVehSession() {
/*  64 */     List<String> keys = null;
/*  65 */     for (Iterator localIterator = this.vehSessionMap.keySet().iterator(); localIterator.hasNext(); ) { Object o = localIterator.next();
/*  66 */       VehSession b = (VehSession)this.vehSessionMap.get(o);
/*  67 */       if (b.isTimeout()) {
/*  68 */         if (keys == null) {
/*  69 */           keys = new ArrayList();
/*     */         }
/*  71 */         keys.add((String)o);
/*     */       }
/*     */     }
/*  74 */     if (keys != null)
/*  75 */       for (String key : keys) {
/*  76 */         VehSession b = (VehSession)this.vehSessionMap.remove(key);
/*     */ 
/*  79 */         this.log.info("Remove vehSessionId from VehSessionManager, MobileNum[" + b.mobileNum + "] sessionId[" + b.sessionId + "]");
/*     */       }
/*     */   }
/*     */ 
/*     */   public Long getVehSessionId(String mobileNum)
/*     */   {
/*  85 */     VehSession vehSession = (VehSession)this.vehSessionMap.get(mobileNum);
/*  86 */     if (vehSession != null) {
/*  87 */       return Long.valueOf(vehSession.sessionId);
/*     */     }
/*  89 */     return null;
/*     */   }
/*     */ 
/*     */   private class VehSession
/*     */   {
/*     */     private long lastTime;
/*     */     private String mobileNum;
/*     */     private long sessionId;
/* 101 */     private long TIMEOUT = 600000L;
/*     */ 
/*     */     public VehSession(long id, String mobileNum) {
/* 104 */       resetSessionId(id, mobileNum);
/*     */     }
/*     */ 
/*     */     public void resetSessionId(long id, String mobileNum) {
/* 108 */       resetTime();
/* 109 */       this.sessionId = id;
/* 110 */       this.mobileNum = mobileNum;
/*     */     }
/*     */ 
/*     */     public void resetTime() {
/* 114 */       this.lastTime = System.currentTimeMillis();
/*     */     }
/*     */ 
/*     */     public boolean isTimeout()
/*     */     {
/* 119 */       if (System.currentTimeMillis() - this.lastTime > this.TIMEOUT) {
/* 120 */         return true;
/*     */       }
/* 122 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   static class VehSessionManagerHolder
/*     */   {
/*  15 */     static VehSessionManager instance = new VehSessionManager();
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.VehSessionManager
 * JD-Core Version:    0.6.1
 */