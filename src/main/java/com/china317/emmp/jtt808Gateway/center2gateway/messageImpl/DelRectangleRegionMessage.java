/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8603;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DelRectangleRegionMessage extends BaseDownMessage
/*    */ {
/*    */   private byte regionCount;
/*    */   private List<Integer> regionIdList;
/*    */ 
/*    */   public DelRectangleRegionMessage(String mobileNum, String messageKey, List<Integer> regionIdList)
/*    */   {
/* 29 */     setMobileNum(mobileNum);
/* 30 */     setMessageKey(messageKey);
/* 31 */     setRegionIdList(regionIdList);
/* 32 */     setCommand("0x8603");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 37 */     UnitPackJT808 pack = new UnitPackJT808(34307);
/* 38 */     pack.setMobileNum(getMobileNum());
/* 39 */     JT808MsgBody_0x8603 body = new JT808MsgBody_0x8603();
/* 40 */     if (this.regionIdList != null) {
/* 41 */       body.setRegionCount((byte)this.regionIdList.size());
/* 42 */       body.setRegionIdList(this.regionIdList);
/*    */     }
/* 44 */     pack.setMsgBody(body);
/* 45 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getRegionCount()
/*    */   {
/* 50 */     return this.regionCount;
/*    */   }
/*    */ 
/*    */   public void setRegionCount(byte regionCount) {
/* 54 */     this.regionCount = regionCount;
/*    */   }
/*    */ 
/*    */   public List<Integer> getRegionIdList() {
/* 58 */     return this.regionIdList;
/*    */   }
/*    */ 
/*    */   public void setRegionIdList(List<Integer> regionIdList)
/*    */   {
/* 63 */     this.regionIdList = regionIdList;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.DelRectangleRegionMessage
 * JD-Core Version:    0.6.1
 */