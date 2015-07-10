/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg;
/*     */ 
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class UpExgMsgHistoryLocation_0x1203 extends UpExgMsgHead
/*     */ {
/*     */   private byte gnssCnt;
/*     */   private UpExgMsgRealLocation_0x1202[] realLocations;
/*     */ 
/*     */   public UpExgMsgHistoryLocation_0x1203()
/*     */   {
/*     */   }
/*     */ 
/*     */   public UpExgMsgHistoryLocation_0x1203(int msgId)
/*     */   {
/*  11 */     super.setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public byte[] buildBody() throws Exception
/*     */   {
/*  16 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  17 */     if (this.realLocations != null) {
/*  18 */       setDatalength(36 * this.realLocations.length);
/*     */     }
/*  20 */     buildFirstBody(buffer);
/*     */ 
/*  34 */     buildLocationBody(buffer);
/*  35 */     buffer.flip();
/*  36 */     byte[] bytes = new byte[buffer.remaining()];
/*  37 */     buffer.get(bytes);
/*  38 */     return bytes;
/*     */   }
/*     */ 
/*     */   private void buildLocationBody(IoBuffer buffer) {
/*  42 */     buffer.put(this.gnssCnt);
/*  43 */     if (this.realLocations != null)
/*  44 */       for (UpExgMsgRealLocation_0x1202 l : this.realLocations)
/*  45 */         buffer.put(l.buildGnssBody());
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/*  52 */     return 4611;
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  57 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  58 */     parseFirstBody(buffer);
/*     */ 
/*  60 */     parseLocationBody(buffer);
/*     */   }
/*     */ 
/*     */   public void parseLocationBody(IoBuffer buffer)
/*     */   {
/*  66 */     initBytes();
/*     */ 
/*  68 */     setGnssCnt(buffer.get());
/*  69 */     this.realLocations = new UpExgMsgRealLocation_0x1202[getGnssCnt()];
/*     */ 
/*  71 */     for (int i = 0; i < getGnssCnt(); i++) {
/*  72 */       UpExgMsgRealLocation_0x1202 entity = new UpExgMsgRealLocation_0x1202();
/*  73 */       entity.parseLocationBody(buffer);
/*  74 */       entity.setVehicleNo(getVehicleNo());
/*  75 */       entity.setVehicleColor(getVehicleColor());
/*  76 */       entity.setDataType(getDataType());
/*     */ 
/*  78 */       this.realLocations[i] = entity;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initBytes()
/*     */   {
/*     */   }
/*     */ 
/*     */   public byte getGnssCnt()
/*     */   {
/*  91 */     return this.gnssCnt;
/*     */   }
/*     */ 
/*     */   public void setGnssCnt(byte gnssCnt) {
/*  95 */     this.gnssCnt = gnssCnt;
/*     */   }
/*     */ 
/*     */   public UpExgMsgRealLocation_0x1202[] getRealLocations() {
/*  99 */     return this.realLocations;
/*     */   }
/*     */ 
/*     */   public void setRealLocations(UpExgMsgRealLocation_0x1202[] realLocations) {
/* 103 */     this.realLocations = realLocations;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgHistoryLocation_0x1203
 * JD-Core Version:    0.6.1
 */