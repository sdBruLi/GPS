/*    */ package com.china317.core.codec.jtt808Gateway.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808Gateway.DataRow0012;
/*    */ import com.china317.core.codec.jtt808Gateway.GatewayBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import java.nio.charset.Charset;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class GatewayBody_0x0012 extends GatewayBody
/*    */ {
/* 17 */   private Log log = LogFactory.getLog(GatewayBody_0x0012.class);
/*    */   private int rowNum;
/* 19 */   private List<DataRow0012> dataRowList = new ArrayList();
/*    */ 
/*    */   public void bulidBody() throws Exception
/*    */   {
/* 23 */     if (!isBuildBody()) {
/* 24 */       this.bodyBuffer = IoBuffer.allocate(100).setAutoExpand(true);
/* 25 */       this.bodyBuffer.putUnsigned(this.rowNum);
/* 26 */       for (DataRow0012 row : this.dataRowList) {
/*    */         try {
/* 28 */           this.bodyBuffer.putString(row.getSessionid(), 12, Charset.forName("GBK").newEncoder());
/*    */         } catch (Exception e) {
/* 30 */           this.log.error("", e);
/* 31 */           this.log.error("encoder error, sessionid = [" + row.getSessionid() + "]");
/* 32 */           this.bodyBuffer.putString(row.getSessionid(), 12, DefaultCharset.encoder);
/*    */         }
/*    */ 
/* 35 */         this.bodyBuffer.putUnsignedShort(row.getLength());
/* 36 */         this.bodyBuffer.put(row.getRowBuffer());
/*    */       }
/* 38 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 44 */     this.rowNum = this.bodyBuffer.getUnsigned();
/* 45 */     for (int i = 0; i < this.rowNum; i++) {
/* 46 */       DataRow0012 row = new DataRow0012();
/* 47 */       row.setSessionid(this.bodyBuffer.getString(12, DefaultCharset.decoder));
/* 48 */       row.setLength(this.bodyBuffer.getUnsignedShort());
/*    */ 
/* 51 */       if (this.bodyBuffer.limit() - 14 - row.getLength() > 0) {
/* 52 */         row.setRowBuffer(this.bodyBuffer.getSlice(row.getLength()));
/* 53 */         this.dataRowList.add(row);
/*    */       } else {
/* 55 */         this.log.error("GatewayBody_0x0012 error frame data");
/*    */       }
/*    */     }
/*    */ 
/* 59 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/*    */   }
/*    */ 
/*    */   public int getRowNum() {
/* 66 */     return this.rowNum;
/*    */   }
/*    */ 
/*    */   public void setRowNum(int rowNum) {
/* 70 */     this.rowNum = rowNum;
/*    */   }
/*    */ 
/*    */   public List<DataRow0012> getDataRowList() {
/* 74 */     return this.dataRowList;
/*    */   }
/*    */ 
/*    */   public void setDataRowList(List<DataRow0012> dataRowList) {
/* 78 */     this.dataRowList = dataRowList;
/*    */   }
/*    */ 
/*    */   public void addDataRowList(DataRow0012 dataRow0012) {
/* 82 */     this.dataRowList.add(dataRow0012);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0012
 * JD-Core Version:    0.6.1
 */