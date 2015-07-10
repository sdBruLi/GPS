/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ 
/*    */ public class DeregisterMessage extends BaseUpMessage
/*    */ {
/*    */   public DeregisterMessage()
/*    */   {
/*  8 */     setCommand("0x0003");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 13 */     unpackHeadPart(pack);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.DeregisterMessage
 * JD-Core Version:    0.6.1
 */