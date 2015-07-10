/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import com.china317.core.util.BytesUtil;
/*    */ import java.util.HashMap;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1inspector extends F1MsgDataPack
/*    */ {
/*    */   private String inspectProcessId;
/*    */   private String carrierSim;
/*    */ 
/*    */   public F1inspector()
/*    */   {
/* 22 */     super(34, 0, null);
/*    */   }
/*    */ 
/*    */   public F1inspector(int len, IoBuffer data) {
/* 26 */     super(34, len, data);
/*    */   }
/*    */ 
/*    */   public void praser() throws Exception
/*    */   {
/* 31 */     byte[] temp = new byte[10];
/* 32 */     this.data.get(temp);
/* 33 */     this.inspectProcessId = String.valueOf(ByteUtil.BCD2Long(temp));
/* 34 */     temp = new byte[6];
/* 35 */     this.data.get(temp);
/* 36 */     this.carrierSim = String.valueOf(ByteUtil.BCD2Long(temp));
/*    */ 
/* 38 */     int cnt = (this.len - 16) / 4;
/* 39 */     this.labelStatus = new HashMap(cnt);
/* 40 */     for (int i = 0; i < cnt; i++) {
/* 41 */       temp = new byte[4];
/* 42 */       this.data.get(temp);
/* 43 */       this.labelStatus.put(Long.valueOf(BytesUtil.byte4ToLong(temp, false)), Byte.valueOf((byte)1));
/*    */     }
/* 45 */     if (this.data.remaining() == 28) {
/* 46 */       temp = new byte[28];
/* 47 */       this.data.get(temp);
/* 48 */       this.gpsData = new JT808MsgBody_0x0200();
/* 49 */       this.gpsData.setBodyBuffer(IoBuffer.wrap(temp));
/* 50 */       this.gpsData.praseBody();
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getInspectProcessId() {
/* 55 */     return this.inspectProcessId;
/*    */   }
/*    */ 
/*    */   public void setInspectProcessId(String inspectProcessId) {
/* 59 */     this.inspectProcessId = inspectProcessId;
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public String getCarrierSim() {
/* 68 */     return this.carrierSim;
/*    */   }
/*    */ 
/*    */   public void setCarrierSim(String carrierSim) {
/* 72 */     this.carrierSim = carrierSim;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1inspector
 * JD-Core Version:    0.6.1
 */