/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ public class QuestionAnswer
/*    */ {
/*    */   private byte answerId;
/*    */   private String answerContent;
/*    */ 
/*    */   public QuestionAnswer()
/*    */   {
/*    */   }
/*    */ 
/*    */   public QuestionAnswer(byte answerId, String answerContent)
/*    */   {
/* 13 */     this.answerContent = answerContent;
/* 14 */     this.answerId = answerId;
/*    */   }
/*    */   public byte getAnswerId() {
/* 17 */     return this.answerId;
/*    */   }
/*    */ 
/*    */   public void setAnswerId(byte answerId) {
/* 21 */     this.answerId = answerId;
/*    */   }
/*    */ 
/*    */   public String getAnswerContent() {
/* 25 */     return this.answerContent;
/*    */   }
/*    */ 
/*    */   public void setAnswerContent(String answerContent) {
/* 29 */     this.answerContent = answerContent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.QuestionAnswer
 * JD-Core Version:    0.6.1
 */