/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8105;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class TerminalControlMessage extends BaseDownMessage
/*    */ {
/*    */   public static final byte COMMAND_UPLOAD = 1;
/*    */   public static final byte COMMAND_CONNECT_1SERVER = 2;
/*    */   public static final byte COMMAND_TEMINAL_SHUTDOWN = 3;
/*    */   public static final byte COMMAND_TEMINAL_RESTORATION = 4;
/*    */   public static final byte COMMAND_TEMINAL_RESET_2FACTORY_DEF = 5;
/*    */   public static final byte COMMAND_SHUTDOWN_DATA_COMMUNICATION = 6;
/*    */   public static final byte COMMAND_SHUTDOWN_ALL_COMMUNICATION = 7;
/*    */   private byte command1;
/*    */   private String commandParam;
/*    */   private IoBuffer commandParamIo;
/*    */ 
/*    */   public TerminalControlMessage(String mobileNum, String messageKey, byte command, String commandParam, IoBuffer commandParamIo)
/*    */   {
/* 37 */     setMobileNum(mobileNum);
/* 38 */     setMessageKey(messageKey);
/* 39 */     setCommand1(command);
/* 40 */     setCommandParam(commandParam);
/* 41 */     setCommandParamIo(commandParamIo);
/* 42 */     setCommand("0x8105");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 47 */     UnitPackJT808 pack = new UnitPackJT808(33029);
/* 48 */     pack.setMobileNum(getMobileNum());
/* 49 */     JT808MsgBody_0x8105 body = new JT808MsgBody_0x8105();
/* 50 */     body.setCommand(getCommand1());
/* 51 */     body.setCommandParam(getCommandParam());
/* 52 */     body.setCommandParamIo(getCommandParamIo());
/* 53 */     pack.setMsgBody(body);
/* 54 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getCommand1() {
/* 58 */     return this.command1;
/*    */   }
/*    */ 
/*    */   public void setCommand1(byte command)
/*    */   {
/* 63 */     this.command1 = command;
/*    */   }
/*    */ 
/*    */   public String getCommandParam() {
/* 67 */     return this.commandParam;
/*    */   }
/*    */ 
/*    */   public void setCommandParam(String commandParam)
/*    */   {
/* 72 */     this.commandParam = commandParam;
/*    */   }
/*    */ 
/*    */   public IoBuffer getCommandParamIo() {
/* 76 */     return this.commandParamIo;
/*    */   }
/*    */ 
/*    */   public void setCommandParamIo(IoBuffer commandParamIo) {
/* 80 */     this.commandParamIo = commandParamIo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TerminalControlMessage
 * JD-Core Version:    0.6.1
 */