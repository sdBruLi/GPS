/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import com.china317.core.util.BytesUtil;
/*    */ import java.util.HashMap;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1openCoffer extends F1MsgDataPack
/*    */ {
/*    */   private Long userid;
/*    */   private Long pwd;
/*    */   private int lefttime;
/*    */ 
/*    */   public F1openCoffer()
/*    */   {
/* 19 */     super(24, 0, null);
/*    */   }
/*    */ 
/*    */   public F1openCoffer(int len, IoBuffer data) {
/* 23 */     super(24, len, data);
/*    */   }
/*    */ 
/*    */   public void praser()
/*    */     throws Exception
/*    */   {
/* 32 */     byte[] pack200 = new byte[5];
/* 33 */     this.data.get(pack200);
/* 34 */     this.userid = Long.valueOf(ByteUtil.BCD2Long(pack200));
/* 35 */     this.data.get(pack200);
/* 36 */     this.pwd = Long.valueOf(ByteUtil.BCD2Long(pack200));
/*    */ 
/* 38 */     this.lefttime = this.data.getUnsignedShort();
/*    */ 
/* 40 */     int cnt = (this.len - 12) / 4;
/* 41 */     this.labelStatus = new HashMap(cnt);
/* 42 */     for (int i = 0; i < cnt; i++) {
/* 43 */       pack200 = new byte[4];
/* 44 */       this.data.get(pack200);
/* 45 */       this.labelStatus.put(Long.valueOf(BytesUtil.byte4ToLong(pack200, false)), Byte.valueOf((byte)1));
/*    */     }
/* 47 */     if (this.data.remaining() == 28) {
/* 48 */       pack200 = new byte[28];
/* 49 */       this.data.get(pack200);
/* 50 */       this.gpsData = new JT808MsgBody_0x0200();
/* 51 */       this.gpsData.setBodyBuffer(IoBuffer.wrap(pack200));
/* 52 */       this.gpsData.praseBody();
/*    */     }
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public Long getUserid() {
/* 62 */     return this.userid;
/*    */   }
/*    */ 
/*    */   public void setUserid(Long userid) {
/* 66 */     this.userid = userid;
/*    */   }
/*    */ 
/*    */   public Long getPwd() {
/* 70 */     return this.pwd;
/*    */   }
/*    */ 
/*    */   public void setPwd(Long pwd) {
/* 74 */     this.pwd = pwd;
/*    */   }
/*    */ 
/*    */   public int getLefttime() {
/* 78 */     return this.lefttime;
/*    */   }
/*    */ 
/*    */   public void setLefttime(int lefttime) {
/* 82 */     this.lefttime = lefttime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1openCoffer
 * JD-Core Version:    0.6.1
 */