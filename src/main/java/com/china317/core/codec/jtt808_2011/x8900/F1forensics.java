/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1forensics extends F1MsgDataPack
/*    */ {
/*    */   private String inspectProcessId;
/*    */   private String carrierSim;
/*    */   private int mediaID;
/*    */   private String description;
/*    */ 
/*    */   public String getDescription()
/*    */   {
/* 21 */     return this.description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description) {
/* 25 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public int getMediaID() {
/* 29 */     return this.mediaID;
/*    */   }
/*    */ 
/*    */   public void setMediaID(int mediaID) {
/* 33 */     this.mediaID = mediaID;
/*    */   }
/*    */ 
/*    */   public F1forensics() {
/* 37 */     super(35, 0, null);
/*    */   }
/*    */ 
/*    */   public F1forensics(int len, IoBuffer data) {
/* 41 */     super(35, len, data);
/*    */   }
/*    */ 
/*    */   public void praser() throws Exception
/*    */   {
/* 46 */     byte[] temp = new byte[10];
/* 47 */     this.data.get(temp);
/* 48 */     this.inspectProcessId = String.valueOf(ByteUtil.BCD2Long(temp));
/*    */ 
/* 50 */     temp = new byte[6];
/* 51 */     this.data.get(temp);
/* 52 */     this.carrierSim = String.valueOf(ByteUtil.BCD2Long(temp));
/*    */ 
/* 55 */     this.mediaID = this.data.getInt();
/*    */ 
/* 57 */     temp = new byte[this.len - 20];
/* 58 */     this.data.get(temp);
/* 59 */     this.description = new String(temp, "GBK");
/*    */ 
/* 61 */     if (this.data.remaining() == 28) {
/* 62 */       temp = new byte[28];
/* 63 */       this.data.get(temp);
/* 64 */       this.gpsData = new JT808MsgBody_0x0200();
/* 65 */       this.gpsData.setBodyBuffer(IoBuffer.wrap(temp));
/* 66 */       this.gpsData.praseBody();
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getInspectProcessId() {
/* 71 */     return this.inspectProcessId;
/*    */   }
/*    */ 
/*    */   public void setInspectProcessId(String inspectProcessId) {
/* 75 */     this.inspectProcessId = inspectProcessId;
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public String getCarrierSim() {
/* 84 */     return this.carrierSim;
/*    */   }
/*    */ 
/*    */   public void setCarrierSim(String carrierSim) {
/* 88 */     this.carrierSim = carrierSim;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1forensics
 * JD-Core Version:    0.6.1
 */