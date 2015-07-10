/*    */ package com.china317.core.base;
/*    */ 
/*    */ public abstract class AbstractDataPacket
/*    */   implements DataPacket
/*    */ {
/*    */   private byte[] bytes;
/*    */   private DataPacketContext context;
/*    */   private boolean valid;
/*    */   private String invalidMessage;
/*    */ 
/*    */   public byte[] getBytes()
/*    */   {
/* 26 */     return this.bytes;
/*    */   }
/*    */ 
/*    */   public void setBytes(byte[] bytes)
/*    */   {
/* 34 */     this.bytes = bytes;
/*    */   }
/*    */ 
/*    */   public DataPacketContext getContext()
/*    */   {
/* 41 */     return this.context;
/*    */   }
/*    */ 
/*    */   public void setContext(DataPacketContext context)
/*    */   {
/* 49 */     this.context = context;
/*    */   }
/*    */ 
/*    */   public boolean isValid()
/*    */   {
/* 57 */     return this.valid;
/*    */   }
/*    */ 
/*    */   public void setValid(boolean valid)
/*    */   {
/* 65 */     this.valid = valid;
/*    */   }
/*    */ 
/*    */   public String getInvalidMessage()
/*    */   {
/* 73 */     return this.invalidMessage;
/*    */   }
/*    */ 
/*    */   public void setInvalidMessage(String invalidMessage)
/*    */   {
/* 80 */     this.invalidMessage = invalidMessage;
/*    */   }
/*    */ 
/*    */   public abstract String getCommand();
/*    */ 
/*    */   public abstract long getSessionId();
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.base.AbstractDataPacket
 * JD-Core Version:    0.6.1
 */