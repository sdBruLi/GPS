/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class VehCharacteristicCoefficients
/*    */ {
/*    */   private int characteristicCoefficients;
/*    */ 
/*    */   public int getCharacteristicCoefficients()
/*    */   {
/*  9 */     return this.characteristicCoefficients;
/*    */   }
/*    */ 
/*    */   public void setCharacteristicCoefficients(int characteristicCoefficients) {
/* 13 */     this.characteristicCoefficients = characteristicCoefficients;
/*    */   }
/*    */   public void parse(byte[] datas) {
/* 16 */     this.characteristicCoefficients = (((datas[0] & 0xFF) << 16) + ((datas[1] & 0xFF) << 8) + (datas[2] & 0xFF));
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 21 */     return "CharacteristicCoefficients:" + this.characteristicCoefficients;
/*    */   }
/*    */ 
/*    */   public IoBuffer getBuffer() {
/* 25 */     IoBuffer buf = IoBuffer.allocate(3);
/* 26 */     buf.put((byte)(this.characteristicCoefficients >> 16 & 0xFF));
/* 27 */     buf.put((byte)(this.characteristicCoefficients >> 8 & 0xFF));
/* 28 */     buf.put((byte)(this.characteristicCoefficients & 0xFF));
/* 29 */     buf.flip();
/* 30 */     return buf;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.VehCharacteristicCoefficients
 * JD-Core Version:    0.6.1
 */