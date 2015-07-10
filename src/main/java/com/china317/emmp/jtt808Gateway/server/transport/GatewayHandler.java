/*    */ package com.china317.emmp.jtt808Gateway.server.transport;
/*    */ 
/*    */ import com.china317.core.codec.jtt808Gateway.GatewayUnitPack;
/*    */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0001;
/*    */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0011;
/*    */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x8011;
/*    */ import com.china317.emmp.jtt808Gateway.server.processor.Gateway2VehProcessor;
/*    */ import com.china317.emmp.jtt808Gateway.server.processor.Veh2GatewayProcessor;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.service.IoHandlerAdapter;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ 
/*    */ public class GatewayHandler extends IoHandlerAdapter
/*    */ {
/* 17 */   private static final Log log = LogFactory.getLog(GatewayHandler.class);
/*    */ 
/*    */   public void sessionOpened(IoSession session) throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void messageReceived(IoSession session, Object message) throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 27 */       if ((message instanceof GatewayUnitPack)) {
/* 28 */         GatewayUnitPack unit = (GatewayUnitPack)message;
/*    */ 
/* 30 */         if (unit.getCMD() == 1) {
/* 31 */           GatewayBody_0x0001 body0001 = (GatewayBody_0x0001)unit.getMsgBody();
/* 32 */           if (!Veh2GatewayProcessor.login(session, unit))
/*    */           {
/* 34 */             session.close(false);
/*    */           }
/*    */         } else {
/* 37 */           if (!Veh2GatewayProcessor.checkLogin(session)) {
/* 38 */             session.close(false);
/*    */           }
/* 40 */           switch (unit.getCMD()) {
/*    */           case 2:
/* 42 */             GatewayUnitPack heartRes = new GatewayUnitPack(32770);
/* 43 */             heartRes.setSequenceNum(unit.getSequenceNum());
/* 44 */             session.write(heartRes);
/* 45 */             break;
/*    */           case 17:
/* 47 */             log.debug("received :" + unit.toString());
/* 48 */             int status = Gateway2VehProcessor.processTransData(unit, session);
/* 49 */             GatewayUnitPack receiveUnit = new GatewayUnitPack(32785);
/* 50 */             receiveUnit.setSequenceNum(unit.getSequenceNum());
/* 51 */             GatewayBody_0x0011 body0011 = (GatewayBody_0x0011)unit.getMsgBody();
/* 52 */             GatewayBody_0x8011 gbody = new GatewayBody_0x8011();
/* 53 */             gbody.setSessionid(body0011.getSessionid());
/* 54 */             gbody.setStatus(status);
/* 55 */             gbody.setMessageId(body0011.getMessageId());
/* 56 */             gbody.setSequenceNum(0);
/* 57 */             receiveUnit.setMsgBody(gbody);
/* 58 */             session.write(receiveUnit);
/* 59 */             break;
/*    */           case 32786:
/* 61 */             Veh2GatewayProcessor.putResponse(session, unit);
/*    */           }
/*    */         }
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 69 */       log.error(e.toString(), e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void exceptionCaught(IoSession session, Throwable cause) throws Exception
/*    */   {
/*    */     try {
/* 76 */       log.error("exceptionCaught " + cause.getMessage());
/* 77 */       Veh2GatewayProcessor.removeSession(session);
/* 78 */       session.close(false);
/*    */     } catch (Exception e) {
/* 80 */       log.error(e.toString(), e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void sessionClosed(IoSession session) throws Exception
/*    */   {
/*    */     try {
/* 87 */       Veh2GatewayProcessor.removeSession(session);
/*    */     } catch (Exception e) {
/* 89 */       log.error(e.toString(), e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.GatewayHandler
 * JD-Core Version:    0.6.1
 */