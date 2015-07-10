/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8701;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class SettingRunRecordMessage extends BaseDownMessage
/*    */ {
/*    */   private byte cmd;
/*    */   private IoBuffer dataBlock;
/*    */ 
/*    */   public SettingRunRecordMessage(String mobileNum, String messageKey, byte cmd, IoBuffer dataBuf)
/*    */   {
/* 30 */     setMobileNum(mobileNum);
/* 31 */     setMessageKey(messageKey);
/* 32 */     setCmd(cmd);
/* 33 */     setDataBlock(dataBuf);
/* 34 */     setCommand("0x8701");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 39 */     UnitPackJT808 pack = new UnitPackJT808(34561);
/* 40 */     pack.setMobileNum(getMobileNum());
/* 41 */     JT808MsgBody_0x8701 body = new JT808MsgBody_0x8701();
/* 42 */     body.setCommand(getCmd());
/* 43 */     body.setDataBlock(getDataBlock());
/* 44 */     pack.setMsgBody(body);
/* 45 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getCmd() {
/* 49 */     return this.cmd;
/*    */   }
/*    */ 
/*    */   public void setCmd(byte cmd)
/*    */   {
/* 54 */     this.cmd = cmd;
/*    */   }
/*    */ 
/*    */   public IoBuffer getDataBlock() {
/* 58 */     return this.dataBlock;
/*    */   }
/*    */ 
/*    */   public void setDataBlock(IoBuffer dataBlock)
/*    */   {
/* 63 */     this.dataBlock = dataBlock;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SettingRunRecordMessage
 * JD-Core Version:    0.6.1
 */