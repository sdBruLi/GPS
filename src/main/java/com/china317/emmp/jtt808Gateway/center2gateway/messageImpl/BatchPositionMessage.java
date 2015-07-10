/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0704;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class BatchPositionMessage extends BaseUpMessage
/*    */ {
/* 18 */   private static final Log log = LogFactory.getLog(BatchPositionMessage.class);
/*    */   private byte normal0blind1;
/*    */   private List<PositionMessage> pm200s;
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 24 */     unpackHeadPart(pack);
/*    */     try {
/* 26 */       JT808MsgBody_0x0704 body = (JT808MsgBody_0x0704)pack.getMsgBody();
/* 27 */       List data200s = body.getData200s();
/* 28 */       this.normal0blind1 = body.getNormal0blind1();
/*    */ 
/* 31 */       for (int i = 0; i < data200s.size(); i++) {
/* 32 */         JT808MsgBody_0x0200 d200 = (JT808MsgBody_0x0200)data200s.get(i);
/* 33 */         PositionMessage pm = new PositionMessage();
/* 34 */         pm.unpackBody(d200);
/*    */ 
/* 36 */         this.pm200s.add(pm);
/*    */       }
/*    */     }
/*    */     catch (Exception e) {
/* 40 */       log.debug("unpack fail ", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public byte getNormal0blind1() {
/* 45 */     return this.normal0blind1;
/*    */   }
/*    */ 
/*    */   public void setNormal0blind1(byte normal0blind1) {
/* 49 */     this.normal0blind1 = normal0blind1;
/*    */   }
/*    */ 
/*    */   public List<PositionMessage> getPm200s() {
/* 53 */     return this.pm200s;
/*    */   }
/*    */ 
/*    */   public void setPm200s(List<PositionMessage> pm200s) {
/* 57 */     this.pm200s = pm200s;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.BatchPositionMessage
 * JD-Core Version:    0.6.1
 */