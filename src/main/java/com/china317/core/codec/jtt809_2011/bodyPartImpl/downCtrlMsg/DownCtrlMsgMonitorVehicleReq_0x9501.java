/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DownCtrlMsgMonitorVehicleReq_0x9501 extends DownCtrlMsgHead
/*    */ {
/*    */   private String monitorTel;
/*    */ 
/*    */   public String getMonitorTel()
/*    */   {
/* 13 */     return this.monitorTel;
/*    */   }
/*    */ 
/*    */   public void setMonitorTel(String monitorTel) {
/* 17 */     this.monitorTel = monitorTel;
/*    */   }
/*    */ 
/*    */   public DownCtrlMsgMonitorVehicleReq_0x9501()
/*    */   {
/*    */   }
/*    */ 
/*    */   public DownCtrlMsgMonitorVehicleReq_0x9501(int msgId) {
/* 25 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 30 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 31 */     parseFirstBody(buffer);
/* 32 */     setMonitorTel(buffer.getString(20, Constants.CharsetDecoder_GBK));
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 37 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 38 */     setDataLength(20);
/* 39 */     buildFirstBody(buffer);
/* 40 */     buffer.put(ByteUtil.string2ByteArray(getMonitorTel(), 20, "GBK"));
/* 41 */     buffer.flip();
/* 42 */     byte[] bytes = new byte[buffer.remaining()];
/* 43 */     buffer.get(bytes);
/* 44 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 49 */     return 38145;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 53 */     return super.toString() + ",monitorTel=" + this.monitorTel;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 57 */     DownCtrlMsgMonitorVehicleReq_0x9501 entity = new DownCtrlMsgMonitorVehicleReq_0x9501();
/* 58 */     entity.setVehicleNo("沪A3804");
/* 59 */     entity.setVehicleColor((byte)1);
/* 60 */     entity.setDataType(1);
/*    */ 
/* 62 */     entity.setMonitorTel("02715566321-1023");
/*    */ 
/* 65 */     DownCtrlMsgMonitorVehicleReq_0x9501 entity2 = new DownCtrlMsgMonitorVehicleReq_0x9501();
/* 66 */     entity2.parseBody(entity.buildBody());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgMonitorVehicleReq_0x9501
 * JD-Core Version:    0.6.1
 */