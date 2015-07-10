/*    */ package com.china317.core.distributor;
/*    */ 
/*    */ import com.china317.core.event.SessionAuthorizedListener;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class SessionAuthorizedListenerManager
/*    */ {
/* 19 */   private static final Log log = LogFactory.getLog(SessionAuthorizedListenerManager.class);
/* 20 */   private static SessionAuthorizedListenerManager instance = new SessionAuthorizedListenerManager();
/*    */   private Map<String, SessionAuthorizedListener> map;
/*    */ 
/*    */   public static SessionAuthorizedListenerManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */ 
/*    */   private SessionAuthorizedListenerManager() {
/* 26 */     this.map = new HashMap();
/*    */   }
/*    */ 
/*    */   public boolean register(SessionAuthorizedListener listener)
/*    */   {
/* 35 */     return register(listener.getClass().getName(), listener);
/*    */   }
/*    */ 
/*    */   public boolean register(String name, SessionAuthorizedListener listener)
/*    */   {
/* 44 */     if (this.map.containsKey(name)) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.map.put(name, listener);
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */   public SessionAuthorizedListener unregister(String name)
/*    */   {
/* 57 */     return (SessionAuthorizedListener)this.map.remove(name);
/*    */   }
/*    */ 
/*    */   public Iterator<SessionAuthorizedListener> listenerIterator()
/*    */   {
/* 64 */     return this.map.values().iterator();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.distributor.SessionAuthorizedListenerManager
 * JD-Core Version:    0.6.1
 */