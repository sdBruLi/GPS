/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownConnectRsp_0x9002 extends DataPacketBodyPart
/*    */ {
/*    */   private byte result;
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
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/* 27 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 28 */     setResult(buffer.get());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 33 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 34 */     buffer.put(getResult());
/* 35 */     buffer.flip();
/* 36 */     byte[] bytes = new byte[buffer.remaining()];
/* 37 */     buffer.get(bytes);
/* 38 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 43 */     return 36866;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 47 */     return super.toString() + ",result=" + this.result;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 51 */     DownConnectRsp_0x9002 entity = new DownConnectRsp_0x9002();
/* 52 */     entity.setResult((byte)1);
/*    */ 
/* 55 */     DownConnectRsp_0x9002 entity2 = new DownConnectRsp_0x9002();
/* 56 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.DownConnectRsp_0x9002
 * JD-Core Version:    0.6.1
 */