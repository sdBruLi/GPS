/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8304;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ 
/*    */ public class InfoServiceMessage extends BaseDownMessage
/*    */ {
/*    */   private byte infoType;
/*    */   private short infoLen;
/*    */   private String infoContent;
/*    */ 
/*    */   public InfoServiceMessage(String mobileNum, String messageKey, byte infoType, String infoContent)
/*    */   {
/* 31 */     setMobileNum(mobileNum);
/* 32 */     setMessageKey(messageKey);
/* 33 */     setInfoType(infoType);
/* 34 */     if (infoContent != null) {
/*    */       try {
/* 36 */         setInfoLen((short)infoContent.getBytes("GBK").length);
/*    */       } catch (UnsupportedEncodingException e) {
/* 38 */         e.printStackTrace();
/*    */       }
/* 40 */       setInfoContent(infoContent);
/*    */     }
/* 42 */     setCommand("0x8304");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 47 */     UnitPackJT808 pack = new UnitPackJT808(33540);
/* 48 */     pack.setMobileNum(getMobileNum());
/* 49 */     JT808MsgBody_0x8304 body = new JT808MsgBody_0x8304();
/* 50 */     body.setInfoType(getInfoType());
/* 51 */     body.setInfoLen(getInfoLen());
/* 52 */     body.setInfoContent(getInfoContent());
/* 53 */     pack.setMsgBody(body);
/* 54 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getInfoType()
/*    */   {
/* 59 */     return this.infoType;
/*    */   }
/*    */ 
/*    */   public void setInfoType(byte infoType)
/*    */   {
/* 64 */     this.infoType = infoType;
/*    */   }
/*    */ 
/*    */   public short getInfoLen() {
/* 68 */     return this.infoLen;
/*    */   }
/*    */ 
/*    */   public void setInfoLen(short infoLen)
/*    */   {
/* 73 */     this.infoLen = infoLen;
/*    */   }
/*    */ 
/*    */   public String getInfoContent() {
/* 77 */     return this.infoContent;
/*    */   }
/*    */ 
/*    */   public void setInfoContent(String infoContent)
/*    */   {
/* 82 */     this.infoContent = infoContent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.InfoServiceMessage
 * JD-Core Version:    0.6.1
 */