/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0108;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class TerminalUpdateResult extends BaseUpMessage
/*    */ {
/* 15 */   private static final Log log = LogFactory.getLog(TerminalUpdateResult.class);
/*    */   private byte updateType;
/*    */   private byte result;
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 21 */     unpackHeadPart(pack);
/*    */     try {
/* 23 */       JT808MsgBody_0x0108 body = (JT808MsgBody_0x0108)pack.getMsgBody();
/* 24 */       this.updateType = body.getUpdateType();
/* 25 */       this.result = body.getResult();
/*    */     }
/*    */     catch (Exception e) {
/* 28 */       log.debug("unpack fail ", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public byte getUpdateType() {
/* 33 */     return this.updateType;
/*    */   }
/*    */ 
/*    */   public void setUpdateType(byte updateType) {
/* 37 */     this.updateType = updateType;
/*    */   }
/*    */ 
/*    */   public byte getResult() {
/* 41 */     return this.result;
/*    */   }
/*    */ 
/*    */   public void setResult(byte result) {
/* 45 */     this.result = result;
/*    */   }
/*    */ 
/*    */   public static Log getLog() {
/* 49 */     return log;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TerminalUpdateResult
 * JD-Core Version:    0.6.1
 */