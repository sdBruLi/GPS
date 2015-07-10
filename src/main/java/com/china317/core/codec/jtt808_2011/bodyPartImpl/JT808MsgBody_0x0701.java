/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0701 extends JT808MsgBody
/*    */ {
/*    */   private int elecFreightNote;
/*    */   private IoBuffer freightNoteContent;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 20 */     this.elecFreightNote = this.bodyBuffer.getInt();
/* 21 */     this.freightNoteContent = this.bodyBuffer.getSlice(this.bodyBuffer.limit() - 4);
/* 22 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public String getElecFreightNoteLine() {
/* 26 */     if (this.freightNoteContent != null) {
/*    */       try {
/* 28 */         return this.freightNoteContent.getString(DefaultCharset.decoder);
/*    */       } catch (CharacterCodingException e) {
/* 30 */         e.printStackTrace();
/*    */       }
/*    */     }
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */   public int getElecFreightNote() {
/* 37 */     return this.elecFreightNote;
/*    */   }
/*    */ 
/*    */   public void setElecFreightNote(int elecFreightNote) {
/* 41 */     this.elecFreightNote = elecFreightNote;
/*    */   }
/*    */ 
/*    */   public IoBuffer getFreightNoteContent() {
/* 45 */     return this.freightNoteContent;
/*    */   }
/*    */ 
/*    */   public void setFreightNoteContent(IoBuffer freightNoteContent) {
/* 49 */     this.freightNoteContent = freightNoteContent;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0701
 * JD-Core Version:    0.6.1
 */