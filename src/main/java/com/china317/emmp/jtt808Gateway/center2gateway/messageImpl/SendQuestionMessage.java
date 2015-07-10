/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8302;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8302_AnswerItem;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SendQuestionMessage extends BaseDownMessage
/*     */ {
/*     */   public static final byte MSG_TYPE_URGENT = 1;
/*     */   public static final byte MSG_TYPE_COMMON = 0;
/*     */   public static final byte TTS_ON = 1;
/*     */   public static final byte TTS_OFF = 0;
/*     */   public static final byte ADV_PANEL_ON = 1;
/*     */   public static final byte ADV_PANEL_OFF = 0;
/*     */   private byte sign;
/*     */   private byte problemContentLen;
/*     */   private String problem;
/*     */   private List<QuestionAnswer> answerItems;
/*     */ 
/*     */   public SendQuestionMessage(String mobileNum, String messageKey, String problem, byte msgType, byte tts, byte advPanel, List<QuestionAnswer> answerItems)
/*     */   {
/*  48 */     setMobileNum(mobileNum);
/*  49 */     setMessageKey(messageKey);
/*  50 */     setProblem(problem);
/*  51 */     setSign(getSign(msgType, tts, advPanel));
/*  52 */     setAnswerItems(answerItems);
/*  53 */     setCommand("0x8302");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception {
/*  57 */     UnitPackJT808 pack = new UnitPackJT808(33538);
/*  58 */     pack.setMobileNum(getMobileNum());
/*  59 */     JT808MsgBody_0x8302 body = new JT808MsgBody_0x8302();
/*  60 */     body.setSign(getSign());
/*  61 */     body.setProblemContentLen((byte)getProblem().getBytes("GBK").length);
/*  62 */     body.setProblem(getProblem());
/*  63 */     List answers = null;
/*  64 */     if (this.answerItems != null) {
/*  65 */       for (QuestionAnswer a : this.answerItems) {
/*  66 */         if (answers == null) {
/*  67 */           answers = new ArrayList();
/*     */         }
/*  69 */         JT808MsgBody_0x8302_AnswerItem i = new JT808MsgBody_0x8302_AnswerItem();
/*  70 */         i.setAnswerContent(a.getAnswerContent());
/*  71 */         i.setAnswerContentLen((short)a.getAnswerContent().getBytes("GBK").length);
/*  72 */         i.setAnswerId(a.getAnswerId());
/*  73 */         answers.add(i);
/*     */       }
/*     */     }
/*  76 */     body.setAnswerItems(answers);
/*  77 */     pack.setMsgBody(body);
/*  78 */     return pack;
/*     */   }
/*     */ 
/*     */   private static byte getSign(byte msgType, byte tts, byte advPanel)
/*     */   {
/*  83 */     byte sign = 0;
/*  84 */     sign = (byte)(msgType | tts << 3 | advPanel << 4);
/*  85 */     return sign;
/*     */   }
/*     */ 
/*     */   public byte getSign() {
/*  89 */     return this.sign;
/*     */   }
/*     */ 
/*     */   public void setSign(byte sign)
/*     */   {
/*  94 */     this.sign = sign;
/*     */   }
/*     */ 
/*     */   public byte getProblemContentLen() {
/*  98 */     return this.problemContentLen;
/*     */   }
/*     */ 
/*     */   public void setProblemContentLen(byte problemContentLen)
/*     */   {
/* 103 */     this.problemContentLen = problemContentLen;
/*     */   }
/*     */ 
/*     */   public String getProblem() {
/* 107 */     return this.problem;
/*     */   }
/*     */ 
/*     */   public void setProblem(String problem)
/*     */   {
/* 112 */     this.problem = problem;
/*     */   }
/*     */ 
/*     */   public List<QuestionAnswer> getAnswerItems() {
/* 116 */     return this.answerItems;
/*     */   }
/*     */ 
/*     */   public void setAnswerItems(List<QuestionAnswer> answerItems)
/*     */   {
/* 121 */     this.answerItems = answerItems;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SendQuestionMessage
 * JD-Core Version:    0.6.1
 */