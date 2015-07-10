/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownTotalRecvBackMsg_0x9101 extends DataPacketBodyPart
/*    */ {
/*    */   private int dynamicInfoTotal;
/*    */   private long startTime;
/*    */   private long endTime;
/*    */ 
/*    */   public int getDynamicInfoTotal()
/*    */   {
/* 15 */     return this.dynamicInfoTotal;
/*    */   }
/*    */ 
/*    */   public void setDynamicInfoTotal(int dynamicInfoTotal) {
/* 19 */     this.dynamicInfoTotal = dynamicInfoTotal;
/*    */   }
/*    */ 
/*    */   public long getStartTime() {
/* 23 */     return this.startTime;
/*    */   }
/*    */ 
/*    */   public void setStartTime(long startTime) {
/* 27 */     this.startTime = startTime;
/*    */   }
/*    */ 
/*    */   public long getEndTime() {
/* 31 */     return this.endTime;
/*    */   }
/*    */ 
/*    */   public void setEndTime(long endTime) {
/* 35 */     this.endTime = endTime;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/* 44 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 45 */     setDynamicInfoTotal(buffer.getInt());
/* 46 */     setStartTime(buffer.getLong());
/* 47 */     setEndTime(buffer.getLong());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 52 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 53 */     buffer.putInt(getDynamicInfoTotal());
/* 54 */     buffer.putLong(getStartTime());
/* 55 */     buffer.putLong(getEndTime());
/* 56 */     buffer.flip();
/* 57 */     byte[] bytes = new byte[buffer.remaining()];
/* 58 */     buffer.get(bytes);
/* 59 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 64 */     return 37121;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 68 */     return super.toString() + ",dynamicInfoTotal=" + getDynamicInfoTotal() + 
/* 69 */       ",startTime=" + getStartTime() + ",endTime=" + getEndTime();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 73 */     DownTotalRecvBackMsg_0x9101 entity = new DownTotalRecvBackMsg_0x9101();
/* 74 */     entity.setDynamicInfoTotal(1);
/* 75 */     entity.setStartTime(1234567890123L);
/* 76 */     entity.setEndTime(1234567890456L);
/*    */ 
/* 79 */     DownTotalRecvBackMsg_0x9101 entity2 = new DownTotalRecvBackMsg_0x9101();
/* 80 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.DownTotalRecvBackMsg_0x9101
 * JD-Core Version:    0.6.1
 */