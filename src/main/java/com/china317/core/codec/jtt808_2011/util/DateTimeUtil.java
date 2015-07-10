/*     */ package com.china317.core.codec.jtt808_2011.util;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ public class DateTimeUtil
/*     */ {
/*     */   public static final String PATTERN_0 = "yyyyMMddHHmmss";
/*     */   public static final String PATTERN_1 = "yyyy-MM-dd HH:mm:ss";
/*     */   public static final String PATTERN_2 = "yyyy-MM-dd";
/*     */   public static final String PATTERN_3 = "yyyy年MM月dd日 HH时mm分ss秒";
/*     */   public static final String PATTERN_4 = "yyyy年MM月dd日";
/*     */   public static final String PATTERN_5 = "yyyy-MM-dd HH:mm";
/*     */   public static final String PATTERN_6 = "yyyy年MM月dd日 HH时mm分";
/*     */   public static final String PATTERN_7 = "yyyyMMdd";
/*     */   public static final String PATTERN_8 = "HHmmss";
/*     */   public static final String PATTERN_9 = "HH:mm:ss";
/*     */ 
/*     */   public static String getSysTime()
/*     */   {
/*  51 */     return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
/*     */   }
/*     */ 
/*     */   public static byte[] getSimpleSysTime() {
/*  55 */     byte[] ret = new byte[3];
/*  56 */     Calendar now = Calendar.getInstance();
/*  57 */     ret[0] = (byte)now.get(11);
/*  58 */     ret[1] = (byte)now.get(12);
/*  59 */     ret[2] = (byte)now.get(13);
/*  60 */     return ret;
/*     */   }
/*     */ 
/*     */   public static String getTime(String pattern, Calendar cal)
/*     */   {
/*  67 */     return new SimpleDateFormat(pattern).format(cal.getTime());
/*     */   }
/*     */ 
/*     */   public static String getSysTime(String pattern) {
/*  71 */     return new SimpleDateFormat(pattern).format(new Date());
/*     */   }
/*     */ 
/*     */   public static Calendar getDateTime(String dateTime) {
/*  75 */     Calendar date = (Calendar)Calendar.getInstance().clone();
/*  76 */     int year = parseInt(dateTime.substring(0, 4), 1900);
/*  77 */     int Month = parseInt(dateTime.substring(4, 6), 1) - 1;
/*  78 */     int day = parseInt(dateTime.substring(6, 8), 1);
/*  79 */     int hh = parseInt(dateTime.substring(8, 10), 0);
/*  80 */     int mm = parseInt(dateTime.substring(10, 12), 0);
/*  81 */     int ss = parseInt(dateTime.substring(12, 14), 0);
/*  82 */     date.set(year, Month, day, hh, mm, ss);
/*  83 */     return date;
/*     */   }
/*     */ 
/*     */   public static Calendar getDateTime(byte[] dateTime) {
/*  87 */     Calendar date = (Calendar)Calendar.getInstance().clone();
/*  88 */     int year = dateTime[0] + 2000;
/*  89 */     int Month = dateTime[1] - 1;
/*  90 */     int day = dateTime[2];
/*  91 */     int hh = dateTime[3];
/*  92 */     int mm = dateTime[4];
/*  93 */     int ss = dateTime[5];
/*  94 */     date.set(year, Month, day, hh, mm, ss);
/*  95 */     return date;
/*     */   }
/*     */ 
/*     */   public static String getDateTimeString(byte[] dateTime) {
/*  99 */     Calendar date = getDateTime(dateTime);
/* 100 */     return getDateTimeString(date.getTime());
/*     */   }
/*     */ 
/*     */   public static String getDateTimeString(Date t) {
/* 104 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
/* 105 */     String time = formatter.format(t);
/* 106 */     return time;
/*     */   }
/*     */ 
/*     */   public static String getDateTimeString(Date t, String pattern) {
/* 110 */     SimpleDateFormat formatter = new SimpleDateFormat(pattern);
/* 111 */     String time = formatter.format(t);
/* 112 */     return time;
/*     */   }
/*     */ 
/*     */   public static String reFormatTime(String str, String oldPattern, String newPattern) {
/*     */     try {
/* 117 */       SimpleDateFormat oldFormat = new SimpleDateFormat(oldPattern);
/* 118 */       SimpleDateFormat newFormat = new SimpleDateFormat(newPattern);
/* 119 */       return newFormat.format(oldFormat.parse(str));
/*     */     } catch (Exception e) {
/*     */     }
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */   public static String formatTime(String str, String pattern)
/*     */   {
/*     */     try {
/* 128 */       if (str == null)
/* 129 */         return null;
/* 130 */       int size = str.length();
/* 131 */       if (size == 0) {
/* 132 */         return "";
/*     */       }
/* 134 */       if (size < 14) {
/* 135 */         for (int i = 0; i < 14 - size; i++)
/* 136 */           str = str + "0";
/*     */       }
/* 138 */       int nYear = Integer.parseInt(str.substring(0, 4), 10);
/* 139 */       int nMonth = Integer.parseInt(str.substring(4, 6), 10);
/* 140 */       int nDay = Integer.parseInt(str.substring(6, 8), 10);
/* 141 */       int nHour = Integer.parseInt(str.substring(8, 10), 10);
/* 142 */       int nMinute = Integer.parseInt(str.substring(10, 12), 10);
/* 143 */       int nSecond = Integer.parseInt(str.substring(12, 14), 10);
/* 144 */       Calendar tmpCalendar = Calendar.getInstance(TimeZone.getTimeZone("CTT"));
/* 145 */       tmpCalendar.set(nYear, nMonth - 1, nDay, nHour, nMinute, nSecond);
/* 146 */       SimpleDateFormat formatter = new SimpleDateFormat(pattern);
/* 147 */       Date tmpDate = tmpCalendar.getTime();
/* 148 */       return formatter.format(tmpDate); } catch (Exception e) {
/*     */     }
/* 150 */     return null;
/*     */   }
/*     */ 
/*     */   public static String getFormatTimebyInt(String str)
/*     */   {
/*     */     try {
/* 156 */       if (str == null)
/* 157 */         return null;
/* 158 */       int size = str.length();
/* 159 */       if (size < 6) {
/* 160 */         for (int i = 0; i < 6 - size; i++)
/* 161 */           str = "0" + str;
/*     */       }
/* 163 */       return str.substring(0, 2) + ":" + str.substring(2, 4) + ":" + str.substring(4, 6); } catch (Exception e) {
/*     */     }
/* 165 */     return "";
/*     */   }
/*     */ 
/*     */   public static String formatTime(String str)
/*     */   {
/*     */     try {
/* 171 */       if (str == null)
/* 172 */         return null;
/* 173 */       int size = str.length();
/* 174 */       if (size < 6) {
/* 175 */         for (int i = 0; i < 6 - size; i++)
/* 176 */           str = "0" + str;
/*     */       }
/* 178 */       return str.substring(0, 2) + ":" + str.substring(2, 4) + ":" + str.substring(4, 6); } catch (Exception e) {
/*     */     }
/* 180 */     return "";
/*     */   }
/*     */ 
/*     */   public static int parseInt(String str, int defaultvalue)
/*     */   {
/*     */     try {
/* 186 */       return Integer.parseInt(str);
/*     */     } catch (Exception e) {
/* 188 */       e.printStackTrace();
/* 189 */     }return defaultvalue;
/*     */   }
/*     */ 
/*     */   public static int accountTime(String time1, String time2)
/*     */   {
/* 201 */     Calendar c1 = getDateTime(time1);
/* 202 */     Calendar c2 = getDateTime(time2);
/* 203 */     return (int)((c2.getTimeInMillis() - c1.getTimeInMillis()) / 1000L);
/*     */   }
/*     */ 
/*     */   public static int accountTime(long time1, long time2)
/*     */   {
/* 216 */     if ((time1 == 0L) || (time2 == 0L))
/* 217 */       return 0;
/* 218 */     String t1 = getTimebyInt(time1);
/* 219 */     int hh_1 = parseInt(t1.substring(0, 2), 0);
/* 220 */     int mm_1 = parseInt(t1.substring(2, 4), 0);
/* 221 */     int ss_1 = parseInt(t1.substring(4, 6), 0);
/* 222 */     String t2 = getTimebyInt(time2);
/* 223 */     int hh_2 = parseInt(t2.substring(0, 2), 0);
/* 224 */     int mm_2 = parseInt(t2.substring(2, 4), 0);
/* 225 */     int ss_2 = parseInt(t2.substring(4, 6), 0);
/* 226 */     return ss_2 - ss_1 + (mm_2 - mm_1) * 60 + (hh_2 - hh_1) * 3600;
/*     */   }
/*     */ 
/*     */   public static String getTimebyInt(long time) {
/* 230 */     String temp = "000000" + time;
/* 231 */     return temp.substring(temp.length() - 6);
/*     */   }
/*     */ 
/*     */   public static String getFormatTimebyInt(long time) {
/* 235 */     String temp = "000000" + time;
/* 236 */     temp = temp.substring(temp.length() - 6);
/* 237 */     return (temp.charAt(0) == '0' ? temp.substring(1, 2) : temp.substring(0, 2)) + ":" + temp.substring(2, 4) + ":" + temp.substring(4, 6);
/*     */   }
/*     */ 
/*     */   public static Date format(String dateTime) {
/* 241 */     Calendar date = (Calendar)Calendar.getInstance().clone();
/* 242 */     int hh = parseInt(dateTime.substring(0, 2), 0);
/* 243 */     int mm = parseInt(dateTime.substring(2, 4), 0);
/* 244 */     int ss = parseInt(dateTime.substring(4, 6), 0);
/* 245 */     int SS = parseInt(dateTime.substring(6, 10), 0);
/* 246 */     date.set(11, hh);
/* 247 */     date.set(12, mm);
/* 248 */     date.set(13, ss);
/* 249 */     date.set(14, SS);
/* 250 */     return date.getTime();
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.util.DateTimeUtil
 * JD-Core Version:    0.6.1
 */