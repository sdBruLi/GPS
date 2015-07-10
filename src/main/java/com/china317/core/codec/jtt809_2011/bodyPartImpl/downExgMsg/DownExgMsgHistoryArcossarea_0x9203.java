/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownExgMsgHistoryArcossarea_0x9203 extends DownExgMsgHead
/*    */ {
/*    */   private byte gnssCnt;
/*    */   private DownExgMsgCarLocation_0x9202[] realLocations;
/*    */ 
/*    */   public DownExgMsgHistoryArcossarea_0x9203()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownExgMsgHistoryArcossarea_0x9203(int msgId)
/*    */   {
/* 12 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception
/*    */   {
/* 17 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 18 */     int dataLen = 1;
/*    */ 
/* 20 */     if (this.realLocations != null) {
/* 21 */       dataLen += this.realLocations.length * 36;
/*    */     }
/* 23 */     setDatalength(dataLen);
/*    */ 
/* 25 */     buildFirstBody(buffer);
/* 26 */     buffer.put(this.gnssCnt);
/* 27 */     for (DownExgMsgCarLocation_0x9202 d : this.realLocations) {
/* 28 */       buffer.put(d.buildLocationBuffer());
/*    */     }
/*    */ 
/* 43 */     buffer.flip();
/* 44 */     byte[] bytes = new byte[buffer.remaining()];
/* 45 */     buffer.get(bytes);
/* 46 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 52 */     return 37379;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 57 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 58 */     parseFirstBody(buffer);
/*    */ 
/* 60 */     parseLocationBody(buffer);
/*    */   }
/*    */ 
/*    */   public void parseLocationBody(IoBuffer buffer)
/*    */   {
/* 66 */     setGnssCnt(buffer.get());
/* 67 */     this.realLocations = new DownExgMsgCarLocation_0x9202[getGnssCnt()];
/*    */ 
/* 69 */     for (int i = 0; i < getGnssCnt(); i++) {
/* 70 */       DownExgMsgCarLocation_0x9202 entity = new DownExgMsgCarLocation_0x9202();
/* 71 */       entity.parseLocationBody(buffer);
/* 72 */       entity.setVehicleNo(getVehicleNo());
/* 73 */       entity.setVehicleColor(getVehicleColor());
/* 74 */       entity.setDataType(getDataType());
/*    */ 
/* 76 */       this.realLocations[i] = entity;
/*    */     }
/*    */   }
/*    */ 
/*    */   public byte getGnssCnt()
/*    */   {
/* 86 */     return this.gnssCnt;
/*    */   }
/*    */ 
/*    */   public void setGnssCnt(byte gnssCnt) {
/* 90 */     this.gnssCnt = gnssCnt;
/*    */   }
/*    */ 
/*    */   public DownExgMsgCarLocation_0x9202[] getRealLocations() {
/* 94 */     return this.realLocations;
/*    */   }
/*    */ 
/*    */   public void setRealLocations(DownExgMsgCarLocation_0x9202[] realLocations) {
/* 98 */     this.realLocations = realLocations;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgHistoryArcossarea_0x9203
 * JD-Core Version:    0.6.1
 */