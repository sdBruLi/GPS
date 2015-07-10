/*    */ package com.china317.core.codec.jtt809_2011;
/*    */ 
/*    */ import java.nio.charset.Charset;
/*    */ import java.nio.charset.CharsetDecoder;
/*    */ import java.nio.charset.CharsetEncoder;
/*    */ 
/*    */ public final class Constants
/*    */ {
/*    */   public static final byte HeadFlag = 91;
/*    */   public static final int HeadFlagByteSize = 1;
/*    */   public static final byte HeadFlagEscape = 90;
/*    */   public static final byte EndFlag = 93;
/*    */   public static final byte EndFlagEscape = 94;
/*    */   public static final int EndFlagByteSize = 1;
/*    */   public static final byte EscapeSuffix1 = 1;
/*    */   public static final byte EscapeSuffix2 = 2;
/*    */   public static final int CRCCodeByteSize = 2;
/*    */   public static final int DataHeadByteSize = 22;
/*    */   public static final int COMMAND_UNKONWN = -1;
/*    */   public static final String CharsetName_GBK = "GBK";
/* 27 */   public static final Charset Charset_GBK = Charset.forName("GBK");
/*    */ 
/* 29 */   public static final CharsetEncoder CharsetEncoder_GBK = Charset_GBK.newEncoder();
/* 30 */   public static final CharsetDecoder CharsetDecoder_GBK = Charset_GBK.newDecoder();
/*    */   public static final String ProtocolName = "JTT809";
/*    */   public static final String ProtocolVersion = "2011";
/*    */   public static final int COMMAND_NO_Child = 0;
/*    */   public static final int COMMAND_UP_0x1001 = 4097;
/*    */   public static final int COMMAND_UP_0x1002 = 4098;
/*    */   public static final int COMMAND_UP_0x1003 = 4099;
/*    */   public static final int COMMAND_UP_0x1004 = 4100;
/*    */   public static final int COMMAND_UP_0x1005 = 4101;
/*    */   public static final int COMMAND_UP_0x1006 = 4102;
/*    */   public static final int COMMAND_UP_0x1007 = 4103;
/*    */   public static final int COMMAND_UP_0x1008 = 4104;
/*    */   public static final int COMMAND_DOWN_0x9001 = 36865;
/*    */   public static final int COMMAND_DOWN_0x9002 = 36866;
/*    */   public static final int COMMAND_DOWN_0x9003 = 36867;
/*    */   public static final int COMMAND_DOWN_0x9004 = 36868;
/*    */   public static final int COMMAND_DOWN_0x9005 = 36869;
/*    */   public static final int COMMAND_DOWN_0x9006 = 36870;
/*    */   public static final int COMMAND_DOWN_0x9007 = 36871;
/*    */   public static final int COMMAND_DOWN_0x9008 = 36872;
/*    */   public static final int COMMAND_DOWN_0x9101 = 37121;
/*    */   public static final int COMMAND_UP_0x1200 = 4608;
/*    */   public static final int COMMAND_UP_0x1201 = 4609;
/*    */   public static final int COMMAND_UP_0x1202 = 4610;
/*    */   public static final int COMMAND_UP_0x1203 = 4611;
/*    */   public static final int COMMAND_UP_0x1205 = 4613;
/*    */   public static final int COMMAND_UP_0x1206 = 4614;
/*    */   public static final int COMMAND_UP_0x1207 = 4615;
/*    */   public static final int COMMAND_UP_0x1208 = 4616;
/*    */   public static final int COMMAND_UP_0x1209 = 4617;
/*    */   public static final int COMMAND_UP_0x120A = 4618;
/*    */   public static final int COMMAND_UP_0x120B = 4619;
/*    */   public static final int COMMAND_UP_0x120C = 4620;
/*    */   public static final int COMMAND_UP_0x120D = 4621;
/*    */   public static final int COMMAND_DOWN_0x9200 = 37376;
/*    */   public static final int COMMAND_DOWN_0x9202 = 37378;
/*    */   public static final int COMMAND_DOWN_0x9203 = 37379;
/*    */   public static final int COMMAND_DOWN_0x9204 = 37380;
/*    */   public static final int COMMAND_DOWN_0x9205 = 37381;
/*    */   public static final int COMMAND_DOWN_0x9206 = 37382;
/*    */   public static final int COMMAND_DOWN_0x9207 = 37383;
/*    */   public static final int COMMAND_DOWN_0x9208 = 37384;
/*    */   public static final int COMMAND_DOWN_0x9209 = 37385;
/*    */   public static final int COMMAND_DOWN_0x920A = 37386;
/*    */   public static final int COMMAND_DOWN_0x920B = 37387;
/*    */   public static final int COMMAND_UP_0x1300 = 4864;
/*    */   public static final int COMMAND_UP_0x1301 = 4865;
/*    */   public static final int COMMAND_UP_0x1302 = 4866;
/*    */   public static final int COMMAND_DOWN_0x9300 = 37632;
/*    */   public static final int COMMAND_DOWN_0x9301 = 37633;
/*    */   public static final int COMMAND_DOWN_0x9302 = 37634;
/*    */   public static final int COMMAND_UP_0x1400 = 5120;
/*    */   public static final int COMMAND_UP_0x1401 = 5121;
/*    */   public static final int COMMAND_UP_0x1402 = 5122;
/*    */   public static final int COMMAND_UP_0x1403 = 5123;
/*    */   public static final int COMMAND_DOWN_0x9400 = 37888;
/*    */   public static final int COMMAND_DOWN_0x9401 = 37889;
/*    */   public static final int COMMAND_DOWN_0x9402 = 37890;
/*    */   public static final int COMMAND_DOWN_0x9403 = 37891;
/*    */   public static final int COMMAND_UP_0x1500 = 5376;
/*    */   public static final int COMMAND_UP_0x1501 = 5377;
/*    */   public static final int COMMAND_UP_0x1502 = 5378;
/*    */   public static final int COMMAND_UP_0x1503 = 5379;
/*    */   public static final int COMMAND_UP_0x1504 = 5380;
/*    */   public static final int COMMAND_UP_0x1505 = 5381;
/*    */   public static final int COMMAND_DOWN_0x9500 = 38144;
/*    */   public static final int COMMAND_DOWN_0x9501 = 38145;
/*    */   public static final int COMMAND_DOWN_0x9502 = 38146;
/*    */   public static final int COMMAND_DOWN_0x9503 = 38147;
/*    */   public static final int COMMAND_DOWN_0x9504 = 38148;
/*    */   public static final int COMMAND_DOWN_0x9505 = 38149;
/*    */   public static final int COMMAND_UP_0x1600 = 5632;
/*    */   public static final int COMMAND_UP_0x1601 = 5633;
/*    */   public static final int COMMAND_DOWN_0x9600 = 38400;
/*    */   public static final int COMMAND_DOWN_0x9601 = 38401;
/*    */   public static final int COMMAND_NO_DataType = 0;
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.Constants
 * JD-Core Version:    0.6.1
 */