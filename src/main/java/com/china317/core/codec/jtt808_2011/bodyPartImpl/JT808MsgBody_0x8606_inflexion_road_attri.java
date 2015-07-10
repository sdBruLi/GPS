/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8606_inflexion_road_attri extends JT808MsgBody
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
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!isBuildBody()) {
/* 23 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 24 */       this.bodyBuffer.putShort(this.attribute);
/* 25 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public static byte getAttribute(byte time, byte speedRestricted, byte latitude, byte longitude) {
/* 34 */     byte attri = 0;
/* 35 */     attri = (byte)(time | speedRestricted << 1 | latitude << 2 | longitude << 3);
/* 36 */     return attri;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8606_inflexion_road_attri
 * JD-Core Version:    0.6.1
 */