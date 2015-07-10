/*     */ package com.china317.emmp.jtt808Gateway.server.transport;
/*     */ 
/*     */ import com.china317.emmp.jtt808Gateway.server.common.config.Config;
/*     */ import com.china317.emmp.jtt808Gateway.server.common.config.ThreadConfig;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ 
/*     */ public class SessionTimeoutManager extends Thread
/*     */ {
/*  17 */   private Log log = LogFactory.getLog(SessionTimeoutManager.class);
/*     */ 
/*  19 */   private static SessionTimeoutManager manager = new SessionTimeoutManager();
/*  20 */   private Map<Long, VehSession> sessionMap = new HashMap();
/*  21 */   private static long lastDataTimeout = 600000L;
/*  22 */   private static long openSessionTimeout = 20000L;
/*  23 */   private static ThreadConfig config = null;
/*     */ 
/*  25 */   private static long put = 0L;
/*  26 */   private static long remove = 0L;
/*     */ 
/* 119 */   SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
/*     */ 
/*     */   private SessionTimeoutManager()
/*     */   {
/*  29 */     config = Config.getThreadConfig(SessionTimeoutManager.class);
/*  30 */     if (config.getOpenSessionTimeout() * 1000 > openSessionTimeout) {
/*  31 */       openSessionTimeout = config.getOpenSessionTimeout() * 1000;
/*     */     }
/*  33 */     if (config.getLastDataTimeout() * 1000 > lastDataTimeout)
/*  34 */       lastDataTimeout = config.getLastDataTimeout() * 1000;
/*     */   }
/*     */ 
/*     */   public static SessionTimeoutManager getInstance()
/*     */   {
/*  39 */     return manager;
/*     */   }
/*     */ 
/*     */   public void putSession(IoSession session) {
/*  43 */     this.log.debug("SessionTimeoutManager putSession sessionId : " + session.getId());
/*  44 */     VehSession vehSession = new VehSession(session);
/*  45 */     synchronized (this.sessionMap) {
/*  46 */       this.sessionMap.put(Long.valueOf(session.getId()), vehSession);
/*  47 */       put += 1L;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updSessionLastTime(IoSession session, String mobileNum) {
/*  52 */     VehSession vehSession = getSession(session);
/*  53 */     if (vehSession != null) {
/*  54 */       this.log.debug("=" + vehSession.getSessionId() + " last " + vehSession.getLastDataTime());
/*  55 */       vehSession.updLastDataTime();
/*  56 */       this.log.debug("=" + vehSession.getSessionId() + " now " + vehSession.getLastDataTime());
/*     */     }
/*     */   }
/*     */ 
/*     */   public VehSession getSession(IoSession session) {
/*  61 */     return (VehSession)this.sessionMap.get(Long.valueOf(session.getId()));
/*     */   }
/*     */ 
/*     */   public void removeSession(Long sessionId)
/*     */   {
/*  83 */     VehSession remove2 = (VehSession)this.sessionMap.remove(sessionId);
/*  84 */     if (remove2 != null) {
/*  85 */       remove2.closeSession();
/*  86 */       this.log.debug("SessionTimeoutManager removeSession++++++++ sessionId =" + sessionId);
/*  87 */       remove += 1L;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*     */     while (true)
/*     */       try {
/*  95 */         synchronized (this.sessionMap) {
/*  96 */           Iterator iterator = this.sessionMap.values().iterator();
/*  97 */           continue;         }       } catch (Exception e) {
/* 114 */         this.log.error("", e);
/*     */       } 
/*     */   }
/*     */ 
/* 122 */   class VehSession { private long openSessionTime = 0L;
/* 123 */     private long lastDataTime = 0L;
/*     */     private IoSession session;
/*     */     private long sessionId;
/* 126 */     private String mobileNum = "";
/*     */     private Date createtime;
/*     */ 
/* 130 */     public Date getCreatetime() { return this.createtime; }
/*     */ 
/*     */     public void setCreatetime(Date createtime)
/*     */     {
/* 134 */       this.createtime = createtime;
/*     */     }
/*     */ 
/*     */     public VehSession(IoSession session) {
/* 138 */       this.session = session;
/* 139 */       this.sessionId = session.getId();
/* 140 */       this.createtime = new Date();
/* 141 */       setOpenSessionTime();
/*     */     }
/*     */ 
/*     */     public void updLastDataTime() {
/* 145 */       this.lastDataTime = System.currentTimeMillis();
/*     */     }
/*     */ 
/*     */     public void setOpenSessionTime() {
/* 149 */       this.openSessionTime = System.currentTimeMillis();
/*     */     }
/*     */ 
/*     */     public void closeSession() {
/*     */       try {
/* 154 */         this.session.close(false);
/*     */       } catch (Exception e) {
/* 156 */         SessionTimeoutManager.this.log.error("", e);
/*     */       }
/*     */     }
/*     */ 
/*     */     public boolean isTimeout() {
/* 161 */       boolean isTimeout = false;
/* 162 */       if (this.lastDataTime == 0L) {
/* 163 */         if (System.currentTimeMillis() - this.openSessionTime > SessionTimeoutManager.openSessionTimeout) {
/* 164 */           isTimeout = true;
/*     */         }
/*     */       }
/* 167 */       else if (System.currentTimeMillis() - this.lastDataTime > SessionTimeoutManager.lastDataTimeout) {
/* 168 */         isTimeout = true;
/*     */       }
/*     */ 
/* 171 */       return isTimeout;
/*     */     }
/*     */ 
/*     */     public long getSessionId() {
/* 175 */       return this.sessionId;
/*     */     }
/*     */ 
/*     */     public void setSessionId(long sessionId) {
/* 179 */       this.sessionId = sessionId;
/*     */     }
/*     */ 
/*     */     public IoSession getSession() {
/* 183 */       return this.session;
/*     */     }
/*     */ 
/*     */     public void setSession(IoSession session) {
/* 187 */       this.session = session;
/*     */     }
/*     */ 
/*     */     public String getMobileNum() {
/* 191 */       return this.mobileNum;
/*     */     }
/*     */ 
/*     */     public void setMobileNum(String mobileNum) {
/* 195 */       this.mobileNum = mobileNum;
/*     */     }
/*     */ 
/*     */     public long getLastDataTime() {
/* 199 */       return this.lastDataTime;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.SessionTimeoutManager
 * JD-Core Version:    0.6.1
 */