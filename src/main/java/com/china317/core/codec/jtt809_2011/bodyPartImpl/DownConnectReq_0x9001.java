/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownConnectReq_0x9001 extends DataPacketBodyPart
/*    */ {
/*    */   private int verifyCode;
/*    */ 
/*    */   public int getVerifyCode()
/*    */   {
/* 14 */     return this.verifyCode;
/*    */   }
/*    */ 
/*    */   public void setVerifyCode(int verifyCode) {
/* 18 */     this.verifyCode = verifyCode;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/* 27 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 28 */     setVerifyCode(buffer.getInt());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 33 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 34 */     buffer.putInt(getVerifyCode());
/* 35 */     buffer.flip();
/* 36 */     byte[] bytes = new byte[buffer.remaining()];
/* 37 */     buffer.get(bytes);
/* 38 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 43 */     return 36865;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 47 */     return super.toString() + ",verifyCode=" + this.verifyCode;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 51 */     DownConnectReq_0x9001 entity = new DownConnectReq_0x9001();
/* 52 */     entity.setVerifyCode(1);
/*    */ 
/* 55 */     DownConnectReq_0x9001 entity2 = new DownConnectReq_0x9001();
/* 56 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.DownConnectReq_0x9001
 * JD-Core Version:    0.6.1
 */