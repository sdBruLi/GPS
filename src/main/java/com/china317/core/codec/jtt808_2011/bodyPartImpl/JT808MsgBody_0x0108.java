/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0108 extends JT808MsgBody
/*    */ {
/*    */   private byte updateType;
/*    */   private byte result;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 21 */     this.updateType = this.bodyBuffer.get();
/* 22 */     this.result = this.bodyBuffer.get();
/*    */   }
/*    */ 
/*    */   public byte getUpdateType() {
/* 26 */     return this.updateType;
/*    */   }
/*    */ 
/*    */   public void setUpdateType(byte updateType) {
/* 30 */     this.updateType = updateType;
/*    */   }
/*    */ 
/*    */   public byte getResult()
/*    */   {
/* 38 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 42 */     this.result = result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0108
 * JD-Core Version:    0.6.1
 */