/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpExgMsgReportDriverInfoAck_0x120A extends UpExgMsgHead
/*    */ {
/*    */   private String driverName;
/*    */   private String driverId;
/*    */   private String licence;
/*    */   private String orgName;
/*    */ 
/*    */   public UpExgMsgReportDriverInfoAck_0x120A()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UpExgMsgReportDriverInfoAck_0x120A(int msgId)
/*    */   {
/* 14 */     setDataType(msgId);
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception
/*    */   {
/* 19 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 20 */     setDatalength(276);
/* 21 */     buildFirstBody(buffer);
/*    */ 
/* 23 */     buffer.putString(getDriverName(), 16, Constants.CharsetEncoder_GBK);
/* 24 */     buffer.putString(getDriverId(), 20, Constants.CharsetEncoder_GBK);
/* 25 */     buffer.putString(getLicence(), 40, Constants.CharsetEncoder_GBK);
/* 26 */     buffer.putString(getOrgName(), 200, Constants.CharsetEncoder_GBK);
/*    */ 
/* 28 */     buffer.flip();
/* 29 */     byte[] bytes = new byte[buffer.remaining()];
/* 30 */     buffer.get(bytes);
/* 31 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 37 */     return 4618;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 42 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 43 */     parseFirstBody(buffer);
/*    */ 
/* 45 */     parseLocationBody(buffer);
/*    */   }
/*    */ 
/*    */   public void parseLocationBody(IoBuffer buffer)
/*    */     throws CharacterCodingException
/*    */   {
/* 51 */     setDriverName(buffer.getString(16, Constants.CharsetDecoder_GBK));
/* 52 */     setDriverId(buffer.getString(20, Constants.CharsetDecoder_GBK));
/* 53 */     setLicence(buffer.getString(40, Constants.CharsetDecoder_GBK));
/* 54 */     setOrgName(buffer.getString(200, Constants.CharsetDecoder_GBK));
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 65 */     return super.toString() + ",driverName=" + this.driverName + 
/* 66 */       ",driverId=" + this.driverId + ",licence=" + this.licence + 
/* 67 */       ",orgName=" + this.orgName;
/*    */   }
/*    */   public String getDriverName() {
/* 70 */     return this.driverName;
/*    */   }
/*    */ 
/*    */   public void setDriverName(String driverName) {
/* 74 */     this.driverName = driverName;
/*    */   }
/*    */ 
/*    */   public String getDriverId() {
/* 78 */     return this.driverId;
/*    */   }
/*    */ 
/*    */   public void setDriverId(String driverId) {
/* 82 */     this.driverId = driverId;
/*    */   }
/*    */ 
/*    */   public String getLicence() {
/* 86 */     return this.licence;
/*    */   }
/*    */ 
/*    */   public void setLicence(String licence) {
/* 90 */     this.licence = licence;
/*    */   }
/*    */ 
/*    */   public String getOrgName() {
/* 94 */     return this.orgName;
/*    */   }
/*    */ 
/*    */   public void setOrgName(String orgName) {
/* 98 */     this.orgName = orgName;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgReportDriverInfoAck_0x120A
 * JD-Core Version:    0.6.1
 */