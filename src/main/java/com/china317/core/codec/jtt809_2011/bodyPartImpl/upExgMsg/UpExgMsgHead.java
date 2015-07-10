/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public abstract class UpExgMsgHead extends DataPacketBodyPart
/*    */ {
/*    */   private String vehicleNo;
/*    */   private byte vehicleColor;
/*    */   private int datalength;
/*    */ 
/*    */   public UpExgMsgHead()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpExgMsgHead(int dataType)
/*    */   {
/* 19 */     setDataType(dataType);
/*    */   }
/*    */ 
/*    */   public String getVehicleNo() {
/* 23 */     return this.vehicleNo;
/*    */   }
/*    */ 
/*    */   public void setVehicleNo(String vehicleNo) {
/* 27 */     this.vehicleNo = vehicleNo;
/*    */   }
/*    */ 
/*    */   public byte getVehicleColor() {
/* 31 */     return this.vehicleColor;
/*    */   }
/*    */ 
/*    */   public void setVehicleColor(byte vehicleColor) {
/* 35 */     this.vehicleColor = vehicleColor;
/*    */   }
/*    */ 
/*    */   public int getDatalength()
/*    */   {
/* 47 */     return this.datalength;
/*    */   }
/*    */ 
/*    */   public void setDatalength(int datalength) {
/* 51 */     this.datalength = datalength;
/*    */   }
/*    */ 
/*    */   public void buildFirstBody(IoBuffer buffer) {
/* 55 */     buffer.put(ByteUtil.string2ByteArray(getVehicleNo(), 21, "GBK"));
/* 56 */     buffer.put(getVehicleColor());
/* 57 */     buffer.putShort(getDataType());
/* 58 */     buffer.putInt(getDatalength());
/*    */   }
/*    */ 
/*    */   public void parseFirstBody(IoBuffer buffer) throws CharacterCodingException {
/* 62 */     setVehicleNo(buffer.getString(21, Constants.CharsetDecoder_GBK));
/* 63 */     setVehicleColor(buffer.get());
/* 64 */     setDataType(buffer.getShort() & 0xFFFF);
/* 65 */     setDatalength(buffer.getInt());
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 69 */     return super.toString() + ",vehicleNo=" + this.vehicleNo + 
/* 70 */       ",vehicleColor=" + this.vehicleColor + ",dataType=" + getDataType() + 
/* 71 */       ",dataLength=" + this.datalength;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgHead
 * JD-Core Version:    0.6.1
 */