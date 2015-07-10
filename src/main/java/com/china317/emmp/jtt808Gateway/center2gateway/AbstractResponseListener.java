/*    */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*    */ 
/*    */ import com.china317.core.base.UpMessage;
/*    */ import java.util.Observable;
/*    */ import java.util.Observer;
/*    */ 
/*    */ public abstract class AbstractResponseListener
/*    */   implements Observer
/*    */ {
/*    */   public static final String RESULT_ACK_Result = "5";
/*    */ 
/*    */   public void update(Observable o, Object arg)
/*    */   {
/* 12 */     if ((o instanceof DownMessageAdapter)) {
/* 13 */       DownMessageAdapter m = (DownMessageAdapter)o;
/* 14 */       if ((arg instanceof String)) {
/* 15 */         String s = (String)arg;
/* 16 */         statusChange(m.getDownMessage(), s, null);
/*    */       } else {
/* 18 */         UpMessage result = (UpMessage)arg;
/* 19 */         statusChange(m.getDownMessage(), "5", result);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public abstract void statusChange(DownMessage paramDownMessage, String paramString, UpMessage paramUpMessage);
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.AbstractResponseListener
 * JD-Core Version:    0.6.1
 */