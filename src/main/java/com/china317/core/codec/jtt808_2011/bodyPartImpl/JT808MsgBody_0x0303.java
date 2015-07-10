/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0303 extends JT808MsgBody
/*    */ {
/*    */   private byte infoType;
/*    */   private byte sign;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 15 */     this.infoType = this.bodyBuffer.get();
/* 16 */     this.sign = this.bodyBuffer.get();
/* 17 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public byte getInfoType() {
/* 21 */     return this.infoType;
/*    */   }
/*    */ 
/*    */   public void setInfoType(byte infoType) {
/* 25 */     this.infoType = infoType;
/*    */   }
/*    */ 
/*    */   public byte getSign() {
/* 29 */     return this.sign;
/*    */   }
/*    */ 
/*    */   public void setSign(byte sign) {
/* 33 */     this.sign = sign;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0303
 * JD-Core Version:    0.6.1
 */