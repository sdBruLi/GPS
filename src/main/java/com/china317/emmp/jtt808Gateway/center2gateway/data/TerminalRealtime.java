/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class TerminalRealtime
/*    */ {
/*    */   private String realtime;
/*    */ 
/*    */   public String getRealtime()
/*    */   {
/* 11 */     return this.realtime;
/*    */   }
/*    */   public void setRealtime(String realtime) {
/* 14 */     this.realtime = realtime;
/*    */   }
/*    */ 
/*    */   public void parse(byte[] datas) {
/* 18 */     this.realtime = ByteUtil.getHexString(datas);
/*    */   }
/*    */ 
/*    */   public IoBuffer getBuffer() {
/* 22 */     IoBuffer buf = IoBuffer.allocate(3).setAutoExpand(true);
/* 23 */     buf.put(ByteUtil.string2BCD(this.realtime, 6));
/* 24 */     buf.flip();
/* 25 */     return buf;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 29 */     return "Terminal Realtime : " + this.realtime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.TerminalRealtime
 * JD-Core Version:    0.6.1
 */