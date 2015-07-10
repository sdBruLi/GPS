/*     */ package com.china317.core.processor;
/*     */ 
/*     */ import com.china317.core.base.DataPacket;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public abstract class AbstractProcessor<T extends DataPacket>
/*     */ {
/*  22 */   private static final Log log = LogFactory.getLog(AbstractProcessor.class);
/*     */   private String name;
/*     */   private static final int Default_QueueCapacity = 10000;
/*     */   private int queueCapacity;
/*     */   private LinkedBlockingQueue<T> queue;
/*     */   private Object processThreadLock;
/*     */   private Thread processThread;
/*     */   private boolean processThreadRunning;
/*     */   private boolean processThreadWaiting;
/*     */   private static final int Default_OverflowQueueCapacity = 100;
/*     */   private int overflowQueueCapacity;
/*     */   private LinkedBlockingQueue<T> overflowQueue;
/*     */   private Object overflowProcessThreadLock;
/*     */   private Thread overflowProcessThread;
/*     */   private boolean overflowProcessThreadRunning;
/*     */   private boolean overflowProcessThreadWaiting;
/*     */   private Set<String> uniqueIndexSet;
/*     */   private int processCapacity;
/*     */   private static final int Default_ProcessCapacity = 100;
/*     */ 
/*     */   public String getName()
/*     */   {
/*  83 */     if ((this.name == null) || (this.name.trim().equals(""))) {
/*  84 */       return "unknown";
/*     */     }
/*  86 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  97 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public int getQueueCapacity()
/*     */   {
/* 105 */     return this.queueCapacity;
/*     */   }
/*     */ 
/*     */   public int getProcessCapacity()
/*     */   {
/* 113 */     return this.processCapacity;
/*     */   }
/*     */ 
/*     */   public AbstractProcessor()
/*     */   {
/* 121 */     this(10000, 100, 100);
/*     */   }
/*     */ 
/*     */   public AbstractProcessor(int queueCapacity, int processCapacity, int overflowQueueCapacity)
/*     */   {
/* 131 */     this.queueCapacity = queueCapacity;
/* 132 */     this.processCapacity = processCapacity;
/* 133 */     this.overflowQueueCapacity = overflowQueueCapacity;
/* 134 */     this.queue = new LinkedBlockingQueue(this.queueCapacity);
/* 135 */     this.overflowQueue = new LinkedBlockingQueue(this.queueCapacity);
/* 136 */     this.processThreadLock = new Object();
/* 137 */     this.overflowProcessThreadLock = new Object();
/* 138 */     this.uniqueIndexSet = Collections.synchronizedSet(new HashSet());
/* 139 */     this.processThreadRunning = false;
/* 140 */     this.processThreadWaiting = false;
/* 141 */     this.overflowProcessThreadRunning = false;
/* 142 */     this.overflowProcessThreadWaiting = false;
/*     */   }
/*     */ 
/*     */   public void startup()
/*     */   {
/* 150 */     if (!this.processThreadRunning) {
/* 151 */       this.processThreadRunning = true;
/* 152 */       log.warn("start processor[name=" + getName() + "] process thread...");
/* 153 */       this.processThread = new Thread() {
/*     */         public void run() {
/* 155 */           while (AbstractProcessor.this.processThreadRunning) {
/*     */             try {
/* 157 */               AbstractProcessor.this.runProcess();
/*     */             } catch (Exception e) {
/* 159 */               AbstractProcessor.log.error("", e);
/*     */             }
/*     */           }
/* 162 */           AbstractProcessor.log.info(getName() + " processThread is stop...");
/*     */         }
/*     */       };
/* 165 */       this.processThread.setName(this.name);
/* 166 */       this.processThread.start();
/*     */     }
/*     */     else
/*     */     {
/* 170 */       log.warn("processor[name=" + getName() + "] process thread is already startup");
/*     */     }
/* 172 */     if (!this.overflowProcessThreadRunning) {
/* 173 */       this.overflowProcessThreadRunning = true;
/* 174 */       log.info("start processor[name=" + getName() + "] overflowProcess thread...");
/* 175 */       this.overflowProcessThread = new Thread() {
/*     */         public void run() {
/* 177 */           while (AbstractProcessor.this.overflowProcessThreadRunning) {
/*     */             try {
/* 179 */               AbstractProcessor.this.runOverflowProcess();
/*     */             } catch (Exception e) {
/* 181 */               AbstractProcessor.log.error("", e);
/*     */             }
/*     */           }
/* 184 */           AbstractProcessor.log.info(getName() + " overflowProcessThread is stop...");
/*     */         }
/*     */       };
/* 187 */       this.overflowProcessThread.start();
/*     */     } else {
/* 189 */       log.warn("processor[name=" + getName() + "] overflowProcess thread is already startup");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void shutdown()
/*     */   {
/*     */     try {
/* 196 */       this.processThreadRunning = false;
/* 197 */       this.overflowProcessThreadRunning = false;
/* 198 */       synchronized (this.processThreadLock) {
/* 199 */         this.processThreadLock.notifyAll();
/*     */       }
/* 201 */       synchronized (this.overflowProcessThreadLock) {
/* 202 */         this.overflowProcessThreadLock.notifyAll();
/*     */       }
/*     */     } catch (Exception e) {
/* 205 */       log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void finalize() throws Throwable {
/* 210 */     super.finalize();
/* 211 */     shutdown();
/*     */   }
/*     */ 
/*     */   private void runProcess() {
/* 215 */     List<T> processingDataPacketList = new ArrayList();
/* 216 */     this.queue.drainTo(processingDataPacketList, this.processCapacity);
/* 217 */     if (processingDataPacketList.isEmpty())
/*     */     {
/* 219 */       synchronized (this.processThreadLock) {
/* 220 */         if (this.queue.isEmpty()) {
/*     */           try {
/* 222 */             this.processThreadWaiting = true;
/* 223 */             log.debug("processor[name=" + getName() + "] queue is empty process thead enter WAITING state");
/* 224 */             this.processThreadLock.wait();
/*     */           } catch (Exception e) {
/* 226 */             log.warn("processor[name=" + getName() + "] process thread wait error", e);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 231 */     for (DataPacket dataPacket : processingDataPacketList) {
/* 232 */       this.uniqueIndexSet.remove(dataPacket.getUniqueIndex());
/*     */     }
/* 234 */     processDataPackets(processingDataPacketList);
/*     */   }
/*     */ 
/*     */   private void runOverflowProcess()
/*     */   {
/* 239 */     if (this.overflowQueue.isEmpty())
/*     */     {
/* 241 */       synchronized (this.overflowProcessThreadLock) {
/* 242 */         if (this.overflowQueue.isEmpty()) {
/*     */           try {
/* 244 */             this.overflowProcessThreadWaiting = true;
/* 245 */             log.debug("processor[name=" + getName() + "] overflowQueue is empty overflowProcess thead enter WAITING state");
/* 246 */             this.overflowProcessThreadLock.wait();
/*     */           } catch (Exception e) {
/* 248 */             log.warn("processor[name=" + getName() + "] overflowProcess thread wait error", e);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 253 */     T dataPacket = (T)this.overflowQueue.poll();
/* 254 */     if (dataPacket != null)
/* 255 */       processOverflowDataPacket(dataPacket);
/*     */   }
/*     */ 
/*     */   public int getOverflowQueueCapacity()
/*     */   {
/* 260 */     return this.overflowQueueCapacity;
/*     */   }
/*     */ 
/*     */   public void setOverflowQueueCapacity(int overflowQueueCapacity) {
/* 264 */     this.overflowQueueCapacity = overflowQueueCapacity;
/*     */   }
/*     */ 
/*     */   public abstract void processDataPackets(List<T> paramList);
/*     */ 
/*     */   public abstract void processOverflowDataPacket(T paramT);
/*     */ 
/*     */   public final boolean putInWaitingQueue(T dataPacket)
/*     */   {
/* 285 */     if (dataPacket.getUniqueIndex() == null) {
/* 286 */       log.info("processor[name=" + getName() + "] putInWaitingQueue fail , DataPacket[UniqueIndex:is null] ");
/* 287 */       return false;
/* 288 */     }this.uniqueIndexSet.contains(dataPacket.getUniqueIndex());
/*     */ 
/* 295 */     if (this.queue.size() >= this.queueCapacity)
/*     */     {
/* 297 */       T overflowDataPacket = (T)this.queue.poll();
/* 298 */       log.info("processor[name=" + getName() + "] queue is full,take out element from queue , and put into overflowQueue " + overflowDataPacket.toString());
/* 299 */       if (this.overflowQueue.size() >= this.overflowQueueCapacity) {
/* 300 */         DataPacket dropedDataPacket = (DataPacket)this.overflowQueue.poll();
/* 301 */         log.info("processor[name=" + getName() + "] overflowQueue is full ,drop old element " + dropedDataPacket.toString());
/*     */       }
/* 303 */       this.overflowQueue.offer(overflowDataPacket);
/* 304 */       if (this.overflowProcessThreadWaiting) {
/* 305 */         synchronized (this.overflowProcessThreadLock)
/*     */         {
/* 307 */           this.overflowProcessThreadWaiting = false;
/* 308 */           log.debug("processor[name=" + getName() + "] notify overflowProcess thread");
/* 309 */           this.overflowProcessThreadLock.notifyAll();
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 315 */     this.queue.offer(dataPacket);
/* 316 */     this.uniqueIndexSet.add(dataPacket.getUniqueIndex());
/*     */ 
/* 318 */     if (this.processThreadWaiting) {
/* 319 */       synchronized (this.processThreadLock) {
/* 320 */         this.processThreadWaiting = false;
/* 321 */         log.debug("processor[name=" + getName() + "] notify process thread");
/* 322 */         this.processThreadLock.notifyAll();
/*     */       }
/*     */     }
/*     */ 
/* 326 */     return true;
/*     */   }
/*     */ 
/*     */   public void setQueueCapacity(int queueCapacity) {
/* 330 */     this.queueCapacity = queueCapacity;
/*     */   }
/*     */ 
/*     */   public void setProcessCapacity(int processCapacity) {
/* 334 */     this.processCapacity = processCapacity;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.processor.AbstractProcessor
 * JD-Core Version:    0.6.1
 */