/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8103;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8103_param_item;
/*    */ import com.china317.core.codec.jtt808_2011.util.DefaultCharset;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.mina.core.buffer.IoBuffer;
/*    */ 
/*    */ public class ParameterSetting extends BaseDownMessage
/*    */ {
/*    */   private byte paramCount;
/*    */   private List<ParameterItem> paramList;
/*    */ 
/*    */   public ParameterSetting(String mobileNum, String messageKey, List<ParameterItem> paramList)
/*    */   {
/* 25 */     setMobileNum(mobileNum);
/* 26 */     setMessageKey(messageKey);
/* 27 */     setParamCount((byte)paramList.size());
/* 28 */     setParamList(paramList);
/* 29 */     setCommand("0x8103");
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 34 */     UnitPackJT808 pack = new UnitPackJT808(33027);
/* 35 */     pack.setMobileNum(getMobileNum());
/* 36 */     JT808MsgBody_0x8103 body = new JT808MsgBody_0x8103();
/* 37 */     body.setParamCount(getParamCount());
/* 38 */     List items = new ArrayList();
/* 39 */     for (ParameterItem item : this.paramList) {
/* 40 */       JT808MsgBody_0x8103_param_item i = new JT808MsgBody_0x8103_param_item();
/* 41 */       i.setParamID(item.getParamId());
/* 42 */       i.setParamLen(item.getParamLen());
/* 43 */       i.setParamValue(getBuffer(item.getParamId(), item.getParamLen(), item.getValue()));
/* 44 */       items.add(i);
/*    */     }
/* 46 */     body.setParamList(items);
/* 47 */     pack.setMsgBody(body);
/* 48 */     return pack;
/*    */   }
/*    */ 
/*    */   private IoBuffer getBuffer(int paramID, byte len, Object value) throws Exception {
/* 52 */     IoBuffer buf = IoBuffer.allocate(1).setAutoExpand(true);
/*    */ 
/* 54 */     if ((paramID == 16) || (paramID == 17) || (paramID == 18) || 
/* 55 */       (paramID == 19) || (paramID == 20) || (paramID == 21) || 
/* 56 */       (paramID == 22) || (paramID == 23) || (paramID == 64) || 
/* 57 */       (paramID == 65) || (paramID == 66) || (paramID == 67) || 
/* 58 */       (paramID == 68) || (paramID == 72) || (paramID == 73) || 
/* 59 */       (paramID == 131)) {
/* 60 */       String line = (String)value;
/* 61 */       buf.putString(line, DefaultCharset.encoder);
/*    */     }
/* 63 */     else if ((paramID == 49) || (paramID == 129) || (paramID == 130)) {
/* 64 */       Short s = (Short)value;
/* 65 */       buf.putShort(s.shortValue());
/*    */     }
/* 67 */     else if (paramID == 132) {
/* 68 */       Byte b = (Byte)value;
/* 69 */       buf.put(b.byteValue());
/*    */     }
/*    */     else {
/* 72 */       Integer i = (Integer)value;
/* 73 */       buf.putInt(i.intValue());
/*    */     }
/*    */ 
/* 76 */     buf.flip();
/* 77 */     return buf;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ 
/*    */   public byte getParamCount() {
/* 85 */     return this.paramCount;
/*    */   }
/*    */ 
/*    */   public void setParamCount(byte paramCount)
/*    */   {
/* 90 */     this.paramCount = paramCount;
/*    */   }
/*    */ 
/*    */   public List<ParameterItem> getParamList() {
/* 94 */     return this.paramList;
/*    */   }
/*    */ 
/*    */   public void setParamList(List<ParameterItem> paramList)
/*    */   {
/* 99 */     this.paramList = paramList;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ParameterSetting
 * JD-Core Version:    0.6.1
 */