/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ public class SpeedSwitchingNode
/*    */ {
/*    */   private byte speed;
/*    */   private byte switching;
/*    */ 
/*    */   public byte getSpeed()
/*    */   {
/*  8 */     return this.speed;
/*    */   }
/*    */   public void setSpeed(byte speed) {
/* 11 */     this.speed = speed;
/*    */   }
/*    */   public byte getSwitching() {
/* 14 */     return this.switching;
/*    */   }
/*    */   public void setSwitching(byte switching) {
/* 17 */     this.switching = switching;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 21 */     return this.speed + ":" + this.switching;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.SpeedSwitchingNode
 * JD-Core Version:    0.6.1
 */