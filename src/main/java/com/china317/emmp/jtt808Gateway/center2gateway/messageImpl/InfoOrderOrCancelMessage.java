/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0303;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class InfoOrderOrCancelMessage extends BaseUpMessage
/*    */ {
/* 16 */   private static final Log log = LogFactory.getLog(InfoOrderOrCancelMessage.class);
/*    */   private byte infoType;
/*    */   private byte sign;
/*    */ 
/*    */   public InfoOrderOrCancelMessage()
/*    */   {
/* 21 */     setCommand("0x0303");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 26 */     unpackHeadPart(pack);
/*    */     try {
/* 28 */       JT808MsgBody_0x0303 body = (JT808MsgBody_0x0303)pack.getMsgBody();
/* 29 */       setInfoType(body.getInfoType());
/* 30 */       setSign(body.getSign());
/*    */     } catch (Exception e) {
/* 32 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public byte getInfoType() {
/* 37 */     return this.infoType;
/*    */   }
/*    */ 
/*    */   public void setInfoType(byte infoType)
/*    */   {
/* 42 */     this.infoType = infoType;
/*    */   }
/*    */ 
/*    */   public byte getSign() {
/* 46 */     return this.sign;
/*    */   }
/*    */ 
/*    */   public void setSign(byte sign)
/*    */   {
/* 51 */     this.sign = sign;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.InfoOrderOrCancelMessage
 * JD-Core Version:    0.6.1
 */