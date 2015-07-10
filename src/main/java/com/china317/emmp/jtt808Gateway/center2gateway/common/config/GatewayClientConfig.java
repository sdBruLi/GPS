/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.common.config;
/*    */ 
/*    */ public class GatewayClientConfig
/*    */ {
/*    */   private boolean disable;
/*    */   private String name;
/*    */   private String ip;
/*    */   private int port;
/*  8 */   private boolean check = false;
/*  9 */   private int unLinkStartTime = 0;
/* 10 */   private int unLinkEndTime = 0;
/*    */ 
/*    */   public boolean isDisable() {
/* 13 */     return this.disable;
/*    */   }
/*    */ 
/*    */   public void setDisable(boolean disable) {
/* 17 */     this.disable = disable;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 21 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 25 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getIp() {
/* 29 */     return this.ip;
/*    */   }
/*    */ 
/*    */   public void setIp(String ip) {
/* 33 */     this.ip = ip;
/*    */   }
/*    */ 
/*    */   public int getPort() {
/* 37 */     return this.port;
/*    */   }
/*    */ 
/*    */   public void setPort(int port) {
/* 41 */     this.port = port;
/*    */   }
/*    */ 
/*    */   public boolean isCheck() {
/* 45 */     return this.check;
/*    */   }
/*    */ 
/*    */   public void setCheck(boolean check) {
/* 49 */     this.check = check;
/*    */   }
/*    */ 
/*    */   public int getUnLinkStartTime() {
/* 53 */     return this.unLinkStartTime;
/*    */   }
/*    */ 
/*    */   public void setUnLinkStartTime(int unLinkStartTime) {
/* 57 */     this.unLinkStartTime = unLinkStartTime;
/*    */   }
/*    */ 
/*    */   public int getUnLinkEndTime() {
/* 61 */     return this.unLinkEndTime;
/*    */   }
/*    */ 
/*    */   public void setUnLinkEndTime(int unLinkEndTime) {
/* 65 */     if (unLinkEndTime < this.unLinkStartTime) {
/* 66 */       unLinkEndTime = this.unLinkStartTime + 100;
/*    */     }
/* 68 */     this.unLinkEndTime = unLinkEndTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.common.config.GatewayClientConfig
 * JD-Core Version:    0.6.1
 */