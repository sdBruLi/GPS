/*    */ package com.china317.core.event;
/*    */ 
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public abstract class AbstractQueueThread<E>
/*    */ {
/* 17 */   private static final Log log = LogFactory.getLog(AbstractQueueThread.class);
/*    */   private LinkedBlockingQueue<E> queue;
/*    */   private Thread processThread;
/*    */   private boolean processThreadRunning;
/*    */   private boolean processThreadWaiting;
/*    */   private Object lock;
/*    */   private String name;
/*    */ 
/*    */   public AbstractQueueThread(String name)
/*    */   {
/* 30 */     this(2147483647, name);
/*    */   }
/*    */ 
/*    */   public AbstractQueueThread(int capacity, String name)
/*    */   {
/* 39 */     this.queue = new LinkedBlockingQueue(capacity);
/* 40 */     this.name = name;
/* 41 */     this.processThreadRunning = true;
/* 42 */     this.processThreadWaiting = false;
/* 43 */     this.lock = new Object();
/* 44 */     this.processThread = new Thread() {
/*    */       public void run() {
/* 46 */         while (AbstractQueueThread.this.processThreadRunning)
/* 47 */           AbstractQueueThread.this.runProcess();
/*    */       }
/*    */     };
/* 51 */     log.debug("[name=" + this.name + "] start process thread");
/* 52 */     this.processThread.start();
/*    */   }
/*    */   private void runProcess() {
/* 55 */     E element = this.queue.poll();
/* 56 */     if (element == null) {
/* 57 */       synchronized (this.lock) {
/* 58 */         if (this.queue.isEmpty()) {
/*    */           try {
/* 60 */             this.processThreadWaiting = true;
/* 61 */             log.debug("[name=" + this.name + "] queue is empty process thead enter WAITING state");
/* 62 */             this.lock.wait();
/*    */           } catch (Exception e) {
/* 64 */             log.warn("[name=" + this.name + "] process thread wait error", e);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 69 */     process(element);
/*    */   }
/*    */ 
/*    */   public boolean putInWaitingQueue(E element)
/*    */   {
/* 75 */     boolean result = this.queue.offer(element);
/* 76 */     if (this.processThreadWaiting) {
/* 77 */       synchronized (this.lock) {
/* 78 */         this.processThreadWaiting = false;
/* 79 */         log.debug("[name=" + this.name + "] notify process thread");
/* 80 */         this.lock.notifyAll();
/*    */       }
/*    */     }
/*    */ 
/* 84 */     return result;
/*    */   }
/*    */ 
/*    */   public abstract void process(E paramE);
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.event.AbstractQueueThread
 * JD-Core Version:    0.6.1
 */