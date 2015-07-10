/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0500;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class VehControlResponseMsg extends BaseUpMessage
/*    */ {
/* 16 */   private static final Log log = LogFactory.getLog(VehControlResponseMsg.class);
/*    */   private short ackSeqnum;
/*    */   private PositionMessage position;
/*    */ 
/*    */   public VehControlResponseMsg()
/*    */   {
/* 21 */     setCommand("0x0500");
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack)
/*    */   {
/* 26 */     unpackHeadPart(pack);
/*    */     try {
/* 28 */       JT808MsgBody_0x0500 body = (JT808MsgBody_0x0500)pack.getMsgBody();
/* 29 */       setAckSeqnum(body.getAckSeqnum());
/* 30 */       if (body.getPostion() != null) {
/* 31 */         this.position = new PositionMessage();
/* 32 */         this.position.unpackBody(body.getPostion());
/*    */       }
/*    */     } catch (Exception e) {
/* 35 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public short getAckSeqnum() {
/* 40 */     return this.ackSeqnum;
/*    */   }
/*    */ 
/*    */   public void setAckSeqnum(short ackSeqnum)
/*    */   {
/* 45 */     this.ackSeqnum = ackSeqnum;
/*    */   }
/*    */ 
/*    */   public PositionMessage getPosition() {
/* 49 */     return this.position;
/*    */   }
/*    */ 
/*    */   public void setPosition(PositionMessage postion)
/*    */   {
/* 54 */     this.position = postion;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.VehControlResponseMsg
 * JD-Core Version:    0.6.1
 */