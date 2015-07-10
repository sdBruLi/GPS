/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.codecExt;
/*     */ 
/*     */ import com.china317.core.base.UpMessage;
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgId;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class ObjectDataJT808
/*     */   implements UpMessage
/*     */ {
/*     */   private int msgId;
/*     */   private long sessionId;
/*     */   private String mobileNum;
/*  18 */   private int startSeq = 0;
/*     */   private String messageId;
/*  20 */   private Map<Integer, ObjectDataPacket> packets = new HashMap();
/*     */   private int packetCount;
/*  22 */   private int currentMaxSequenceNum = 0;
/*     */   private int ackSeqenceNum;
/*     */   private long createTime;
/*     */ 
/*     */   public ObjectDataJT808()
/*     */   {
/*  29 */     this.createTime = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   public String getCommand() {
/*  33 */     return JT808MsgId.getStringCommand(this.msgId);
/*     */   }
/*     */ 
/*     */   public long getSessionId() {
/*  37 */     return this.sessionId;
/*     */   }
/*     */ 
/*     */   public String getUniqueIndex()
/*     */   {
/*  42 */     return String.valueOf(this.startSeq);
/*     */   }
/*     */ 
/*     */   public byte[] getBytes() {
/*  46 */     IoBuffer buf = IoBuffer.allocate(128).setAutoExpand(true);
/*  47 */     for (int i = 1; i < this.packetCount + 1; i++) {
/*  48 */       buf.put(((ObjectDataPacket)this.packets.get(Integer.valueOf(i))).getBuffer());
/*     */     }
/*  50 */     byte[] bytes = new byte[buf.position()];
/*  51 */     buf.rewind();
/*  52 */     buf.get(bytes);
/*  53 */     return bytes;
/*     */   }
/*     */ 
/*     */   public List<Integer> getPatchPackets() {
/*  57 */     List listPkgNums = null;
/*  58 */     for (int i = 1; i <= this.currentMaxSequenceNum; i++) {
/*  59 */       if (this.packets.get(Integer.valueOf(i)) == null) {
/*  60 */         if (listPkgNums == null) {
/*  61 */           listPkgNums = new ArrayList();
/*     */         }
/*  63 */         listPkgNums.add(Integer.valueOf(i));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  77 */     return listPkgNums;
/*     */   }
/*     */ 
/*     */   public void addPacket(Integer seq, ObjectDataPacket packet) {
/*  81 */     this.packets.put(seq, packet);
/*  82 */     if (packet.getId() > this.currentMaxSequenceNum)
/*  83 */       this.currentMaxSequenceNum = packet.getId();
/*     */   }
/*     */ 
/*     */   public int getPacketsSize()
/*     */   {
/*  88 */     return this.packets.size();
/*     */   }
/*     */ 
/*     */   public int getMsgId() {
/*  92 */     return this.msgId;
/*     */   }
/*     */ 
/*     */   public void setMsgId(int msgId) {
/*  96 */     this.msgId = msgId;
/*     */   }
/*     */ 
/*     */   public int getStartSeq() {
/* 100 */     return this.startSeq;
/*     */   }
/*     */ 
/*     */   public void setStartSeq(int startSeq) {
/* 104 */     this.startSeq = startSeq;
/*     */   }
/*     */ 
/*     */   public void setSessionId(long sessionId) {
/* 108 */     this.sessionId = sessionId;
/*     */   }
/*     */ 
/*     */   public String getMessageId() {
/* 112 */     return this.messageId;
/*     */   }
/*     */ 
/*     */   public void setMessageId(String messageId) {
/* 116 */     this.messageId = messageId;
/*     */   }
/*     */ 
/*     */   public Map<Integer, ObjectDataPacket> getPackets() {
/* 120 */     return this.packets;
/*     */   }
/*     */ 
/*     */   public void setPackets(Map<Integer, ObjectDataPacket> packets) {
/* 124 */     this.packets = packets;
/*     */   }
/*     */ 
/*     */   public int getPacketCount() {
/* 128 */     return this.packetCount;
/*     */   }
/*     */ 
/*     */   public void setPacketCount(int packetCount) {
/* 132 */     this.packetCount = packetCount;
/*     */   }
/*     */ 
/*     */   public int getCurrentMaxSequenceNum() {
/* 136 */     return this.currentMaxSequenceNum;
/*     */   }
/*     */ 
/*     */   public void setCurrentMaxSequenceNum(int currentMaxSequenceNum) {
/* 140 */     this.currentMaxSequenceNum = currentMaxSequenceNum;
/*     */   }
/*     */ 
/*     */   public String getMobileNum() {
/* 144 */     return this.mobileNum;
/*     */   }
/*     */ 
/*     */   public void setMobileNum(String mobileNum) {
/* 148 */     this.mobileNum = mobileNum;
/*     */   }
/*     */ 
/*     */   public int getAckSeqenceNum() {
/* 152 */     return this.ackSeqenceNum;
/*     */   }
/*     */ 
/*     */   public void setAckSeqenceNum(int ackSeqenceNum) {
/* 156 */     this.ackSeqenceNum = ackSeqenceNum;
/*     */   }
/*     */ 
/*     */   public long getCreateTime()
/*     */   {
/* 175 */     return this.createTime;
/*     */   }
/*     */   public void setCreateTime(long createTime) {
/* 178 */     this.createTime = createTime;
/*     */   }
/*     */ 
/*     */   public void unpack(UnitPackJT808 pack)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.codecExt.ObjectDataJT808
 * JD-Core Version:    0.6.1
 */