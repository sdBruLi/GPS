/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0800 extends JT808MsgBody
/*    */ {
/*    */   public static final byte MULTIMEDIA_TYPE_IMAGE = 0;
/*    */   public static final byte MULTIMEDIA_TYPE_AUDIO = 1;
/*    */   public static final byte MULTIMEDIA_TYPE_VIDEO = 2;
/*    */   public static final byte MULTIMEDIA_FORMAT_JPEG = 0;
/*    */   public static final byte MULTIMEDIA_FORMAT_TIF = 1;
/*    */   public static final byte MULTIMEDIA_FORMAT_MP3 = 2;
/*    */   public static final byte MULTIMEDIA_FORMAT_WAV = 3;
/*    */   public static final byte MULTIMEDIA_FORMAT_WMV = 4;
/*    */   public static final byte EVENT_ITEM_CODING_PLATFORM = 0;
/*    */   public static final byte EVENT_ITEM_CODING_TIMING = 1;
/*    */   public static final byte EVENT_ITEM_CODING_ALERT_ROBBERY = 2;
/*    */   public static final byte EVENT_ITEM_CODING_CRASH = 3;
/*    */   private int multimediaID;
/*    */   private byte multimediaType;
/*    */   private byte multimediaFormatCoding;
/*    */   private byte eventItemCoding;
/*    */   private byte channelID;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!isBuildBody()) {
/* 29 */       this.bodyBuffer = IoBuffer.allocate(8).setAutoExpand(true);
/* 30 */       this.bodyBuffer.putInt(this.multimediaID);
/* 31 */       this.bodyBuffer.put(this.multimediaType);
/* 32 */       this.bodyBuffer.put(this.multimediaFormatCoding);
/* 33 */       this.bodyBuffer.put(this.eventItemCoding);
/* 34 */       this.bodyBuffer.put(this.channelID);
/* 35 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 41 */     this.multimediaID = this.bodyBuffer.getInt();
/* 42 */     this.multimediaType = this.bodyBuffer.get();
/* 43 */     this.multimediaFormatCoding = this.bodyBuffer.get();
/* 44 */     this.eventItemCoding = this.bodyBuffer.get();
/* 45 */     this.channelID = this.bodyBuffer.get();
/* 46 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getMultimediaID() {
/* 50 */     return this.multimediaID;
/*    */   }
/*    */ 
/*    */   public void setMultimediaID(int multimediaID) {
/* 54 */     this.multimediaID = multimediaID;
/*    */   }
/*    */ 
/*    */   public byte getMultimediaType() {
/* 58 */     return this.multimediaType;
/*    */   }
/*    */ 
/*    */   public void setMultimediaType(byte multimediaType) {
/* 62 */     this.multimediaType = multimediaType;
/*    */   }
/*    */ 
/*    */   public byte getMultimediaFormatCoding() {
/* 66 */     return this.multimediaFormatCoding;
/*    */   }
/*    */ 
/*    */   public void setMultimediaFormatCoding(byte multimediaFormatCoding) {
/* 70 */     this.multimediaFormatCoding = multimediaFormatCoding;
/*    */   }
/*    */ 
/*    */   public byte getEventItemCoding() {
/* 74 */     return this.eventItemCoding;
/*    */   }
/*    */ 
/*    */   public void setEventItemCoding(byte eventItemCoding) {
/* 78 */     this.eventItemCoding = eventItemCoding;
/*    */   }
/*    */ 
/*    */   public byte getChannelID() {
/* 82 */     return this.channelID;
/*    */   }
/*    */ 
/*    */   public void setChannelID(byte channelID) {
/* 86 */     this.channelID = channelID;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0800
 * JD-Core Version:    0.6.1
 */