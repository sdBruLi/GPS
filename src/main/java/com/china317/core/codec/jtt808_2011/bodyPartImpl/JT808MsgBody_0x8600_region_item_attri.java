/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8600_region_item_attri extends JT808MsgBody
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
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!isBuildBody()) {
/* 31 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 32 */       this.bodyBuffer.putShort(this.attribute);
/* 33 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public static short getAttribute(byte time, byte speedRestricted, byte inRegion2Driver, byte inRegion2Platform, byte outRegion2Driver, byte outRegion2Platform, byte latitude, byte longitude)
/*    */   {
/* 44 */     short attri = 0;
/* 45 */     attri = (short)(time | speedRestricted << 1 | inRegion2Driver << 2 | 
/* 46 */       inRegion2Platform << 3 | outRegion2Driver << 4 | 
/* 47 */       outRegion2Platform << 5 | latitude << 6 | longitude << 6);
/* 48 */     return attri;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8600_region_item_attri
 * JD-Core Version:    0.6.1
 */