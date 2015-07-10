/*    */ package com.china317.core.codec.jtt808_2011;
/*    */ 
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ import org.apache.mina.filter.codec.ProtocolCodecFactory;
/*    */ import org.apache.mina.filter.codec.ProtocolDecoder;
/*    */ import org.apache.mina.filter.codec.ProtocolEncoder;
/*    */ 
/*    */ public class JT808CodecFactory
/*    */   implements ProtocolCodecFactory
/*    */ {
/*    */   private final JT808Encoder encoder;
/*    */   private final JT808Decoder decoder;
/*    */ 
/*    */   public JT808CodecFactory()
/*    */   {
/* 17 */     this.encoder = new JT808Encoder();
/* 18 */     this.decoder = new JT808Decoder();
/*    */   }
/*    */ 
/*    */   public ProtocolDecoder getDecoder(IoSession session) throws Exception
/*    */   {
/* 23 */     return this.decoder;
/*    */   }
/*    */ 
/*    */   public ProtocolEncoder getEncoder(IoSession session) throws Exception
/*    */   {
/* 28 */     return this.encoder;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.JT808CodecFactory
 * JD-Core Version:    0.6.1
 */