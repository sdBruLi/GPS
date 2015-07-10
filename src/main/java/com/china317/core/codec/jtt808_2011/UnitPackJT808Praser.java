/*     */ package com.china317.core.codec.jtt808_2011;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0001;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0002;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0100;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0102;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0104;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0201;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0301;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0302;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0303;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0500;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0700;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0701;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0702;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0800;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0801;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0802;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0900;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0901;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0A00;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8001;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8100;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8103;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8104;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8105;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8201;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8202;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8300;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8301;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8302;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8303;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8304;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8400;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8401;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8500;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8600;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8601;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8602;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8603;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8604;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8605;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8606;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8607;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8700;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8701;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8800;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8801;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8802;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8803;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8804;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8805;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8900;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8A00;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class UnitPackJT808Praser
/*     */ {
/*  69 */   private static Log log = LogFactory.getLog(UnitPackJT808Praser.class);
/*     */ 
/*     */   public static UnitPackJT808 prasePacket(IoBuffer packetBuffer)
/*     */     throws Exception
/*     */   {
/*  77 */     return prasePacket(packetBuffer, true);
/*     */   }
/*     */ 
/*     */   public static UnitPackJT808 prasePacket(IoBuffer packetBuffer, boolean isVerfyCHK)
/*     */     throws Exception
/*     */   {
/*  89 */     UnitPackJT808 pack = UnitPackJT808.createParseEntity();
/*  90 */     int tempTestPos1 = 0;
/*  91 */     if (isVerfyCHK) {
/*  92 */       boolean result = verifyCHK(packetBuffer);
/*  93 */       if (result) {
/*  94 */         pack.setCRCResult(result);
/*     */         try {
/*  96 */           pack.setMsgID(packetBuffer.getUnsignedShort());
/*  97 */           int msgBodyAttribute = packetBuffer.getUnsignedShort();
/*  98 */           pack.setPacket((msgBodyAttribute & 0x2000) >> 13);
/*  99 */           pack.setEncrypt((msgBodyAttribute & 0x1C00) >> 10);
/* 100 */           pack.setMsgBodyLength(msgBodyAttribute & 0x3FF);
/* 101 */           byte[] temp = new byte[6];
/* 102 */           packetBuffer.get(temp);
/* 103 */           pack.setMobileNum(String.valueOf(ByteUtil.BCD2Long(temp)));
/* 104 */           pack.setSequenceNum(packetBuffer.getUnsignedShort());
/* 105 */           if (pack.isPacket()) {
/* 106 */             pack.setMsgPacketCount(packetBuffer.getUnsignedShort());
/* 107 */             pack.setMsgPacketNum(packetBuffer.getUnsignedShort());
/*     */           }
/* 109 */           if (pack.getEncrypt() == 0) {
/* 110 */             byte[] tempbytes = new byte[pack.getMsgBodyLength()];
/* 111 */             tempTestPos1 = packetBuffer.position();
/* 112 */             packetBuffer.get(tempbytes);
/*     */ 
/* 114 */             pack.setMsgBody(IoBuffer.wrap(tempbytes)); } else {
/* 115 */             pack.getEncrypt();
/*     */           }
/*     */ 
/* 118 */           packetBuffer.rewind();
/* 119 */           byte[] ptempbytes = new byte[packetBuffer.limit()];
/* 120 */           packetBuffer.get(ptempbytes);
/* 121 */           packetBuffer.rewind();
/*     */ 
/* 123 */           pack.setPacketBuffer(IoBuffer.wrap(ptempbytes));
/* 124 */           praseBody(pack);
/*     */         } catch (Exception e) {
/* 126 */           log.error("", e);
/* 127 */           packetBuffer.rewind();
/* 128 */           log.error("UnitPackJT808Praser error position[" + tempTestPos1 + "], pack.getMsgBodyLength()[" + pack.getMsgBodyLength() + "], packetBuffer position[" + packetBuffer.position() + "] datas [" + ByteUtil.getHexString(packetBuffer) + "]");
/*     */         }
/*     */       }
/*     */       else {
/* 132 */         return pack;
/*     */       }
/*     */     }
/*     */ 
/* 136 */     return pack;
/*     */   }
/*     */ 
/*     */   private static void praseBody(UnitPackJT808 pack) throws Exception {
/* 140 */     JT808MsgBody body = null;
/* 141 */     switch (pack.getMsgID()) {
/*     */     case 1:
/* 143 */       body = new JT808MsgBody_0x0001();
/* 144 */       break;
/*     */     case 2:
/* 146 */       body = new JT808MsgBody_0x0002();
/* 147 */       break;
/*     */     case 256:
/* 149 */       body = new JT808MsgBody_0x0100();
/* 150 */       break;
/*     */     case 258:
/* 152 */       body = new JT808MsgBody_0x0102();
/* 153 */       break;
/*     */     case 260:
/* 155 */       body = new JT808MsgBody_0x0104();
/* 156 */       break;
/*     */     case 512:
/* 158 */       body = new JT808MsgBody_0x0200();
/* 159 */       break;
/*     */     case 513:
/* 161 */       body = new JT808MsgBody_0x0201();
/* 162 */       break;
/*     */     case 769:
/* 164 */       body = new JT808MsgBody_0x0301();
/* 165 */       break;
/*     */     case 770:
/* 167 */       body = new JT808MsgBody_0x0302();
/* 168 */       break;
/*     */     case 771:
/* 170 */       body = new JT808MsgBody_0x0303();
/* 171 */       break;
/*     */     case 1280:
/* 173 */       body = new JT808MsgBody_0x0500();
/* 174 */       break;
/*     */     case 1792:
/* 176 */       body = new JT808MsgBody_0x0700();
/* 177 */       break;
/*     */     case 1793:
/* 179 */       body = new JT808MsgBody_0x0701();
/* 180 */       break;
/*     */     case 1794:
/* 182 */       body = new JT808MsgBody_0x0702();
/* 183 */       break;
/*     */     case 2048:
/* 185 */       body = new JT808MsgBody_0x0800();
/* 186 */       break;
/*     */     case 2049:
/* 188 */       body = new JT808MsgBody_0x0801();
/* 189 */       break;
/*     */     case 2050:
/* 191 */       body = new JT808MsgBody_0x0802();
/* 192 */       break;
/*     */     case 2304:
/* 194 */       body = new JT808MsgBody_0x0900();
/* 195 */       break;
/*     */     case 2305:
/* 197 */       body = new JT808MsgBody_0x0901();
/* 198 */       break;
/*     */     case 2560:
/* 200 */       body = new JT808MsgBody_0x0A00();
/* 201 */       break;
/*     */     case 32769:
/* 204 */       body = new JT808MsgBody_0x8001();
/* 205 */       break;
/*     */     case 33024:
/* 207 */       body = new JT808MsgBody_0x8100();
/* 208 */       break;
/*     */     case 33027:
/* 210 */       body = new JT808MsgBody_0x8103();
/* 211 */       break;
/*     */     case 33028:
/* 213 */       body = new JT808MsgBody_0x8104();
/* 214 */       break;
/*     */     case 33029:
/* 216 */       body = new JT808MsgBody_0x8105();
/* 217 */       break;
/*     */     case 33281:
/* 219 */       body = new JT808MsgBody_0x8201();
/* 220 */       break;
/*     */     case 33282:
/* 222 */       body = new JT808MsgBody_0x8202();
/* 223 */       break;
/*     */     case 33536:
/* 225 */       body = new JT808MsgBody_0x8300();
/* 226 */       break;
/*     */     case 33537:
/* 228 */       body = new JT808MsgBody_0x8301();
/* 229 */       break;
/*     */     case 33538:
/* 231 */       body = new JT808MsgBody_0x8302();
/* 232 */       break;
/*     */     case 33539:
/* 234 */       body = new JT808MsgBody_0x8303();
/* 235 */       break;
/*     */     case 33540:
/* 237 */       body = new JT808MsgBody_0x8304();
/* 238 */       break;
/*     */     case 33792:
/* 240 */       body = new JT808MsgBody_0x8400();
/* 241 */       break;
/*     */     case 33793:
/* 243 */       body = new JT808MsgBody_0x8401();
/* 244 */       break;
/*     */     case 34048:
/* 246 */       body = new JT808MsgBody_0x8500();
/* 247 */       break;
/*     */     case 34304:
/* 249 */       body = new JT808MsgBody_0x8600();
/* 250 */       break;
/*     */     case 34305:
/* 252 */       body = new JT808MsgBody_0x8601();
/* 253 */       break;
/*     */     case 34306:
/* 255 */       body = new JT808MsgBody_0x8602();
/* 256 */       break;
/*     */     case 34307:
/* 258 */       body = new JT808MsgBody_0x8603();
/* 259 */       break;
/*     */     case 34308:
/* 261 */       body = new JT808MsgBody_0x8604();
/* 262 */       break;
/*     */     case 34309:
/* 264 */       body = new JT808MsgBody_0x8605();
/* 265 */       break;
/*     */     case 34310:
/* 267 */       body = new JT808MsgBody_0x8606();
/* 268 */       break;
/*     */     case 34311:
/* 270 */       body = new JT808MsgBody_0x8607();
/* 271 */       break;
/*     */     case 34560:
/* 273 */       body = new JT808MsgBody_0x8700();
/* 274 */       break;
/*     */     case 34561:
/* 276 */       body = new JT808MsgBody_0x8701();
/* 277 */       break;
/*     */     case 34816:
/* 279 */       body = new JT808MsgBody_0x8800();
/* 280 */       break;
/*     */     case 34817:
/* 282 */       body = new JT808MsgBody_0x8801();
/* 283 */       break;
/*     */     case 34818:
/* 285 */       body = new JT808MsgBody_0x8802();
/* 286 */       break;
/*     */     case 34819:
/* 288 */       body = new JT808MsgBody_0x8803();
/* 289 */       break;
/*     */     case 34820:
/* 291 */       body = new JT808MsgBody_0x8804();
/* 292 */       break;
/*     */     case 34821:
/* 294 */       body = new JT808MsgBody_0x8805();
/* 295 */       break;
/*     */     case 35072:
/* 297 */       body = new JT808MsgBody_0x8900();
/* 298 */       break;
/*     */     case 35328:
/* 300 */       body = new JT808MsgBody_0x8A00();
/* 301 */       break;
/*     */     }
/*     */ 
/* 305 */     if (body != null) {
/* 306 */       body.setBodyBuffer(pack.getMsgBodyBuffer());
/* 307 */       body.praseBody();
/* 308 */       pack.setMsgBody(body);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static boolean verifyCHK(IoBuffer packetBuffer) throws Exception {
/* 313 */     byte ret = packetBuffer.get();
/* 314 */     for (int i = 0; i < packetBuffer.limit() - 2; i++) {
/* 315 */       ret = (byte)(ret ^ packetBuffer.get());
/*     */     }
/* 317 */     byte chk = packetBuffer.get();
/* 318 */     packetBuffer.rewind();
/* 319 */     boolean result = ret == chk;
/* 320 */     return result;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 327 */     String code = "090104880136119923030003000000841F8B0800000000000400EDBD07601C499625262F6DCA7B7F4AF54AD7E074A10880601324D8904010ECC188CDE692EC1D69472329AB2A81CA6556655D661640CCED9DBCF7DE7BEFBDF7DE7BEFBDF7BA3B9D4E27F7DFFF3F5C6664016CF6CE4ADAC99E2180AAC81F3F7D027C1F3F227D028D5FF3D7FAB57F9D5F57FEFD7F00E3BA78D00C0000007D02";
/* 328 */     code = "0102000B014782492997001131343738323439323939371A";
/*     */     UnitPackJT808 pack;
/*     */     try {
/* 330 */       IoBuffer packetBuffer = IoBuffer.wrap(ByteUtil.hexString2byteArray(code));
/* 331 */       pack = prasePacket(packetBuffer);
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.UnitPackJT808Praser
 * JD-Core Version:    0.6.1
 */