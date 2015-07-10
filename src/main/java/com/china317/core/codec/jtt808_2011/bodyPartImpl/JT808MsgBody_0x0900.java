/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0900 extends JT808MsgBody
/*    */ {
/*    */   private byte transType;
/*    */   private IoBuffer dataBlock;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 14 */     if (!isBuildBody()) {
/* 15 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 16 */       this.bodyBuffer.put(this.transType);
/* 17 */       this.bodyBuffer.put(this.dataBlock);
/* 18 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 24 */     this.transType = this.bodyBuffer.get();
/* 25 */     this.dataBlock = this.bodyBuffer.getSlice(this.bodyBuffer.limit() - 1);
/* 26 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public byte getTransType() {
/* 30 */     return this.transType;
/*    */   }
/*    */ 
/*    */   public void setTransType(byte transType) {
/* 34 */     this.transType = transType;
/*    */   }
/*    */ 
/*    */   public IoBuffer getDataBlock() {
/* 38 */     return this.dataBlock;
/*    */   }
/*    */ 
/*    */   public void setDataBlock(IoBuffer dataBlock) {
/* 42 */     this.dataBlock = dataBlock;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0900
 * JD-Core Version:    0.6.1
 */