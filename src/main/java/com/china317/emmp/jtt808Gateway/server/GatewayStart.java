/*    */ package com.china317.emmp.jtt808Gateway.server;
/*    */ 
/*    */ import com.china317.emmp.jtt808Gateway.Constants;
/*    */ import com.china317.emmp.jtt808Gateway.server.Container.DistributeClientContainer;
/*    */ import com.china317.emmp.jtt808Gateway.server.transport.GatewayServer;
/*    */ import com.china317.emmp.jtt808Gateway.server.transport.SessionTimeoutManager;
/*    */ import com.china317.emmp.jtt808Gateway.server.transport.VehServer;
/*    */ import com.china317.emmp.jtt808Gateway.server.transport.VehUdpServer;
/*    */ 
/*    */ public class GatewayStart
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 12 */     Constants.init();
/* 13 */     DistributeClientContainer.startClient();
/* 14 */     VehServer.startThread();
/* 15 */     GatewayServer.startThread();
/* 16 */     VehUdpServer.startThread();
/* 17 */     SessionTimeoutManager.getInstance().start();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.GatewayStart
 * JD-Core Version:    0.6.1
 */