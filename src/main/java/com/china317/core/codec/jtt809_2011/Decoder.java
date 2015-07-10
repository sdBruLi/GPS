/*    */ package com.china317.core.codec.jtt809_2011;
/*    */ 
/*    */ import com.china317.core.base.AbstractDataPacket;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
/*    */ import org.apache.mina.filter.codec.ProtocolDecoderOutput;
/*    */ 
/*    */ public class Decoder extends CumulativeProtocolDecoder
/*    */ {
/* 14 */   private static final Log log = LogFactory.getLog(Decoder.class);
/*    */ 
/* 16 */   private final String AttributeKey_Buffer = "AttributeKey_Buffer";
/*    */   private CodecConfig codecConfig;
/*    */ 
/*    */   public Decoder(CodecConfig codecConfig)
/*    */   {
/* 21 */     this.codecConfig = codecConfig;
/*    */   }
/*    */ 
/*    */   protected boolean doDecode(IoSession session, IoBuffer input, ProtocolDecoderOutput output)
/*    */     throws Exception
/*    */   {
/* 27 */     log.debug("Gmmp Decoder...");
/* 28 */     int pos = input.position();
/* 29 */     byte[] decoderbytes = new byte[input.limit() - pos];
/* 30 */     input.get(decoderbytes);
/* 31 */     log.debug("JT809Decoder received session[" + session.getId() + "] position[" + pos + "] datas : " + ByteUtil.byteArray2HexDump(decoderbytes));
/* 32 */     input.position(pos);
/*    */ 
/* 35 */     IoBuffer buffer = getBuffer(session);
/* 36 */     while (input.hasRemaining()) {
/* 37 */       byte b = input.get();
/* 38 */       if (!hasHeadFlag(buffer)) {
/* 39 */         if (b == 91) {
/* 40 */           buffer.put(b);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 45 */         if (b == 93) {
/* 46 */           buffer.put(b);
/* 47 */           buffer.flip();
/* 48 */           AbstractDataPacket dataPacket = DataPacketParser.parse(buffer, this.codecConfig, session.getId());
/* 49 */           output.write(dataPacket);
/* 50 */           buffer.clear();
/* 51 */           return true;
/*    */         }
/* 53 */         buffer.put(b);
/*    */       }
/*    */     }
/*    */ 
/* 57 */     return false;
/*    */   }
/*    */ 
/*    */   private boolean hasHeadFlag(IoBuffer buffer) {
/* 61 */     return buffer.position() > 0;
/*    */   }
/*    */   private IoBuffer getBuffer(IoSession session) {
/* 64 */     IoBuffer buffer = (IoBuffer)session.getAttribute("AttributeKey_Buffer");
/* 65 */     if (buffer == null) {
/* 66 */       buffer = initBuffer();
/* 67 */       session.setAttribute("AttributeKey_Buffer", buffer);
/*    */     }
/* 69 */     return buffer;
/*    */   }
/*    */   private IoBuffer initBuffer() {
/* 72 */     return IoBuffer.allocate(this.codecConfig.getDefaultDataPacketLength()).setAutoExpand(true);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.Decoder
 * JD-Core Version:    0.6.1
 */