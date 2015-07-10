/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpExgMsgTakeEwaybillAck_0x120B extends UpExgMsgHead
/*    */ {
/*    */   private int ewaybillLength;
/*    */   private String ewaybillInfo;
/*    */ 
/*    */   public UpExgMsgTakeEwaybillAck_0x120B()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpExgMsgTakeEwaybillAck_0x120B(int msgId)
/*    */   {
/* 14 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception
/*    */   {
/* 19 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 20 */     setDatalength(getEwaybillLength() + 4);
/* 21 */     buildFirstBody(buffer);
/*    */ 
/* 23 */     buffer.putInt(getEwaybillLength());
/* 24 */     buffer.putString(getEwaybillInfo(), getEwaybillLength(), Constants.CharsetEncoder_GBK);
/* 25 */     buffer.flip();
/* 26 */     byte[] bytes = new byte[buffer.remaining()];
/* 27 */     buffer.get(bytes);
/* 28 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 34 */     return 4619;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 39 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 40 */     parseFirstBody(buffer);
/*    */ 
/* 42 */     parseLocationBody(buffer);
/*    */   }
/*    */ 
/*    */   public void parseLocationBody(IoBuffer buffer)
/*    */     throws CharacterCodingException
/*    */   {
/* 48 */     setEwaybillLength(buffer.getInt());
/* 49 */     setEwaybillInfo(buffer.getString(getEwaybillLength(), Constants.CharsetDecoder_GBK));
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 58 */     return super.toString() + ",ewaybillLength=" + this.ewaybillLength + 
/* 59 */       ",ewaybillInfo=" + this.ewaybillInfo;
/*    */   }
/*    */   public int getEwaybillLength() {
/* 62 */     return this.ewaybillLength;
/*    */   }
/*    */ 
/*    */   public void setEwaybillLength(int ewaybillLength) {
/* 66 */     this.ewaybillLength = ewaybillLength;
/*    */   }
/*    */ 
/*    */   public String getEwaybillInfo() {
/* 70 */     return this.ewaybillInfo;
/*    */   }
/*    */ 
/*    */   public void setEwaybillInfo(String ewaybillInfo) {
/* 74 */     this.ewaybillInfo = ewaybillInfo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgTakeEwaybillAck_0x120B
 * JD-Core Version:    0.6.1
 */