/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.DownMessage;
/*    */ import java.util.Date;
/*    */ 
/*    */ public abstract class BaseDownMessage
/*    */   implements DownMessage
/*    */ {
/*    */   public static final byte RESULT_OK = 0;
/*    */   public static final byte RESULT_FAILURE = 1;
/*    */   public static final byte RESULT_OFFLINE = 2;
/*    */   public static final byte RESULT_ACK_OK = 3;
/*    */   public static final byte RESULT_ACK_FAILED = 4;
/*    */   public static final byte RESULT_ACK_RESULT = 5;
/*    */   public static final byte RESULT_ACK_TIMEOUT = 6;
/*    */   public static final byte RESULT_RST_TIMEOUT = 7;
/*    */   private String command;
/*    */   private String mobileNum;
/*    */   private String messageKey;
/*    */   private Date createTime;
/*    */ 
/*    */   public BaseDownMessage()
/*    */   {
/* 30 */     this.createTime = new Date(System.currentTimeMillis());
/*    */   }
/*    */ 
/*    */   public String getUniqueIndex() {
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */   public String getMessageKey()
/*    */   {
/* 39 */     return this.messageKey;
/*    */   }
/*    */ 
/*    */   public void setMessageKey(String messageKey) {
/* 43 */     this.messageKey = messageKey;
/*    */   }
/*    */ 
/*    */   public String getCommand() {
/* 47 */     return this.command;
/*    */   }
/*    */ 
/*    */   public void setCommand(String command) {
/* 51 */     this.command = command;
/*    */   }
/*    */ 
/*    */   public String getMobileNum() {
/* 55 */     return this.mobileNum;
/*    */   }
/*    */ 
/*    */   public void setMobileNum(String mobileNum) {
/* 59 */     this.mobileNum = mobileNum;
/*    */   }
/*    */   public Date getCreateTime() {
/* 62 */     return this.createTime;
/*    */   }
/*    */ 
/*    */   public void setCreateTime(Date createTime) {
/* 66 */     this.createTime = createTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.BaseDownMessage
 * JD-Core Version:    0.6.1
 */