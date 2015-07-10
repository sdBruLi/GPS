/*    */ package com.china317.emmp.jtt808Gateway.server.transport;
/*    */ 
/*    */ import com.china317.core.event.SessionClosedListener;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ 
/*    */ public class VehSessionClosedListener
/*    */   implements SessionClosedListener
/*    */ {
/* 10 */   private static final Log log = LogFactory.getLog(VehSessionClosedListener.class);
/*    */ 
/*    */   public VehSessionClosedListener(String name)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void sessionClosed(IoSession session)
/*    */   {
/* 24 */     log.debug("VehSession Closed Listener...");
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.VehSessionClosedListener
 * JD-Core Version:    0.6.1
 */