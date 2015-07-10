/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8607 extends JT808MsgBody
/*    */ {
/*    */   private byte regionCount;
/*    */   private List<Integer> regionIdList;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!isBuildBody()) {
/* 19 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 20 */       this.bodyBuffer.put(this.regionCount);
/* 21 */       if (this.regionIdList != null) {
/* 22 */         for (Integer i : this.regionIdList) {
/* 23 */           this.bodyBuffer.putInt(i.intValue());
/*    */         }
/*    */       }
/* 26 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createDelRoute(String mobileNum, List<Integer> regionIdList)
/*    */     throws Exception
/*    */   {
/* 42 */     UnitPackJT808 pack = new UnitPackJT808(34311);
/* 43 */     pack.setMobileNum(mobileNum);
/* 44 */     JT808MsgBody_0x8607 body = new JT808MsgBody_0x8607();
/* 45 */     if (regionIdList != null) {
/* 46 */       body.setRegionCount((byte)regionIdList.size());
/* 47 */       body.setRegionIdList(regionIdList);
/*    */     }
/* 49 */     pack.setMsgBody(body);
/* 50 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getRegionCount() {
/* 54 */     return this.regionCount;
/*    */   }
/*    */ 
/*    */   public void setRegionCount(byte regionCount) {
/* 58 */     this.regionCount = regionCount;
/*    */   }
/*    */ 
/*    */   public List<Integer> getRegionIdList() {
/* 62 */     return this.regionIdList;
/*    */   }
/*    */ 
/*    */   public void setRegionIdList(List<Integer> regionIdList) {
/* 66 */     this.regionIdList = regionIdList;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8607
 * JD-Core Version:    0.6.1
 */