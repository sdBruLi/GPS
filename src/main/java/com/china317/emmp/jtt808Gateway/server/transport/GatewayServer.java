/*    */ package com.china317.emmp.jtt808Gateway.server.transport;
/*    */ 
/*    */ import com.china317.core.codec.jtt808Gateway.GatewayCodecFactory;
/*    */ import com.china317.emmp.jtt808Gateway.server.common.config.Config;
/*    */ import com.china317.emmp.jtt808Gateway.server.common.config.ThreadConfig;
/*    */ import java.net.InetSocketAddress;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
/*    */ import org.apache.mina.core.session.IdleStatus;
/*    */ import org.apache.mina.filter.codec.ProtocolCodecFilter;
/*    */ import org.apache.mina.transport.socket.SocketSessionConfig;
/*    */ import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
/*    */ 
/*    */ public class GatewayServer extends Thread
/*    */ {
/* 16 */   private static final Log log = LogFactory.getLog(GatewayServer.class);
/* 17 */   private static GatewayServer instance = null;
/* 18 */   private static ThreadConfig config = null;
/* 19 */   private NioSocketAcceptor acceptor = null;
/* 20 */   private int port = 1582;
/*    */ 
/*    */   private GatewayServer() {
/* 23 */     config = Config.getThreadConfig(GatewayServer.class);
/* 24 */     this.port = config.getListenPort();
/* 25 */     setName(" face to center server");
/* 26 */     if (config.isRun())
/* 27 */       start();
/*    */   }
/*    */ 
/*    */   public static void startThread()
/*    */   {
/* 32 */     if (instance == null)
/* 33 */       instance = new GatewayServer();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 38 */     startThread();
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 43 */     ProtocolCodecFilter protocolCodecFilter = new ProtocolCodecFilter(new GatewayCodecFactory());
/* 44 */     GatewayHandler gatewayHandler = new GatewayHandler();
/*    */     while (true)
/*    */       try {
/* 47 */         this.acceptor = new NioSocketAcceptor();
/* 48 */         this.acceptor.getSessionConfig().setReadBufferSize(4096);
/* 49 */         this.acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
/* 50 */         this.acceptor.setReuseAddress(true);
/* 51 */         this.acceptor.getFilterChain().addLast("codec", protocolCodecFilter);
/* 52 */         this.acceptor.setHandler(gatewayHandler);
/*    */ 
/* 54 */         this.acceptor.bind(new InetSocketAddress(this.port));
/* 55 */         log.info("listen to:" + this.port + " successful");
/* 56 */         return;
/*    */       } catch (Exception e) {
/* 58 */         log.error(e.toString(), e);
/*    */         try {
/* 60 */           sleep(10000L);
/*    */         }
/*    */         catch (Exception localException1)
/*    */         {
/*    */         }
/*    */       }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.GatewayServer
 * JD-Core Version:    0.6.1
 */