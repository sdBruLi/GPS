/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.messageImpl;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*    */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8700;
/*    */ 
/*    */ public class DrivingRecordGatherMsg extends BaseDownMessage
/*    */ {
/*    */   public static final byte Record_Driver_Code_License = 1;
/*    */   public static final byte Record_Realtime_Clock = 2;
/*    */   public static final byte Record_360h_Total_Mileage = 3;
/*    */   public static final byte Record_CharacteristicCoefficients = 4;
/*    */   public static final byte Record_360h_Speed = 5;
/*    */   public static final byte Record_Vin_license_classification = 6;
/*    */   public static final byte Record_Accident_Doubtful = 7;
/*    */   public static final byte Record_2d_Total_Mileage = 8;
/*    */   public static final byte Record_2d_Speed = 9;
/*    */   public static final byte Record_2d_Driving_over3h_record = 17;
/*    */   private byte commandRecord;
/*    */ 
/*    */   public DrivingRecordGatherMsg(String mobileNum, String messageKey, byte commandRecord)
/*    */   {
/* 38 */     setCommand("0x8700");
/* 39 */     setCommandRecord(commandRecord);
/* 40 */     setMessageKey(messageKey);
/* 41 */     setMobileNum(mobileNum);
/*    */   }
/*    */ 
/*    */   public UnitPackJT808 pack() throws Exception
/*    */   {
/* 46 */     UnitPackJT808 pack = new UnitPackJT808(34560);
/* 47 */     pack.setMobileNum(getMobileNum());
/* 48 */     JT808MsgBody_0x8700 body = new JT808MsgBody_0x8700();
/* 49 */     body.setCommand(getCommandRecord());
/* 50 */     pack.setMsgBody(body);
/* 51 */     return pack;
/*    */   }
/*    */ 
/*    */   public byte getCommandRecord() {
/* 55 */     return this.commandRecord;
/*    */   }
/*    */ 
/*    */   public void setCommandRecord(byte commandRecord)
/*    */   {
/* 60 */     this.commandRecord = commandRecord;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.DrivingRecordGatherMsg
 * JD-Core Version:    0.6.1
 */