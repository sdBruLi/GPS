/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x0200_item extends JT808MsgBody
/*     */ {
/*  10 */   private static final Log log = LogFactory.getLog(JT808MsgBody_0x0200_item.class);
/*     */   private int id;
/*     */   private byte length;
/*     */   private IoBuffer info;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public void praseBody()
/*     */     throws Exception
/*     */   {
/*  21 */     this.id = this.bodyBuffer.getUnsigned();
/*  22 */     this.length = this.bodyBuffer.get();
/*  23 */     this.info = this.bodyBuffer.getSlice(this.bodyBuffer.limit() - 2);
/*  24 */     this.bodyBuffer.rewind();
/*     */   }
/*     */ 
/*     */   public Object getItemInfo() {
/*  28 */     Object obj = null;
/*  29 */     if (this.length > 0) {
/*     */       try {
/*  31 */         switch (this.id) {
/*     */         case 1:
/*  33 */           JT808MsgBody_0x0200_item_mileage itemMileage = new JT808MsgBody_0x0200_item_mileage();
/*  34 */           itemMileage.setBodyBuffer(this.info);
/*  35 */           itemMileage.praseBody();
/*  36 */           obj = itemMileage;
/*  37 */           break;
/*     */         case 2:
/*  39 */           JT808MsgBody_0x0200_item_oilMass itemOilMass = new JT808MsgBody_0x0200_item_oilMass();
/*  40 */           itemOilMass.setBodyBuffer(this.info);
/*  41 */           itemOilMass.praseBody();
/*  42 */           obj = itemOilMass;
/*  43 */           break;
/*     */         case 3:
/*  45 */           JT808MsgBody_0x0200_item_sensorSpeed itemSensorSpeed = new JT808MsgBody_0x0200_item_sensorSpeed();
/*  46 */           itemSensorSpeed.setBodyBuffer(this.info);
/*  47 */           itemSensorSpeed.praseBody();
/*  48 */           obj = itemSensorSpeed;
/*  49 */           break;
/*     */         case 4:
/*  51 */           JT808MsgBody_0x0200_item_alarmId_ack itemAlarmId = new JT808MsgBody_0x0200_item_alarmId_ack();
/*  52 */           itemAlarmId.setBodyBuffer(this.info);
/*  53 */           itemAlarmId.praseBody();
/*  54 */           obj = itemAlarmId;
/*  55 */           break;
/*     */         case 17:
/*  57 */           JT808MsgBody_0x0200_item_overspeed_alarm itemOverSpeedAlarm = new JT808MsgBody_0x0200_item_overspeed_alarm();
/*  58 */           itemOverSpeedAlarm.setBodyBuffer(this.info);
/*  59 */           itemOverSpeedAlarm.praseBody();
/*  60 */           obj = itemOverSpeedAlarm;
/*  61 */           break;
/*     */         case 18:
/*  63 */           JT808MsgBody_0x0200_item_in_out_alarm itemInOutAlarm = new JT808MsgBody_0x0200_item_in_out_alarm();
/*  64 */           itemInOutAlarm.setBodyBuffer(this.info);
/*  65 */           itemInOutAlarm.praseBody();
/*  66 */           obj = itemInOutAlarm;
/*  67 */           break;
/*     */         case 19:
/*  69 */           JT808MsgBody_0x0200_item_runTime_alarm itemRunTimeAlarm = new JT808MsgBody_0x0200_item_runTime_alarm();
/*  70 */           itemRunTimeAlarm.setBodyBuffer(this.info);
/*  71 */           itemRunTimeAlarm.praseBody();
/*  72 */           obj = itemRunTimeAlarm;
/*  73 */           break;
/*     */         case 20:
/*  75 */           JT808MsgBody_0x0200_item_temperature t1 = new JT808MsgBody_0x0200_item_temperature();
/*  76 */           t1.setBodyBuffer(this.info);
/*  77 */           t1.praseBody();
/*  78 */           obj = t1;
/*  79 */           break;
/*     */         case 21:
/*  81 */           JT808MsgBody_0x0200_item_temperature t2 = new JT808MsgBody_0x0200_item_temperature();
/*  82 */           t2.setBodyBuffer(this.info);
/*  83 */           t2.praseBody();
/*  84 */           obj = t2;
/*  85 */           break;
/*     */         case 228:
/*  87 */           JT808MsgBody_0x0200_item_E4 e = new JT808MsgBody_0x0200_item_E4();
/*  88 */           e.setBodyBuffer(this.info);
/*  89 */           e.praseBody();
/*  90 */           obj = e;
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/*  94 */         log.error("", e);
/*     */       }
/*     */     }
/*     */ 
/*  98 */     return obj;
/*     */   }
/*     */ 
/*     */   public int getId() {
/* 102 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(int id) {
/* 106 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public byte getLength() {
/* 110 */     return this.length;
/*     */   }
/*     */ 
/*     */   public void setLength(byte length) {
/* 114 */     this.length = length;
/*     */   }
/*     */ 
/*     */   public IoBuffer getInfo() {
/* 118 */     return this.info;
/*     */   }
/*     */ 
/*     */   public void setInfo(IoBuffer info) {
/* 122 */     this.info = info;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item
 * JD-Core Version:    0.6.1
 */