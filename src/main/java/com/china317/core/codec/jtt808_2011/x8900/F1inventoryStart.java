/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1inventoryStart extends F1MsgDataPack
/*    */ {
/*    */   protected String checkProcessorId;
/*    */ 
/*    */   public F1inventoryStart(String checkProcessorId)
/*    */   {
/* 21 */     super(32785, 0, null);
/* 22 */     this.checkProcessorId = checkProcessorId;
/*    */   }
/*    */ 
/*    */   public F1inventoryStart(int msgid, int len, IoBuffer data) {
/* 26 */     super(msgid, len, data);
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void praser() throws Exception
/*    */   {
/* 32 */     byte[] emp = new byte[10];
/* 33 */     this.data.get(emp);
/* 34 */     this.checkProcessorId = String.valueOf(ByteUtil.BCD2Long(emp));
/*    */   }
/*    */ 
/*    */   public void bulid() throws Exception
/*    */   {
/* 39 */     IoBuffer bodybuffer = IoBuffer.allocate(10);
/* 40 */     bodybuffer.put(ByteUtil.string2BCD(this.checkProcessorId, 10));
/* 41 */     bodybuffer.flip();
/* 42 */     super.bulid(bodybuffer);
/*    */   }
/*    */ 
/*    */   public String getCheckProcessorId() {
/* 46 */     return this.checkProcessorId;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1inventoryStart
 * JD-Core Version:    0.6.1
 */