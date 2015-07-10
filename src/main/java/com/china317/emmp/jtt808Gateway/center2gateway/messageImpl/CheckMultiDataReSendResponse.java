/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8800;
/*    */ import java.util.List;
/*    */ 
/*    */ public class CheckMultiDataReSendResponse extends BaseDownMessage
/*    */ {
/*    */   private int multimediaId;
/*    */   private List<Integer> resendPkgNums;
/*    */ 
/*    */   public UnitPackJT808 pack()
/*    */     throws Exception
/*    */   {
/* 22 */     UnitPackJT808 pack = new UnitPackJT808(34816);
/* 23 */     JT808MsgBody_0x8800 body_0x8800 = new JT808MsgBody_0x8800();
/* 24 */     body_0x8800.setMultimediaID(this.multimediaId);
/* 25 */     body_0x8800.setRetransPkgSum((byte)this.resendPkgNums.size());
/* 26 */     body_0x8800.setRetransPkgList(this.resendPkgNums);
/* 27 */     body_0x8800.bulidBody();
/*    */ 
/* 29 */     pack.setMsgBody(body_0x8800);
/* 30 */     pack.setMsgBody(body_0x8800.getBodyBuffer());
/* 31 */     pack.setMobileNum(getMobileNum());
/* 32 */     pack.setSequenceNum(0);
/* 33 */     return pack;
/*    */   }
/*    */ 
/*    */   public CheckMultiDataReSendResponse(String mobileNum, int multimediaId, List<Integer> resendPkgNums) {
/* 37 */     setMobileNum(mobileNum);
/* 38 */     setMultimediaId(multimediaId);
/* 39 */     setResendPkgNums(resendPkgNums);
/* 40 */     setCommand("0x8800");
/*    */   }
/*    */ 
/*    */   public int getMultimediaId() {
/* 44 */     return this.multimediaId;
/*    */   }
/*    */ 
/*    */   public void setMultimediaId(int multimediaId)
/*    */   {
/* 49 */     this.multimediaId = multimediaId;
/*    */   }
/*    */ 
/*    */   public List<Integer> getResendPkgNums() {
/* 53 */     return this.resendPkgNums;
/*    */   }
/*    */ 
/*    */   public void setResendPkgNums(List<Integer> resendPkgNums) {
/* 57 */     this.resendPkgNums = resendPkgNums;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.CheckMultiDataReSendResponse
 * JD-Core Version:    0.6.1
 */