/*     */ package com.china317.emmp.jtt808Gateway.server.broadcast;
/*     */ 
/*     */ import com.china317.core.base.AbstractDataPacket;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.service.IoAcceptor;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ 
/*     */ public abstract class UdpResponseBroadcast
/*     */ {
/*  22 */   private static final Log log = LogFactory.getLog(UdpResponseBroadcast.class);
/*     */   private int maxRetryCount;
/*     */   private int retryPeriod;
/*     */   private AbstractDataPacket dataPacket;
/*     */   private IoAcceptor acceptor;
/*     */   private Map<Long, Date> activeSessions;
/*     */   private Map<Long, Date> failedSessions;
/*     */   private Map<Long, Date> successedSessions;
/*     */   private Map<Long, Integer> retryCountMap;
/*     */   private boolean hasResponse;
/*     */   private Object lock;
/*     */   private boolean finished;
/*     */   private Thread thread;
/*     */ 
/*     */   public UdpResponseBroadcast(int maxRetryCount, int retryPeriod, AbstractDataPacket dataPacket, boolean hasResponse, IoAcceptor accptor)
/*     */   {
/*  69 */     this.maxRetryCount = maxRetryCount;
/*  70 */     this.retryPeriod = retryPeriod;
/*  71 */     this.dataPacket = dataPacket;
/*  72 */     this.hasResponse = hasResponse;
/*  73 */     this.activeSessions = new HashMap();
/*  74 */     this.failedSessions = new HashMap();
/*  75 */     this.successedSessions = new HashMap();
/*  76 */     this.retryCountMap = new HashMap();
/*  77 */     this.lock = new Object();
/*  78 */     this.finished = false;
/*  79 */     this.thread = new Thread()
/*     */     {
/*     */       public void run() {
/*  82 */         UdpResponseBroadcast.this.boardcast();
/*     */       }
/*     */     };
/*  85 */     this.dataPacket = dataPacket;
/*  86 */     this.acceptor = accptor;
/*     */   }
/*     */ 
/*     */   public int addSessions(long[] sessionIds)
/*     */   {
/* 100 */     int tmp = 0;
/* 101 */     if (!this.finished) {
/* 102 */       synchronized (this.lock) {
/* 103 */         for (long sessionId : sessionIds) {
/* 104 */           if ((!this.activeSessions.containsKey(Long.valueOf(sessionId))) && (!this.successedSessions.containsKey(Long.valueOf(sessionId)))) {
/* 105 */             this.activeSessions.put(Long.valueOf(sessionId), new Date());
/* 106 */             tmp++;
/* 107 */             this.failedSessions.remove(Long.valueOf(sessionId));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 112 */     return tmp;
/*     */   }
/*     */ 
/*     */   private void boardcast()
/*     */   {
/* 117 */     while (!this.finished)
/*     */     {
/* 119 */       if (this.activeSessions.isEmpty()) {
/* 120 */         this.finished = true;
/*     */       }
/*     */ 
/* 123 */       List activeSessionIds = new ArrayList();
/* 124 */       synchronized (this.lock) {
/* 125 */         activeSessionIds.addAll((Collection)this.activeSessions.keySet());
/*     */       }
/* 127 */       for (Iterator localIterator = activeSessionIds.iterator(); localIterator.hasNext(); ) { long sessionId = ((Long)localIterator.next()).longValue();
/* 128 */         boolean success = false;
/*     */         try {
/* 130 */           IoSession session = (IoSession)this.acceptor.getManagedSessions().get(Long.valueOf(sessionId));
/* 131 */           session.write(this.dataPacket);
/* 132 */           success = true;
/*     */         } catch (Exception e) {
/* 134 */           log.warn("boardcast to session[id=" + sessionId + "] error", e);
/*     */         }
/* 136 */         if (success) {
/* 137 */           if (!this.hasResponse) {
/* 138 */             synchronized (this.lock) {
/* 139 */               this.activeSessions.remove(Long.valueOf(sessionId));
/* 140 */               this.successedSessions.put(Long.valueOf(sessionId), new Date());
/*     */             }
/*     */           }
/* 143 */           int count = 0;
/* 144 */           if (this.retryCountMap.get(Long.valueOf(sessionId)) != null) {
/* 145 */             count = ((Integer)this.retryCountMap.get(Long.valueOf(sessionId))).intValue();
/*     */           }
/* 147 */           count++;
/* 148 */           this.retryCountMap.put(Long.valueOf(sessionId), Integer.valueOf(count));
/* 149 */           if (count > this.maxRetryCount) {
/* 150 */             synchronized (this.lock) {
/* 151 */               this.activeSessions.remove(Long.valueOf(sessionId));
/* 152 */               this.failedSessions.put(Long.valueOf(sessionId), new Date());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       try
/*     */       {
/* 159 */         Thread.sleep(1000 * this.retryPeriod);
/*     */       } catch (Exception e) {
/* 161 */         log.error("broadcast thread sleep error", e);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 166 */     log.info("broadcast is finished...");
/*     */   }
/*     */ 
/*     */   public void responseMessageReceived(long sessionId)
/*     */   {
/* 174 */     if (this.hasResponse)
/* 175 */       synchronized (this.lock) {
/* 176 */         if (this.activeSessions.remove(Long.valueOf(sessionId)) != null)
/* 177 */           this.successedSessions.put(Long.valueOf(sessionId), new Date());
/*     */       }
/*     */   }
/*     */ 
/*     */   public boolean isActiveSession(long sessionId)
/*     */   {
/* 189 */     return this.activeSessions.containsKey(Long.valueOf(sessionId));
/*     */   }
/*     */ 
/*     */   public boolean isFailedSession(long sessionId)
/*     */   {
/* 198 */     return this.failedSessions.containsKey(Long.valueOf(sessionId));
/*     */   }
/*     */ 
/*     */   public boolean isSuccessedSession(long sessionId)
/*     */   {
/* 207 */     return this.successedSessions.containsKey(Long.valueOf(sessionId));
/*     */   }
/*     */ 
/*     */   public void start()
/*     */   {
/* 214 */     this.thread.start();
/*     */   }
/*     */ 
/*     */   public void cancel()
/*     */   {
/* 222 */     this.finished = true;
/* 223 */     this.thread = null;
/* 224 */     this.failedSessions.putAll(this.activeSessions);
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.broadcast.UdpResponseBroadcast
 * JD-Core Version:    0.6.1
 */