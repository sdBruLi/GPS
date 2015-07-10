/*     */ package com.china317.emmp.jtt808Gateway.server.processor;
/*     */ 
/*     */ import com.china317.core.codec.jtt808Gateway.GatewayUnitPack;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0011;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808Praser;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0001;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0104;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0201;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0302;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0500;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0700;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0802;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0805;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8001;
/*     */ import com.china317.core.codec.jtt808_2011.util.SequenceNumProducer;
/*     */ import com.china317.emmp.jtt808Gateway.server.broadcast.SingleSessionIdCommandBroadcast;
/*     */ import com.china317.emmp.jtt808Gateway.server.transport.VehServer;
/*     */ import com.china317.emmp.jtt808Gateway.server.transport.VehSessionManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Hashtable;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ 
/*     */ public class Gateway2VehProcessor
/*     */ {
/*  33 */   private static Log log = LogFactory.getLog(Gateway2VehProcessor.class);
/*  34 */   private static Map<Long, IoSession> loginSuccessMap = new Hashtable();
/*  35 */   private static List<SingleSessionIdCommandBroadcast> broadcastList = new ArrayList();
/*     */ 
/*     */   public static boolean verifyAuth(IoSession session)
/*     */     throws Exception
/*     */   {
/*  46 */     return loginSuccessMap.containsValue(session);
/*     */   }
/*     */ 
/*     */   public static boolean loginCheck(long sessionId, UnitPackJT808 pack) throws Exception {
/*  50 */     IoSession session = VehServer.getSession(sessionId);
/*  51 */     if (session == null) {
/*  52 */       return false;
/*     */     }
/*  54 */     if (loginSuccessMap.containsValue(session)) {
/*  55 */       return true;
/*     */     }
/*  57 */     return true;
/*     */   }
/*     */ 
/*     */   public static void putAuth(long sessionId, UnitPackJT808 authPack) throws Exception {
/*  61 */     IoSession session = VehServer.getSession(sessionId);
/*  62 */     if (session != null)
/*  63 */       loginSuccessMap.put(new Long(sessionId), session);
/*     */   }
/*     */ 
/*     */   public static void removeAuth(long sessionId) throws Exception {
/*  67 */     loginSuccessMap.remove(new Long(sessionId));
/*     */   }
/*     */ 
/*     */   public static byte processTransData(GatewayUnitPack gUnit, IoSession session2) throws Exception {
/*  71 */     GatewayBody_0x0011 body0011 = (GatewayBody_0x0011)gUnit.getMsgBody();
/*  72 */     Long sessionId = Long.valueOf(Long.parseLong(body0011.getSessionid()));
/*  73 */     UnitPackJT808 pack = UnitPackJT808Praser.prasePacket(body0011.getRowBuffer());
/*     */ 
/*  75 */     sessionId = VehSessionManager.getInstance().getVehSessionId(pack.getMobileNum());
/*  76 */     log.debug("Get SessionId[" + sessionId + "] from  VehSessionManager by MobileNum[" + pack.getMobileNum() + "]...");
/*  77 */     if (sessionId != null)
/*     */     {
/*  79 */       switch (pack.getMsgID()) {
/*     */       case 33024:
/*  81 */         if (VehServer.write(sessionId.longValue(), pack, false)) {
/*  82 */           return 0;
/*     */         }
/*  84 */         return 1;
/*     */       case 32769:
/*  87 */         JT808MsgBody_0x8001 packbody = (JT808MsgBody_0x8001)pack.getMsgBody();
/*  88 */         if (packbody.getResponseMsgID() == 258) {
/*  89 */           IoSession session = VehServer.getSession(sessionId.longValue());
/*  90 */           if (session == null) {
/*  91 */             return 2;
/*     */           }
/*  93 */           if (writeCheck(session, pack)) {
/*  94 */             if (packbody.getResult() == 0) {
/*  95 */               loginSuccessMap.put(new Long(sessionId.longValue()), session);
/*     */             }
/*  97 */             return 0;
/*     */           }
/*  99 */           return 2;
/*     */         }
/*     */ 
/* 102 */         if (packbody.getResponseMsgID() == 3) {
/* 103 */           IoSession session = VehServer.getSession(sessionId.longValue());
/* 104 */           if (session == null) {
/* 105 */             return 2;
/*     */           }
/* 107 */           if (writeCheck(session, pack)) {
/* 108 */             session.close(false);
/* 109 */             return 0;
/*     */           }
/* 111 */           return 2;
/*     */         }
/*     */ 
/* 128 */         return writeCheckLogin(sessionId.longValue(), pack);
/*     */       case 34817:
/* 131 */         pack.setSequenceNum(SequenceNumProducer.getSequenceNum(String.valueOf(sessionId.longValue())));
/* 132 */         SingleSessionIdCommandBroadcast multimediaBroadcast = new SingleSessionIdCommandBroadcast(3, 90, pack, true, 
/* 133 */           VehServer.getInstance().getAcceptor());
/* 134 */         multimediaBroadcast.addSession(sessionId.longValue(), pack.getSequenceNum());
/* 135 */         multimediaBroadcast.setMessageId(body0011.getMessageId());
/* 136 */         multimediaBroadcast.setGatewaySession(session2);
/* 137 */         broadcastList.add(multimediaBroadcast);
/* 138 */         multimediaBroadcast.start();
/* 139 */         return 0;
/*     */       }
/*     */ 
/* 142 */       log.info(pack.toString());
/* 143 */       pack.setSequenceNum(SequenceNumProducer.getSequenceNum(String.valueOf(sessionId.longValue())));
/* 144 */       SingleSessionIdCommandBroadcast commonBroadcast = new SingleSessionIdCommandBroadcast(3, 90, pack, true, 
/* 145 */         VehServer.getInstance().getAcceptor());
/* 146 */       commonBroadcast.addSession(sessionId.longValue(), pack.getSequenceNum());
/* 147 */       commonBroadcast.setMessageId(body0011.getMessageId());
/* 148 */       commonBroadcast.setGatewaySession(session2);
/* 149 */       broadcastList.add(commonBroadcast);
/* 150 */       commonBroadcast.start();
/* 151 */       return 0;
/*     */     }
/*     */ 
/* 154 */     return 1;
/*     */   }
/*     */ 
/*     */   private static byte writeCheckLogin(long sessionId, UnitPackJT808 vpu)
/*     */   {
/* 159 */     if (loginSuccessMap.containsKey(new Long(sessionId))) {
/* 160 */       IoSession session = (IoSession)loginSuccessMap.get(new Long(sessionId));
/* 161 */       String smnum = (String)session.getAttribute("MOBILE_NUM");
/* 162 */       if (smnum.equals(vpu.getMobileNum())) {
/* 163 */         session.write(vpu);
/* 164 */         return 0;
/*     */       }
/* 166 */       return 2;
/*     */     }
/*     */ 
/* 169 */     return 2;
/*     */   }
/*     */ 
/*     */   private static boolean writeCheck(IoSession session, UnitPackJT808 vpu)
/*     */   {
/* 174 */     String smnum = (String)session.getAttribute("MOBILE_NUM");
/* 175 */     if (smnum.equals(vpu.getMobileNum())) {
/* 176 */       session.write(vpu);
/* 177 */       return true;
/*     */     }
/* 179 */     return false;
/*     */   }
/*     */ 
/*     */   public static void processMonitorResponse(UnitPackJT808 packJT808)
/*     */   {
/* 184 */     for (SingleSessionIdCommandBroadcast broadcast : broadcastList)
/*     */     {
/* 186 */       boolean isSuccess = true;
/* 187 */       int sequenceNum = 0;
/* 188 */       if ((packJT808.getMsgBody() instanceof JT808MsgBody_0x0001)) {
/* 189 */         JT808MsgBody_0x0001 body = (JT808MsgBody_0x0001)packJT808.getMsgBody();
/* 190 */         sequenceNum = body.getResponseSequenceNum();
/* 191 */         if (body.getResult() != 0)
/* 192 */           isSuccess = false;
/*     */       }
/* 194 */       else if ((packJT808.getMsgBody() instanceof JT808MsgBody_0x0104)) {
/* 195 */         JT808MsgBody_0x0104 body = (JT808MsgBody_0x0104)packJT808.getMsgBody();
/* 196 */         sequenceNum = body.getAckSeqnum();
/* 197 */       } else if ((packJT808.getMsgBody() instanceof JT808MsgBody_0x0201)) {
/* 198 */         JT808MsgBody_0x0201 body = (JT808MsgBody_0x0201)packJT808.getMsgBody();
/* 199 */         sequenceNum = body.getAckSeqnum();
/* 200 */       } else if ((packJT808.getMsgBody() instanceof JT808MsgBody_0x0302)) {
/* 201 */         JT808MsgBody_0x0302 body = (JT808MsgBody_0x0302)packJT808.getMsgBody();
/* 202 */         sequenceNum = body.getAckSeqNum();
/* 203 */       } else if ((packJT808.getMsgBody() instanceof JT808MsgBody_0x0500)) {
/* 204 */         JT808MsgBody_0x0500 body = (JT808MsgBody_0x0500)packJT808.getMsgBody();
/* 205 */         sequenceNum = body.getAckSeqnum();
/* 206 */       } else if ((packJT808.getMsgBody() instanceof JT808MsgBody_0x0700)) {
/* 207 */         JT808MsgBody_0x0700 body = (JT808MsgBody_0x0700)packJT808.getMsgBody();
/* 208 */         sequenceNum = body.getAckSeqNum();
/* 209 */       } else if ((packJT808.getMsgBody() instanceof JT808MsgBody_0x0802)) {
/* 210 */         JT808MsgBody_0x0802 body = (JT808MsgBody_0x0802)packJT808.getMsgBody();
/* 211 */         sequenceNum = body.getAckSeqNum();
/*     */       }
/* 213 */       else if ((packJT808.getMsgBody() instanceof JT808MsgBody_0x0805)) {
/* 214 */         JT808MsgBody_0x0805 body = (JT808MsgBody_0x0805)packJT808.getMsgBody();
/* 215 */         sequenceNum = body.getResponseSequenceNum();
/* 216 */         if (body.getResult() != 0) {
/* 217 */           isSuccess = false;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 222 */       if (broadcast.isExist(packJT808.getSessionId(), sequenceNum)) {
/* 223 */         broadcast.setSuccess(isSuccess);
/* 224 */         broadcast.process();
/* 225 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.processor.Gateway2VehProcessor
 * JD-Core Version:    0.6.1
 */