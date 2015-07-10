/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DownCtrlMsgEmergencyMonitoringReq_0x9505 extends DownCtrlMsgHead
/*     */ {
/*     */   private byte[] authenticationCode;
/*     */   private String accessPointName;
/*     */   private String username;
/*     */   private String password;
/*     */   private String serverIp;
/*     */   private short tcpPort;
/*     */   private short udpPort;
/*     */   private long endTime;
/*     */ 
/*     */   public byte[] getAuthenticationCode()
/*     */   {
/*  20 */     return this.authenticationCode;
/*     */   }
/*     */ 
/*     */   public void setAuthenticationCode(byte[] authenticationCode) {
/*  24 */     this.authenticationCode = authenticationCode;
/*     */   }
/*     */ 
/*     */   public String getAccessPointName() {
/*  28 */     return this.accessPointName;
/*     */   }
/*     */ 
/*     */   public void setAccessPointName(String accessPointName) {
/*  32 */     this.accessPointName = accessPointName;
/*     */   }
/*     */ 
/*     */   public String getUsername() {
/*  36 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username) {
/*  40 */     this.username = username;
/*     */   }
/*     */ 
/*     */   public String getPassword() {
/*  44 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/*  48 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getServerIp() {
/*  52 */     return this.serverIp;
/*     */   }
/*     */ 
/*     */   public void setServerIp(String serverIp) {
/*  56 */     this.serverIp = serverIp;
/*     */   }
/*     */ 
/*     */   public short getTcpPort() {
/*  60 */     return this.tcpPort;
/*     */   }
/*     */ 
/*     */   public void setTcpPort(short tcpPort) {
/*  64 */     this.tcpPort = tcpPort;
/*     */   }
/*     */ 
/*     */   public short getUdpPort() {
/*  68 */     return this.udpPort;
/*     */   }
/*     */ 
/*     */   public void setUdpPort(short udpPort) {
/*  72 */     this.udpPort = udpPort;
/*     */   }
/*     */ 
/*     */   public long getEndTime() {
/*  76 */     return this.endTime;
/*     */   }
/*     */ 
/*     */   public void setEndTime(long endTime) {
/*  80 */     this.endTime = endTime;
/*     */   }
/*     */ 
/*     */   public DownCtrlMsgEmergencyMonitoringReq_0x9505()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DownCtrlMsgEmergencyMonitoringReq_0x9505(int msgId) {
/*  88 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  93 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  94 */     parseFirstBody(buffer);
/*  95 */     byte[] authenticationCode = new byte[10];
/*  96 */     buffer.get(authenticationCode);
/*  97 */     setAuthenticationCode(authenticationCode);
/*  98 */     setAccessPointName(buffer.getString(20, Constants.CharsetDecoder_GBK));
/*  99 */     setUsername(buffer.getString(49, Constants.CharsetDecoder_GBK));
/* 100 */     setPassword(buffer.getString(22, Constants.CharsetDecoder_GBK));
/* 101 */     setServerIp(buffer.getString(32, Constants.CharsetDecoder_GBK));
/* 102 */     setTcpPort(buffer.getShort());
/* 103 */     setUdpPort(buffer.getShort());
/* 104 */     setEndTime(buffer.getLong());
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/* 109 */     IoBuffer buffer = IoBuffer.allocate(100).setAutoExpand(true);
/* 110 */     setDataLength(145);
/* 111 */     buildFirstBody(buffer);
/* 112 */     buffer.put(getAuthenticationCode());
/* 113 */     buffer.put(ByteUtil.string2ByteArray(getAccessPointName(), 20, "GBK"));
/* 114 */     buffer.put(ByteUtil.string2ByteArray(getUsername(), 49, "GBK"));
/* 115 */     buffer.put(ByteUtil.string2ByteArray(getPassword(), 22, "GBK"));
/* 116 */     buffer.put(ByteUtil.string2ByteArray(getServerIp(), 32, "GBK"));
/* 117 */     buffer.putShort(getTcpPort());
/* 118 */     buffer.putShort(getUdpPort());
/* 119 */     buffer.putLong(getEndTime());
/* 120 */     buffer.flip();
/* 121 */     byte[] bytes = new byte[buffer.remaining()];
/* 122 */     buffer.get(bytes);
/* 123 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/* 128 */     return 38149;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 132 */     return super.toString() + ",authenticationCode=" + new String(this.authenticationCode) + 
/* 133 */       ",accessPointName=" + this.accessPointName + ",username=" + this.username + 
/* 134 */       ",password=" + this.password + ",serverIp=" + this.serverIp + ",tcpPort=" + this.tcpPort + 
/* 135 */       ",udpPort=" + this.udpPort + ",endTime=" + this.endTime;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/* 139 */     DownCtrlMsgEmergencyMonitoringReq_0x9505 entity = new DownCtrlMsgEmergencyMonitoringReq_0x9505();
/* 140 */     entity.setVehicleNo("沪A3804");
/* 141 */     entity.setVehicleColor((byte)1);
/* 142 */     entity.setDataType(1);
/*     */ 
/* 144 */     byte[] authenticationCode = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
/* 145 */     entity.setAuthenticationCode(authenticationCode);
/* 146 */     entity.setAccessPointName("12");
/* 147 */     entity.setUsername("user");
/* 148 */     entity.setPassword("pass");
/* 149 */     entity.setServerIp("127.0.0.1");
/* 150 */     entity.setTcpPort((short)77);
/* 151 */     entity.setUdpPort((short)88);
/* 152 */     entity.setEndTime(1234567890123L);
/*     */ 
/* 155 */     DownCtrlMsgEmergencyMonitoringReq_0x9505 entity2 = new DownCtrlMsgEmergencyMonitoringReq_0x9505();
/* 156 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgEmergencyMonitoringReq_0x9505
 * JD-Core Version:    0.6.1
 */