/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0104 extends JT808MsgBody
/*    */ {
/*    */   private short ackSeqnum;
/*    */   private byte ackParamCount;
/*    */   private List<JT808MsgBody_0x8103_param_item> params;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!isBuildBody()) {
/* 18 */       this.bodyBuffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 19 */       this.bodyBuffer.putShort(this.ackSeqnum);
/* 20 */       this.bodyBuffer.put(this.ackParamCount);
/* 21 */       if (this.params != null) {
/* 22 */         for (JT808MsgBody_0x8103_param_item item : this.params) {
/* 23 */           item.bulidBody();
/* 24 */           this.bodyBuffer.put(item.getBodyBuffer());
/*    */         }
/*    */       }
/* 27 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 33 */     this.ackSeqnum = this.bodyBuffer.getShort();
/* 34 */     this.ackParamCount = this.bodyBuffer.get();
/* 35 */     for (int i = 0; i < this.ackParamCount; i++) {
/* 36 */       if (this.params == null) {
/* 37 */         this.params = new ArrayList();
/*    */       }
/* 39 */       JT808MsgBody_0x8103_param_item item = new JT808MsgBody_0x8103_param_item();
/* 40 */       item.setParamID(this.bodyBuffer.getInt());
/* 41 */       item.setParamLen(this.bodyBuffer.get());
/* 42 */       item.setParamValue(this.bodyBuffer.getSlice(item.getParamLen()));
/*    */ 
/* 44 */       this.params.add(item);
/*    */     }
/* 46 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public short getAckSeqnum() {
/* 50 */     return this.ackSeqnum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqnum(short ackSeqnum) {
/* 54 */     this.ackSeqnum = ackSeqnum;
/*    */   }
/*    */ 
/*    */   public byte getAckParamCount() {
/* 58 */     return this.ackParamCount;
/*    */   }
/*    */ 
/*    */   public void setAckParamCount(byte ackParamCount) {
/* 62 */     this.ackParamCount = ackParamCount;
/*    */   }
/*    */ 
/*    */   public List<JT808MsgBody_0x8103_param_item> getParams() {
/* 66 */     return this.params;
/*    */   }
/*    */ 
/*    */   public void setParams(List<JT808MsgBody_0x8103_param_item> params) {
/* 70 */     this.params = params;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0104
 * JD-Core Version:    0.6.1
 */