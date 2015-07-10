/*     */ package com.china317.core.codec.jtt808_2011;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0001;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ import org.apache.mina.core.session.AttributeKey;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
/*     */ import org.apache.mina.filter.codec.ProtocolDecoderOutput;
/*     */ 
/*     */ public class JT808Decoder extends CumulativeProtocolDecoder
/*     */ {
/*  20 */   private static final Log log = LogFactory.getLog(JT808Decoder.class);
/*  21 */   private final AttributeKey CONTEXT = new AttributeKey(getClass(), "context");
/*  22 */   private static int DEFAULT_MAX_DATA_LENGTH = 2048;
/*     */ 
/*     */   protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception
/*     */   {
/*  26 */     log.debug("Veh Decoder...");
/*  27 */     int pos = in.position();
/*  28 */     byte[] decoderbytes = new byte[in.limit() - pos];
/*  29 */     in.get(decoderbytes);
/*  30 */     log.info("JT808Decoder received session[" + session.getId() + "] position[" + pos + "] datas : " + ByteUtil.byteArray2HexDump(decoderbytes));
/*     */ 
/*  32 */     in.position(pos);
/*     */ 
/*  34 */     Context ctx = getContext(session);
/*  35 */     IoBuffer buffer = ctx.innerBuffer;
/*  36 */     if (p_begin(in, buffer)) {
/*  37 */       if (buffer.limit() > 0) {
/*  38 */         IoBuffer buff = escape(buffer);
/*     */         try
/*     */         {
/*  41 */           UnitPackJT808 unit = UnitPackJT808Praser.prasePacket(buff);
/*  42 */           if (unit.isCRCResult()) {
/*  43 */             if (unit.getMsgID() == 1) {
/*  44 */               JT808MsgBody_0x0001 body = (JT808MsgBody_0x0001)unit.getMsgBody();
/*  45 */               if (body.getResponseMsgID() == 34817)
/*  46 */                 log.info(
/*  47 */                   "[ Receive 0001(8801) ] sessionID=" + session.getId() + ",sim=" + unit.getMobileNum() + ",sequence = " + unit.getSequenceNum());
/*  48 */               else if (body.getResponseMsgID() == 33027)
/*  49 */                 log.info(
/*  50 */                   "[ Receive 0001(8103) ] sessionID=" + session.getId() + ",sim=" + unit.getMobileNum() + ",sequence = " + unit.getSequenceNum() + ",result = " + body.getResult());
/*     */             }
/*  52 */             else if (unit.getMsgID() == 2048) {
/*  53 */               log.info(
/*  54 */                 "[ Receive 0800 ] sessionID=" + session.getId() + ",sim=" + unit.getMobileNum() + ",seq=" + unit.getSequenceNum());
/*  55 */             } else if (unit.getMsgID() == 2049) {
/*  56 */               log.info(
/*  57 */                 "[ Receive 0801 ] sessionID=" + session.getId() + ",sim=" + unit.getMobileNum() + ",seq=" + unit.getSequenceNum() + "," + unit.getMsgPacketNum() + 
/*  58 */                 "/" + unit.getMsgPacketCount());
/*     */             }
/*  60 */             unit.setSessionId(session.getId());
/*  61 */             out.write(unit);
/*     */           }
/*     */         } catch (Exception e) {
/*  64 */           log.error("", e);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  69 */       ctx.reset();
/*  70 */       return true;
/*     */     }
/*  72 */     if (buffer.position() > DEFAULT_MAX_DATA_LENGTH) {
/*  73 */       log.warn("reset ctx :" + ByteUtil.byteArray2HexDump(buffer.array()));
/*  74 */       ctx.reset();
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean p_begin(IoBuffer in, IoBuffer buffer)
/*     */   {
/*  82 */     if (buffer.position() > 0) {
/*  83 */       if (p_end(in, buffer)) {
/*  84 */         return true;
/*     */       }
/*  86 */       return false;
/*     */     }
/*     */ 
/*  89 */     while (in.hasRemaining()) {
/*  90 */       byte b = in.get();
/*  91 */       if (b == 126)
/*     */       {
/*  93 */         if (p_end(in, buffer)) {
/*  94 */           return true;
/*     */         }
/*  96 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean p_end(IoBuffer in, IoBuffer buffer)
/*     */   {
/* 106 */     while (in.hasRemaining()) {
/* 107 */       byte b = in.get();
/* 108 */       if (b == 126)
/*     */       {
/* 110 */         buffer.flip();
/* 111 */         return true;
/*     */       }
/* 113 */       buffer.put(b);
/* 114 */       if (buffer.position() > DEFAULT_MAX_DATA_LENGTH) {
/* 115 */         return false;
/*     */       }
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */ 
/*     */   private IoBuffer escape(IoBuffer buffer) {
/* 122 */     IoBuffer tempBuffer = IoBuffer.allocate(buffer.limit());
/* 123 */     while (buffer.hasRemaining()) {
/* 124 */       byte b1 = buffer.get();
/* 125 */       if (b1 == 125) {
/* 126 */         byte b2 = buffer.get();
/* 127 */         if (b2 == 2) {
/* 128 */           tempBuffer.put((byte)126);
/* 129 */         } else if (b2 == 1) {
/* 130 */           tempBuffer.put((byte)125);
/*     */         } else {
/* 132 */           tempBuffer.put(b1);
/* 133 */           tempBuffer.put(b2);
/*     */         }
/*     */       } else {
/* 136 */         tempBuffer.put(b1);
/*     */       }
/*     */     }
/* 139 */     tempBuffer.flip();
/* 140 */     return tempBuffer;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 144 */     JT808Decoder deocder = new JT808Decoder();
/* 145 */     byte[] barray = { 0, 126, 48, 125, 2, 8, 125, 1, 85, 126, 1 };
/* 146 */     IoBuffer in = IoBuffer.wrap(barray);
/* 147 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/* 148 */     boolean bool = deocder.p_begin(in, buffer);
/* 149 */     log.info(bool);
/* 150 */     buffer.flip();
/* 151 */     log.info(buffer.getHexDump());
/*     */   }
/*     */ 
/*     */   private Context getContext(IoSession session) {
/* 155 */     Context context = (Context)session.getAttribute(this.CONTEXT);
/* 156 */     if (context == null) {
/* 157 */       context = new Context();
/* 158 */       session.setAttribute(this.CONTEXT, context);
/*     */     }
/* 160 */     return context;
/*     */   }
/*     */ 
/*     */   private class Context
/*     */   {
/* 167 */     private final IoBuffer innerBuffer = IoBuffer.allocate(100).setAutoExpand(true);
/*     */ 
/*     */     public Context() {
/*     */     }
/* 171 */     public void reset() { this.innerBuffer.clear(); }
/*     */ 
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.JT808Decoder
 * JD-Core Version:    0.6.1
 */