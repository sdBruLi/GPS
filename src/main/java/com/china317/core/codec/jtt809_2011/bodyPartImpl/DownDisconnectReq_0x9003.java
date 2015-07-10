/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownDisconnectReq_0x9003 extends DataPacketBodyPart
/*    */ {
/*    */   private int verifyCode;
/*    */ 
/*    */   public int getVerifyCode()
/*    */   {
/* 13 */     return this.verifyCode;
/*    */   }
/*    */ 
/*    */   public void setVerifyCode(int verifyCode) {
/* 17 */     this.verifyCode = verifyCode;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/* 26 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 27 */     setVerifyCode(buffer.getInt());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 32 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 33 */     buffer.putInt(getVerifyCode());
/* 34 */     buffer.flip();
/* 35 */     byte[] bytes = new byte[buffer.remaining()];
/* 36 */     buffer.get(bytes);
/* 37 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 42 */     return 36867;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 46 */     return super.toString() + ",verifyCode=" + this.verifyCode;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 50 */     DownDisconnectReq_0x9003 entity = new DownDisconnectReq_0x9003();
/* 51 */     entity.setVerifyCode(1);
/*    */ 
/* 54 */     DownDisconnectReq_0x9003 entity2 = new DownDisconnectReq_0x9003();
/* 55 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.DownDisconnectReq_0x9003
 * JD-Core Version:    0.6.1
 */