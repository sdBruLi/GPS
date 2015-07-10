/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upPlatformMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class UpPlatformMsgPostQueryAck_0x1301 extends UpPlatformMsgHead
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
/*     */   public UpPlatformMsgPostQueryAck_0x1301()
/*     */   {
/*     */   }
/*     */ 
/*     */   public UpPlatformMsgPostQueryAck_0x1301(int msgId) {
/*  44 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  49 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  50 */     parseFirstBody(buffer);
/*  51 */     setObjectType(buffer.get());
/*  52 */     setObjectId(buffer.getString(12, Constants.CharsetDecoder_GBK));
/*  53 */     setInfoId(buffer.getInt() & 0xFFFFFFFF);
/*  54 */     setInfoLength(buffer.getInt());
/*  55 */     setInfoContent(buffer.getString(getInfoLength(), Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/*  60 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  61 */     byte[] content = ByteUtil.string2ByteArray(getInfoContent(), "GBK");
/*  62 */     setInfoLength(content.length);
/*  63 */     setDataLength(21 + getInfoLength());
/*  64 */     buildFirstBody(buffer);
/*  65 */     buffer.put(getObjectType());
/*  66 */     buffer.put(ByteUtil.string2ByteArray(getObjectId(), 12, "GBK"));
/*  67 */     buffer.putInt(getInfoId() & 0xFFFFFFFF);
/*  68 */     buffer.putInt(getInfoLength());
/*  69 */     buffer.put(ByteUtil.string2ByteArray(getInfoContent(), getInfoLength(), "GBK"));
/*  70 */     buffer.flip();
/*  71 */     byte[] bytes = new byte[buffer.remaining()];
/*  72 */     buffer.get(bytes);
/*  73 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/*  78 */     return 4865;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  82 */     return super.toString() + ",infoId=" + this.infoId + ",infoLength=" + this.infoLength + 
/*  83 */       ",infoContent=" + this.infoContent;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/*  87 */     UpPlatformMsgPostQueryAck_0x1301 entity = new UpPlatformMsgPostQueryAck_0x1301();
/*  88 */     entity.setDataType(1);
/*     */ 
/*  90 */     entity.setInfoId(1);
/*     */ 
/*  92 */     entity.setInfoContent("平台信息abc");
/*     */ 
/*  95 */     UpPlatformMsgPostQueryAck_0x1301 entity2 = new UpPlatformMsgPostQueryAck_0x1301();
/*  96 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ 
/*     */   public byte getObjectType()
/*     */   {
/* 101 */     return this.objectType;
/*     */   }
/*     */ 
/*     */   public void setObjectType(byte objectType) {
/* 105 */     this.objectType = objectType;
/*     */   }
/*     */ 
/*     */   public String getObjectId() {
/* 109 */     return this.objectId;
/*     */   }
/*     */ 
/*     */   public void setObjectId(String objectId) {
/* 113 */     this.objectId = objectId;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upPlatformMsg.UpPlatformMsgPostQueryAck_0x1301
 * JD-Core Version:    0.6.1
 */