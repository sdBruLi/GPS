/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0A00;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class TerminalRSAMessage extends BaseUpMessage
/*    */ {
/* 15 */   private static final Log log = LogFactory.getLog(TerminalRSAMessage.class);
/*    */   private int e;
/*    */   private byte[] n;
/*    */ 
/*    */   public TerminalRSAMessage()
/*    */   {
/* 20 */     setCommand("0x0a00");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 25 */     unpackHeadPart(pack);
/*    */     try {
/* 27 */       JT808MsgBody_0x0A00 body = (JT808MsgBody_0x0A00)pack.getMsgBody();
/* 28 */       setE(body.getE());
/* 29 */       setN(body.getN());
/*    */     } catch (Exception e) {
/* 31 */       log.debug("unpack fail ", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getE() {
/* 36 */     return this.e;
/*    */   }
/*    */ 
/*    */   public void setE(int e) {
/* 40 */     this.e = e;
/*    */   }
/*    */ 
/*    */   public byte[] getN() {
/* 44 */     return this.n;
/*    */   }
/*    */ 
/*    */   public void setN(byte[] n) {
/* 48 */     this.n = n;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TerminalRSAMessage
 * JD-Core Version:    0.6.1
 */