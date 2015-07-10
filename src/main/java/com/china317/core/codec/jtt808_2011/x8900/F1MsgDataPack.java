/*     */ package com.china317.core.codec.jtt808_2011.x8900;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*     */ import java.util.HashMap;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public abstract class F1MsgDataPack
/*     */ {
/*  10 */   protected byte typeid = -15;
/*     */   protected int msgid;
/*     */   protected int len;
/*     */   protected IoBuffer data;
/*     */   protected int demolition;
/*     */   protected JT808MsgBody_0x0200 gpsData;
/*     */   protected HashMap<Long, Byte> labelStatus;
/*     */ 
/*     */   public int getMsgid()
/*     */   {
/*  22 */     return this.msgid;
/*     */   }
/*     */ 
/*     */   public void setMsgid(int msgid) {
/*  26 */     this.msgid = msgid;
/*     */   }
/*     */ 
/*     */   public int getLen() {
/*  30 */     return this.len;
/*     */   }
/*     */ 
/*     */   public void setLen(int len) {
/*  34 */     this.len = len;
/*     */   }
/*     */ 
/*     */   public IoBuffer getData()
/*     */     throws Exception
/*     */   {
/*  43 */     if (this.data == null) {
/*  44 */       bulid();
/*     */     }
/*  46 */     return this.data;
/*     */   }
/*     */ 
/*     */   public void setData(IoBuffer data) {
/*  50 */     this.data = data;
/*     */   }
/*     */ 
/*     */   public abstract void praser()
/*     */     throws Exception;
/*     */ 
/*     */   public abstract void bulid()
/*     */     throws Exception;
/*     */ 
/*     */   public void bulid(IoBuffer bodybuffer)
/*     */     throws Exception
/*     */   {
/*  64 */     this.len = 4;
/*  65 */     if (bodybuffer != null) {
/*  66 */       this.len += bodybuffer.limit();
/*     */     }
/*  68 */     this.data = IoBuffer.allocate(this.len);
/*  69 */     this.data.putUnsignedShort(this.msgid);
/*  70 */     if (bodybuffer == null) {
/*  71 */       this.data.putUnsignedShort(0);
/*     */     } else {
/*  73 */       this.data.putUnsignedShort(bodybuffer.limit());
/*  74 */       this.data.put(bodybuffer);
/*     */     }
/*  76 */     this.data.flip();
/*     */   }
/*     */ 
/*     */   public F1MsgDataPack(int msgid, int len, IoBuffer data)
/*     */   {
/*  87 */     this.msgid = msgid;
/*  88 */     this.len = len;
/*  89 */     this.data = data;
/*     */   }
/*     */ 
/*     */   public JT808MsgBody_0x0200 getGpsData() {
/*  93 */     return this.gpsData;
/*     */   }
/*     */ 
/*     */   public void setGpsData(JT808MsgBody_0x0200 gpsData) {
/*  97 */     this.gpsData = gpsData;
/*     */   }
/*     */ 
/*     */   public HashMap<Long, Byte> getLabelStatus() {
/* 101 */     return this.labelStatus;
/*     */   }
/*     */ 
/*     */   public void setLabelStatus(HashMap<Long, Byte> labelStatus) {
/* 105 */     this.labelStatus = labelStatus;
/*     */   }
/*     */ 
/*     */   public void prase200Body() throws Exception {
/* 109 */     this.gpsData.praseBody();
/*     */   }
/*     */ 
/*     */   public byte getTypeid() {
/* 113 */     return this.typeid;
/*     */   }
/*     */ 
/*     */   public void setTypeid(byte typeid) {
/* 117 */     this.typeid = typeid;
/*     */   }
/*     */ 
/*     */   public int getDemolition() {
/* 121 */     return this.demolition;
/*     */   }
/*     */ 
/*     */   public void setDemolition(int demolition) {
/* 125 */     this.demolition = demolition;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.x8900.F1MsgDataPack
 * JD-Core Version:    0.6.1
 */