/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8701;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class DriverRecordParam extends BaseDownMessage
/*    */ {
/*    */   private byte parm_command;
/*    */   private IoBuffer dataBlock;
/*    */ 
/*    */   public DriverRecordParam(String mobileNum, String messageKey, byte command, IoBuffer dataBlock)
/*    */   {
/* 26 */     setMobileNum(mobileNum);
/* 27 */     setMessageKey(messageKey);
/* 28 */     setParm_command(command);
/* 29 */     setDataBlock(dataBlock);
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 34 */     UnitPackJT808 pack = new UnitPackJT808(34561);
/* 35 */     pack.setMobileNum(getMobileNum());
/* 36 */     JT808MsgBody_0x8701 body = new JT808MsgBody_0x8701();
/* 37 */     body.setCommand(getParm_command());
/* 38 */     body.setDataBlock(this.dataBlock);
/* 39 */     pack.setMsgBody(body);
/* 40 */     return pack;
/*    */   }
/*    */ 
/*    */   public IoBuffer getDataBlock() {
/* 44 */     return this.dataBlock;
/*    */   }
/*    */ 
/*    */   public void setDataBlock(IoBuffer dataBlock) {
/* 48 */     this.dataBlock = dataBlock;
/*    */   }
/*    */ 
/*    */   public byte getParm_command() {
/* 52 */     return this.parm_command;
/*    */   }
/*    */ 
/*    */   public void setParm_command(byte parm_command) {
/* 56 */     this.parm_command = parm_command;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.DriverRecordParam
 * JD-Core Version:    0.6.1
 */