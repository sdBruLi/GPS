/*     */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*     */ 
/*     */ import com.china317.core.codec.jtt808Gateway.GatewayCodecFactory;
/*     */ import com.china317.core.codec.jtt808Gateway.GatewayUnitPack;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0001;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0011;
/*     */ import com.china317.core.codec.jtt808_2011.util.DateTimeUtil;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.common.config.GatewayClientConfig;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
/*     */ import org.apache.mina.core.future.ConnectFuture;
/*     */ import org.apache.mina.core.service.IoConnector;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ import org.apache.mina.filter.codec.ProtocolCodecFilter;
/*     */ import org.apache.mina.transport.socket.nio.NioSocketConnector;
/*     */ 
/*     */ public class GReceiveClient extends Thread
/*     */ {
/*  26 */   public final byte COMMON_RESULT_OK = 0;
/*  27 */   public final byte COMMON_RESULT_FAILURE = 1;
/*  28 */   public final byte REGISTER_RESULT_OK = 0;
/*  29 */   public final byte REGISTER_RESULT_VEH_WAS_REGISTERED = 1;
/*  30 */   public final byte REGISTER_RESULT_DATABASE_NO_VEH = 2;
/*  31 */   public final byte REGISTER_RESULT_TERMINAL_WAS_REGISTERED = 3;
/*  32 */   public final byte REGISTER_RESULT_DATABASE_NO_TERMINAL = 4;
/*     */ 
/*  34 */   private Log log = LogFactory.getLog(GReceiveClient.class);
/*  35 */   private IoSession session = null;
/*  36 */   private IoConnector connector = null;
/*  37 */   private String IP = "116.228.187.106";
/*  38 */   private int port = 1582;
/*  39 */   protected GReceiveMachineDefault reciveMachine = null;
/*  40 */   private String loginCode = "code001";
/*  41 */   private int loginType = 1;
/*  42 */   private int loginVer = 1;
/*     */ 
/*  44 */   private Map<String, VehSession> mobileNum2Vehsession = new HashMap();
/*     */ 
/*  46 */   private long TIMEOUT_HEARTBEATTIME = 30000L;
/*     */   private long heartbeatTime;
/*     */   private GatewayClientConfig config;
/*     */ 
/*     */   public GReceiveClient(String IP_, int port_)
/*     */   {
/*  59 */     this.IP = IP_;
/*  60 */     this.port = port_;
/*     */   }
/*     */ 
/*     */   void setMachine(GReceiveMachineDefault gReceiveMachineDefault) {
/*  64 */     this.reciveMachine = gReceiveMachineDefault;
/*     */   }
/*     */ 
/*     */   void updMobileNum2VehSession(String mobileNum, String sessionid, int msgID) {
/*  68 */     if ((mobileNum != null) && (!"".equals(mobileNum)))
/*     */     {
/*  70 */       if (getSession(mobileNum) == null) {
/*  71 */         setSession(mobileNum, new VehSession(sessionid));
/*  72 */         this.log.debug("GReceiveClient IP[" + this.IP + "] PORT[" + this.port + "] MobileNum[" + mobileNum + "] set session id [" + sessionid + 
/*  73 */           "] to memery");
/*  74 */       } else if (!sessionid.equals(getSession(mobileNum).sessionId))
/*     */       {
/*  79 */         getSession(mobileNum).resetSessionId(sessionid);
/*  80 */         this.log.debug("GReceiveClient IP[" + this.IP + "] PORT[" + this.port + "] MobileNum[" + mobileNum + "] reset session id [" + sessionid + 
/*  81 */           "] to memery" + " msgId is " + msgID);
/*     */       } else {
/*  83 */         getSession(mobileNum).resetTime();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void init() {
/*  89 */     this.connector = new NioSocketConnector();
/*  90 */     this.connector.setConnectTimeoutMillis(30000L);
/*  91 */     this.connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new GatewayCodecFactory()));
/*  92 */     this.connector.setHandler(new GReceiveClientHandler(this));
/*     */   }
/*     */ 
/*     */   private boolean connect() {
/*     */     try {
/*  97 */       this.log.info("开始连接网关" + this.IP + ":" + this.port);
/*  98 */       init();
/*     */ 
/* 100 */       ConnectFuture future = this.connector.connect(new InetSocketAddress(this.IP, this.port));
/* 101 */       future.awaitUninterruptibly();
/* 102 */       if ((future.isDone()) && 
/* 103 */         (!future.isConnected())) {
/* 104 */         this.connector.dispose();
/* 105 */         this.log.error("未在时限内建立连接");
/* 106 */         return false;
/*     */       }
/*     */ 
/* 109 */       this.session = future.getSession();
/* 110 */       return true;
/*     */     } catch (Exception e) {
/* 112 */       e.printStackTrace();
/* 113 */       this.log.error(e.getMessage());
/* 114 */     }return false;
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*     */     while (true)
/*     */       try
/*     */       {
/* 122 */         if (this.config.isCheck()) {
/* 123 */           this.log.warn("has limit hour");
/* 124 */           int time = Integer.parseInt(DateTimeUtil.getDateTimeString(new Date(), "HHmm"));
/* 125 */           if ((time > this.config.getUnLinkStartTime()) && (time < this.config.getUnLinkEndTime()))
/* 126 */             sleep(300000L);
/*     */         }
/*     */         else
/*     */         {
/* 130 */           if (connect()) {
/* 131 */             GatewayUnitPack loginpack = getLoginPack();
/* 132 */             this.session.write(loginpack);
/* 133 */             synchronized (this) {
/* 134 */               wait();
/*     */             }
/*     */           }
/* 137 */           sleep(10000L);
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/* 141 */         this.log.error(e.getMessage());
/*     */       }
/*     */   }
/*     */ 
/*     */   void closeService()
/*     */   {
/* 147 */     clearSession();
/* 148 */     synchronized (this) {
/* 149 */       notify();
/*     */     }
/*     */   }
/*     */ 
/*     */   VehSession getSession(String authCode) {
/* 154 */     VehSession session = (VehSession)this.mobileNum2Vehsession.get(authCode);
/* 155 */     if (session == null)
/* 156 */       return null;
/* 157 */     if (session.isTimeout()) {
/* 158 */       session = (VehSession)this.mobileNum2Vehsession.remove(authCode);
/* 159 */       this.log.info("session is timeout[mobileNum:" + authCode + "] [sessionId:" + session.sessionId + "]");
/* 160 */       return null;
/*     */     }
/* 162 */     return session;
/*     */   }
/*     */ 
/*     */   void setSession(String authCode, VehSession session)
/*     */   {
/* 167 */     this.mobileNum2Vehsession.put(authCode, session);
/*     */   }
/*     */ 
/*     */   void clearSession() {
/* 171 */     this.mobileNum2Vehsession.clear();
/*     */   }
/*     */ 
/*     */   void updHeartbeatTime() {
/* 175 */     this.heartbeatTime = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   boolean isTimeoutOfHeartbeat() {
/* 179 */     boolean isTimeout = false;
/*     */ 
/* 181 */     if (System.currentTimeMillis() - this.heartbeatTime > this.TIMEOUT_HEARTBEATTIME) {
/* 182 */       isTimeout = true;
/*     */     }
/* 184 */     return isTimeout;
/*     */   }
/*     */ 
/*     */   boolean isTimeoutOfHeartbeatLongTime() {
/* 188 */     boolean isTimeout = false;
/*     */ 
/* 190 */     if (System.currentTimeMillis() - this.heartbeatTime > this.TIMEOUT_HEARTBEATTIME + 10000L) {
/* 191 */       isTimeout = true;
/*     */     }
/* 193 */     return isTimeout;
/*     */   }
/*     */ 
/*     */   private GatewayUnitPack getLoginPack() throws Exception {
/* 197 */     GatewayUnitPack pack = new GatewayUnitPack(1);
/* 198 */     GatewayBody_0x0001 body = new GatewayBody_0x0001();
/* 199 */     body.setCode(this.loginCode);
/* 200 */     body.setType(this.loginType);
/* 201 */     body.setVer(this.loginVer);
/* 202 */     pack.setMsgBody(body);
/* 203 */     pack.setSequenceNum(99);
/* 204 */     return pack;
/*     */   }
/*     */ 
/*     */   boolean write(GatewayUnitPack pack) throws Exception {
/* 208 */     if (this.connector == null)
/* 209 */       throw new Exception("connector is null");
/* 210 */     if (this.session == null)
/* 211 */       throw new Exception("session is null");
/* 212 */     if (!this.session.isConnected()) {
/* 213 */       throw new Exception("session is closed");
/*     */     }
/* 215 */     this.session.write(pack);
/* 216 */     return true;
/*     */   }
/*     */ 
/*     */   boolean isConnect() throws Exception
/*     */   {
/* 221 */     if (this.connector == null)
/* 222 */       throw new Exception("connector is null");
/* 223 */     if (this.session == null)
/* 224 */       throw new Exception("session is null");
/* 225 */     if (!this.session.isConnected()) {
/* 226 */       throw new Exception("session is closed");
/*     */     }
/* 228 */     return true;
/*     */   }
/*     */ 
/*     */   boolean writeRransVehMsg(String sessionId, int sequenceNum, byte[] rowbuff, String messageId) throws Exception
/*     */   {
/* 233 */     GatewayUnitPack pack = new GatewayUnitPack(17);
/* 234 */     GatewayBody_0x0011 body = new GatewayBody_0x0011();
/* 235 */     body.setSessionid(sessionId);
/* 236 */     body.setRowBuffer(IoBuffer.wrap(rowbuff));
/* 237 */     body.setMessageId(messageId);
/* 238 */     pack.setMsgBody(body);
/* 239 */     pack.setSequenceNum(sequenceNum);
/* 240 */     return write(pack);
/*     */   }
/*     */ 
/*     */   public String getLoginCode() {
/* 244 */     return this.loginCode;
/*     */   }
/*     */ 
/*     */   public void setLoginCode(String loginCode) {
/* 248 */     this.loginCode = loginCode;
/*     */   }
/*     */ 
/*     */   public int getLoginType() {
/* 252 */     return this.loginType;
/*     */   }
/*     */ 
/*     */   public void setLoginType(int loginType) {
/* 256 */     this.loginType = loginType;
/*     */   }
/*     */ 
/*     */   public int getLoginVer() {
/* 260 */     return this.loginVer;
/*     */   }
/*     */ 
/*     */   public void setLoginVer(int loginVer) {
/* 264 */     this.loginVer = loginVer;
/*     */   }
/*     */ 
/*     */   public String getIP() {
/* 268 */     return this.IP;
/*     */   }
/*     */ 
/*     */   public int getPort() {
/* 272 */     return this.port;
/*     */   }
/*     */ 
/*     */   public void setConfig(GatewayClientConfig config) {
/* 276 */     this.config = config;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.GReceiveClient
 * JD-Core Version:    0.6.1
 */