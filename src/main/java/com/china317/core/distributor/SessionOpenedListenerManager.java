/*    */ package com.china317.core.distributor;
/*    */ 
/*    */ import com.china317.core.event.SessionOpenedListener;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class SessionOpenedListenerManager
/*    */ {
/* 18 */   private static final Log log = LogFactory.getLog(SessionOpenedListenerManager.class);
/* 19 */   private static SessionOpenedListenerManager instance = new SessionOpenedListenerManager();
/*    */   private Map<String, SessionOpenedListener> map;
/*    */ 
/*    */   public static SessionOpenedListenerManager getInstance()
/*    */   {
/* 21 */     return instance;
/*    */   }
/*    */ 
/*    */   private SessionOpenedListenerManager() {
/* 25 */     this.map = new HashMap();
/*    */   }
/*    */ 
/*    */   public boolean register(SessionOpenedListener listener)
/*    */   {
/* 34 */     return register(listener.getClass().getName(), listener);
/*    */   }
/*    */ 
/*    */   public boolean register(String name, SessionOpenedListener listener)
/*    */   {
/* 43 */     if (this.map.containsKey(name)) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.map.put(name, listener);
/* 47 */     return true;
/*    */   }
/*    */ 
/*    */   public SessionOpenedListener unregister(String name)
/*    */   {
/* 56 */     return (SessionOpenedListener)this.map.remove(name);
/*    */   }
/*    */ 
/*    */   public Iterator<SessionOpenedListener> listenerIterator()
/*    */   {
/* 63 */     return this.map.values().iterator();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.distributor.SessionOpenedListenerManager
 * JD-Core Version:    0.6.1
 */