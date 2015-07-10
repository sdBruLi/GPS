/*    */ package com.china317.core.codec.jtt808_2011;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UnitPackJT808Builder
/*    */ {
/* 13 */   private static int MAX_MSG_BODY_LENGTH = 2000;
/*    */ 
/*    */   public static IoBuffer buildPacket(UnitPackJT808 pack) throws Exception {
/* 16 */     IoBuffer packetBuffer = IoBuffer.allocate(128).setAutoExpand(true);
/* 17 */     if (check(pack)) {
/* 18 */       packetBuffer.putUnsignedShort(pack.getMsgID());
/* 19 */       int msgBodyAttribute = pack.getMsgBodyLength() | pack.getEncrypt() << 10;
/* 20 */       msgBodyAttribute |= pack.getPacket() << 13;
/* 21 */       packetBuffer.putUnsignedShort(msgBodyAttribute);
/* 22 */       byte[] temp = ByteUtil.string2BCD(pack.getMobileNum(), 6);
/* 23 */       packetBuffer.put(temp);
/* 24 */       packetBuffer.putUnsignedShort(pack.getSequenceNum());
/* 25 */       if (pack.isPacket()) {
/* 26 */         packetBuffer.putUnsignedShort(pack.getMsgPacketCount());
/* 27 */         packetBuffer.putUnsignedShort(pack.getMsgPacketNum());
/*    */       }
/* 29 */       if (pack.getMsgBodyLength() > 0) {
/* 30 */         if (pack.getEncrypt() == 0) {
/* 31 */           packetBuffer.put(pack.getMsgBodyBuffer());
/* 32 */           pack.getMsgBodyBuffer().rewind(); } else {
/* 33 */           pack.getEncrypt();
/*    */         }
/*    */       }
/*    */ 
/* 37 */       int pos = packetBuffer.position();
/* 38 */       packetBuffer.rewind();
/* 39 */       byte chk = packetBuffer.get();
/* 40 */       for (int i = 0; i < pos - 1; i++) {
/* 41 */         chk = (byte)(chk ^ packetBuffer.get());
/*    */       }
/* 43 */       packetBuffer.put(chk);
/* 44 */       packetBuffer.flip();
/*    */     }
/* 46 */     return packetBuffer.slice();
/*    */   }
/*    */ 
/*    */   public static boolean check(UnitPackJT808 pack) throws Exception {
/* 50 */     if (pack.getMsgID() == 0) {
/* 51 */       throw new Exception("UnitPackMoc.msgID was not defined");
/*    */     }
/* 53 */     if (pack.getMobileNum().length() == 0) {
/* 54 */       throw new Exception("UnitPackMoc.MobileNum was not defined");
/*    */     }
/* 56 */     if ((pack.getMsgBodyBuffer() != null) && 
/* 57 */       (pack.getMsgBodyLength() > MAX_MSG_BODY_LENGTH)) {
/* 58 */       throw new Exception("UnitPackMoc.MsgBodyLength=" + pack.getMsgBodyLength() + " is over long ,maxBodyLength=" + MAX_MSG_BODY_LENGTH);
/*    */     }
/*    */ 
/* 61 */     return true;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 65 */     UnitPackJT808 pack = new UnitPackJT808(1);
/* 66 */     pack.setMobileNum("130");
/* 67 */     byte[] bb = { 1, 2, 3, 3, 3 };
/* 68 */     pack.setMsgBody(bb);
/*    */     try {
/* 70 */       IoBuffer buff = buildPacket(pack);
/*    */ 
/* 74 */       pack = UnitPackJT808Praser.prasePacket(buff);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/*    */       UnitPackJT808 pack0;
/* 78 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.UnitPackJT808Builder
 * JD-Core Version:    0.6.1
 */