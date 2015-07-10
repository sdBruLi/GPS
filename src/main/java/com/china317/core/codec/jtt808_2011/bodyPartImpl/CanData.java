/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class CanData
/*    */ {
/*    */   private Date createTime;
/*    */   private Date time;
/*    */   private int id;
/*    */   private byte channel;
/*    */   private byte type;
/*    */   private byte collect;
/*    */   private long data;
/*    */ 
/*    */   public long getData()
/*    */   {
/* 15 */     return this.data;
/*    */   }
/*    */ 
/*    */   public void setData(long data) {
/* 19 */     this.data = data;
/*    */   }
/*    */ 
/*    */   public CanData() {
/* 23 */     this.createTime = new Date();
/*    */   }
/*    */ 
/*    */   public byte getChannel() {
/* 27 */     return this.channel;
/*    */   }
/*    */ 
/*    */   public void setChannel(byte channel) {
/* 31 */     this.channel = channel;
/*    */   }
/*    */ 
/*    */   public byte getType() {
/* 35 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(byte type) {
/* 39 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public byte getCollect() {
/* 43 */     return this.collect;
/*    */   }
/*    */ 
/*    */   public void setCollect(byte collect) {
/* 47 */     this.collect = collect;
/*    */   }
/*    */ 
/*    */   public int getId() {
/* 51 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(int id) {
/* 55 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Date getCreateTime() {
/* 59 */     return this.createTime;
/*    */   }
/*    */ 
/*    */   public void setCreateTime(Date createTime) {
/* 63 */     this.createTime = createTime;
/*    */   }
/*    */ 
/*    */   public Date getTime() {
/* 67 */     return this.time;
/*    */   }
/*    */ 
/*    */   public void setTime(Date time) {
/* 71 */     this.time = time;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.CanData
 * JD-Core Version:    0.6.1
 */