/*     */ package com.china317.core.util;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class ByteUtil
/*     */ {
/*  13 */   private static final Log log = LogFactory.getLog(ByteUtil.class);
/*     */ 
/*     */   public static byte[] string2ByteArray(String source, int size, String charsetName)
/*     */   {
/*  27 */     byte[] bytes = new byte[size];
/*  28 */     byte[] tmp = (byte[])null;
/*     */ 
/*  30 */     if (source != null) {
/*     */       try {
/*  32 */         tmp = source.getBytes(charsetName);
/*     */       }
/*     */       catch (Exception e) {
/*  35 */         log.debug("", e);
/*     */       }
/*     */     }
/*     */ 
/*  39 */     int index = 0;
/*  40 */     index = 0;
/*     */     do { bytes[index] = tmp[index];
/*     */ 
/*  40 */       index++; if ((tmp == null) || (index >= tmp.length)) break;  } while (index < bytes.length);
/*     */ 
/*  43 */     while (index < bytes.length) {
/*  44 */       bytes[index] = 0;
/*  45 */       index++;
/*     */     }
/*     */ 
/*  48 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] string2ByteArrayWithMaxSize(String source, int maxSize, String charsetName)
/*     */   {
/*  63 */     byte[] bytes = new byte[0];
/*  64 */     byte[] tmp = (byte[])null;
/*     */     try {
/*  66 */       tmp = source.getBytes(charsetName);
/*     */     }
/*     */     catch (Exception e) {
/*  69 */       log.debug("", e);
/*     */     }
/*  71 */     if (tmp != null) {
/*  72 */       if (tmp.length <= maxSize) {
/*  73 */         bytes = tmp;
/*     */       } else {
/*  75 */         bytes = new byte[maxSize];
/*  76 */         int index = 0;
/*  77 */         for (index = 0; index < bytes.length; index++) {
/*  78 */           bytes[index] = tmp[index];
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  83 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] string2ByteArray(String source, String charsetName)
/*     */   {
/*  96 */     return string2ByteArrayWithMaxSize(source, 2147483647, charsetName);
/*     */   }
/*     */ 
/*     */   public static byte[] mergeByteArray(byte[][] byteArrays) {
/* 100 */     IoBuffer buffer = IoBuffer.allocate(1024).setAutoExpand(true);
/* 101 */     byte[][] arrayOfByte = byteArrays; int j = byteArrays.length; for (int i = 0; i < j; i++) { byte[] byteArray = arrayOfByte[i];
/* 102 */       buffer.put(byteArray);
/*     */     }
/* 104 */     buffer.flip();
/* 105 */     byte[] bytes = new byte[buffer.remaining()];
/* 106 */     buffer.get(bytes);
/* 107 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static String byteArray2HexDump(byte[] src, int offset, int length) {
/* 111 */     IoBuffer buffer = IoBuffer.allocate(length).setAutoExpand(true);
/* 112 */     buffer.put(src, offset, length);
/* 113 */     buffer.flip();
/* 114 */     return buffer.getHexDump();
/*     */   }
/*     */ 
/*     */   public static String byteArray2HexDump(byte[] src) {
/* 118 */     return byteArray2HexDump(src, 0, src.length);
/*     */   }
/*     */ 
/*     */   public static byte[] hexDump2ByteArray(String src) {
/* 122 */     if (src == null) {
/* 123 */       return null;
/*     */     }
/* 125 */     if (src.length() == 0) {
/* 126 */       return null;
/*     */     }
/* 128 */     String[] strArray = src.toUpperCase().split(" ");
/* 129 */     IoBuffer buffer = IoBuffer.allocate(strArray.length).setAutoExpand(true);
/*     */ 
/* 131 */     for (int i = 0; i < strArray.length; i++) {
/* 132 */       if (strArray[i].length() != 2) break;
/* 133 */       int ch1 = strArray[i].charAt(0) - '0';
/* 134 */       int ch2 = strArray[i].charAt(1) - '0';
/* 135 */       if (ch1 > 10) {
/* 136 */         ch1 -= 7;
/*     */       }
/* 138 */       if (ch2 > 10) {
/* 139 */         ch2 -= 7;
/*     */       }
/* 141 */       ch1 = ch1 * 16 + ch2;
/* 142 */       buffer.put((byte)(ch1 & 0xFF));
/*     */     }
/*     */ 
/* 148 */     buffer.flip();
/* 149 */     byte[] bytes = new byte[buffer.remaining()];
/* 150 */     buffer.get(bytes);
/* 151 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] number2Bytes(long number, int length) {
/* 155 */     byte[] bytes = new byte[length];
/* 156 */     for (int i = 0; i < length; i++) {
/* 157 */       if (i == 0)
/* 158 */         bytes[(length - 1 - i)] = (byte)(int)(0xFF & number);
/* 159 */       else if (i == 1)
/* 160 */         bytes[(length - 1 - i)] = (byte)(int)((0xFF00 & number) >> 8);
/* 161 */       else if (i == 2)
/* 162 */         bytes[(length - 1 - i)] = (byte)(int)((0xFF0000 & number) >> 16);
/* 163 */       else if (i == 3)
/* 164 */         bytes[(length - 1 - i)] = (byte)(int)((0xFF000000 & number) >> 24);
/* 165 */       else if (i == 4)
/* 166 */         bytes[(length - 1 - i)] = (byte)(int)((0x0 & number) >> 32);
/* 167 */       else if (i == 5)
/* 168 */         bytes[(length - 1 - i)] = (byte)(int)((0x0 & number) >> 40);
/* 169 */       else if (i == 6)
/* 170 */         bytes[(length - 1 - i)] = (byte)(int)((0x0 & number) >> 48);
/* 171 */       else if (i == 7) {
/* 172 */         bytes[(length - 1 - i)] = (byte)(int)((0x0 & number) >> 56);
/*     */       }
/*     */     }
/* 175 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static String byteArray2HexStr(byte[] bytes) {
/* 179 */     return "0x" + byteArray2HexDump(bytes).replaceAll(" ", "");
/*     */   }
/*     */ 
/*     */   public static String number2HexStr(long number, int length) {
/* 183 */     return byteArray2HexStr(number2Bytes(number, length));
/*     */   }
/*     */ 
/*     */   public static Date createDate(byte[] date, byte[] time) {
/* 187 */     Date d = null;
/* 188 */     int year = 0xFFFF & (date[2] << 8) + (0xFF & date[3]);
/* 189 */     String timeLine = year + "-" + date[1] + "-" + date[0] + " " + time[0] + ":" + time[1] + ":" + time[2];
/* 190 */     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */     try {
/* 192 */       d = sf.parse(timeLine);
/*     */     } catch (ParseException e) {
/* 194 */       log.error("", e);
/*     */     }
/* 196 */     return d;
/*     */   }
/*     */   public static void main(String[] args) throws Exception {
/* 199 */     byte[] date = { 7, -39, 12, 17 };
/* 200 */     byte[] time = { 23, 50, 2 };
/*     */ 
/* 204 */     getDatePart(createDate(date, time));
/*     */   }
/*     */ 
/*     */   public static byte[] getDatePart(Date gpsTime)
/*     */   {
/* 219 */     Calendar c = Calendar.getInstance();
/* 220 */     c.setTime(gpsTime);
/* 221 */     byte[] date = new byte[4];
/* 222 */     date[2] = (byte)(c.get(1) >> 8 & 0xFF);
/* 223 */     date[3] = (byte)(c.get(1) & 0xFF);
/* 224 */     date[1] = (byte)(c.get(2) + 1);
/* 225 */     date[0] = (byte)c.get(5);
/* 226 */     return date;
/*     */   }
/*     */ 
/*     */   public static byte[] getTimePart(Date gpsTime) {
/* 230 */     Calendar c = Calendar.getInstance();
/* 231 */     c.setTime(gpsTime);
/* 232 */     byte[] time = new byte[3];
/* 233 */     time[0] = (byte)c.get(11);
/* 234 */     time[1] = (byte)c.get(12);
/* 235 */     time[2] = (byte)c.get(13);
/* 236 */     return time;
/*     */   }
/*     */ 
/*     */   public static byte[] getDecodeData(String str) {
/* 240 */     if (str == null) {
/* 241 */       return null;
/*     */     }
/* 243 */     if (str.length() == 0) {
/* 244 */       return null;
/*     */     }
/* 246 */     if (str.length() % 2 != 0) {
/* 247 */       return null;
/*     */     }
/* 249 */     String temp = str.toUpperCase();
/* 250 */     byte[] b = new byte[str.length() / 2];
/* 251 */     for (int i = 0; i < b.length; i++) {
/* 252 */       int ch1 = temp.charAt(i * 2) - '0';
/* 253 */       int ch2 = temp.charAt(i * 2 + 1) - '0';
/* 254 */       if (ch1 > 10) {
/* 255 */         ch1 -= 7;
/*     */       }
/* 257 */       if (ch2 > 10) {
/* 258 */         ch2 -= 7;
/*     */       }
/* 260 */       ch1 = ch1 * 16 + ch2;
/* 261 */       b[i] = (byte)(ch1 & 0xFF);
/*     */     }
/* 263 */     return b;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.util.ByteUtil
 * JD-Core Version:    0.6.1
 */