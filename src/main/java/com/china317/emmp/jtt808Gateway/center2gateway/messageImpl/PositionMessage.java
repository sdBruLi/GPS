/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_E4;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_alarmId_ack;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_in_out_alarm;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_mileage;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_oilMass;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_overspeed_alarm;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_runTime_alarm;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_sensorSpeed;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_temperature;
/*     */ import com.china317.emmp.jtt808Gateway.server.common.UtilTime;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class PositionMessage extends BaseUpMessage
/*     */ {
/*  29 */   private static final Log log = LogFactory.getLog(PositionMessage.class);
/*     */   private double latitude;
/*     */   private double longitude;
/*     */   private short altitude;
/*     */   private float speed;
/*     */   private short direction;
/*     */   private Date time;
/*     */   private byte emergencyAlarm;
/*     */   private byte overspeedAlarm;
/*     */   private byte fatigueDrivingAlarm;
/*     */   private byte earlyAlarm;
/*     */   private byte gnnsErrorAlarm;
/*     */   private byte gnnsBreakAlarm;
/*     */   private byte gnnsShortAlarm;
/*     */   private byte undervoltageAlarm;
/*     */   private byte powerdownAlarm;
/*     */   private byte screemErrorAlarm;
/*     */   private byte ttsAlarm;
/*     */   private byte cameraAlarm;
/*     */   private byte turnOverSpeedAlarm;
/*     */   private byte hardBrakingAlarm;
/*     */   private byte drivingOvertimeAlarm;
/*     */   private byte packingOvertimeAlarm;
/*     */   private byte enterRegionAlarm;
/*     */   private byte enterLineAlarm;
/*     */   private byte lineTimeAlarm;
/*     */   private byte deviateAlarm;
/*     */   private byte vssAlarm;
/*     */   private byte oilAlarm;
/*     */   private byte stolenAlarm;
/*     */   private byte fireAlarm;
/*     */   private byte shiftAlarm;
/*     */   private byte turneOverAlarm;
/*     */   private Byte accStatus;
/*     */   private Byte locationStatus;
/*     */   private Byte latitudeStatus;
/*     */   private Byte longitudeStatus;
/*     */   private Byte runingStatus;
/*     */   private Byte encipherStatus;
/*     */   private Byte gpsStatus;
/*     */   private Byte oilStatus;
/*     */   private Byte powerStatus;
/*     */   private Byte doorStatus;
/*     */   private double mileage;
/*     */   private float oilMass;
/*     */   private float sensorSpeed;
/*     */   private short alarmId;
/*     */   private Byte overspeedRegionType;
/*     */   private int overspeedRegionId;
/*     */   private Byte ioRegionType;
/*     */   private int ioRegionId;
/*     */   private Byte ioRegion;
/*     */   private int drivingTimeRegionId;
/*     */   private short drivingTime;
/*  87 */   private Byte drivingTimeResult = Byte.valueOf((byte)0);
/*     */   private Float carriageTemperature1;
/*     */   private Float carriageTemperature2;
/*     */   private int areaid;
/*     */   private long markid;
/*     */   private byte wingStatus;
/*     */ 
/*     */   public int getAreaid()
/*     */   {
/* 100 */     return this.areaid;
/*     */   }
/*     */ 
/*     */   public void setAreaid(int areaid) {
/* 104 */     this.areaid = areaid;
/*     */   }
/*     */ 
/*     */   public long getMarkid() {
/* 108 */     return this.markid;
/*     */   }
/*     */ 
/*     */   public void setMarkid(long markid) {
/* 112 */     this.markid = markid;
/*     */   }
/*     */ 
/*     */   public PositionMessage() {
/* 116 */     setCommand("0x0200");
/*     */   }
/*     */ 
/*     */   public void unpack(UnitPackJT808 pack)
/*     */   {
/* 121 */     unpackHeadPart(pack);
/*     */     try {
/* 123 */       JT808MsgBody_0x0200 body = (JT808MsgBody_0x0200)pack.getMsgBody();
/* 124 */       unpackBody(body);
/*     */     } catch (Exception e) {
/* 126 */       log.debug("unpack fail ", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void unpackBody(JT808MsgBody_0x0200 body) {
/* 131 */     setLatitude(body.getLatitude() / 1000000.0D);
/* 132 */     setLongitude(body.getLangitude() / 1000000.0D);
/* 133 */     setSpeed(body.getSpeed() / 10.0F);
/* 134 */     setDirection(body.getDirection());
/* 135 */     if ((body.getTime() != null) && (!"".equals(body.getTime()))) {
/* 136 */       setTime(UtilTime.parse2Date(body.getTime(), "yyMMddHHmmss"));
/*     */     }
/*     */ 
/* 139 */     if (body.getItems() != null) {
/* 140 */       for (JT808MsgBody_0x0200_item item : body.getItems()) {
/* 141 */         switch (item.getId()) {
/*     */         case 1:
/* 143 */           JT808MsgBody_0x0200_item_mileage itemMileage = (JT808MsgBody_0x0200_item_mileage)item.getItemInfo();
/* 144 */           if (itemMileage != null) {
/* 145 */             this.mileage = (itemMileage.getMileage() / 10.0D);
/*     */           }
/* 147 */           break;
/*     */         case 2:
/* 149 */           JT808MsgBody_0x0200_item_oilMass itemOilMass = (JT808MsgBody_0x0200_item_oilMass)item.getItemInfo();
/* 150 */           if (itemOilMass != null) {
/* 151 */             this.oilMass = (itemOilMass.getOilMass() / 10.0F);
/*     */           }
/* 153 */           break;
/*     */         case 3:
/* 155 */           JT808MsgBody_0x0200_item_sensorSpeed itemSensorSpeed = (JT808MsgBody_0x0200_item_sensorSpeed)item.getItemInfo();
/* 156 */           if (itemSensorSpeed != null) {
/* 157 */             this.sensorSpeed = (itemSensorSpeed.getSensorSpeed() / 10.0F);
/*     */           }
/* 159 */           break;
/*     */         case 4:
/* 161 */           JT808MsgBody_0x0200_item_alarmId_ack itemAlarmId = (JT808MsgBody_0x0200_item_alarmId_ack)item.getItemInfo();
/* 162 */           if (itemAlarmId != null) {
/* 163 */             this.alarmId = itemAlarmId.getAlarmId();
/*     */           }
/* 165 */           break;
/*     */         case 17:
/* 167 */           JT808MsgBody_0x0200_item_overspeed_alarm itemOverSpeedAlarm = (JT808MsgBody_0x0200_item_overspeed_alarm)item.getItemInfo();
/* 168 */           if (itemOverSpeedAlarm != null) {
/* 169 */             this.overspeedRegionType = Byte.valueOf(itemOverSpeedAlarm.getPositonType());
/* 170 */             this.overspeedRegionId = itemOverSpeedAlarm.getRegionId();
/*     */           }
/* 172 */           break;
/*     */         case 18:
/* 174 */           JT808MsgBody_0x0200_item_in_out_alarm itemInOutAlarm = (JT808MsgBody_0x0200_item_in_out_alarm)item.getItemInfo();
/* 175 */           if (itemInOutAlarm != null) {
/* 176 */             this.ioRegionType = Byte.valueOf(itemInOutAlarm.getPositonType());
/* 177 */             this.ioRegionId = itemInOutAlarm.getRegionId();
/* 178 */             this.ioRegion = Byte.valueOf(itemInOutAlarm.getDirection());
/*     */           }
/* 180 */           break;
/*     */         case 19:
/* 182 */           JT808MsgBody_0x0200_item_runTime_alarm itemRunTimeAlarm = (JT808MsgBody_0x0200_item_runTime_alarm)item.getItemInfo();
/* 183 */           if (itemRunTimeAlarm != null) {
/* 184 */             this.drivingTimeRegionId = itemRunTimeAlarm.getRegionId();
/* 185 */             this.drivingTime = itemRunTimeAlarm.getRunTime();
/* 186 */             this.drivingTimeResult = Byte.valueOf(itemRunTimeAlarm.getResult());
/*     */           }
/* 188 */           break;
/*     */         case 20:
/* 190 */           JT808MsgBody_0x0200_item_temperature t1 = (JT808MsgBody_0x0200_item_temperature)item.getItemInfo();
/* 191 */           if (t1 != null) {
/* 192 */             if (t1.getSign() == 255)
/* 193 */               this.carriageTemperature1 = Float.valueOf(0.0F - t1.getTemperature() / 100.0F);
/*     */             else {
/* 195 */               this.carriageTemperature1 = Float.valueOf(t1.getTemperature() / 100.0F);
/*     */             }
/*     */           }
/*     */ 
/* 199 */           break;
/*     */         case 21:
/* 201 */           JT808MsgBody_0x0200_item_temperature t2 = (JT808MsgBody_0x0200_item_temperature)item.getItemInfo();
/* 202 */           if (t2 != null) {
/* 203 */             if (t2.getSign() == 255)
/* 204 */               this.carriageTemperature2 = Float.valueOf(0.0F - t2.getTemperature() / 100.0F);
/*     */             else {
/* 206 */               this.carriageTemperature2 = Float.valueOf(t2.getTemperature() / 100.0F);
/*     */             }
/*     */           }
/*     */ 
/* 210 */           break;
/*     */         case 228:
/* 212 */           JT808MsgBody_0x0200_item_E4 e4 = (JT808MsgBody_0x0200_item_E4)item.getItemInfo();
/* 213 */           this.areaid = e4.getAreaid();
/* 214 */           this.markid = e4.getMarkid();
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 220 */     int alertSign = body.getAlertSign();
/* 221 */     if ((alertSign & 0x1) == 1) {
/* 222 */       setEmergencyAlarm((byte)1);
/*     */     }
/* 224 */     if ((alertSign >> 1 & 0x1) == 1) {
/* 225 */       setOverspeedAlarm((byte)1);
/*     */     }
/*     */ 
/* 229 */     if ((alertSign >> 2 & 0x1) == 1) {
/* 230 */       setFatigueDrivingAlarm((byte)1);
/*     */     }
/* 232 */     if ((alertSign >> 3 & 0x1) == 1) {
/* 233 */       setEarlyAlarm((byte)1);
/*     */     }
/* 235 */     if ((alertSign >> 4 & 0x1) == 1) {
/* 236 */       setGnnsErrorAlarm((byte)1);
/*     */     }
/* 238 */     if ((alertSign >> 5 & 0x1) == 1) {
/* 239 */       setGnnsBreakAlarm((byte)1);
/*     */     }
/* 241 */     if ((alertSign >> 6 & 0x1) == 1) {
/* 242 */       setGnnsShortAlarm((byte)1);
/*     */     }
/* 244 */     if ((alertSign >> 7 & 0x1) == 1) {
/* 245 */       setUndervoltageAlarm((byte)1);
/*     */     }
/* 247 */     if ((alertSign >> 8 & 0x1) == 1) {
/* 248 */       setPowerdownAlarm((byte)1);
/*     */     }
/* 250 */     if ((alertSign >> 9 & 0x1) == 1) {
/* 251 */       setScreemErrorAlarm((byte)1);
/*     */     }
/* 253 */     if ((alertSign >> 10 & 0x1) == 1) {
/* 254 */       setTtsAlarm((byte)1);
/*     */     }
/* 256 */     if ((alertSign >> 11 & 0x1) == 1) {
/* 257 */       setCameraAlarm((byte)1);
/*     */     }
/* 259 */     if ((alertSign >> 12 & 0x1) == 1) {
/* 260 */       setTurnOverSpeedAlarm(Byte.valueOf((byte)1));
/*     */     }
/* 262 */     if ((alertSign >> 13 & 0x1) == 1) {
/* 263 */       setHardBrakingAlarm(Byte.valueOf((byte)1));
/*     */     }
/* 265 */     if ((alertSign >> 18 & 0x1) == 1) {
/* 266 */       setDrivingOvertimeAlarm((byte)1);
/*     */     }
/* 268 */     if ((alertSign >> 19 & 0x1) == 1) {
/* 269 */       setPackingOvertimeAlarm((byte)1);
/*     */     }
/*     */ 
/* 272 */     if ((alertSign >> 20 & 0x1) == 1) {
/* 273 */       if (this.ioRegion.byteValue() == 0)
/* 274 */         this.enterRegionAlarm = 1;
/*     */       else {
/* 276 */         this.enterRegionAlarm = 2;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 281 */     if ((alertSign >> 21 & 0x1) == 1) {
/* 282 */       if (this.ioRegion.byteValue() == 0)
/* 283 */         this.enterLineAlarm = 1;
/*     */       else {
/* 285 */         this.enterLineAlarm = 2;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 290 */     if ((alertSign >> 22 & 0x1) == 1) {
/* 291 */       if (this.drivingTimeResult.byteValue() == 0)
/* 292 */         this.lineTimeAlarm = 1;
/*     */       else {
/* 294 */         this.lineTimeAlarm = 2;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 299 */     if ((alertSign >> 23 & 0x1) == 1) {
/* 300 */       setDeviateAlarm((byte)1);
/*     */     }
/* 302 */     if ((alertSign >> 24 & 0x1) == 1) {
/* 303 */       setVssAlarm((byte)1);
/*     */     }
/* 305 */     if ((alertSign >> 25 & 0x1) == 1) {
/* 306 */       setOilAlarm((byte)1);
/*     */     }
/* 308 */     if ((alertSign >> 26 & 0x1) == 1) {
/* 309 */       setStolenAlarm((byte)1);
/*     */     }
/* 311 */     if ((alertSign >> 27 & 0x1) == 1) {
/* 312 */       setFireAlarm((byte)1);
/*     */     }
/* 314 */     if ((alertSign >> 28 & 0x1) == 1) {
/* 315 */       setShiftAlarm((byte)1);
/*     */     }
/* 317 */     if ((alertSign >> 29 & 0x1) == 1) {
/* 318 */       setTurneOverAlarm((byte)1);
/*     */     }
/*     */ 
/* 322 */     int status = body.getStatus();
/* 323 */     setAccStatus(Byte.valueOf((byte)(status & 0x1)));
/* 324 */     setLocationStatus(Byte.valueOf((byte)(status >> 1 & 0x1)));
/* 325 */     setLatitudeStatus(Byte.valueOf((byte)(status >> 2 & 0x1)));
/* 326 */     setLongitudeStatus(Byte.valueOf((byte)(status >> 3 & 0x1)));
/* 327 */     setRuningStatus(Byte.valueOf((byte)(status >> 4 & 0x1)));
/* 328 */     setEncipherStatus(Byte.valueOf((byte)(status >> 5 & 0x1)));
/* 329 */     setGpsStatus(Byte.valueOf((byte)(status >> 6 & 0x1)));
/* 330 */     setOilStatus(Byte.valueOf((byte)(status >> 10 & 0x1)));
/* 331 */     setPowerStatus(Byte.valueOf((byte)(status >> 11 & 0x1)));
/* 332 */     setDoorStatus(Byte.valueOf((byte)(status >> 12 & 0x1)));
/*     */ 
/* 334 */     setWingStatus((byte)(status >> 28 & 0x3));
/*     */   }
/*     */ 
/*     */   public Byte getGpsStatus() {
/* 338 */     return this.gpsStatus;
/*     */   }
/*     */ 
/*     */   public void setGpsStatus(Byte gpsStatus) {
/* 342 */     this.gpsStatus = gpsStatus;
/*     */   }
/*     */ 
/*     */   public double getLatitude() {
/* 346 */     return this.latitude;
/*     */   }
/*     */ 
/*     */   public void setLatitude(double latitude) {
/* 350 */     this.latitude = latitude;
/*     */   }
/*     */ 
/*     */   public double getLongitude() {
/* 354 */     return this.longitude;
/*     */   }
/*     */ 
/*     */   public void setLongitude(double longitude) {
/* 358 */     this.longitude = longitude;
/*     */   }
/*     */ 
/*     */   public short getAltitude() {
/* 362 */     return this.altitude;
/*     */   }
/*     */ 
/*     */   public void setAltitude(short altitude) {
/* 366 */     this.altitude = altitude;
/*     */   }
/*     */ 
/*     */   public float getSpeed() {
/* 370 */     return this.speed;
/*     */   }
/*     */ 
/*     */   public void setSpeed(float speed) {
/* 374 */     this.speed = speed;
/*     */   }
/*     */ 
/*     */   public short getDirection() {
/* 378 */     return this.direction;
/*     */   }
/*     */ 
/*     */   public void setDirection(short direction) {
/* 382 */     this.direction = direction;
/*     */   }
/*     */ 
/*     */   public Date getTime() {
/* 386 */     return this.time;
/*     */   }
/*     */ 
/*     */   public void setTime(Date time) {
/* 390 */     this.time = time;
/*     */   }
/*     */ 
/*     */   public byte getEmergencyAlarm() {
/* 394 */     return this.emergencyAlarm;
/*     */   }
/*     */ 
/*     */   public void setEmergencyAlarm(byte emergencyAlarm) {
/* 398 */     this.emergencyAlarm = emergencyAlarm;
/*     */   }
/*     */ 
/*     */   public byte getOverspeedAlarm() {
/* 402 */     return this.overspeedAlarm;
/*     */   }
/*     */ 
/*     */   public void setOverspeedAlarm(byte overspeedAlarm) {
/* 406 */     this.overspeedAlarm = overspeedAlarm;
/*     */   }
/*     */ 
/*     */   public byte getFatigueDrivingAlarm() {
/* 410 */     return this.fatigueDrivingAlarm;
/*     */   }
/*     */ 
/*     */   public void setFatigueDrivingAlarm(byte fatigueDrivingAlarm) {
/* 414 */     this.fatigueDrivingAlarm = fatigueDrivingAlarm;
/*     */   }
/*     */ 
/*     */   public byte getEarlyAlarm() {
/* 418 */     return this.earlyAlarm;
/*     */   }
/*     */ 
/*     */   public void setEarlyAlarm(byte earlyAlarm) {
/* 422 */     this.earlyAlarm = earlyAlarm;
/*     */   }
/*     */ 
/*     */   public byte getGnnsErrorAlarm() {
/* 426 */     return this.gnnsErrorAlarm;
/*     */   }
/*     */ 
/*     */   public void setGnnsErrorAlarm(byte gnnsErrorAlarm) {
/* 430 */     this.gnnsErrorAlarm = gnnsErrorAlarm;
/*     */   }
/*     */ 
/*     */   public byte getGnnsBreakAlarm() {
/* 434 */     return this.gnnsBreakAlarm;
/*     */   }
/*     */ 
/*     */   public void setGnnsBreakAlarm(byte gnnsBreakAlarm) {
/* 438 */     this.gnnsBreakAlarm = gnnsBreakAlarm;
/*     */   }
/*     */ 
/*     */   public byte getGnnsShortAlarm() {
/* 442 */     return this.gnnsShortAlarm;
/*     */   }
/*     */ 
/*     */   public void setGnnsShortAlarm(byte gnnsShortAlarm) {
/* 446 */     this.gnnsShortAlarm = gnnsShortAlarm;
/*     */   }
/*     */ 
/*     */   public byte getUndervoltageAlarm() {
/* 450 */     return this.undervoltageAlarm;
/*     */   }
/*     */ 
/*     */   public void setUndervoltageAlarm(byte undervoltageAlarm) {
/* 454 */     this.undervoltageAlarm = undervoltageAlarm;
/*     */   }
/*     */ 
/*     */   public byte getPowerdownAlarm() {
/* 458 */     return this.powerdownAlarm;
/*     */   }
/*     */ 
/*     */   public void setPowerdownAlarm(byte powerdownAlarm) {
/* 462 */     this.powerdownAlarm = powerdownAlarm;
/*     */   }
/*     */ 
/*     */   public byte getScreemErrorAlarm() {
/* 466 */     return this.screemErrorAlarm;
/*     */   }
/*     */ 
/*     */   public void setScreemErrorAlarm(byte screemErrorAlarm) {
/* 470 */     this.screemErrorAlarm = screemErrorAlarm;
/*     */   }
/*     */ 
/*     */   public byte getTtsAlarm() {
/* 474 */     return this.ttsAlarm;
/*     */   }
/*     */ 
/*     */   public void setTtsAlarm(byte ttsAlarm) {
/* 478 */     this.ttsAlarm = ttsAlarm;
/*     */   }
/*     */ 
/*     */   public byte getCameraAlarm() {
/* 482 */     return this.cameraAlarm;
/*     */   }
/*     */ 
/*     */   public void setCameraAlarm(byte cameraAlarm) {
/* 486 */     this.cameraAlarm = cameraAlarm;
/*     */   }
/*     */ 
/*     */   public byte getDrivingOvertimeAlarm() {
/* 490 */     return this.drivingOvertimeAlarm;
/*     */   }
/*     */ 
/*     */   public void setDrivingOvertimeAlarm(byte drivingOvertimeAlarm) {
/* 494 */     this.drivingOvertimeAlarm = drivingOvertimeAlarm;
/*     */   }
/*     */ 
/*     */   public byte getPackingOvertimeAlarm() {
/* 498 */     return this.packingOvertimeAlarm;
/*     */   }
/*     */ 
/*     */   public void setPackingOvertimeAlarm(byte packingOvertimeAlarm) {
/* 502 */     this.packingOvertimeAlarm = packingOvertimeAlarm;
/*     */   }
/*     */ 
/*     */   public byte getEnterRegionAlarm() {
/* 506 */     return this.enterRegionAlarm;
/*     */   }
/*     */ 
/*     */   public void setEnterRegionAlarm(byte enterRegionAlarm) {
/* 510 */     this.enterRegionAlarm = enterRegionAlarm;
/*     */   }
/*     */ 
/*     */   public byte getEnterLineAlarm() {
/* 514 */     return this.enterLineAlarm;
/*     */   }
/*     */ 
/*     */   public void setEnterLineAlarm(byte enterLineAlarm) {
/* 518 */     this.enterLineAlarm = enterLineAlarm;
/*     */   }
/*     */ 
/*     */   public byte getLineTimeAlarm() {
/* 522 */     return this.lineTimeAlarm;
/*     */   }
/*     */ 
/*     */   public void setLineTimeAlarm(byte lineTimeAlarm) {
/* 526 */     this.lineTimeAlarm = lineTimeAlarm;
/*     */   }
/*     */ 
/*     */   public byte getDeviateAlarm() {
/* 530 */     return this.deviateAlarm;
/*     */   }
/*     */ 
/*     */   public void setDeviateAlarm(byte deviateAlarm) {
/* 534 */     this.deviateAlarm = deviateAlarm;
/*     */   }
/*     */ 
/*     */   public byte getVssAlarm() {
/* 538 */     return this.vssAlarm;
/*     */   }
/*     */ 
/*     */   public void setVssAlarm(byte vssAlarm) {
/* 542 */     this.vssAlarm = vssAlarm;
/*     */   }
/*     */ 
/*     */   public byte getOilAlarm() {
/* 546 */     return this.oilAlarm;
/*     */   }
/*     */ 
/*     */   public void setOilAlarm(byte oilAlarm) {
/* 550 */     this.oilAlarm = oilAlarm;
/*     */   }
/*     */ 
/*     */   public byte getStolenAlarm() {
/* 554 */     return this.stolenAlarm;
/*     */   }
/*     */ 
/*     */   public void setStolenAlarm(byte stolenAlarm) {
/* 558 */     this.stolenAlarm = stolenAlarm;
/*     */   }
/*     */ 
/*     */   public byte getFireAlarm() {
/* 562 */     return this.fireAlarm;
/*     */   }
/*     */ 
/*     */   public void setFireAlarm(byte fireAlarm) {
/* 566 */     this.fireAlarm = fireAlarm;
/*     */   }
/*     */ 
/*     */   public byte getShiftAlarm() {
/* 570 */     return this.shiftAlarm;
/*     */   }
/*     */ 
/*     */   public void setShiftAlarm(byte shiftAlarm) {
/* 574 */     this.shiftAlarm = shiftAlarm;
/*     */   }
/*     */ 
/*     */   public byte getTurneOverAlarm() {
/* 578 */     return this.turneOverAlarm;
/*     */   }
/*     */ 
/*     */   public void setTurneOverAlarm(byte turneOverAlarm) {
/* 582 */     this.turneOverAlarm = turneOverAlarm;
/*     */   }
/*     */ 
/*     */   public Byte getAccStatus() {
/* 586 */     return this.accStatus;
/*     */   }
/*     */ 
/*     */   public void setAccStatus(Byte accStatus) {
/* 590 */     this.accStatus = accStatus;
/*     */   }
/*     */ 
/*     */   public Byte getLocationStatus() {
/* 594 */     return this.locationStatus;
/*     */   }
/*     */ 
/*     */   public void setLocationStatus(Byte locationStatus) {
/* 598 */     this.locationStatus = locationStatus;
/*     */   }
/*     */ 
/*     */   public Byte getLatitudeStatus() {
/* 602 */     return this.latitudeStatus;
/*     */   }
/*     */ 
/*     */   public void setLatitudeStatus(Byte latitudeStatus) {
/* 606 */     this.latitudeStatus = latitudeStatus;
/*     */   }
/*     */ 
/*     */   public Byte getLongitudeStatus() {
/* 610 */     return this.longitudeStatus;
/*     */   }
/*     */ 
/*     */   public void setLongitudeStatus(Byte longitudeStatus) {
/* 614 */     this.longitudeStatus = longitudeStatus;
/*     */   }
/*     */ 
/*     */   public Byte getRuningStatus() {
/* 618 */     return this.runingStatus;
/*     */   }
/*     */ 
/*     */   public void setRuningStatus(Byte runingStatus) {
/* 622 */     this.runingStatus = runingStatus;
/*     */   }
/*     */ 
/*     */   public Byte getEncipherStatus() {
/* 626 */     return this.encipherStatus;
/*     */   }
/*     */ 
/*     */   public void setEncipherStatus(Byte encipherStatus) {
/* 630 */     this.encipherStatus = encipherStatus;
/*     */   }
/*     */ 
/*     */   public Byte getOilStatus() {
/* 634 */     return this.oilStatus;
/*     */   }
/*     */ 
/*     */   public void setOilStatus(Byte oilStatus) {
/* 638 */     this.oilStatus = oilStatus;
/*     */   }
/*     */ 
/*     */   public Byte getPowerStatus() {
/* 642 */     return this.powerStatus;
/*     */   }
/*     */ 
/*     */   public void setPowerStatus(Byte powerStatus) {
/* 646 */     this.powerStatus = powerStatus;
/*     */   }
/*     */ 
/*     */   public Byte getDoorStatus() {
/* 650 */     return this.doorStatus;
/*     */   }
/*     */ 
/*     */   public void setDoorStatus(Byte doorStatus) {
/* 654 */     this.doorStatus = doorStatus;
/*     */   }
/*     */ 
/*     */   public double getMileage() {
/* 658 */     return this.mileage;
/*     */   }
/*     */ 
/*     */   public void setMileage(double mileage) {
/* 662 */     this.mileage = mileage;
/*     */   }
/*     */ 
/*     */   public float getOilMass() {
/* 666 */     return this.oilMass;
/*     */   }
/*     */ 
/*     */   public void setOilMass(float oilMass) {
/* 670 */     this.oilMass = oilMass;
/*     */   }
/*     */ 
/*     */   public float getSensorSpeed() {
/* 674 */     return this.sensorSpeed;
/*     */   }
/*     */ 
/*     */   public void setSensorSpeed(float sensorSpeed) {
/* 678 */     this.sensorSpeed = sensorSpeed;
/*     */   }
/*     */ 
/*     */   public short getAlarmId() {
/* 682 */     return this.alarmId;
/*     */   }
/*     */ 
/*     */   public void setAlarmId(short alarmId) {
/* 686 */     this.alarmId = alarmId;
/*     */   }
/*     */ 
/*     */   public Byte getOverspeedRegionType() {
/* 690 */     return this.overspeedRegionType;
/*     */   }
/*     */ 
/*     */   public void setOverspeedRegionType(Byte overspeedRegionType) {
/* 694 */     this.overspeedRegionType = overspeedRegionType;
/*     */   }
/*     */ 
/*     */   public int getOverspeedRegionId() {
/* 698 */     return this.overspeedRegionId;
/*     */   }
/*     */ 
/*     */   public void setOverspeedRegionId(int overspeedRegionId) {
/* 702 */     this.overspeedRegionId = overspeedRegionId;
/*     */   }
/*     */ 
/*     */   public Byte getIoRegionType() {
/* 706 */     return this.ioRegionType;
/*     */   }
/*     */ 
/*     */   public void setIoRegionType(Byte ioRegionType) {
/* 710 */     this.ioRegionType = ioRegionType;
/*     */   }
/*     */ 
/*     */   public int getIoRegionId() {
/* 714 */     return this.ioRegionId;
/*     */   }
/*     */ 
/*     */   public void setIoRegionId(int ioRegionId) {
/* 718 */     this.ioRegionId = ioRegionId;
/*     */   }
/*     */ 
/*     */   public Byte getIoRegion() {
/* 722 */     return this.ioRegion;
/*     */   }
/*     */ 
/*     */   public void setIoRegion(Byte ioRegion) {
/* 726 */     this.ioRegion = ioRegion;
/*     */   }
/*     */ 
/*     */   public int getDrivingTimeRegionId() {
/* 730 */     return this.drivingTimeRegionId;
/*     */   }
/*     */ 
/*     */   public void setDrivingTimeRegionId(int drivingTimeRegionId) {
/* 734 */     this.drivingTimeRegionId = drivingTimeRegionId;
/*     */   }
/*     */ 
/*     */   public short getDrivingTime() {
/* 738 */     return this.drivingTime;
/*     */   }
/*     */ 
/*     */   public void setDrivingTime(short drivingTime) {
/* 742 */     this.drivingTime = drivingTime;
/*     */   }
/*     */ 
/*     */   public Byte getDrivingTimeResult() {
/* 746 */     return this.drivingTimeResult;
/*     */   }
/*     */ 
/*     */   public void setDrivingTimeResult(Byte drivingTimeResult) {
/* 750 */     this.drivingTimeResult = drivingTimeResult;
/*     */   }
/*     */ 
/*     */   public Byte getTurnOverSpeedAlarm() {
/* 754 */     return Byte.valueOf(this.turnOverSpeedAlarm);
/*     */   }
/*     */ 
/*     */   public void setTurnOverSpeedAlarm(Byte turnOverSpeedAlarm) {
/* 758 */     this.turnOverSpeedAlarm = turnOverSpeedAlarm.byteValue();
/*     */   }
/*     */ 
/*     */   public Byte getHardBrakingAlarm() {
/* 762 */     return Byte.valueOf(this.hardBrakingAlarm);
/*     */   }
/*     */ 
/*     */   public void setHardBrakingAlarm(Byte hardBrakingAlarm) {
/* 766 */     this.hardBrakingAlarm = hardBrakingAlarm.byteValue();
/*     */   }
/*     */ 
/*     */   public Float getCarriageTemperature1() {
/* 770 */     return this.carriageTemperature1;
/*     */   }
/*     */ 
/*     */   public void setCarriageTemperature1(Float carriageTemperature1) {
/* 774 */     this.carriageTemperature1 = carriageTemperature1;
/*     */   }
/*     */ 
/*     */   public Float getCarriageTemperature2() {
/* 778 */     return this.carriageTemperature2;
/*     */   }
/*     */ 
/*     */   public void setCarriageTemperature2(Float carriageTemperature2) {
/* 782 */     this.carriageTemperature2 = carriageTemperature2;
/*     */   }
/*     */ 
/*     */   public byte getWingStatus() {
/* 786 */     return this.wingStatus;
/*     */   }
/*     */ 
/*     */   public void setWingStatus(byte wingStatus) {
/* 790 */     this.wingStatus = wingStatus;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.PositionMessage
 * JD-Core Version:    0.6.1
 */