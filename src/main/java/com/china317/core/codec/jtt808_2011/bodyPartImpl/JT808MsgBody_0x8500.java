/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8500 extends JT808MsgBody
/*    */ {
/*    */   public static final byte DOOR_UNLOCK = 0;
/*    */   public static final byte DOOR_LOCK = 1;
/*    */   private byte controlSign;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!isBuildBody()) {
/* 18 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 19 */       this.bodyBuffer.put(this.controlSign);
/* 20 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 26 */     this.controlSign = this.bodyBuffer.get();
/* 27 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createVehControl(String mobileNum, byte door)
/*    */     throws Exception
/*    */   {
/* 38 */     UnitPackJT808 pack = new UnitPackJT808(34048);
/* 39 */     pack.setMobileNum(mobileNum);
/* 40 */     JT808MsgBody_0x8500 body = new JT808MsgBody_0x8500();
/* 41 */     body.setControlSign(getSign(door));
/* 42 */     pack.setMsgBody(body);
/* 43 */     return pack;
/*    */   }
/*    */ 
/*    */   private static byte getSign(byte door)
/*    */   {
/* 49 */     return door;
/*    */   }
/*    */ 
/*    */   public byte getControlSign() {
/* 53 */     return this.controlSign;
/*    */   }
/*    */ 
/*    */   public void setControlSign(byte controlSign) {
/* 57 */     this.controlSign = controlSign;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8500
 * JD-Core Version:    0.6.1
 */