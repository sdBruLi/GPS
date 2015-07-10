/*     */ package com.china317.emmp.jtt808Gateway.server.transport;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0201;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0704;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8001;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8100;
/*     */ import com.china317.core.distributor.DistributorHandlerAdapter;
/*     */ import com.china317.emmp.jtt808Gateway.Constants;
/*     */ import com.china317.emmp.jtt808Gateway.server.Container.DistributeClientContainer;
/*     */ import com.china317.emmp.jtt808Gateway.server.processor.Gateway2VehProcessor;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ 
/*     */ public class VehHandler extends DistributorHandlerAdapter
/*     */ {
/*  20 */   private static final Log log = LogFactory.getLog(VehHandler.class);
/*     */ 
/*     */   public void sessionOpened(IoSession session)
/*     */     throws Exception
/*     */   {
/*  25 */     log.info("open session id:" + session.getId() + "," + session.getRemoteAddress().toString());
/*  26 */     SessionTimeoutManager.getInstance().putSession(session);
/*  27 */     super.sessionOpened(session);
/*     */   }
/*     */ 
/*     */   public void exceptionCaught(IoSession session, Throwable arg1)
/*     */     throws Exception
/*     */   {
/*  34 */     super.exceptionCaught(session, arg1);
/*     */ 
/*  37 */     Gateway2VehProcessor.removeAuth(session.getId());
/*     */   }
/*     */ 
/*     */   public void messageReceived(IoSession session, Object message)
/*     */     throws Exception
/*     */   {
/*  43 */     log.debug("veh Handler...");
/*  44 */     if ((message instanceof UnitPackJT808)) {
/*  45 */       UnitPackJT808 pack = (UnitPackJT808)message;
/*  46 */       SessionTimeoutManager.getInstance().updSessionLastTime(session, 
/*  47 */         pack.getMobileNum());
/*  48 */       if (pack.isCRCResult())
/*     */       {
/*  50 */         DistributeClientContainer.offerData(pack);
/*     */ 
/*  52 */         log.debug("received(" + session.getRemoteAddress() + 
/*  53 */           ") sessionid=" + session.getId() + ", " + 
/*  54 */           pack.toString(2));
/*  55 */         int msgid = pack.getMsgID();
/*     */ 
/*  57 */         switch (msgid)
/*     */         {
/*     */         case 256:
/*  60 */           if (!Constants.NEED_AUTHENTICATION) {
/*  61 */             session.write(
/*  62 */               JT808MsgBody_0x8100.createRegisterResponsePack(
/*  63 */               pack.getMobileNum(), (byte)0, 
/*  64 */               pack.getSequenceNum(), 
/*  65 */               "123456789001"));
/*     */           }
/*  67 */           break;
/*     */         case 3:
/*  69 */           session.write(
/*  70 */             JT808MsgBody_0x8001.getCommonResponseOK(pack));
/*  71 */           break;
/*     */         case 258:
/*  74 */           session.setAttribute("MOBILE_NUM", pack.getMobileNum());
/*  75 */           if (!Constants.NEED_AUTHENTICATION)
/*  76 */             session.write(
/*  77 */               JT808MsgBody_0x8001.getCommonResponseOK(pack));
/*  78 */           break;
/*     */         case 512:
/*  82 */           JT808MsgBody_0x0200 position = (JT808MsgBody_0x0200)pack
/*  83 */             .getMsgBody();
/*  84 */           if (position.isAlarm()) {
/*  85 */             log.debug(pack.getMobileNum() + " position.isAlarm()" + Integer.toBinaryString(position.getAlertSign()));
/*     */           }
/*  87 */           session.write(
/*  88 */             JT808MsgBody_0x8001.getCommonResponseOK(pack));
/*     */ 
/*  90 */           break;
/*     */         case 1796:
/*  92 */           JT808MsgBody_0x0704 bp = (JT808MsgBody_0x0704)pack
/*  93 */             .getMsgBody();
/*  94 */           session.write(
/*  95 */             JT808MsgBody_0x8001.getCommonResponseOK(pack));
/*     */ 
/*  97 */           break;
/*     */         case 513:
/* 100 */           JT808MsgBody_0x0201 package201 = (JT808MsgBody_0x0201)pack
/* 101 */             .getMsgBody();
/* 102 */           package201.getPostion().isAlarm();
/*     */ 
/* 104 */           session.write(
/* 105 */             JT808MsgBody_0x8001.getCommonResponseOK(pack));
/*     */ 
/* 107 */           break;
/*     */         default:
/* 111 */           if (!Constants.NEED_AUTHENTICATION) {
/* 112 */             session.write(
/* 113 */               JT808MsgBody_0x8001.getCommonResponseOK(pack));
/*     */           }
/* 117 */           else if (Gateway2VehProcessor.verifyAuth(session)) {
/* 118 */             session.write(
/* 119 */               JT808MsgBody_0x8001.getCommonResponseOK(pack));
/*     */           }
/* 122 */           else if (msgid == 2049) {
/* 123 */             session.write(
/* 124 */               JT808MsgBody_0x8001.getCommonResponseOK(pack));
/* 125 */             log
/* 126 */               .info("multimedia_upload_authentication verify ok");
/*     */           } else {
/* 128 */             session.close(false);
/* 129 */             log.info("authentication verify error");
/*     */           }
/*     */ 
/*     */           break;
/*     */         }
/*     */ 
/* 136 */         VehSessionManager.getInstance().updVehSessionId(
/* 137 */           pack.getMobileNum(), session.getId());
/*     */       }
/*     */       else
/*     */       {
/* 145 */         log.debug("CRC is error , session[" + session.getId() + 
/* 146 */           "], datas :" + pack);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 151 */     super.messageReceived(session, message);
/*     */   }
/*     */ 
/*     */   public void sessionClosed(IoSession session) throws Exception
/*     */   {
/* 156 */     Gateway2VehProcessor.removeAuth(session.getId());
/*     */ 
/* 158 */     super.sessionClosed(session);
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.VehHandler
 * JD-Core Version:    0.6.1
 */