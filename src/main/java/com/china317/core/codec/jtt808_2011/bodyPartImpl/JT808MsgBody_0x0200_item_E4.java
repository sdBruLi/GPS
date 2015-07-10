/*    */ package com.china317.core.codec.jtt808_2011.bodyPartImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.JT808MsgBody;
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import java.io.PrintStream;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class JT808MsgBody_0x0200_item_E4 extends JT808MsgBody
/*    */ {
/*    */   private int areaid;
/*    */   private long markid;
/*    */ 
/*    */   public void bulidBody()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void praseBody()
/*    */     throws Exception
/*    */   {
/* 18 */     this.areaid = this.bodyBuffer.getUnsignedShort();
/* 19 */     this.markid = this.bodyBuffer.getUnsignedInt();
/* 20 */     this.bodyBuffer.rewind();
/*    */   }
/*    */ 
/*    */   public int getAreaid() {
/* 24 */     return this.areaid;
/*    */   }
/*    */ 
/*    */   public void setAreaid(int areaid) {
/* 28 */     this.areaid = areaid;
/*    */   }
/*    */ 
/*    */   public long getMarkid() {
/* 32 */     return this.markid;
/*    */   }
/*    */ 
/*    */   public void setMarkid(long markid) {
/* 36 */     this.markid = markid;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 40 */     byte[] array = ByteUtil.hexString2byteArray("E400D0000000");
/*    */ 
/* 49 */     IoBuffer bb = IoBuffer.wrap(array);
/* 50 */     System.out.println(bb.getUnsigned());
/* 51 */     System.out.println(bb.position());
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200_item_E4
 * JD-Core Version:    0.6.1
 */