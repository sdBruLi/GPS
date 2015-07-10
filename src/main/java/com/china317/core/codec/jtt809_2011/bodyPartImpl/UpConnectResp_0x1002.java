/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpConnectResp_0x1002 extends DataPacketBodyPart
/*    */ {
/*    */   private byte result;
/*    */   private int verifyCode;
/*    */ 
/*    */   public byte getResult()
/*    */   {
/* 14 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 18 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public int getVerifyCode() {
/* 22 */     return this.verifyCode;
/*    */   }
/*    */ 
/*    */   public void setVerifyCode(int verifyCode) {
/* 26 */     this.verifyCode = verifyCode;
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception
/*    */   {
/* 31 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 32 */     buffer.put(getResult());
/* 33 */     buffer.putInt(getVerifyCode());
/* 34 */     buffer.flip();
/* 35 */     byte[] bytes = new byte[buffer.remaining()];
/* 36 */     buffer.get(bytes);
/* 37 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 43 */     return 4098;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 48 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 49 */     setResult(buffer.get());
/* 50 */     setVerifyCode(buffer.getInt());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.UpConnectResp_0x1002
 * JD-Core Version:    0.6.1
 */