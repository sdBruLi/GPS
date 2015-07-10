/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8606_route_attri extends JT808MsgBody
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
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!isBuildBody()) {
/* 25 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 26 */       this.bodyBuffer.putShort(this.attribute);
/* 27 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public short getAttribute(byte time, byte inRoute2Driver, byte inRoute2Platform, byte outRoute2Driver, byte outRoute2Platform)
/*    */   {
/* 37 */     short attri = 0;
/* 38 */     attri = (short)(time | inRoute2Driver << 2 | inRoute2Platform << 3 | 
/* 39 */       outRoute2Driver << 4 | outRoute2Platform << 5);
/* 40 */     return attri;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8606_route_attri
 * JD-Core Version:    0.6.1
 */