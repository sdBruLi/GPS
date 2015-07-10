/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1checkStart extends F1inventoryStart
/*    */ {
/*    */   public F1checkStart(String checkProcessorId)
/*    */   {
/* 20 */     super(32801, 0, null);
/* 21 */     this.checkProcessorId = checkProcessorId;
/*    */   }
/*    */ 
/*    */   public F1checkStart(IoBuffer data) {
/* 25 */     super(32801, 0, data);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1checkStart
 * JD-Core Version:    0.6.1
 */