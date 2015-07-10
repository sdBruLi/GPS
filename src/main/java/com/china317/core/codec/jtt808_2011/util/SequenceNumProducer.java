/*    */ package com.china317.core.codec.jtt808_2011.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class SequenceNumProducer
/*    */ {
/*  7 */   private Map<String, SequenceM> sequenceMap = new HashMap<String, SequenceNumProducer.SequenceM>();
/*  8 */   private static SequenceNumProducer producer = new SequenceNumProducer();
/*    */ 
/*    */   public static int getSequenceNum(String key) {
/* 11 */     return producer.getSequenceNumInner(key) & 0xFFFF;
/*    */   }
/*    */ 
/*    */   public static void clearSessionSeqNum(String id) {
/* 15 */     producer.removeSessionId(id);
/*    */   }
/*    */ 
/*    */   private int getSequenceNumInner(String key)
/*    */   {
/* 20 */     if (this.sequenceMap.size() > 100000)
/* 21 */       this.sequenceMap.clear();
/*    */     SequenceM m;
/* 23 */     if (this.sequenceMap.containsKey(key)) {
/* 24 */       m = (SequenceM)this.sequenceMap.get(key);
/*    */     } else {
/* 26 */       m = new SequenceM();
/* 27 */       this.sequenceMap.put(key, m);
/*    */     }
/* 29 */     return m.curSeq++;
/*    */   }
/*    */ 
/*    */   private void removeSessionId(String key) {
/* 33 */     this.sequenceMap.remove(key);
/*    */   }
/*    */ 
/*    */   class SequenceM {
/* 37 */     int curSeq = 1;
/*    */ 
/*    */     SequenceM()
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.util.SequenceNumProducer
 * JD-Core Version:    0.6.1
 */