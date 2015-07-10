/*    */ package com.china317.emmp.jtt808Gateway.server.transport;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8001;
/*    */ import com.china317.core.distributor.DistributorHandlerAdapter;
/*    */ import com.china317.emmp.jtt808Gateway.server.processor.Gateway2VehProcessor;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ 
/*    */ public class VehUdpHandler extends DistributorHandlerAdapter
/*    */ {
/* 15 */   private static final Log log = LogFactory.getLog(VehUdpHandler.class);
/*    */ 
/*    */   public void messageReceived(IoSession session, Object message)
/*    */     throws Exception
/*    */   {
/* 21 */     log.debug("upd veh Handler...");
/*    */ 
/* 23 */     if ((message instanceof UnitPackJT808)) {
/* 24 */       UnitPackJT808 pack = (UnitPackJT808)message;
/* 25 */       if (pack.isCRCResult()) {
/* 26 */         log.debug("received(" + session.getRemoteAddress() + ") sessionid=" + session.getId() + ", " + pack.toString(2));
/* 27 */         int msgid = pack.getMsgID();
/*    */ 
/* 29 */         switch (msgid) {
/*    */         case 256:
/* 31 */           break;
/*    */         case 3:
/* 33 */           break;
/*    */         case 258:
/* 35 */           session.setAttribute("MOBILE_NUM", pack.getMobileNum());
/* 36 */           break;
/*    */         case 512:
/* 38 */           JT808MsgBody_0x0200 position = (JT808MsgBody_0x0200)pack.getMsgBody();
/* 39 */           if (!position.isAlarm())
/*    */           {
/* 41 */             session.write(JT808MsgBody_0x8001.getCommonResponseOK(pack));
/*    */           }
/*    */ 
/* 44 */           break;
/*    */         default:
/* 46 */           if (Gateway2VehProcessor.verifyAuth(session)) {
/* 47 */             session.write(JT808MsgBody_0x8001.getCommonResponseOK(pack));
/*    */           }
/* 50 */           else if (msgid == 2049) {
/* 51 */             session.write(JT808MsgBody_0x8001.getCommonResponseOK(pack));
/* 52 */             log.info("multimedia_upload_authentication verify ok");
/*    */           } else {
/* 54 */             session.close(false);
/* 55 */             log.info("authentication verify error");
/*    */           }
/*    */           break;
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 64 */     super.messageReceived(session, message);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.VehUdpHandler
 * JD-Core Version:    0.6.1
 */