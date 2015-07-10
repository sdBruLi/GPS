/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8900;
/*    */ import com.china317.core.codec.jtt808_2011.x8900.F1MsgDataPack;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class TransDownMessage extends BaseDownMessage
/*    */ {
/* 19 */   private Log log = LogFactory.getLog(TransDownMessage.class);
/*    */   private byte transType;
/*    */   private IoBuffer dataBlock;
/*    */ 
/*    */   public TransDownMessage(String mobileNum, String messageKey, byte transType, IoBuffer data)
/*    */   {
/* 33 */     setMobileNum(mobileNum);
/* 34 */     setMessageKey(messageKey);
/* 35 */     setTransType(transType);
/* 36 */     setDataBlock(data);
/* 37 */     setCommand("0x8900");
/*    */   }
/*    */ 
/*    */   public TransDownMessage(String mobileNum, String messageKey, F1MsgDataPack pack) {
/*    */     try {
/* 42 */       setMobileNum(mobileNum);
/* 43 */       setMessageKey(messageKey);
/* 44 */       setTransType(pack.getTypeid());
/* 45 */       setDataBlock(pack.getData());
/* 46 */       setCommand("0x8900");
/*    */     } catch (Exception e) {
/* 48 */       this.log.error(e.toString(), e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public TransDownMessage()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 58 */     UnitPackJT808 pack = new UnitPackJT808(35072);
/* 59 */     pack.setMobileNum(getMobileNum());
/* 60 */     JT808MsgBody_0x8900 body = new JT808MsgBody_0x8900();
/* 61 */     body.setTransType(this.transType);
/* 62 */     body.setDataBlock(this.dataBlock);
/* 63 */     pack.setMsgBody(body);
/* 64 */     return pack;
/*    */   }
/*    */ 
/*    */   public void unpack(UnitPackJT808 pack) {
/*    */     try {
/* 69 */       JT808MsgBody_0x8900 body = (JT808MsgBody_0x8900)pack.getMsgBody();
/* 70 */       setTransType(body.getTransType());
/* 71 */       setDataBlock(body.getDataBlock());
/*    */     } catch (Exception e) {
/* 73 */       this.log.debug("unpack fail ", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public byte getTransType() {
/* 78 */     return this.transType;
/*    */   }
/*    */ 
/*    */   public void setTransType(byte transType)
/*    */   {
/* 83 */     this.transType = transType;
/*    */   }
/*    */ 
/*    */   public IoBuffer getDataBlock() {
/* 87 */     return this.dataBlock;
/*    */   }
/*    */ 
/*    */   public void setDataBlock(IoBuffer dataBlock)
/*    */   {
/* 92 */     this.dataBlock = dataBlock;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.TransDownMessage
 * JD-Core Version:    0.6.1
 */