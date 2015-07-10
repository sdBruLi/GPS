/*     */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*     */ 
/*     */ import com.china317.core.codec.jtt808Gateway.DataRow0012;
/*     */ import com.china317.core.codec.jtt808Gateway.GatewayUnitPack;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0012;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808Praser;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ import org.apache.mina.core.service.IoHandlerAdapter;
/*     */ import org.apache.mina.core.service.IoService;
/*     */ import org.apache.mina.core.session.IoSession;
/*     */ 
/*     */ public class GReceiveClientHandler extends IoHandlerAdapter
/*     */ {
/*  18 */   private Log log = LogFactory.getLog(GReceiveClientHandler.class);
/*  19 */   private GReceiveClient gReciveClient = null;
/*     */ 
/*     */   public GReceiveClientHandler(GReceiveClient reciveclient)
/*     */   {
/*  24 */     this.gReciveClient = reciveclient;
/*     */   }
/*     */ 
/*     */   public void sessionOpened(IoSession session)
/*     */   {
/*  30 */     this.log.info("GReceiveClient conneted");
/*     */   }
/*     */ 
/*     */   public void messageReceived(IoSession session, Object message) throws Exception
/*     */   {
/*  35 */     if ((message instanceof GatewayUnitPack))
/*     */       try {
/*  37 */         GatewayUnitPack unit = (GatewayUnitPack)message;
/*  38 */         if (unit.isCRCResult())
/*     */         {
/*  40 */           updStatusOfClient(unit);
/*  41 */           switch (unit.getCMD()) {
/*     */           case 2:
/*  43 */             this.log.debug("received heartbeat from gateway...");
/*  44 */             GatewayUnitPack heartRes = new GatewayUnitPack(32770);
/*  45 */             heartRes.setSequenceNum(unit.getSequenceNum());
/*  46 */             session.write(heartRes);
/*  47 */             break;
/*     */           case 18:
/*  49 */             GatewayUnitPack rtnPack = new GatewayUnitPack(32786);
/*  50 */             rtnPack.setSequenceNum(unit.getSequenceNum());
/*  51 */             session.write(rtnPack);
/*  52 */             break;
/*     */           }
/*     */ 
/*  57 */           this.gReciveClient.reciveMachine.putInWaitingQueue(unit);
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/*  61 */         this.log.error("", e);
/*     */       }
/*     */   }
/*     */ 
/*     */   private void updStatusOfClient(GatewayUnitPack unit)
/*     */   {
/*     */     try
/*     */     {
/*  69 */       this.gReciveClient.updHeartbeatTime();
/*  70 */       switch (unit.getCMD()) {
/*     */       case 18:
/*  72 */         GatewayBody_0x0012 body0012 = (GatewayBody_0x0012)unit.getMsgBody();
/*  73 */         List dataRowList = body0012.getDataRowList();
/*  74 */         Iterator localIterator = dataRowList.iterator();
/*     */         while (true) { DataRow0012 row = (DataRow0012)localIterator.next();
/*  75 */           processDataRow(row);
/*     */ 
/*  74 */           if (!localIterator.hasNext())
/*     */           {
/*  77 */             break;
/*     */           } }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  82 */       this.log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void processDataRow(DataRow0012 row)
/*     */   {
/*     */     try
/*     */     {
/*  91 */       UnitPackJT808 mocPack = UnitPackJT808Praser.prasePacket(row.getRowBuffer());
/*  92 */       mocPack.setSessionId(Long.parseLong(row.getSessionid()));
/*     */ 
/*  98 */       this.gReciveClient.updMobileNum2VehSession(mocPack.getMobileNum(), row.getSessionid(), mocPack.getMsgID());
/*     */ 
/* 103 */       this.gReciveClient.reciveMachine.updMobileNum2GClient(mocPack.getMobileNum(), this.gReciveClient);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 107 */       this.log.error("", e);
/* 108 */       row.getRowBuffer().rewind();
/* 109 */       this.log.error("row buffer [" + row.getRowBuffer().toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void exceptionCaught(IoSession session, Throwable cause) throws Exception
/*     */   {
/* 115 */     this.log.error("", cause.getCause());
/* 116 */     session.close(true);
/* 117 */     session.getService().dispose();
/* 118 */     this.gReciveClient.closeService();
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.GReceiveClientHandler
 * JD-Core Version:    0.6.1
 */