/*    */ package com.china317.core.codec.jtt809_2011;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class PlatformCodecConfigManager
/*    */ {
/*  7 */   private static PlatformCodecConfigManager manager = new PlatformCodecConfigManager();
/*  8 */   private Map<Integer, CodecConfig> codecConfigMap = new HashMap();
/*    */ 
/*    */   public static PlatformCodecConfigManager getInstance()
/*    */   {
/* 14 */     return manager;
/*    */   }
/*    */ 
/*    */   public void putCodecConfig(Integer msgCnssCenterid, CodecConfig codecConfig) {
/* 18 */     this.codecConfigMap.put(msgCnssCenterid, codecConfig);
/*    */   }
/*    */ 
/*    */   public CodecConfig getCodecConfig(Integer msgCnssCenterid) {
/* 22 */     return (CodecConfig)this.codecConfigMap.get(msgCnssCenterid);
/*    */   }
/*    */ 
/*    */   public void updCodeConfig(Integer msgCnssCenterid, boolean encryptEnable, long encryptKey) {
/* 26 */     if (this.codecConfigMap.get(msgCnssCenterid) != null) {
/* 27 */       ((CodecConfig)this.codecConfigMap.get(msgCnssCenterid)).setEncryptEnable(encryptEnable);
/* 28 */       ((CodecConfig)this.codecConfigMap.get(msgCnssCenterid)).setEncryptKey(encryptKey);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.PlatformCodecConfigManager
 * JD-Core Version:    0.6.1
 */