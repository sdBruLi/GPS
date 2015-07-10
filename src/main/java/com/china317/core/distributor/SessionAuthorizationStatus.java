/*    */ package com.china317.core.distributor;
/*    */ 
/*    */ public class SessionAuthorizationStatus
/*    */ {
/*  8 */   public static final SessionAuthorizationStatus Unauthorized_Session = new SessionAuthorizationStatus("unauthorized session");
/*  9 */   public static final SessionAuthorizationStatus Authorized_Session = new SessionAuthorizationStatus("authorized session");
/* 10 */   public static final SessionAuthorizationStatus Both_Session = new SessionAuthorizationStatus("both session");
/*    */   private String statusValue;
/*    */ 
/*    */   private SessionAuthorizationStatus(String statusValue)
/*    */   {
/* 13 */     this.statusValue = statusValue;
/*    */   }
/*    */   public String toString() {
/* 16 */     return this.statusValue;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.distributor.SessionAuthorizationStatus
 * JD-Core Version:    0.6.1
 */