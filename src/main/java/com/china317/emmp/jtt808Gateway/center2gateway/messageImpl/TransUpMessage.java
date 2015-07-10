/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0900;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class TransUpMessage extends BaseUpMessage
/*    */ {
/* 16 */   private static final Log log = LogFactory.getLog(TransUpMessage.class);
/*    */   private byte transType;
/*    */   private IoBuffer dataBlock;
/*    */ 
/*    */   public TransUpMessage()
/*    */   {
/* 21 */     setCommand("0x0900");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 26 */     unpackHeadPart(pack);
/*    */     try {
/* 28 */       JT808MsgBody_0x0900 body = (JT808MsgBody_0x0900)pack.getMsgBody();
/* 29 */       setTransType(body.getTransType());
/* 30 */       setDataBlock(body.getDataBlock());
/*    */     } catch (Exception e) {
/* 32 */       log.debug("unpack fail ", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public byte getTransType() {
/* 37 */     return this.transType;
/*    */   }
/*    */ 
/*    */   public void setTransType(byte transType) {
/* 41 */     this.transType = transType;
/*    */   }
/*    */ 
/*    */   public IoBuffer getDataBlock() {
/* 45 */     return this.dataBlock;
/*    */   }
/*    */ 
/*    */   public void setDataBlock(IoBuffer dataBlock) {
/* 49 */     this.dataBlock = dataBlock;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TransUpMessage
 * JD-Core Version:    0.6.1
 */