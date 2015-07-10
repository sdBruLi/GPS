/*    */ package com.china317.core.codec.jtt808Gateway.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808Gateway.GatewayBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class GatewayBody_0x8011 extends GatewayBody
/*    */ {
/*    */   public static final byte RESULT_OK = 0;
/*    */   public static final byte RESULT_FAILURE = 1;
/*    */   public static final byte RESULT_OFFLINE = 2;
/*    */   public static final byte RESULT_ACK_OK = 3;
/*    */   public static final byte RESULT_ACK_FAILED = 4;
/*    */   public static final byte RESULT_ACK_RESULT = 5;
/*    */   public static final byte RESULT_ACK_TIMEOUT = 6;
/*    */   public static final byte RESULT_RST_TIMEOUT = 7;
/* 19 */   private String messageId = "";
/* 20 */   private String sessionid = "";
/*    */   private int status;
/*    */   private int sequenceNum;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!isBuildBody()) {
/* 27 */       this.bodyBuffer = IoBuffer.allocate(33).setAutoExpand(true);
/* 28 */       this.bodyBuffer.putString(this.messageId, 20, DefaultCharset.encoder);
/* 29 */       this.bodyBuffer.putString(this.sessionid, 12, DefaultCharset.encoder);
/* 30 */       this.bodyBuffer.putUnsigned(this.status);
/* 31 */       this.bodyBuffer.putInt(this.sequenceNum);
/* 32 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 38 */     this.messageId = this.bodyBuffer.getString(20, DefaultCharset.decoder);
/* 39 */     this.sessionid = this.bodyBuffer.getString(12, DefaultCharset.decoder);
/* 40 */     this.status = this.bodyBuffer.getUnsigned();
/* 41 */     this.sequenceNum = this.bodyBuffer.getInt();
/* 42 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getStatus() {
/* 46 */     return this.status;
/*    */   }
/*    */ 
/*    */   public void setStatus(int status) {
/* 50 */     this.status = status;
/*    */   }
/*    */ 
/*    */   public String getSessionid() {
/* 54 */     return this.sessionid;
/*    */   }
/*    */ 
/*    */   public void setSessionid(String sessionid) {
/* 58 */     this.sessionid = sessionid;
/*    */   }
/*    */ 
/*    */   public String getMessageId() {
/* 62 */     return this.messageId;
/*    */   }
/*    */ 
/*    */   public void setMessageId(String messageId) {
/* 66 */     this.messageId = messageId;
/*    */   }
/*    */ 
/*    */   public int getSequenceNum() {
/* 70 */     return this.sequenceNum;
/*    */   }
/*    */ 
/*    */   public void setSequenceNum(int sequenceNum) {
/* 74 */     this.sequenceNum = sequenceNum;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x8011
 * JD-Core Version:    0.6.1
 */