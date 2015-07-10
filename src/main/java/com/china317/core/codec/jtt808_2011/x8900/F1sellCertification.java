/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.util.BytesUtil;
/*    */ import java.util.HashMap;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1sellCertification extends F1MsgDataPack
/*    */ {
/*    */   public F1sellCertification()
/*    */   {
/* 18 */     super(25, 0, null);
/*    */   }
/*    */ 
/*    */   public F1sellCertification(int len, IoBuffer data) {
/* 22 */     super(25, len, data);
/*    */   }
/*    */ 
/*    */   public void praser() throws Exception
/*    */   {
/* 27 */     int cnt = this.len / 4;
/* 28 */     this.labelStatus = new HashMap(cnt);
/* 29 */     byte[] temp = new byte[4];
/* 30 */     for (int i = 0; i < cnt; i++) {
/* 31 */       this.data.get(temp);
/* 32 */       this.labelStatus.put(Long.valueOf(BytesUtil.byte4ToLong(temp, false)), Byte.valueOf((byte)1));
/*    */     }
/*    */ 
/* 35 */     temp = new byte[28];
/* 36 */     this.data.get(temp);
/* 37 */     this.gpsData = new JT808MsgBody_0x0200();
/* 38 */     this.gpsData.setBodyBuffer(IoBuffer.wrap(temp));
/* 39 */     this.gpsData.praseBody();
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1sellCertification
 * JD-Core Version:    0.6.1
 */