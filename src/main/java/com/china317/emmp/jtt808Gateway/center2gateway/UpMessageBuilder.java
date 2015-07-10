/*    */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*    */ 
/*    */ import com.china317.core.base.UpMessage;
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.AuthenticationMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.BatchPositionMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ClientCommonResponseMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.CompressionDataUploadMsg;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.DeregisterMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.DriverInfoMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ElecFreightNoteMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.EventReportMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.HeartbeatMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.InfoOrderOrCancelMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.MultimediaEventMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ParameterQueryResponseMsg;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.PositionMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.PositionQueryResponseMsg;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.QuestionResponseMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.RegisterMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.StoreMultiDataSearchResponseMsg;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TerminalPropertyResponseMsg;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TerminalRSAMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TerminalUpdateResult;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TransUpMessage;
/*    */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.VehControlResponseMsg;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class UpMessageBuilder
/*    */ {
/* 36 */   private static final Log log = LogFactory.getLog(UpMessageBuilder.class);
/* 37 */   private static UpMessageBuilder instance = new UpMessageBuilder();
/*    */   private Map<Integer, Class> map;
/*    */ 
/*    */   private UpMessageBuilder()
/*    */   {
/* 41 */     this.map = new HashMap();
/* 42 */     this.map.put(Integer.valueOf(258), AuthenticationMessage.class);
/* 43 */     this.map.put(Integer.valueOf(3), DeregisterMessage.class);
/* 44 */     this.map.put(Integer.valueOf(256), RegisterMessage.class);
/* 45 */     this.map.put(Integer.valueOf(2), HeartbeatMessage.class);
/* 46 */     this.map.put(Integer.valueOf(1), ClientCommonResponseMessage.class);
/* 47 */     this.map.put(Integer.valueOf(512), PositionMessage.class);
/* 48 */     this.map.put(Integer.valueOf(260), ParameterQueryResponseMsg.class);
/* 49 */     this.map.put(Integer.valueOf(769), EventReportMessage.class);
/* 50 */     this.map.put(Integer.valueOf(770), QuestionResponseMessage.class);
/* 51 */     this.map.put(Integer.valueOf(1794), DriverInfoMessage.class);
/* 52 */     this.map.put(Integer.valueOf(513), PositionQueryResponseMsg.class);
/* 53 */     this.map.put(Integer.valueOf(771), InfoOrderOrCancelMessage.class);
/* 54 */     this.map.put(Integer.valueOf(1280), VehControlResponseMsg.class);
/* 55 */     this.map.put(Integer.valueOf(1793), ElecFreightNoteMessage.class);
/* 56 */     this.map.put(Integer.valueOf(2048), MultimediaEventMessage.class);
/* 57 */     this.map.put(Integer.valueOf(2050), StoreMultiDataSearchResponseMsg.class);
/* 58 */     this.map.put(Integer.valueOf(2304), TransUpMessage.class);
/* 59 */     this.map.put(Integer.valueOf(2305), CompressionDataUploadMsg.class);
/* 60 */     this.map.put(Integer.valueOf(2560), TerminalRSAMessage.class);
/* 61 */     this.map.put(Integer.valueOf(1796), BatchPositionMessage.class);
/* 62 */     this.map.put(Integer.valueOf(263), TerminalPropertyResponseMsg.class);
/* 63 */     this.map.put(Integer.valueOf(264), TerminalUpdateResult.class);
/*    */   }
/*    */ 
/*    */   public static UpMessageBuilder getInstance()
/*    */   {
/* 71 */     return UpMessageBuilderHolder.instance;
/*    */   }
/*    */ 
/*    */   public UpMessage buildMessage(UnitPackJT808 pack) {
/* 75 */     UpMessage upMessage = null;
/* 76 */     Class clazz = (Class)this.map.get(Integer.valueOf(pack.getMsgID()));
/* 77 */     if (clazz != null) {
/*    */       try {
/* 79 */         upMessage = (UpMessage)clazz.newInstance();
/* 80 */         upMessage.unpack(pack);
/*    */       } catch (Exception e) {
/* 82 */         log.debug("build UpMessage UnitPackJT808[" + pack.toString() + "] fail ", e);
/*    */       }
/*    */     }
/* 85 */     return upMessage;
/*    */   }
/*    */ 
/*    */   static class UpMessageBuilderHolder
/*    */   {
/* 67 */     static UpMessageBuilder instance = new UpMessageBuilder();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.UpMessageBuilder
 * JD-Core Version:    0.6.1
 */