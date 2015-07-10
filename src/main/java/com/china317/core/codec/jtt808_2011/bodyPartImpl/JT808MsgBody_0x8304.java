/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8304 extends JT808MsgBody
/*    */ {
/*    */   private byte infoType;
/*    */   private short infoLen;
/*    */   private String infoContent;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!isBuildBody()) {
/* 19 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 20 */       this.bodyBuffer.put(this.infoType);
/* 21 */       this.bodyBuffer.putShort(this.infoLen);
/* 22 */       if ((this.infoContent != null) && (this.infoContent.length() > 0)) {
/* 23 */         this.bodyBuffer.put(this.infoContent.getBytes("GBK"));
/*    */       }
/* 25 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 31 */     this.infoType = this.bodyBuffer.get();
/* 32 */     this.infoLen = this.bodyBuffer.getShort();
/* 33 */     this.infoContent = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 34 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createInfoServicePack(String mobileNum, byte infoType, short infoLen, String infoContent)
/*    */     throws Exception
/*    */   {
/* 47 */     UnitPackJT808 pack = new UnitPackJT808(33540);
/* 48 */     pack.setMobileNum(mobileNum);
/* 49 */     JT808MsgBody_0x8304 body = new JT808MsgBody_0x8304();
/* 50 */     body.setInfoType(infoType);
/* 51 */     body.setInfoLen(infoLen);
/* 52 */     body.setInfoContent(infoContent);
/* 53 */     pack.setMsgBody(body);
/* 54 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getInfoType() {
/* 58 */     return this.infoType;
/*    */   }
/*    */ 
/*    */   public void setInfoType(byte infoType) {
/* 62 */     this.infoType = infoType;
/*    */   }
/*    */ 
/*    */   public short getInfoLen() {
/* 66 */     return this.infoLen;
/*    */   }
/*    */ 
/*    */   public void setInfoLen(short infoLen) {
/* 70 */     this.infoLen = infoLen;
/*    */   }
/*    */ 
/*    */   public String getInfoContent() {
/* 74 */     return this.infoContent;
/*    */   }
/*    */ 
/*    */   public void setInfoContent(String infoContent) {
/* 78 */     this.infoContent = infoContent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8304
 * JD-Core Version:    0.6.1
 */