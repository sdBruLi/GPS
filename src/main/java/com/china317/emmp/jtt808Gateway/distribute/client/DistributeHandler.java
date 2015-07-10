/*    */ package com.china317.emmp.jtt808Gateway.distribute.client;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.emmp.jtt808Gateway.server.transport.VehServer;
/*    */ import com.china317.emmp.jtt808Gateway.server.transport.VehSessionManager;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.service.IoHandler;
/*    */ import org.apache.mina.core.session.IdleStatus;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ 
/*    */ public class DistributeHandler
/*    */   implements IoHandler
/*    */ {
/* 19 */   private static final Log log = LogFactory.getLog(DistributeHandler.class);
/*    */   private DistributeClient client;
/*    */ 
/*    */   public DistributeClient getClient()
/*    */   {
/* 23 */     return this.client;
/*    */   }
/*    */ 
/*    */   public void setClient(DistributeClient client) {
/* 27 */     this.client = client;
/*    */   }
/*    */ 
/*    */   public void exceptionCaught(IoSession session, Throwable arg1)
/*    */     throws Exception
/*    */   {
/* 33 */     log.error(arg1.toString(), arg1);
/* 34 */     this.client.rebuildSession();
/*    */   }
/*    */ 
/*    */   public void messageReceived(IoSession session, Object message) throws Exception
/*    */   {
/* 39 */     if ((message instanceof UnitPackJT808))
/*    */     {
/* 41 */       UnitPackJT808 msg = (UnitPackJT808)message;
/* 42 */       if (this.client.getAcceptMsgId().contains(Integer.valueOf(msg.getMsgID()))) {
/* 43 */         String mobileNum = msg.getMobileNum();
/* 44 */         Long sessionId = VehSessionManager.getInstance().getVehSessionId(mobileNum);
/* 45 */         VehServer.write(sessionId.longValue(), msg, false);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void messageSent(IoSession session, Object arg1)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void sessionClosed(IoSession session) throws Exception
/*    */   {
/* 57 */     log.info(this.client.getClinetName() + " is closed,try rebulid");
/* 58 */     this.client.rebuildSession();
/*    */   }
/*    */ 
/*    */   public void sessionCreated(IoSession session) throws Exception
/*    */   {
/* 63 */     log.info("connected " + session.getRemoteAddress());
/*    */   }
/*    */ 
/*    */   public void sessionIdle(IoSession session, IdleStatus arg1)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void sessionOpened(IoSession session)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.distribute.client.DistributeHandler
 * JD-Core Version:    0.6.1
 */