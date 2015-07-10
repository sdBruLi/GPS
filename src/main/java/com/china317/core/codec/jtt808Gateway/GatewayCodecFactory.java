/*    */ package com.china317.core.codec.jtt808Gateway;
/*    */ 
/*    */ import org.apache.mina.core.session.IoSession;
/*    */ import org.apache.mina.filter.codec.ProtocolCodecFactory;
/*    */ import org.apache.mina.filter.codec.ProtocolDecoder;
/*    */ import org.apache.mina.filter.codec.ProtocolEncoder;
/*    */ 
/*    */ public class GatewayCodecFactory
/*    */   implements ProtocolCodecFactory
/*    */ {
/*    */   private final GatewayEncoder encoder;
/*    */   private final GatewayDecoder decoder;
/*    */ 
/*    */   public GatewayCodecFactory()
/*    */   {
/* 17 */     this.encoder = new GatewayEncoder();
/* 18 */     this.decoder = new GatewayDecoder();
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
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.GatewayCodecFactory
 * JD-Core Version:    0.6.1
 */