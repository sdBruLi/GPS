/*    */ package com.china317.core.codec.jtt809_2011;
/*    */ 
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ import org.apache.mina.filter.codec.ProtocolCodecFactory;
/*    */ import org.apache.mina.filter.codec.ProtocolDecoder;
/*    */ import org.apache.mina.filter.codec.ProtocolEncoder;
/*    */ 
/*    */ public class CodecFactory
/*    */   implements ProtocolCodecFactory
/*    */ {
/*    */   private CodecConfig codecConfig;
/*    */   private ProtocolDecoder decoder;
/*    */   private ProtocolEncoder encoder;
/*    */ 
/*    */   public CodecFactory(CodecConfig codecConfig)
/*    */   {
/* 15 */     this.codecConfig = codecConfig;
/* 16 */     this.decoder = new Decoder(this.codecConfig);
/* 17 */     this.encoder = new Encoder(this.codecConfig);
/*    */   }
/*    */ 
/*    */   public ProtocolDecoder getDecoder(IoSession arg0) throws Exception
/*    */   {
/* 22 */     return this.decoder;
/*    */   }
/*    */ 
/*    */   public ProtocolEncoder getEncoder(IoSession arg0) throws Exception
/*    */   {
/* 27 */     return this.encoder;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.CodecFactory
 * JD-Core Version:    0.6.1
 */