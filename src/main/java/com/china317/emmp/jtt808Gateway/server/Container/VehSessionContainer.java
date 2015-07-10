/*    */ package com.china317.emmp.jtt808Gateway.server.Container;
/*    */ 
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ 
/*    */ public class VehSessionContainer
/*    */ {
/* 15 */   private static ConcurrentHashMap<String, IoSession> vehSessions = new ConcurrentHashMap();
/*    */ 
/*    */   public static void addVeh2container(String phoneNum, IoSession session) {
/* 18 */     vehSessions.put(phoneNum, session);
/*    */   }
/*    */ 
/*    */   public static IoSession getVehSessionBy(String phoneNum) {
/* 22 */     return (IoSession)vehSessions.get(phoneNum);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.Container.VehSessionContainer
 * JD-Core Version:    0.6.1
 */