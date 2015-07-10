/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0802;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0802_item;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class StoreMultiDataSearchResponseMsg extends BaseUpMessage
/*    */ {
/* 20 */   private static final Log log = LogFactory.getLog(StoreMultiDataSearchResponseMsg.class);
/*    */   private short ackSeqNum;
/*    */   private short multimediaItemCount;
/*    */   private List<MultiDataSearchItem> items;
/*    */ 
/*    */   public StoreMultiDataSearchResponseMsg()
/*    */   {
/* 26 */     setCommand("0x0802");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 31 */     unpackHeadPart(pack);
/*    */     try {
/* 33 */       JT808MsgBody_0x0802 body = (JT808MsgBody_0x0802)pack.getMsgBody();
/* 34 */       setAckSeqNum(body.getAckSeqNum());
/* 35 */       setMultimediaItemCount(body.getMultimediaItemCount());
/* 36 */       if (body.getItems() != null) {
/* 37 */         List itemList = new ArrayList();
/* 38 */         for (JT808MsgBody_0x0802_item i : body.getItems()) {
/* 39 */           MultiDataSearchItem item = new MultiDataSearchItem();
/* 40 */           item.setChannelID(i.getChannelID());
/* 41 */           item.setEventItemCoding(i.getEventItemCoding());
/* 42 */           PositionMessage position = new PositionMessage();
/* 43 */           position.unpackBody(i.getGpsData());
/* 44 */           item.setGpsData(position);
/* 45 */           item.setMultimediaID(i.getMultimediaID());
/* 46 */           item.setMultimediaType(i.getMultimediaType());
/* 47 */           itemList.add(item);
/*    */         }
/* 49 */         setItems(itemList);
/*    */       }
/*    */     }
/*    */     catch (Exception e) {
/* 53 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public short getAckSeqNum() {
/* 58 */     return this.ackSeqNum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqNum(short ackSeqNum)
/*    */   {
/* 63 */     this.ackSeqNum = ackSeqNum;
/*    */   }
/*    */ 
/*    */   public short getMultimediaItemCount() {
/* 67 */     return this.multimediaItemCount;
/*    */   }
/*    */ 
/*    */   public void setMultimediaItemCount(short multimediaItemCount)
/*    */   {
/* 72 */     this.multimediaItemCount = multimediaItemCount;
/*    */   }
/*    */ 
/*    */   public List<MultiDataSearchItem> getItems() {
/* 76 */     return this.items;
/*    */   }
/*    */ 
/*    */   public void setItems(List<MultiDataSearchItem> items)
/*    */   {
/* 81 */     this.items = items;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.StoreMultiDataSearchResponseMsg
 * JD-Core Version:    0.6.1
 */