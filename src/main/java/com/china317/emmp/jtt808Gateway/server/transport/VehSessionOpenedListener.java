/*    */ package com.china317.emmp.jtt808Gateway.server.transport;
/*    */ 
/*    */ import com.china317.core.event.SessionOpenedListener;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ 
/*    */ public class VehSessionOpenedListener
/*    */   implements SessionOpenedListener
/*    */ {
/* 10 */   private static final Log log = LogFactory.getLog(VehSessionOpenedListener.class);
/*    */ 
/*    */   public VehSessionOpenedListener(String name)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void sessionOpened(IoSession session)
/*    */   {
/* 23 */     log.debug("VehSession Opened Listener...");
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.transport.VehSessionOpenedListener
 * JD-Core Version:    0.6.1
 */