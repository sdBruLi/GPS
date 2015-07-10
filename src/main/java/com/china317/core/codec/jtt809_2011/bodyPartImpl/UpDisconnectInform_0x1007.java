/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpDisconnectInform_0x1007 extends DataPacketBodyPart
/*    */ {
/*    */   private byte errorCode;
/*    */ 
/*    */   public byte[] buildBody()
/*    */     throws Exception
/*    */   {
/* 13 */     IoBuffer buffer = IoBuffer.allocate(1).setAutoExpand(true);
/* 14 */     buffer.put(getErrorCode());
/* 15 */     buffer.flip();
/* 16 */     byte[] bytes = new byte[buffer.remaining()];
/* 17 */     buffer.get(bytes);
/* 18 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 23 */     return 4103;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 28 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 29 */     setErrorCode(buffer.get());
/*    */   }
/*    */ 
/*    */   public void setErrorCode(byte errorCode) {
/* 33 */     this.errorCode = errorCode;
/*    */   }
/*    */ 
/*    */   public byte getErrorCode() {
/* 37 */     return this.errorCode;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.UpDisconnectInform_0x1007
 * JD-Core Version:    0.6.1
 */