/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpDisconnectReq_0x1003 extends DataPacketBodyPart
/*    */ {
/*    */   private int userId;
/*    */   private String password;
/*    */ 
/*    */   public int getUserId()
/*    */   {
/* 14 */     return this.userId;
/*    */   }
/*    */ 
/*    */   public void setUserId(int userId) {
/* 18 */     this.userId = userId;
/*    */   }
/*    */ 
/*    */   public String getPassword() {
/* 22 */     return this.password;
/*    */   }
/*    */ 
/*    */   public void setPassword(String password) {
/* 26 */     this.password = password;
/*    */   }
/*    */ 
/*    */   public byte[] buildBody() throws Exception
/*    */   {
/* 31 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 32 */     buffer.putInt(getUserId());
/* 33 */     buffer.put(ByteUtil.string2ByteArray(getPassword(), 8, "GBK"));
/* 34 */     buffer.flip();
/* 35 */     byte[] bytes = new byte[buffer.remaining()];
/* 36 */     buffer.get(bytes);
/* 37 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand()
/*    */   {
/* 42 */     return 4099;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes) throws Exception
/*    */   {
/* 47 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 48 */     setUserId(buffer.getInt());
/* 49 */     setPassword(buffer.getString(8, Constants.CharsetDecoder_GBK));
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.UpDisconnectReq_0x1003
 * JD-Core Version:    0.6.1
 */