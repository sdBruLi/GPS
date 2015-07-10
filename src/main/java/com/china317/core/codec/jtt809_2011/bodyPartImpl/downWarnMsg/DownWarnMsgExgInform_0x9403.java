/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DownWarnMsgExgInform_0x9403 extends DownWarnMsgHead
/*     */ {
/*     */   private byte warnSrc;
/*     */   private short warnType;
/*     */   private long warnTime;
/*     */   private int warnLength;
/*     */   private String warnContent;
/*     */ 
/*     */   public int getWarnLength()
/*     */   {
/*  16 */     return this.warnLength;
/*     */   }
/*     */ 
/*     */   public void setWarnLength(int warnLength) {
/*  20 */     this.warnLength = warnLength;
/*     */   }
/*     */ 
/*     */   public String getWarnContent() {
/*  24 */     return this.warnContent;
/*     */   }
/*     */ 
/*     */   public void setWarnContent(String warnContent) {
/*  28 */     this.warnContent = warnContent;
/*     */   }
/*     */ 
/*     */   public byte getWarnSrc() {
/*  32 */     return this.warnSrc;
/*     */   }
/*     */ 
/*     */   public void setWarnSrc(byte warnSrc) {
/*  36 */     this.warnSrc = warnSrc;
/*     */   }
/*     */ 
/*     */   public short getWarnType() {
/*  40 */     return this.warnType;
/*     */   }
/*     */ 
/*     */   public void setWarnType(short warnType) {
/*  44 */     this.warnType = warnType;
/*     */   }
/*     */ 
/*     */   public long getWarnTime() {
/*  48 */     return this.warnTime;
/*     */   }
/*     */ 
/*     */   public void setWarnTime(long warnTime) {
/*  52 */     this.warnTime = warnTime;
/*     */   }
/*     */ 
/*     */   public DownWarnMsgExgInform_0x9403()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DownWarnMsgExgInform_0x9403(int msgId) {
/*  60 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  65 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  66 */     parseFirstBody(buffer);
/*     */ 
/*  70 */     setWarnLength(buffer.getInt());
/*  71 */     setWarnContent(buffer.getString(getWarnLength(), Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/*  76 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/*  77 */     byte[] content = ByteUtil.string2ByteArrayWithMaxSize(getWarnContent(), 1024, "GBK");
/*  78 */     setWarnLength(content.length);
/*  79 */     setDataLength(15 + getWarnLength());
/*  80 */     buildFirstBody(buffer);
/*     */ 
/*  84 */     buffer.putInt(getWarnLength());
/*  85 */     buffer.put(ByteUtil.string2ByteArray(getWarnContent(), getWarnLength(), "GBK"));
/*  86 */     buffer.flip();
/*  87 */     byte[] bytes = new byte[buffer.remaining()];
/*  88 */     buffer.get(bytes);
/*  89 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/*  94 */     return 37891;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  98 */     return super.toString() + ",warnLength=" + this.warnLength + 
/*  99 */       ",warnContent=" + this.warnContent;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 103 */     DownWarnMsgExgInform_0x9403 entity = new DownWarnMsgExgInform_0x9403();
/* 104 */     entity.setVehicleNo("沪A3804");
/* 105 */     entity.setVehicleColor((byte)1);
/* 106 */     entity.setDataType(1);
/*     */ 
/* 108 */     entity.setWarnSrc((byte)1);
/* 109 */     entity.setWarnType((short)1);
/* 110 */     entity.setWarnTime(1234567890123L);
/*     */ 
/* 112 */     entity.setWarnContent("警告信息abcd");
/*     */ 
/* 115 */     DownWarnMsgExgInform_0x9403 entity2 = new DownWarnMsgExgInform_0x9403();
/* 116 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg.DownWarnMsgExgInform_0x9403
 * JD-Core Version:    0.6.1
 */