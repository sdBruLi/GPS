/*    */ package com.china317.core.codec.jtt808_2011;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8001;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8800;
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import com.china317.core.codec.jtt808_2011.util.SequenceNumProducer;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
/*    */ import org.apache.mina.filter.codec.ProtocolEncoderOutput;
/*    */ 
/*    */ public class JT808Encoder extends ProtocolEncoderAdapter
/*    */ {
/* 21 */   private static final Log log = LogFactory.getLog(JT808Encoder.class);
/*    */ 
/*    */   public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception
/*    */   {
/* 25 */     log.debug("Veh Encoder...");
/* 26 */     if ((message instanceof UnitPackJT808)) {
/* 27 */       UnitPackJT808 pack = (UnitPackJT808)message;
/* 28 */       if (pack.getSequenceNum() == 0) {
/* 29 */         pack.setSequenceNum(SequenceNumProducer.getSequenceNum(String.valueOf(session.getId())));
/*    */       }
/* 31 */       IoBuffer buff1 = UnitPackJT808Builder.buildPacket(pack);
/*    */ 
/* 33 */       if (pack.getMsgID() == 34817) {
/* 34 */         log.info(
/* 35 */           "[ Send 8801 ] sessionID=" + session.getId() + ",sim=" + pack.getMobileNum() + ", sequence:" + 
/* 36 */           pack.getSequenceNum());
/* 37 */       } else if (pack.getMsgID() == 32769) {
/* 38 */         JT808MsgBody_0x8001 body = (JT808MsgBody_0x8001)pack.getMsgBody();
/* 39 */         if (body.getResponseMsgID() == 2048) {
/* 40 */           log.info(
/* 41 */             "[ Send 8001 ] sessionID=" + session.getId() + ",sim=" + pack.getMobileNum());
/*    */         }
/*    */         else
/* 44 */           log.info("sessionID=" + session.getRemoteAddress() + " write:" + ByteUtil.getHexString(buff1));
/*    */       }
/* 46 */       else if (pack.getMsgID() == 34816) {
/* 47 */         JT808MsgBody_0x8800 body = (JT808MsgBody_0x8800)pack.getMsgBody();
/* 48 */         log.info(
/* 49 */           "[ Send 8800 ] sessionID=" + session.getId() + ",sim=" + pack.getMobileNum() + 
/* 50 */           ",retryPackageQuantity =  " + body.getRetransPkgSum());
/*    */       }
/*    */       else {
/* 53 */         log.info("sessionID=" + session.getRemoteAddress() + " write:" + ByteUtil.getHexString(buff1));
/*    */       }
/*    */ 
/* 56 */       IoBuffer buff2 = escape(buff1);
/* 57 */       out.write(buff2);
/*    */     }
/*    */   }
/*    */ 
/*    */   private IoBuffer escape(IoBuffer buffer) {
/* 62 */     IoBuffer tempBuffer = IoBuffer.allocate(buffer.limit() + 2).setAutoExpand(true);
/* 63 */     tempBuffer.put((byte)126);
/* 64 */     while (buffer.hasRemaining()) {
/* 65 */       byte b1 = buffer.get();
/* 66 */       if (b1 == 125) {
/* 67 */         tempBuffer.put((byte)125);
/* 68 */         tempBuffer.put((byte)1);
/* 69 */       } else if (b1 == 126) {
/* 70 */         tempBuffer.put((byte)125);
/* 71 */         tempBuffer.put((byte)2);
/*    */       } else {
/* 73 */         tempBuffer.put(b1);
/*    */       }
/*    */     }
/* 76 */     tempBuffer.put((byte)126);
/* 77 */     tempBuffer.flip();
/* 78 */     return tempBuffer.slice();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.JT808Encoder
 * JD-Core Version:    0.6.1
 */