/*     */ package com.china317.core.codec.jtt808Gateway;
/*     */ 
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ import org.apache.mina.core.session.AttributeKey;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
/*     */ import org.apache.mina.filter.codec.ProtocolDecoderOutput;
/*     */ 
/*     */ public class GatewayDecoder extends CumulativeProtocolDecoder
/*     */ {
/*  18 */   private static final Log log = LogFactory.getLog(GatewayDecoder.class);
/*  19 */   private final AttributeKey CONTEXT = new AttributeKey(getClass(), "context");
/*  20 */   private static int DEFAULT_MAX_DATA_LENGTH = 4196;
/*     */   private static final int headlen = 8;
/*     */ 
/*     */   protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
/*     */     throws Exception
/*     */   {
/*  25 */     log.debug("GatewayDecoder...");
/*  26 */     int pos = in.position();
/*  27 */     byte[] decoderbytes = new byte[in.limit() - pos];
/*  28 */     in.get(decoderbytes);
/*  29 */     log.debug("GatewayDecoder received session[" + session.getId() + "] position[" + pos + "] datas : " + com.china317.core.util.ByteUtil.byteArray2HexDump(decoderbytes));
/*     */ 
/*  31 */     in.position(pos);
/*     */ 
/*  34 */     Context ctx = getContext(session);
/*  35 */     IoBuffer buffer = ctx.innerBuffer;
/*     */     try {
/*  37 */       if (p_begin(in, buffer)) {
/*  38 */         if (buffer.limit() > 0)
/*     */         {
/*     */           try {
/*  41 */             GatewayUnitPack unit = GatewayUnitPackPraser.prasePacket(buffer);
/*  42 */             if (unit.isCRCResult()) {
/*  43 */               out.write(unit);
/*  44 */               log.debug("GatewayDecoder ok ..., unit cmd[" + unit.getCMD() + "]");
/*     */             } else {
/*  46 */               log.debug("GatewayDecoder no ..., isCRCResult is false");
/*     */             }
/*     */           } catch (Exception e) {
/*  49 */             log.error("", e);
/*     */           }
/*     */ 
/*  52 */           ctx.reset();
/*  53 */           return true;
/*     */         }
/*  55 */         ctx.reset();
/*  56 */         log.debug("GatewayDecoder no ..., buffer.limit() < 0");
/*  57 */         return false;
/*     */       }
/*     */ 
/*  61 */       if (buffer.position() > DEFAULT_MAX_DATA_LENGTH) {
/*  62 */         ctx.reset();
/*     */       }
/*  64 */       log.debug("GatewayDecoder no ..., not end...");
/*  65 */       return false;
/*     */     }
/*     */     catch (Exception e) {
/*  68 */       ctx.reset();
/*  69 */       log.error(buffer.toString());
/*  70 */       log.error(com.china317.core.codec.jtt808_2011.util.ByteUtil.getHexString(buffer.array()));
/*  71 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   private boolean p_begin(IoBuffer in, IoBuffer buffer)
/*     */     throws Exception
/*     */   {
/*  79 */     int bufferpos = buffer.position();
/*  80 */     if (bufferpos > 0) {
/*  81 */       if (bufferpos <= 8) {
/*  82 */         int rem = 8 - bufferpos;
/*  83 */         if (in.remaining() > rem) {
/*  84 */           for (int i = 0; i < rem; i++) {
/*  85 */             buffer.put(in.get());
/*     */           }
/*  87 */           return p_end(in, buffer);
/*     */         }
/*  89 */         buffer.put(in);
/*  90 */         return false;
/*     */       }
/*     */ 
/*  93 */       return p_end(in, buffer);
/*     */     }
/*     */ 
/*  96 */     int sign = 0;
/*  97 */     while (in.hasRemaining()) {
/*  98 */       byte b = in.get();
/*  99 */       if (b == -86) {
/* 100 */         sign = 1; } else {
/* 101 */         if ((b == -18) && (sign == 1)) {
/* 102 */           sign = 2;
/* 103 */           break;
/*     */         }
/* 105 */         sign = 0;
/*     */       }
/*     */     }
/* 108 */     if (sign == 1) {
/* 109 */       buffer.put((byte)-86);
/* 110 */       return false;
/* 111 */     }if (sign == 2) {
/* 112 */       buffer.put((byte)-86);
/* 113 */       buffer.put((byte)-18);
/* 114 */       int rem = 6;
/* 115 */       if (in.remaining() > rem) {
/* 116 */         for (int i = 0; i < rem; i++) {
/* 117 */           buffer.put(in.get());
/*     */         }
/* 119 */         return p_end(in, buffer);
/*     */       }
/* 121 */       buffer.put(in);
/* 122 */       return false;
/*     */     }
/*     */ 
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean p_end(IoBuffer in, IoBuffer buffer) throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 132 */       int blen = buffer.getUnsignedShort(2);
/* 133 */       int areadlen = buffer.position() - 8;
/* 134 */       int remainreadlen = blen - areadlen + 1;
/*     */ 
/* 136 */       if (in.remaining() >= remainreadlen) {
/* 137 */         for (int i = 0; i < remainreadlen; i++) {
/* 138 */           byte b = in.get();
/* 139 */           buffer.put(b);
/*     */         }
/* 141 */         buffer.flip();
/* 142 */         return true;
/*     */       }
/* 144 */       int i = 0;
/* 145 */       while (in.hasRemaining()) {
/* 146 */         byte b = in.get();
/* 147 */         buffer.put(b);
/*     */       }
/* 149 */       return false;
/*     */     }
/*     */     catch (Exception e) {
/* 152 */       log.error("1# " + in.arrayOffset() + "," + in.toString());
/* 153 */       log.error("1# " + com.china317.core.codec.jtt808_2011.util.ByteUtil.getHexString(in.array()));
/* 154 */       log.error("2# " + buffer.toString());
/* 155 */       log.error("2# " + com.china317.core.codec.jtt808_2011.util.ByteUtil.getHexString(buffer.array()));
/* 156 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/*     */     try {
/* 162 */       StringBuffer code = new StringBuffer();
/*     */ 
/* 165 */       code
/* 166 */         .append("AAEE08040012008611333232000000000000000000003302000026014782493021053C00000001008C800001DCB7EB073F64EC000B0000000012080807131301040000823F030200001A313231000000000000000000005C0200004F01367199825909EC000000000000000301E078EF07386489000A000100001208081327110104000002310202FFFF03020000200218E82102004C2202008C230200002404000000002504000000142604000001352801001A313137000000000000000000005C0200004F01367199877007DF000000000000000301E3BFFD06C2252C0050000000001208081326160104000036760202FFFF030200002002FFFF2102FFFF2202FFFF2302FFFF2404000000002504000000002604FFFFFFFF280100FC313432000000000000000000002F0200002201478194903200B9000000000000200301E58D1E072BEAED001002E80057120808132618010400017055A4313136000000000000000000005C0200004F0147819559840A5D000000000000200201DF3EA2071EFE5F000A0000000012080813260801040000F30C0202FFFF030200002002FFFF2102FFFF2202FFFF2302FFFF2404000000002504000000002604FFFFFFFF2801009933353500000000000000000000180102000B01478249301000543134373832343933303130C6313234000000000000000000000D000200000136417888560217C7313138000000000000000000005C0200004F01478190351909A9000000000000200301EBE20D072BC522000A010A00A8120808132516010400013FE30202FFFF0302010E2002FFFF2102FFFF2202FFFF2302FFFF2404000000002504000000002604FFFFFFFF2801003C313232000000000000000000005F020000520136719960230755000000020000000302160976071A455B000903C300CE12080813261301040002F40D0202FFFF030204241101002002FFFF2102FFFF2202FFFF2302FFFF2404000000002504000000002604FFFFFFFF2801000131303800000000000000000000180102000B014782493042009D31343738323439333034325A383500000000000000000000002F020000220147819025190F36000000000000200301DDA116073B3A60000D0000004B120808132619010400056B0649333834000000000000000000005C0200004F0159215368430CBC000000040000000301CE989A0729EF160019022400BC120808132616010400019B340202FFFF030201A420022088210201BC220200B7230200962404000000002504000000002604FFFFFFFF2801006233393800000000000000000000180102000B014782492993008A3134373832343932393933813231300000000000000000000033020000260147824908260188000000000384000301D02CF4072C9D4B000D0392003B1208081326180104000037A00302031A6C313231000000000000000000000D0002000001367199825909EDE2313032000000000000000000002F020000220147819024810241000000000000200301CE1D9307213406007002DF009D120808132622010400037AFF51333934000000000000000000039508012384014781955984E00200090003731F28C003352449D4F6AD9BD0C20B51E45626AEDFBF51FECFF53589B32943099E40AB8C9ADE53B126907448CE3F1E9FCAA65B08C7C600A4DB9AD09136734A179A0076DA5D940CB120F9E931505815A8D873548890D61D8533186AA20314DE8726801A7B5482948B892C7D6B6EE3FE418BFEF035250B08CC42948A604320C0FC6A265E735A189132E7A714C3D6803FFFD6CC236BA9ED9C1A632ED241A82861A6026A912C78269714C9171C548293296E2E2AE589EA2A4B3490E539FA558418415ACB63282D58D90E149AC3D587CF113DC1ACCD18CD38E26FA026B52E3E4D3189C832381F87F9152F742E865E334BB6B524365285A402EDE6971401291934A16A0D00AD44C3E6C5522643597F4A691CD5198CEF4D6EDF9D301ADD463A53C54C8B89247D6B62F1F6D9409FDECFE9528A25B33BADC548C29810B0C8A898715A231216E05467AD203FFFD7A53C7989BE94C9C676B7F780350595C8A6B0A689628A70AB207638A914722931ADC762A7B5F964A8342F799B38A97ED6981CD5BD9111D2E44F721FE506A9EAC331C6DE848FF3F9549454B3709282DD3045685DB37D9634639C37145B511540C9A701C74AA245FC28C7B5002E3D2971400F51935205A934118544546734D1121AE38A8FBE2A8923230693AD310DC8CE29F8A991A447A75AD5BE8DDACAD9D572884EE391C64002A464FA69CC03EB561C6298101EF504957D0C889AA26A047FFFD06BA650FD2A949CDBC2DEC40FC38A82C82908A6897B0878A755103C548064530250B9A7A0DAE2B3351DA91290A3A9FE2C7E60FF008566F98E7B9AAE84F5248E52AE189FD6ADDD38B8B2DCBCEC209FE548657B28C3BEE27EE1071EB56EEDB0635F41934C9224E453E98828CD0019E69738A00962E6A6DB526835C544475A68896C44C79C77A8CF0D9C0AB2063721BD69A7A53421A179E7D73520151246B1D8913835AB732E34A54FEF11FCC548C7E9A7F73F8D5A92981035577AB322173E951B1E2803FFD1955774759AFF00F1EC07649187F5A96522BE28238A103131CD156663FA54A94016231914E618359B352D0489C013A0741C906A445D3C0E2DA0FC501FE74C964BE75BA0F9638D47B201552EE749ADE40B8E54FF00F5A988CAB36C4C07F7B8A9EE9B74EDCF4C0A100C46C71526EE2980669375020CD04F340C9EDDB27156D7915250D71501A68996C40E339C75A6355902118A61EB4C418E453C0A891A4761E055DBB3FE816FFEF5228B1A69FDD1FAD5C92802B3F4A81CE70C60");
/*     */ 
/* 168 */       byte[] barray = com.china317.core.codec.jtt808_2011.util.ByteUtil.hexString2byteArray(code.toString());
/* 169 */       IoBuffer in = IoBuffer.wrap(barray);
/*     */ 
/* 171 */       while (in.hasRemaining()) {
/* 172 */         IoBuffer buffer = IoBuffer.allocate(2011).setAutoExpand(true);
/* 173 */         GatewayDecoder deocder = new GatewayDecoder();
/* 174 */         boolean bool = deocder.p_begin(in, buffer);
/* 175 */         if (bool)
/* 176 */           log.info(buffer.toString());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 180 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private Context getContext(IoSession session) {
/* 185 */     Context context = (Context)session.getAttribute(this.CONTEXT);
/* 186 */     if (context == null) {
/* 187 */       context = new Context();
/* 188 */       session.setAttribute(this.CONTEXT, context);
/*     */     }
/* 190 */     return context;
/*     */   }
/*     */ 
/*     */   private class Context
/*     */   {
/* 197 */     private final IoBuffer innerBuffer = IoBuffer.allocate(4196).setAutoExpand(true);
/*     */ 
/*     */     public Context() {
/*     */     }
/* 201 */     public void reset() { this.innerBuffer.clear(); }
/*     */ 
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.GatewayDecoder
 * JD-Core Version:    0.6.1
 */