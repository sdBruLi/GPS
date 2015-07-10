/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downPlatformMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DownPlatformMsgInfoReq_0x9302 extends DownPlatformMsgHead
/*     */ {
/*     */   private byte objectType;
/*     */   private String objectId;
/*     */   private int infoId;
/*     */   private int infoLength;
/*     */   private String infoContent;
/*     */ 
/*     */   public int getInfoId()
/*     */   {
/*  16 */     return this.infoId;
/*     */   }
/*     */ 
/*     */   public void setInfoId(int infoId) {
/*  20 */     this.infoId = infoId;
/*     */   }
/*     */ 
/*     */   public int getInfoLength() {
/*  24 */     return this.infoLength;
/*     */   }
/*     */ 
/*     */   public void setInfoLength(int infoLength) {
/*  28 */     this.infoLength = infoLength;
/*     */   }
/*     */ 
/*     */   public String getInfoContent() {
/*  32 */     return this.infoContent;
/*     */   }
/*     */ 
/*     */   public void setInfoContent(String infoContent) {
/*  36 */     this.infoContent = infoContent;
/*     */   }
/*     */ 
/*     */   public byte getObjectType() {
/*  40 */     return this.objectType;
/*     */   }
/*     */ 
/*     */   public void setObjectType(byte objectType) {
/*  44 */     this.objectType = objectType;
/*     */   }
/*     */ 
/*     */   public String getObjectId() {
/*  48 */     return this.objectId;
/*     */   }
/*     */ 
/*     */   public void setObjectId(String objectId) {
/*  52 */     this.objectId = objectId;
/*     */   }
/*     */ 
/*     */   public DownPlatformMsgInfoReq_0x9302()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DownPlatformMsgInfoReq_0x9302(int msgId) {
/*  60 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  65 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  66 */     parseFirstBody(buffer);
/*  67 */     setObjectType(buffer.get());
/*  68 */     setObjectId(buffer.getString(12, Constants.CharsetDecoder_GBK));
/*  69 */     setInfoId(buffer.getInt());
/*  70 */     setInfoLength(buffer.getInt());
/*  71 */     setInfoContent(buffer.getString(getInfoLength(), Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/*  76 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  77 */     byte[] content = ByteUtil.string2ByteArray(getInfoContent(), "GBK");
/*  78 */     setInfoLength(content.length);
/*  79 */     setDataLength(21 + getInfoLength());
/*  80 */     buildFirstBody(buffer);
/*  81 */     buffer.put(getObjectType());
/*  82 */     buffer.put(ByteUtil.string2ByteArray(getObjectId(), 12, "GBK"));
/*  83 */     buffer.putInt(getInfoId());
/*  84 */     buffer.putInt(getInfoLength());
/*  85 */     buffer.put(ByteUtil.string2ByteArray(getInfoContent(), getInfoLength(), "GBK"));
/*  86 */     buffer.flip();
/*  87 */     byte[] bytes = new byte[buffer.remaining()];
/*  88 */     buffer.get(bytes);
/*  89 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/*  94 */     return 37634;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  98 */     return super.toString() + ",infoId=" + this.infoId + ",infoLength=" + this.infoLength + 
/*  99 */       ",infoContent=" + this.infoContent;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 103 */     DownPlatformMsgPostQueryReq_0x9301 entity = new DownPlatformMsgPostQueryReq_0x9301();
/* 104 */     entity.setDataType(1);
/*     */ 
/* 106 */     entity.setInfoId(1);
/*     */ 
/* 108 */     entity.setInfoContent("平台信息abc");
/*     */ 
/* 111 */     DownPlatformMsgPostQueryReq_0x9301 entity2 = new DownPlatformMsgPostQueryReq_0x9301();
/* 112 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downPlatformMsg.DownPlatformMsgInfoReq_0x9302
 * JD-Core Version:    0.6.1
 */