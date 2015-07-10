/*     */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*     */ 
/*     */ import com.china317.core.base.UpMessage;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import java.util.Observable;
/*     */ 
/*     */ public class DownMessageAdapter extends Observable
/*     */ {
/*     */   public static final String STATUS_GATEWAY_OK = "0";
/*     */   public static final String STATUS_FAILURE = "1";
/*     */   public static final String STATUS_OFFLINE = "2";
/*     */   public static final String STATUS_ACK_OK = "3";
/*     */   public static final String STATUS_ACK_FAILED = "4";
/*     */   public static final String STATUS_ACK_RESULT = "5";
/*     */   public static final String STATUS_ACK_TIMEOUT = "6";
/*     */   public static final String STATUS_RST_TIMEOUT = "7";
/*     */   private String messageKey;
/*     */   private UnitPackJT808 pack;
/*     */   private String sendStatus;
/*     */   private long createTime;
/*     */   private long updTime;
/*  24 */   private long TIMEOUT = 600000L;
/*     */   private DownMessage downMessage;
/*     */ 
/*     */   public DownMessageAdapter(DownMessage downMessage, UnitPackJT808 pack)
/*     */   {
/*  29 */     this.messageKey = downMessage.getMessageKey();
/*  30 */     this.pack = pack;
/*  31 */     this.downMessage = downMessage;
/*     */   }
/*     */ 
/*     */   public DownMessageAdapter(String messageKey, UnitPackJT808 pack) {
/*  35 */     this.messageKey = messageKey;
/*  36 */     this.pack = pack;
/*     */   }
/*     */ 
/*     */   public String getMessageKey() {
/*  40 */     return this.messageKey;
/*     */   }
/*     */ 
/*     */   public void setMessageKey(String messageKey) {
/*  44 */     this.messageKey = messageKey;
/*     */   }
/*     */ 
/*     */   public UnitPackJT808 getPack() {
/*  48 */     return this.pack;
/*     */   }
/*     */ 
/*     */   public void setPack(UnitPackJT808 pack) {
/*  52 */     this.pack = pack;
/*     */   }
/*     */ 
/*     */   public String getSendStatus() {
/*  56 */     return this.sendStatus;
/*     */   }
/*     */ 
/*     */   public long getCreateTime() {
/*  60 */     return this.createTime;
/*     */   }
/*     */ 
/*     */   public void setCreateTime() {
/*  64 */     this.createTime = System.currentTimeMillis();
/*  65 */     setUpdTime();
/*     */   }
/*     */ 
/*     */   public void setUpdTime() {
/*  69 */     this.updTime = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   public boolean isTimeout() {
/*  73 */     boolean bTimeout = false;
/*  74 */     if (System.currentTimeMillis() - this.updTime > this.TIMEOUT) {
/*  75 */       bTimeout = true;
/*     */     }
/*  77 */     return bTimeout;
/*     */   }
/*     */ 
/*     */   public void setSendStatus(String sendStatus)
/*     */   {
/*  86 */     this.sendStatus = sendStatus;
/*  87 */     if (isChangeUpdTime(sendStatus)) {
/*  88 */       setUpdTime();
/*     */     }
/*  90 */     setChanged();
/*  91 */     notifyObservers(sendStatus);
/*     */   }
/*     */ 
/*     */   private boolean isChangeUpdTime(String sendStatus)
/*     */   {
/*  97 */     if ((this.pack.getMsgID() == 34560) || 
/*  98 */       (this.pack.getMsgID() == 33028) || 
/*  99 */       (this.pack.getMsgID() == 33281) || 
/* 100 */       (this.pack.getMsgID() == 34818))
/*     */     {
/* 102 */       if (("3".equals(sendStatus)) || ("0".equals(sendStatus))) {
/* 103 */         return true;
/*     */       }
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   public void setResultPack(UpMessage pack) {
/* 110 */     setChanged();
/* 111 */     notifyObservers(pack);
/*     */   }
/*     */ 
/*     */   public boolean isFinished(String status) {
/* 115 */     if (("1".equals(status)) || ("2".equals(status)) || ("4".equals(status)) || ("5".equals(status)) || 
/* 116 */       (isStatusAckOk(status))) {
/* 117 */       return true;
/*     */     }
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isStatusAckOk(String status) {
/* 123 */     boolean isOk = false;
/* 124 */     if ("3".equals(status))
/*     */     {
/* 126 */       if ((this.pack.getMsgID() == 32769) || 
/* 127 */         (this.pack.getMsgID() == 33024) || 
/* 128 */         (this.pack.getMsgID() == 33027) || 
/* 129 */         (this.pack.getMsgID() == 33029) || 
/* 130 */         (this.pack.getMsgID() == 33282) || 
/* 131 */         (this.pack.getMsgID() == 33536) || 
/* 134 */         (this.pack.getMsgID() == 33540) || 
/* 135 */         (this.pack.getMsgID() == 33792) || 
/* 136 */         (this.pack.getMsgID() == 33793) || 
/* 138 */         (this.pack.getMsgID() == 34304) || (this.pack.getMsgID() == 34305) || (this.pack.getMsgID() == 34306) || 
/* 139 */         (this.pack.getMsgID() == 34307) || (this.pack.getMsgID() == 34308) || (this.pack.getMsgID() == 34309) || 
/* 140 */         (this.pack.getMsgID() == 34310) || (this.pack.getMsgID() == 34311) || (this.pack.getMsgID() == 34561) || 
/* 141 */         (this.pack.getMsgID() == 34816) || (this.pack.getMsgID() == 34817) || (this.pack.getMsgID() == 34819) || 
/* 142 */         (this.pack.getMsgID() == 34820) || (this.pack.getMsgID() == 35072) || (this.pack.getMsgID() == 35328))
/* 143 */         isOk = true;
/* 144 */       else if ((this.pack.getMsgID() != 33537) && (this.pack.getMsgID() != 33538) && (this.pack.getMsgID() != 33539) && 
/* 145 */         (this.pack.getMsgID() != 34048) && (this.pack.getMsgID() != 33028) && (this.pack.getMsgID() != 33281) && 
/* 146 */         (this.pack.getMsgID() != 34560) && (this.pack.getMsgID() != 34818))
/* 147 */         isOk = true;
/*     */       else {
/* 149 */         isOk = false;
/*     */       }
/*     */     }
/* 152 */     return isOk;
/*     */   }
/*     */ 
/*     */   public void processOfTimeout() {
/* 156 */     if ("3".equals(this.sendStatus))
/* 157 */       setSendStatus("7");
/*     */     else
/* 159 */       setSendStatus("6");
/*     */   }
/*     */ 
/*     */   public DownMessage getDownMessage()
/*     */   {
/* 164 */     return this.downMessage;
/*     */   }
/*     */ 
/*     */   public void setDownMessage(DownMessage downMessage) {
/* 168 */     this.downMessage = downMessage;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.DownMessageAdapter
 * JD-Core Version:    0.6.1
 */