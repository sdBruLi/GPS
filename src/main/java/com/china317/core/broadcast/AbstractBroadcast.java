/*     */ package com.china317.core.broadcast;
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
/*     */ public abstract class AbstractBroadcast
/*     */ {
/*  22 */   private static final Log log = LogFactory.getLog(AbstractBroadcast.class);
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
/*     */   public AbstractBroadcast(int maxRetryCount, int retryPeriod, AbstractDataPacket dataPacket, boolean hasResponse, IoAcceptor accptor)
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
/*  79 */     this.thread = new Thread() {
/*     */       public void run() {
/*  81 */         AbstractBroadcast.this.boardcast();
/*     */       }
/*     */     };
/*  84 */     this.dataPacket = dataPacket;
/*  85 */     this.acceptor = accptor;
/*     */   }
/*     */ 
/*     */   public int addSessions(long[] sessionIds)
/*     */   {
/*  99 */     int tmp = 0;
/* 100 */     if (!this.finished) {
/* 101 */       synchronized (this.lock) {
/* 102 */         for (long sessionId : sessionIds) {
/* 103 */           if ((!this.activeSessions.containsKey(Long.valueOf(sessionId))) && (!this.successedSessions.containsKey(Long.valueOf(sessionId)))) {
/* 104 */             this.activeSessions.put(Long.valueOf(sessionId), new Date());
/* 105 */             tmp++;
/* 106 */             this.failedSessions.remove(Long.valueOf(sessionId));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 111 */     return tmp;
/*     */   }
/*     */ 
/*     */   private void boardcast()
/*     */   {
/* 116 */     while (!this.finished)
/*     */     {
/* 118 */       if (this.activeSessions.isEmpty()) {
/* 119 */         this.finished = true;
/*     */       }
/*     */       else
/*     */       {
/* 123 */         List activeSessionIds = new ArrayList();
/* 124 */         synchronized (this.lock) {
/* 125 */           activeSessionIds.addAll((Collection)this.activeSessions.keySet());
/*     */         }
/* 127 */         for (Iterator localIterator = activeSessionIds.iterator(); localIterator.hasNext(); ) { long sessionId = ((Long)localIterator.next()).longValue();
/* 128 */           boolean success = false;
/*     */           try {
/* 130 */             IoSession session = (IoSession)this.acceptor.getManagedSessions().get(Long.valueOf(sessionId));
/* 131 */             session.write(this.dataPacket);
/* 132 */             success = true;
/*     */           } catch (Exception e) {
/* 134 */             synchronized (this.lock) {
/* 135 */               this.activeSessions.remove(Long.valueOf(sessionId));
/* 136 */               this.failedSessions.put(Long.valueOf(sessionId), new Date());
/*     */             }
/* 138 */             log.warn("boardcast to session[id=" + sessionId + "] error", e);
/*     */           }
/* 140 */           if (success) {
/* 141 */             if (!this.hasResponse) {
/* 142 */               synchronized (this.lock) {
/* 143 */                 this.activeSessions.remove(Long.valueOf(sessionId));
/* 144 */                 this.successedSessions.put(Long.valueOf(sessionId), new Date());
/*     */               }
/*     */             }
/* 147 */             int count = 0;
/* 148 */             if (this.retryCountMap.get(Long.valueOf(sessionId)) != null) {
/* 149 */               count = ((Integer)this.retryCountMap.get(Long.valueOf(sessionId))).intValue();
/*     */             }
/* 151 */             count++;
/* 152 */             this.retryCountMap.put(Long.valueOf(sessionId), Integer.valueOf(count));
/* 153 */             if (count > this.maxRetryCount) {
/* 154 */               synchronized (this.lock) {
/* 155 */                 this.activeSessions.remove(Long.valueOf(sessionId));
/* 156 */                 this.failedSessions.put(Long.valueOf(sessionId), new Date());
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         try
/*     */         {
/* 163 */           Thread.sleep(1000 * this.retryPeriod);
/*     */         } catch (Exception e) {
/* 165 */           log.error("broadcast thread sleep error", e);
/*     */         }
/*     */       }
/*     */     }
/* 169 */     process();
/* 170 */     log.info("broadcast is finished...");
/*     */   }
/*     */ 
/*     */   public abstract void process();
/*     */ 
/*     */   public void responseMessageReceived(long sessionId)
/*     */   {
/* 183 */     if (this.hasResponse)
/* 184 */       synchronized (this.lock) {
/* 185 */         if (this.activeSessions.remove(Long.valueOf(sessionId)) != null)
/* 186 */           this.successedSessions.put(Long.valueOf(sessionId), new Date());
/*     */       }
/*     */   }
/*     */ 
/*     */   public boolean isActiveSession(long sessionId)
/*     */   {
/* 198 */     return this.activeSessions.containsKey(Long.valueOf(sessionId));
/*     */   }
/*     */ 
/*     */   public boolean isFailedSession(long sessionId)
/*     */   {
/* 207 */     return this.failedSessions.containsKey(Long.valueOf(sessionId));
/*     */   }
/*     */ 
/*     */   public boolean isSuccessedSession(long sessionId)
/*     */   {
/* 216 */     return this.successedSessions.containsKey(Long.valueOf(sessionId));
/*     */   }
/*     */ 
/*     */   public void start()
/*     */   {
/* 223 */     this.thread.start();
/*     */   }
/*     */ 
/*     */   public void cancel()
/*     */   {
/* 231 */     this.finished = true;
/* 232 */     this.thread = null;
/* 233 */     this.failedSessions.putAll(this.activeSessions);
/*     */   }
/*     */ 
/*     */   public Map<Long, Date> getFailedSessions() {
/* 237 */     return this.failedSessions;
/*     */   }
/*     */ 
/*     */   public Map<Long, Date> getSuccessedSessions() {
/* 241 */     return this.successedSessions;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.broadcast.AbstractBroadcast
 * JD-Core Version:    0.6.1
 */