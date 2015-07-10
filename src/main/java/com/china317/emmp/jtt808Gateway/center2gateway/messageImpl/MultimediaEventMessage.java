/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0800;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class MultimediaEventMessage extends BaseUpMessage
/*     */ {
/*  16 */   private static final Log log = LogFactory.getLog(MultimediaEventMessage.class);
/*     */   public static final byte MULTIMEDIA_TYPE_IMAGE = 0;
/*     */   public static final byte MULTIMEDIA_TYPE_AUDIO = 1;
/*     */   public static final byte MULTIMEDIA_TYPE_VIDEO = 2;
/*     */   public static final byte MULTIMEDIA_FORMAT_JPEG = 0;
/*     */   public static final byte MULTIMEDIA_FORMAT_TIF = 1;
/*     */   public static final byte MULTIMEDIA_FORMAT_MP3 = 2;
/*     */   public static final byte MULTIMEDIA_FORMAT_WAV = 3;
/*     */   public static final byte MULTIMEDIA_FORMAT_WMV = 4;
/*     */   public static final byte EVENT_ITEM_CODING_PLATFORM = 0;
/*     */   public static final byte EVENT_ITEM_CODING_TIMING = 1;
/*     */   public static final byte EVENT_ITEM_CODING_ALERT_ROBBERY = 2;
/*     */   public static final byte EVENT_ITEM_CODING_CRASH = 3;
/*     */   private int multimediaID;
/*     */   private byte multimediaType;
/*     */   private byte multimediaFormatCoding;
/*     */   private byte eventItemCoding;
/*     */   private byte channelID;
/*     */ 
/*     */   public MultimediaEventMessage()
/*     */   {
/*  49 */     setCommand("0x0800");
/*     */   }
/*     */ 
/*     */   public void unpack(UnitPackJT808 pack) {
/*  53 */     unpackHeadPart(pack);
/*     */     try {
/*  55 */       JT808MsgBody_0x0800 body = (JT808MsgBody_0x0800)pack.getMsgBody();
/*  56 */       setChannelID(body.getChannelID());
/*  57 */       setEventItemCoding(body.getEventItemCoding());
/*  58 */       setMultimediaID(body.getMultimediaID());
/*  59 */       setMultimediaType(body.getMultimediaType());
/*  60 */       setMultimediaFormatCoding(body.getMultimediaFormatCoding());
/*     */     } catch (Exception e) {
/*  62 */       log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getMultimediaID() {
/*  67 */     return this.multimediaID;
/*     */   }
/*     */ 
/*     */   public void setMultimediaID(int multimediaID)
/*     */   {
/*  72 */     this.multimediaID = multimediaID;
/*     */   }
/*     */ 
/*     */   public byte getMultimediaType() {
/*  76 */     return this.multimediaType;
/*     */   }
/*     */ 
/*     */   public void setMultimediaType(byte multimediaType)
/*     */   {
/*  81 */     this.multimediaType = multimediaType;
/*     */   }
/*     */ 
/*     */   public byte getMultimediaFormatCoding() {
/*  85 */     return this.multimediaFormatCoding;
/*     */   }
/*     */ 
/*     */   public void setMultimediaFormatCoding(byte multimediaFormatCoding)
/*     */   {
/*  90 */     this.multimediaFormatCoding = multimediaFormatCoding;
/*     */   }
/*     */ 
/*     */   public byte getEventItemCoding() {
/*  94 */     return this.eventItemCoding;
/*     */   }
/*     */ 
/*     */   public void setEventItemCoding(byte eventItemCoding)
/*     */   {
/*  99 */     this.eventItemCoding = eventItemCoding;
/*     */   }
/*     */ 
/*     */   public byte getChannelID() {
/* 103 */     return this.channelID;
/*     */   }
/*     */ 
/*     */   public void setChannelID(byte channelID)
/*     */   {
/* 108 */     this.channelID = channelID;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.MultimediaEventMessage
 * JD-Core Version:    0.6.1
 */