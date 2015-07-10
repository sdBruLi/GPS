/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8203 extends JT808MsgBody
/*    */ {
/* 15 */   private int sequenceNum = 0;
/* 16 */   private long alarmtype = 0L;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 32 */     if (!isBuildBody()) {
/* 33 */       this.bodyBuffer = IoBuffer.allocate(6);
/* 34 */       this.bodyBuffer.putUnsignedShort(this.sequenceNum);
/* 35 */       this.bodyBuffer.putUnsignedInt(this.alarmtype);
/* 36 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createConfirmAlarmPack(String mobileNum, int sequenceNum, TermianlAlarmType alarmtype) throws Exception
/*    */   {
/* 46 */     UnitPackJT808 pack = new UnitPackJT808(33027);
/* 47 */     pack.setMobileNum(mobileNum);
/* 48 */     JT808MsgBody_0x8203 body = new JT808MsgBody_0x8203();
/* 49 */     body.setSequenceNum(sequenceNum);
/* 50 */     body.setAlarmtype(alarmtype.getValue());
/* 51 */     pack.setMsgBody(body);
/* 52 */     return pack;
/*    */   }
/*    */ 
/*    */   public int getSequenceNum() {
/* 56 */     return this.sequenceNum;
/*    */   }
/*    */ 
/*    */   public void setSequenceNum(int sequenceNum) {
/* 60 */     this.sequenceNum = sequenceNum;
/*    */   }
/*    */ 
/*    */   public long getAlarmtype() {
/* 64 */     return this.alarmtype;
/*    */   }
/*    */ 
/*    */   public void setAlarmtype(long alarmtype) {
/* 68 */     this.alarmtype = alarmtype;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8203
 * JD-Core Version:    0.6.1
 */