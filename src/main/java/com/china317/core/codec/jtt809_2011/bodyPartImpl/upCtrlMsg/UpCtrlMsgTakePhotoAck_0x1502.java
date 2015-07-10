/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg;
/*     */ 
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class UpCtrlMsgTakePhotoAck_0x1502 extends UpCtrlMsgHead
/*     */ {
/*     */   private byte photoRspFlag;
/*     */   private byte[] gnssData;
/*     */   private byte lensId;
/*     */   private int photoLen;
/*     */   private byte sizeType;
/*     */   private byte type;
/*     */   private byte[] photo;
/*     */ 
/*     */   public byte getPhotoRspFlag()
/*     */   {
/*  19 */     return this.photoRspFlag;
/*     */   }
/*     */ 
/*     */   public void setPhotoRspFlag(byte photoRspFlag) {
/*  23 */     this.photoRspFlag = photoRspFlag;
/*     */   }
/*     */ 
/*     */   public byte[] getGnssData() {
/*  27 */     return this.gnssData;
/*     */   }
/*     */ 
/*     */   public void setGnssData(byte[] gnssData) {
/*  31 */     this.gnssData = gnssData;
/*     */   }
/*     */ 
/*     */   public byte getLensId() {
/*  35 */     return this.lensId;
/*     */   }
/*     */ 
/*     */   public void setLensId(byte lensId) {
/*  39 */     this.lensId = lensId;
/*     */   }
/*     */ 
/*     */   public int getPhotoLen() {
/*  43 */     return this.photoLen;
/*     */   }
/*     */ 
/*     */   public void setPhotoLen(int photoLen) {
/*  47 */     this.photoLen = photoLen;
/*     */   }
/*     */ 
/*     */   public byte getSizeType() {
/*  51 */     return this.sizeType;
/*     */   }
/*     */ 
/*     */   public void setSizeType(byte sizeType) {
/*  55 */     this.sizeType = sizeType;
/*     */   }
/*     */ 
/*     */   public byte getType() {
/*  59 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(byte type) {
/*  63 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public byte[] getPhoto() {
/*  67 */     return this.photo;
/*     */   }
/*     */ 
/*     */   public void setPhoto(byte[] photo) {
/*  71 */     this.photo = photo;
/*     */   }
/*     */ 
/*     */   public UpCtrlMsgTakePhotoAck_0x1502()
/*     */   {
/*     */   }
/*     */ 
/*     */   public UpCtrlMsgTakePhotoAck_0x1502(int msgId) {
/*  79 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  84 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  85 */     parseFirstBody(buffer);
/*  86 */     setPhotoRspFlag(buffer.get());
/*  87 */     byte[] bytesGnss = new byte[36];
/*  88 */     buffer.get(bytesGnss);
/*  89 */     setGnssData(bytesGnss);
/*  90 */     setLensId(buffer.get());
/*  91 */     setPhotoLen(buffer.getInt());
/*  92 */     setSizeType(buffer.get());
/*  93 */     setType(buffer.get());
/*  94 */     byte[] bytesPhoto = new byte[getPhotoLen()];
/*  95 */     buffer.get(bytesPhoto);
/*  96 */     setPhoto(bytesPhoto);
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/* 101 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 102 */     byte[] content = getPhoto();
/* 103 */     setPhotoLen(content.length);
/* 104 */     setDataLength(44 + getPhotoLen());
/* 105 */     buildFirstBody(buffer);
/* 106 */     buffer.put(getPhotoRspFlag());
/* 107 */     if (this.gnssData != null) {
/* 108 */       buffer.put(getGnssData());
/*     */     } else {
/* 110 */       byte[] ds = new byte[36];
/* 111 */       buffer.put(ds);
/*     */     }
/* 113 */     buffer.put(getLensId());
/* 114 */     buffer.putInt(getPhotoLen());
/* 115 */     buffer.put(getSizeType());
/* 116 */     buffer.put(getType());
/* 117 */     if (getPhoto() != null) {
/* 118 */       buffer.put(getPhoto());
/*     */     }
/* 120 */     buffer.flip();
/* 121 */     byte[] bytes = new byte[buffer.remaining()];
/* 122 */     buffer.get(bytes);
/* 123 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/* 128 */     return 5378;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 132 */     return super.toString() + ",photoRspFlag=" + this.photoRspFlag + 
/* 133 */       ",gnssData=" + ByteUtil.byteArray2HexDump(this.gnssData) + ",lensId=" + this.lensId + 
/* 134 */       ",photoLen=" + this.photoLen + ",sizeType=" + this.sizeType + ",type=" + this.type + 
/* 135 */       ",photo=" + ByteUtil.byteArray2HexDump(this.photo);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 139 */     UpCtrlMsgTakePhotoAck_0x1502 entity = new UpCtrlMsgTakePhotoAck_0x1502();
/* 140 */     entity.setVehicleNo("沪A3804");
/* 141 */     entity.setVehicleColor((byte)1);
/* 142 */     entity.setDataType(1);
/*     */ 
/* 144 */     entity.setPhotoRspFlag((byte)0);
/* 145 */     entity.setGnssData(ByteUtil.string2ByteArray("上海浦东34路", 36, "GBK"));
/* 146 */     entity.setLensId((byte)1);
/*     */ 
/* 148 */     entity.setSizeType((byte)1);
/* 149 */     entity.setType((byte)1);
/* 150 */     entity.setPhoto(new byte[100]);
/*     */ 
/* 153 */     UpCtrlMsgTakePhotoAck_0x1502 entity2 = new UpCtrlMsgTakePhotoAck_0x1502();
/* 154 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg.UpCtrlMsgTakePhotoAck_0x1502
 * JD-Core Version:    0.6.1
 */