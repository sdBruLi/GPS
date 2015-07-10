/*     */ package com.china317.emmp.jtt808Gateway.server.transport;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808CodecFactory;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.distributor.SessionAuthorizationStatus;
/*     */ import com.china317.core.distributor.SessionAuthorizedListenerManager;
/*     */ import com.china317.core.distributor.SessionClosedListenerManager;
/*     */ import com.china317.core.distributor.SessionManager;
/*     */ import com.china317.core.distributor.SessionOpenedListenerManager;
/*     */ import com.china317.core.processor.AbstractProcessor;
/*     */ import com.china317.emmp.jtt808Gateway.server.common.config.Config;
/*     */ import com.china317.emmp.jtt808Gateway.server.common.config.ThreadConfig;
/*     */ import com.china317.emmp.jtt808Gateway.server.processor.CommonProcessor;
/*     */ import java.net.InetSocketAddress;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
/*     */ import org.apache.mina.core.session.IdleStatus;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ import org.apache.mina.filter.codec.ProtocolCodecFilter;
/*     */ import org.apache.mina.transport.socket.SocketSessionConfig;
/*     */ import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
/*     */ 
/*     */ public class VehServer extends Thread
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(VehServer.class);
/*  25 */   private int port = 1581;
/*  26 */   private int bufferSize = 4096;
/*  27 */   private int idelTime = 10;
/*     */   private NioSocketAcceptor acceptor;
/*     */   private VehHandler vehHandler;
/*  30 */   private static ThreadConfig config = null;
/*  31 */   private boolean running = false;
/*     */ 
/*     */   private VehServer() {
/*  34 */     config = Config.getThreadConfig(VehServer.class);
/*  35 */     this.port = config.getListenPort();
/*  36 */     setName(" face to vehicle server");
/*  37 */     if (config.isRun()) {
/*  38 */       log.info("start vehicle server");
/*  39 */       startup();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static VehServer getInstance()
/*     */   {
/*  48 */     return SingletonHolder.INSTANCE;
/*     */   }
/*     */ 
/*     */   public void startup() {
/*  52 */     if (!this.running) {
/*  53 */       start();
/*  54 */       this.running = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void startThread() {
/*  59 */     getInstance();
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*  65 */     SessionOpenedListenerManager.getInstance().register("VehSessionOpened", new VehSessionOpenedListener("VehSessionOpened"));
/*  66 */     SessionClosedListenerManager.getInstance().register("VehSessionClosed", new VehSessionClosedListener("VehSessionClosed"));
/*  67 */     SessionAuthorizedListenerManager.getInstance().register("VehSessionAuthorized", new VehSessionAuthorizedListener("VehSessionAuthorized"));
/*     */ 
/*  69 */     this.vehHandler = new VehHandler();
/*     */ 
/*  71 */     CommonProcessor commonProcessor = new CommonProcessor("JT/T808--2011");
/*  72 */     String[] acceptCommands = commonProcessor.getConfig().getAcceptCommands();
/*  73 */     this.vehHandler.registerProcessor(commonProcessor.getConfig().getProcessorName(), commonProcessor, SessionAuthorizationStatus.Authorized_Session, 
/*  74 */       acceptCommands);
/*     */     while (true)
/*     */       try
/*     */       {
/*  78 */         this.acceptor = new NioSocketAcceptor();
/*  79 */         this.acceptor.getSessionConfig().setReadBufferSize(this.bufferSize);
/*  80 */         this.acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, this.idelTime);
/*  81 */         this.acceptor.setReuseAddress(true);
/*  82 */         this.acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new JT808CodecFactory()));
/*  83 */         this.acceptor.setHandler(this.vehHandler);
/*  84 */         this.acceptor.bind(new InetSocketAddress(this.port));
/*  85 */         log.info("listen to:" + this.port + " success");
/*  86 */         return;
/*     */       } catch (Exception e) {
/*  88 */         log.error("listen to:" + this.port + " fail", e);
/*     */         try {
/*  90 */           sleep(10000L);
/*     */         }
/*     */         catch (Exception localException1)
/*     */         {
/*     */         }
/*     */       }
/*     */   }
/*     */ 
/*     */   public void registerProcessor(String processorName, AbstractProcessor processor, SessionAuthorizationStatus sessionAuthorizationStatus, String[] acceptCommands) {
/*  99 */     this.vehHandler.registerProcessor(processorName, processor, sessionAuthorizationStatus, acceptCommands);
/*     */   }
/*     */ 
/*     */   public static boolean write(long sessionId, UnitPackJT808 pack, boolean isClose) {
/* 103 */     if (getInstance() == null) {
/* 104 */       logerror("instance is null", sessionId, pack);
/* 105 */     } else if (getInstance().acceptor == null) {
/* 106 */       logerror("instance.acceptor is null", sessionId, pack);
/*     */     } else {
/* 108 */       IoSession session = getSession(sessionId);
/* 109 */       if (session == null) {
/* 110 */         logerror("session is null", sessionId, pack);
/* 111 */       } else if (!session.isConnected()) {
/* 112 */         logerror("session is closed", sessionId, pack);
/*     */       } else {
/* 114 */         session.write(pack);
/* 115 */         if (isClose) {
/* 116 */           session.close(false);
/*     */         }
/* 118 */         return true;
/*     */       }
/*     */     }
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */   public NioSocketAcceptor getAcceptor() {
/* 125 */     return this.acceptor;
/*     */   }
/*     */ 
/*     */   public static IoSession getSession(long sessionId) {
/* 129 */     return getInstance().vehHandler.getSessionManager().getSession(sessionId);
/*     */   }
/*     */ 
/*     */   private static void logerror(String str, long sessionId, UnitPackJT808 pack) {
/* 133 */     log.error("sessionId=" + sessionId + ",MobileNum=" + pack.getMobileNum() + " " + str);
/*     */   }
/*     */ 
/*     */   private static class SingletonHolder
/*     */   {
/*  44 */     private static final VehServer INSTANCE = new VehServer();
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.VehServer
 * JD-Core Version:    0.6.1
 */