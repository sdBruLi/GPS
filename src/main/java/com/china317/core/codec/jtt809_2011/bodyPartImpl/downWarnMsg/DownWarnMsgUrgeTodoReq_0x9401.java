/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DownWarnMsgUrgeTodoReq_0x9401 extends DownWarnMsgHead
/*     */ {
/*     */   private int supervisionId;
/*     */   private long supervisionEndtime;
/*     */   private byte supervisionLevel;
/*     */   private String supervisor;
/*     */   private String supervisorTel;
/*     */   private String supervisorEmail;
/*     */ 
/*     */   public int getSupervisionId()
/*     */   {
/*  18 */     return this.supervisionId;
/*     */   }
/*     */ 
/*     */   public void setSupervisionId(int supervisionId) {
/*  22 */     this.supervisionId = supervisionId;
/*     */   }
/*     */ 
/*     */   public long getSupervisionEndtime() {
/*  26 */     return this.supervisionEndtime;
/*     */   }
/*     */ 
/*     */   public void setSupervisionEndtime(long supervisionEndtime) {
/*  30 */     this.supervisionEndtime = supervisionEndtime;
/*     */   }
/*     */ 
/*     */   public byte getSupervisionLevel() {
/*  34 */     return this.supervisionLevel;
/*     */   }
/*     */ 
/*     */   public void setSupervisionLevel(byte supervisionLevel) {
/*  38 */     this.supervisionLevel = supervisionLevel;
/*     */   }
/*     */ 
/*     */   public String getSupervisor() {
/*  42 */     return this.supervisor;
/*     */   }
/*     */ 
/*     */   public void setSupervisor(String supervisor) {
/*  46 */     this.supervisor = supervisor;
/*     */   }
/*     */ 
/*     */   public String getSupervisorTel() {
/*  50 */     return this.supervisorTel;
/*     */   }
/*     */ 
/*     */   public void setSupervisorTel(String supervisorTel) {
/*  54 */     this.supervisorTel = supervisorTel;
/*     */   }
/*     */ 
/*     */   public String getSupervisorEmail() {
/*  58 */     return this.supervisorEmail;
/*     */   }
/*     */ 
/*     */   public void setSupervisorEmail(String supervisorEmail) {
/*  62 */     this.supervisorEmail = supervisorEmail;
/*     */   }
/*     */ 
/*     */   public DownWarnMsgUrgeTodoReq_0x9401()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DownWarnMsgUrgeTodoReq_0x9401(int msgId) {
/*  70 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  75 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  76 */     parseFirstBody(buffer);
/*  77 */     setSupervisionId(buffer.getInt());
/*  78 */     setSupervisionEndtime(buffer.getLong());
/*  79 */     setSupervisionLevel(buffer.get());
/*  80 */     setSupervisor(buffer.getString(16, Constants.CharsetDecoder_GBK));
/*  81 */     setSupervisorTel(buffer.getString(20, Constants.CharsetDecoder_GBK));
/*  82 */     setSupervisorEmail(buffer.getString(32, Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/*  87 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  88 */     setDataLength(92);
/*  89 */     buildFirstBody(buffer);
/*  90 */     buffer.putInt(getSupervisionId());
/*  91 */     buffer.putLong(getSupervisionEndtime());
/*  92 */     buffer.put(getSupervisionLevel());
/*  93 */     buffer.put(ByteUtil.string2ByteArray(getSupervisor(), 16, "GBK"));
/*  94 */     buffer.put(ByteUtil.string2ByteArray(getSupervisorTel(), 20, "GBK"));
/*  95 */     buffer.put(ByteUtil.string2ByteArray(getSupervisorEmail(), 32, "GBK"));
/*  96 */     buffer.flip();
/*  97 */     byte[] bytes = new byte[buffer.remaining()];
/*  98 */     buffer.get(bytes);
/*  99 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/* 104 */     return 37889;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 108 */     return super.toString() + ",supervisionId=" + this.supervisionId + 
/* 109 */       ",supervisionEndtime=" + this.supervisionEndtime + ",supervisionLevel=" + this.supervisionLevel + 
/* 110 */       ",supervisor=" + this.supervisor + ",supervisorTel=" + this.supervisorTel + 
/* 111 */       ",supervisorEmail=" + this.supervisorEmail;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 115 */     DownWarnMsgUrgeTodoReq_0x9401 entity = new DownWarnMsgUrgeTodoReq_0x9401();
/* 116 */     entity.setVehicleNo("沪A3804");
/* 117 */     entity.setVehicleColor((byte)1);
/* 118 */     entity.setDataType(1);
/*     */ 
/* 120 */     entity.setWarnSrc((byte)1);
/* 121 */     entity.setWarnType((short)1);
/* 122 */     entity.setWarnTime(1234567890123L);
/* 123 */     entity.setSupervisionId(1);
/* 124 */     entity.setSupervisionEndtime(1234567890456L);
/* 125 */     entity.setSupervisionLevel((byte)1);
/* 126 */     entity.setSupervisor("中安");
/* 127 */     entity.setSupervisorTel("02154264798");
/* 128 */     entity.setSupervisorEmail("zha@china317.com");
/*     */ 
/* 131 */     DownWarnMsgUrgeTodoReq_0x9401 entity2 = new DownWarnMsgUrgeTodoReq_0x9401();
/* 132 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg.DownWarnMsgUrgeTodoReq_0x9401
 * JD-Core Version:    0.6.1
 */