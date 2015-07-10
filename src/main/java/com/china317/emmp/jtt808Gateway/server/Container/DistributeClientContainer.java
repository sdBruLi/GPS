/*    */ package com.china317.emmp.jtt808Gateway.server.Container;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.emmp.jtt808Gateway.distribute.ConfigLoader;
/*    */ import com.china317.emmp.jtt808Gateway.distribute.client.DistributeClient;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class DistributeClientContainer
/*    */ {
/* 19 */   private static final Log log = LogFactory.getLog(DistributeClientContainer.class);
/* 20 */   private static ConcurrentHashMap<String, DistributeClient> clientMap = new ConcurrentHashMap();
/*    */ 
/*    */   public static Iterator<DistributeClient> getClients() {
/* 23 */     return clientMap.values().iterator();
/*    */   }
/*    */ 
/*    */   public static DistributeClient getClientBy(String name) {
/* 27 */     return (DistributeClient)clientMap.get(name);
/*    */   }
/*    */ 
/*    */   public static void put(String name, DistributeClient client) {
/* 31 */     clientMap.put(name, client);
/*    */   }
/*    */ 
/*    */   public static void offerData(UnitPackJT808 pack)
/*    */   {
/* 39 */     Iterator iterator = clientMap.values().iterator();
/* 40 */     DistributeClient next = null;
/* 41 */     while (iterator.hasNext()) {
/* 42 */       next = (DistributeClient)iterator.next();
/* 43 */       next.add2Queue(pack);
/* 44 */       log.info("add to " + next.getClinetName());
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void startClient()
/*    */   {
/* 53 */     ConfigLoader.getInstance().load();
/*    */ 
/* 55 */     Iterator iterator = clientMap.values().iterator();
/* 56 */     while (iterator.hasNext())
/* 57 */       ((DistributeClient)iterator.next()).init();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.Container.DistributeClientContainer
 * JD-Core Version:    0.6.1
 */