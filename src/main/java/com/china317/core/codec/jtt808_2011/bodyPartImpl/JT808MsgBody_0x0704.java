/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0704 extends JT808MsgBody
/*    */ {
/*    */   private byte normal0blind1;
/*    */   private short dataCnt;
/*    */   private List<JT808MsgBody_0x0200> data200s;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 26 */     this.dataCnt = this.bodyBuffer.getShort();
/* 27 */     this.data200s = new ArrayList(this.dataCnt);
/* 28 */     this.normal0blind1 = this.bodyBuffer.get();
/* 29 */     int datalength = 0;
/*    */ 
/* 32 */     while (this.bodyBuffer.remaining() > 2) {
/* 33 */       datalength = this.bodyBuffer.getShort();
/* 34 */       byte[] data = new byte[datalength];
/* 35 */       this.bodyBuffer.get(data);
/* 36 */       JT808MsgBody_0x0200 x200 = new JT808MsgBody_0x0200();
/* 37 */       x200.setBodyBuffer(IoBuffer.wrap(data));
/* 38 */       x200.praseBody();
/*    */     }
/* 40 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public short getDataCnt() {
/* 44 */     return this.dataCnt;
/*    */   }
/*    */ 
/*    */   public void setDataCnt(short dataCnt) {
/* 48 */     this.dataCnt = dataCnt;
/*    */   }
/*    */ 
/*    */   public List<JT808MsgBody_0x0200> getData200s() {
/* 52 */     return this.data200s;
/*    */   }
/*    */ 
/*    */   public void setData200s(List<JT808MsgBody_0x0200> data200s) {
/* 56 */     this.data200s = data200s;
/*    */   }
/*    */ 
/*    */   public byte getNormal0blind1() {
/* 60 */     return this.normal0blind1;
/*    */   }
/*    */ 
/*    */   public void setNormal0blind1(byte normal0blind1) {
/* 64 */     this.normal0blind1 = normal0blind1;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0704
 * JD-Core Version:    0.6.1
 */