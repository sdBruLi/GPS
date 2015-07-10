/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8003 extends JT808MsgBody
/*    */ {
/*    */   private int responseSequenceNum;
/*    */   private byte retransPkgSum;
/*    */   private List<Integer> retransPkgList;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!isBuildBody()) {
/* 23 */       this.bodyBuffer = IoBuffer.allocate(5).setAutoExpand(true);
/* 24 */       this.bodyBuffer.putUnsignedShort(this.responseSequenceNum);
/* 25 */       this.bodyBuffer.put(this.retransPkgSum);
/* 26 */       if (this.retransPkgList != null) {
/* 27 */         for (Integer i : this.retransPkgList) {
/* 28 */           this.bodyBuffer.putUnsignedShort(i.intValue());
/*    */         }
/*    */       }
/* 31 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 37 */     this.responseSequenceNum = this.bodyBuffer.getUnsignedShort();
/* 38 */     this.retransPkgSum = this.bodyBuffer.get();
/* 39 */     for (int i = 0; i < this.retransPkgSum; i++) {
/* 40 */       if (this.retransPkgList == null) {
/* 41 */         this.retransPkgList = new ArrayList();
/*    */       }
/* 43 */       this.retransPkgList.add(Integer.valueOf(this.bodyBuffer.getUnsignedShort()));
/*    */     }
/* 45 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getResponseSequenceNum() {
/* 49 */     return this.responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public void setResponseSequenceNum(int responseSequenceNum) {
/* 53 */     this.responseSequenceNum = responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public byte getRetransPkgSum() {
/* 57 */     return this.retransPkgSum;
/*    */   }
/*    */ 
/*    */   public void setRetransPkgSum(byte retransPkgSum) {
/* 61 */     this.retransPkgSum = retransPkgSum;
/*    */   }
/*    */ 
/*    */   public List<Integer> getRetransPkgList() {
/* 65 */     return this.retransPkgList;
/*    */   }
/*    */ 
/*    */   public void setRetransPkgList(List<Integer> retransPkgList) {
/* 69 */     this.retransPkgList = retransPkgList;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8003
 * JD-Core Version:    0.6.1
 */