/*    */ package com.china317.core.codec.jtt808_2011.x8900;
/*    */ 
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class F1bind2Waybill extends F1MsgDataPack
/*    */ {
/*    */   private String[] labelList;
/*    */ 
/*    */   public F1bind2Waybill(String[] labelList)
/*    */   {
/* 23 */     super(32770, 0, null);
/* 24 */     this.labelList = labelList;
/*    */   }
/*    */ 
/*    */   public F1bind2Waybill(boolean unband)
/*    */   {
/* 35 */     super(32772, 0, null);
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   public void praser() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void bulid() throws Exception
/*    */   {
/* 45 */     if (this.msgid == 32772) {
/* 46 */       super.bulid(null);
/* 47 */       return;
/*    */     }
/* 49 */     IoBuffer bodybuffer = IoBuffer.allocate(this.labelList.length * 4);
/*    */ 
/* 51 */     for (String rfid : this.labelList) {
/* 52 */       byte[] temp = ByteUtil.number2Bytes(Long.parseLong(rfid), 4);
/* 53 */       bodybuffer.put(temp);
/*    */     }
/* 55 */     bodybuffer.flip();
/* 56 */     super.bulid(bodybuffer);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1bind2Waybill
 * JD-Core Version:    0.6.1
 */