/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0302;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class QuestionResponseMessage extends BaseUpMessage
/*    */ {
/* 15 */   private static final Log log = LogFactory.getLog(QuestionResponseMessage.class);
/*    */   private short ackSeqNum;
/*    */   private byte answerId;
/*    */ 
/*    */   public QuestionResponseMessage()
/*    */   {
/* 20 */     setCommand("0x0302");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack) {
/* 24 */     unpackHeadPart(pack);
/*    */     try {
/* 26 */       JT808MsgBody_0x0302 body = (JT808MsgBody_0x0302)pack.getMsgBody();
/* 27 */       setAckSeqNum(body.getAckSeqNum());
/* 28 */       setAnswerId(body.getAnswerId());
/*    */     } catch (Exception e) {
/* 30 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public short getAckSeqNum() {
/* 35 */     return this.ackSeqNum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqNum(short ackSeqNum)
/*    */   {
/* 40 */     this.ackSeqNum = ackSeqNum;
/*    */   }
/*    */ 
/*    */   public byte getAnswerId() {
/* 44 */     return this.answerId;
/*    */   }
/*    */ 
/*    */   public void setAnswerId(byte answerId)
/*    */   {
/* 49 */     this.answerId = answerId;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.QuestionResponseMessage
 * JD-Core Version:    0.6.1
 */