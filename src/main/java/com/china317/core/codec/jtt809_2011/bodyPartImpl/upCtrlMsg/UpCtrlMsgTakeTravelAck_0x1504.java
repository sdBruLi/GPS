/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpCtrlMsgTakeTravelAck_0x1504 extends UpCtrlMsgHead
/*    */ {
/*    */   private byte commandType;
/*    */   private int traveldataLength;
/*    */   private String traveldataInfo;
/*    */ 
/*    */   public byte getCommandType()
/*    */   {
/* 14 */     return this.commandType;
/*    */   }
/*    */ 
/*    */   public void setCommandType(byte commandType) {
/* 18 */     this.commandType = commandType;
/*    */   }
/*    */ 
/*    */   public int getTraveldataLength() {
/* 22 */     return this.traveldataLength;
/*    */   }
/*    */ 
/*    */   public void setTraveldataLength(int traveldataLength) {
/* 26 */     this.traveldataLength = traveldataLength;
/*    */   }
/*    */ 
/*    */   public String getTraveldataInfo() {
/* 30 */     return this.traveldataInfo;
/*    */   }
/*    */ 
/*    */   public void setTraveldataInfo(String traveldataInfo) {
/* 34 */     this.traveldataInfo = traveldataInfo;
/*    */   }
/*    */ 
/*    */   public UpCtrlMsgTakeTravelAck_0x1504()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpCtrlMsgTakeTravelAck_0x1504(int msgId) {
/* 42 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 47 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 48 */     parseFirstBody(buffer);
/* 49 */     setCommandType(buffer.get());
/* 50 */     setTraveldataLength(buffer.getInt());
/* 51 */     setTraveldataInfo(buffer.getString(getTraveldataLength(), Constants.CharsetDecoder_GBK));
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 56 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 57 */     byte[] content = ByteUtil.string2ByteArray(getTraveldataInfo(), "GBK");
/* 58 */     setTraveldataLength(content.length);
/* 59 */     setDataLength(5 + getTraveldataLength());
/* 60 */     buildFirstBody(buffer);
/* 61 */     buffer.put(getCommandType());
/* 62 */     buffer.putInt(getTraveldataLength());
/* 63 */     buffer.put(ByteUtil.string2ByteArray(getTraveldataInfo(), getTraveldataLength(), "GBK"));
/* 64 */     buffer.flip();
/* 65 */     byte[] bytes = new byte[buffer.remaining()];
/* 66 */     buffer.get(bytes);
/* 67 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 72 */     return 5380;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 76 */     return super.toString() + ",traveldataLength=" + this.traveldataLength + 
/* 77 */       ",traveldataInfo=" + this.traveldataInfo;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 81 */     UpCtrlMsgTakeTravelAck_0x1504 entity = new UpCtrlMsgTakeTravelAck_0x1504();
/* 82 */     entity.setVehicleNo("沪A3804");
/* 83 */     entity.setVehicleColor((byte)1);
/* 84 */     entity.setDataType(1);
/*    */ 
/* 87 */     entity.setTraveldataInfo("车辆行驶abc");
/*    */ 
/* 90 */     UpCtrlMsgTakeTravelAck_0x1504 entity2 = new UpCtrlMsgTakeTravelAck_0x1504();
/* 91 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg.UpCtrlMsgTakeTravelAck_0x1504
 * JD-Core Version:    0.6.1
 */