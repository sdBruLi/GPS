/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class UpExgMsgRegister_0x1201 extends UpExgMsgHead
/*     */ {
/*     */   private byte[] platformId;
/*     */   private byte[] producerId;
/*     */   private byte[] terminalModelType;
/*     */   private byte[] terminalId;
/*     */   private String terminalSimcode;
/*     */ 
/*     */   public UpExgMsgRegister_0x1201()
/*     */   {
/*     */   }
/*     */ 
/*     */   public UpExgMsgRegister_0x1201(int msgId)
/*     */   {
/*  12 */     super.setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public byte[] buildBody() throws Exception
/*     */   {
/*  17 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  18 */     setDatalength(61);
/*  19 */     buildFirstBody(buffer);
/*     */ 
/*  21 */     buffer.put(getPlatformId());
/*  22 */     buffer.put(getProducerId());
/*  23 */     buffer.put(getTerminalModelType());
/*  24 */     buffer.put(getTerminalId());
/*  25 */     buffer.put(ByteUtil.string2ByteArray(getFormattedSim(getTerminalSimcode()), 12, "GBK"));
/*  26 */     buffer.flip();
/*  27 */     byte[] bytes = new byte[buffer.remaining()];
/*  28 */     buffer.get(bytes);
/*  29 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/*  34 */     return 4609;
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  39 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  40 */     parseFirstBody(buffer);
/*     */ 
/*  42 */     initBytes();
/*     */ 
/*  44 */     buffer.get(this.platformId);
/*  45 */     buffer.get(this.producerId);
/*  46 */     buffer.get(this.terminalModelType);
/*  47 */     buffer.get(this.terminalId);
/*  48 */     setTerminalSimcode(buffer.getString(12, Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] getPlatformId()
/*     */   {
/*  59 */     return this.platformId;
/*     */   }
/*     */ 
/*     */   public void setPlatformId(byte[] platformId) {
/*  63 */     this.platformId = platformId;
/*     */   }
/*     */ 
/*     */   public byte[] getProducerId() {
/*  67 */     return this.producerId;
/*     */   }
/*     */ 
/*     */   public void setProducerId(byte[] producerId) {
/*  71 */     this.producerId = producerId;
/*     */   }
/*     */ 
/*     */   public byte[] getTerminalModelType() {
/*  75 */     return this.terminalModelType;
/*     */   }
/*     */ 
/*     */   public void setTerminalModelType(byte[] terminalModelType) {
/*  79 */     this.terminalModelType = terminalModelType;
/*     */   }
/*     */ 
/*     */   public byte[] getTerminalId() {
/*  83 */     return this.terminalId;
/*     */   }
/*     */ 
/*     */   public void setTerminalId(byte[] terminalId) {
/*  87 */     this.terminalId = terminalId;
/*     */   }
/*     */ 
/*     */   public String getTerminalSimcode() {
/*  91 */     return this.terminalSimcode;
/*     */   }
/*     */ 
/*     */   public void setTerminalSimcode(String terminalSimcode) {
/*  95 */     this.terminalSimcode = terminalSimcode;
/*     */   }
/*     */ 
/*     */   private String getFormattedSim(String sim) {
/*  99 */     int len = 12 - sim.length();
/* 100 */     String line = "";
/* 101 */     for (int i = 0; i < len; i++) {
/* 102 */       line = line + "0";
/*     */     }
/* 104 */     return line + sim;
/*     */   }
/*     */ 
/*     */   private byte[] getFormattedType1(byte[] terminalModelType)
/*     */   {
/* 119 */     if (terminalModelType.length < 8) {
/* 120 */       byte[] returnValue = new byte[8];
/* 121 */       int index = 0;
/* 122 */       for (int i = 0; i < terminalModelType.length; i++) {
/* 123 */         returnValue[(index++)] = terminalModelType[i];
/*     */       }
/* 125 */       returnValue[index] = 0;
/*     */ 
/* 127 */       return returnValue;
/* 128 */     }if (terminalModelType.length == 8) {
/* 129 */       return terminalModelType;
/*     */     }
/*     */ 
/* 132 */     return terminalModelType;
/*     */   }
/*     */ 
/*     */   private void initBytes()
/*     */   {
/* 137 */     this.platformId = new byte[11];
/* 138 */     this.producerId = new byte[11];
/* 139 */     this.terminalId = new byte[7];
/* 140 */     this.terminalModelType = new byte[20];
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgRegister_0x1201
 * JD-Core Version:    0.6.1
 */