/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8303_item extends JT808MsgBody
/*    */ {
/*    */   private byte infoType;
/*    */   private short infoNameLen;
/*    */   private String infoName;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 16 */     if (!isBuildBody()) {
/* 17 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 18 */       this.bodyBuffer.put(this.infoType);
/* 19 */       this.bodyBuffer.putShort(this.infoNameLen);
/* 20 */       if ((this.infoName != null) && (this.infoName.length() > 0)) {
/* 21 */         this.bodyBuffer.put(this.infoName.getBytes("GBK"));
/*    */       }
/* 23 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 29 */     this.infoType = this.bodyBuffer.get();
/* 30 */     this.infoNameLen = this.bodyBuffer.getShort();
/* 31 */     this.infoName = this.bodyBuffer.getString(DefaultCharset.decoder);
/* 32 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public byte getInfoType() {
/* 36 */     return this.infoType;
/*    */   }
/*    */ 
/*    */   public void setInfoType(byte infoType) {
/* 40 */     this.infoType = infoType;
/*    */   }
/*    */ 
/*    */   public short getInfoNameLen() {
/* 44 */     return this.infoNameLen;
/*    */   }
/*    */ 
/*    */   public void setInfoNameLen(short infoNameLen) {
/* 48 */     this.infoNameLen = infoNameLen;
/*    */   }
/*    */ 
/*    */   public String getInfoName() {
/* 52 */     return this.infoName;
/*    */   }
/*    */ 
/*    */   public void setInfoName(String infoName) {
/* 56 */     this.infoName = infoName;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8303_item
 * JD-Core Version:    0.6.1
 */