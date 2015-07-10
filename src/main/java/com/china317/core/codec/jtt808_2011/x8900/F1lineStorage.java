/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.util.BytesUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1lineStorage extends F1MsgDataPack
/*    */ {
/*    */   private String vin;
/*    */   private String rfid;
/*    */   private String certificate;
/*    */ 
/*    */   public F1lineStorage()
/*    */   {
/* 19 */     super(36, 0, null);
/*    */   }
/*    */ 
/*    */   public F1lineStorage(int len, IoBuffer data) {
/* 23 */     super(36, len, data);
/*    */   }
/*    */ 
/*    */   public void praser()
/*    */     throws Exception
/*    */   {
/* 31 */     byte[] temp = new byte[17];
/* 32 */     this.data.get(temp);
/* 33 */     this.vin = new String(temp);
/* 34 */     temp = new byte[4];
/* 35 */     this.data.get(temp);
/* 36 */     this.rfid = String.valueOf(BytesUtil.byte4ToLong(temp, false));
/* 37 */     temp = new byte[4];
/* 38 */     this.data.get(temp);
/* 39 */     this.certificate = String.valueOf(BytesUtil.byte4ToLong(temp, false));
/* 40 */     this.data.get();
/*    */   }
/*    */ 
/*    */   public String getVin()
/*    */   {
/* 52 */     return this.vin;
/*    */   }
/*    */ 
/*    */   public void setVin(String vin) {
/* 56 */     this.vin = vin;
/*    */   }
/*    */ 
/*    */   public String getRfid() {
/* 60 */     return this.rfid;
/*    */   }
/*    */ 
/*    */   public void setRfid(String rfid) {
/* 64 */     this.rfid = rfid;
/*    */   }
/*    */ 
/*    */   public String getCertificate() {
/* 68 */     return this.certificate;
/*    */   }
/*    */ 
/*    */   public void setCertificate(String certificate) {
/* 72 */     this.certificate = certificate;
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1lineStorage
 * JD-Core Version:    0.6.1
 */