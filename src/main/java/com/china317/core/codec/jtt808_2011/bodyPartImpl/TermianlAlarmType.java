/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */  enum TermianlAlarmType
/*    */ {
/* 78 */   EMERGENCY(1L), 
/*    */ 
/* 80 */   DANGER(8L), 
/*    */ 
/* 82 */   INOUT_AREA(1048576L), 
/* 83 */   INOUT_LINE(2097152L), 
/* 84 */   SECTION_TIMEWARN(4194304L), 
/*    */ 
/* 86 */   ILLEAGE_ACC(138412032L), 
/* 87 */   ILLEAGE_MOVE(272629760L);
/*    */ 
/*    */   private long value;
/*    */ 
/*    */   private TermianlAlarmType(long value)
/*    */   {
/* 93 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public long getValue() {
/* 97 */     return this.value;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.TermianlAlarmType
 * JD-Core Version:    0.6.1
 */