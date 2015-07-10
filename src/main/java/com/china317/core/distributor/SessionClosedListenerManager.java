/*    */ package com.china317.core.distributor;
/*    */ 
/*    */ import com.china317.core.event.SessionClosedListener;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class SessionClosedListenerManager
/*    */ {
/* 18 */   private static final Log log = LogFactory.getLog(SessionClosedListenerManager.class);
/* 19 */   private static SessionClosedListenerManager instance = new SessionClosedListenerManager();
/*    */   private Map<String, SessionClosedListener> map;
/*    */ 
/*    */   public static SessionClosedListenerManager getInstance()
/*    */   {
/* 21 */     return instance;
/*    */   }
/*    */ 
/*    */   private SessionClosedListenerManager() {
/* 25 */     this.map = new HashMap();
/*    */   }
/*    */ 
/*    */   public boolean register(SessionClosedListener listener)
/*    */   {
/* 34 */     return register(listener.getClass().getName(), listener);
/*    */   }
/*    */ 
/*    */   public boolean register(String name, SessionClosedListener listener)
/*    */   {
/* 43 */     if (this.map.containsKey(name)) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.map.put(name, listener);
/* 47 */     return true;
/*    */   }
/*    */ 
/*    */   public SessionClosedListener unregister(String name)
/*    */   {
/* 56 */     return (SessionClosedListener)this.map.remove(name);
/*    */   }
/*    */ 
/*    */   public Iterator<SessionClosedListener> listenerIterator()
/*    */   {
/* 64 */     return this.map.values().iterator();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.distributor.SessionClosedListenerManager
 * JD-Core Version:    0.6.1
 */