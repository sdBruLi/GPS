/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.codecExt;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class ObjectDataPacket
/*    */ {
/*    */   private long createTime;
/*    */   private int id;
/*    */   private byte[] bytes;
/*    */ 
/*    */   public ObjectDataPacket()
/*    */   {
/* 10 */     this.createTime = System.currentTimeMillis();
/*    */   }
/*    */   public int getId() {
/* 13 */     return this.id;
/*    */   }
/*    */   public void setId(int id) {
/* 16 */     this.id = id;
/*    */   }
/*    */   public byte[] getBuffer() {
/* 19 */     return this.bytes;
/*    */   }
/*    */   public void setBuffer(IoBuffer buf) {
/* 22 */     this.bytes = new byte[buf.limit()];
/* 23 */     buf.get(this.bytes);
/*    */   }
/*    */   public long getCreateTime() {
/* 26 */     return this.createTime;
/*    */   }
/*    */ 
/*    */   public void setCreateTime(long createTime) {
/* 30 */     this.createTime = createTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.codecExt.ObjectDataPacket
 * JD-Core Version:    0.6.1
 */