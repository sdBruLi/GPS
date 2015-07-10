/*     */ package com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.Constants;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class DownCtrlMsgTextInfo_0x9503 extends DownCtrlMsgHead
/*     */ {
/*     */   private int msgSequence;
/*     */   private byte msgPriority;
/*     */   private int msgLength;
/*     */   private String msgContent;
/*     */ 
/*     */   public int getMsgSequence()
/*     */   {
/*  16 */     return this.msgSequence;
/*     */   }
/*     */ 
/*     */   public void setMsgSequence(int msgSequence) {
/*  20 */     this.msgSequence = msgSequence;
/*     */   }
/*     */ 
/*     */   public byte getMsgPriority() {
/*  24 */     return this.msgPriority;
/*     */   }
/*     */ 
/*     */   public void setMsgPriority(byte msgPriority) {
/*  28 */     this.msgPriority = msgPriority;
/*     */   }
/*     */ 
/*     */   public int getMsgLength() {
/*  32 */     return this.msgLength;
/*     */   }
/*     */ 
/*     */   public void setMsgLength(int msgLength) {
/*  36 */     this.msgLength = msgLength;
/*     */   }
/*     */ 
/*     */   public String getMsgContent() {
/*  40 */     return this.msgContent;
/*     */   }
/*     */ 
/*     */   public void setMsgContent(String msgContent) {
/*  44 */     this.msgContent = msgContent;
/*     */   }
/*     */ 
/*     */   public DownCtrlMsgTextInfo_0x9503()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DownCtrlMsgTextInfo_0x9503(int msgId) {
/*  52 */     setDataType(msgId);
/*     */   }
/*     */ 
/*     */   public void parseBody(byte[] bytes) throws Exception
/*     */   {
/*  57 */     IoBuffer buffer = IoBuffer.wrap(bytes);
/*  58 */     parseFirstBody(buffer);
/*  59 */     setMsgSequence(buffer.getInt());
/*  60 */     setMsgPriority(buffer.get());
/*  61 */     setMsgLength(buffer.getInt());
/*  62 */     setMsgContent(buffer.getString(getMsgLength(), Constants.CharsetDecoder_GBK));
/*     */   }
/*     */ 
/*     */   public byte[] buildBody()
/*     */   {
/*  67 */     IoBuffer buffer = IoBuffer.allocate(10).setAutoExpand(true);
/*  68 */     byte[] content = ByteUtil.string2ByteArrayWithMaxSize(getMsgContent(), 1024, "GBK");
/*  69 */     setMsgLength(content.length);
/*  70 */     setDataLength(9 + getMsgLength());
/*  71 */     buildFirstBody(buffer);
/*  72 */     buffer.putInt(getMsgSequence());
/*  73 */     buffer.put(getMsgPriority());
/*  74 */     buffer.putInt(getMsgLength());
/*  75 */     buffer.put(ByteUtil.string2ByteArray(getMsgContent(), getMsgLength(), "GBK"));
/*  76 */     buffer.flip();
/*  77 */     byte[] bytes = new byte[buffer.remaining()];
/*  78 */     buffer.get(bytes);
/*  79 */     return bytes;
/*     */   }
/*     */ 
/*     */   public int getCommand()
/*     */   {
/*  84 */     return 38147;
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  88 */     return super.toString() + ",msgSequence=" + this.msgSequence + 
/*  89 */       ",msgPriority=" + this.msgPriority + ",msgLength=" + this.msgLength + ",msgContent=" + this.msgContent;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws Exception {
/*  93 */     DownCtrlMsgTextInfo_0x9503 entity = new DownCtrlMsgTextInfo_0x9503();
/*  94 */     entity.setVehicleNo("沪A3804");
/*  95 */     entity.setVehicleColor((byte)1);
/*  96 */     entity.setDataType(1);
/*     */ 
/*  98 */     entity.setMsgSequence(1);
/*  99 */     entity.setMsgPriority((byte)1);
/*     */ 
/* 102 */     entity.setMsgContent("信息好xca");
/*     */ 
/* 105 */     DownCtrlMsgTextInfo_0x9503 entity2 = new DownCtrlMsgTextInfo_0x9503();
/* 106 */     entity2.parseBody(entity.buildBody());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgTextInfo_0x9503
 * JD-Core Version:    0.6.1
 */