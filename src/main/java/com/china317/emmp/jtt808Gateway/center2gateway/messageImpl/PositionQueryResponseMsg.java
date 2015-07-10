/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0201;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class PositionQueryResponseMsg extends BaseUpMessage
/*    */ {
/* 15 */   private static final Log log = LogFactory.getLog(PositionQueryResponseMsg.class);
/*    */   private short ackSeqnum;
/*    */   private PositionMessage position;
/*    */ 
/*    */   public PositionQueryResponseMsg()
/*    */   {
/* 20 */     setCommand("0x0201");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 25 */     unpackHeadPart(pack);
/*    */     try {
/* 27 */       JT808MsgBody_0x0201 body = (JT808MsgBody_0x0201)pack.getMsgBody();
/* 28 */       setAckSeqnum(body.getAckSeqnum());
/* 29 */       if (body.getPostion() != null) {
/* 30 */         this.position = new PositionMessage();
/* 31 */         this.position.unpackBody(body.getPostion());
/*    */       }
/*    */     } catch (Exception e) {
/* 34 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public short getAckSeqnum() {
/* 39 */     return this.ackSeqnum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqnum(short ackSeqnum)
/*    */   {
/* 44 */     this.ackSeqnum = ackSeqnum;
/*    */   }
/*    */ 
/*    */   public PositionMessage getPosition() {
/* 48 */     return this.position;
/*    */   }
/*    */ 
/*    */   public void setPosition(PositionMessage postion)
/*    */   {
/* 53 */     this.position = postion;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.PositionQueryResponseMsg
 * JD-Core Version:    0.6.1
 */