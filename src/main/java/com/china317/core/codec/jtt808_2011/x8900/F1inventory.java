/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import com.china317.core.util.BytesUtil;
/*    */ import java.util.HashMap;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1inventory extends F1MsgDataPack
/*    */ {
/*    */   private String checkprocessId;
/*    */ 
/*    */   public F1inventory(int len, IoBuffer data)
/*    */   {
/* 21 */     super(18, len, data);
/*    */   }
/*    */ 
/*    */   public F1inventory(int msgid, int len, IoBuffer data) {
/* 25 */     super(msgid, len, data);
/*    */   }
/*    */ 
/*    */   public void praser() throws Exception
/*    */   {
/* 30 */     byte[] temp = new byte[10];
/* 31 */     this.data.get(temp);
/* 32 */     this.checkprocessId = String.valueOf(ByteUtil.BCD2Long(temp));
/* 33 */     int cnt = (this.len - 10) / 5;
/* 34 */     this.labelStatus = new HashMap(cnt);
/* 35 */     for (int i = 0; i < cnt; i++) {
/* 36 */       temp = new byte[4];
/* 37 */       this.data.get(temp);
/* 38 */       this.labelStatus.put(Long.valueOf(BytesUtil.byte4ToLong(temp, false)), Byte.valueOf(this.data.get()));
/*    */     }
/* 40 */     if (this.data.remaining() == 28) {
/* 41 */       temp = new byte[28];
/* 42 */       this.data.get(temp);
/* 43 */       this.gpsData = new JT808MsgBody_0x0200();
/* 44 */       this.gpsData.setBodyBuffer(IoBuffer.wrap(temp));
/* 45 */       this.gpsData.praseBody();
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getCheckprocessId() {
/* 50 */     return this.checkprocessId;
/*    */   }
/*    */ 
/*    */   public void setCheckprocessId(String checkprocessId) {
/* 54 */     this.checkprocessId = checkprocessId;
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1inventory
 * JD-Core Version:    0.6.1
 */