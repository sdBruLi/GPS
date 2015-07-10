/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ 
/*    */ public class OrderInfoItem
/*    */ {
/*    */   private byte infoType;
/*    */   private short infoNameLen;
/*    */   private String infoName;
/*    */ 
/*    */   public OrderInfoItem(byte infoType, String infoName)
/*    */   {
/* 17 */     this.infoType = infoType;
/* 18 */     if (infoName != null) {
/*    */       try {
/* 20 */         this.infoNameLen = (short)infoName.getBytes("GBK").length;
/*    */       } catch (UnsupportedEncodingException e) {
/* 22 */         e.printStackTrace();
/*    */       }
/* 24 */       this.infoName = infoName;
/*    */     }
/*    */   }
/*    */ 
/*    */   public byte getInfoType() {
/* 29 */     return this.infoType;
/*    */   }
/*    */ 
/*    */   public void setInfoType(byte infoType)
/*    */   {
/* 34 */     this.infoType = infoType;
/*    */   }
/*    */ 
/*    */   public short getInfoNameLen() {
/* 38 */     return this.infoNameLen;
/*    */   }
/*    */ 
/*    */   public void setInfoNameLen(short infoNameLen)
/*    */   {
/* 43 */     this.infoNameLen = infoNameLen;
/*    */   }
/*    */ 
/*    */   public String getInfoName() {
/* 47 */     return this.infoName;
/*    */   }
/*    */ 
/*    */   public void setInfoName(String infoName)
/*    */   {
/* 52 */     this.infoName = infoName;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.OrderInfoItem
 * JD-Core Version:    0.6.1
 */