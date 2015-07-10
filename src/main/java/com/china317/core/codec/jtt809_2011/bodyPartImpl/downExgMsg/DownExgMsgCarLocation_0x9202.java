/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg;
/*     */ 
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DownExgMsgCarLocation_0x9202 extends DownExgMsgHead
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
/*     */   public DownExgMsgCarLocation_0x9202()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DownExgMsgCarLocation_0x9202(int msgId)
/*     */   {
/*  14 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public byte[] buildBody() throws Exception
/*     */   {
/*  19 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/*  20 */     setDatalength(36);
/*  21 */     buildFirstBody(buffer);
/*     */ 
/*  23 */     buffer.put(buildLocationBuffer());
/*     */ 
/*  26 */     buffer.flip();
/*  27 */     byte[] bytes = new byte[buffer.remaining()];
/*  28 */     buffer.get(bytes);
/*  29 */     return bytes;
/*     */   }
/*     */ 
/*     */   public byte[] buildLocationBuffer() {
/*  33 */     IoBuffer buffer = IoBuffer.allocate(36);
/*  34 */     buffer.put(getEncrype());
/*  35 */     buffer.put(getDate());
/*  36 */     buffer.put(getTime());
/*  37 */     buffer.putInt(getLon());
/*  38 */     buffer.putInt(getLat());
/*  39 */     buffer.putShort(getVec1());
/*  40 */     buffer.putShort(getVec2());
/*  41 */     buffer.putInt(getVec3());
/*  42 */     buffer.putShort(getDirection());
/*  43 */     buffer.putShort(getAltitude());
/*  44 */     buffer.putInt(getState());
/*  45 */     buffer.putInt(getAlarm());
/*  46 */     buffer.flip();
/*  47 */     byte[] datas = new byte[36];
/*  48 */     buffer.get(datas);
/*  49 */     return datas;
/*     */   }
/*     */ 
/*     */   public int getCommand() {
/*  53 */     return 37378;
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  58 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  59 */     parseFirstBody(buffer);
/*     */ 
/*  61 */     parseLocationBody(buffer);
/*     */   }
/*     */ 
/*     */   public void parseLocationBody(IoBuffer buffer)
/*     */   {
/*  67 */     initBytes();
/*     */ 
/*  69 */     setEncrype(buffer.get());
/*  70 */     buffer.get(this.date);
/*  71 */     buffer.get(this.time);
/*  72 */     setLon(buffer.getInt());
/*  73 */     setLat(buffer.getInt());
/*  74 */     setVec1(buffer.getShort());
/*  75 */     setVec2(buffer.getShort());
/*  76 */     setVec3(buffer.getInt());
/*  77 */     setDirection(buffer.getShort());
/*  78 */     setAltitude(buffer.getShort());
/*  79 */     setState(buffer.getInt());
/*  80 */     setAlarm(buffer.getInt());
/*     */   }
/*     */ 
/*     */   private void initBytes() {
/*  84 */     this.date = new byte[4];
/*  85 */     this.time = new byte[3];
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 102 */     return super.toString() + ",lon=" + this.lon + ",lat" + this.lat;
/*     */   }
/*     */ 
/*     */   public byte getEncrype() {
/* 106 */     return this.encrype;
/*     */   }
/*     */ 
/*     */   public void setEncrype(byte encrype) {
/* 110 */     this.encrype = encrype;
/*     */   }
/*     */ 
/*     */   public byte[] getDate() {
/* 114 */     return this.date;
/*     */   }
/*     */ 
/*     */   public void setDate(byte[] date) {
/* 118 */     this.date = date;
/*     */   }
/*     */ 
/*     */   public byte[] getTime() {
/* 122 */     return this.time;
/*     */   }
/*     */ 
/*     */   public void setTime(byte[] time) {
/* 126 */     this.time = time;
/*     */   }
/*     */ 
/*     */   public int getLon() {
/* 130 */     return this.lon;
/*     */   }
/*     */ 
/*     */   public void setLon(int lon) {
/* 134 */     this.lon = lon;
/*     */   }
/*     */ 
/*     */   public int getLat() {
/* 138 */     return this.lat;
/*     */   }
/*     */ 
/*     */   public void setLat(int lat) {
/* 142 */     this.lat = lat;
/*     */   }
/*     */ 
/*     */   public short getVec1() {
/* 146 */     return this.vec1;
/*     */   }
/*     */ 
/*     */   public void setVec1(short vec1) {
/* 150 */     this.vec1 = vec1;
/*     */   }
/*     */ 
/*     */   public short getVec2() {
/* 154 */     return this.vec2;
/*     */   }
/*     */ 
/*     */   public void setVec2(short vec2) {
/* 158 */     this.vec2 = vec2;
/*     */   }
/*     */ 
/*     */   public int getVec3() {
/* 162 */     return this.vec3;
/*     */   }
/*     */ 
/*     */   public void setVec3(int vec3) {
/* 166 */     this.vec3 = vec3;
/*     */   }
/*     */ 
/*     */   public short getDirection() {
/* 170 */     return this.direction;
/*     */   }
/*     */ 
/*     */   public void setDirection(short direction) {
/* 174 */     this.direction = direction;
/*     */   }
/*     */ 
/*     */   public short getAltitude() {
/* 178 */     return this.altitude;
/*     */   }
/*     */ 
/*     */   public void setAltitude(short altitude) {
/* 182 */     this.altitude = altitude;
/*     */   }
/*     */ 
/*     */   public int getState() {
/* 186 */     return this.state;
/*     */   }
/*     */ 
/*     */   public void setState(int state) {
/* 190 */     this.state = state;
/*     */   }
/*     */ 
/*     */   public int getAlarm() {
/* 194 */     return this.alarm;
/*     */   }
/*     */ 
/*     */   public void setAlarm(int alarm) {
/* 198 */     this.alarm = alarm;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgCarLocation_0x9202
 * JD-Core Version:    0.6.1
 */