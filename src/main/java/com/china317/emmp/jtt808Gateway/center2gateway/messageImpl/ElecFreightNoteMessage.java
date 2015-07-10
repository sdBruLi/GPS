/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0701;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class ElecFreightNoteMessage extends BaseUpMessage
/*    */ {
/* 15 */   private static final Log log = LogFactory.getLog(ElecFreightNoteMessage.class);
/*    */   private String freightNoteContent;
/*    */ 
/*    */   public ElecFreightNoteMessage()
/*    */   {
/* 19 */     setCommand("0x0701");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 24 */     unpackHeadPart(pack);
/*    */     try {
/* 26 */       JT808MsgBody_0x0701 body = (JT808MsgBody_0x0701)pack.getMsgBody();
/* 27 */       setFreightNoteContent(body.getElecFreightNoteLine());
/*    */     } catch (Exception e) {
/* 29 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getFreightNoteContent() {
/* 34 */     return this.freightNoteContent;
/*    */   }
/*    */ 
/*    */   public void setFreightNoteContent(String freightNoteContent)
/*    */   {
/* 39 */     this.freightNoteContent = freightNoteContent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ElecFreightNoteMessage
 * JD-Core Version:    0.6.1
 */