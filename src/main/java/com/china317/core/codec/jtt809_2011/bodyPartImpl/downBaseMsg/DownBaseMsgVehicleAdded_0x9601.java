/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downBaseMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownBaseMsgVehicleAdded_0x9601 extends DataPacketBodyPart
/*    */ {
/*    */   private String vehicleNo;
/*    */   private byte vehicleColor;
/*    */   private int dataLength;
/*    */ 
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/* 18 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 19 */     parseFirstBody(buffer);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 24 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 25 */     buildFirstBody(buffer);
/* 26 */     buffer.flip();
/* 27 */     byte[] bytes = new byte[buffer.remaining()];
/* 28 */     buffer.get(bytes);
/* 29 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 34 */     return 38401;
/*    */   }
/*    */ 
/*    */   public void parseFirstBody(IoBuffer buffer) throws Exception {
/* 38 */     setVehicleNo(buffer.getString(21, Constants.CharsetDecoder_GBK));
/* 39 */     setVehicleColor(buffer.get());
/* 40 */     setDataType(buffer.getShort() & 0xFFFF);
/* 41 */     setDataLength(buffer.getInt());
/*    */   }
/*    */ 
/*    */   public void buildFirstBody(IoBuffer buffer) {
/* 45 */     buffer.put(ByteUtil.string2ByteArray(getVehicleNo(), 21, "GBK"));
/* 46 */     buffer.put(getVehicleColor());
/* 47 */     buffer.putShort(getDataType());
/* 48 */     buffer.putInt(getDataLength());
/*    */   }
/*    */   public String getVehicleNo() {
/* 51 */     return this.vehicleNo;
/*    */   }
/*    */ 
/*    */   public void setVehicleNo(String vehicleNo) {
/* 55 */     this.vehicleNo = vehicleNo;
/*    */   }
/*    */ 
/*    */   public byte getVehicleColor() {
/* 59 */     return this.vehicleColor;
/*    */   }
/*    */ 
/*    */   public void setVehicleColor(byte vehicleColor) {
/* 63 */     this.vehicleColor = vehicleColor;
/*    */   }
/*    */ 
/*    */   public int getDataLength() {
/* 67 */     return this.dataLength;
/*    */   }
/*    */ 
/*    */   public void setDataLength(int dataLength) {
/* 71 */     this.dataLength = dataLength;
/*    */   }
/*    */   public String toString() {
/* 74 */     return super.toString() + ",vehicleNo=" + this.vehicleNo + 
/* 75 */       ",vehicleColor=" + this.vehicleColor + ",dataType=" + getDataType() + 
/* 76 */       ",dataLength=" + this.dataLength;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downBaseMsg.DownBaseMsgVehicleAdded_0x9601
 * JD-Core Version:    0.6.1
 */