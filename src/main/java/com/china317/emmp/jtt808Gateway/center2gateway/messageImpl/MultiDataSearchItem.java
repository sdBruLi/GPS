/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ public class MultiDataSearchItem
/*    */ {
/*    */   private int multimediaID;
/*    */   private byte multimediaType;
/*    */   private byte channelID;
/*    */   private byte eventItemCoding;
/*    */   private PositionMessage gpsData;
/*    */ 
/*    */   public byte getChannelID()
/*    */   {
/* 12 */     return this.channelID;
/*    */   }
/*    */ 
/*    */   public void setChannelID(byte channelID) {
/* 16 */     this.channelID = channelID;
/*    */   }
/*    */ 
/*    */   public int getMultimediaID() {
/* 20 */     return this.multimediaID;
/*    */   }
/*    */ 
/*    */   public void setMultimediaID(int multimediaID) {
/* 24 */     this.multimediaID = multimediaID;
/*    */   }
/*    */ 
/*    */   public byte getMultimediaType() {
/* 28 */     return this.multimediaType;
/*    */   }
/*    */ 
/*    */   public void setMultimediaType(byte multimediaType) {
/* 32 */     this.multimediaType = multimediaType;
/*    */   }
/*    */ 
/*    */   public byte getEventItemCoding() {
/* 36 */     return this.eventItemCoding;
/*    */   }
/*    */ 
/*    */   public void setEventItemCoding(byte eventItemCoding) {
/* 40 */     this.eventItemCoding = eventItemCoding;
/*    */   }
/*    */ 
/*    */   public PositionMessage getGpsData() {
/* 44 */     return this.gpsData;
/*    */   }
/*    */ 
/*    */   public void setGpsData(PositionMessage gpsData) {
/* 48 */     this.gpsData = gpsData;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.MultiDataSearchItem
 * JD-Core Version:    0.6.1
 */