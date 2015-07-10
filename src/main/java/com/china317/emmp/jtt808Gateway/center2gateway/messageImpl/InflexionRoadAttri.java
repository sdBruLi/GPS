/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ public class InflexionRoadAttri
/*    */ {
/*    */   public static final byte TIME_ON = 1;
/*    */   public static final byte TIME_OFF = 0;
/*    */   public static final byte SPEED_RESTRICTED_ON = 1;
/*    */   public static final byte SPEED_RESTRICTED_OFF = 0;
/*    */   public static final byte LATITUDE_NORTHERN = 0;
/*    */   public static final byte LATITUDE_SOUTHERN = 1;
/*    */   public static final byte LONGITUDE_EAST = 0;
/*    */   public static final byte LONGITUDE_WEST = 1;
/*    */   private byte attribute;
/*    */   private byte time;
/*    */   private byte speedRestricted;
/*    */   private byte latitude;
/*    */   private byte longitude;
/*    */ 
/*    */   public InflexionRoadAttri(byte time, byte speedRestricted, byte latitude, byte longitude)
/*    */   {
/* 23 */     this.time = time;
/* 24 */     this.speedRestricted = speedRestricted;
/* 25 */     this.latitude = latitude;
/* 26 */     this.longitude = longitude;
/*    */   }
/*    */ 
/*    */   public byte getAttribute() {
/* 30 */     this.attribute = (byte)(this.time | this.speedRestricted << 1 | this.latitude << 2 | this.longitude << 3);
/* 31 */     return this.attribute;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.InflexionRoadAttri
 * JD-Core Version:    0.6.1
 */