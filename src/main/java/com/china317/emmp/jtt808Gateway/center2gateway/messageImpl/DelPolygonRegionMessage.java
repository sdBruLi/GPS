/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8605;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DelPolygonRegionMessage extends BaseDownMessage
/*    */ {
/*    */   private byte regionCount;
/*    */   private List<Integer> regionIdList;
/*    */ 
/*    */   public DelPolygonRegionMessage(String mobileNum, String messageKey, List<Integer> regionIdList)
/*    */   {
/* 29 */     setMobileNum(mobileNum);
/* 30 */     setMessageKey(messageKey);
/* 31 */     if (regionIdList != null) {
/* 32 */       setRegionCount((byte)regionIdList.size());
/* 33 */       setRegionIdList(regionIdList);
/*    */     }
/* 35 */     setCommand("0x8605");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 40 */     UnitPackJT808 pack = new UnitPackJT808(34309);
/* 41 */     pack.setMobileNum(getMobileNum());
/* 42 */     JT808MsgBody_0x8605 body = new JT808MsgBody_0x8605();
/* 43 */     if (this.regionIdList != null) {
/* 44 */       body.setRegionCount((byte)this.regionIdList.size());
/* 45 */       body.setRegionIdList(this.regionIdList);
/*    */     }
/* 47 */     pack.setMsgBody(body);
/* 48 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getRegionCount() {
/* 52 */     return this.regionCount;
/*    */   }
/*    */ 
/*    */   public void setRegionCount(byte regionCount)
/*    */   {
/* 57 */     this.regionCount = regionCount;
/*    */   }
/*    */ 
/*    */   public List<Integer> getRegionIdList() {
/* 61 */     return this.regionIdList;
/*    */   }
/*    */ 
/*    */   public void setRegionIdList(List<Integer> regionIdList)
/*    */   {
/* 66 */     this.regionIdList = regionIdList;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.DelPolygonRegionMessage
 * JD-Core Version:    0.6.1
 */