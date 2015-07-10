/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import com.china317.core.codec.jtt808_2011.util.DateTimeUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0705 extends JT808MsgBody
/*    */ {
/*    */   private IoBuffer dataBlock;
/*    */   private short dataCnt;
/*    */   private String time;
/*    */   private List<CanData> datas;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 32 */     this.dataCnt = this.bodyBuffer.getShort();
/* 33 */     byte[] timebytes = new byte[5];
/* 34 */     this.bodyBuffer.get(timebytes);
/* 35 */     this.time = ByteUtil.getHexString(timebytes);
/* 36 */     int po = this.bodyBuffer.position();
/* 37 */     this.datas = new ArrayList(this.dataCnt);
/* 38 */     CanData ob = null;
/* 39 */     this.dataBlock = this.bodyBuffer.getSlice(this.bodyBuffer.limit() - 7);
/* 40 */     this.bodyBuffer.position(po);
/*    */ 
/* 42 */     byte[] ss = new byte[4];
/* 43 */     Date dd = DateTimeUtil.format(this.time);
/* 44 */     for (int i = 0; i < this.dataCnt; i++) {
/* 45 */       ob = new CanData();
/* 46 */       this.bodyBuffer.get(ss);
/* 47 */       long status = ByteUtil.toLongValue(ss);
/* 48 */       ob.setChannel((byte)(int)(status >> 31 & 1L));
/* 49 */       ob.setType((byte)(int)(status >> 30 & 1L));
/* 50 */       ob.setCollect((byte)(int)(status >> 29 & 1L));
/* 51 */       ob.setId((int)(status & 0x1FFFFFFF));
/* 52 */       ob.setData(this.bodyBuffer.getLong());
/* 53 */       ob.setTime(dd);
/* 54 */       this.datas.add(ob);
/*    */     }
/* 56 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public short getDataCnt() {
/* 60 */     return this.dataCnt;
/*    */   }
/*    */ 
/*    */   public void setDataCnt(short dataCnt) {
/* 64 */     this.dataCnt = dataCnt;
/*    */   }
/*    */ 
/*    */   public String getTime() {
/* 68 */     return this.time;
/*    */   }
/*    */ 
/*    */   public void setTime(String time) {
/* 72 */     this.time = time;
/*    */   }
/*    */ 
/*    */   public List<CanData> getDatas() {
/* 76 */     return this.datas;
/*    */   }
/*    */ 
/*    */   public void setDatas(List<CanData> datas) {
/* 80 */     this.datas = datas;
/*    */   }
/*    */ 
/*    */   public IoBuffer getDataBlock() {
/* 84 */     return this.dataBlock;
/*    */   }
/*    */ 
/*    */   public void setDataBlock(IoBuffer dataBlock) {
/* 88 */     this.dataBlock = dataBlock;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0705
 * JD-Core Version:    0.6.1
 */