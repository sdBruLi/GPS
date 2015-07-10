/*    */ package com.china317.core.codec.jtt809_2011;
/*    */ 
/*    */ import com.china317.core.util.ByteUtil;
/*    */ 
/*    */ public abstract class DataPacketBodyPart
/*    */ {
/*  6 */   private int dataType = 0;
/*    */ 
/*    */   public abstract void parseBody(byte[] paramArrayOfByte) throws Exception;
/*    */ 
/*    */   public abstract byte[] buildBody() throws Exception;
/*    */ 
/*    */   public abstract int getCommand();
/*    */ 
/* 11 */   public String toString() { return "command=" + ByteUtil.number2HexStr(getCommand(), 2); }
/*    */ 
/*    */   public short getDataType()
/*    */   {
/* 15 */     return (short)this.dataType;
/*    */   }
/*    */   public void setDataType(int dataType) {
/* 18 */     this.dataType = dataType;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.DataPacketBodyPart
 * JD-Core Version:    0.6.1
 */