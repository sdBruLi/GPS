/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.util.BytesUtil;

/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;

/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1scanUpload4Dynamic extends F1MsgDataPack
/*    */ {
/*    */   public F1scanUpload4Dynamic(int len, IoBuffer data)
/*    */   {
/* 20 */     super(1, len, data);
/*    */   }
/*    */ 
/*    */   public F1scanUpload4Dynamic(int msgid, int len, IoBuffer data) {
/* 24 */     super(msgid, len, data);
/*    */   }
/*    */ 
/*    */   public void praser() throws Exception
/*    */   {
/* 29 */     byte[] temp = new byte[10];
/* 30 */     int cnt = this.len / 5;
/* 31 */     this.labelStatus = new HashMap(cnt);
/*    */ 
/* 33 */     for (int i = 0; i < cnt; i++) {
/* 34 */       temp = new byte[4];
/* 35 */       this.data.get(temp);
/* 36 */       this.labelStatus.put(Long.valueOf(BytesUtil.byte4ToLong(temp, false)), Byte.valueOf(this.data.get()));
/*    */     }
/* 38 */     if (this.data.remaining() == 28) {
/* 39 */       byte[] pack200 = new byte[28];
/* 40 */       this.data.get(pack200);
/* 41 */       this.gpsData = new JT808MsgBody_0x0200();
/* 42 */       this.gpsData.setBodyBuffer(IoBuffer.wrap(pack200));
/* 43 */       this.gpsData.praseBody();
/*    */     }
/* 45 */     this.data.position(0);
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 49 */     StringBuffer sb = new StringBuffer();
/* 50 */     Iterator iterator = this.labelStatus.entrySet().iterator();
/*    */ 
/* 52 */     while (iterator.hasNext()) {
/* 53 */       Map.Entry entry = (Map.Entry)iterator.next();
/* 54 */       sb.append(entry.getKey()).append(":").append(entry.getValue()).append("|");
/*    */     }
/* 56 */     if (sb.length() > 0) {
/* 57 */       sb.deleteCharAt(sb.length() - 1);
/*    */     }
/* 59 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   public String toFileString() {
/* 63 */     StringBuffer sb = new StringBuffer();
/* 64 */     Iterator iterator = this.labelStatus.entrySet().iterator();
/*    */ 
/* 66 */     while (iterator.hasNext()) {
/* 67 */       Map.Entry entry = (Map.Entry)iterator.next();
/* 68 */       sb.append(entry.getKey()).append("=").append(entry.getValue()).append("\t\t");
/*    */     }
/* 70 */     sb.deleteCharAt(sb.length() - 1);
/* 71 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void bulid()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1scanUpload4Dynamic
 * JD-Core Version:    0.6.1
 */