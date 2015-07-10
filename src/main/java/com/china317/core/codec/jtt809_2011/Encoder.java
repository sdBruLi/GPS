/*    */ package com.china317.core.codec.jtt809_2011;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.SequenceNumProducer;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
/*    */ import org.apache.mina.filter.codec.ProtocolEncoderOutput;
/*    */ 
/*    */ public class Encoder extends ProtocolEncoderAdapter
/*    */ {
/* 15 */   private static final Log log = LogFactory.getLog(Encoder.class);
/*    */   private CodecConfig codecConfig;
/*    */ 
/*    */   public Encoder(CodecConfig codecConfig)
/*    */   {
/* 19 */     this.codecConfig = codecConfig;
/*    */   }
/*    */ 
/*    */   public void encode(IoSession session, Object object, ProtocolEncoderOutput output) throws Exception {
/* 23 */     if ((object instanceof DataPacketJTT809)) {
/* 24 */       DataPacketJTT809 dataPacket = (DataPacketJTT809)object;
/* 25 */       if (dataPacket.getHeadPart().getMsgSN() == 0L) {
/* 26 */         dataPacket.getHeadPart().setMsgSN(SequenceNumProducer.getSequenceNum(String.valueOf(session.getId())));
/*    */       }
/* 28 */       IoBuffer buffer = IoBuffer.allocate(this.codecConfig.getDefaultDataPacketLength()).setAutoExpand(true);
/* 29 */       buffer.put(dataPacket.build());
/* 30 */       buffer.flip();
/*    */ 
/* 33 */       byte[] decoderbytes = new byte[buffer.limit()];
/* 34 */       buffer.get(decoderbytes);
/* 35 */       log.debug("JT809Encoder received session[" + session.getId() + "] datas : " + ByteUtil.byteArray2HexDump(decoderbytes));
/*    */ 
/* 37 */       if ((dataPacket.getHeadPart().getMsgGnssCenterId() == 111119) || (dataPacket.getHeadPart().getMsgGnssCenterId() == 310000)) {
/* 38 */         log.info("JT809Encoder received session[" + session.getId() + "] datas : " + ByteUtil.byteArray2HexDump(decoderbytes));
/*    */       }
/* 40 */       buffer.rewind();
/* 41 */       output.write(buffer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.Encoder
 * JD-Core Version:    0.6.1
 */