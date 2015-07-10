/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8105 extends JT808MsgBody
/*    */ {
/*    */   public static final byte COMMAND_UPLOAD = 1;
/*    */   public static final byte COMMAND_CONNECT_1SERVER = 2;
/*    */   public static final byte COMMAND_TEMINAL_SHUTDOWN = 3;
/*    */   public static final byte COMMAND_TEMINAL_RESTORATION = 4;
/*    */   public static final byte COMMAND_TEMINAL_RESET_2FACTORY_DEF = 5;
/*    */   public static final byte COMMAND_SHUTDOWN_DATA_COMMUNICATION = 6;
/*    */   public static final byte COMMAND_SHUTDOWN_ALL_COMMUNICATION = 7;
/*    */   private byte command;
/* 22 */   private String commandParam = "";
/*    */   private IoBuffer commandParamIo;
/*    */ 
/*    */   public IoBuffer getCommandParamIo()
/*    */   {
/* 26 */     return this.commandParamIo;
/*    */   }
/*    */ 
/*    */   public void setCommandParamIo(IoBuffer commandParamIo) {
/* 30 */     this.commandParamIo = commandParamIo;
/*    */   }
/*    */ 
/*    */   public void bulidBody() throws Exception
/*    */   {
/* 35 */     if (!isBuildBody()) {
/* 36 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 37 */       this.bodyBuffer.put(this.command);
/* 38 */       if ((this.commandParam != null) && (this.commandParam.length() > 0)) {
/* 39 */         this.bodyBuffer.put(this.commandParam.getBytes("GBK"));
/*    */       }
/* 41 */       else if (this.commandParamIo != null) {
/* 42 */         byte[] a = new byte[this.commandParamIo.limit()];
/* 43 */         this.commandParamIo.get(a);
/* 44 */         this.bodyBuffer.put(a);
/*    */       }
/*    */ 
/* 47 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 53 */     this.command = this.bodyBuffer.get();
/* 54 */     this.commandParam = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 55 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 teminalControl(String mobileNum, byte command, String commandParam) throws Exception {
/* 59 */     UnitPackJT808 pack = new UnitPackJT808(33029);
/* 60 */     pack.setMobileNum(mobileNum);
/* 61 */     JT808MsgBody_0x8105 body = new JT808MsgBody_0x8105();
/* 62 */     body.setCommand(command);
/* 63 */     body.setCommandParam(commandParam);
/* 64 */     pack.setMsgBody(body);
/* 65 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getCommand() {
/* 69 */     return this.command;
/*    */   }
/*    */ 
/*    */   public void setCommand(byte command) {
/* 73 */     this.command = command;
/*    */   }
/*    */ 
/*    */   public String getCommandParam() {
/* 77 */     return this.commandParam;
/*    */   }
/*    */ 
/*    */   public void setCommandParam(String commandParam) {
/* 81 */     this.commandParam = commandParam;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8105
 * JD-Core Version:    0.6.1
 */