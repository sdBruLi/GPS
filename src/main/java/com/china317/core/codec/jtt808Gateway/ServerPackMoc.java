/*    */ package com.china317.core.codec.jtt808Gateway;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ 
/*    */ public class ServerPackMoc
/*    */ {
/*    */   private UnitPackJT808 pack;
/*    */   private Long vehSessionid;
/*    */ 
/*    */   public ServerPackMoc(long vehSessionid_, UnitPackJT808 pack_)
/*    */   {
/* 10 */     this.vehSessionid = new Long(vehSessionid_);
/* 11 */     this.pack = pack_;
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 getPack() {
/* 15 */     return this.pack;
/*    */   }
/*    */ 
/*    */   public void setPack(UnitPackJT808 pack) {
/* 19 */     this.pack = pack;
/*    */   }
/*    */ 
/*    */   public Long getVehSessionid() {
/* 23 */     return this.vehSessionid;
/*    */   }
/*    */ 
/*    */   public void setVehSessionid(Long vehSessionid) {
/* 27 */     this.vehSessionid = vehSessionid;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.ServerPackMoc
 * JD-Core Version:    0.6.1
 */