/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import com.china317.core.util.BytesUtil;
/*    */ import java.util.HashMap;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1outTreasury extends F1MsgDataPack
/*    */ {
/*    */   private String wayballID;
/*    */   private String carrierSim;
/*    */ 
/*    */   public F1outTreasury()
/*    */   {
/* 22 */     super(37, 0, null);
/*    */   }
/*    */ 
/*    */   public F1outTreasury(int len, IoBuffer data) {
/* 26 */     super(37, len, data);
/*    */   }
/*    */ 
/*    */   public void praser() throws Exception
/*    */   {
/* 31 */     byte[] temp = new byte[13];
/* 32 */     this.data.get(temp);
/* 33 */     this.wayballID = new String(temp).trim();
/* 34 */     temp = new byte[6];
/* 35 */     this.data.get(temp);
/* 36 */     this.carrierSim = String.valueOf(ByteUtil.BCD2Long(temp));
/* 37 */     this.labelStatus = new HashMap(1);
/*    */ 
/* 39 */     int cnt = (this.len - 19) / 5;
/* 40 */     for (int i = 0; i < cnt; i++) {
/* 41 */       temp = new byte[4];
/* 42 */       this.data.get(temp);
/* 43 */       this.labelStatus.put(Long.valueOf(BytesUtil.byte4ToLong(temp, false)), Byte.valueOf(this.data.get()));
/*    */     }
/*    */ 
/* 46 */     if (this.data.remaining() == 28) {
/* 47 */       temp = new byte[28];
/* 48 */       this.data.get(temp);
/* 49 */       this.gpsData = new JT808MsgBody_0x0200();
/* 50 */       this.gpsData.setBodyBuffer(IoBuffer.wrap(temp));
/* 51 */       this.gpsData.praseBody();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setWayballID(String wayballID) {
/* 56 */     this.wayballID = wayballID;
/*    */   }
/*    */ 
/*    */   public String getCarrierSim() {
/* 60 */     return this.carrierSim;
/*    */   }
/*    */ 
/*    */   public void setCarrierSim(String carrierSim) {
/* 64 */     this.carrierSim = carrierSim;
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public String getWayballID() {
/* 73 */     return this.wayballID;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1outTreasury
 * JD-Core Version:    0.6.1
 */