/*    */ package com.china317.core.codec.jtt809_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt809_2011.Constants;
/*    */ import com.china317.core.codec.jtt809_2011.DataPacketBodyPart;
/*    */ import com.china317.core.util.ByteUtil;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class UpConnectReq_0x1001 extends DataPacketBodyPart
/*    */ {
/*    */   private long userId;
/*    */   private String password;
/*    */   private String downLinkIp;
/*    */   private int downLinkPort;
/*    */ 
/*    */   public long getUserId()
/*    */   {
/* 17 */     return this.userId;
/*    */   }
/*    */ 
/*    */   public void setUserId(long userId) {
/* 21 */     this.userId = userId;
/*    */   }
/*    */ 
/*    */   public String getPassword() {
/* 25 */     return this.password;
/*    */   }
/*    */ 
/*    */   public void setPassword(String password) {
/* 29 */     this.password = password;
/*    */   }
/*    */ 
/*    */   public String getDownLinkIp() {
/* 33 */     return this.downLinkIp;
/*    */   }
/*    */ 
/*    */   public void setDownLinkIp(String downLinkIp) {
/* 37 */     this.downLinkIp = downLinkIp;
/*    */   }
/*    */ 
/*    */   public int getDownLinkPort() {
/* 41 */     return this.downLinkPort;
/*    */   }
/*    */ 
/*    */   public void setDownLinkPort(int downLinkPort) {
/* 45 */     this.downLinkPort = downLinkPort;
/*    */   }
/*    */ 
/*    */   public void parseBody(byte[] bytes)
/*    */     throws Exception
/*    */   {
/* 52 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/* 53 */     setUserId(buffer.getUnsignedInt());
/* 54 */     setPassword(buffer.getString(8, Constants.CharsetDecoder_GBK));
/* 55 */     setDownLinkIp(buffer.getString(32, Constants.CharsetDecoder_GBK));
/* 56 */     setDownLinkPort(buffer.getUnsignedShort());
/*    */   }
/*    */ 
/*    */   public byte[] buildBody()
/*    */   {
/* 61 */     IoBuffer buffer = IoBuffer.allocate(64).setAutoExpand(true);
/* 62 */     buffer.putUnsignedInt(getUserId());
/* 63 */     buffer.put(ByteUtil.string2ByteArray(getPassword(), 8, "GBK"));
/* 64 */     buffer.put(ByteUtil.string2ByteArray(getDownLinkIp(), 32, "GBK"));
/* 65 */     buffer.putUnsignedShort(getDownLinkPort());
/* 66 */     buffer.flip();
/* 67 */     byte[] bytes = new byte[buffer.remaining()];
/* 68 */     buffer.get(bytes);
/* 69 */     return bytes;
/*    */   }
/*    */ 
/*    */   public int getCommand() {
/* 73 */     return 4097;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 77 */     return "command=" + getCommand() + ",userId=" + this.userId + ", password=" + this.password + ", downLinkIp=" + this.downLinkIp + ", downLinkPort=" + this.downLinkPort;
/*    */   }
/*    */   public static void main(String[] args) throws Exception {
/* 80 */     UpConnectReq_0x1001 entity = new UpConnectReq_0x1001();
/* 81 */     entity.setUserId(1L);
/* 82 */     entity.setPassword("111");
/* 83 */     entity.setDownLinkIp("192.168.200.3");
/* 84 */     entity.setDownLinkPort(22);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.UpConnectReq_0x1001
 * JD-Core Version:    0.6.1
 */