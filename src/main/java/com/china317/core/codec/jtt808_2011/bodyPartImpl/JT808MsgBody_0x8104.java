/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ 
/*    */ public class JT808MsgBody_0x8104 extends JT808MsgBody
/*    */ {
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 queryTeminalParam(String mobileNum)
/*    */     throws Exception
/*    */   {
/* 19 */     UnitPackJT808 pack = new UnitPackJT808(33028);
/* 20 */     pack.setMobileNum(mobileNum);
/* 21 */     return pack;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8104
 * JD-Core Version:    0.6.1
 */