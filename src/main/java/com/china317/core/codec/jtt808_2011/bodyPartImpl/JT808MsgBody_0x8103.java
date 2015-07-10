/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8103 extends JT808MsgBody
/*    */ {
/*    */   private byte paramCount;
/*    */   private List<JT808MsgBody_0x8103_param_item> paramList;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 19 */     if (!isBuildBody()) {
/* 20 */       this.bodyBuffer = IoBuffer.allocate(1).setAutoExpand(true);
/* 21 */       this.bodyBuffer.put(this.paramCount);
/* 22 */       if (this.paramList != null) {
/* 23 */         for (JT808MsgBody_0x8103_param_item item : this.paramList) {
/* 24 */           item.bulidBody();
/* 25 */           this.bodyBuffer.put(item.getBodyBuffer());
/*    */         }
/*    */       }
/* 28 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/* 34 */     this.paramCount = this.bodyBuffer.get();
/* 35 */     for (int i = 0; i < this.paramCount; i++) {
/* 36 */       if (this.paramList == null) {
/* 37 */         this.paramList = new ArrayList();
/*    */       }
/* 39 */       JT808MsgBody_0x8103_param_item item = new JT808MsgBody_0x8103_param_item();
/* 40 */       item.setParamID(this.bodyBuffer.getInt());
/* 41 */       item.setParamLen(this.bodyBuffer.get());
/* 42 */       item.setParamValue(this.bodyBuffer.getSlice(item.getParamLen()));
/*    */ 
/* 44 */       this.paramList.add(item);
/*    */     }
/* 46 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public static UnitPackJT808 createParameterPack(String mobileNum, byte paramCount, List<JT808MsgBody_0x8103_param_item> paramList)
/*    */     throws Exception
/*    */   {
/* 60 */     UnitPackJT808 pack = new UnitPackJT808(33027);
/* 61 */     pack.setMobileNum(mobileNum);
/* 62 */     JT808MsgBody_0x8103 body = new JT808MsgBody_0x8103();
/* 63 */     body.setParamCount(paramCount);
/* 64 */     body.setParamList(paramList);
/* 65 */     pack.setMsgBody(body);
/* 66 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getParamCount() {
/* 70 */     return this.paramCount;
/*    */   }
/*    */ 
/*    */   public void setParamCount(byte paramCount) {
/* 74 */     this.paramCount = paramCount;
/*    */   }
/*    */ 
/*    */   public List<JT808MsgBody_0x8103_param_item> getParamList() {
/* 78 */     return this.paramList;
/*    */   }
/*    */ 
/*    */   public void setParamList(List<JT808MsgBody_0x8103_param_item> paramList) {
/* 82 */     this.paramList = paramList;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8103
 * JD-Core Version:    0.6.1
 */