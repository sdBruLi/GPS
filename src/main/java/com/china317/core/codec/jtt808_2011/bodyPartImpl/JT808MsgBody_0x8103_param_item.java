/*     */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*     */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class JT808MsgBody_0x8103_param_item extends JT808MsgBody
/*     */ {
/*     */   private int paramID;
/*     */   private byte paramLen;
/*     */   private IoBuffer paramValue;
/*     */ 
/*     */   public int getParamID()
/*     */   {
/*  14 */     return this.paramID;
/*     */   }
/*     */ 
/*     */   public void setParamID(int paramID) {
/*  18 */     this.paramID = paramID;
/*     */   }
/*     */ 
/*     */   public byte getParamLen() {
/*  22 */     return this.paramLen;
/*     */   }
/*     */ 
/*     */   public void setParamLen(byte paramLen) {
/*  26 */     this.paramLen = paramLen;
/*     */   }
/*     */ 
/*     */   public IoBuffer getParamValue() {
/*  30 */     return this.paramValue;
/*     */   }
/*     */ 
/*     */   public void setParamValue(IoBuffer paramValue) {
/*  34 */     this.paramValue = paramValue;
/*     */   }
/*     */ 
/*     */   public void bulidBody() throws Exception
/*     */   {
/*  39 */     if (!isBuildBody()) {
/*  40 */       this.bodyBuffer = IoBuffer.allocate(5).setAutoExpand(true);
/*  41 */       this.bodyBuffer.putInt(this.paramID);
/*  42 */       this.bodyBuffer.put(this.paramLen);
/*  43 */       if (this.paramValue != null) {
/*  44 */         this.bodyBuffer.put(this.paramValue);
/*     */       }
/*  46 */       this.bodyBuffer.flip();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void praseBody() throws Exception
/*     */   {
/*  52 */     this.paramID = this.bodyBuffer.getInt();
/*  53 */     this.paramLen = this.bodyBuffer.get();
/*  54 */     if (this.paramLen > 0) {
/*  55 */       this.paramValue = this.bodyBuffer.getSlice(this.paramLen);
/*     */     }
/*  57 */     this.bodyBuffer.rewind();
/*     */   }
/*     */ 
/*     */   public Object getValue() {
/*  61 */     Object obj = null;
/*     */     try
/*     */     {
/*  64 */       if (this.paramLen > 0)
/*     */       {
/*  66 */         if (((this.paramID >= 16) && (this.paramID <= 23)) || 
/*  67 */           (this.paramID == 26) || (this.paramID == 29) || 
/*  68 */           ((this.paramID >= 64) && (this.paramID <= 68)) || 
/*  69 */           (this.paramID == 72) || (this.paramID == 73) || 
/*  70 */           (this.paramID == 131)) {
/*     */           try {
/*  72 */             obj = this.paramValue.getString(DefaultCharset.decoder);
/*     */           } catch (Exception e) {
/*  74 */             obj = "";
/*     */           }
/*     */         }
/*  77 */         else if ((this.paramID == 49) || 
/*  78 */           ((this.paramID >= 91) && (this.paramID <= 94)) || 
/*  79 */           (this.paramID == 53) || (this.paramID == 54) || (this.paramID == 55) || 
/*  80 */           (this.paramID == 129) || (this.paramID == 130) || (this.paramID == 91) || 
/*  81 */           (this.paramID == 257) || (this.paramID == 259)) {
/*  82 */           obj = new Short(this.paramValue.getShort());
/*     */         }
/*  84 */         else if ((this.paramID == 132) || 
/*  85 */           ((this.paramID >= 144) && (this.paramID >= 146)) || 
/*  86 */           (this.paramID == 148)) {
/*  87 */           obj = new Byte(this.paramValue.get());
/*     */         }
/*  89 */         else if ((this.paramID == 70) || (this.paramID == 71)) {
/*  90 */           int i = -1;
/*  91 */           obj = new Integer(this.paramValue.getInt());
/*  92 */           int temp = ((Integer)obj).intValue();
/*  93 */           if (i == (temp & i)) {
/*  94 */             obj = "不限制";
/*     */           }
/*     */ 
/*     */         }
/* 102 */         else if (((this.paramID >= 1) && (this.paramID <= 7)) || 
/* 103 */           (this.paramID == 24) || (this.paramID == 25) || 
/* 104 */           (this.paramID == 27) || (this.paramID == 28) || 
/* 105 */           ((this.paramID >= 32) && (this.paramID <= 41)) || 
/* 106 */           ((this.paramID >= 44) && (this.paramID <= 48)) || 
/* 107 */           ((this.paramID >= 69) && (this.paramID <= 71)) || 
/* 108 */           ((this.paramID >= 80) && (this.paramID <= 90)) || 
/* 109 */           ((this.paramID >= 100) && (this.paramID <= 101)) || 
/* 110 */           ((this.paramID == 112) && (this.paramID == 116)) || 
/* 111 */           (this.paramID == 128) || (this.paramID == 147) || 
/* 112 */           (this.paramID == 149) || (this.paramID == 256) || 
/* 113 */           (this.paramID == 258)) {
/* 114 */           obj = new Integer(this.paramValue.getInt());
/*     */         } else {
/* 116 */           obj = this.paramValue;
/*     */         }
/* 118 */         this.paramValue.rewind();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 122 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 125 */     return obj;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8103_param_item
 * JD-Core Version:    0.6.1
 */