/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ public class RegionItemAttri
/*    */ {
/*    */   public static final byte TIME_ON = 1;
/*    */   public static final byte TIME_OFF = 0;
/*    */   public static final byte SPEED_RESTRICTED_ON = 1;
/*    */   public static final byte SPEED_RESTRICTED_OFF = 0;
/*    */   public static final byte IN_REGION2DRIVER_ON = 1;
/*    */   public static final byte IN_REGION2DRIVER_OFF = 0;
/*    */   public static final byte IN_REGION2PLATFORM_ON = 1;
/*    */   public static final byte IN_REGION2PLATFORM_OFF = 0;
/*    */   public static final byte OUT_REGION2DRIVER_ON = 1;
/*    */   public static final byte OUT_REGION2DRIVER_OFF = 0;
/*    */   public static final byte OUT_REGION2PLATFORM_ON = 1;
/*    */   public static final byte OUT_REGION2PLATFORM_OFF = 0;
/*    */   public static final byte LATITUDE_NORTHERN = 0;
/*    */   public static final byte LATITUDE_SOUTHERN = 1;
/*    */   public static final byte LONGITUDE_EAST = 0;
/*    */   public static final byte LONGITUDE_WEST = 1;
/*    */   private short attribute;
/*    */   private byte time;
/*    */   private byte speedRestricted;
/*    */   private byte inRegion2Driver;
/*    */   private byte inRegion2Platform;
/*    */   private byte outRegion2Driver;
/*    */   private byte outRegion2Platform;
/*    */   private byte latitude;
/*    */   private byte longitude;
/*    */ 
/*    */   public RegionItemAttri(byte time, byte speedRestricted, byte inRegion2Driver, byte inRegion2Platform, byte outRegion2Driver, byte outRegion2Platform, byte latitude, byte longitude)
/*    */   {
/* 36 */     this.time = time;
/* 37 */     this.speedRestricted = speedRestricted;
/* 38 */     this.inRegion2Driver = inRegion2Driver;
/* 39 */     this.inRegion2Platform = inRegion2Platform;
/* 40 */     this.outRegion2Driver = outRegion2Driver;
/* 41 */     this.outRegion2Platform = outRegion2Platform;
/* 42 */     this.latitude = latitude;
/* 43 */     this.longitude = longitude;
/*    */   }
/*    */ 
/*    */   public short getAttribute() {
/* 47 */     this.attribute = 
/* 49 */       (short)(this.time | this.speedRestricted << 1 | this.inRegion2Driver << 2 | 
/* 48 */       this.inRegion2Platform << 3 | this.outRegion2Driver << 4 | 
/* 49 */       this.outRegion2Platform << 5 | this.latitude << 6 | this.longitude << 6);
/* 50 */     return this.attribute;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.RegionItemAttri
 * JD-Core Version:    0.6.1
 */