/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0302 extends JT808MsgBody
/*    */ {
/*    */   private short ackSeqNum;
/*    */   private byte answerId;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 15 */     this.ackSeqNum = this.bodyBuffer.getShort();
/* 16 */     this.answerId = this.bodyBuffer.get();
/* 17 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public short getAckSeqNum() {
/* 21 */     return this.ackSeqNum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqNum(short ackSeqNum) {
/* 25 */     this.ackSeqNum = ackSeqNum;
/*    */   }
/*    */ 
/*    */   public byte getAnswerId() {
/* 29 */     return this.answerId;
/*    */   }
/*    */ 
/*    */   public void setAnswerId(byte answerId) {
/* 33 */     this.answerId = answerId;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0302
 * JD-Core Version:    0.6.1
 */