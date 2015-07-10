/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import com.china317.core.util.BytesUtil;
/*    */ import java.util.HashMap;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1lineStorage4s extends F1MsgDataPack
/*    */ {
/*    */   private String carrierSim;
/*    */   private String wayballID;
/*    */ 
/*    */   public F1lineStorage4s()
/*    */   {
/* 22 */     super(38, 0, null);
/*    */   }
/*    */ 
/*    */   public F1lineStorage4s(int len, IoBuffer data) {
/* 26 */     super(38, len, data);
/*    */   }
/*    */ 
/*    */   public void praser() throws Exception
/*    */   {
/* 31 */     byte[] temp = new byte[13];
/* 32 */     this.data.get(temp);
/* 33 */     this.wayballID = new String(temp);
/* 34 */     temp = new byte[6];
/* 35 */     this.data.get(temp);
/* 36 */     this.carrierSim = String.valueOf(ByteUtil.BCD2Long(temp));
/* 37 */     int cnt = (this.len - 19) / 5;
/* 38 */     this.labelStatus = new HashMap(cnt);
/* 39 */     for (int i = 0; i < cnt; i++) {
/* 40 */       temp = new byte[4];
/* 41 */       this.data.get(temp);
/* 42 */       this.labelStatus.put(Long.valueOf(BytesUtil.byte4ToLong(temp, false)), Byte.valueOf(this.data.get()));
/*    */     }
/*    */ 
/* 45 */     if (this.data.remaining() == 28) {
/* 46 */       temp = new byte[28];
/* 47 */       this.data.get(temp);
/* 48 */       this.gpsData = new JT808MsgBody_0x0200();
/* 49 */       this.gpsData.setBodyBuffer(IoBuffer.wrap(temp));
/* 50 */       this.gpsData.praseBody();
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getCarrierSim() {
/* 55 */     return this.carrierSim;
/*    */   }
/*    */ 
/*    */   public void setCarrierSim(String carrierSim) {
/* 59 */     this.carrierSim = carrierSim;
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public String getWayballID() {
/* 68 */     return this.wayballID;
/*    */   }
/*    */ 
/*    */   public void setWayballID(String wayballID) {
/* 72 */     this.wayballID = wayballID;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1lineStorage4s
 * JD-Core Version:    0.6.1
 */