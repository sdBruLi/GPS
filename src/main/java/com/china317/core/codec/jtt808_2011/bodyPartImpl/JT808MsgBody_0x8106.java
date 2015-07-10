/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x8106 extends JT808MsgBody
/*    */ {
/*    */   private List<JT808MsgBody_0x8103_param_item> paramList;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/* 19 */     if (!isBuildBody()) {
/* 20 */       this.bodyBuffer = IoBuffer.allocate(1).setAutoExpand(true);
/* 21 */       this.bodyBuffer.put((byte)this.paramList.size());
/* 22 */       if (this.paramList != null) {
/* 23 */         for (JT808MsgBody_0x8103_param_item item : this.paramList) {
/* 24 */           this.bodyBuffer.putInt(item.getParamID());
/*    */         }
/*    */       }
/* 27 */       this.bodyBuffer.flip();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void praseBody() throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public List<JT808MsgBody_0x8103_param_item> getParamList()
/*    */   {
/* 37 */     return this.paramList;
/*    */   }
/*    */ 
/*    */   public void setParamList(List<JT808MsgBody_0x8103_param_item> paramList) {
/* 41 */     this.paramList = paramList;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8106
 * JD-Core Version:    0.6.1
 */