/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8900 extends JT808MsgBody
/*    */ {
/*    */   private byte transType;
/*    */   private IoBuffer dataBlock;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 16 */     if (!isBuildBody()) {
/* 17 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 18 */       this.bodyBuffer.put(this.transType);
/* 19 */       this.bodyBuffer.put(this.dataBlock);
/* 20 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 26 */     this.transType = this.bodyBuffer.get();
/* 27 */     this.dataBlock = this.bodyBuffer.getSlice(this.bodyBuffer.limit() - 1);
/* 28 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createTransDownPack(String mobileNum, byte transType, IoBuffer dataBlock)
/*    */     throws Exception
/*    */   {
/* 41 */     UnitPackJT808 pack = new UnitPackJT808(35072);
/* 42 */     pack.setMobileNum(mobileNum);
/* 43 */     JT808MsgBody_0x8900 body = new JT808MsgBody_0x8900();
/* 44 */     body.setTransType(transType);
/* 45 */     body.setBodyBuffer(dataBlock);
/* 46 */     pack.setMsgBody(body);
/* 47 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getTransType() {
/* 51 */     return this.transType;
/*    */   }
/*    */ 
/*    */   public void setTransType(byte transType) {
/* 55 */     this.transType = transType;
/*    */   }
/*    */ 
/*    */   public IoBuffer getDataBlock() {
/* 59 */     return this.dataBlock;
/*    */   }
/*    */ 
/*    */   public void setDataBlock(IoBuffer dataBlock) {
/* 63 */     this.dataBlock = dataBlock;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8900
 * JD-Core Version:    0.6.1
 */