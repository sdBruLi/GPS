/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.common.config;
/*    */ 
/*    */ public class ProcessorConfig
/*    */ {
/*    */   private boolean disable;
/*    */   private String processorClass;
/*    */   private String processorName;
/*    */   private String sessionAuthorizationStatus;
/*    */   private String acceptCommands;
/*    */   private String parameters;
/*    */ 
/*    */   public boolean isDisable()
/*    */   {
/* 12 */     return this.disable;
/*    */   }
/*    */   public void setDisable(boolean disable) {
/* 15 */     this.disable = disable;
/*    */   }
/*    */   public String getProcessorClass() {
/* 18 */     return this.processorClass;
/*    */   }
/*    */   public void setProcessorClass(String processorClass) {
/* 21 */     this.processorClass = processorClass;
/*    */   }
/*    */   public String getProcessorName() {
/* 24 */     return this.processorName;
/*    */   }
/*    */   public void setProcessorName(String processorName) {
/* 27 */     this.processorName = processorName;
/*    */   }
/*    */   public String getSessionAuthorizationStatus() {
/* 30 */     return this.sessionAuthorizationStatus;
/*    */   }
/*    */   public void setSessionAuthorizationStatus(String sessionAuthorizationStatus) {
/* 33 */     this.sessionAuthorizationStatus = sessionAuthorizationStatus;
/*    */   }
/*    */ 
/*    */   public void setAcceptCommands(String acceptCommands)
/*    */   {
/* 39 */     this.acceptCommands = acceptCommands;
/*    */   }
/*    */ 
/*    */   public String[] getAcceptCommands() {
/* 43 */     if (!"".equals(this.acceptCommands)) {
/* 44 */       String[] tempLines = this.acceptCommands.split(",");
/* 45 */       for (int i = 0; i < tempLines.length; i++) {
/* 46 */         tempLines[i] = tempLines[i].trim().toLowerCase();
/*    */       }
/* 48 */       return tempLines;
/*    */     }
/* 50 */     return null;
/*    */   }
/*    */   public String getParameters() {
/* 53 */     return this.parameters;
/*    */   }
/*    */   public void setParameters(String parameters) {
/* 56 */     this.parameters = parameters;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.common.config.ProcessorConfig
 * JD-Core Version:    0.6.1
 */