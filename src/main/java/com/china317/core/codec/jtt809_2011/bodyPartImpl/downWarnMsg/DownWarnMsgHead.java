/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public abstract class DownWarnMsgHead extends DataPacketBodyPart
/*    */ {
/*    */   private String vehicleNo;
/*    */   private byte vehicleColor;
/*    */   private int dataLength;
/*    */   private byte warnSrc;
/*    */   private short warnType;
/*    */   private long warnTime;
/*    */ 
/*    */   public String getVehicleNo()
/*    */   {
/* 20 */     return this.vehicleNo;
/*    */   }
/*    */ 
/*    */   public void setVehicleNo(String vehicleNo) {
/* 24 */     this.vehicleNo = vehicleNo;
/*    */   }
/*    */ 
/*    */   public byte getVehicleColor() {
/* 28 */     return this.vehicleColor;
/*    */   }
/*    */ 
/*    */   public void setVehicleColor(byte vehicleColor) {
/* 32 */     this.vehicleColor = vehicleColor;
/*    */   }
/*    */ 
/*    */   public int getDataLength()
/*    */   {
/* 44 */     return this.dataLength;
/*    */   }
/*    */ 
/*    */   public void setDataLength(int dataLength) {
/* 48 */     this.dataLength = dataLength;
/*    */   }
/*    */ 
/*    */   public byte getWarnSrc() {
/* 52 */     return this.warnSrc;
/*    */   }
/*    */ 
/*    */   public void setWarnSrc(byte warnSrc) {
/* 56 */     this.warnSrc = warnSrc;
/*    */   }
/*    */ 
/*    */   public short getWarnType() {
/* 60 */     return this.warnType;
/*    */   }
/*    */ 
/*    */   public void setWarnType(short warnType) {
/* 64 */     this.warnType = warnType;
/*    */   }
/*    */ 
/*    */   public long getWarnTime() {
/* 68 */     return this.warnTime;
/*    */   }
/*    */ 
/*    */   public void setWarnTime(long warnTime) {
/* 72 */     this.warnTime = warnTime;
/*    */   }
/*    */ 
/*    */   public void parseFirstBody(IoBuffer buffer) throws Exception {
/* 76 */     setVehicleNo(buffer.getString(21, Constants.CharsetDecoder_GBK));
/* 77 */     setVehicleColor(buffer.get());
/* 78 */     setDataType(buffer.getShort() & 0xFFFF);
/* 79 */     setDataLength(buffer.getInt());
/* 80 */     setWarnSrc(buffer.get());
/* 81 */     setWarnType(buffer.getShort());
/* 82 */     setWarnTime(buffer.getLong());
/*    */   }
/*    */ 
/*    */   public void buildFirstBody(IoBuffer buffer) {
/* 86 */     buffer.put(ByteUtil.string2ByteArray(getVehicleNo(), 21, "GBK"));
/* 87 */     buffer.put(getVehicleColor());
/* 88 */     buffer.putShort(getDataType());
/* 89 */     buffer.putInt(getDataLength());
/* 90 */     buffer.put(getWarnSrc());
/* 91 */     buffer.putShort(getWarnType());
/* 92 */     buffer.putLong(getWarnTime());
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 96 */     return super.toString() + ",vehicleNo=" + this.vehicleNo + 
/* 97 */       ",vehicleColor=" + this.vehicleColor + ",dataType=" + getDataType() + 
/* 98 */       ",dataLength=" + this.dataLength + ",warnSrc=" + this.warnSrc + 
/* 99 */       ",warnType=" + this.warnType + ",warnTime=" + this.warnTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg.DownWarnMsgHead
 * JD-Core Version:    0.6.1
 */