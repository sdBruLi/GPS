/*     */ package com.china317.core.codec.jtt809_2011;
/*     */ 
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DataPacketHeadPart
/*     */ {
/*     */   private long msgLength;
/*     */   private long msgSN;
/*     */   private int msgId;
/*     */   private int msgGnssCenterId;
/*     */   private byte versionFlag_1;
/*     */   private byte versionFlag_2;
/*     */   private byte versionFlag_3;
/*     */   private String versionFlag;
/*     */   private boolean encryptFlag;
/*     */   private long encryptKey;
/*     */ 
/*     */   public long getMsgLength()
/*     */   {
/*  20 */     return this.msgLength;
/*     */   }
/*     */   void setMsgLength(long msgLength) {
/*  23 */     this.msgLength = msgLength;
/*     */   }
/*     */   public long getMsgSN() {
/*  26 */     return this.msgSN;
/*     */   }
/*     */   public void setMsgSN(long msgSN) {
/*  29 */     this.msgSN = msgSN;
/*     */   }
/*     */   public int getMsgId() {
/*  32 */     return this.msgId;
/*     */   }
/*     */   void setMsgId(int msgId) {
/*  35 */     this.msgId = msgId;
/*     */   }
/*     */   public int getMsgGnssCenterId() {
/*  38 */     return this.msgGnssCenterId;
/*     */   }
/*     */   public void setMsgGnssCenterId(int msgGnssCenterId) {
/*  41 */     this.msgGnssCenterId = msgGnssCenterId;
/*     */   }
/*     */   public String getVersionFlag() {
/*  44 */     return this.versionFlag;
/*     */   }
/*     */   public void setVersionFlag(byte versionFlag_1, byte versionFlag_2, byte versionFlag_3) {
/*  47 */     this.versionFlag_1 = versionFlag_1;
/*  48 */     this.versionFlag_2 = versionFlag_2;
/*  49 */     this.versionFlag_3 = versionFlag_3;
/*  50 */     this.versionFlag = (versionFlag_1 + "." + versionFlag_2 + "." + versionFlag_3);
/*     */   }
/*     */   public boolean isEncryptFlag() {
/*  53 */     return this.encryptFlag;
/*     */   }
/*     */   public void setEncryptFlag(boolean encryptFlag) {
/*  56 */     this.encryptFlag = encryptFlag;
/*     */   }
/*     */   public long getEncryptKey() {
/*  59 */     return this.encryptKey;
/*     */   }
/*     */   public void setEncryptKey(long encryptKey) {
/*  62 */     this.encryptKey = encryptKey;
/*     */   }
/*     */   public DataPacketHeadPart() {
/*  65 */     this.versionFlag = ("V" + this.versionFlag_1 + "." + this.versionFlag_2 + "." + this.versionFlag_3);
/*     */   }
/*     */ 
/*     */   public void parseHead(IoBuffer input) {
/*  69 */     setMsgLength(input.getUnsignedInt());
/*  70 */     setMsgSN(input.getUnsignedInt());
/*  71 */     setMsgId(input.getUnsignedShort());
/*  72 */     setMsgGnssCenterId(input.getInt());
/*  73 */     setVersionFlag(input.get(), input.get(), input.get());
/*  74 */     setEncryptFlag(input.getUnsigned() == 1);
/*  75 */     setEncryptKey(input.getUnsignedInt());
/*     */   }
/*     */   public static void main(String[] args) {
/*  78 */     IoBuffer buf = IoBuffer.allocate(1).setAutoExpand(true);
/*  79 */     byte[] byts = { 0, 0, 0, 26, 0, 0, 0, 0, 16, 5, 0, 0, 4, -59, 0, 0, 0, 0, 0, 0, 0, 1, 63, 66 };
/*  80 */     buf.put(byts);
/*  81 */     buf.flip();
/*  82 */     DataPacketHeadPart head = new DataPacketHeadPart();
/*  83 */     head.parseHead(buf);
/*     */   }
/*     */   public byte[] buildHead() {
/*  86 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  87 */     buffer.putUnsignedInt(this.msgLength);
/*  88 */     buffer.putUnsignedInt(this.msgSN);
/*  89 */     buffer.putUnsignedShort(this.msgId);
/*  90 */     buffer.putUnsignedInt(this.msgGnssCenterId);
/*  91 */     buffer.put(this.versionFlag_1);
/*  92 */     buffer.put(this.versionFlag_2);
/*  93 */     buffer.put(this.versionFlag_3);
/*  94 */     buffer.putUnsigned(this.encryptFlag ? 1 : 0);
/*  95 */     buffer.putUnsignedInt(this.encryptKey);
/*  96 */     buffer.flip();
/*  97 */     byte[] bytes = new byte[buffer.remaining()];
/*  98 */     buffer.get(bytes);
/*  99 */     return bytes;
/*     */   }
/*     */   public String toString() {
/* 102 */     return "msgLength=" + this.msgLength + ",msgSN=" + this.msgSN + ",msgId=" + this.msgId + ",msgGnssCenterId=" + this.msgGnssCenterId + ",versionFlag=" + getVersionFlag() + ",encryptFlag=" + this.encryptFlag + ",encryptKey=" + this.encryptKey;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.DataPacketHeadPart
 * JD-Core Version:    0.6.1
 */