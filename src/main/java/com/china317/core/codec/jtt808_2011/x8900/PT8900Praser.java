/*     */ package com.china317.core.codec.jtt808_2011.x8900;
/*     */ 
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class PT8900Praser
/*     */ {
/*   8 */   private static Log log = LogFactory.getLog(PT8900Praser.class);
/*     */ 
/*     */   public static F1MsgDataPack prasePacket(IoBuffer packetBuffer) {
/*     */     try {
/*  12 */       int ptmsgid = packetBuffer.getUnsignedShort();
/*  13 */       int len = packetBuffer.getUnsignedShort();
/*  14 */       byte[] data = new byte[len];
/*  15 */       if (len != packetBuffer.remaining()) {
/*  16 */         data = new byte[len + 28];
/*     */       }
/*  18 */       packetBuffer.get(data);
/*  19 */       packetBuffer.rewind();
/*     */ 
/*  21 */       F1MsgDataPack ptmsg = null;
/*  22 */       switch (ptmsgid) {
/*     */       case 1:
/*  24 */         ptmsg = new F1scanUpload4Dynamic(len, IoBuffer.wrap(data));
/*  25 */         break;
/*     */       case 17:
/*  27 */         ptmsg = new F1scanUpload4Still(len, IoBuffer.wrap(data));
/*  28 */         break;
/*     */       case 18:
/*  30 */         ptmsg = new F1inventory(len, IoBuffer.wrap(data));
/*  31 */         break;
/*     */       case 24:
/*  33 */         ptmsg = new F1openCoffer(len, IoBuffer.wrap(data));
/*  34 */         break;
/*     */       case 25:
/*  36 */         ptmsg = new F1sellCertification(len, IoBuffer.wrap(data));
/*  37 */         break;
/*     */       case 33:
/*  39 */         ptmsg = new F1check(len, IoBuffer.wrap(data));
/*  40 */         break;
/*     */       case 34:
/*  42 */         ptmsg = new F1inspector(len, IoBuffer.wrap(data));
/*  43 */         break;
/*     */       case 35:
/*  45 */         ptmsg = new F1forensics(len, IoBuffer.wrap(data));
/*  46 */         break;
/*     */       case 36:
/*  48 */         ptmsg = new F1lineStorage(len, IoBuffer.wrap(data));
/*  49 */         break;
/*     */       case 37:
/*  51 */         ptmsg = new F1outTreasury(len, IoBuffer.wrap(data));
/*  52 */         break;
/*     */       case 38:
/*  54 */         ptmsg = new F1lineStorage4s(len, IoBuffer.wrap(data));
/*  55 */         break;
/*     */       case 39:
/*  57 */         ptmsg = new F1sallProduct(len, IoBuffer.wrap(data));
/*     */       }
/*     */ 
/*  60 */       if (ptmsg != null) {
/*  61 */         ptmsg.praser();
/*     */       }
/*  63 */       return ptmsg;
/*     */     } catch (Exception e) {
/*  65 */       log.error(e.toString(), e);
/*  66 */     }return null;
/*     */   }
/*     */ 
/*     */   public static F1MsgDataPack prasePacketDown(IoBuffer packetBuffer)
/*     */   {
/*     */     try {
/*  72 */       int ptmsgid = packetBuffer.getUnsignedShort();
/*  73 */       int len = packetBuffer.getUnsignedShort();
/*  74 */       byte[] data = new byte[len];
/*  75 */       packetBuffer.get(data);
/*  76 */       packetBuffer.rewind();
/*     */ 
/*  78 */       F1MsgDataPack ptmsg = null;
/*  79 */       switch (ptmsgid) {
/*     */       case 32771:
/*  81 */         ptmsg = new F1setUploadInterval(len, IoBuffer.wrap(data));
/*  82 */         break;
/*     */       case 32787:
/*  84 */         ptmsg = new F1setUploadInterval(len, IoBuffer.wrap(data), false);
/*  85 */         break;
/*     */       case 32785:
/*  87 */         ptmsg = new F1inventoryStart(32785, len, IoBuffer.wrap(data));
/*  88 */         break;
/*     */       case 32801:
/*  90 */         ptmsg = new F1checkStart(IoBuffer.wrap(data));
/*  91 */         break;
/*     */       case 32770:
/*  93 */         break;
/*     */       case 32772:
/*  95 */         break;
/*     */       case 32792:
/*  97 */         break;
/*     */       case 32802:
/*     */       }
/*     */ 
/* 101 */       if (ptmsg != null) {
/* 102 */         ptmsg.praser();
/*     */       }
/* 104 */       return ptmsg;
/*     */     } catch (Exception e) {
/* 106 */       log.error(e.toString(), e);
/* 107 */     }return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.PT8900Praser
 * JD-Core Version:    0.6.1
 */