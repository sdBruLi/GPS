/*     */ package com.china317.core.codec.jtt808_2011;
/*     */ 
/*     */ import com.china317.core.base.AbstractDataPacket;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class UnitPackJT808 extends AbstractDataPacket
/*     */   implements UnitPack
/*     */ {
/*     */   private long sessionId;
/*  10 */   private byte[] packetBytes = null;
/*  11 */   private IoBuffer packetBuffer = null;
/*  12 */   private int msgID = 0;
/*  13 */   private int packet = 0;
/*  14 */   private int encrypt = 0;
/*  15 */   private int msgBodyLength = 0;
/*  16 */   private String mobileNum = "";
/*  17 */   private int sequenceNum = 0;
/*  18 */   private int msgPacketCount = 0;
/*  19 */   private int msgPacketNum = 0;
/*     */   private JT808MsgBody msgBody;
/*     */   private IoBuffer msgBodyBuffer;
/*  23 */   private boolean CRCResult = false;
/*     */   public static final int USAGE_BUILD = 0;
/*     */   public static final int USAGE_PARSE = 1;
/*  26 */   private int createUsage = 0;
/*     */   private long createTime;
/*     */ 
/*     */   public static UnitPackJT808 createParseEntity()
/*     */   {
/*  30 */     UnitPackJT808 entity = new UnitPackJT808();
/*  31 */     entity.createUsage = 1;
/*  32 */     return entity;
/*     */   }
/*     */ 
/*     */   private UnitPackJT808() {
/*  36 */     this.createTime = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   public UnitPackJT808(int msgID) {
/*  40 */     setMsgID(msgID);
/*     */   }
/*     */ 
/*     */   public UnitPackJT808(int msgID, String mobileNum) {
/*  44 */     setMsgID(msgID);
/*  45 */     setMobileNum(mobileNum);
/*     */   }
/*     */ 
/*     */   public UnitPackJT808(int msgID, String mobileNum, int sequenceNum) {
/*  49 */     setMsgID(msgID);
/*  50 */     setMobileNum(mobileNum);
/*  51 */     setSequenceNum(sequenceNum);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/*     */   }
/*     */ 
/*     */   public boolean isPacket() {
/*  58 */     return this.packet == 1;
/*     */   }
/*     */ 
/*     */   public IoBuffer getPacketBuffer() {
/*  62 */     return this.packetBuffer;
/*     */   }
/*     */ 
/*     */   public byte[] getPacketBytes() {
/*  66 */     return this.packetBytes;
/*     */   }
/*     */ 
/*     */   public void setPacketBuffer(IoBuffer packetBuffer)
/*     */   {
/*  71 */     this.packetBuffer = packetBuffer;
/*  72 */     this.packetBytes = new byte[packetBuffer.limit()];
/*  73 */     this.packetBuffer.get(this.packetBytes);
/*  74 */     this.packetBuffer.rewind();
/*     */   }
/*     */ 
/*     */   public int getMsgID() {
/*  78 */     return this.msgID;
/*     */   }
/*     */ 
/*     */   public void setMsgID(int msgID) {
/*  82 */     this.msgID = msgID;
/*     */   }
/*     */ 
/*     */   public int getPacket() {
/*  86 */     return this.packet;
/*     */   }
/*     */ 
/*     */   public void setPacket(int packet) {
/*  90 */     this.packet = packet;
/*     */   }
/*     */ 
/*     */   public int getEncrypt() {
/*  94 */     return this.encrypt;
/*     */   }
/*     */ 
/*     */   public void setEncrypt(int encrypt) {
/*  98 */     this.encrypt = encrypt;
/*     */   }
/*     */ 
/*     */   public int getMsgBodyLength() {
/* 102 */     if (isParseEntity())
/* 103 */       return this.msgBodyLength;
/* 104 */     if (this.msgBodyBuffer != null)
/* 105 */       return this.msgBodyBuffer.limit();
/* 106 */     if ((this.msgBody != null) && (this.msgBody.getBodyBuffer() != null)) {
/* 107 */       return this.msgBody.getBodyBuffer().limit();
/*     */     }
/* 109 */     return 0;
/*     */   }
/*     */ 
/*     */   public void setMsgBodyLength(int msgBodyLength)
/*     */   {
/* 114 */     this.msgBodyLength = msgBodyLength;
/*     */   }
/*     */ 
/*     */   public String getMobileNum() {
/* 118 */     return this.mobileNum;
/*     */   }
/*     */ 
/*     */   public void setMobileNum(String mobileNum) {
/* 122 */     this.mobileNum = mobileNum;
/*     */   }
/*     */ 
/*     */   public int getSequenceNum() {
/* 126 */     return this.sequenceNum;
/*     */   }
/*     */ 
/*     */   public void setSequenceNum(int sequenceNum) {
/* 130 */     this.sequenceNum = sequenceNum;
/*     */   }
/*     */ 
/*     */   public int getMsgPacketCount() {
/* 134 */     return this.msgPacketCount;
/*     */   }
/*     */ 
/*     */   public void setMsgPacketCount(int msgPacketCount) {
/* 138 */     this.msgPacketCount = msgPacketCount;
/*     */   }
/*     */ 
/*     */   public int getMsgPacketNum() {
/* 142 */     return this.msgPacketNum;
/*     */   }
/*     */ 
/*     */   public void setMsgPacketNum(int msgPacketNum) {
/* 146 */     this.msgPacketNum = msgPacketNum;
/*     */   }
/*     */ 
/*     */   public JT808MsgBody getMsgBody() {
/* 150 */     return this.msgBody;
/*     */   }
/*     */ 
/*     */   public IoBuffer getMsgBodyBuffer() throws Exception {
/* 154 */     if (this.msgBodyBuffer != null)
/* 155 */       return this.msgBodyBuffer;
/* 156 */     if (this.msgBody != null) {
/* 157 */       if (!this.msgBody.isBuildBody()) {
/* 158 */         this.msgBody.bulidBody();
/*     */       }
/* 160 */       return this.msgBody.getBodyBuffer();
/*     */     }
/* 162 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMsgBody(JT808MsgBody msgBody) throws Exception
/*     */   {
/* 167 */     this.msgBody = msgBody;
/* 168 */     if (!isParseEntity())
/*     */     {
/* 170 */       if (!this.msgBody.isBuildBody())
/*     */       {
/* 172 */         this.msgBody.bulidBody();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setMsgBody(IoBuffer msgBodyBuff) {
/* 178 */     this.msgBodyBuffer = msgBodyBuff;
/*     */   }
/*     */ 
/*     */   public void setMsgBody(byte[] msgBodybytes) {
/* 182 */     setMsgBody(IoBuffer.wrap(msgBodybytes));
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 187 */     StringBuffer str = new StringBuffer();
/* 188 */     str.append("msgID=").append(Integer.toHexString(this.msgID)).append(" ");
/* 189 */     str.append("mobileNum=").append(this.mobileNum).append(" ");
/* 190 */     if ((this.msgBodyLength > 0) && 
/* 191 */       (this.msgBodyBuffer != null)) {
/* 192 */       str.append("msgBody=").append(ByteUtil.getHexString(this.msgBodyBuffer)).append(" ");
/*     */     }
/*     */ 
/* 196 */     return str.toString();
/*     */   }
/*     */ 
/*     */   public String toString(int level) {
/* 200 */     StringBuffer str = new StringBuffer();
/* 201 */     str.append("(").append(Integer.toHexString(this.msgID) + "H," + this.mobileNum).append(") ");
/* 202 */     if ((level >= 1) && 
/* 203 */       (this.msgBodyLength > 0) && 
/* 204 */       (this.msgBodyBuffer != null)) {
/* 205 */       str.append("msgBody=").append(ByteUtil.getHexString(this.msgBodyBuffer)).append(" ");
/*     */     }
/*     */ 
/* 209 */     if (level >= 2) {
/* 210 */       str.append('\n' + ByteUtil.getHexString(this.packetBuffer));
/*     */     }
/* 212 */     return str.toString();
/*     */   }
/*     */ 
/*     */   public boolean isCRCResult() {
/* 216 */     return this.CRCResult;
/*     */   }
/*     */ 
/*     */   public void setCRCResult(boolean cRCResult) {
/* 220 */     this.CRCResult = cRCResult;
/*     */   }
/*     */ 
/*     */   public boolean isBuildEntity() {
/* 224 */     return this.createUsage == 0;
/*     */   }
/*     */ 
/*     */   public boolean isParseEntity() {
/* 228 */     return this.createUsage == 1;
/*     */   }
/*     */ 
/*     */   public void setSessionId(long sessionId) {
/* 232 */     this.sessionId = sessionId;
/*     */   }
/*     */ 
/*     */   public String getCommand()
/*     */   {
/* 237 */     return JT808MsgId.getStringCommand(this.msgID);
/*     */   }
/*     */ 
/*     */   public long getSessionId()
/*     */   {
/* 242 */     return this.sessionId;
/*     */   }
/*     */ 
/*     */   public String getUniqueIndex()
/*     */   {
/* 247 */     return String.valueOf(this.sequenceNum);
/*     */   }
/*     */ 
/*     */   public long getCreateTime() {
/* 251 */     return this.createTime;
/*     */   }
/*     */ 
/*     */   public void setCreateTime(long createTime) {
/* 255 */     this.createTime = createTime;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.UnitPackJT808
 * JD-Core Version:    0.6.1
 */