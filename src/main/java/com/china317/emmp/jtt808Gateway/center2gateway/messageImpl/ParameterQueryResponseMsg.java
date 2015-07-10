/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0104;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8103_param_item;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class ParameterQueryResponseMsg extends BaseUpMessage
/*    */ {
/* 19 */   private static final Log log = LogFactory.getLog(ParameterQueryResponseMsg.class);
/*    */   private short ackSeqnum;
/*    */   private byte ackParamCount;
/*    */   private List<ParameterItem> params;
/*    */ 
/*    */   public ParameterQueryResponseMsg()
/*    */   {
/* 24 */     setCommand("0x0104");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack) {
/* 28 */     unpackHeadPart(pack);
/*    */     try {
/* 30 */       JT808MsgBody_0x0104 body = (JT808MsgBody_0x0104)pack.getMsgBody();
/* 31 */       setAckSeqnum(body.getAckSeqnum());
/* 32 */       setAckParamCount(body.getAckParamCount());
/* 33 */       if (body.getParams() != null)
/* 34 */         for (JT808MsgBody_0x8103_param_item item : body.getParams()) {
/* 35 */           if (this.params == null) {
/* 36 */             this.params = new ArrayList();
/*    */           }
/* 38 */           this.params.add(new ParameterItem(item.getParamID(), item.getParamLen(), item.getValue()));
/*    */         }
/*    */     }
/*    */     catch (Exception e) {
/* 42 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public short getAckSeqnum() {
/* 47 */     return this.ackSeqnum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqnum(short ackSeqnum)
/*    */   {
/* 52 */     this.ackSeqnum = ackSeqnum;
/*    */   }
/*    */ 
/*    */   public byte getAckParamCount() {
/* 56 */     return this.ackParamCount;
/*    */   }
/*    */ 
/*    */   public void setAckParamCount(byte ackParamCount)
/*    */   {
/* 61 */     this.ackParamCount = ackParamCount;
/*    */   }
/*    */ 
/*    */   public List<ParameterItem> getParams() {
/* 65 */     return this.params;
/*    */   }
/*    */ 
/*    */   public void setParams(List<ParameterItem> params)
/*    */   {
/* 70 */     this.params = params;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ParameterQueryResponseMsg
 * JD-Core Version:    0.6.1
 */