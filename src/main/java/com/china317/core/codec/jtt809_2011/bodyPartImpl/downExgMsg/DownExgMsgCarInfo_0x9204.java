/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownExgMsgCarInfo_0x9204 extends DownExgMsgHead
/*    */ {
/*    */   private String carInfo;
/*    */ 
/*    */   public DownExgMsgCarInfo_0x9204()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownExgMsgCarInfo_0x9204(int msgId)
/*    */   {
/* 15 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception {
/* 19 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/*    */ 
/* 21 */     if (getCarInfo() != null) {
/* 22 */       setDatalength(getCarInfo().getBytes("GBK").length);
/*    */     }
/*    */ 
/* 25 */     buildFirstBody(buffer);
/*    */ 
/* 27 */     buildLastBody(buffer);
/*    */ 
/* 29 */     buffer.flip();
/* 30 */     byte[] bytes = new byte[buffer.remaining()];
/* 31 */     buffer.get(bytes);
/* 32 */     return bytes;
/*    */   }
/*    */ 
/*    */   private void buildLastBody(IoBuffer buffer) throws CharacterCodingException {
/* 36 */     buffer.putString(getCarInfo(), Constants.CharsetEncoder_GBK);
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 41 */     return 37380;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 46 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 47 */     parseFirstBody(buffer);
/*    */ 
/* 49 */     parseLocationBody(buffer);
/*    */   }
/*    */ 
/*    */   public void parseLocationBody(IoBuffer buffer)
/*    */     throws CharacterCodingException
/*    */   {
/* 55 */     setCarInfo(buffer.getString(getDatalength(), Constants.CharsetDecoder_GBK));
/*    */   }
/*    */ 
/*    */   public String getCarInfo()
/*    */   {
/* 61 */     return this.carInfo;
/*    */   }
/*    */ 
/*    */   public void setCarInfo(String carInfo) {
/* 65 */     this.carInfo = carInfo;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 69 */     return super.toString() + ",carInfo=" + this.carInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgCarInfo_0x9204
 * JD-Core Version:    0.6.1
 */