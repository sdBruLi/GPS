/*    */ package com.china317.emmp.jtt808Gateway.server.transport;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808CodecFactory;
/*    */ import com.china317.core.distributor.SessionAuthorizationStatus;
/*    */ import com.china317.emmp.jtt808Gateway.server.common.config.Config;
/*    */ import com.china317.emmp.jtt808Gateway.server.common.config.ThreadConfig;
/*    */ import com.china317.emmp.jtt808Gateway.server.processor.CommonProcessor;
/*    */ import java.net.InetSocketAddress;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
/*    */ import org.apache.mina.core.session.IdleStatus;
/*    */ import org.apache.mina.filter.codec.ProtocolCodecFilter;
/*    */ import org.apache.mina.transport.socket.DatagramSessionConfig;
/*    */ import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
/*    */ 
/*    */ public class VehUdpServer
/*    */ {
/* 21 */   private static final Log log = LogFactory.getLog(VehUdpServer.class);
/* 22 */   private static VehUdpServer instance = null;
/* 23 */   private static ThreadConfig config = null;
/* 24 */   private int port = 3100;
/*    */ 
/*    */   private VehUdpServer() {
/* 27 */     config = Config.getThreadConfig(VehUdpServer.class);
/* 28 */     this.port = config.getListenPort();
/* 29 */     if (config.isRun()) {
/* 30 */       NioDatagramAcceptor acceptor = new NioDatagramAcceptor();
/* 31 */       acceptor.getSessionConfig().setReadBufferSize(4096);
/* 32 */       acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
/* 33 */       acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new JT808CodecFactory()));
/*    */ 
/* 35 */       CommonProcessor commonProcessor = new CommonProcessor("JT/T808--2011");
/* 36 */       String[] acceptCommands = commonProcessor.getConfig().getAcceptCommands();
/*    */ 
/* 38 */       VehUdpHandler vehHandler = new VehUdpHandler();
/* 39 */       vehHandler.registerProcessor("JT/T808--2011", commonProcessor, SessionAuthorizationStatus.Both_Session, acceptCommands);
/* 40 */       acceptor.setHandler(vehHandler);
/*    */ 
/* 42 */       DatagramSessionConfig dcfg = acceptor.getSessionConfig();
/* 43 */       dcfg.setReadBufferSize(4096);
/* 44 */       dcfg.setReceiveBufferSize(1024);
/* 45 */       dcfg.setSendBufferSize(1024);
/* 46 */       dcfg.setReuseAddress(true);
/*    */       while (true)
/*    */         try {
/* 49 */           acceptor.bind(new InetSocketAddress(this.port));
/* 50 */           log.info("UDP listen to:" + this.port + " successful");
/* 51 */           return;
/*    */         } catch (Exception e) {
/* 53 */           log.error(e.getMessage() + " port:" + this.port);
/*    */         }
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void startThread()
/*    */   {
/* 60 */     if (instance == null)
/* 61 */       instance = new VehUdpServer();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.VehUdpServer
 * JD-Core Version:    0.6.1
 */