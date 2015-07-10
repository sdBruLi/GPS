/*     */ package com.china317.core.codec.jtt809_2011;
/*     */ 
/*     */ import com.china317.core.base.AbstractDataPacket;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UnknownCommandBodyPart;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import com.china317.core.util.CRC16;
/*     */ import com.china317.core.util.Encrypt;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DataPacketParser
/*     */ {
/*  16 */   private static final Log log = LogFactory.getLog(DataPacketParser.class);
/*     */ 
/*     */   public static AbstractDataPacket parse(IoBuffer input, CodecConfig codecConfig, long sessionId) {
/*  19 */     DataPacketJTT809 dataPacket = new DataPacketJTT809(codecConfig);
/*  20 */     dataPacket.setValid(false);
/*  21 */     String lineTemp = input.getHexDump();
/*  22 */     log.debug("parse(),input buffer  = " + lineTemp);
/*     */     try {
/*  24 */       IoBuffer unescapedInput = unescape(input);
/*  25 */       log.debug("parse(),unescaped buffer  = " + unescapedInput.getHexDump());
/*  26 */       if (unescapedInput.remaining() < 26) {
/*  27 */         dataPacket.setInvalidMessage("input datas less than '(HeadFlagByteSize+DataHeadByteSize+CRCCodeByteSize+EndFlagByteSize)=26'");
/*  28 */         log.debug("input datas less than '(HeadFlagByteSize+DataHeadByteSize+CRCCodeByteSize+EndFlagByteSize)=26'");
/*  29 */       } else if (!crcCheck(unescapedInput)) {
/*  30 */         dataPacket.setInvalidMessage("crc check fail");
/*  31 */         log.debug("crc check fail");
/*  32 */       } else if (!lengthCheck(unescapedInput)) {
/*  33 */         dataPacket.setInvalidMessage("length check fail");
/*  34 */         log.debug("length check fail");
/*     */       }
/*     */       else {
/*  37 */         byte headFlag = unescapedInput.get();
/*     */ 
/*  39 */         DataPacketHeadPart headPart = new DataPacketHeadPart();
/*  40 */         headPart.parseHead(unescapedInput);
/*  41 */         dataPacket.setHeadPart(headPart);
/*     */ 
/*  43 */         PlatformCodecConfigManager.getInstance().updCodeConfig(Integer.valueOf(headPart.getMsgGnssCenterId()), headPart.isEncryptFlag(), headPart.getEncryptKey());
/*  44 */         byte[] bodyBytes = new byte[unescapedInput.remaining() - 2 - 1];
/*  45 */         unescapedInput.get(bodyBytes);
/*  46 */         log.debug("parse(),encrypt enable : " + headPart.isEncryptFlag());
/*     */ 
/*  51 */         boolean isE = headPart.isEncryptFlag();
/*  52 */         long key = headPart.getEncryptKey();
/*     */ 
/*  54 */         if (isE)
/*     */         {
/*  56 */           log.debug("session[" + sessionId + "]parse(), before encrypt body(size=" + bodyBytes.length + "): " + ByteUtil.byteArray2HexDump(bodyBytes));
/*  57 */           CodecConfig tempConfig = PlatformCodecConfigManager.getInstance().getCodecConfig(Integer.valueOf(headPart.getMsgGnssCenterId()));
/*  58 */           if (tempConfig != null) {
/*  59 */             codecConfig = tempConfig;
/*     */           }
/*  61 */           long m1 = codecConfig.getEncryptM1();
/*  62 */           long a1 = codecConfig.getEncryptIA1();
/*  63 */           long c1 = codecConfig.getEncryptIC1();
/*     */ 
/*  67 */           if ((headPart.getMsgGnssCenterId() == 111119) || (headPart.getMsgGnssCenterId() == 310000))
/*     */           {
/*  69 */             if (headPart.getMsgGnssCenterId() == 111119) {
/*  70 */               if (m1 != 10000000L) {
/*  71 */                 m1 = 10000000L;
/*     */               }
/*  73 */               if (a1 != 20000000L) {
/*  74 */                 a1 = 20000000L;
/*     */               }
/*  76 */               if (c1 != 30000000L) {
/*  77 */                 c1 = 30000000L;
/*     */               }
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*  83 */           bodyBytes = Encrypt.encrypt(m1, a1, c1, key, bodyBytes);
/*     */ 
/*  85 */           log.debug("parse(), after encrypt body(size=" + bodyBytes.length + "): " + ByteUtil.byteArray2HexDump(bodyBytes));
/*     */         }
/*     */ 
/*  91 */         DataPacketBodyPart bodyPart = DataPacketBodyPartFactory.getDataPacketBodyPart(headPart.getMsgId(), bodyBytes);
/*  92 */         if ((bodyPart instanceof UnknownCommandBodyPart)) {
/*  93 */           dataPacket.setValid(false);
/*  94 */           dataPacket.setInvalidMessage("unknown MSG_ID " + headPart.getMsgId());
/*     */         }
/*     */         else {
/*  97 */           dataPacket.setBodyPart(bodyPart);
/*  98 */           dataPacket.getBodyPart().parseBody(bodyBytes);
/*  99 */           dataPacket.setValid(true);
/*     */         }
/*     */       }
/*     */ 
/* 103 */       input.rewind();
/* 104 */       byte[] bytes = new byte[input.remaining()];
/* 105 */       input.get(bytes);
/* 106 */       dataPacket.setBytes(bytes);
/* 107 */       dataPacket.setReceivedDate(new Date());
/* 108 */       dataPacket.setSessionId(sessionId);
/*     */     } catch (Exception e) {
/* 110 */       log.error("parse(),excpetion = " + e.toString(), e);
/* 111 */       dataPacket.setInvalidMessage(e.toString());
/*     */     }
/* 113 */     log.debug("session[" + sessionId + "]parse(), finished ,dataPacket = " + dataPacket.toString());
/*     */     try
/*     */     {
/* 117 */       if ((dataPacket.getHeadPart().getMsgGnssCenterId() == 111119) || (dataPacket.getHeadPart().getMsgGnssCenterId() == 310000))
/* 118 */         log.info("parse(), finished ,dataPacket = " + dataPacket.toString());
/*     */     }
/*     */     catch (Exception e) {
/* 121 */       log.error("", e);
/*     */     }
/* 123 */     return dataPacket;
/*     */   }
/*     */ 
/*     */   public static IoBuffer unescape(IoBuffer buffer) {
/* 127 */     IoBuffer output = IoBuffer.allocate(buffer.remaining()).setAutoExpand(true);
/* 128 */     boolean foundEscapeByte = false;
/* 129 */     byte b = 0;
/* 130 */     byte preByte = 0;
/* 131 */     while (buffer.hasRemaining()) {
/* 132 */       b = buffer.get();
/* 133 */       if (!foundEscapeByte) {
/* 134 */         if ((b == 90) || (b == 94)) {
/* 135 */           preByte = b;
/* 136 */           foundEscapeByte = true;
/*     */         } else {
/* 138 */           output.put(b);
/*     */         }
/*     */       } else {
/* 141 */         if (preByte == 90) {
/* 142 */           if (b == 1) {
/* 143 */             output.put((byte)91);
/* 144 */           } else if (b == 2) {
/* 145 */             output.put((byte)90);
/*     */           } else {
/* 147 */             output.put(preByte);
/* 148 */             output.put(b);
/*     */           }
/* 150 */         } else if (preByte == 94) {
/* 151 */           if (b == 1) {
/* 152 */             output.put((byte)93);
/* 153 */           } else if (b == 2) {
/* 154 */             output.put((byte)94);
/*     */           } else {
/* 156 */             output.put(preByte);
/* 157 */             output.put(b);
/*     */           }
/*     */         }
/* 160 */         foundEscapeByte = false;
/*     */       }
/*     */     }
/*     */ 
/* 164 */     output.flip();
/* 165 */     return output;
/*     */   }
/*     */ 
/*     */   public static IoBuffer wrap(IoBuffer input) {
/* 169 */     IoBuffer output = IoBuffer.allocate(10).setAutoExpand(true);
/* 170 */     while (input.hasRemaining()) {
/* 171 */       byte b = input.get();
/*     */ 
/* 173 */       if (b == 91) {
/* 174 */         output.put((byte)90);
/* 175 */         output.put((byte)1);
/* 176 */       } else if (b == 90) {
/* 177 */         output.put((byte)90);
/* 178 */         output.put((byte)2);
/* 179 */       } else if (b == 93) {
/* 180 */         output.put((byte)94);
/* 181 */         output.put((byte)1);
/* 182 */       } else if (b == 94) {
/* 183 */         output.put((byte)94);
/* 184 */         output.put((byte)2);
/*     */       } else {
/* 186 */         output.put(b);
/*     */       }
/*     */     }
/* 189 */     output.flip();
/* 190 */     return output;
/*     */   }
/*     */ 
/*     */   public static byte[] wrap(byte[] src) {
/* 194 */     IoBuffer input = IoBuffer.wrap(src).setAutoExpand(true);
/* 195 */     IoBuffer output = wrap(input);
/* 196 */     byte[] bytes = new byte[output.remaining()];
/* 197 */     output.get(bytes);
/* 198 */     return bytes;
/*     */   }
/*     */ 
/*     */   private static boolean lengthCheck(IoBuffer input) {
/* 202 */     byte headFlag = input.get();
/* 203 */     long msgLength = input.getUnsignedInt();
/* 204 */     input.rewind();
/* 205 */     log.debug("parse(length check), msgLength = " + msgLength + " , buffer remaining = " + input.remaining());
/* 206 */     return msgLength == input.remaining();
/*     */   }
/*     */ 
/*     */   private static boolean crcCheck(IoBuffer input) {
/* 210 */     byte[] bytes = new byte[input.remaining() - 4];
/* 211 */     input.position(input.position() + 1);
/* 212 */     input.get(bytes);
/*     */ 
/* 214 */     int crcCode = input.getUnsignedShort();
/*     */ 
/* 216 */     int crcValue = CRC16.getCRC(bytes);
/* 217 */     log.debug("parse(crc check),CRC value = " + Integer.toHexString(crcValue).toUpperCase() + " , " + "CRC code = " + Integer.toHexString(crcCode).toUpperCase());
/* 218 */     input.rewind();
/* 219 */     return crcValue == crcCode;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/* 253 */     byte[] bytes2 = { 91, 0, 0, 0, 127, 0, 0, 0, 14, 18, 0, 0, 1, -78, 15, 0, 0, 41, 
/* 254 */       0, 0, 0, 0, 0, -78, -30, 65, 49, 50, 51, 52, 53, 
/* 255 */       0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 18, 3, 0, 0, 0, 73, 2, 1, 30, 10, 7, -37, 17, 50, 9, 
/* 256 */       6, -5, -33, 80, 1, -32, -11, 0, 0, 100, 0, 100, 0, 0, 39, 16, 1, 44, 1, -12, 
/* 257 */       0, 0, 0, 0, 0, 0, 0, 0, 1, 30, 10, 7, -37, 17, 50, 19, 6, -5, -33, 80, 
/* 258 */       1, -32, -11, 0, 0, 100, 0, 100, 0, 0, 39, 16, 1, 44, 1, -12, 
/* 259 */       0, 0, 0, 0, 0, 0, 0, 1, 70, -5, 93 };
/* 260 */     IoBuffer buffer = IoBuffer.allocate(16).setAutoExpand(true);
/* 261 */     buffer.put(bytes2);
/* 262 */     buffer.flip();
/* 263 */     parse(buffer, new CodecConfig(), 1L);
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.DataPacketParser
 * JD-Core Version:    0.6.1
 */