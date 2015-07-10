/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upBaseMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class UpBaseMsgVehicleAddedAck_0x1601 extends DataPacketBodyPart
/*     */ {
/*     */   private String vehicleNo;
/*     */   private byte vehicleColor;
/*     */   private int dataLength;
/*     */   private String carInfo;
/*     */ 
/*     */   public void parseFirstBody(IoBuffer buffer)
/*     */     throws Exception
/*     */   {
/*  19 */     setVehicleNo(buffer.getString(21, Constants.CharsetDecoder_GBK));
/*  20 */     setVehicleColor(buffer.get());
/*  21 */     setDataType(buffer.getShort() & 0xFFFF);
/*  22 */     setDataLength(buffer.getInt());
/*     */   }
/*     */ 
/*     */   public void buildFirstBody(IoBuffer buffer) {
/*  26 */     buffer.put(ByteUtil.string2ByteArray(getVehicleNo(), 21, "GBK"));
/*  27 */     buffer.put(getVehicleColor());
/*  28 */     buffer.putShort(getDataType());
/*  29 */     buffer.putInt(getDataLength());
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  34 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  35 */     parseFirstBody(buffer);
/*  36 */     setCarInfo(buffer.getString(getDataLength(), Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/*  42 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/*  43 */     byte[] carDatas = (byte[])null;
/*  44 */     if ((getCarInfo() != null) && (!"".equals(getCarInfo())))
/*     */       try
/*     */       {
/*  47 */         carDatas = getCarInfo().getBytes("GBK");
/*  48 */         setDataLength(carDatas.length);
/*     */       } catch (UnsupportedEncodingException e) {
/*  50 */         e.printStackTrace();
/*     */       }
/*     */     else {
/*  53 */       setDataLength(0);
/*     */     }
/*  55 */     buildFirstBody(buffer);
/*  56 */     if (carDatas != null)
/*  57 */       buffer.put(carDatas);
/*  58 */     buffer.flip();
/*  59 */     byte[] bytes = new byte[buffer.remaining()];
/*  60 */     buffer.get(bytes);
/*  61 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/*  66 */     return 5633;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  70 */     return super.toString() + ",vehicleNo=" + this.vehicleNo + 
/*  71 */       ",vehicleColor=" + this.vehicleColor + ",dataType=" + getDataType() + 
/*  72 */       ",dataLength=" + this.dataLength;
/*     */   }
/*     */ 
/*     */   public String getVehicleNo() {
/*  76 */     return this.vehicleNo;
/*     */   }
/*     */ 
/*     */   public void setVehicleNo(String vehicleNo) {
/*  80 */     this.vehicleNo = vehicleNo;
/*     */   }
/*     */ 
/*     */   public byte getVehicleColor() {
/*  84 */     return this.vehicleColor;
/*     */   }
/*     */ 
/*     */   public void setVehicleColor(byte vehicleColor) {
/*  88 */     this.vehicleColor = vehicleColor;
/*     */   }
/*     */ 
/*     */   public int getDataLength() {
/*  92 */     return this.dataLength;
/*     */   }
/*     */ 
/*     */   public void setDataLength(int dataLength) {
/*  96 */     this.dataLength = dataLength;
/*     */   }
/*     */ 
/*     */   public String getCarInfo() {
/* 100 */     return this.carInfo;
/*     */   }
/*     */ 
/*     */   public void setCarInfo(String carInfo) {
/* 104 */     this.carInfo = carInfo;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upBaseMsg.UpBaseMsgVehicleAddedAck_0x1601
 * JD-Core Version:    0.6.1
 */