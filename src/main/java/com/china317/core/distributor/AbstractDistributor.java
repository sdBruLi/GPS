/*     */ package com.china317.core.distributor;
/*     */ 
/*     */ import com.china317.core.base.AbstractDataPacket;
/*     */ import com.china317.core.processor.AbstractProcessor;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public abstract class AbstractDistributor
/*     */ {
/*  18 */   private static final Log log = LogFactory.getLog(AbstractDistributor.class);
/*     */   private Map<String, ProcessorWrapper> map;
/*     */   private Object mapLock;
/*     */ 
/*     */   public AbstractDistributor()
/*     */   {
/*  26 */     this.map = new HashMap();
/*  27 */     this.mapLock = new Object();
/*     */   }
/*     */ 
/*     */   public abstract boolean isSessionAuthorized(long paramLong);
/*     */ 
/*     */   public boolean registerProcessor(String processorName, AbstractProcessor processor, SessionAuthorizationStatus sessionAuthorizationStatus, String[] acceptCommands)
/*     */   {
/*  47 */     if (processorName == null) {
/*  48 */       log.warn("error param, processorName is null");
/*  49 */       return false;
/*     */     }
/*  51 */     if (processor == null) {
/*  52 */       log.warn("error param,processor is null");
/*  53 */       return false;
/*     */     }
/*  55 */     if (sessionAuthorizationStatus == null) {
/*  56 */       log.warn("error param ,sessionAuthorizationStatus is null");
/*  57 */       return false;
/*     */     }
/*  59 */     if (acceptCommands == null) {
/*  60 */       log.warn("error param,acceptCommands is null");
/*  61 */       return false;
/*     */     }
/*  63 */     if (acceptCommands.length <= 0) {
/*  64 */       log.warn("error param,acceptCommands is empty");
/*  65 */       return false;
/*     */     }
/*  67 */     if (this.map.containsKey(processorName)) {
/*  68 */       log.warn("processorName '" + processorName + "'  is already registered");
/*  69 */       return false;
/*     */     }
/*  71 */     synchronized (this.mapLock) {
/*  72 */       processor.setName(processorName);
/*  73 */       processor.startup();
/*  74 */       this.map.put(processorName, new ProcessorWrapper(processorName, processor, sessionAuthorizationStatus, acceptCommands));
/*     */     }
/*     */ 
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */   public AbstractProcessor unregisterProcessor(String name)
/*     */   {
/*  86 */     ProcessorWrapper processorWrapper = null;
/*  87 */     synchronized (this.mapLock) {
/*  88 */       processorWrapper = (ProcessorWrapper)this.map.get(name);
/*     */     }
/*  90 */     if (processorWrapper == null) {
/*  91 */       return null;
/*     */     }
/*  93 */     return processorWrapper.processor;
/*     */   }
/*     */ 
/*     */   public void clearAllProcessor()
/*     */   {
/*  98 */     Iterator iterator = this.map.values().iterator();
/*  99 */     while (iterator.hasNext()) {
/* 100 */       ProcessorWrapper processorWrapper = (ProcessorWrapper)iterator.next();
/* 101 */       processorWrapper.getProcessor().shutdown();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void receiveDataPacket(AbstractDataPacket dataPacket)
/*     */   {
/* 109 */     Iterator iterator = this.map.values().iterator();
/* 110 */     while (iterator.hasNext()) {
/* 111 */       ProcessorWrapper processorWrapper = (ProcessorWrapper)iterator.next();
/* 112 */       if (processorWrapper.isDataPacketAcceptable(dataPacket))
/* 113 */         processorWrapper.getProcessor().putInWaitingQueue(dataPacket);  } 
/*     */   }
/*     */   private class ProcessorWrapper { private String processorName;
/*     */     private AbstractProcessor processor;
/*     */     private SessionAuthorizationStatus sessionAuthorizationStatus;
/*     */     private String[] acceptCommands;
/*     */ 
/* 123 */     ProcessorWrapper(String processorName, AbstractProcessor processor, SessionAuthorizationStatus sessionAuthorizationStatus, String[] acceptCommands) { this.processorName = processorName;
/* 124 */       this.processor = processor;
/* 125 */       this.sessionAuthorizationStatus = sessionAuthorizationStatus;
/* 126 */       this.acceptCommands = acceptCommands; }
/*     */ 
/*     */     String getProcessorName() {
/* 129 */       return this.processorName;
/*     */     }
/*     */     AbstractProcessor getProcessor() {
/* 132 */       return this.processor;
/*     */     }
/*     */     SessionAuthorizationStatus getSessionAuthorizationStatus() {
/* 135 */       return this.sessionAuthorizationStatus;
/*     */     }
/*     */     String[] getAcceptCommands() {
/* 138 */       return this.acceptCommands;
/*     */     }
/*     */ 
/*     */     boolean isDataPacketAcceptable(AbstractDataPacket dataPacket) {
/* 142 */       boolean sessionAuthorizationStateAcceptable = false;
/* 143 */       if (this.sessionAuthorizationStatus == SessionAuthorizationStatus.Both_Session)
/* 144 */         sessionAuthorizationStateAcceptable = true;
/* 145 */       else if (this.sessionAuthorizationStatus == SessionAuthorizationStatus.Authorized_Session) {
/* 146 */         if (AbstractDistributor.this.isSessionAuthorized(dataPacket.getSessionId()))
/* 147 */           sessionAuthorizationStateAcceptable = true;
/*     */       }
/* 149 */       else if ((this.sessionAuthorizationStatus == SessionAuthorizationStatus.Unauthorized_Session) && 
/* 150 */         (!AbstractDistributor.this.isSessionAuthorized(dataPacket.getSessionId()))) {
/* 151 */         sessionAuthorizationStateAcceptable = true;
/*     */       }
/*     */ 
/* 155 */       if (!sessionAuthorizationStateAcceptable) {
/* 156 */         return false;
/*     */       }
/* 158 */       boolean commandAcceptable = false;
/* 159 */       for (String acceptCommand : getAcceptCommands()) {
/* 160 */         if (acceptCommand.equals(dataPacket.getCommand())) {
/* 161 */           commandAcceptable = true;
/* 162 */           break;
/*     */         }
/*     */       }
/* 165 */       boolean acceptable = (sessionAuthorizationStateAcceptable) && (commandAcceptable);
/* 166 */       return acceptable;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.distributor.AbstractDistributor
 * JD-Core Version:    0.6.1
 */