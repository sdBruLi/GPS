/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8401_item extends JT808MsgBody
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
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!isBuildBody()) {
/* 22 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 23 */       this.bodyBuffer.put(this.sign);
/* 24 */       this.bodyBuffer.put(this.numberLen);
/* 25 */       if ((this.phoneNum != null) && (this.phoneNum.length() > 0)) {
/* 26 */         this.bodyBuffer.put(this.phoneNum.getBytes("GBK"));
/*    */       }
/* 28 */       this.bodyBuffer.put(this.contactLen);
/* 29 */       if ((this.contact != null) && (this.contact.length() > 0)) {
/* 30 */         this.bodyBuffer.put(this.contact.getBytes("GBK"));
/*    */       }
/* 32 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 38 */     this.sign = this.bodyBuffer.get();
/* 39 */     this.numberLen = this.bodyBuffer.get();
/* 40 */     this.phoneNum = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 41 */     this.contactLen = this.bodyBuffer.get();
/* 42 */     this.contact = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 43 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public byte getSign() {
/* 47 */     return this.sign;
/*    */   }
/*    */ 
/*    */   public void setSign(byte sign) {
/* 51 */     this.sign = sign;
/*    */   }
/*    */ 
/*    */   public byte getNumberLen() {
/* 55 */     return this.numberLen;
/*    */   }
/*    */ 
/*    */   public void setNumberLen(byte numberLen) {
/* 59 */     this.numberLen = numberLen;
/*    */   }
/*    */ 
/*    */   public String getPhoneNum() {
/* 63 */     return this.phoneNum;
/*    */   }
/*    */ 
/*    */   public void setPhoneNum(String phoneNum) {
/* 67 */     this.phoneNum = phoneNum;
/*    */   }
/*    */ 
/*    */   public byte getContactLen() {
/* 71 */     return this.contactLen;
/*    */   }
/*    */ 
/*    */   public void setContactLen(byte contactLen) {
/* 75 */     this.contactLen = contactLen;
/*    */   }
/*    */ 
/*    */   public String getContact() {
/* 79 */     return this.contact;
/*    */   }
/*    */ 
/*    */   public void setContact(String contact) {
/* 83 */     this.contact = contact;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8401_item
 * JD-Core Version:    0.6.1
 */