/*    */ package com.china317.core.codec.jtt809_2011;
/*    */ 
/*    */ public class CodecConfig
/*    */ {
/*    */   private int defaultDataPacketLength;
/*    */   private int maxDataPacketLength;
/*    */   private boolean encryptEnable;
/*    */   private long encryptKey;
/*    */   private long encryptM1;
/*    */   private long encryptIA1;
/*    */   private long encryptIC1;
/*    */   private byte versionFlag_1;
/*    */   private byte versionFlag_2;
/*    */   private byte versionFlag_3;
/*    */ 
/*    */   public CodecConfig()
/*    */   {
/* 18 */     this.defaultDataPacketLength = 10240;
/* 19 */     this.maxDataPacketLength = 33554432;
/* 20 */     this.encryptEnable = false;
/* 21 */     this.encryptKey = 1L;
/* 22 */     this.encryptM1 = 1L;
/* 23 */     this.encryptIA1 = 1L;
/* 24 */     this.encryptIC1 = 1L;
/*    */   }
/*    */   public CodecConfig(boolean encryptEnable, long encryptKey, long encryptM1, long encryptIA1, long encryptIC1) {
/* 27 */     this.encryptEnable = encryptEnable;
/* 28 */     this.encryptKey = encryptKey;
/* 29 */     this.encryptM1 = encryptM1;
/* 30 */     this.encryptIA1 = encryptIA1;
/* 31 */     this.encryptIC1 = encryptIC1;
/*    */   }
/*    */ 
/*    */   public int getDefaultDataPacketLength() {
/* 35 */     return this.defaultDataPacketLength;
/*    */   }
/*    */   public void setDefaultDataPacketLength(int defaultDataPacketLength) {
/* 38 */     this.defaultDataPacketLength = defaultDataPacketLength;
/*    */   }
/*    */   public int getMaxDataPacketLength() {
/* 41 */     return this.maxDataPacketLength;
/*    */   }
/*    */   public void setMaxDataPacketLength(int maxDataPacketLength) {
/* 44 */     this.maxDataPacketLength = maxDataPacketLength;
/*    */   }
/*    */   public boolean isEncryptEnable() {
/* 47 */     return this.encryptEnable;
/*    */   }
/*    */   public void setEncryptEnable(boolean encryptEnable) {
/* 50 */     this.encryptEnable = encryptEnable;
/*    */   }
/*    */   public long getEncryptKey() {
/* 53 */     return this.encryptKey;
/*    */   }
/*    */   public void setEncryptKey(long encryptKey) {
/* 56 */     this.encryptKey = encryptKey;
/*    */   }
/*    */   public long getEncryptM1() {
/* 59 */     return this.encryptM1;
/*    */   }
/*    */   public void setEncryptM1(long encryptM1) {
/* 62 */     this.encryptM1 = encryptM1;
/*    */   }
/*    */   public long getEncryptIA1() {
/* 65 */     return this.encryptIA1;
/*    */   }
/*    */   public void setEncryptIA1(long encryptIA1) {
/* 68 */     this.encryptIA1 = encryptIA1;
/*    */   }
/*    */   public long getEncryptIC1() {
/* 71 */     return this.encryptIC1;
/*    */   }
/*    */   public void setEncryptIC1(long encryptIC1) {
/* 74 */     this.encryptIC1 = encryptIC1;
/*    */   }
/*    */   public byte getVersionFlag_1() {
/* 77 */     return this.versionFlag_1;
/*    */   }
/*    */ 
/*    */   public byte getVersionFlag_2()
/*    */   {
/* 82 */     return this.versionFlag_2;
/*    */   }
/*    */ 
/*    */   public byte getVersionFlag_3()
/*    */   {
/* 87 */     return this.versionFlag_3;
/*    */   }
/*    */ 
/*    */   public void setVersionFlag(byte versionFlag_1, byte versionFlag_2, byte versionFlag_3) {
/* 91 */     this.versionFlag_1 = versionFlag_1;
/* 92 */     this.versionFlag_2 = versionFlag_2;
/* 93 */     this.versionFlag_3 = versionFlag_3;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.CodecConfig
 * JD-Core Version:    0.6.1
 */