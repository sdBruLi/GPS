/*     */ package com.china317.emmp.jtt808Gateway.distribute;
/*     */ 
/*     */ import com.china317.emmp.jtt808Gateway.distribute.client.DistributeClient;
/*     */ import com.china317.emmp.jtt808Gateway.server.Container.DistributeClientContainer;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class ConfigLoader
/*     */ {
/*  28 */   private static Log log = LogFactory.getLog(ConfigLoader.class);
/*  29 */   private static String distributeConfig = "distribute_config.xml";
/*  30 */   private static String distributeCarFile = "_distributeCars";
/*     */   private static ConfigLoader instance;
/*     */ 
/*     */   public static ConfigLoader getInstance()
/*     */   {
/*  37 */     if (instance == null) {
/*  38 */       instance = new ConfigLoader();
/*     */     }
/*  40 */     return instance;
/*     */   }
/*     */ 
/*     */   public void load()
/*     */   {
/*  48 */     InputStream in = null;
/*     */     try {
/*  50 */       in = new FileInputStream(distributeConfig);
/*  51 */       if (in != null) {
/*  52 */         SAXReader reader = new SAXReader();
/*  53 */         Document doc = reader.read(new InputStreamReader(in, "GBK"));
/*  54 */         Element root = doc.getRootElement();
/*  55 */         List<Element> elements = root.elements("distribute");
/*     */ 
/*  57 */         for (Element distribute : elements) {
/*  58 */           String isRun = distribute.element("isRun").getTextTrim()
/*  59 */             .toLowerCase();
/*  60 */           boolean run = Boolean.parseBoolean(isRun);
/*  61 */           if (run) {
/*  62 */             String name = distribute.element("name").getTextTrim();
/*  63 */             String distributeCommands = distribute.element(
/*  64 */               "distributeCommands").getTextTrim();
/*  65 */             String acceptCommands = distribute
/*  66 */               .element("acceptCommands").getTextTrim();
/*  67 */             String ip = distribute.element("ip").getTextTrim();
/*  68 */             String port = distribute.element("port").getTextTrim();
/*     */ 
/*  70 */             DistributeClient client = new DistributeClient();
/*  71 */             client.setRun(run);
/*  72 */             client.setClinetName(name);
/*  73 */             client.setRemoteIp(ip, Integer.parseInt(port));
/*  74 */             client.setAcceptMsgId(toList(acceptCommands));
/*  75 */             client.setDistributeMsgId(toList(distributeCommands));
/*     */ 
/*  77 */             DistributeClientContainer.put(name, client);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  82 */       log.error(e.toString(), e);
/*     */       try
/*     */       {
/*  85 */         if (in != null)
/*  86 */           in.close();
/*     */       }
/*     */       catch (IOException localIOException)
/*     */       {
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  85 */         if (in != null)
/*  86 */           in.close();
/*     */       }
/*     */       catch (IOException localIOException1)
/*     */       {
/*     */       }
/*     */     }
/*  92 */     loadDistributeCarList();
/*     */   }
/*     */ 
/*     */   public void loadDistributeCarList() {
/*  96 */     Iterator clients = 
/*  97 */       DistributeClientContainer.getClients();
/*  98 */     DistributeClient client = null;
/*  99 */     while (clients.hasNext()) {
/* 100 */       client = (DistributeClient)clients.next();
/* 101 */       client.setDistributeCars(
/* 103 */         loadDistributeCarFile(client.getClinetName() + 
/* 103 */         distributeCarFile));
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<String> loadDistributeCarFile(String filename) {
/* 108 */     List list = null;
/* 109 */     BufferedReader read = null;
/*     */     try {
/* 111 */       read = new BufferedReader(new FileReader(filename));
/* 112 */       String line = null;
/* 113 */       list = new ArrayList();
/* 114 */       while ((line = read.readLine()) != null)
/*     */       {
/* 116 */         list.add(line.split(" ")[0]);
/*     */       }
/*     */     } catch (Exception e) {
/* 119 */       log.error(e.toString(), e);
/*     */       try
/*     */       {
/* 122 */         if (read != null)
/* 123 */           read.close();
/*     */       }
/*     */       catch (IOException localIOException)
/*     */       {
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 122 */         if (read != null)
/* 123 */           read.close();
/*     */       }
/*     */       catch (IOException localIOException1) {
/*     */       }
/*     */     }
/* 128 */     return list;
/*     */   }
/*     */ 
/*     */   private static List<Integer> toList(String data) {
/* 132 */     List list = new ArrayList();
/* 133 */     String[] splits = data.split(",");
/* 134 */     for (String split : splits) {
/* 135 */       list.add(Integer.valueOf(Integer.parseInt(split, 16)));
/*     */     }
/* 137 */     return list;
/*     */   }
/*     */ 
/*     */   private static List<Object> toList(String data, Class clazz)
/*     */   {
/* 142 */     List list = new ArrayList();
/* 143 */     String[] splits = data.split(",");
/* 144 */     for (String split : splits) {
/* 145 */       if (clazz == Integer.class)
/* 146 */         list.add(Integer.valueOf(Integer.parseInt(split)));
/*     */       else {
/* 148 */         list.add(split);
/*     */       }
/*     */     }
/* 151 */     return list;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 155 */     toList("0001,0002,0003,0100,0102,0104,0200,0201,0301", 
/* 156 */       Integer.class);
/* 157 */     toList("0001,0002,0003,0100,0102,0104,0200,0201,0301", 
/* 158 */       String.class);
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.distribute.ConfigLoader
 * JD-Core Version:    0.6.1
 */