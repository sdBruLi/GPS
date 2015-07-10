/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import java.util.List;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8302 extends JT808MsgBody
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
/*     */   private List<JT808MsgBody_0x8302_AnswerItem> answerItems;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  29 */     if (!isBuildBody()) {
/*  30 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/*  31 */       this.bodyBuffer.put(this.sign);
/*  32 */       this.bodyBuffer.put(this.problemContentLen);
/*  33 */       if ((this.problemContentLen > 0) && (this.problem != null) && (this.problem.length() > 0)) {
/*  34 */         this.bodyBuffer.put(this.problem.getBytes("GBK"));
/*     */       }
/*  36 */       if (this.answerItems != null) {
/*  37 */         for (JT808MsgBody_0x8302_AnswerItem item : this.answerItems) {
/*  38 */           item.bulidBody();
/*  39 */           this.bodyBuffer.put(item.getBodyBuffer());
/*     */         }
/*     */       }
/*     */ 
/*  43 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public static UnitPackJT808 createQuestionPack(String mobileNum, String problem, byte msgType, byte tts, byte advPanel, List<JT808MsgBody_0x8302_AnswerItem> answerItems)
/*     */     throws Exception
/*     */   {
/*  66 */     UnitPackJT808 pack = new UnitPackJT808(33538);
/*  67 */     pack.setMobileNum(mobileNum);
/*  68 */     JT808MsgBody_0x8302 body = new JT808MsgBody_0x8302();
/*  69 */     body.setSign(getSign(msgType, tts, advPanel));
/*  70 */     body.setProblemContentLen((byte)problem.getBytes("GBK").length);
/*  71 */     body.setProblem(problem);
/*  72 */     body.setAnswerItems(answerItems);
/*  73 */     pack.setMsgBody(body);
/*  74 */     return pack;
/*     */   }
/*     */ 
/*     */   private static byte getSign(byte msgType, byte tts, byte advPanel) {
/*  78 */     byte sign = 0;
/*  79 */     sign = (byte)(msgType | tts << 3 | advPanel << 4);
/*  80 */     return sign;
/*     */   }
/*     */ 
/*     */   public byte getSign() {
/*  84 */     return this.sign;
/*     */   }
/*     */ 
/*     */   public void setSign(byte sign) {
/*  88 */     this.sign = sign;
/*     */   }
/*     */ 
/*     */   public byte getProblemContentLen() {
/*  92 */     return this.problemContentLen;
/*     */   }
/*     */ 
/*     */   public void setProblemContentLen(byte problemContentLen) {
/*  96 */     this.problemContentLen = problemContentLen;
/*     */   }
/*     */ 
/*     */   public String getProblem() {
/* 100 */     return this.problem;
/*     */   }
/*     */ 
/*     */   public void setProblem(String problem) {
/* 104 */     this.problem = problem;
/*     */   }
/*     */ 
/*     */   public List<JT808MsgBody_0x8302_AnswerItem> getAnswerItems() {
/* 108 */     return this.answerItems;
/*     */   }
/*     */ 
/*     */   public void setAnswerItems(List<JT808MsgBody_0x8302_AnswerItem> answerItems) {
/* 112 */     this.answerItems = answerItems;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8302
 * JD-Core Version:    0.6.1
 */