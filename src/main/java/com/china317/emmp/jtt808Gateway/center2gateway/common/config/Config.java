/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.common.config;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.DocumentException;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public abstract class Config
/*     */ {
/*  19 */   protected Log log = LogFactory.getLog(Config.class);
/*     */ 
/*     */   protected void loadxml(String configPath) {
/*     */     try {
/*  23 */       InputStream in = getClass().getResourceAsStream(configPath);
/*  24 */       if (in != null)
/*  25 */         parse(in);
/*     */     }
/*     */     catch (Exception e) {
/*  28 */       this.log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public abstract void parseConfig(Element paramElement);
/*     */ 
/*     */   private void parse(InputStream input) {
/*  35 */     SAXReader reader = new SAXReader();
/*     */     try {
/*  37 */       Document doc = reader.read(new InputStreamReader(input, "GBK"));
/*  38 */       Element root = doc.getRootElement();
/*     */ 
/*  40 */       parseConfig(root);
/*     */     } catch (UnsupportedEncodingException e) {
/*  42 */       this.log.error("不支持的编码格式!", e);
/*     */     } catch (DocumentException e) {
/*  44 */       this.log.error("解析错误！", e);
/*     */     } catch (Exception e) {
/*  46 */       this.log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected List<ProcessorConfig> parseProcessor(Element e)
/*     */   {
/*  84 */     List<Element> processorE = e.elements();
/*  85 */     List processorList = null;
/*  86 */     for (Element pe : processorE) {
/*  87 */       ProcessorConfig pc = new ProcessorConfig();
/*     */ 
/*  89 */       if ("true".equals(pe.attributeValue("disable")))
/*  90 */         pc.setDisable(true);
/*     */       else {
/*  92 */         pc.setDisable(false);
/*     */       }
/*  94 */       pc.setProcessorClass(pe.attributeValue("class"));
/*  95 */       pc.setProcessorName(pe.attributeValue("name"));
/*     */ 
/*  97 */       pc.setAcceptCommands(pe.element("acceptCommands").getTextTrim());
/*  98 */       pc.setParameters(pe.element("parameters").asXML().trim());
/*     */ 
/* 100 */       pc.setSessionAuthorizationStatus(pe.element("sessionAuthorizationStatus").getTextTrim());
/* 101 */       if (processorList == null) {
/* 102 */         processorList = new ArrayList();
/*     */       }
/* 104 */       processorList.add(pc);
/*     */     }
/* 106 */     return processorList;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.common.config.Config
 * JD-Core Version:    0.6.1
 */