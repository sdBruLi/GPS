/*     */ package com.china317.core.codec.jtt808Gateway;
/*     */ 
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0001;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0011;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0012;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x8001;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x8011;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class GatewayUnitPackPraser
/*     */ {
/*     */   public static GatewayUnitPack prasePacket(IoBuffer packetBuffer)
/*     */     throws Exception
/*     */   {
/*  24 */     return prasePacket(packetBuffer, true, true);
/*     */   }
/*     */ 
/*     */   public static GatewayUnitPack prasePacket(IoBuffer packetBuffer, boolean isVerfyCHK, boolean isPraseBody)
/*     */     throws Exception
/*     */   {
/*  36 */     GatewayUnitPack pack = GatewayUnitPack.createParseEntity();
/*  37 */     if (isVerfyCHK) {
/*  38 */       boolean result = verifyCHK(packetBuffer);
/*  39 */       if (result) {
/*  40 */         pack.setCRCResult(result);
/*     */ 
/*  42 */         packetBuffer.getUnsignedShort();
/*  43 */         pack.setMsgBodyLength(packetBuffer.getUnsignedShort());
/*  44 */         pack.setCMD(packetBuffer.getUnsignedShort());
/*  45 */         pack.setSequenceNum(packetBuffer.getUnsignedShort());
/*  46 */         byte[] tempbytes = new byte[pack.getMsgBodyLength()];
/*  47 */         packetBuffer.get(tempbytes);
/*     */ 
/*  49 */         pack.setMsgBody(IoBuffer.wrap(tempbytes));
/*  50 */         if (isPraseBody) {
/*  51 */           praseBody(pack);
/*     */         }
/*     */ 
/*  54 */         packetBuffer.rewind();
/*  55 */         byte[] ptempbytes = new byte[packetBuffer.limit()];
/*  56 */         packetBuffer.get(ptempbytes);
/*  57 */         packetBuffer.rewind();
/*     */ 
/*  59 */         pack.setPacketBuffer(IoBuffer.wrap(ptempbytes));
/*     */       } else {
/*  61 */         return pack;
/*     */       }
/*     */     }
/*     */ 
/*  65 */     return pack;
/*     */   }
/*     */ 
/*     */   private static void praseBody(GatewayUnitPack pack) throws Exception {
/*  69 */     GatewayBody body = null;
/*  70 */     switch (pack.getCMD()) {
/*     */     case 1:
/*  72 */       body = new GatewayBody_0x0001();
/*  73 */       break;
/*     */     case 32769:
/*  75 */       body = new GatewayBody_0x8001();
/*  76 */       break;
/*     */     case 2:
/*  78 */       break;
/*     */     case 17:
/*  80 */       body = new GatewayBody_0x0011();
/*  81 */       break;
/*     */     case 32785:
/*  83 */       body = new GatewayBody_0x8011();
/*  84 */       break;
/*     */     case 18:
/*  86 */       body = new GatewayBody_0x0012();
/*  87 */       break;
/*     */     case 32786:
/*  89 */       break;
/*     */     }
/*     */ 
/*  93 */     if (body != null) {
/*  94 */       body.setBodyBuffer(pack.getMsgBodyBuffer());
/*  95 */       body.praseBody();
/*  96 */       pack.setMsgBody(body);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static boolean verifyCHK(IoBuffer packetBuffer) throws Exception {
/* 101 */     byte ret = packetBuffer.get();
/* 102 */     for (int i = 0; i < packetBuffer.limit() - 2; i++) {
/* 103 */       ret = (byte)(ret ^ packetBuffer.get());
/*     */     }
/* 105 */     byte chk = packetBuffer.get();
/* 106 */     packetBuffer.rewind();
/* 107 */     boolean result = ret == chk;
/* 108 */     return result;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 112 */     String code = "AA EE 00 13 00 01 00 63 63 6F 64 65 30 30 31 00 00 00 00 00 00 00 00 00 01 00 02 0A";
/* 113 */     code = "AA EE 00 29 00 12 00 01 01 00 00 00 21 00 22 81 00 00 15 00 00 00 00 00 01 00 00 00 00 00 63 6F 64 65 3A 31 33 31 37 31 31 34 32 30 37 30 33 38 9C 7C";
/* 114 */     code = "AA EE 03 A4 00 12 00 10 01 35 34 37 00 00 00 00 00 00 00 00 00 03 95 08 01 23 84 01 50 21 35 45 43 D0 0B 00 0F 00 0C D6 75 BC 64 C6 8A DD 63 3F 21 F6 A9 9C 7C C2 4C FC FD 0F 1D 6B 03 76 72 77 52 79 D7 52 C9 D8 B1 C7 D3 B5 30 56 C8 C0 7A 87 6F BA 8C 7E 83 35 A7 68 AC B6 EA 19 19 79 3C 30 C1 AA 42 2C A2 D4 CA B8 A6 22 40 B4 F0 31 40 0F 5F A1 A9 91 80 38 EF 40 CB 29 38 B7 8D E7 C8 CA 63 9E C3 9E 6B 5A 29 D6 41 E8 DD C1 A4 68 95 D1 2E 69 68 B1 4A 01 58 DE 2A 4D FA 33 1E 3E 57 53 FA E3 FA D0 69 25 68 9C 92 15 08 06 6A 17 6F 98 D6 9D 0E 60 8F EE 3B 80 09 51 C6 6A 4B 59 58 9D AE DB AA 18 1A 2F 12 DC 5A 47 BB 04 A3 60 67 A6 3B FF 00 21 48 A8 1E E6 08 44 6A 18 90 01 1F 75 40 3F 4F E5 42 D8 B8 97 6D E4 54 B8 9C CA C2 47 84 71 C6 57 A8 05 BE 82 AF DB CD 34 93 88 E7 3B C1 52 40 38 05 7D FA 7E 15 CA A2 B9 4E D5 36 AA AB 0C D4 B4 D6 B8 09 3C 01 44 99 DA E4 9C 64 7A FE 15 56 DB 79 8E EE CA 56 04 A2 79 A1 94 82 06 31 91 9F C4 7E 55 9C 74 69 9A 57 F7 A0 CC D3 24 79 23 70 C8 ED 4A 25 8F 1C 10 4F A7 7A EF B9 E5 34 C8 64 BB F2 DC 06 4F 94 FA 72 6A 0B B9 44 CA 0C 7B B8 04 90 47 2B FD 29 36 09 19 EC 69 84 D4 8C 01 A5 CD 00 39 4F 39 CD 68 69 92 94 BE 81 BD 24 5C FD 33 CF E9 4D 08 D5 B9 32 46 67 40 B2 14 59 98 80 5F 08 01 39 1D FD EB 7E 17 2F A2 C6 CD 82 57 0B C7 6C 36 3F 95 36 49 FF D7 9E 39 D0 8E 0F D6 A1 D4 66 C5 AB F9 7C 31 1B 41 AC 0D D4 5C B4 47 38 B6 8E 64 55 3C 67 81 9A BF 1E 8E E7 19 7F C8 56 C9 A6 AE 8C A7 17 07 66 5C 87 4A 28 A0 09 1D 47 B3 62 AC C7 A6 46 0E 49 C9 F5 24 9A A2 0B 0B 65 18 EE 69 C2 D1 3D C5 31 12 2D A4 78 EA DF 5C D3 C5 AC 78 E4 13 EF 9A 00 CD BF 0B 65 24 48 26 90 99 01 3F 3B 9E D4 B1 4B B7 1F 36 D1 40 12 5D 4C 66 B7 78 A2 07 0C 8C 3E A7 15 95 06 A5 75 6A FB 21 9C AA 29 DA 15 B0 C3 8F AF 4F C3 14 32 93 B1 A5 07 89 65 53 8B 88 73 8E AD 11 FE 87 FC 6B 46 0F 10 5B C8 07 EF 82 9F 47 04 63 F1 E9 FA D2 36 53 2E C3 A9 C7 2F DD 96 36 E3 3C 30 27 1E B5 1E B2 C6 EB 4F 78 63 47 62 C5 47 03 BE 41 FE 94 8A 93 BC 4C 64 D3 16 C6 26 9E E4 A8 70 33 D7 85 AE 72 69 BC CB 87 7E 81 89 38 A8 8B E6 6E 46 0C 92 03 96 29 EA 0D 32 D8 9F 3D 78 24 29 C9 C7 A5 6A F6 11 B4 A4 C9 67 3A 27 5C 6E 1D FA 73 FD 2A 2B 1D 41 21 98 C9 75 23 90 AA 70 3A F3 EA 6B 39 3B 45 D8 D6 92 BB 27 74 9A 2B C6 91 41 47 DC 58 63 B6 7B 55 EB 49 1E 35 C2 C3 1C 20 F5 D9 1A A6 7F 21 5C AE 52 4A C7 AB 08 C5 C9 4C 83 5E D4 55 AC A3 B5 5C 1C 36 4D 63 5B CA 46 71 DC 62 AE 0A F6 30 AC D4 53 48 5F 29 9C 96 3D CD 48 B0 20 03 2A 1B EA 33 5D 76 3C F6 38 A4 25 B3 21 5C FB BF F8 9A 8A E5 21 78 88 8C C7 BB B7 22 86 89 32 89 A4 A9 10 52 D0 03 97 AD 5D B0 5D D7 31 81 EB 9A 00 EE CE 97 6B 73 31 B9 95 59 DA 4C 12 A5 CE DC 81 8E 95 35 D2 47 15 8B 2A 2A A2 0C 60 28 C0 1C D5 32 51 FF D0 C1 D5 1E D5 EE 8B 5A BB 38 23 92 46 00 3E D5 53 73 71 F3 1E 3D E8 04 DA 25 8A EA 48 E4 57 DC 32 A7 BE 4D 6B 45 AE 80 07 9B 16 7D D3 FF 00 AF 42 07 77 B9 3F 53 40";
/*     */ 
/* 116 */     byte[] bb = ByteUtil.hexString2byteArray(code);
/* 117 */     IoBuffer packetBuffer = IoBuffer.wrap(bb);
/*     */     try {
/* 119 */      // pack = prasePacket(packetBuffer);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       GatewayUnitPack pack;
/* 122 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.GatewayUnitPackPraser
 * JD-Core Version:    0.6.1
 */