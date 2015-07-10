/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x0200 extends JT808MsgBody
/*     */ {
/*     */   private int alertSign;
/*     */   private int status;
/*     */   private int latitude;
/*     */   private int langitude;
/*     */   private short altitude;
/*     */   private short speed;
/*     */   private short direction;
/*  21 */   private String time = "";
/*     */   private List<JT808MsgBody_0x0200_item> items;
/*  23 */   private Log log = LogFactory.getLog(JT808MsgBody_0x0200.class);
/*     */ 
/*     */   public void bulidBody() throws Exception {
/*  26 */     if (!isBuildBody()) {
/*  27 */       this.bodyBuffer = IoBuffer.allocate(28).setAutoExpand(true);
/*  28 */       this.bodyBuffer.putInt(this.alertSign);
/*  29 */       this.bodyBuffer.putInt(this.status);
/*  30 */       this.bodyBuffer.putInt(this.latitude);
/*  31 */       this.bodyBuffer.putInt(this.langitude);
/*  32 */       this.bodyBuffer.putShort(this.altitude);
/*  33 */       this.bodyBuffer.putShort(this.speed);
/*  34 */       this.bodyBuffer.putShort(this.direction);
/*  35 */       this.bodyBuffer.put(ByteUtil.string2BCD(this.time, 6));
/*     */ 
/*  37 */       if ((this.items != null) && (this.items.size() > 0)) {
/*  38 */         for (JT808MsgBody_0x0200_item item : this.items) {
/*  39 */           this.bodyBuffer.put(item.getBodyBuffer().array());
/*     */         }
/*     */       }
/*  42 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*     */     try {
/*  49 */       this.alertSign = this.bodyBuffer.getInt();
/*  50 */       this.status = this.bodyBuffer.getInt();
/*  51 */       this.latitude = this.bodyBuffer.getInt();
/*  52 */       this.langitude = this.bodyBuffer.getInt();
/*  53 */       this.altitude = this.bodyBuffer.getShort();
/*  54 */       this.speed = this.bodyBuffer.getShort();
/*  55 */       this.direction = this.bodyBuffer.getShort();
/*  56 */       byte[] timebytes = new byte[6];
/*  57 */       this.bodyBuffer.get(timebytes);
/*  58 */       this.time = ByteUtil.getHexString(timebytes);
/*     */ 
/*  60 */       int tempLen = 28;
/*  61 */       if (this.bodyBuffer.limit() - tempLen > 0)
/*     */         do {
/*  63 */           int id = this.bodyBuffer.getUnsigned();
/*  64 */           byte length = this.bodyBuffer.get();
/*  65 */           JT808MsgBody_0x0200_item item = new JT808MsgBody_0x0200_item();
/*  66 */           item.setId(id);
/*  67 */           item.setLength(length);
/*  68 */           item.setInfo(this.bodyBuffer.getSlice(length));
/*  69 */           if (this.items == null) {
/*  70 */             this.items = new ArrayList();
/*     */           }
/*  72 */           this.items.add(item);
/*  73 */           tempLen = tempLen + 2 + length;
/*  74 */         }while (this.bodyBuffer.limit() - tempLen > 0);
/*     */     }
/*     */     catch (Exception e) {
/*  77 */       this.bodyBuffer.rewind();
/*  78 */       this.log.error("", e);
/*  79 */       this.log.error("JT808MsgBody_0x0200 error, bodyBuffer datas[" + this.bodyBuffer + "]");
/*     */     }
/*     */ 
/*  82 */     this.bodyBuffer.rewind();
/*     */   }
/*     */   public int getAlertSign() {
/*  85 */     return this.alertSign;
/*     */   }
/*     */ 
/*     */   public void setAlertSign(int alertSign) {
/*  89 */     this.alertSign = alertSign;
/*     */   }
/*     */ 
/*     */   public int getStatus() {
/*  93 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(int status) {
/*  97 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public int getLatitude() {
/* 101 */     return this.latitude;
/*     */   }
/*     */ 
/*     */   public void setLatitude(int latitude) {
/* 105 */     this.latitude = latitude;
/*     */   }
/*     */ 
/*     */   public int getLangitude() {
/* 109 */     return this.langitude;
/*     */   }
/*     */ 
/*     */   public void setLangitude(int langitude) {
/* 113 */     this.langitude = langitude;
/*     */   }
/*     */ 
/*     */   public short getAltitude() {
/* 117 */     return this.altitude;
/*     */   }
/*     */ 
/*     */   public void setAltitude(short altitude) {
/* 121 */     this.altitude = altitude;
/*     */   }
/*     */ 
/*     */   public short getSpeed() {
/* 125 */     return this.speed;
/*     */   }
/*     */ 
/*     */   public void setSpeed(short speed) {
/* 129 */     this.speed = speed;
/*     */   }
/*     */ 
/*     */   public short getDirection() {
/* 133 */     return this.direction;
/*     */   }
/*     */ 
/*     */   public void setDirection(short direction) {
/* 137 */     this.direction = direction;
/*     */   }
/*     */ 
/*     */   public String getTime() {
/* 141 */     return this.time;
/*     */   }
/*     */ 
/*     */   public void setTime(String timeString) {
/* 145 */     this.time = timeString;
/*     */   }
/*     */ 
/*     */   public List<JT808MsgBody_0x0200_item> getItems() {
/* 149 */     return this.items;
/*     */   }
/*     */ 
/*     */   public void setItems(List<JT808MsgBody_0x0200_item> items) {
/* 153 */     this.items = items;
/*     */   }
/*     */ 
/*     */   public boolean isAlarm()
/*     */   {
/* 158 */     if ((this.alertSign & 0x1) == 1) {
/* 159 */       return true;
/*     */     }
/* 161 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200
 * JD-Core Version:    0.6.1
 */