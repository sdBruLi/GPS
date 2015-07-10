/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DownWarnMsgInformTips_0x9402 extends DownWarnMsgHead
/*     */ {
/*     */   private byte warnSrc;
/*     */   private short warnType;
/*     */   private long warnTime;
/*     */   private int warnLength;
/*     */   private String warnContent;
/*     */ 
/*     */   public int getWarnLength()
/*     */   {
/*  17 */     return this.warnLength;
/*     */   }
/*     */ 
/*     */   public void setWarnLength(int warnLength) {
/*  21 */     this.warnLength = warnLength;
/*     */   }
/*     */ 
/*     */   public String getWarnContent() {
/*  25 */     return this.warnContent;
/*     */   }
/*     */ 
/*     */   public void setWarnContent(String warnContent) {
/*  29 */     this.warnContent = warnContent;
/*     */   }
/*     */ 
/*     */   public byte getWarnSrc() {
/*  33 */     return this.warnSrc;
/*     */   }
/*     */ 
/*     */   public void setWarnSrc(byte warnSrc) {
/*  37 */     this.warnSrc = warnSrc;
/*     */   }
/*     */ 
/*     */   public short getWarnType() {
/*  41 */     return this.warnType;
/*     */   }
/*     */ 
/*     */   public void setWarnType(short warnType) {
/*  45 */     this.warnType = warnType;
/*     */   }
/*     */ 
/*     */   public long getWarnTime() {
/*  49 */     return this.warnTime;
/*     */   }
/*     */ 
/*     */   public void setWarnTime(long warnTime) {
/*  53 */     this.warnTime = warnTime;
/*     */   }
/*     */ 
/*     */   public DownWarnMsgInformTips_0x9402()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DownWarnMsgInformTips_0x9402(int msgId) {
/*  61 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  66 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  67 */     parseFirstBody(buffer);
/*     */ 
/*  71 */     setWarnLength(buffer.getInt());
/*  72 */     setWarnContent(buffer.getString(getWarnLength(), Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/*  77 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/*  78 */     byte[] content = ByteUtil.string2ByteArrayWithMaxSize(getWarnContent(), 1024, "GBK");
/*  79 */     setWarnLength(content.length);
/*  80 */     setDataLength(15 + getWarnLength());
/*  81 */     buildFirstBody(buffer);
/*     */ 
/*  85 */     buffer.putInt(getWarnLength());
/*  86 */     buffer.put(ByteUtil.string2ByteArray(getWarnContent(), getWarnLength(), "GBK"));
/*  87 */     buffer.flip();
/*  88 */     byte[] bytes = new byte[buffer.remaining()];
/*  89 */     buffer.get(bytes);
/*  90 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/*  95 */     return 37890;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  99 */     return super.toString() + ",warnLength=" + this.warnLength + 
/* 100 */       ",warnContent=" + this.warnContent;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 104 */     DownWarnMsgInformTips_0x9402 entity = new DownWarnMsgInformTips_0x9402();
/* 105 */     entity.setVehicleNo("沪A3804");
/* 106 */     entity.setVehicleColor((byte)1);
/* 107 */     entity.setDataType(1);
/*     */ 
/* 109 */     entity.setWarnSrc((byte)1);
/* 110 */     entity.setWarnType((short)1);
/* 111 */     entity.setWarnTime(1234567890123L);
/*     */ 
/* 113 */     entity.setWarnContent("警告信息abc");
/*     */ 
/* 116 */     DownWarnMsgInformTips_0x9402 entity2 = new DownWarnMsgInformTips_0x9402();
/* 117 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg.DownWarnMsgInformTips_0x9402
 * JD-Core Version:    0.6.1
 */