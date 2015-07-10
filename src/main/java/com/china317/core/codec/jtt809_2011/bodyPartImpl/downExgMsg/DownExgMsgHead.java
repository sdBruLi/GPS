/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public abstract class DownExgMsgHead extends DataPacketBodyPart
/*    */ {
/*    */   private String vehicleNo;
/*    */   private byte vehicleColor;
/*    */   private int datalength;
/*    */ 
/*    */   public String getVehicleNo()
/*    */   {
/* 18 */     return this.vehicleNo;
/*    */   }
/*    */ 
/*    */   public void setVehicleNo(String vehicleNo) {
/* 22 */     this.vehicleNo = vehicleNo;
/*    */   }
/*    */ 
/*    */   public byte getVehicleColor() {
/* 26 */     return this.vehicleColor;
/*    */   }
/*    */ 
/*    */   public void setVehicleColor(byte vehicleColor) {
/* 30 */     this.vehicleColor = vehicleColor;
/*    */   }
/*    */ 
/*    */   public int getDatalength()
/*    */   {
/* 42 */     return this.datalength;
/*    */   }
/*    */ 
/*    */   public void setDatalength(int datalength) {
/* 46 */     this.datalength = datalength;
/*    */   }
/*    */ 
/*    */   public void buildFirstBody(IoBuffer buffer) {
/* 50 */     buffer.put(ByteUtil.string2ByteArray(getVehicleNo(), 21, "GBK"));
/* 51 */     buffer.put(getVehicleColor());
/* 52 */     buffer.putShort(getDataType());
/* 53 */     buffer.putInt(getDatalength());
/*    */   }
/*    */ 
/*    */   public void parseFirstBody(IoBuffer buffer) throws CharacterCodingException {
/* 57 */     setVehicleNo(buffer.getString(21, Constants.CharsetDecoder_GBK));
/* 58 */     setVehicleColor(buffer.get());
/* 59 */     setDataType(buffer.getShort() & 0xFFFF);
/* 60 */     setDatalength(buffer.getInt());
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 64 */     return super.toString() + ",vehicleNo=" + this.vehicleNo + 
/* 65 */       ",vehicleColor=" + this.vehicleColor + 
/* 66 */       ",dataType=" + getDataType() + 
/* 67 */       ",dataLength=" + this.datalength;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgHead
 * JD-Core Version:    0.6.1
 */