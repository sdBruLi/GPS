/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8800 extends JT808MsgBody
/*    */ {
/*    */   private int multimediaID;
/*    */   private byte retransPkgSum;
/*    */   private List<Integer> retransPkgList;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!isBuildBody()) {
/* 19 */       this.bodyBuffer = IoBuffer.allocate(5).setAutoExpand(true);
/* 20 */       this.bodyBuffer.putInt(this.multimediaID);
/* 21 */       this.bodyBuffer.put(this.retransPkgSum);
/* 22 */       if (this.retransPkgList != null) {
/* 23 */         for (Integer i : this.retransPkgList) {
/* 24 */           this.bodyBuffer.putUnsignedShort(i.intValue());
/*    */         }
/*    */       }
/* 27 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 33 */     this.multimediaID = this.bodyBuffer.getInt();
/* 34 */     this.retransPkgSum = this.bodyBuffer.get();
/* 35 */     for (int i = 0; i < this.retransPkgSum; i++) {
/* 36 */       if (this.retransPkgList == null) {
/* 37 */         this.retransPkgList = new ArrayList();
/*    */       }
/* 39 */       this.retransPkgList.add(Integer.valueOf(this.bodyBuffer.getUnsignedShort()));
/*    */     }
/* 41 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getMultimediaID()
/*    */   {
/* 67 */     return this.multimediaID;
/*    */   }
/*    */ 
/*    */   public void setMultimediaID(int multimediaID) {
/* 71 */     this.multimediaID = multimediaID;
/*    */   }
/*    */ 
/*    */   public byte getRetransPkgSum() {
/* 75 */     return this.retransPkgSum;
/*    */   }
/*    */ 
/*    */   public void setRetransPkgSum(byte retransPkgSum) {
/* 79 */     this.retransPkgSum = retransPkgSum;
/*    */   }
/*    */ 
/*    */   public List<Integer> getRetransPkgList() {
/* 83 */     return this.retransPkgList;
/*    */   }
/*    */ 
/*    */   public void setRetransPkgList(List<Integer> retransPkgList) {
/* 87 */     this.retransPkgList = retransPkgList;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8800
 * JD-Core Version:    0.6.1
 */