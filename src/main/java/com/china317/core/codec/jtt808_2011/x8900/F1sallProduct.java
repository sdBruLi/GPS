/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.util.BytesUtil;
/*    */ import java.util.HashMap;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1sallProduct extends F1MsgDataPack
/*    */ {
/*    */   public F1sallProduct()
/*    */   {
/* 18 */     super(39, 0, null);
/*    */   }
/*    */ 
/*    */   public F1sallProduct(int len, IoBuffer data) {
/* 22 */     super(39, len, data);
/*    */   }
/*    */ 
/*    */   public void praser() throws Exception
/*    */   {
/* 27 */     this.labelStatus = new HashMap(1);
/* 28 */     int cnt = this.len / 5;
/* 29 */     byte[] temp = (byte[])null;
/* 30 */     for (int i = 0; i < cnt; i++) {
/* 31 */       temp = new byte[4];
/* 32 */       this.data.get(temp);
/* 33 */       this.labelStatus.put(Long.valueOf(BytesUtil.byte4ToLong(temp, false)), Byte.valueOf(this.data.get()));
/*    */     }
/*    */ 
/* 36 */     if (this.data.remaining() == 28) {
/* 37 */       temp = new byte[28];
/* 38 */       this.data.get(temp);
/* 39 */       this.gpsData = new JT808MsgBody_0x0200();
/* 40 */       this.gpsData.setBodyBuffer(IoBuffer.wrap(temp));
/* 41 */       this.gpsData.praseBody();
/*    */     }
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1sallProduct
 * JD-Core Version:    0.6.1
 */