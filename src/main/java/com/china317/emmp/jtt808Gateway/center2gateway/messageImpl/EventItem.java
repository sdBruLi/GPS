/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ public class EventItem
/*    */ {
/*    */   private int eventId;
/*    */   private String eventContent;
/*    */ 
/*    */   public EventItem()
/*    */   {
/*    */   }
/*    */ 
/*    */   public EventItem(byte eventId, String eventContent)
/*    */   {
/* 13 */     this.eventId = eventId;
/* 14 */     this.eventContent = eventContent;
/*    */   }
/*    */ 
/*    */   public int getEventId() {
/* 18 */     return this.eventId;
/*    */   }
/*    */ 
/*    */   public void setEventId(int eventId) {
/* 22 */     this.eventId = eventId;
/*    */   }
/*    */ 
/*    */   public String getEventContent() {
/* 26 */     return this.eventContent;
/*    */   }
/*    */ 
/*    */   public void setEventContent(String eventContent) {
/* 30 */     this.eventContent = eventContent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.EventItem
 * JD-Core Version:    0.6.1
 */