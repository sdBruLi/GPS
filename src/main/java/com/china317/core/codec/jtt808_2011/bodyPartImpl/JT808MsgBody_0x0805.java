/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0805 extends JT808MsgBody
/*    */ {
/*    */   public static final byte RESULT_OK = 0;
/*    */   public static final byte RESULT_FAILURE = 1;
/*    */   public static final byte RESULT_CHANNEL_WARN = 2;
/*    */   private int responseSequenceNum;
/*    */   private int successCnt;
/*    */   private byte result;
/*    */   private List<Integer> mediaIds;
/*    */ 
/*    */   public int getResponseSequenceNum()
/*    */   {
/* 26 */     return this.responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public void setResponseSequenceNum(int responseSequenceNum) {
/* 30 */     this.responseSequenceNum = responseSequenceNum;
/*    */   }
/*    */ 
/*    */   public int getSuccessCnt() {
/* 34 */     return this.successCnt;
/*    */   }
/*    */ 
/*    */   public void setSuccessCnt(int successCnt) {
/* 38 */     this.successCnt = successCnt;
/*    */   }
/*    */ 
/*    */   public byte getResult() {
/* 42 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 46 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public void bulidBody() throws Exception
/*    */   {
/* 51 */     if (!isBuildBody()) {
/* 52 */       this.bodyBuffer = IoBuffer.allocate(5).setAutoExpand(true);
/* 53 */       this.bodyBuffer.putUnsignedShort(this.responseSequenceNum);
/* 54 */       this.bodyBuffer.put(this.result);
/* 55 */       this.bodyBuffer.putUnsignedShort(this.successCnt);
/* 56 */       for (Iterator localIterator = this.mediaIds.iterator(); localIterator.hasNext(); ) { int id = ((Integer)localIterator.next()).intValue();
/* 57 */         this.bodyBuffer.putInt(id);
/*    */       }
/* 59 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 65 */     this.responseSequenceNum = this.bodyBuffer.getUnsignedShort();
/* 66 */     this.result = this.bodyBuffer.get();
/* 67 */     this.successCnt = this.bodyBuffer.getUnsignedShort();
/* 68 */     this.mediaIds = new ArrayList(this.successCnt);
/* 69 */     for (int i = 0; i < this.successCnt; i++) {
/* 70 */       this.mediaIds.add(Integer.valueOf(this.bodyBuffer.getInt()));
/*    */     }
/* 72 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0805
 * JD-Core Version:    0.6.1
 */