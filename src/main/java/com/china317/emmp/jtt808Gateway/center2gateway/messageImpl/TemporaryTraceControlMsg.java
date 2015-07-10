/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8202;
/*    */ 
/*    */ public class TemporaryTraceControlMsg extends BaseDownMessage
/*    */ {
/*    */   public static final byte STOP_TRACE = 0;
/*    */   private short interval;
/*    */   private int availablePeriod;
/*    */ 
/*    */   public TemporaryTraceControlMsg(String mobileNum, String messageKey, short interval, int availablePeriod)
/*    */   {
/* 31 */     setMobileNum(mobileNum);
/* 32 */     setMessageKey(messageKey);
/* 33 */     setInterval(interval);
/* 34 */     setAvailablePeriod(availablePeriod);
/* 35 */     setCommand("0x8202");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 40 */     UnitPackJT808 pack = new UnitPackJT808(33282);
/* 41 */     pack.setMobileNum(getMobileNum());
/* 42 */     JT808MsgBody_0x8202 body = new JT808MsgBody_0x8202();
/* 43 */     body.setInterval(getInterval());
/* 44 */     body.setAvailablePeriod(getAvailablePeriod());
/* 45 */     pack.setMsgBody(body);
/* 46 */     return pack;
/*    */   }
/*    */ 
/*    */   public short getInterval() {
/* 50 */     return this.interval;
/*    */   }
/*    */ 
/*    */   public void setInterval(short interval)
/*    */   {
/* 55 */     this.interval = interval;
/*    */   }
/*    */ 
/*    */   public int getAvailablePeriod() {
/* 59 */     return this.availablePeriod;
/*    */   }
/*    */ 
/*    */   public void setAvailablePeriod(int availablePeriod)
/*    */   {
/* 64 */     this.availablePeriod = availablePeriod;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TemporaryTraceControlMsg
 * JD-Core Version:    0.6.1
 */