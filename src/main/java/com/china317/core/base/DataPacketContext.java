/*    */ package com.china317.core.base;
/*    */ 
/*    */ public class DataPacketContext
/*    */ {
/*    */   private String protocolName;
/*    */   private String protocolversion;
/*    */ 
/*    */   public String getProtocolName()
/*    */   {
/* 15 */     return this.protocolName;
/*    */   }
/*    */   public String getProtocolVersion() {
/* 18 */     return this.protocolversion;
/*    */   }
/*    */ 
/*    */   public DataPacketContext(String protocolName, String protocolversion)
/*    */   {
/* 27 */     this.protocolName = protocolName;
/* 28 */     this.protocolversion = protocolversion;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.base.DataPacketContext
 * JD-Core Version:    0.6.1
 */