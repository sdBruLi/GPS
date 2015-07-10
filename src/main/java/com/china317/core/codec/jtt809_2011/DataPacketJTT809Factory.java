/*   */ package com.china317.core.codec.jtt809_2011;
/*   */ 
/*   */ public class DataPacketJTT809Factory
/*   */ {
/*   */   public static DataPacketJTT809 createDataPackeJTT809(int msgId, int childMsgId, int msgGnssCenterId)
/*   */   {
/* 5 */     DataPacketJTT809 pack = new DataPacketJTT809(new CodecConfig(), msgId, childMsgId);
/* 6 */     pack.getHeadPart().setMsgGnssCenterId(msgGnssCenterId);
/* 7 */     return pack;
/*   */   }
/*   */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.DataPacketJTT809Factory
 * JD-Core Version:    0.6.1
 */