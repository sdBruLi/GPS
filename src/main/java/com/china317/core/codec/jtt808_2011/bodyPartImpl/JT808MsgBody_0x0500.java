/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0500 extends JT808MsgBody
/*    */ {
/*    */   private short ackSeqnum;
/*    */   private JT808MsgBody_0x0200 postion;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 15 */     this.ackSeqnum = this.bodyBuffer.getShort();
/* 16 */     this.postion = new JT808MsgBody_0x0200();
/* 17 */     this.postion.setBodyBuffer(this.bodyBuffer.getSlice(this.bodyBuffer.limit() - 2));
/* 18 */     this.postion.praseBody();
/* 19 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public short getAckSeqnum() {
/* 23 */     return this.ackSeqnum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqnum(short ackSeqnum) {
/* 27 */     this.ackSeqnum = ackSeqnum;
/*    */   }
/*    */ 
/*    */   public JT808MsgBody_0x0200 getPostion() {
/* 31 */     return this.postion;
/*    */   }
/*    */ 
/*    */   public void setPostion(JT808MsgBody_0x0200 postion) {
/* 35 */     this.postion = postion;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0500
 * JD-Core Version:    0.6.1
 */