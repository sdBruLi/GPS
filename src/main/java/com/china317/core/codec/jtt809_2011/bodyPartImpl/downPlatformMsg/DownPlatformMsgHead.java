/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downPlatformMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public abstract class DownPlatformMsgHead extends DataPacketBodyPart
/*    */ {
/*    */   private int dataLength;
/*    */ 
/*    */   public int getDataLength()
/*    */   {
/* 21 */     return this.dataLength;
/*    */   }
/*    */ 
/*    */   public void setDataLength(int dataLength) {
/* 25 */     this.dataLength = dataLength;
/*    */   }
/*    */ 
/*    */   public void parseFirstBody(IoBuffer buffer) throws Exception {
/* 29 */     setDataType(buffer.getShort() & 0xFFFF);
/* 30 */     setDataLength(buffer.getInt());
/*    */   }
/*    */ 
/*    */   public void buildFirstBody(IoBuffer buffer) {
/* 34 */     buffer.putShort(getDataType());
/* 35 */     buffer.putInt(getDataLength());
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 39 */     return super.toString() + ",dataType=" + getDataType() + 
/* 40 */       ",dataLength=" + this.dataLength;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downPlatformMsg.DownPlatformMsgHead
 * JD-Core Version:    0.6.1
 */