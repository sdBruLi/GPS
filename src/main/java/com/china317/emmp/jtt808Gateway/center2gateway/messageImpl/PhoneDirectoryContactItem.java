/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ 
/*    */ public class PhoneDirectoryContactItem
/*    */ {
/*    */   public static final byte PHONE_IN = 1;
/*    */   public static final byte PHONE_OUT = 2;
/*    */   public static final byte PHONE_IN_AND_OUT = 3;
/*    */   private byte sign;
/*    */   private byte numberLen;
/*    */   private String phoneNum;
/*    */   private byte contactLen;
/*    */   private String contact;
/*    */ 
/*    */   public PhoneDirectoryContactItem(byte sign, String phoneNum, String contact)
/*    */   {
/* 17 */     setSign(sign);
/* 18 */     if (phoneNum != null) {
/*    */       try {
/* 20 */         setNumberLen((byte)phoneNum.getBytes("GBK").length);
/*    */       } catch (UnsupportedEncodingException e) {
/* 22 */         e.printStackTrace();
/*    */       }
/* 24 */       setPhoneNum(phoneNum);
/*    */     }
/* 26 */     if (contact != null) {
/*    */       try {
/* 28 */         setContactLen((byte)contact.getBytes("GBK").length);
/*    */       } catch (UnsupportedEncodingException e) {
/* 30 */         e.printStackTrace();
/*    */       }
/* 32 */       setContact(contact);
/*    */     }
/*    */   }
/*    */ 
/*    */   public byte getSign() {
/* 37 */     return this.sign;
/*    */   }
/*    */ 
/*    */   public void setSign(byte sign) {
/* 41 */     this.sign = sign;
/*    */   }
/*    */ 
/*    */   public byte getNumberLen() {
/* 45 */     return this.numberLen;
/*    */   }
/*    */ 
/*    */   public void setNumberLen(byte numberLen) {
/* 49 */     this.numberLen = numberLen;
/*    */   }
/*    */ 
/*    */   public String getPhoneNum() {
/* 53 */     return this.phoneNum;
/*    */   }
/*    */ 
/*    */   public void setPhoneNum(String phoneNum) {
/* 57 */     this.phoneNum = phoneNum;
/*    */   }
/*    */ 
/*    */   public byte getContactLen() {
/* 61 */     return this.contactLen;
/*    */   }
/*    */ 
/*    */   public void setContactLen(byte contactLen) {
/* 65 */     this.contactLen = contactLen;
/*    */   }
/*    */ 
/*    */   public String getContact() {
/* 69 */     return this.contact;
/*    */   }
/*    */ 
/*    */   public void setContact(String contact) {
/* 73 */     this.contact = contact;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.PhoneDirectoryContactItem
 * JD-Core Version:    0.6.1
 */