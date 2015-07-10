/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8805 extends JT808MsgBody
/*    */ {
/*    */   private int multimediaId;
/*    */   private byte delSign;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!isBuildBody()) {
/* 18 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 19 */       this.bodyBuffer.putInt(this.multimediaId);
/* 20 */       this.bodyBuffer.put(this.delSign);
/* 21 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createSingleMultiDataSearchUpload(String mobileNum, int multimediaId, byte delSign)
/*    */     throws Exception
/*    */   {
/* 38 */     UnitPackJT808 pack = new UnitPackJT808(34821);
/* 39 */     pack.setMobileNum(mobileNum);
/* 40 */     JT808MsgBody_0x8805 body = new JT808MsgBody_0x8805();
/* 41 */     body.setMultimediaId(multimediaId);
/* 42 */     body.setDelSign(delSign);
/* 43 */     pack.setMsgBody(body);
/* 44 */     return pack;
/*    */   }
/*    */ 
/*    */   public int getMultimediaId() {
/* 48 */     return this.multimediaId;
/*    */   }
/*    */ 
/*    */   public void setMultimediaId(int multimediaId) {
/* 52 */     this.multimediaId = multimediaId;
/*    */   }
/*    */ 
/*    */   public byte getDelSign() {
/* 56 */     return this.delSign;
/*    */   }
/*    */ 
/*    */   public void setDelSign(byte delSign) {
/* 60 */     this.delSign = delSign;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8805
 * JD-Core Version:    0.6.1
 */