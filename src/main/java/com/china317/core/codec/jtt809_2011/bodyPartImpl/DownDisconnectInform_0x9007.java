/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownDisconnectInform_0x9007 extends DataPacketBodyPart
/*    */ {
/*    */   private byte errorCode;
/*    */ 
/*    */   public byte getErrorCode()
/*    */   {
/* 14 */     return this.errorCode;
/*    */   }
/*    */ 
/*    */   public void setErrorCode(byte errorCode) {
/* 18 */     this.errorCode = errorCode;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/* 27 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 28 */     setErrorCode(buffer.get());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 33 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 34 */     buffer.put(getErrorCode());
/* 35 */     buffer.flip();
/* 36 */     byte[] bytes = new byte[buffer.remaining()];
/* 37 */     buffer.get(bytes);
/* 38 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 43 */     return 36871;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 47 */     return super.toString() + ",errorCode=" + this.errorCode;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 51 */     DownDisconnectInform_0x9007 entity = new DownDisconnectInform_0x9007();
/* 52 */     entity.setErrorCode((byte)1);
/*    */ 
/* 55 */     DownDisconnectInform_0x9007 entity2 = new DownDisconnectInform_0x9007();
/* 56 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.DownDisconnectInform_0x9007
 * JD-Core Version:    0.6.1
 */