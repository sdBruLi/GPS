/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DriverCodeLicenseNum
/*    */ {
/*    */   private int driverCode;
/*    */   private String licenseNum;
/*    */ 
/*    */   public int getDriverCode()
/*    */   {
/* 12 */     return this.driverCode;
/*    */   }
/*    */   public void setDriverCode(int driverCode) {
/* 15 */     this.driverCode = driverCode;
/*    */   }
/*    */   public String getLicenseNum() {
/* 18 */     return this.licenseNum;
/*    */   }
/*    */   public void setLicenseNum(String licenseNum) {
/* 21 */     this.licenseNum = licenseNum;
/*    */   }
/*    */ 
/*    */   public void parse(byte[] datas) {
/* 25 */     this.driverCode = (((datas[0] & 0xFF) << 16) + ((datas[1] & 0xFF) << 8) + (datas[2] & 0xFF));
/* 26 */     byte[] dests = new byte[datas.length - 3];
/* 27 */     System.arraycopy(datas, 3, dests, 0, dests.length);
/*    */     try {
/* 29 */       this.licenseNum = new String(dests, "GBK");
/*    */     } catch (UnsupportedEncodingException e) {
/* 31 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public IoBuffer getBuffer() {
/* 36 */     IoBuffer buf = IoBuffer.allocate(3).setAutoExpand(true);
/* 37 */     buf.put((byte)(this.driverCode >> 16 & 0xFF));
/* 38 */     buf.put((byte)(this.driverCode >> 8 & 0xFF));
/* 39 */     buf.put((byte)(this.driverCode & 0xFF));
/*    */     try {
/* 41 */       byte[] dest = this.licenseNum.getBytes("GBK");
/* 42 */       byte[] dest2 = new byte[18];
/* 43 */       int length = 18;
/* 44 */       if (dest.length < 18) {
/* 45 */         length = dest.length;
/*    */       }
/* 47 */       System.arraycopy(dest, 0, dest2, 0, length);
/* 48 */       buf.put(dest2);
/*    */     } catch (UnsupportedEncodingException e) {
/* 50 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 53 */     buf.flip();
/* 54 */     return buf;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 58 */     return "driverCode : " + this.driverCode + " licenceNum:" + this.licenseNum;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.DriverCodeLicenseNum
 * JD-Core Version:    0.6.1
 */