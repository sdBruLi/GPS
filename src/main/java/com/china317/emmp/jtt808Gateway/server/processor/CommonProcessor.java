/*     */ package com.china317.emmp.jtt808Gateway.server.processor;
/*     */ 
/*     */ import com.china317.core.base.AbstractDataPacket;
/*     */ import com.china317.core.base.DataPacket;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8100;
/*     */ import com.china317.emmp.jtt808Gateway.server.common.config.Config;
/*     */ import com.china317.emmp.jtt808Gateway.server.common.config.ThreadConfig;
/*     */ import com.china317.emmp.jtt808Gateway.server.transport.VehServer;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class CommonProcessor extends JT808BaseProcessor
/*     */ {
/*  18 */   private static final Log log = LogFactory.getLog(CommonProcessor.class);
/*  19 */   private static ThreadConfig config = null;
/*     */ 
/*  21 */   public CommonProcessor(String name) { super.setName(name);
/*  22 */     config = Config.getThreadConfig(CommonProcessor.class);
/*     */   }
/*     */ 
/*     */   public void processDataPackets(List<AbstractDataPacket> list)
/*     */   {
/*  27 */     log.debug("JT808 Common Processor...");
/*  28 */     for (DataPacket pack : list)
/*  29 */       if ((pack instanceof UnitPackJT808)) {
/*  30 */         UnitPackJT808 packJT808 = (UnitPackJT808)pack;
/*     */         try {
/*  32 */           switch (packJT808.getMsgID())
/*     */           {
/*     */           case 256:
/*  35 */             break;
/*     */           case 3:
/*  38 */             break;
/*     */           case 258:
/*  40 */             if (Gateway2VehProcessor.loginCheck(packJT808.getSessionId(), packJT808)) {
/*  41 */               Gateway2VehProcessor.putAuth(packJT808.getSessionId(), packJT808);
/*     */ 
/*  43 */               log.debug("mobileNum[" + packJT808.getMobileNum() + "] send authentication");
/*     */             }
/*     */             else {
/*  46 */               log.error("authentication failed   sessionId=" + packJT808.getSessionId() + " MobileNum=" + packJT808.getMobileNum());
/*     */             }
/*  48 */             break;
/*     */           case 1:
/*  50 */             log.debug("0x0001, received...");
/*  51 */             Gateway2VehProcessor.processMonitorResponse(packJT808);
/*  52 */             break;
/*     */           case 260:
/*  54 */             log.debug("0x0104, received...");
/*  55 */             Gateway2VehProcessor.processMonitorResponse(packJT808);
/*  56 */             break;
/*     */           case 513:
/*  58 */             log.debug("0x0201, received...");
/*  59 */             Gateway2VehProcessor.processMonitorResponse(packJT808);
/*  60 */             break;
/*     */           case 770:
/*  62 */             log.debug("0x0302, received...");
/*  63 */             Gateway2VehProcessor.processMonitorResponse(packJT808);
/*     */           case 1280:
/*  65 */             log.debug("0x0500, received...");
/*  66 */             Gateway2VehProcessor.processMonitorResponse(packJT808);
/*  67 */             break;
/*     */           case 1792:
/*  69 */             log.debug("0x0700, received...");
/*  70 */             Gateway2VehProcessor.processMonitorResponse(packJT808);
/*  71 */             break;
/*     */           case 2050:
/*  73 */             log.debug("0x0802, received...");
/*  74 */             Gateway2VehProcessor.processMonitorResponse(packJT808);
/*     */           }
/*     */ 
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*  80 */           log.error("", e);
/*     */         }
/*     */ 
/*  84 */         distributePackJT808(packJT808);
/*     */       }
/*     */   }
/*     */ 
/*     */   private void distributePackJT808(UnitPackJT808 packJT808)
/*     */   {
/*     */     try
/*     */     {
/*  92 */       Veh2GatewayProcessor.putInWaitingQueue(packJT808);
/*     */     } catch (Exception e) {
/*  94 */       log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void processOverflowDataPacket(AbstractDataPacket dataPacket)
/*     */   {
/*     */   }
/*     */ 
/*     */   private static UnitPackJT808 getResponseRegisterOK(UnitPackJT808 requestPack) throws Exception
/*     */   {
/* 104 */     UnitPackJT808 pack = new UnitPackJT808(33024);
/* 105 */     pack.setMobileNum(requestPack.getMobileNum());
/* 106 */     JT808MsgBody_0x8100 body = new JT808MsgBody_0x8100();
/* 107 */     body.setResponseSequenceNum(requestPack.getSequenceNum());
/* 108 */     body.setResult((byte)0);
/* 109 */     body.setAuthCode("code:" + System.currentTimeMillis());
/* 110 */     pack.setMsgBody(body);
/* 111 */     return pack;
/*     */   }
/*     */ 
/*     */   protected boolean write(long sessionId, UnitPackJT808 returnPack) {
/* 115 */     return VehServer.write(sessionId, returnPack, false);
/*     */   }
/*     */ 
/*     */   protected boolean writeClose(long sessionId, UnitPackJT808 returnPack) {
/* 119 */     return VehServer.write(sessionId, returnPack, true);
/*     */   }
/*     */ 
/*     */   public ThreadConfig getConfig() {
/* 123 */     return config;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.processor.CommonProcessor
 * JD-Core Version:    0.6.1
 */