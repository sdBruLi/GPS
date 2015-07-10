/*     */ package com.china317.emmp.jtt808Gateway.distribute.client;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808CodecFactory;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.emmp.jtt808Gateway.Constants;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
/*     */ import org.apache.mina.core.future.ConnectFuture;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ import org.apache.mina.filter.codec.ProtocolCodecFilter;
/*     */ import org.apache.mina.transport.socket.nio.NioSocketConnector;
/*     */ 
/*     */ public class DistributeClient
/*     */ {
/*  24 */   private static final Log log = LogFactory.getLog(DistributeClient.class);
/*     */   private NioSocketConnector connector;
/*     */   private IoSession session;
/*  28 */   private int remotePort = 1581;
/*  29 */   private String remoteIp = "127.0.0.1";
/*  30 */   private String clinetName = "D1";
/*     */   private DistributeHandler handler;
/*  32 */   private boolean isRun = false;
/*     */   private Thread sendThread;
/*     */   private List<Integer> acceptMsgId;
/*     */   private List<Integer> distributeMsgId;
/*     */   private List<String> distributeCars;
/*     */   private ConcurrentLinkedQueue<UnitPackJT808> distributeQueue;
/*     */   private InetSocketAddress address;
/*     */ 
/*     */   public void init()
/*     */   {
/*  47 */     if (this.isRun) {
/*  48 */       this.distributeQueue = new ConcurrentLinkedQueue();
/*     */ 
/*  52 */       if (this.handler == null) {
/*  53 */         this.handler = new DistributeHandler();
/*  54 */         this.handler.setClient(this);
/*     */       }
/*     */ 
/*  68 */       startup();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void startup()
/*     */   {
/*     */     try
/*     */     {
/*  77 */       this.connector = new NioSocketConnector();
/*  78 */       this.connector.setConnectTimeoutMillis(30000L);
/*  79 */       this.connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new JT808CodecFactory()));
/*  80 */       this.connector.setHandler(this.handler);
/*     */ 
/*  82 */       ConnectFuture future = this.connector.connect(this.address);
/*  83 */       future.awaitUninterruptibly();
/*  84 */       if ((future.isDone()) && 
/*  85 */         (!future.isConnected())) {
/*  86 */         this.connector.dispose();
/*  87 */         log.error("未在时限内建立连接");
/*  88 */         return;
/*     */       }
/*     */ 
/*  91 */       this.session = future.getSession();
/*     */ 
/*  93 */       log.info("try to connect " + this.address);
/*     */ 
/*  95 */       if (this.sendThread == null) {
/*  96 */         this.sendThread = new Thread(new Runnable()
/*     */         {
/*     */           public void run() {
/*  99 */             long outmemorytime = 0L;
/*     */             while (true)
/*     */               try {
/* 102 */                 Thread.sleep(10L);
/* 103 */                 DistributeClient.this.write((UnitPackJT808)DistributeClient.this.distributeQueue.poll());
/*     */ 
/* 105 */                 if ((outmemorytime == 0L) && (DistributeClient.this.distributeMsgId.size() > Constants.OUTOFMEMORY / 2)) {
/* 106 */                   outmemorytime = System.currentTimeMillis();
/*     */                 }
/* 108 */                 if (outmemorytime != 0L)
/* 109 */                   if (DistributeClient.this.distributeMsgId.size() >= Constants.OUTOFMEMORY) {
/* 110 */                     DistributeClient.log.info("drop message!");
/* 111 */                     DistributeClient.this.distributeQueue.clear();
/* 112 */                     outmemorytime = 0L;
/*     */                   }
/* 114 */                   else if (System.currentTimeMillis() - outmemorytime > 300000L) {
/* 115 */                     DistributeClient.log.info("drop message!");
/* 116 */                     DistributeClient.this.distributeQueue.clear();
/* 117 */                     outmemorytime = 0L;
/*     */                   }
/*     */               }
/*     */               catch (Exception e)
/*     */               {
/* 122 */                 DistributeClient.this.rebuildSession();
/*     */               }
/*     */           }
/*     */         });
/* 127 */         this.sendThread.start();
/*     */       }
/*     */     } catch (Exception e) {
/* 130 */       rebuildSession();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void rebuildSession() {
/*     */     try {
/* 136 */       if (this.session != null) {
/* 137 */         this.session.close(false);
/*     */       }
/* 139 */       this.session = null;
/* 140 */       log.error("session error or closed");
/* 141 */       Thread.sleep(10000L);
/* 142 */       startup();
/*     */     } catch (Exception localException) {
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean write(UnitPackJT808 message) {
/* 148 */     if ((this.session == null) || (message == null)) {
/* 149 */       return false;
/*     */     }
/*     */ 
/* 152 */     if (this.distributeCars.contains(message.getMobileNum()))
/*     */     {
/* 154 */       if (this.distributeMsgId.contains(Integer.valueOf(message.getMsgID()))) {
/* 155 */         this.session.write(message);
/* 156 */         log.info("write to distributeserver");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   public void add2Queue(UnitPackJT808 pack)
/*     */   {
/* 166 */     if (this.isRun) {
/* 167 */       this.distributeQueue.offer(pack);
/* 168 */       log.info("add to " + this.clinetName);
/*     */     }
/*     */   }
/*     */ 
/*     */   public IoSession getSession() {
/* 173 */     return this.session;
/*     */   }
/*     */ 
/*     */   public int getRemotePort() {
/* 177 */     return this.remotePort;
/*     */   }
/*     */ 
/*     */   public String getRemoteIp() {
/* 181 */     return this.remoteIp;
/*     */   }
/*     */ 
/*     */   public void setRemoteIp(String remoteIp, int remotePort) {
/* 185 */     this.remoteIp = remoteIp;
/* 186 */     this.remotePort = remotePort;
/* 187 */     this.address = new InetSocketAddress(remoteIp, remotePort);
/*     */   }
/*     */ 
/*     */   public String getClinetName() {
/* 191 */     return this.clinetName;
/*     */   }
/*     */ 
/*     */   public void setClinetName(String clinetName) {
/* 195 */     this.clinetName = clinetName;
/*     */   }
/*     */ 
/*     */   public boolean isRun() {
/* 199 */     return this.isRun;
/*     */   }
/*     */ 
/*     */   public void setRun(boolean isRun) {
/* 203 */     this.isRun = isRun;
/*     */   }
/*     */ 
/*     */   public List<Integer> getAcceptMsgId() {
/* 207 */     return this.acceptMsgId;
/*     */   }
/*     */ 
/*     */   public void setAcceptMsgId(List<Integer> acceptMsgId) {
/* 211 */     this.acceptMsgId = acceptMsgId;
/*     */   }
/*     */ 
/*     */   public List<Integer> getDistributeMsgId() {
/* 215 */     return this.distributeMsgId;
/*     */   }
/*     */ 
/*     */   public void setDistributeMsgId(List<Integer> distributeMsgId) {
/* 219 */     this.distributeMsgId = distributeMsgId;
/*     */   }
/*     */ 
/*     */   public List<String> getDistributeCars() {
/* 223 */     return this.distributeCars;
/*     */   }
/*     */ 
/*     */   public void setDistributeCars(List<String> distributeCars) {
/* 227 */     this.distributeCars = distributeCars;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.distribute.client.DistributeClient
 * JD-Core Version:    0.6.1
 */