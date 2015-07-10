/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg;
/*     */ 
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class UpExgMsgRealLocation_0x1202 extends UpExgMsgHead
/*     */ {
/*     */   private byte encrype;
/*     */   private byte[] date;
/*     */   private byte[] time;
/*     */   private int lon;
/*     */   private int lat;
/*     */   private short vec1;
/*     */   private short vec2;
/*     */   private int vec3;
/*     */   private short direction;
/*     */   private short altitude;
/*     */   private int state;
/*     */   private int alarm;
/*     */ 
/*     */   public UpExgMsgRealLocation_0x1202()
/*     */   {
/*     */   }
/*     */ 
/*     */   public UpExgMsgRealLocation_0x1202(int msgId)
/*     */   {
/*  11 */     super.setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public byte[] buildBody() throws Exception
/*     */   {
/*  16 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  17 */     setDatalength(36);
/*  18 */     buildFirstBody(buffer);
/*     */ 
/*  20 */     buffer.put(buildGnssBody());
/*     */ 
/*  22 */     buffer.flip();
/*  23 */     byte[] bytes = new byte[buffer.remaining()];
/*  24 */     buffer.get(bytes);
/*  25 */     return bytes;
/*     */   }
/*     */ 
/*     */   public byte[] buildGnssBody() {
/*  29 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/*  30 */     buffer.put(getEncrype());
/*  31 */     buffer.put(getDate());
/*  32 */     buffer.put(getTime());
/*  33 */     buffer.putInt(getLon());
/*  34 */     buffer.putInt(getLat());
/*  35 */     buffer.putShort(getVec1());
/*  36 */     buffer.putShort(getVec2());
/*  37 */     buffer.putInt(getVec3());
/*  38 */     buffer.putShort(getDirection());
/*  39 */     buffer.putShort(getAltitude());
/*  40 */     buffer.putInt(getState());
/*  41 */     buffer.putInt(getAlarm());
/*  42 */     buffer.flip();
/*     */ 
/*  44 */     byte[] datas = new byte[buffer.limit()];
/*  45 */     buffer.get(datas);
/*  46 */     return datas;
/*     */   }
/*     */ 
/*     */   public int getCommand() {
/*  50 */     return 4610;
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  55 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  56 */     parseFirstBody(buffer);
/*     */ 
/*  58 */     parseLocationBody(buffer);
/*     */   }
/*     */ 
/*     */   public void parseLocationBody(IoBuffer buffer)
/*     */   {
/*  63 */     initBytes();
/*     */ 
/*  65 */     setEncrype(buffer.get());
/*  66 */     buffer.get(this.date);
/*  67 */     buffer.get(this.time);
/*  68 */     setLon(buffer.getInt());
/*  69 */     setLat(buffer.getInt());
/*  70 */     setVec1(buffer.getShort());
/*  71 */     setVec2(buffer.getShort());
/*  72 */     setVec3(buffer.getInt());
/*  73 */     setDirection(buffer.getShort());
/*  74 */     setAltitude(buffer.getShort());
/*  75 */     setState(buffer.getInt());
/*  76 */     setAlarm(buffer.getInt());
/*     */   }
/*     */ 
/*     */   private void initBytes() {
/*  80 */     this.date = new byte[4];
/*  81 */     this.time = new byte[3];
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  98 */     return super.toString() + ",lon=" + this.lon + 
/*  99 */       ",lat=" + this.lat;
/*     */   }
/*     */   public byte getEncrype() {
/* 102 */     return this.encrype;
/*     */   }
/*     */ 
/*     */   public void setEncrype(byte encrype) {
/* 106 */     this.encrype = encrype;
/*     */   }
/*     */ 
/*     */   public byte[] getDate() {
/* 110 */     return this.date;
/*     */   }
/*     */ 
/*     */   public void setDate(byte[] date) {
/* 114 */     this.date = date;
/*     */   }
/*     */ 
/*     */   public byte[] getTime() {
/* 118 */     return this.time;
/*     */   }
/*     */ 
/*     */   public void setTime(byte[] time) {
/* 122 */     this.time = time;
/*     */   }
/*     */ 
/*     */   public int getLon() {
/* 126 */     return this.lon;
/*     */   }
/*     */ 
/*     */   public void setLon(int lon) {
/* 130 */     this.lon = lon;
/*     */   }
/*     */ 
/*     */   public int getLat() {
/* 134 */     return this.lat;
/*     */   }
/*     */ 
/*     */   public void setLat(int lat) {
/* 138 */     this.lat = lat;
/*     */   }
/*     */ 
/*     */   public short getVec1() {
/* 142 */     return this.vec1;
/*     */   }
/*     */ 
/*     */   public void setVec1(short vec1) {
/* 146 */     this.vec1 = vec1;
/*     */   }
/*     */ 
/*     */   public short getVec2() {
/* 150 */     return this.vec2;
/*     */   }
/*     */ 
/*     */   public void setVec2(short vec2) {
/* 154 */     this.vec2 = vec2;
/*     */   }
/*     */ 
/*     */   public int getVec3() {
/* 158 */     return this.vec3;
/*     */   }
/*     */ 
/*     */   public void setVec3(int vec3) {
/* 162 */     this.vec3 = vec3;
/*     */   }
/*     */ 
/*     */   public short getDirection() {
/* 166 */     return this.direction;
/*     */   }
/*     */ 
/*     */   public void setDirection(short direction) {
/* 170 */     this.direction = direction;
/*     */   }
/*     */ 
/*     */   public short getAltitude() {
/* 174 */     return this.altitude;
/*     */   }
/*     */ 
/*     */   public void setAltitude(short altitude) {
/* 178 */     this.altitude = altitude;
/*     */   }
/*     */ 
/*     */   public int getState() {
/* 182 */     return this.state;
/*     */   }
/*     */ 
/*     */   public void setState(int state) {
/* 186 */     this.state = state;
/*     */   }
/*     */ 
/*     */   public int getAlarm() {
/* 190 */     return this.alarm;
/*     */   }
/*     */ 
/*     */   public void setAlarm(int alarm) {
/* 194 */     this.alarm = alarm;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgRealLocation_0x1202
 * JD-Core Version:    0.6.1
 */