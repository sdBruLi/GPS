/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0301;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class EventReportMessage extends BaseUpMessage
/*    */ {
/* 15 */   private static final Log log = LogFactory.getLog(EventReportMessage.class);
/*    */   private int eventId;
/*    */ 
/*    */   public EventReportMessage()
/*    */   {
/* 19 */     setCommand("0x0301");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 24 */     unpackHeadPart(pack);
/*    */     try {
/* 26 */       JT808MsgBody_0x0301 body = (JT808MsgBody_0x0301)pack.getMsgBody();
/* 27 */       setEventId(body.getEventId());
/*    */     } catch (Exception e) {
/* 29 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getEventId() {
/* 34 */     return this.eventId;
/*    */   }
/*    */ 
/*    */   public void setEventId(int eventId)
/*    */   {
/* 39 */     this.eventId = eventId;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.EventReportMessage
 * JD-Core Version:    0.6.1
 */