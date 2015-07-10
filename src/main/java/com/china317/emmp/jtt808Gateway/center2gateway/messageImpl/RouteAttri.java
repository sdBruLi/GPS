/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ public class RouteAttri
/*    */ {
/*    */   public static final byte TIME_ON = 1;
/*    */   public static final byte TIME_OFF = 0;
/*    */   public static final byte IN_ROUTE2DRIVER_ON = 1;
/*    */   public static final byte IN_ROUTE2DRIVER_OFF = 0;
/*    */   public static final byte IN_ROUTE2PLATFORM_ON = 1;
/*    */   public static final byte IN_ROUTE2PLATFORM_OFF = 0;
/*    */   public static final byte OUT_REGION2DRIVER_ON = 1;
/*    */   public static final byte OUT_REGION2DRIVER_OFF = 0;
/*    */   public static final byte OUT_REGION2PLATFORM_ON = 1;
/*    */   public static final byte OUT_REGION2PLATFORM_OFF = 0;
/*    */   private short attribute;
/*    */   private byte time;
/*    */   private byte inRoute2Driver;
/*    */   private byte inRoute2Platform;
/*    */   private byte outRoute2Driver;
/*    */   private byte outRoute2Platform;
/*    */ 
/*    */   public RouteAttri(byte time, byte inRoute2Driver, byte inRoute2Platform, byte outRoute2Driver, byte outRoute2Platform)
/*    */   {
/* 28 */     this.time = time;
/* 29 */     this.inRoute2Driver = inRoute2Driver;
/* 30 */     this.inRoute2Driver = inRoute2Platform;
/* 31 */     this.outRoute2Driver = outRoute2Driver;
/* 32 */     this.outRoute2Platform = outRoute2Platform;
/*    */   }
/*    */ 
/*    */   public short getAttribute() {
/* 36 */     this.attribute = 
/* 37 */       (short)(this.time | this.inRoute2Driver << 2 | this.inRoute2Platform << 3 | 
/* 37 */       this.outRoute2Driver << 4 | this.outRoute2Platform << 5);
/* 38 */     return this.attribute;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.RouteAttri
 * JD-Core Version:    0.6.1
 */