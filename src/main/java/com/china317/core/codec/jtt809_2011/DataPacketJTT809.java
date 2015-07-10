/*     */ package com.china317.core.codec.jtt809_2011;
/*     */ 
/*     */ import com.china317.core.base.AbstractDataPacket;
/*     */ import com.china317.core.base.DataPacketContext;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UnknownCommandBodyPart;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import com.china317.core.util.CRC16;
/*     */ import com.china317.core.util.Encrypt;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DataPacketJTT809 extends AbstractDataPacket
/*     */ {
/*  17 */   private static final Log log = LogFactory.getLog(DataPacketJTT809.class);
/*     */   private DataPacketHeadPart headPart;
/*     */   private DataPacketBodyPart bodyPart;
/*     */   private long sessionId;
/*     */   private Date receivedDate;
/*     */   private Date sendedDate;
/*     */   private CodecConfig codecConfig;
/*     */ 
/*     */   public void setCodecConfig(CodecConfig codecConfig)
/*     */   {
/*  27 */     this.codecConfig = codecConfig;
/*     */   }
/*     */   public DataPacketHeadPart getHeadPart() {
/*  30 */     return this.headPart;
/*     */   }
/*     */   void setHeadPart(DataPacketHeadPart headPart) {
/*  33 */     this.headPart = headPart;
/*     */   }
/*     */ 
/*     */   public DataPacketBodyPart getBodyPart() {
/*  37 */     return this.bodyPart;
/*     */   }
/*     */   void setBodyPart(DataPacketBodyPart bodyPart) {
/*  40 */     this.bodyPart = bodyPart;
/*     */   }
/*     */ 
/*     */   public long getSessionId() {
/*  44 */     return this.sessionId;
/*     */   }
/*     */   public void setSessionId(long sessionId) {
/*  47 */     this.sessionId = sessionId;
/*     */   }
/*     */   public Date getReceivedDate() {
/*  50 */     return this.receivedDate;
/*     */   }
/*     */   public void setReceivedDate(Date receivedDate) {
/*  53 */     this.receivedDate = receivedDate;
/*     */   }
/*     */   public Date getSendedDate() {
/*  56 */     return this.sendedDate;
/*     */   }
/*     */   public void setSendedDate(Date sendedDate) {
/*  59 */     this.sendedDate = sendedDate;
/*     */   }
/*     */ 
/*     */   public CodecConfig getCodecConfig() {
/*  63 */     return this.codecConfig;
/*     */   }
/*     */   public String getCommand() {
/*  66 */     if (this.bodyPart != null)
/*  67 */       return getStringCommand(this.bodyPart.getCommand());
/*  68 */     if (this.headPart != null) {
/*  69 */       return getStringCommand(this.headPart.getMsgId());
/*     */     }
/*  71 */     return "-1";
/*     */   }
/*     */ 
/*     */   public String getStringCommand(int command) {
/*  75 */     StringBuffer line = new StringBuffer("0x");
/*  76 */     String tempLin = Integer.toHexString(command);
/*  77 */     for (int i = 0; i < 4 - tempLin.length(); i++) {
/*  78 */       line.append("0");
/*     */     }
/*  80 */     line.append(tempLin);
/*  81 */     return line.toString().toLowerCase();
/*     */   }
/*     */   public String getUniqueIndex() {
/*  84 */     if (this.headPart != null) {
/*  85 */       return String.valueOf(this.headPart.getMsgSN());
/*     */     }
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */   DataPacketJTT809(CodecConfig codecConfig) {
/*  91 */     this.codecConfig = codecConfig;
/*  92 */     this.headPart = new DataPacketHeadPart();
/*  93 */     this.headPart.setEncryptFlag(codecConfig.isEncryptEnable());
/*  94 */     this.headPart.setEncryptKey(codecConfig.getEncryptKey());
/*     */ 
/*  96 */     setContext(new DataPacketContext("JTT809", "2011"));
/*     */   }
/*     */ 
/*     */   public DataPacketJTT809(CodecConfig codecConfig, int msgId, int childMsgId) {
/* 100 */     this(codecConfig);
/* 101 */     this.headPart.setMsgId(msgId);
/* 102 */     if (childMsgId == 0) {
/* 103 */       childMsgId = msgId;
/*     */     }
/* 105 */     this.bodyPart = DataPacketBodyPartFactory.getDataPacketBodyPart2(childMsgId);
/* 106 */     if ((this.bodyPart instanceof UnknownCommandBodyPart)) {
/* 107 */       setValid(false);
/* 108 */       setInvalidMessage("unknown command " + this.bodyPart.getCommand());
/*     */     } else {
/* 110 */       setValid(true);
/*     */     }
/*     */   }
/*     */ 
/* 114 */   public DataPacketJTT809(CodecConfig codecConfig, DataPacketBodyPart bodyPart) { this(codecConfig);
/* 115 */     this.headPart.setMsgId(bodyPart.getCommand());
/* 116 */     this.bodyPart = bodyPart;
/* 117 */     if ((this.bodyPart instanceof UnknownCommandBodyPart)) {
/* 118 */       setValid(false);
/* 119 */       setInvalidMessage("unknown command " + this.bodyPart.getCommand());
/*     */     } else {
/* 121 */       setValid(true);
/*     */     } }
/*     */ 
/*     */   public byte[] build() throws Exception
/*     */   {
/* 126 */     CodecConfig tempConfig = PlatformCodecConfigManager.getInstance().getCodecConfig(Integer.valueOf(this.headPart.getMsgGnssCenterId()));
/* 127 */     if (tempConfig != null) {
/* 128 */       this.codecConfig = tempConfig;
/*     */     }
/* 130 */     byte[] bodyBytes = this.bodyPart.buildBody();
/*     */ 
/* 132 */     if (bodyBytes != null)
/*     */     {
/* 137 */       log.debug("parse(), before encrypt body bytes (size=" + bodyBytes.length + ") : " + ByteUtil.byteArray2HexDump(bodyBytes));
/* 138 */       boolean isE = this.codecConfig.isEncryptEnable();
/* 139 */       long key = this.codecConfig.getEncryptKey();
/* 140 */       long m1 = this.codecConfig.getEncryptM1();
/* 141 */       long a1 = this.codecConfig.getEncryptIA1();
/* 142 */       long c1 = this.codecConfig.getEncryptIC1();
/* 143 */       isE = false;
/* 144 */       if (isE) {
/* 145 */         if ((this.headPart.getMsgGnssCenterId() == 111119) || (this.headPart.getMsgGnssCenterId() == 310000))
/*     */         {
/* 147 */           if (this.headPart.getMsgGnssCenterId() == 111119) {
/* 148 */             if (m1 != 10000000L) {
/* 149 */               m1 = 10000000L;
/*     */             }
/* 151 */             if (a1 != 20000000L) {
/* 152 */               a1 = 20000000L;
/*     */             }
/* 154 */             if (c1 != 30000000L) {
/* 155 */               c1 = 30000000L;
/*     */             }
/*     */           }
/*     */         }
/* 159 */         bodyBytes = Encrypt.encrypt(m1, a1, c1, key, bodyBytes);
/* 160 */         this.headPart.setEncryptFlag(isE);
/* 161 */         this.headPart.setEncryptKey(key);
/*     */       }
/*     */ 
/* 166 */       log.debug("parse(), after encrypt body bytes (size=" + bodyBytes.length + ") : " + ByteUtil.byteArray2HexDump(bodyBytes));
/* 167 */       this.headPart.setMsgLength(23 + bodyBytes.length + 2 + 1);
/*     */     } else {
/* 169 */       this.headPart.setMsgLength(26L);
/*     */     }
/*     */ 
/* 172 */     byte[] headBytes = this.headPart.buildHead();
/* 173 */     log.debug("head bytes (size=" + headBytes.length + ") : " + ByteUtil.byteArray2HexDump(headBytes));
/* 174 */     byte[] headAndBodyBytes = (byte[])null;
/* 175 */     if (bodyBytes != null)
/* 176 */       headAndBodyBytes = ByteUtil.mergeByteArray(new byte[][] { headBytes, bodyBytes });
/*     */     else {
/* 178 */       headAndBodyBytes = headBytes;
/*     */     }
/* 180 */     int crc = CRC16.getCRC(headAndBodyBytes);
/* 181 */     log.debug("crc value = " + Integer.toHexString(crc).toUpperCase());
/*     */ 
/* 185 */     log.debug("head and body bytes(size=" + headAndBodyBytes.length + ") : " + ByteUtil.byteArray2HexDump(headAndBodyBytes));
/* 186 */     IoBuffer tempBuffer = IoBuffer.allocate(headAndBodyBytes.length + 2);
/* 187 */     tempBuffer.put(headAndBodyBytes);
/* 188 */     tempBuffer.putUnsignedShort(crc);
/* 189 */     tempBuffer.flip();
/*     */ 
/* 191 */     IoBuffer wrapBuffer = DataPacketParser.wrap(tempBuffer);
/* 192 */     byte[] wrapedHeadAndBodyBytes = new byte[wrapBuffer.limit()];
/* 193 */     wrapBuffer.get(wrapedHeadAndBodyBytes);
/* 194 */     log.debug("wraped head and body bytes(size=" + wrapedHeadAndBodyBytes.length + ") : " + ByteUtil.byteArray2HexDump(wrapedHeadAndBodyBytes));
/* 195 */     IoBuffer buffer = null;
/* 196 */     if (bodyBytes != null)
/* 197 */       buffer = IoBuffer.allocate(1 + headBytes.length + bodyBytes.length + 1).setAutoExpand(true);
/*     */     else {
/* 199 */       buffer = IoBuffer.allocate(1 + headBytes.length + 1).setAutoExpand(true);
/*     */     }
/*     */ 
/* 204 */     buffer.put((byte)91);
/* 205 */     buffer.put(wrapedHeadAndBodyBytes);
/*     */ 
/* 207 */     buffer.put((byte)93);
/* 208 */     buffer.flip();
/* 209 */     byte[] bytes = new byte[buffer.remaining()];
/* 210 */     buffer.get(bytes);
/* 211 */     log.debug("packet bytes(size=" + bytes.length + ") : " + ByteUtil.byteArray2HexDump(bytes));
/* 212 */     return bytes;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 216 */     if (isValid()) {
/* 217 */       return "head=[" + this.headPart.toString() + "],body=[" + this.bodyPart.toString() + "],receivedDate=" + this.receivedDate + ",sendedDate=" + this.sendedDate + ",sessionId=" + this.sessionId;
/*     */     }
/* 219 */     return "invalid," + getInvalidMessage();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.DataPacketJTT809
 * JD-Core Version:    0.6.1
 */