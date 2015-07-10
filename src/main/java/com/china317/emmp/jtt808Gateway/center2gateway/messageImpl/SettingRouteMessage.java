/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8606;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8606_inflexion_item;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SettingRouteMessage extends BaseDownMessage
/*     */ {
/*     */   private int routeId;
/*     */   private RouteAttri routeAttribute;
/*  21 */   private String startTime = "";
/*  22 */   private String stopTime = "";
/*     */   private short routeInflexionCount;
/*     */   private List<RouteInflexionItem> inflexionList;
/*     */ 
/*     */   public SettingRouteMessage(String mobileNum, String messageKey, int routeId, RouteAttri routeAttribute, String startTime, String stopTime, List<RouteInflexionItem> inflexionList)
/*     */   {
/*  44 */     setMobileNum(mobileNum);
/*  45 */     setMessageKey(messageKey);
/*  46 */     setRouteId(routeId);
/*  47 */     setRouteAttribute(routeAttribute);
/*  48 */     setStartTime(startTime);
/*  49 */     setStopTime(stopTime);
/*  50 */     setInflexionList(inflexionList);
/*  51 */     setCommand("0x8606");
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 pack() throws Exception
/*     */   {
/*  56 */     UnitPackJT808 pack = new UnitPackJT808(34310);
/*  57 */     pack.setMobileNum(getMobileNum());
/*  58 */     JT808MsgBody_0x8606 body = new JT808MsgBody_0x8606();
/*  59 */     body.setRouteId(getRouteId());
/*  60 */     body.setRouteAttribute(getRouteAttribute().getAttribute());
/*  61 */     body.setStartTime(getStartTime());
/*  62 */     body.setStopTime(getStopTime());
/*  63 */     if (this.inflexionList != null) {
/*  64 */       List inflexionLists = new ArrayList();
/*  65 */       for (RouteInflexionItem item : this.inflexionList) {
/*  66 */         JT808MsgBody_0x8606_inflexion_item i = new JT808MsgBody_0x8606_inflexion_item();
/*  67 */         i.setInflexionId(item.getInflexionId());
/*  68 */         i.setInflexionLatitude(item.getInflexionLatitude());
/*  69 */         i.setInflexionLongitude(item.getInflexionLongitude());
/*  70 */         i.setMaxSpeed(item.getMaxSpeed());
/*  71 */         i.setOverspeedTime(item.getOverspeedTime());
/*  72 */         i.setRoadAttribute(item.getRoadAttribute().getAttribute());
/*  73 */         i.setRoadId(item.getRoadId());
/*  74 */         i.setRoadRunOverlength(item.getRoadRunOverlength());
/*  75 */         i.setRoadRunShortness(item.getRoadRunShortness());
/*  76 */         i.setRoadWide(item.getRoadWide());
/*     */ 
/*  78 */         inflexionLists.add(i);
/*     */       }
/*  80 */       body.setRouteInflexionCount((short)inflexionLists.size());
/*  81 */       body.setInflexionList(inflexionLists);
/*     */     }
/*  83 */     pack.setMsgBody(body);
/*  84 */     return pack;
/*     */   }
/*     */ 
/*     */   public int getRouteId() {
/*  88 */     return this.routeId;
/*     */   }
/*     */ 
/*     */   public void setRouteId(int routeId)
/*     */   {
/*  93 */     this.routeId = routeId;
/*     */   }
/*     */ 
/*     */   public RouteAttri getRouteAttribute() {
/*  97 */     return this.routeAttribute;
/*     */   }
/*     */ 
/*     */   public void setRouteAttribute(RouteAttri routeAttribute)
/*     */   {
/* 102 */     this.routeAttribute = routeAttribute;
/*     */   }
/*     */ 
/*     */   public String getStartTime() {
/* 106 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(String startTime)
/*     */   {
/* 111 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public String getStopTime() {
/* 115 */     return this.stopTime;
/*     */   }
/*     */ 
/*     */   public void setStopTime(String stopTime)
/*     */   {
/* 120 */     this.stopTime = stopTime;
/*     */   }
/*     */ 
/*     */   public short getRouteInflexionCount() {
/* 124 */     return this.routeInflexionCount;
/*     */   }
/*     */ 
/*     */   public void setRouteInflexionCount(short routeInflexionCount)
/*     */   {
/* 129 */     this.routeInflexionCount = routeInflexionCount;
/*     */   }
/*     */ 
/*     */   public List<RouteInflexionItem> getInflexionList() {
/* 133 */     return this.inflexionList;
/*     */   }
/*     */ 
/*     */   public void setInflexionList(List<RouteInflexionItem> inflexionList)
/*     */   {
/* 138 */     this.inflexionList = inflexionList;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SettingRouteMessage
 * JD-Core Version:    0.6.1
 */