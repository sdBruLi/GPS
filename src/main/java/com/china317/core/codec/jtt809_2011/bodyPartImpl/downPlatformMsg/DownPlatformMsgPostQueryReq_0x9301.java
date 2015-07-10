/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downPlatformMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DownPlatformMsgPostQueryReq_0x9301 extends DownPlatformMsgHead
/*     */ {
/*     */   private byte objectType;
/*     */   private String objectId;
/*     */   private int infoId;
/*     */   private int infoLength;
/*     */   private String infoContent;
/*     */ 
/*     */   public int getInfoId()
/*     */   {
/*  17 */     return this.infoId;
/*     */   }
/*     */ 
/*     */   public void setInfoId(int infoId) {
/*  21 */     this.infoId = infoId;
/*     */   }
/*     */ 
/*     */   public int getInfoLength() {
/*  25 */     return this.infoLength;
/*     */   }
/*     */ 
/*     */   public void setInfoLength(int infoLength) {
/*  29 */     this.infoLength = infoLength;
/*     */   }
/*     */ 
/*     */   public String getInfoContent() {
/*  33 */     return this.infoContent;
/*     */   }
/*     */ 
/*     */   public void setInfoContent(String infoContent) {
/*  37 */     this.infoContent = infoContent;
/*     */   }
/*     */ 
/*     */   public byte getObjectType() {
/*  41 */     return this.objectType;
/*     */   }
/*     */ 
/*     */   public void setObjectType(byte objectType) {
/*  45 */     this.objectType = objectType;
/*     */   }
/*     */ 
/*     */   public String getObjectId() {
/*  49 */     return this.objectId;
/*     */   }
/*     */ 
/*     */   public void setObjectId(String objectId) {
/*  53 */     this.objectId = objectId;
/*     */   }
/*     */ 
/*     */   public DownPlatformMsgPostQueryReq_0x9301()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DownPlatformMsgPostQueryReq_0x9301(int msgId) {
/*  61 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  66 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  67 */     parseFirstBody(buffer);
/*  68 */     setObjectType(buffer.get());
/*  69 */     setObjectId(buffer.getString(12, Constants.CharsetDecoder_GBK));
/*  70 */     setInfoId(buffer.getInt());
/*  71 */     setInfoLength(buffer.getInt());
/*  72 */     setInfoContent(buffer.getString(getInfoLength(), Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/*  77 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  78 */     byte[] content = ByteUtil.string2ByteArray(getInfoContent(), "GBK");
/*  79 */     setInfoLength(content.length);
/*  80 */     setDataLength(21 + getInfoLength());
/*  81 */     buildFirstBody(buffer);
/*  82 */     buffer.put(getObjectType());
/*  83 */     buffer.put(ByteUtil.string2ByteArray(getObjectId(), 12, "GBK"));
/*  84 */     buffer.putInt(getInfoId());
/*  85 */     buffer.putInt(getInfoLength());
/*  86 */     buffer.put(ByteUtil.string2ByteArray(getInfoContent(), getInfoLength(), "GBK"));
/*  87 */     buffer.flip();
/*  88 */     byte[] bytes = new byte[buffer.remaining()];
/*  89 */     buffer.get(bytes);
/*  90 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/*  95 */     return 37633;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  99 */     return super.toString() + ",infoId=" + this.infoId + ",infoLength=" + this.infoLength + 
/* 100 */       ",infoContent=" + this.infoContent;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 104 */     DownPlatformMsgPostQueryReq_0x9301 entity = new DownPlatformMsgPostQueryReq_0x9301();
/* 105 */     entity.setDataType(1);
/*     */ 
/* 107 */     entity.setInfoId(1);
/*     */ 
/* 109 */     entity.setInfoContent("平台信息abc");
/*     */ 
/* 112 */     DownPlatformMsgPostQueryReq_0x9301 entity2 = new DownPlatformMsgPostQueryReq_0x9301();
/* 113 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downPlatformMsg.DownPlatformMsgPostQueryReq_0x9301
 * JD-Core Version:    0.6.1
 */