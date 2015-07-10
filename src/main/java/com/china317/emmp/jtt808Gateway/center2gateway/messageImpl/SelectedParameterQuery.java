/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8103_param_item;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8106;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SelectedParameterQuery extends BaseDownMessage
/*    */ {
/*    */   private List<Integer> paramIdList;
/*    */ 
/*    */   public SelectedParameterQuery(String mobileNum, String messageKey, List<Integer> paramIdList)
/*    */   {
/* 27 */     setMobileNum(mobileNum);
/* 28 */     setMessageKey(messageKey);
/* 29 */     setParamIdList(paramIdList);
/* 30 */     setCommand("0x8106");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 35 */     UnitPackJT808 pack = new UnitPackJT808(33030);
/* 36 */     pack.setMobileNum(getMobileNum());
/* 37 */     JT808MsgBody_0x8106 body = new JT808MsgBody_0x8106();
/* 38 */     List items = new ArrayList();
/* 39 */     for (Integer id : this.paramIdList) {
/* 40 */       JT808MsgBody_0x8103_param_item i = new JT808MsgBody_0x8103_param_item();
/* 41 */       i.setParamID(id.intValue());
/* 42 */       items.add(i);
/*    */     }
/* 44 */     body.setParamList(items);
/* 45 */     pack.setMsgBody(body);
/* 46 */     return pack;
/*    */   }
/*    */ 
/*    */   public List<Integer> getParamIdList() {
/* 50 */     return this.paramIdList;
/*    */   }
/*    */ 
/*    */   public void setParamIdList(List<Integer> paramIdList) {
/* 54 */     this.paramIdList = paramIdList;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.SelectedParameterQuery
 * JD-Core Version:    0.6.1
 */