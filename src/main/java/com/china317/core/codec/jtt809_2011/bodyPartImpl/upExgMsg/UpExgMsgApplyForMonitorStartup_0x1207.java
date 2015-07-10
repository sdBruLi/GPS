/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpExgMsgApplyForMonitorStartup_0x1207 extends UpExgMsgHead
/*    */ {
/*    */   private long startTime;
/*    */   private long endTime;
/*    */ 
/*    */   public UpExgMsgApplyForMonitorStartup_0x1207()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpExgMsgApplyForMonitorStartup_0x1207(int msgId)
/*    */   {
/* 12 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception
/*    */   {
/* 17 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 18 */     setDatalength(16);
/* 19 */     buildFirstBody(buffer);
/*    */ 
/* 21 */     buffer.putLong(getStartTime());
/* 22 */     buffer.putLong(getEndTime());
/*    */ 
/* 24 */     buffer.flip();
/* 25 */     byte[] bytes = new byte[buffer.remaining()];
/* 26 */     buffer.get(bytes);
/* 27 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 33 */     return 4615;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 38 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 39 */     parseFirstBody(buffer);
/*    */ 
/* 41 */     parseLocationBody(buffer);
/*    */   }
/*    */ 
/*    */   public void parseLocationBody(IoBuffer buffer)
/*    */   {
/* 47 */     setStartTime(buffer.getLong());
/* 48 */     setEndTime(buffer.getLong());
/*    */   }
/*    */ 
/*    */   public long getStartTime()
/*    */   {
/* 56 */     return this.startTime;
/*    */   }
/*    */ 
/*    */   public void setStartTime(long startTime) {
/* 60 */     this.startTime = startTime;
/*    */   }
/*    */ 
/*    */   public long getEndTime() {
/* 64 */     return this.endTime;
/*    */   }
/*    */ 
/*    */   public void setEndTime(long endTime) {
/* 68 */     this.endTime = endTime;
/*    */   }
/*    */   public String toString() {
/* 71 */     return super.toString() + ",startTime=" + this.startTime + 
/* 72 */       ",endTime=" + this.endTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgApplyForMonitorStartup_0x1207
 * JD-Core Version:    0.6.1
 */