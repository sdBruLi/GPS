/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8700 extends JT808MsgBody
/*    */ {
/*    */   private byte command;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 15 */     if (!isBuildBody()) {
/* 16 */       this.bodyBuffer = IoBuffer.allocate(1).setAutoExpand(true);
/* 17 */       this.bodyBuffer.put(this.command);
/* 18 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 24 */     this.command = this.bodyBuffer.get();
/* 25 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createDriverRecordGatherPack(String mobileNum, byte command)
/*    */     throws Exception
/*    */   {
/* 36 */     UnitPackJT808 pack = new UnitPackJT808(34560);
/* 37 */     pack.setMobileNum(mobileNum);
/* 38 */     JT808MsgBody_0x8700 body = new JT808MsgBody_0x8700();
/* 39 */     body.setCommand(command);
/* 40 */     pack.setMsgBody(body);
/* 41 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getCommand() {
/* 45 */     return this.command;
/*    */   }
/*    */ 
/*    */   public void setCommand(byte command) {
/* 49 */     this.command = command;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8700
 * JD-Core Version:    0.6.1
 */