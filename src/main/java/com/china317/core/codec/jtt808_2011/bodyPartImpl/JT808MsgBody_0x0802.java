/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0802 extends JT808MsgBody
/*    */ {
/*    */   private short ackSeqNum;
/*    */   private short multimediaItemCount;
/*    */   private List<JT808MsgBody_0x0802_item> items;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!isBuildBody()) {
/* 19 */       this.bodyBuffer = IoBuffer.allocate(3).setAutoExpand(true);
/* 20 */       this.bodyBuffer.putShort(this.ackSeqNum);
/* 21 */       this.bodyBuffer.putShort(this.multimediaItemCount);
/* 22 */       if (this.items != null) {
/* 23 */         for (JT808MsgBody_0x0802_item item : this.items) {
/* 24 */           item.bulidBody();
/* 25 */           this.bodyBuffer.put(item.getBodyBuffer());
/*    */         }
/*    */       }
/*    */ 
/* 29 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 35 */     this.ackSeqNum = this.bodyBuffer.getShort();
/* 36 */     this.multimediaItemCount = this.bodyBuffer.getShort();
/* 37 */     for (int i = 0; i < this.multimediaItemCount; i++) {
/* 38 */       if (this.items == null) {
/* 39 */         this.items = new ArrayList();
/*    */       }
/* 41 */       JT808MsgBody_0x0802_item item = new JT808MsgBody_0x0802_item();
/* 42 */       item.setBodyBuffer(this.bodyBuffer.getSlice(35));
/* 43 */       item.praseBody();
/* 44 */       this.items.add(item);
/*    */     }
/* 46 */     this.bodyBuffer.flip();
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 51 */     StringBuffer line = new StringBuffer("");
/* 52 */     line.append("0x0802 ---> ackSeqNum: ");
/* 53 */     line.append(this.ackSeqNum);
/* 54 */     line.append(" multimediaItemCount: ");
/* 55 */     line.append(this.multimediaItemCount);
/* 56 */     if (this.items != null) {
/* 57 */       for (JT808MsgBody_0x0802_item item : this.items) {
/* 58 */         line.append(item.toString());
/*    */       }
/*    */     }
/*    */ 
/* 62 */     return line.toString();
/*    */   }
/*    */ 
/*    */   public short getAckSeqNum() {
/* 66 */     return this.ackSeqNum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqNum(short ackSeqNum) {
/* 70 */     this.ackSeqNum = ackSeqNum;
/*    */   }
/*    */ 
/*    */   public short getMultimediaItemCount() {
/* 74 */     return this.multimediaItemCount;
/*    */   }
/*    */ 
/*    */   public void setMultimediaItemCount(short multimediaItemCount) {
/* 78 */     this.multimediaItemCount = multimediaItemCount;
/*    */   }
/*    */ 
/*    */   public List<JT808MsgBody_0x0802_item> getItems() {
/* 82 */     return this.items;
/*    */   }
/*    */ 
/*    */   public void setItems(List<JT808MsgBody_0x0802_item> items) {
/* 86 */     this.items = items;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0802
 * JD-Core Version:    0.6.1
 */