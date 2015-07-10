/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.CanData;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0705;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class CanDataUploadMessage extends BaseUpMessage
/*    */ {
/* 18 */   private static final Log log = LogFactory.getLog(CanDataUploadMessage.class);
/*    */   private List<CanData> datas;
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 23 */     unpackHeadPart(pack);
/*    */     try {
/* 25 */       JT808MsgBody_0x0705 body = (JT808MsgBody_0x0705)pack.getMsgBody();
/* 26 */       this.datas = body.getDatas();
/*    */     }
/*    */     catch (Exception e) {
/* 29 */       log.debug("unpack fail ", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public List<CanData> getDatas() {
/* 34 */     return this.datas;
/*    */   }
/*    */ 
/*    */   public void setDatas(List<CanData> datas) {
/* 38 */     this.datas = datas;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.CanDataUploadMessage
 * JD-Core Version:    0.6.1
 */