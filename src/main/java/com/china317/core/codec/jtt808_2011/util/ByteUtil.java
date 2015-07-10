/*     */ package com.china317.core.codec.jtt808_2011.util;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Calendar;

/*     */ import org.apache.mina.core.buffer.IoBuffer;


/*     */ public class ByteUtil
/*     */ {
/*  10 */   private static DecimalFormat DF00 = new DecimalFormat("00");
/*     */   private static final int BIG_ENDIAN = -1;
/*     */   private static final int LITTLE_ENDIAN = 1;
/*  13 */   private static String defaultSeparator = "";
/*  14 */   private static char[] HexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */   public static void getBytes(byte[] buff, byte var) {
/*  17 */     int size = buff.length;
/*  18 */     buff[(size - 1)] = var;
/*     */   }
/*     */ 
/*     */   public static void getBytes(byte[] b, Calendar cal) {
/*  22 */     b[0] = (byte)(cal.get(1) - 2000);
/*  23 */     b[1] = (byte)(cal.get(2) + 1);
/*  24 */     b[2] = (byte)cal.get(5);
/*  25 */     b[3] = (byte)cal.get(11);
/*  26 */     b[4] = (byte)cal.get(12);
/*  27 */     b[5] = (byte)cal.get(13);
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(Calendar cal) {
/*  31 */     byte[] b = new byte[6];
/*  32 */     b[0] = (byte)(cal.get(1) - 2000);
/*  33 */     b[1] = (byte)(cal.get(2) + 1);
/*  34 */     b[2] = (byte)cal.get(5);
/*  35 */     b[3] = (byte)cal.get(11);
/*  36 */     b[4] = (byte)cal.get(12);
/*  37 */     b[5] = (byte)cal.get(13);
/*  38 */     return b;
/*     */   }
/*     */ 
/*     */   public static void getBytes(byte[] buff, short var) {
/*  42 */     int size = buff.length;
/*  43 */     for (int i = 0; i < size; i++)
/*  44 */       buff[i] = (byte)(var >> 8 * (size - i - 1));
/*     */   }
/*     */ 
/*     */   public static void getBytes(byte[] buff, int var)
/*     */   {
/*  49 */     int size = buff.length;
/*  50 */     for (int i = 0; i < size; i++)
/*  51 */       buff[i] = (byte)(var >> 8 * (size - i - 1));
/*     */   }
/*     */ 
/*     */   public static void getBytes(byte[] buff, long var)
/*     */   {
/*  56 */     int size = buff.length;
/*  57 */     for (int i = 0; i < size; i++)
/*  58 */       buff[i] = (byte)(int)(var >> 8 * (size - i - 1));
/*     */   }
/*     */ 
/*     */   public static void getBytes(byte[] buff, String str)
/*     */   {
/*  63 */     byte[] b1 = str.getBytes();
/*  64 */     if (buff == null) {
/*  65 */       buff = new byte[b1.length + 1];
/*     */     }
/*  67 */     for (int i = 0; i < buff.length; i++)
/*  68 */       if (i < b1.length)
/*  69 */         buff[i] = b1[i];
/*     */       else
/*  71 */         buff[i] = 0;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(String str, int byteSize)
/*     */   {
/*  77 */     byte[] buff = new byte[byteSize];
/*  78 */     getBytes(buff, str);
/*  79 */     return buff;
/*     */   }
/*     */ 
/*     */   public static byte[] hexString2byteArray(String hexString)
/*     */   {
/*  89 */     if (hexString == null) {
/*  90 */       return null;
/*     */     }
/*  92 */     if (hexString.length() == 0) {
/*  93 */       return null;
/*     */     }
/*  95 */     String temp = hexString.replaceAll(" ", "").toUpperCase();
/*  96 */     if (temp.length() % 2 != 0) {
/*  97 */       return null;
/*     */     }
/*  99 */     byte[] b = new byte[temp.length() / 2];
/* 100 */     for (int i = 0; i < b.length; i++) {
/* 101 */       int ch1 = temp.charAt(i * 2) - '0';
/* 102 */       int ch2 = temp.charAt(i * 2 + 1) - '0';
/* 103 */       if (ch1 > 10) {
/* 104 */         ch1 -= 7;
/*     */       }
/* 106 */       if (ch2 > 10) {
/* 107 */         ch2 -= 7;
/*     */       }
/* 109 */       ch1 = ch1 * 16 + ch2;
/* 110 */       b[i] = (byte)(ch1 & 0xFF);
/*     */     }
/* 112 */     return b;
/*     */   }
/*     */ 
/*     */   public static String getHexString(byte[] bytearray)
/*     */   {
/* 122 */     return getHexString(bytearray, 0, bytearray.length);
/*     */   }
/*     */ 
/*     */   public static String getHexStringWrap(byte[] bytearray)
/*     */   {
/* 134 */     return getHexString(bytearray, 0, bytearray.length, " ", true);
/*     */   }
/*     */ 
/*     */   public static String getHexString(byte[] bytearray, String separator, boolean wrap)
/*     */   {
/* 148 */     return getHexString(bytearray, 0, bytearray.length, separator, wrap);
/*     */   }
/*     */ 
/*     */   public static String getHexString(byte[] bytearray, int from, int len)
/*     */   {
/* 162 */     return getHexString(bytearray, from, len, defaultSeparator, false);
/*     */   }
/*     */ 
/*     */   public static String getHexString(byte[] bytearray, int from, int len, String separator, boolean wrap)
/*     */   {
/* 180 */     if (bytearray == null) {
/* 181 */       return "";
/*     */     }
/* 183 */     StringBuffer rtn = new StringBuffer();
/* 184 */     for (int i = from; i < from + len; i++) {
/* 185 */       rtn.append(HexChars[(bytearray[i] >> 4 & 0xF)]);
/* 186 */       rtn.append(HexChars[(bytearray[i] & 0xF)]);
/* 187 */       rtn.append(separator);
/* 188 */       if ((wrap) && 
/* 189 */         ((i - from) % 16 == 15)) {
/* 190 */         rtn.append('\n');
/*     */       }
/*     */     }
/*     */ 
/* 194 */     return rtn.toString();
/*     */   }
/*     */ 
/*     */   public static String getHexString(byte b)
/*     */   {
/* 204 */     return String.valueOf(HexChars[(b >> 4 & 0xF)] + HexChars[(b & 0xF)]);
/*     */   }
/*     */ 
/*     */   public static String getHexString(IoBuffer bytearray) {
/* 208 */     if (bytearray == null) {
/* 209 */       return "";
/*     */     }
/* 211 */     StringBuffer rtn = new StringBuffer();
/* 212 */     int len = bytearray.remaining();
/* 213 */     while (bytearray.hasRemaining()) {
/* 214 */       byte b = bytearray.get();
/* 215 */       rtn.append(HexChars[(b >> 4 & 0xF)]);
/* 216 */       rtn.append(HexChars[(b & 0xF)]);
/*     */     }
/* 218 */     bytearray.rewind();
/* 219 */     return rtn.toString();
/*     */   }
/*     */ 
/*     */   public static String getHexString(short b)
/*     */   {
/* 229 */     return getHexString((byte)(b >> 8)) + getHexString((byte)b);
/*     */   }
/*     */ 
/*     */   public static String getString(byte[] buff) throws Exception {
/* 233 */     return getString(buff, "GBK");
/*     */   }
/*     */ 
/*     */   public static String getString(byte[] buff, String charset) throws Exception {
/* 237 */     int start = 0;
/* 238 */     int len = 0;
/* 239 */     boolean has = false;
/* 240 */     for (int i = 0; i < buff.length; i++) {
/* 241 */       if (buff[i] == 0) {
/* 242 */         if (has)
/* 243 */           break;
/*     */       }
/*     */       else {
/* 246 */         if (!has) {
/* 247 */           has = true;
/* 248 */           start = i;
/*     */         }
/* 250 */         len = i - start + 1;
/*     */       }
/*     */     }
/* 253 */     if (len == 0) {
/* 254 */       return "";
/*     */     }
/* 256 */     return new String(buff, start, len, charset);
/*     */   }
/*     */ 
/*     */   public static String getVaribleString(ByteBuffer buff, int maxLen) throws Exception {
/* 260 */     byte[] temp = new byte[maxLen];
/*     */ 	int i;
/* 262 */     for (i = 0; 
/* 263 */       i < maxLen; i++) {
/* 264 */       byte b = buff.get();
/* 265 */       if (b == 0) {
/*     */         break;
/*     */       }
/* 268 */       temp[i] = b;
/*     */     }
/* 270 */     return new String(temp, 0, i, "GBK");
/*     */   }
/*     */ 
/*     */   public static byte[] getVaribleBytes(ByteBuffer buff, int maxLen) throws Exception {
/* 274 */     byte[] temp = new byte[maxLen];
/*     */ int i;
/* 276 */     for (i = 0; 
/* 277 */       i < maxLen; i++) {
/* 278 */       byte b = buff.get();
/* 279 */       if (b == 0) {
/*     */         break;
/*     */       }
/* 282 */       temp[i] = b;
/*     */     }
/* 284 */     byte[] value = new byte[i];
/* 285 */     System.arraycopy(temp, 0, value, 0, i);
/* 286 */     return value;
/*     */   }
/*     */ 
/*     */   public static Calendar toCalendarValue(byte[] bytes) {
/* 290 */     Calendar date = Calendar.getInstance();
/* 291 */     date.set(2000 + bytes[0], bytes[1] - 1, bytes[2], bytes[3], bytes[4], bytes[5]);
/* 292 */     return date;
/*     */   }
/*     */ 
/*     */   public static int toUIntValue(byte b) {
/* 296 */     return b & 0xFF;
/*     */   }
/*     */ 
/*     */   public static int toUIntValue(byte[] b, int endian)
/*     */   {
/* 303 */     return toUIntValue(b, 0, b.length, endian);
/*     */   }
/*     */ 
/*     */   public static int toUIntValue(byte[] b, int from, int len, int endian)
/*     */   {
/* 310 */     int temp = 0;
/* 311 */     for (int i = 0; i < len; i++) {
/* 312 */       if (-1 == endian)
/* 313 */         temp += (toUIntValue(b[(from + i)]) << 8 * (len - 1 - i));
/*     */       else {
/* 315 */         temp += (toUIntValue(b[(from + i)]) << 8 * i);
/*     */       }
/*     */     }
/* 318 */     return temp;
/*     */   }
/*     */ 
/*     */   public static int toIntValue(byte[] b, int endian) {
/* 322 */     return toIntValue(b, 0, b.length, endian);
/*     */   }
/*     */ 
/*     */   public static int toIntValue(byte[] b, int from, int len, int endian) {
/* 326 */     int temp = 0;
/* 327 */     int bb = 0;
/* 328 */     for (int i = 0; i < len; i++) {
/* 329 */       if (-1 == endian) {
/* 330 */         bb = i == 0 ? b[(from + i)] : toUIntValue(b[(from + i)]);
/* 331 */         temp += (bb << 8 * (len - 1 - i));
/*     */       } else {
/* 333 */         bb = i == len - 1 ? b[(from + i)] : toUIntValue(b[(from + i)]);
/* 334 */         temp += (bb << 8 * i);
/*     */       }
/*     */     }
/* 337 */     return temp;
/*     */   }
/*     */ 
/*     */   public static long toLongValue(byte[] b) {
/* 341 */     return toLongValue(b, 1);
/*     */   }
/*     */ 
/*     */   public static long toLongValue(byte[] b, int endian) {
/* 345 */     long temp = 0L;
/* 346 */     int len = b.length;
/* 347 */     for (int i = 0; i < len; i++) {
/* 348 */       if (-1 == endian)
/* 349 */         temp += toUIntValue(b[i]) << 8 * (len - 1 - i);
/*     */       else {
/* 351 */         temp += toUIntValue(b[i]) << 8 * i;
/*     */       }
/*     */     }
/* 354 */     return temp;
/*     */   }
/*     */ 
/*     */   public static long BCD2Long(byte[] bcdBytes)
/*     */   {
/* 364 */     return Long.parseLong(getHexString(bcdBytes));
/*     */   }
/*     */ 
/*     */   public static byte[] string2BCD(String string)
/*     */   {
/* 374 */     if (string.length() % 2 > 0) {
/* 375 */       string = "0" + string;
/*     */     }
/* 377 */     return hexString2byteArray(string);
/*     */   }
/*     */ 
/*     */   public static void string2BCD(String string, byte[] desc)
/*     */   {
/* 387 */     byte[] bb = string2BCD(string);
/* 388 */     System.arraycopy(bb, 0, desc, desc.length - bb.length, bb.length);
/*     */   }
/*     */ 
/*     */   public static byte[] string2BCD(String string, int bcdSize)
/*     */   {
/* 399 */     byte[] desc = new byte[bcdSize];
/* 400 */     string2BCD(string, desc);
/* 401 */     return desc;
/*     */   }
/*     */ 
/*     */   public static byte[] long2BCD(long value)
/*     */   {
/* 411 */     return string2BCD(String.valueOf(value));
/*     */   }
/*     */ 
/*     */   public static byte[] long2BCD(long value, int bcdSize)
/*     */   {
/* 422 */     return string2BCD(String.valueOf(value), bcdSize);
/*     */   }
/*     */ 
/*     */   public static void int2BCD(long value, byte[] desc)
/*     */   {
/* 432 */     string2BCD(String.valueOf(value), desc);
/*     */   }
/*     */ 
/*     */   public static byte[] lat2bytes(int lat) {
/* 436 */     byte[] bytes = new byte[4];
/* 437 */     int temp = lat;
/* 438 */     bytes[0] = (byte)(temp / 1000000);
/* 439 */     temp = lat % 1000000;
/* 440 */     bytes[1] = (byte)(temp / 10000);
/* 441 */     temp = lat % 10000;
/* 442 */     bytes[2] = (byte)(temp / 256);
/* 443 */     bytes[3] = (byte)(temp % 256);
/* 444 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] vpuPositionBytes(int p) {
/* 448 */     byte[] bytes = new byte[4];
/* 449 */     DecimalFormat format = new DecimalFormat("#0.000000");
/* 450 */     double dLa = p;
/*     */ 
/* 452 */     dLa = Double.parseDouble(format.format(dLa / 1000000.0D));
/*     */ 
/* 454 */     int la_1 = (int)Math.floor(Math.abs(dLa));
/* 455 */     bytes[0] = (byte)la_1;
/* 456 */     double tempLa = Double.parseDouble(format.format(dLa - la_1));
/*     */ 
/* 458 */     tempLa *= 60.0D;
/* 459 */     int la_2 = (int)Math.floor(Math.abs(tempLa));
/* 460 */     bytes[1] = (byte)la_2;
/*     */ 
/* 462 */     tempLa = Double.parseDouble(format.format(tempLa - la_2));
/*     */ 
/* 464 */     short la_3 = (short)(int)(tempLa * 10000.0D);
/* 465 */     bytes[2] = (byte)(la_3 >> 8 & 0xFF);
/* 466 */     bytes[3] = (byte)(la_3 & 0xFF);
/*     */ 
/* 468 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytesAddZero2Bigendian(String str, int byteSize)
/*     */   {
/* 479 */     byte[] buff = new byte[byteSize];
/* 480 */     byte[] b1 = str.getBytes();
/* 481 */     if (buff == null) {
/* 482 */       buff = new byte[b1.length + 1];
/*     */     }
/* 484 */     int flag = buff.length - b1.length;
/* 485 */     for (int i = 0; i < buff.length; i++) {
/* 486 */       if (i >= flag)
/* 487 */         buff[i] = b1[(i - flag)];
/*     */       else {
/* 489 */         buff[i] = 0;
/*     */       }
/*     */     }
/* 492 */     return buff;
/*     */   }
/*     */ 
/*     */   public static byte[] encodeBCDAppendZero2Bigendian(String src, int byteSize)
/*     */   {
/* 503 */     if (src.length() % 2 != 0)
/* 504 */       src = '0' + src;
/* 505 */     byte[] result = new byte[byteSize];
/* 506 */     int flag = byteSize - src.length() / 2;
/* 507 */     for (int i = 0; i < result.length; i++) {
/* 508 */       if (i >= flag) {
/* 509 */         String s = src.substring(2 * (i - flag), 2 * (i - flag + 1));
/* 510 */         result[i] = (byte)Integer.parseInt(s, 16);
/*     */       } else {
/* 512 */         result[i] = 0;
/*     */       }
/*     */     }
/* 515 */     return result;
/*     */   }
/*     */ 
/*     */   public static int getIntValueFromHexBCD(byte[] s) {
/* 519 */     return Integer.parseInt(getHexString(s), 16);
/*     */   }
/*     */ 
/*     */   public static String getHexStringCutBigendianZero(byte[] bytearray) {
/* 523 */     if (bytearray == null) {
/* 524 */       return "";
/*     */     }
/* 526 */     StringBuffer rtn = new StringBuffer();
/* 527 */     for (int i = 0; i < bytearray.length; i++) {
/* 528 */       rtn.append(HexChars[(bytearray[i] >> 4 & 0xF)]);
/* 529 */       rtn.append(HexChars[(bytearray[i] & 0xF)]);
/*     */     }
/* 531 */     while (rtn.charAt(0) == '0') {
/* 532 */       rtn.deleteCharAt(0);
/*     */     }
/* 534 */     return rtn.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.util.ByteUtil
 * JD-Core Version:    0.6.1
 */