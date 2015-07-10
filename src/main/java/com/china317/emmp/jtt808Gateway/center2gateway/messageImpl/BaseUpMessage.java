/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.base.UpMessage;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import java.util.Date;
/*    */ 
/*    */ public abstract class BaseUpMessage
/*    */   implements UpMessage
/*    */ {
/*    */   private int msgId;
/*    */   private String uniqueIndex;
/*    */   private String mobileNum;
/*    */   private int sequenceNum;
/*    */   private String command;
/*    */   private Date createTime;
/*    */ 
/*    */   public BaseUpMessage()
/*    */   {
/* 16 */     this.createTime = new Date(System.currentTimeMillis());
/*    */   }
/*    */ 
/*    */   public void unpackHeadPart(UnitPackJT808 pack) {
/* 20 */     setMsgId(pack.getMsgID());
/* 21 */     setUniqueIndex(pack.getUniqueIndex());
/* 22 */     setSequenceNum(pack.getSequenceNum());
/* 23 */     setMobileNum(pack.getMobileNum());
/*    */   }
/*    */ 
/*    */   public int getMsgId() {
/* 27 */     return this.msgId;
/*    */   }
/*    */ 
/*    */   public void setMsgId(int msgId)
/*    */   {
/* 32 */     this.msgId = msgId;
/*    */   }
/*    */ 
/*    */   public void setCommand(String command)
/*    */   {
/* 37 */     this.command = command;
/*    */   }
/*    */ 
/*    */   public void setSequenceNum(int sequenceNum) {
/* 41 */     this.sequenceNum = sequenceNum;
/*    */   }
/*    */ 
/*    */   public void setUniqueIndex(String uniqueIndex) {
/* 45 */     this.uniqueIndex = uniqueIndex;
/*    */   }
/*    */ 
/*    */   public int getSequenceNum() {
/* 49 */     return this.sequenceNum;
/*    */   }
/*    */ 
/*    */   public String getUniqueIndex() {
/* 53 */     return this.uniqueIndex;
/*    */   }
/*    */ 
/*    */   public String getCommand()
/*    */   {
/* 59 */     return this.command;
/*    */   }
/*    */ 
/*    */   public String getMobileNum()
/*    */   {
/* 64 */     return this.mobileNum;
/*    */   }
/*    */ 
/*    */   public void setMobileNum(String mobileNum) {
/* 68 */     this.mobileNum = mobileNum;
/*    */   }
/*    */ 
/*    */   public Date getCreateTime() {
/* 72 */     return this.createTime;
/*    */   }
/*    */ 
/*    */   public void setCreateTime(Date createTime)
/*    */   {
/* 77 */     this.createTime = createTime;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.BaseUpMessage
 * JD-Core Version:    0.6.1
 */