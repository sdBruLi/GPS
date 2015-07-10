/*     */ package com.china317.emmp.jtt808Gateway.server.processor;
/*     */ 
/*     */ import com.china317.core.codec.jtt808Gateway.DataRow0012;
/*     */ import com.china317.core.codec.jtt808Gateway.GatewayUnitPack;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0001;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0012;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;

/*     */ import java.util.Hashtable;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.TimeUnit;

/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ 
/*     */ public class Veh2GatewayProcessor extends Thread
/*     */ {
/*  23 */   private static Log log = null;
/*  24 */   private static Hashtable<IoSession, Veh2GatewayProcessor> sessionMap = new Hashtable();
/*  25 */   private BlockingQueue<UnitPackJT808> serverPackPool = new LinkedBlockingQueue(3000);
/*  26 */   private BlockingQueue<GatewayUnitPack> gatewayPackPool = new LinkedBlockingQueue(1000);
/*  27 */   private IoSession gatewaySession = null;
/*  28 */   private boolean isrun = true;
/*     */ 
/*     */   private Veh2GatewayProcessor(String name, IoSession gatewaySession_) {
/*  31 */     setName(name);
/*  32 */     log = LogFactory.getLog(Veh2GatewayProcessor.class.getName() + "-" + name);
/*  33 */     this.gatewaySession = gatewaySession_;
/*     */   }
/*     */ 
/*     */   public static void putInWaitingQueue(UnitPackJT808 pack)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  50 */       Iterator iterator = sessionMap.entrySet().iterator();
/*     */ 
/*  53 */       while (iterator.hasNext()) {
/*  54 */         Map.Entry entry = (Map.Entry)iterator.next();
/*  55 */         Veh2GatewayProcessor p = (Veh2GatewayProcessor)entry.getValue();
/*     */ 
/*  57 */         if (!p.serverPackPool.offer(pack)) {
/*  58 */           log.error("serverPackPool is pull ,now reset it");
/*  59 */           p.isrun = false;
/*  60 */           ((IoSession)entry.getKey()).close(false);
/*  61 */           iterator.remove();
/*  62 */           p = null;
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  66 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void putResponse(IoSession session, GatewayUnitPack pack) throws Exception {
/*     */     try {
/*  72 */       if (sessionMap.containsKey(session)) {
/*  73 */         Veh2GatewayProcessor mach = (Veh2GatewayProcessor)sessionMap.get(session);
/*  74 */         if (!mach.gatewayPackPool.offer(pack))
/*  75 */           log.error("gatewayPackPool is pull");
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  79 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void init()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void run() {
/*  88 */     init();
/*     */ 
/*  91 */     long sendtimestart = System.currentTimeMillis();
/*  92 */     GatewayBody_0x0012 body0012 = null;
/*  93 */     GatewayBody_0x0012 tempBody0012 = null;
/*  94 */     while (this.isrun)
/*     */     {
/*     */       try
/*     */       {
/*  98 */         int bodysize = 0;
/*     */         do {
/* 100 */           if (tempBody0012 != null) {
/* 101 */             body0012 = tempBody0012;
/* 102 */             tempBody0012 = null;
/* 103 */             break;
/*     */           }
/* 105 */           UnitPackJT808 serverPack = (UnitPackJT808)this.serverPackPool.poll(1000L, TimeUnit.MILLISECONDS);
/* 106 */           if (serverPack == null)
/*     */             break;
/* 108 */           if ((serverPack.getMsgID() == 2305) || 
/* 109 */             (serverPack.getMsgID() == 2304) || 
/* 110 */             (serverPack.getMsgID() == 1792) || 
/* 111 */             (serverPack.getMsgID() == 2049) || 
/* 112 */             (serverPack.getMsgID() == 260)) {
/* 113 */             if (body0012 == null) {
/* 114 */               body0012 = new GatewayBody_0x0012();
/* 115 */               DataRow0012 row = new DataRow0012();
/* 116 */               row.setSessionid(String.valueOf(serverPack.getSessionId()));
/* 117 */               row.setRowBuffer(serverPack.getPacketBytes());
/* 118 */               body0012.addDataRowList(row);
/* 119 */               break;
/*     */             }
/* 121 */             tempBody0012 = new GatewayBody_0x0012();
/*     */ 
/* 123 */             DataRow0012 row = new DataRow0012();
/* 124 */             row.setSessionid(String.valueOf(serverPack.getSessionId()));
/* 125 */             row.setRowBuffer(serverPack.getPacketBytes());
/* 126 */             tempBody0012.addDataRowList(row);
/* 127 */             break;
/*     */           }
/*     */ 
/* 131 */           if (body0012 == null) {
/* 132 */             body0012 = new GatewayBody_0x0012();
/*     */           }
/* 134 */           DataRow0012 row = new DataRow0012();
/* 135 */           row.setSessionid(String.valueOf(serverPack.getSessionId()));
/* 136 */           row.setRowBuffer(serverPack.getPacketBytes());
/* 137 */           body0012.addDataRowList(row);
/* 138 */           bodysize = bodysize + row.getLength() + 4 + 1;
/* 139 */         }while (bodysize <= 1000);
/*     */ 
/* 149 */         if (body0012 != null) {
/* 150 */           body0012.setRowNum(body0012.getDataRowList().size());
/* 151 */           if (body0012.getRowNum() > 0)
/* 152 */             log.debug("bodysize: " + bodysize + " rowNum: " + body0012.getRowNum());
/* 153 */           if (body0012.getRowNum() != 0)
/*     */           {
/* 163 */             GatewayUnitPack sendpack = new GatewayUnitPack(18);
/* 164 */             sendpack.setMsgBody(body0012);
/*     */ 
/* 166 */             for (int i = 0; i < 3; i++) {
/* 167 */               this.gatewaySession.write(sendpack);
/* 168 */               sendtimestart = System.currentTimeMillis();
/* 169 */               GatewayUnitPack gwPack = (GatewayUnitPack)this.gatewayPackPool.poll(10L, TimeUnit.SECONDS);
/* 170 */               if (gwPack != null)
/*     */                 break;
/*     */             }
/*     */           }
/*     */         }
/*     */         else {
/* 176 */           body0012 = null;
/*     */         }
/*     */       } catch (Exception e) { log.error("", e); }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static boolean login(IoSession session, GatewayUnitPack unit) throws Exception
/*     */   {
/* 184 */     GatewayBody_0x0001 body0001 = (GatewayBody_0x0001)unit.getMsgBody();
/* 185 */     if (sessionMap.containsKey(session)) {
/* 186 */       return true;
/*     */     }
/* 188 */     Veh2GatewayProcessor upm = new Veh2GatewayProcessor(body0001.getCode(), session);
/* 189 */     sessionMap.put(session, upm);
/* 190 */     log.debug("gateway sessionMap put a session\t: code[" + body0001.getCode() + "] session id[" + session.getId() + "]");
/* 191 */     upm.start();
/* 192 */     return true;
/*     */   }
/*     */ 
/*     */   public static void removeSession(IoSession session) throws Exception
/*     */   {
/* 197 */     Veh2GatewayProcessor um = (Veh2GatewayProcessor)sessionMap.remove(session);
/* 198 */     if (um != null) um.isrun = false; 
/*     */   }
/*     */ 
/*     */   public static boolean checkLogin(IoSession session) throws Exception {
/* 202 */     return sessionMap.containsKey(session);
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.processor.Veh2GatewayProcessor
 * JD-Core Version:    0.6.1
 */