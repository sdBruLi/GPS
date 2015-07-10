/*     */ package com.china317.emmp.jtt808Gateway.server.broadcast;
/*     */ 
/*     */ import com.china317.core.base.AbstractDataPacket;
/*     */ import com.china317.core.broadcast.AbstractBroadcast;
/*     */ import com.china317.core.codec.jtt808Gateway.GatewayUnitPack;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x8011;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.service.IoAcceptor;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ 
/*     */ public class SingleSessionIdCommandBroadcast extends AbstractBroadcast
/*     */ {
/*  20 */   private static final Log log = LogFactory.getLog(SingleSessionIdCommandBroadcast.class);
/*  21 */   private Map<Long, Integer> sequenceNums = new HashMap();
/*  22 */   private String messageId = "";
/*  23 */   private IoSession gatewaySession = null;
/*  24 */   private boolean isProcess = false;
/*  25 */   private boolean isSuccess = false;
/*     */ 
/*     */   public SingleSessionIdCommandBroadcast(int maxRetryCount, int retryPeriod, AbstractDataPacket dataPacket, boolean hasResponse, IoAcceptor accptor)
/*     */   {
/*  30 */     super(maxRetryCount, retryPeriod, dataPacket, hasResponse, accptor);
/*     */   }
/*     */ 
/*     */   public void addSession(long sessionId, int sequence) {
/*  34 */     this.sequenceNums.put(Long.valueOf(sessionId), Integer.valueOf(sequence));
/*  35 */     long[] sessionIds = { sessionId };
/*  36 */     super.addSessions(sessionIds);
/*  37 */     log.info("sessionId[" + sessionId + "] 's sequence number[" + sequence + "] send to monitor...");
/*     */   }
/*     */ 
/*     */   public boolean isExist(long sessionId, int sequence) {
/*  41 */     boolean exist = false;
/*  42 */     if ((this.sequenceNums.get(Long.valueOf(sessionId)) != null) && (((Integer)this.sequenceNums.get(Long.valueOf(sessionId))).intValue() == sequence)) {
/*  43 */       super.responseMessageReceived(sessionId);
/*  44 */       exist = true;
/*  45 */       log.info("sessionId[" + sessionId + "] 's sequence number[" + sequence + "] response from monitor...");
/*     */     }
/*  47 */     return exist;
/*     */   }
/*     */ 
/*     */   public String getMessageId() {
/*  51 */     return this.messageId;
/*     */   }
/*     */ 
/*     */   public void setMessageId(String messageId) {
/*  55 */     this.messageId = messageId;
/*     */   }
/*     */ 
/*     */   public void setGatewaySession(IoSession session2) {
/*  59 */     this.gatewaySession = session2;
/*     */   }
/*     */ 
/*     */   public void sendAckMessageId(long sessionId, byte resultAck) {
/*  63 */     int sequenceNum = 0;
/*  64 */     if (this.sequenceNums.get(Long.valueOf(sessionId)) != null) {
/*  65 */       sequenceNum = ((Integer)this.sequenceNums.get(Long.valueOf(sessionId))).intValue();
/*     */     }
/*  67 */     GatewayUnitPack receiveUnit = new GatewayUnitPack(32785);
/*  68 */     receiveUnit.setSequenceNum(0);
/*  69 */     GatewayBody_0x8011 gbody = new GatewayBody_0x8011();
/*  70 */     gbody.setMessageId(this.messageId);
/*  71 */     gbody.setSessionid(String.valueOf(sessionId));
/*  72 */     gbody.setStatus(resultAck);
/*  73 */     gbody.setSequenceNum(sequenceNum);
/*     */     try {
/*  75 */       receiveUnit.setMsgBody(gbody);
/*  76 */       this.gatewaySession.write(receiveUnit);
/*     */     } catch (Exception e) {
/*  78 */       log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void process()
/*     */   {
/*  84 */     if (!this.isProcess) {
/*  85 */       log.debug("into AbstractBroadcast process...");
/*  86 */       List<Long> sucessedSessions = new ArrayList();
/*  87 */       sucessedSessions.addAll((Collection)getSuccessedSessions().keySet());
/*  88 */       log.debug("sucessedSessions size is " + sucessedSessions.size());
/*     */       byte result;
/*  89 */       for (Long sessionId : sucessedSessions) {
/*  90 */         result = 3;
/*  91 */         if (!this.isSuccess) {
/*  92 */           result = 4;
/*     */         }
/*  94 */         sendAckMessageId(sessionId.longValue(), result);
/*  95 */         log.debug("send sucessed ack messageis from AbstractBroadcast process:" + sessionId + ":" + this.messageId + ":" + result);
/*     */       }
/*     */ 
/*  98 */       List<Long> failedSessions = new ArrayList();
/*  99 */       failedSessions.addAll((Collection)getFailedSessions().keySet());
/* 100 */       log.debug("failedSessions size is " + failedSessions.size());
/* 101 */       for (Long sessionId : failedSessions) {
/* 102 */         sendAckMessageId(sessionId.longValue(), (byte)1);
/* 103 */         log.debug("send failed ack messageis from AbstractBroadcast process:" + sessionId + ":" + this.messageId + ":" + 1);
/*     */       }
/*     */     }
/* 106 */     this.isProcess = true;
/*     */   }
/*     */ 
/*     */   public void setSuccess(boolean isSuccess) {
/* 110 */     this.isSuccess = isSuccess;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.broadcast.SingleSessionIdCommandBroadcast
 * JD-Core Version:    0.6.1
 */