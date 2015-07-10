/*   */ package com.china317.core.codec.jtt808_2011.util;
/*   */ 
/*   */ import java.nio.charset.Charset;
/*   */ import java.nio.charset.CharsetDecoder;
/*   */ import java.nio.charset.CharsetEncoder;
/*   */ 
/*   */ public class DefaultCharset
/*   */ {
/* 8 */   public static final CharsetEncoder encoder = Charset.forName("GBK").newEncoder();
/* 9 */   public static final CharsetDecoder decoder = Charset.forName("GBK").newDecoder();
/*   */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.util.DefaultCharset
 * JD-Core Version:    0.6.1
 */