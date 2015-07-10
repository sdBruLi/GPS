/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SpeedBlock360h
/*    */ {
/*    */   private String time;
/*    */   private List<Short> speedBlocks;
/*    */ 
/*    */   public String getTime()
/*    */   {
/* 12 */     return this.time;
/*    */   }
/*    */   public void setTime(String time) {
/* 15 */     this.time = time;
/*    */   }
/*    */   public List<Short> getSpeedBlocks() {
/* 18 */     return this.speedBlocks;
/*    */   }
/*    */   public void setSpeedBlocks(List<Short> speedBlocks) {
/* 21 */     this.speedBlocks = speedBlocks;
/*    */   }
/*    */ 
/*    */   public void parse(byte[] datas) {
/* 25 */     byte[] timebytes = new byte[6];
/* 26 */     System.arraycopy(datas, 0, timebytes, 0, 5);
/* 27 */     this.time = ByteUtil.getHexString(timebytes);
/* 28 */     for (int i = 5; i < datas.length; i++) {
/* 29 */       if (this.speedBlocks == null) {
/* 30 */         this.speedBlocks = new ArrayList();
/*    */       }
/* 32 */       this.speedBlocks.add(Short.valueOf((short)(datas[i] & 0xFF)));
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.SpeedBlock360h
 * JD-Core Version:    0.6.1
 */