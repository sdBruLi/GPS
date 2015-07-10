/*    */ package com.china317.emmp.jtt808Gateway.server.common.config;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.dom4j.Attribute;
/*    */ import org.dom4j.Document;
/*    */ import org.dom4j.DocumentException;
/*    */ import org.dom4j.Element;
/*    */ import org.dom4j.io.SAXReader;
/*    */ 
/*    */ public class Config
/*    */ {
/* 19 */   private static Log log = LogFactory.getLog(Config.class);
/* 20 */   private static Config instance = new Config();
/*    */   private static final String XMLFILE = "/emmp_transport_config.xml";
/* 22 */   private Map<String, ThreadConfig> configMap = new HashMap();
/*    */ 
/*    */   private Config() {
/* 25 */     loadxml();
/*    */   }
/*    */ 
/*    */   public static ThreadConfig getThreadConfig(String id) {
/* 29 */     if (instance.configMap.containsKey(id)) {
/* 30 */       return (ThreadConfig)instance.configMap.get(id);
/*    */     }
/* 32 */     log.error("id='" + id + "' undefined in emmp_transport_config.xml ");
/* 33 */     return new ThreadConfig();
/*    */   }
/*    */ 
/*    */   public static ThreadConfig getThreadConfig(Class ca)
/*    */   {
/* 38 */     return getThreadConfig(ca.getName());
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/*    */   }
/*    */ 
/*    */   private String getValue(Element e, String name) {
/* 45 */     String ret = null;
/* 46 */     ret = e.attributeValue(name);
/* 47 */     if (ret == null) {
/* 48 */       ret = e.elementTextTrim(name);
/*    */     }
/* 50 */     return ret;
/*    */   }
/*    */ 
/*    */   private void loadxml()
/*    */   {
/*    */     try {
/* 56 */       InputStream in = getClass().getResourceAsStream("/emmp_transport_config.xml");
/* 57 */       if (in != null)
/* 58 */         parse(in);
/*    */     }
/*    */     catch (Exception e) {
/* 61 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   private void parse(InputStream input) {
/* 66 */     SAXReader reader = new SAXReader();
/*    */     try {
/* 68 */       Document doc = reader.read(new InputStreamReader(input, "GBK"));
/* 69 */       Element root = doc.getRootElement();
/*    */ 
/* 71 */       List<Element> threadList = root.element("threadGroup").elements("thread");
/* 72 */       for (Element thread : threadList) {
/* 73 */         ThreadConfig threadConfig = new ThreadConfig();
/* 74 */         List<Attribute> alist = thread.attributes();
/* 75 */         for (Attribute attr : alist) {
/* 76 */           threadConfig.put(attr.getName(), attr.getValue());
/*    */         }
/* 78 */         List<Element> list = thread.elements();
/* 79 */         for (Element ele : list) {
/* 80 */           threadConfig.put(ele.getName(), ele.getTextTrim());
/*    */         }
/* 82 */         this.configMap.put(threadConfig.getId(), threadConfig);
/*    */       }
/*    */     } catch (UnsupportedEncodingException e) {
/* 85 */       log.error("不支持的编码格式!", e);
/*    */     } catch (DocumentException e) {
/* 87 */       log.error("解析错误！", e);
/*    */     } catch (Exception e) {
/* 89 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.server.common.config.Config
 * JD-Core Version:    0.6.1
 */