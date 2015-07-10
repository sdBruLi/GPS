/*     */ package com.china317.core.codec.jtt808Gateway;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class GatewayUnitPack
/*     */ {
/*     */   public static final byte SIGN_BYTE_0 = -86;
/*     */   public static final byte SIGN_BYTE_1 = -18;
/*  10 */   private IoBuffer packetBuffer = null;
/*  11 */   private int CMD = 0;
/*  12 */   private int msgBodyLength = 0;
/*  13 */   private int sequenceNum = 0;
/*     */   private GatewayBody msgBody;
/*     */   private IoBuffer msgBodyBuffer;
/*  17 */   private boolean CRCResult = false;
/*     */   public static final int USAGE_BUILD = 0;
/*     */   public static final int USAGE_PARSE = 1;
/*  20 */   private int createUsage = 0;
/*     */ 
/*     */   public static GatewayUnitPack createParseEntity() {
/*  23 */     GatewayUnitPack entity = new GatewayUnitPack();
/*  24 */     entity.createUsage = 1;
/*  25 */     return entity;
/*     */   }
/*     */ 
/*     */   private GatewayUnitPack() {
/*     */   }
/*     */ 
/*     */   public GatewayUnitPack(int cmd) {
/*  32 */     setCMD(cmd);
/*     */   }
/*     */ 
/*     */   public GatewayUnitPack(int cmd, int sequenceNum) {
/*  36 */     setCMD(cmd);
/*  37 */     setSequenceNum(sequenceNum);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/*     */   }
/*     */ 
/*     */   public IoBuffer getPacketBuffer() {
/*  44 */     return this.packetBuffer;
/*     */   }
/*     */ 
/*     */   public void setPacketBuffer(IoBuffer packetBuffer) {
/*  48 */     this.packetBuffer = packetBuffer;
/*     */   }
/*     */ 
/*     */   public int getMsgBodyLength() {
/*  52 */     if (isParseEntity())
/*  53 */       return this.msgBodyLength;
/*  54 */     if (this.msgBodyBuffer != null)
/*  55 */       return this.msgBodyBuffer.limit();
/*  56 */     if ((this.msgBody != null) && (this.msgBody.getBodyBuffer() != null)) {
/*  57 */       return this.msgBody.getBodyBuffer().limit();
/*     */     }
/*  59 */     return 0;
/*     */   }
/*     */ 
/*     */   public void setMsgBodyLength(int msgBodyLength)
/*     */   {
/*  64 */     this.msgBodyLength = msgBodyLength;
/*     */   }
/*     */ 
/*     */   public int getSequenceNum() {
/*  68 */     return this.sequenceNum;
/*     */   }
/*     */ 
/*     */   public void setSequenceNum(int sequenceNum) {
/*  72 */     this.sequenceNum = sequenceNum;
/*     */   }
/*     */ 
/*     */   public GatewayBody getMsgBody() {
/*  76 */     return this.msgBody;
/*     */   }
/*     */ 
/*     */   public IoBuffer getMsgBodyBuffer() {
/*  80 */     if (this.msgBodyBuffer != null)
/*  81 */       return this.msgBodyBuffer;
/*  82 */     if (this.msgBody != null) {
/*  83 */       return this.msgBody.getBodyBuffer();
/*     */     }
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMsgBody(GatewayBody msgBody) throws Exception
/*     */   {
/*  90 */     this.msgBody = msgBody;
/*  91 */     if (!isParseEntity())
/*     */     {
/*  93 */       if (!this.msgBody.isBuildBody())
/*     */       {
/*  95 */         this.msgBody.bulidBody();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setMsgBody(IoBuffer msgBodyBuff) {
/* 101 */     this.msgBodyBuffer = msgBodyBuff;
/*     */   }
/*     */ 
/*     */   public void setMsgBody(byte[] msgBodybytes) {
/* 105 */     setMsgBody(IoBuffer.wrap(msgBodybytes));
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 110 */     StringBuffer str = new StringBuffer();
/* 111 */     str.append("CMD=").append(Integer.toHexString(this.CMD)).append(" ");
/* 112 */     if ((this.msgBodyLength > 0) && 
/* 113 */       (this.msgBodyBuffer != null)) {
/* 114 */       str.append("msgBody=").append(this.msgBodyBuffer).append(" ");
/*     */     }
/*     */ 
/* 117 */     str.append('\n');
/* 118 */     str.append(ByteUtil.getHexString(this.packetBuffer));
/* 119 */     return str.toString();
/*     */   }
/*     */ 
/*     */   public boolean isCRCResult() {
/* 123 */     return this.CRCResult;
/*     */   }
/*     */ 
/*     */   public void setCRCResult(boolean cRCResult) {
/* 127 */     this.CRCResult = cRCResult;
/*     */   }
/*     */ 
/*     */   public boolean isBuildEntity() {
/* 131 */     return this.createUsage == 0;
/*     */   }
/*     */ 
/*     */   public boolean isParseEntity() {
/* 135 */     return this.createUsage == 1;
/*     */   }
/*     */ 
/*     */   public int getCMD() {
/* 139 */     return this.CMD;
/*     */   }
/*     */ 
/*     */   public void setCMD(int cMD) {
/* 143 */     this.CMD = cMD;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.GatewayUnitPack
 * JD-Core Version:    0.6.1
 */