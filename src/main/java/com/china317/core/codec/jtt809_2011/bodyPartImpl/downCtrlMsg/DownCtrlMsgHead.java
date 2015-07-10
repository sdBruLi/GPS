/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public abstract class DownCtrlMsgHead extends DataPacketBodyPart
/*    */ {
/*    */   private String vehicleNo;
/*    */   private byte vehicleColor;
/*    */   private int dataLength;
/*    */ 
/*    */   public String getVehicleNo()
/*    */   {
/* 17 */     return this.vehicleNo;
/*    */   }
/*    */ 
/*    */   public void setVehicleNo(String vehicleNo) {
/* 21 */     this.vehicleNo = vehicleNo;
/*    */   }
/*    */ 
/*    */   public byte getVehicleColor() {
/* 25 */     return this.vehicleColor;
/*    */   }
/*    */ 
/*    */   public void setVehicleColor(byte vehicleColor) {
/* 29 */     this.vehicleColor = vehicleColor;
/*    */   }
/*    */ 
/*    */   public int getDataLength()
/*    */   {
/* 41 */     return this.dataLength;
/*    */   }
/*    */ 
/*    */   public void setDataLength(int dataLength) {
/* 45 */     this.dataLength = dataLength;
/*    */   }
/*    */ 
/*    */   public void parseFirstBody(IoBuffer buffer) throws Exception {
/* 49 */     setVehicleNo(buffer.getString(21, Constants.CharsetDecoder_GBK));
/* 50 */     setVehicleColor(buffer.get());
/* 51 */     setDataType(buffer.getShort() & 0xFFFF);
/* 52 */     setDataLength(buffer.getInt());
/*    */   }
/*    */ 
/*    */   public void buildFirstBody(IoBuffer buffer) {
/* 56 */     buffer.put(ByteUtil.string2ByteArray(getVehicleNo(), 21, "GBK"));
/* 57 */     buffer.put(getVehicleColor());
/* 58 */     buffer.putShort(getDataType());
/* 59 */     buffer.putInt(getDataLength());
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 63 */     return super.toString() + ",vehicleNo=" + this.vehicleNo + 
/* 64 */       ",vehicleColor=" + this.vehicleColor + 
/* 65 */       ",dataType=" + getDataType() + 
/* 66 */       ",dataLength=" + this.dataLength;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgHead
 * JD-Core Version:    0.6.1
 */