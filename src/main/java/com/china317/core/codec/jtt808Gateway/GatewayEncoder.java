/*    */ package com.china317.core.codec.jtt808Gateway;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.SequenceNumProducer;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
/*    */ import org.apache.mina.filter.codec.ProtocolEncoderOutput;
/*    */ 
/*    */ public class GatewayEncoder extends ProtocolEncoderAdapter
/*    */ {
/* 17 */   private static final Log log = LogFactory.getLog(GatewayEncoder.class);
/*    */ 
/*    */   public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
/* 20 */     if ((message instanceof GatewayUnitPack)) {
/* 21 */       GatewayUnitPack pack = (GatewayUnitPack)message;
/* 22 */       if (pack.getSequenceNum() == 0) {
/* 23 */         pack.setSequenceNum(SequenceNumProducer.getSequenceNum(String.valueOf(session.getId())));
/*    */       }
/* 25 */       IoBuffer buff1 = pack.getPacketBuffer();
/* 26 */       if (pack.getPacketBuffer() == null) {
/* 27 */         buff1 = GatewayUnitPackBuilder.buildPacket(pack);
/*    */       }
/*    */ 
/* 30 */       out.write(buff1);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.GatewayEncoder
 * JD-Core Version:    0.6.1
 */