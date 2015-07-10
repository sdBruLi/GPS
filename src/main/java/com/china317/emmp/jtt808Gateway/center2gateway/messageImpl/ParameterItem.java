/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ public class ParameterItem
/*    */ {
/*    */   private int paramId;
/*    */   private byte paramLen;
/*    */   private Object value;
/*    */ 
/*    */   public ParameterItem()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ParameterItem(int paramId, byte paramLen, Object value)
/*    */   {
/* 13 */     this.paramId = paramId;
/* 14 */     this.paramLen = paramLen;
/* 15 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public int getParamId() {
/* 19 */     return this.paramId;
/*    */   }
/*    */ 
/*    */   public void setParamId(int paramId) {
/* 23 */     this.paramId = paramId;
/*    */   }
/*    */ 
/*    */   public byte getParamLen()
/*    */   {
/* 28 */     return this.paramLen;
/*    */   }
/*    */ 
/*    */   public void setParamLen(byte paramLen) {
/* 32 */     this.paramLen = paramLen;
/*    */   }
/*    */ 
/*    */   public Object getValue() {
/* 36 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(Object value) {
/* 40 */     this.value = value;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ParameterItem
 * JD-Core Version:    0.6.1
 */