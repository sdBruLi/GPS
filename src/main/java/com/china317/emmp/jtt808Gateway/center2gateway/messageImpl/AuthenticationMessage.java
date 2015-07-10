/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0102;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class AuthenticationMessage extends BaseUpMessage
/*    */ {
/* 16 */   private static final Log log = LogFactory.getLog(AuthenticationMessage.class);
/*    */   private String authCode;
/*    */ 
/*    */   public AuthenticationMessage()
/*    */   {
/* 18 */     setCommand("0x0102");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack) {
/* 22 */     unpackHeadPart(pack);
/*    */     try {
/* 24 */       JT808MsgBody_0x0102 packBody = (JT808MsgBody_0x0102)pack.getMsgBody();
/*    */ 
/* 26 */       setAuthCode(packBody.getAuthCode());
/*    */     } catch (Exception e) {
/* 28 */       log.debug("unpack fail ", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getAuthCode()
/*    */   {
/* 35 */     return this.authCode;
/*    */   }
/*    */ 
/*    */   public void setAuthCode(String authCode) {
/* 39 */     this.authCode = authCode;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.AuthenticationMessage
 * JD-Core Version:    0.6.1
 */