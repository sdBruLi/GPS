/*     */ package com.china317.emmp.jtt808Gateway.center2gateway.common.config;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class EmmpGatewayConfig extends Config
/*     */ {
/*     */   private static final String config_root = "emmpgateway";
/*     */   private static final String config_processorList = "processor-list";
/*     */   private static final String config_gatewayClientList = "gatewayClient-list";
/*     */   private static final String config_parameters = "parameters";
/*  14 */   private String configPath = "/emmp_gateway_config.xml";
/*     */   private boolean disable;
/*     */   private List<ProcessorConfig> processorList;
/*     */   private List<GatewayClientConfig> gatewayClientList;
/*     */   private String parameters;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  22 */     EmmpGatewayConfig c = new EmmpGatewayConfig();
/*     */   }
/*     */ 
/*     */   public EmmpGatewayConfig() {
/*  26 */     loadxml(this.configPath);
/*     */   }
/*     */ 
/*     */   public EmmpGatewayConfig(String configPath_) {
/*  30 */     this.configPath = configPath_;
/*  31 */     loadxml(this.configPath);
/*     */   }
/*     */ 
/*     */   public void parseConfig(Element root)
/*     */   {
/*  36 */     Element rootElement = root.element("emmpgateway");
/*  37 */     String rDisable = rootElement.attributeValue("disable");
/*  38 */     this.log.info(" config disable = " + rDisable);
/*  39 */     if ("true".equals(rDisable))
/*  40 */       setDisable(true);
/*     */     else {
/*  42 */       setDisable(false);
/*     */     }
/*     */ 
/*  46 */     List<Element> platformElementList = rootElement.elements();
/*  47 */     for (Element e : platformElementList) {
/*  48 */       if ("processor-list".equals(e.getName().trim())) {
/*  49 */         setProcessorList(parseProcessor(e));
/*     */       }
/*  51 */       if ("gatewayClient-list".equals(e.getName().trim())) {
/*  52 */         setGatewayClientList(parseGatewayClient(e));
/*     */       }
/*  54 */       if ("parameters".equals(e.getName().trim()))
/*  55 */         setParameters(e.asXML().trim());
/*     */     }
/*     */   }
/*     */ 
/*     */   private Object parseParameters(Element e)
/*     */   {
/*  61 */     return null;
/*     */   }
/*     */   private List<GatewayClientConfig> parseGatewayClient(Element e) {
/*  64 */     List<Element> processorE = e.elements();
/*  65 */     List gatewayClientList = null;
/*  66 */     for (Element pe : processorE) {
/*  67 */       GatewayClientConfig pc = new GatewayClientConfig();
/*     */ 
/*  69 */       if ("true".equals(pe.attributeValue("disable")))
/*  70 */         pc.setDisable(true);
/*     */       else {
/*  72 */         pc.setDisable(false);
/*     */       }
/*  74 */       pc.setIp(pe.attributeValue("ip"));
/*  75 */       pc.setName(pe.attributeValue("name"));
/*     */ 
/*  77 */       this.log.info(pc.isDisable() + "," + pc.getIp() + "," + pc.getName());
/*     */       try {
/*  79 */         pc.setUnLinkStartTime(Integer.parseInt(pe.attributeValue("unLinkStartTime")));
/*  80 */         pc.setUnLinkEndTime(Integer.parseInt(pe.attributeValue("unLinkEndTime")));
/*  81 */         pc.setCheck(true);
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/*  85 */       Integer listenPort = Integer.valueOf(Integer.parseInt(pe.attributeValue("port")));
/*  86 */       pc.setPort(listenPort.intValue());
/*  87 */       this.log.info(pc.isCheck() + "," + pc.getPort());
/*     */ 
/*  89 */       if (gatewayClientList == null) {
/*  90 */         gatewayClientList = new ArrayList();
/*     */       }
/*  92 */       gatewayClientList.add(pc);
/*     */     }
/*     */ 
/*  95 */     return gatewayClientList;
/*     */   }
/*     */   public boolean isDisable() {
/*  98 */     return this.disable;
/*     */   }
/*     */   public void setDisable(boolean disable) {
/* 101 */     this.disable = disable;
/*     */   }
/*     */   public List<ProcessorConfig> getProcessorList() {
/* 104 */     return this.processorList;
/*     */   }
/*     */   public void setProcessorList(List<ProcessorConfig> processorList) {
/* 107 */     this.processorList = processorList;
/*     */   }
/*     */   public List<GatewayClientConfig> getGatewayClientList() {
/* 110 */     return this.gatewayClientList;
/*     */   }
/*     */   public void setGatewayClientList(List<GatewayClientConfig> gatewayClientList) {
/* 113 */     this.gatewayClientList = gatewayClientList;
/*     */   }
/*     */   public String getParameters() {
/* 116 */     return this.parameters;
/*     */   }
/*     */   public void setParameters(String parameters) {
/* 119 */     this.parameters = parameters;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.common.config.EmmpGatewayConfig
 * JD-Core Version:    0.6.1
 */