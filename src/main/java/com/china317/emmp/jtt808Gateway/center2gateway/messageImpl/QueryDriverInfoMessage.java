/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ 
/*    */ public class QueryDriverInfoMessage extends BaseDownMessage
/*    */ {
/*    */   public QueryDriverInfoMessage(String mobileNum, String messageKey)
/*    */   {
/* 15 */     setCommand("0x8702");
/* 16 */     setMobileNum(mobileNum);
/* 17 */     setMessageKey(messageKey);
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception {
/* 21 */     UnitPackJT808 pack = new UnitPackJT808(34562);
/* 22 */     pack.setMobileNum(getMobileNum());
/* 23 */     return pack;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.QueryDriverInfoMessage
 * JD-Core Version:    0.6.1
 */