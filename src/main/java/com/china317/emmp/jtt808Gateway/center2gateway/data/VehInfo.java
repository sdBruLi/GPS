/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class VehInfo
/*     */ {
/*     */   private String vehVIN;
/*     */   private String vehLicense;
/*     */   private String vehColor;
/*     */ 
/*     */   public void parse(byte[] datas)
/*     */   {
/*     */     try
/*     */     {
/*  14 */       byte[] vin = new byte[17];
/*  15 */       System.arraycopy(datas, 0, vin, 0, 17);
/*  16 */       this.vehVIN = new String(vin, "GBK");
/*     */ 
/*  18 */       byte[] licence = new byte[12];
/*  19 */       System.arraycopy(datas, 17, licence, 0, 12);
/*  20 */       this.vehLicense = new String(licence, "GBK");
/*     */ 
/*  22 */       byte[] color = new byte[8];
/*  23 */       System.arraycopy(datas, 29, color, 0, 8);
/*  24 */       this.vehColor = new String(color, "GBK");
/*     */     } catch (UnsupportedEncodingException e) {
/*  26 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public IoBuffer getBuffer()
/*     */   {
/*  32 */     IoBuffer buf = IoBuffer.allocate(3).setAutoExpand(true);
/*     */     try {
/*  34 */       byte[] dest = this.vehVIN.getBytes("GBK");
/*  35 */       byte[] dest2 = new byte[17];
/*  36 */       int length = 17;
/*  37 */       if (dest.length < 17) {
/*  38 */         length = dest.length;
/*     */       }
/*  40 */       System.arraycopy(dest, 0, dest2, 0, length);
/*  41 */       buf.put(dest2);
/*     */     } catch (UnsupportedEncodingException e) {
/*  43 */       e.printStackTrace();
/*     */     }
/*     */     try
/*     */     {
/*  47 */       byte[] dest = this.vehLicense.getBytes("GBK");
/*  48 */       byte[] dest2 = new byte[12];
/*  49 */       int length = 12;
/*  50 */       if (dest.length < 12) {
/*  51 */         length = dest.length;
/*     */       }
/*  53 */       System.arraycopy(dest, 0, dest2, 0, length);
/*  54 */       buf.put(dest2);
/*     */     } catch (UnsupportedEncodingException e) {
/*  56 */       e.printStackTrace();
/*     */     }
/*     */     try
/*     */     {
/*  60 */       byte[] dest = this.vehColor.getBytes("GBK");
/*  61 */       byte[] dest2 = new byte[8];
/*  62 */       int length = 8;
/*  63 */       if (dest.length < 8) {
/*  64 */         length = dest.length;
/*     */       }
/*  66 */       System.arraycopy(dest, 0, dest2, 0, length);
/*  67 */       buf.put(dest2);
/*     */     } catch (UnsupportedEncodingException e) {
/*  69 */       e.printStackTrace();
/*     */     }
/*  71 */     buf.flip();
/*  72 */     return buf;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  76 */     return "vehVIN : " + this.vehVIN.trim() + " vehLicense:" + this.vehLicense.trim() + " vehColor" + this.vehColor.trim();
/*     */   }
/*     */ 
/*     */   public String getVehVIN() {
/*  80 */     return this.vehVIN;
/*     */   }
/*     */ 
/*     */   public void setVehVIN(String vehVIN) {
/*  84 */     this.vehVIN = vehVIN;
/*     */   }
/*     */ 
/*     */   public String getVehLicense() {
/*  88 */     return this.vehLicense;
/*     */   }
/*     */ 
/*     */   public void setVehLicense(String vehLicense) {
/*  92 */     this.vehLicense = vehLicense;
/*     */   }
/*     */ 
/*     */   public String getVehColor() {
/*  96 */     return this.vehColor;
/*     */   }
/*     */ 
/*     */   public void setVehColor(String vehColor) {
/* 100 */     this.vehColor = vehColor;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.VehInfo
 * JD-Core Version:    0.6.1
 */