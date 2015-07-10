/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownCloselinkInform_0x9008 extends DataPacketBodyPart
/*    */ {
/*    */   private byte reasonCode;
/*    */ 
/*    */   public byte getReasonCode()
/*    */   {
/* 14 */     return this.reasonCode;
/*    */   }
/*    */ 
/*    */   public void setReasonCode(byte reasonCode) {
/* 18 */     this.reasonCode = reasonCode;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/* 27 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 28 */     setReasonCode(buffer.get());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 33 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 34 */     buffer.put(getReasonCode());
/* 35 */     buffer.flip();
/* 36 */     byte[] bytes = new byte[buffer.remaining()];
/* 37 */     buffer.get(bytes);
/* 38 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 43 */     return 36872;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 47 */     return super.toString() + ",reasonCode=" + this.reasonCode;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 51 */     DownCloselinkInform_0x9008 entity = new DownCloselinkInform_0x9008();
/* 52 */     entity.setReasonCode((byte)1);
/*    */ 
/* 55 */     DownCloselinkInform_0x9008 entity2 = new DownCloselinkInform_0x9008();
/* 56 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.DownCloselinkInform_0x9008
 * JD-Core Version:    0.6.1
 */