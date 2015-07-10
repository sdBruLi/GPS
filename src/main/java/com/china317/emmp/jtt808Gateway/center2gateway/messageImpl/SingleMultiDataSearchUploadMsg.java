/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8805;
/*    */ 
/*    */ public class SingleMultiDataSearchUploadMsg extends BaseDownMessage
/*    */ {
/*    */   public static final byte DEL_SIGN_ON = 1;
/*    */   public static final byte DEL_SIGN_OFF = 0;
/*    */   private int multimediaId;
/*    */   private byte delSign;
/*    */ 
/*    */   public SingleMultiDataSearchUploadMsg(String mobileNum, String messageKey, int multimediaId, byte delSign)
/*    */   {
/* 31 */     setMobileNum(mobileNum);
/* 32 */     setMessageKey(messageKey);
/* 33 */     setMultimediaId(multimediaId);
/* 34 */     setDelSign(delSign);
/* 35 */     setCommand("0x8805");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 40 */     UnitPackJT808 pack = new UnitPackJT808(34821);
/* 41 */     pack.setMobileNum(getMobileNum());
/* 42 */     JT808MsgBody_0x8805 body = new JT808MsgBody_0x8805();
/* 43 */     body.setMultimediaId(this.multimediaId);
/* 44 */     body.setDelSign(this.delSign);
/* 45 */     pack.setMsgBody(body);
/* 46 */     return pack;
/*    */   }
/*    */ 
/*    */   public int getMultimediaId() {
/* 50 */     return this.multimediaId;
/*    */   }
/*    */ 
/*    */   public void setMultimediaId(int multimediaId)
/*    */   {
/* 55 */     this.multimediaId = multimediaId;
/*    */   }
/*    */ 
/*    */   public byte getDelSign() {
/* 59 */     return this.delSign;
/*    */   }
/*    */ 
/*    */   public void setDelSign(byte delSign)
/*    */   {
/* 64 */     this.delSign = delSign;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SingleMultiDataSearchUploadMsg
 * JD-Core Version:    0.6.1
 */