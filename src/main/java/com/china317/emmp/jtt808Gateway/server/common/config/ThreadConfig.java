/*     */ package com.china317.emmp.jtt808Gateway.server.common.config;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class ThreadConfig
/*     */ {
/*   7 */   public static String SERVER_LISTEN_PROT = "listenPort";
/*   8 */   public static String REMOTE_PORT = "RemotePort";
/*   9 */   public static String REMOTE_IP = "RemoteIP";
/*     */ 
/*  11 */   public static String PROCESSOR_NAME = "processorName";
/*  12 */   public static String SESSION_AUTH_STATUS = "sessionAuthorizationStatus";
/*  13 */   public static String ACCEPT_COMMANDS = "acceptCommands";
/*     */ 
/*  15 */   public static String OPEN_SESSION_TIMEOUT = "openSessionTimeout";
/*  16 */   public static String LASTDATA_TIMEOUT = "lastDataTimeout";
/*     */ 
/*  18 */   private String id = "";
/*  19 */   private boolean isRun = false;
/*     */ 
/*  21 */   private final Map<String, String> map = new HashMap();
/*     */ 
/*     */   public String getId() {
/*  24 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void put(String key, String value) {
/*  28 */     if (value != null) {
/*  29 */       if (key.equals("id"))
/*  30 */         this.id = value;
/*  31 */       else if ((key.equals("isRun")) && 
/*  32 */         (value.toLowerCase().equals("true"))) {
/*  33 */         this.isRun = true;
/*     */       }
/*     */     }
/*     */ 
/*  37 */     this.map.put(key, value);
/*     */   }
/*     */ 
/*     */   public String get(String key, String defaultValue) {
/*  41 */     if (this.map.containsKey(key)) {
/*  42 */       return (String)this.map.get(key);
/*     */     }
/*  44 */     return defaultValue;
/*     */   }
/*     */ 
/*     */   public String[] get(String key)
/*     */   {
/*  49 */     String tempLine = "";
/*  50 */     if (this.map.containsKey(key)) {
/*  51 */       tempLine = (String)this.map.get(key);
/*     */     }
/*  53 */     if (!"".equals(tempLine)) {
/*  54 */       String[] tempLines = tempLine.split(",");
/*  55 */       for (int i = 0; i < tempLines.length; i++) {
/*  56 */         tempLines[i] = tempLines[i].trim().toLowerCase();
/*     */       }
/*  58 */       return tempLines;
/*     */     }
/*  60 */     return null;
/*     */   }
/*     */ 
/*     */   public int getInt(String key, int defaultValue) {
/*  64 */     if (this.map.containsKey(key)) {
/*  65 */       return Integer.parseInt((String)this.map.get(key));
/*     */     }
/*  67 */     return defaultValue;
/*     */   }
/*     */ 
/*     */   public boolean is(String key, boolean defaultValue)
/*     */   {
/*  72 */     if (this.map.containsKey(key)) {
/*  73 */       return ((String)this.map.get(key)).toLowerCase().equals("true");
/*     */     }
/*  75 */     return defaultValue;
/*     */   }
/*     */ 
/*     */   public String[] getCommons()
/*     */   {
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */   public int getListenPort() {
/*  84 */     return getInt(SERVER_LISTEN_PROT, 0);
/*     */   }
/*     */ 
/*     */   public int getRemotePort() {
/*  88 */     return getInt(REMOTE_PORT, 0);
/*     */   }
/*     */ 
/*     */   public int getOpenSessionTimeout() {
/*  92 */     return getInt(OPEN_SESSION_TIMEOUT, 0);
/*     */   }
/*     */   public int getLastDataTimeout() {
/*  95 */     return getInt(LASTDATA_TIMEOUT, 0);
/*     */   }
/*     */   public String getRemoteIP() {
/*  98 */     return get(REMOTE_IP, "");
/*     */   }
/*     */ 
/*     */   public String getProcessorName() {
/* 102 */     return get(PROCESSOR_NAME, "");
/*     */   }
/*     */ 
/*     */   public String getSessionAuthStatus() {
/* 106 */     return get(SESSION_AUTH_STATUS, "");
/*     */   }
/*     */ 
/*     */   public String[] getAcceptCommands() {
/* 110 */     return get(ACCEPT_COMMANDS);
/*     */   }
/*     */ 
/*     */   public boolean isRun() {
/* 114 */     return this.isRun;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/* 118 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public void setRun(boolean isRun) {
/* 122 */     this.isRun = isRun;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.common.config.ThreadConfig
 * JD-Core Version:    0.6.1
 */