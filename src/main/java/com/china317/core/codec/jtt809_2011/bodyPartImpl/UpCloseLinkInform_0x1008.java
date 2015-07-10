/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpCloseLinkInform_0x1008 extends DataPacketBodyPart
/*    */ {
/*    */   private byte reasonCode;
/*    */ 
/*    */   public byte[] buildBody()
/*    */     throws Exception
/*    */   {
/* 14 */     IoBuffer buffer = IoBuffer.allocate(1).setAutoExpand(true);
/* 15 */     buffer.put(getReasonCode());
/* 16 */     buffer.flip();
/* 17 */     byte[] bytes = new byte[buffer.remaining()];
/* 18 */     buffer.get(bytes);
/* 19 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 25 */     return 4104;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 30 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 31 */     setReasonCode(buffer.get());
/*    */   }
/*    */ 
/*    */   public void setReasonCode(byte reasonCode) {
/* 35 */     this.reasonCode = reasonCode;
/*    */   }
/*    */ 
/*    */   public byte getReasonCode() {
/* 39 */     return this.reasonCode;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.UpCloseLinkInform_0x1008
 * JD-Core Version:    0.6.1
 */