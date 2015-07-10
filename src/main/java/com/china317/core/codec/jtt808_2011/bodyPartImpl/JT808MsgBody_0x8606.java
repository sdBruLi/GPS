/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import java.util.List;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8606 extends JT808MsgBody
/*     */ {
/*     */   private int routeId;
/*     */   private short routeAttribute;
/*  16 */   private String startTime = "";
/*  17 */   private String stopTime = "";
/*     */   private short routeInflexionCount;
/*     */   private List<JT808MsgBody_0x8606_inflexion_item> inflexionList;
/*     */ 
/*     */   public void bulidBody()
/*     */     throws Exception
/*     */   {
/*  23 */     if (!isBuildBody()) {
/*  24 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/*  25 */       this.bodyBuffer.putInt(this.routeId);
/*  26 */       this.bodyBuffer.putShort(this.routeAttribute);
/*  27 */       if ((this.routeAttribute & 0x1) == 1) {
/*  28 */         this.bodyBuffer.put(ByteUtil.string2BCD(this.startTime, 6));
/*  29 */         this.bodyBuffer.put(ByteUtil.string2BCD(this.stopTime, 6));
/*     */       }
/*     */ 
/*  32 */       this.bodyBuffer.putShort(this.routeInflexionCount);
/*  33 */       if (this.inflexionList != null) {
/*  34 */         for (JT808MsgBody_0x8606_inflexion_item item : this.inflexionList) {
/*  35 */           item.bulidBody();
/*  36 */           this.bodyBuffer.put(item.getBodyBuffer());
/*     */         }
/*     */       }
/*  39 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public static UnitPackJT808 createRoutePack(String mobileNum, int routeId, short routeAttribute, String startTime, String stopTime, List<JT808MsgBody_0x8606_inflexion_item> inflexionList)
/*     */     throws Exception
/*     */   {
/*  62 */     UnitPackJT808 pack = new UnitPackJT808(34310);
/*  63 */     pack.setMobileNum(mobileNum);
/*  64 */     JT808MsgBody_0x8606 body = new JT808MsgBody_0x8606();
/*  65 */     body.setRouteId(routeId);
/*  66 */     body.setRouteAttribute(routeAttribute);
/*  67 */     body.setStartTime(startTime);
/*  68 */     body.setStopTime(stopTime);
/*  69 */     if (inflexionList != null) {
/*  70 */       body.setRouteInflexionCount((short)inflexionList.size());
/*  71 */       body.setInflexionList(inflexionList);
/*     */     }
/*  73 */     pack.setMsgBody(body);
/*  74 */     return pack;
/*     */   }
/*     */ 
/*     */   public int getRouteId() {
/*  78 */     return this.routeId;
/*     */   }
/*     */ 
/*     */   public void setRouteId(int routeId) {
/*  82 */     this.routeId = routeId;
/*     */   }
/*     */ 
/*     */   public short getRouteAttribute() {
/*  86 */     return this.routeAttribute;
/*     */   }
/*     */ 
/*     */   public void setRouteAttribute(short routeAttribute) {
/*  90 */     this.routeAttribute = routeAttribute;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/*  94 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime) {
/*  98 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 102 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime) {
/* 106 */     this.stopTime = stopTime;
/*     */   }
/*     */ 
/*     */   public short getRouteInflexionCount() {
/* 110 */     return this.routeInflexionCount;
/*     */   }
/*     */ 
/*     */   public void setRouteInflexionCount(short routeInflexionCount) {
/* 114 */     this.routeInflexionCount = routeInflexionCount;
/*     */   }
/*     */ 
/*     */   public List<JT808MsgBody_0x8606_inflexion_item> getInflexionList() {
/* 118 */     return this.inflexionList;
/*     */   }
/*     */ 
/*     */   public void setInflexionList(List<JT808MsgBody_0x8606_inflexion_item> inflexionList)
/*     */   {
/* 123 */     this.inflexionList = inflexionList;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8606
 * JD-Core Version:    0.6.1
 */