/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0901;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class CompressionDataUploadMsg extends BaseUpMessage
/*    */ {
/* 16 */   private static final Log log = LogFactory.getLog(CompressionDataUploadMsg.class);
/*    */   private int compressionDataLen;
/*    */   private IoBuffer compressionData;
/*    */ 
/*    */   public CompressionDataUploadMsg()
/*    */   {
/* 21 */     setCommand("0x0901");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 26 */     unpackHeadPart(pack);
/*    */     try {
/* 28 */       JT808MsgBody_0x0901 body = (JT808MsgBody_0x0901)pack.getMsgBody();
/* 29 */       setCompressionDataLen(body.getCompressionDataLen());
/* 30 */       setCompressionData(body.getCompressionData());
/*    */     } catch (Exception e) {
/* 32 */       log.debug("unpack fail ", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getCompressionDataLen() {
/* 37 */     return this.compressionDataLen;
/*    */   }
/*    */ 
/*    */   public void setCompressionDataLen(int compressionDataLen)
/*    */   {
/* 42 */     this.compressionDataLen = compressionDataLen;
/*    */   }
/*    */ 
/*    */   public IoBuffer getCompressionData() {
/* 46 */     return this.compressionData;
/*    */   }
/*    */ 
/*    */   public void setCompressionData(IoBuffer compressionData)
/*    */   {
/* 51 */     this.compressionData = compressionData;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.CompressionDataUploadMsg
 * JD-Core Version:    0.6.1
 */