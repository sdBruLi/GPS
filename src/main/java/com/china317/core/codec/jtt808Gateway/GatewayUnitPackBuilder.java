/*    */ package com.china317.core.codec.jtt808Gateway;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class GatewayUnitPackBuilder
/*    */ {
/* 10 */   private static int MAX_MSG_BODY_LENGTH = 4096;
/*    */ 
/*    */   public static IoBuffer buildPacket(GatewayUnitPack pack) throws Exception {
/* 13 */     IoBuffer packetBuffer = IoBuffer.allocate(128).setAutoExpand(true);
/* 14 */     if (check(pack)) {
/* 15 */       packetBuffer.put((byte)-86);
/* 16 */       packetBuffer.put((byte)-18);
/* 17 */       packetBuffer.putUnsignedShort(pack.getMsgBodyLength());
/* 18 */       packetBuffer.putUnsignedShort(pack.getCMD());
/* 19 */       packetBuffer.putUnsignedShort(pack.getSequenceNum());
/* 20 */       if (pack.getMsgBodyLength() > 0) {
/* 21 */         packetBuffer.put(pack.getMsgBodyBuffer());
/*    */       }
/* 23 */       int pos = packetBuffer.position();
/* 24 */       packetBuffer.rewind();
/* 25 */       byte chk = packetBuffer.get();
/* 26 */       for (int i = 0; i < pos - 1; i++) {
/* 27 */         chk = (byte)(chk ^ packetBuffer.get());
/*    */       }
/* 29 */       packetBuffer.put(chk);
/* 30 */       packetBuffer.flip();
/*    */     }
/* 32 */     return packetBuffer.slice();
/*    */   }
/*    */ 
/*    */   public static boolean check(GatewayUnitPack pack) throws Exception {
/* 36 */     if (pack.getCMD() == 0) {
/* 37 */       throw new Exception("UnitPackMoc.msgID was not defined");
/*    */     }
/* 39 */     if ((pack.getMsgBodyBuffer() != null) && 
/* 40 */       (pack.getMsgBodyLength() > MAX_MSG_BODY_LENGTH)) {
/* 41 */       throw new Exception("UnitPackMoc.MsgBodyLength=" + pack.getMsgBodyLength() + " is over long ,maxBodyLength=" + MAX_MSG_BODY_LENGTH);
/*    */     }
/*    */ 
/* 44 */     return true;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808Gateway.GatewayUnitPackBuilder
 * JD-Core Version:    0.6.1
 */