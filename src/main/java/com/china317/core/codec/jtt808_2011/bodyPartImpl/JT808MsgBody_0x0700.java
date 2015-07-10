/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0700 extends JT808MsgBody
/*    */ {
/*    */   private short ackSeqNum;
/*    */   private byte command;
/*    */   private IoBuffer dataBlock;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 18 */     this.ackSeqNum = this.bodyBuffer.getShort();
/* 19 */     this.command = this.bodyBuffer.get();
/* 20 */     this.dataBlock = this.bodyBuffer.getSlice(this.bodyBuffer.limit() - 3);
/* 21 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public short getAckSeqNum() {
/* 25 */     return this.ackSeqNum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqNum(short ackSeqNum) {
/* 29 */     this.ackSeqNum = ackSeqNum;
/*    */   }
/*    */ 
/*    */   public byte getCommand() {
/* 33 */     return this.command;
/*    */   }
/*    */ 
/*    */   public void setCommand(byte command) {
/* 37 */     this.command = command;
/*    */   }
/*    */ 
/*    */   public IoBuffer getDataBlock() {
/* 41 */     return this.dataBlock;
/*    */   }
/*    */ 
/*    */   public void setDataBlock(IoBuffer dataBlock) {
/* 45 */     this.dataBlock = dataBlock;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0700
 * JD-Core Version:    0.6.1
 */