/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upWarnMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class UpWarnMsgAdptInfo_0x1402 extends UpWarnMsgHead
/*     */ {
/*     */   private byte warnSrc;
/*     */   private short warnType;
/*     */   private long warnTime;
/*     */   private int infoId;
/*     */   private int infoLength;
/*     */   private String infoContent;
/*     */ 
/*     */   public byte getWarnSrc()
/*     */   {
/*  19 */     return this.warnSrc;
/*     */   }
/*     */ 
/*     */   public void setWarnSrc(byte warnSrc) {
/*  23 */     this.warnSrc = warnSrc;
/*     */   }
/*     */ 
/*     */   public short getWarnType() {
/*  27 */     return this.warnType;
/*     */   }
/*     */ 
/*     */   public void setWarnType(short warnType) {
/*  31 */     this.warnType = warnType;
/*     */   }
/*     */ 
/*     */   public long getWarnTime() {
/*  35 */     return this.warnTime;
/*     */   }
/*     */ 
/*     */   public void setWarnTime(long warnTime) {
/*  39 */     this.warnTime = warnTime;
/*     */   }
/*     */ 
/*     */   public int getInfoId() {
/*  43 */     return this.infoId;
/*     */   }
/*     */ 
/*     */   public void setInfoId(int infoId) {
/*  47 */     this.infoId = infoId;
/*     */   }
/*     */ 
/*     */   public int getInfoLength() {
/*  51 */     return this.infoLength;
/*     */   }
/*     */ 
/*     */   public void setInfoLength(int infoLength) {
/*  55 */     this.infoLength = infoLength;
/*     */   }
/*     */ 
/*     */   public String getInfoContent() {
/*  59 */     return this.infoContent;
/*     */   }
/*     */ 
/*     */   public void setInfoContent(String infoContent) {
/*  63 */     this.infoContent = infoContent;
/*     */   }
/*     */ 
/*     */   public UpWarnMsgAdptInfo_0x1402()
/*     */   {
/*     */   }
/*     */ 
/*     */   public UpWarnMsgAdptInfo_0x1402(int msgId) {
/*  71 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  76 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  77 */     parseFirstBody(buffer);
/*  78 */     setWarnSrc(buffer.get());
/*  79 */     setWarnType(buffer.getShort());
/*  80 */     setWarnTime(buffer.getLong());
/*  81 */     setInfoId(buffer.getInt());
/*  82 */     setInfoLength(buffer.getInt());
/*  83 */     setInfoContent(buffer.getString(getInfoLength(), Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/*  88 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  89 */     byte[] content = ByteUtil.string2ByteArrayWithMaxSize(getInfoContent(), 1024, "GBK");
/*  90 */     setInfoLength(content.length);
/*  91 */     setDataLength(19 + getInfoLength());
/*  92 */     buildFirstBody(buffer);
/*  93 */     buffer.put(getWarnSrc());
/*  94 */     buffer.putShort(getWarnType());
/*  95 */     buffer.putLong(getWarnTime());
/*  96 */     buffer.putInt(getInfoId());
/*  97 */     buffer.putInt(getInfoLength());
/*  98 */     buffer.put(ByteUtil.string2ByteArray(getInfoContent(), getInfoLength(), "GBK"));
/*  99 */     buffer.flip();
/* 100 */     byte[] bytes = new byte[buffer.remaining()];
/* 101 */     buffer.get(bytes);
/* 102 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/* 107 */     return 5122;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 111 */     return super.toString() + ",warnSrc=" + this.warnSrc + 
/* 112 */       ",warnType=" + this.warnType + ",warnTime=" + this.warnTime + 
/* 113 */       ",infoId=" + this.infoId + ",infoLength=" + this.infoLength + 
/* 114 */       ",infoContent=" + this.infoContent;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 118 */     UpWarnMsgAdptInfo_0x1402 entity = new UpWarnMsgAdptInfo_0x1402();
/* 119 */     entity.setVehicleNo("沪A3804");
/* 120 */     entity.setVehicleColor((byte)1);
/* 121 */     entity.setDataType(1);
/*     */ 
/* 123 */     entity.setWarnSrc((byte)1);
/* 124 */     entity.setWarnType((short)1);
/* 125 */     entity.setWarnTime(1234567890123L);
/* 126 */     entity.setInfoId(1);
/*     */ 
/* 128 */     entity.setInfoContent("信息abcd");
/*     */ 
/* 131 */     UpWarnMsgAdptInfo_0x1402 entity2 = new UpWarnMsgAdptInfo_0x1402();
/* 132 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upWarnMsg.UpWarnMsgAdptInfo_0x1402
 * JD-Core Version:    0.6.1
 */