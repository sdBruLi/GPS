/*    */ package com.china317.core.distributor;
/*    */ 
/*    */ import com.china317.core.base.AbstractDataPacket;
/*    */ import com.china317.core.codec.jtt808_2011.util.SequenceNumProducer;
/*    */ import com.china317.core.event.SessionAuthorizedListener;
/*    */ import com.china317.core.event.SessionClosedListener;
/*    */ import com.china317.core.event.SessionOpenedListener;

/*    */ import java.util.Iterator;

/*    */ import org.apache.mina.core.service.IoHandler;
/*    */ import org.apache.mina.core.session.IdleStatus;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ import org.apache.mina.transport.socket.SocketSessionConfig;
/*    */ 
/*    */ public class DistributorHandlerAdapter extends AbstractDistributor
/*    */   implements IoHandler
/*    */ {
/*    */   private SessionManager sessionManager;
/*    */ 
/*    */   public SessionManager getSessionManager()
/*    */   {
/* 27 */     return this.sessionManager;
/*    */   }
/*    */   public DistributorHandlerAdapter() {
/* 30 */     this.sessionManager = new SessionManager(this);
/*    */   }
/*    */ 
/*    */   public void exceptionCaught(IoSession session, Throwable arg1)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void messageReceived(IoSession session, Object object)
/*    */     throws Exception
/*    */   {
/* 41 */     if ((object instanceof AbstractDataPacket)) {
/* 42 */       AbstractDataPacket dataPacket = (AbstractDataPacket)object;
/* 43 */       receiveDataPacket(dataPacket);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void messageSent(IoSession arg0, Object arg1)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void sessionClosed(IoSession session)
/*    */     throws Exception
/*    */   {
/* 55 */     SequenceNumProducer.clearSessionSeqNum(String.valueOf(session.getId()));
/* 56 */     this.sessionManager.remove(session.getId());
/* 57 */     Iterator listenerIterator = SessionClosedListenerManager.getInstance().listenerIterator();
/* 58 */     while (listenerIterator.hasNext())
/* 59 */       ((SessionClosedListener)listenerIterator.next()).sessionClosed(session);
/*    */   }
/*    */ 
/*    */   public void sessionCreated(IoSession session)
/*    */     throws Exception
/*    */   {
/* 65 */     SocketSessionConfig cfg = (SocketSessionConfig)session.getConfig();
/* 66 */     cfg.setKeepAlive(true);
/* 67 */     cfg.setSoLinger(0);
/*    */   }
/*    */ 
/*    */   public void sessionIdle(IoSession arg0, IdleStatus arg1)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void sessionOpened(IoSession session) throws Exception
/*    */   {
/* 77 */     this.sessionManager.put(session);
/*    */ 
/* 79 */     Iterator listenerIterator = SessionOpenedListenerManager.getInstance().listenerIterator();
/* 80 */     while (listenerIterator.hasNext())
/* 81 */       ((SessionOpenedListener)listenerIterator.next()).sessionOpened(session);
/*    */   }
/*    */ 
/*    */   public void sessionAuthorized(IoSession session, String authorizationId)
/*    */   {
/* 91 */     Iterator listenerIterator = SessionAuthorizedListenerManager.getInstance().listenerIterator();
/* 92 */     while (listenerIterator.hasNext())
/* 93 */       ((SessionAuthorizedListener)listenerIterator.next()).sessionAuthorized(session, authorizationId);
/*    */   }
/*    */ 
/*    */   public boolean isSessionAuthorized(long sessionId)
/*    */   {
/* 98 */     return this.sessionManager.isSessionAuthorized(sessionId);
/*    */   }
/*    */
}

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.distributor.DistributorHandlerAdapter
 * JD-Core Version:    0.6.1
 */