/*     */ package com.china317.core.distributor;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ 
/*     */ public class SessionManager
/*     */ {
/*  18 */   private Log log = LogFactory.getLog(SessionManager.class);
/*     */   private Map<Long, IoSessionWrapper> map;
/*     */   private DistributorHandlerAdapter distributorHandler;
/*     */   private int hash;
/*  23 */   private long put = 0L;
/*  24 */   private long remove = 0L;
/*     */ 
/*     */   public SessionManager(DistributorHandlerAdapter distributorHandler)
/*     */   {
/*  32 */     this.map = new HashMap();
/*  33 */     this.distributorHandler = distributorHandler;
/*  34 */     this.hash = hashCode();
/*  35 */     new Thread()
/*     */     {
/*     */       public void run() {
/*     */         while (true) {
/*     */           try {
/*  40 */             sleep(20000L);
/*     */           } catch (Throwable ex) {
/*  42 */             ex.printStackTrace();
/*     */           }
/*  44 */           SessionManager.this.log.info(SessionManager.this.hash + " ++++++SessionManagerput " + SessionManager.this.put + " ,remove " + SessionManager.this.remove + " ,mapsize " + SessionManager.this.map.size());
/*  45 */           SessionManager.this.put = 0L;
/*  46 */           SessionManager.this.remove = 0L;
/*     */         }
/*     */       }
/*     */     }
/*  49 */     .start();
/*     */   }
/*     */ 
/*     */   public void put(IoSession session)
/*     */   {
/*  58 */     put(session, true);
/*     */   }
/*     */ 
/*     */   public void put(IoSession session, boolean authorized) {
/*  62 */     this.map.put(Long.valueOf(session.getId()), new IoSessionWrapper(session, authorized, null));
/*  63 */     this.put += 1L;
/*     */   }
/*     */ 
/*     */   public void remove(long sessionId)
/*     */   {
/*  72 */     if (this.map.remove(Long.valueOf(sessionId)) != null)
/*  73 */       this.remove += 1L;
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/*  78 */     return this.map.size();
/*     */   }
/*     */ 
/*     */   public void setSessionAuthorized(long sessionId, String authorizationId)
/*     */   {
/*  88 */     IoSessionWrapper sessionWrapper = (IoSessionWrapper)this.map.get(Long.valueOf(sessionId));
/*  89 */     if (sessionWrapper != null) {
/*  90 */       sessionWrapper.authorized = true;
/*  91 */       sessionWrapper.authorizationId = authorizationId;
/*  92 */       this.distributorHandler.sessionAuthorized(sessionWrapper.session, sessionWrapper.authorizationId);
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isSessionAuthorized(long sessionId)
/*     */   {
/* 103 */     IoSessionWrapper sessionWrapper = (IoSessionWrapper)this.map.get(Long.valueOf(sessionId));
/* 104 */     if (sessionWrapper != null) {
/* 105 */       return sessionWrapper.authorized;
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   public String getSessionAuthorizationId(long sessionId)
/*     */   {
/* 118 */     IoSessionWrapper sessionWrapper = (IoSessionWrapper)this.map.get(Long.valueOf(sessionId));
/* 119 */     if (sessionWrapper != null) {
/* 120 */       return sessionWrapper.authorizationId;
/*     */     }
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */   public IoSession getSession(long sessionId)
/*     */   {
/* 133 */     IoSessionWrapper sessionWrapper = (IoSessionWrapper)this.map.get(Long.valueOf(sessionId));
/* 134 */     if (sessionWrapper != null) {
/* 135 */       return sessionWrapper.session;
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */ 
/*     */   public Iterator<IoSessionWrapper> getAllSession()
/*     */   {
/* 162 */     return this.map.values().iterator();
/*     */   }
/*     */ 
/*     */   public class IoSessionWrapper
/*     */   {
/*     */     private IoSession session;
/*     */     private boolean authorized;
/*     */     private String authorizationId;
/*     */ 
/*     */     IoSessionWrapper(IoSession session, boolean authorized, String authorizationId)
/*     */     {
/* 147 */       this.session = session;
/* 148 */       this.authorized = authorized;
/* 149 */       this.authorizationId = authorizationId;
/*     */     }
/*     */ 
/*     */     public IoSession getSession() {
/* 153 */       return this.session;
/*     */     }
/*     */ 
/*     */     public void setSession(IoSession session) {
/* 157 */       this.session = session;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.distributor.SessionManager
 * JD-Core Version:    0.6.1
 */