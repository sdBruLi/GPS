/*     */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*     */ 
/*     */ import com.china317.core.base.AbstractDataPacket;
/*     */ import com.china317.core.base.UpMessage;
/*     */ import com.china317.core.codec.jtt808Gateway.DataRow0012;
/*     */ import com.china317.core.codec.jtt808Gateway.GatewayUnitPack;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x0012;
/*     */ import com.china317.core.codec.jtt808Gateway.bodyPartImpl.GatewayBody_0x8011;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808Praser;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0104;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0201;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0302;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0500;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0802;
/*     */ import com.china317.core.processor.UpMessageProcessor;
/*     */ import com.china317.core.util.ByteUtil;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.codecExt.ObjectDataJT808;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.common.CreateObjectInstance;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.common.config.EmmpGatewayConfig;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.common.config.GatewayClientConfig;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.common.config.ProcessorConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class GReceiveMachineDefault extends Thread
/*     */ {
/*  41 */   private Log log = null;
/*  42 */   private BlockingQueue<GatewayUnitPack> messagePool = new LinkedBlockingQueue(10000);
/*  43 */   private Map<String, MessageIdWrapper> vehSequenceNum2MessageIds = new HashMap();
/*  44 */   private Map<String, GReceiveClient> mobileNum2GClients = new HashMap();
/*     */   private Map<String, ProcessorWrapper> map;
/*     */   private Object mapLock;
/*  48 */   private BusinessProcessor businessProcessor = null;
/*  49 */   private BusinessDispatcher businessDispatcher = null;
/*     */   private List<GReceiveClient> clientList;
/*  52 */   private Map<String, DownMessageAdapter> messageId2Message = new ConcurrentHashMap();
/*     */   private static EmmpGatewayConfig emmpGatewayConfig;
/*     */   private static String configPath;
/*  55 */   private static GReceiveMachineDefault instance = null;
/*     */ 
/*     */   private GReceiveMachineDefault() {
/*  58 */     setName(getName());
/*  59 */     this.map = new HashMap();
/*  60 */     this.mapLock = new Object();
/*  61 */     this.log = LogFactory.getLog(getName());
/*     */ 
/*  63 */     this.businessProcessor = BusinessProcessor.getInstance();
/*  64 */     this.businessProcessor.setReceiveClient(this);
/*     */ 
/*  66 */     this.businessDispatcher = BusinessDispatcher.getInstance();
/*  67 */     this.businessDispatcher.setReceiveClient(this);
/*  68 */     this.log.info("GReceiveMachineDefault init");
/*  69 */     start();
/*     */   }
/*     */ 
/*     */   public static void init(String configPath_)
/*     */   {
/*  87 */     configPath = configPath_;
/*  88 */     if (instance == null) {
/*  89 */       if ((configPath != null) && (!"".equals(configPath)))
/*  90 */         emmpGatewayConfig = new EmmpGatewayConfig(configPath);
/*     */       else {
/*  92 */         emmpGatewayConfig = new EmmpGatewayConfig();
/*     */       }
/*  94 */       instance = new GReceiveMachineDefault();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static GReceiveMachineDefault getInstance() {
/*  99 */     init(configPath);
/* 100 */     return instance;
/*     */   }
/*     */ 
/*     */   public void addClient(GReceiveClient client)
/*     */   {
/* 111 */     this.log.info(" add " + client.getIP());
/* 112 */     if (this.clientList == null) {
/* 113 */       this.clientList = new ArrayList();
/*     */     }
/* 115 */     if ((client instanceof GReceiveClient)) {
/* 116 */       client.setMachine(this);
/* 117 */       this.clientList.add(client);
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean registerProcessor(String processorName, UpMessageProcessor processor, String[] acceptCommands)
/*     */   {
/* 132 */     if (processorName == null) {
/* 133 */       this.log.warn("error param, processorName is null");
/* 134 */       return false;
/*     */     }
/* 136 */     if (processor == null) {
/* 137 */       this.log.warn("error param,processor is null");
/* 138 */       return false;
/*     */     }
/*     */ 
/* 141 */     if (acceptCommands == null) {
/* 142 */       this.log.warn("error param,acceptCommands is null");
/* 143 */       return false;
/*     */     }
/*     */ 
/* 146 */     if (acceptCommands.length <= 0) {
/* 147 */       this.log.warn("error param,acceptCommands is empty");
/* 148 */       return false;
/*     */     }
/*     */ 
/* 151 */     if (this.map.containsKey(processorName)) {
/* 152 */       this.log.warn("processorName '" + processorName + "'  is already registered");
/* 153 */       return false;
/*     */     }
/* 155 */     synchronized (this.mapLock) {
/* 156 */       processor.setName(processorName);
/* 157 */       processor.startup();
/* 158 */       this.map.put(processorName, new ProcessorWrapper(processorName, processor, acceptCommands));
/*     */     }
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   public UpMessageProcessor unregisterProcessor(String name)
/*     */   {
/* 170 */     ProcessorWrapper processorWrapper = null;
/* 171 */     synchronized (this.mapLock) {
/* 172 */       processorWrapper = (ProcessorWrapper)this.map.get(name);
/*     */     }
/* 174 */     if (processorWrapper == null) {
/* 175 */       return null;
/*     */     }
/* 177 */     return processorWrapper.processor;
/*     */   }
/*     */ 
/*     */   public boolean isOnline(String mobileNum)
/*     */   {
/* 182 */     GReceiveClient client = (GReceiveClient)this.mobileNum2GClients.get(mobileNum);
/* 183 */     if ((client != null) && 
/* 184 */       (client.getSession(mobileNum) != null)) {
/* 185 */       return true;
/*     */     }
/*     */ 
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean sendMessage(DownMessage message, AbstractResponseListener listener)
/*     */   {
/* 193 */     if ((message == null) || (listener == null)) {
/* 194 */       this.log.debug("message or listener is null");
/* 195 */       return false;
/*     */     }
/*     */ 
/* 198 */     DownMessageAdapter messageImple = DownMessageParser.getInstance().parseMessage(message);
/* 199 */     if (messageImple == null) {
/* 200 */       this.log.debug("DownMessageAdapter is null");
/* 201 */       return false;
/*     */     }
/*     */ 
/* 204 */     messageImple.setCreateTime();
/* 205 */     messageImple.addObserver(listener);
/* 206 */     tempSaveMessage(messageImple.getMessageKey(), messageImple);
/* 207 */     boolean isSend = this.businessDispatcher.writePack(messageImple.getPack(), messageImple.getMessageKey());
/*     */     try
/*     */     {
/* 211 */       if (!isSend)
/* 212 */         removeMessageKey(messageImple.getMessageKey());
/*     */     } catch (Exception e) {
/* 214 */       this.log.error("", e);
/*     */     }
/*     */ 
/* 217 */     return isSend;
/*     */   }
/*     */ 
/*     */   public boolean sendUnRespMessage(DownMessage message) {
/* 221 */     if (message == null) {
/* 222 */       this.log.debug("message or listener is null");
/* 223 */       return false;
/*     */     }
/*     */ 
/* 226 */     DownMessageAdapter messageImple = DownMessageParser.getInstance().parseMessage(message);
/* 227 */     if (messageImple == null) {
/* 228 */       this.log.debug("DownMessageAdapter is null");
/* 229 */       return false;
/*     */     }
/*     */ 
/* 232 */     return this.businessDispatcher.writePack(messageImple.getPack(), messageImple.getMessageKey());
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 237 */     boolean isRun = init();
/* 238 */     this.log.info("isRun " + isRun);
/*     */ 
/* 240 */     while (isRun)
/*     */       try
/*     */       {
/* 243 */         GatewayUnitPack pack = (GatewayUnitPack)this.messagePool.poll(15L, TimeUnit.SECONDS);
/* 244 */         if (pack != null)
/*     */         {
/* 248 */           switch (pack.getCMD())
/*     */           {
/*     */           case 32769:
/* 252 */             break;
/*     */           case 32770:
/* 254 */             this.log.debug("received heartbeat response from gateway...");
/* 255 */             break;
/*     */           case 32785:
/* 257 */             GatewayBody_0x8011 body8011 = (GatewayBody_0x8011)pack.getMsgBody();
/* 258 */             if ((body8011.getMessageId() != null) && (!"".equals(body8011.getMessageId()))) {
/* 259 */               this.log.debug("VehSequenceNum2MessageIds key:" + body8011.getSessionid() + ":" + body8011.getSequenceNum() + " value:" + body8011.getMessageId());
/*     */ 
/* 261 */               tempSaveSequenceNum2Message(body8011.getSessionid() + ":" + body8011.getSequenceNum(), body8011.getMessageId());
/*     */ 
/* 265 */               this.log.debug("VehSequenceNum2MessageIds key:" + body8011.getMessageId() + " status:" + body8011.getStatus());
/* 266 */               changeStatusByMessageId(body8011.getMessageId(), body8011.getStatus());
/*     */             }
/*     */ 
/* 270 */             break;
/*     */           case 18:
/* 272 */             GatewayBody_0x0012 body0012 = (GatewayBody_0x0012)pack.getMsgBody();
/* 273 */             List dataRowList = body0012.getDataRowList();
/* 274 */             Iterator localIterator = dataRowList.iterator();
/*     */             while (true) { DataRow0012 row = (DataRow0012)localIterator.next();
/* 275 */               processDataRow(row);
/*     */ 
/* 274 */               if (!localIterator.hasNext())
/*     */               {
/* 277 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 284 */         sendHeartbeat();
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 288 */         this.log.error("", e);
/*     */       }
/*     */   }
/*     */ 
/*     */   private boolean init()
/*     */   {
/* 295 */     this.log.info("gateway init " + emmpGatewayConfig.isDisable());
/*     */ 
/* 297 */     if (emmpGatewayConfig.isDisable()) {
/* 298 */       this.log.info("gateway disable");
/* 299 */       return false;
/*     */     }
/* 301 */     loadConfig();
/* 302 */     if (this.clientList != null) {
/* 303 */       for (GReceiveClient client : this.clientList) {
/* 304 */         this.log.info("try to conn " + client.getIP() + ":" + client.getPort());
/* 305 */         client.start();
/*     */       }
/*     */     }
/* 308 */     return true;
/*     */   }
/*     */ 
/*     */   private void loadConfig()
/*     */   {
/* 321 */     this.log.info("loadConfig");
/*     */     try {
/* 323 */       if (emmpGatewayConfig.getProcessorList() != null) {
/* 324 */         for (ProcessorConfig pc : emmpGatewayConfig.getProcessorList()) {
/* 325 */           if (!pc.isDisable()) {
/* 326 */             UpMessageProcessor processor = (UpMessageProcessor)
/* 327 */               CreateObjectInstance.getInstance().createObjectInstance(
/* 328 */               pc.getProcessorClass());
/* 329 */             registerProcessor(pc.getProcessorName(), 
/* 330 */               processor, pc.getAcceptCommands());
/*     */           }
/*     */         }
/* 333 */         this.log.info("processor init end");
/*     */       }
/* 335 */       if (emmpGatewayConfig.getGatewayClientList() != null) {
/* 336 */         this.log.info("emmpGatewayConfig size " + emmpGatewayConfig.getGatewayClientList().size());
/* 337 */         for (GatewayClientConfig pc : emmpGatewayConfig.getGatewayClientList())
/* 338 */           if (!pc.isDisable()) {
/* 339 */             GReceiveClient client = new GReceiveClient(pc.getIp(), pc.getPort());
/* 340 */             client.setLoginCode(pc.getName());
/* 341 */             client.setConfig(pc);
/* 342 */             addClient(client);
/*     */           }
/*     */       }
/*     */       else {
/* 346 */         this.log.info("emmpGatewayConfig id null ");
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 350 */       this.log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   void putInWaitingQueue(GatewayUnitPack pack)
/*     */     throws Exception
/*     */   {
/* 362 */     if (!this.messagePool.offer(pack))
/* 363 */       this.log.error("messagePool is full");
/*     */   }
/*     */ 
/*     */   private void tempSaveMessage(String messageId, DownMessageAdapter message)
/*     */   {
/* 368 */     message.setCreateTime();
/* 369 */     this.messageId2Message.put(messageId, message);
/*     */   }
/*     */ 
/*     */   private void clearMessageOfTimeout()
/*     */   {
/* 392 */     List<String> messageIdList = null;
/* 393 */     for (Iterator localIterator = this.messageId2Message.keySet().iterator(); localIterator.hasNext(); ) { Object o = localIterator.next();
/* 394 */       DownMessageAdapter m = (DownMessageAdapter)this.messageId2Message.get(o);
/* 395 */       if (m.isTimeout()) {
/* 396 */         if (messageIdList == null) {
/* 397 */           messageIdList = new ArrayList();
/*     */         }
/* 399 */         messageIdList.add((String)o);
/*     */       }
/*     */     }
/* 402 */     if (messageIdList != null)
/* 403 */       for (String messageId : messageIdList)
/* 404 */         this.messageId2Message.remove(messageId);
/*     */   }
/*     */ 
/*     */   void changeStatusByMessageId(String messageId, int status)
/*     */   {
/* 411 */     DownMessageAdapter message = (DownMessageAdapter)this.messageId2Message.get(messageId);
/* 412 */     if (message != null)
/*     */     {
/* 414 */       message.setSendStatus(String.valueOf(status));
/*     */ 
/* 416 */       if (message.isFinished(String.valueOf(status)))
/*     */       {
/* 418 */         removeMessageKey(messageId);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 424 */     clearMessageOfTimeout();
/*     */   }
/*     */ 
/*     */   private void removeMessageKey(String messageId) {
/* 428 */     this.messageId2Message.remove(messageId);
/*     */   }
/*     */ 
/*     */   private void sendHeartbeat()
/*     */   {
/* 441 */     if (this.clientList == null) {
/* 442 */       this.log.warn("------------- no gateway connected");
/* 443 */       return;
/*     */     }
/* 445 */     for (GReceiveClient client : this.clientList)
/*     */       try {
/* 447 */         if ((client != null) && 
/* 448 */           (client.isTimeoutOfHeartbeat())) {
/* 449 */           boolean isHeart = false;
/*     */ 
/* 451 */           GatewayUnitPack heartpack = new GatewayUnitPack(2);
/*     */           try {
/* 453 */             client.write(heartpack);
/* 454 */             isHeart = true;
/*     */           } catch (Exception e) {
/* 456 */             client.closeService();
/*     */           }
/* 458 */           if ((!isHeart) && 
/* 459 */             (client.isTimeoutOfHeartbeatLongTime())) {
/* 460 */             client.closeService();
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 466 */         this.log.error("", e);
/*     */       }
/*     */   }
/*     */ 
/*     */   private void processDataRow(DataRow0012 row)
/*     */   {
/*     */     try
/*     */     {
/* 474 */       byte[] tempbs = new byte[row.getRowBuffer().limit()];
/* 475 */       row.getRowBuffer().get(tempbs);
/* 476 */       row.getRowBuffer().rewind();
/* 477 */       this.log.debug("row buffer [" + ByteUtil.byteArray2HexDump(tempbs) + "]");
/* 478 */       UnitPackJT808 mocPack = UnitPackJT808Praser.prasePacket(row.getRowBuffer());
/* 479 */       mocPack.setSessionId(Long.parseLong(row.getSessionid()));
/* 480 */       this.log.debug("row cmd[" + mocPack.getMsgID() + "]");
/*     */ 
/* 490 */       reciveMonitorPackData(mocPack);
/*     */     } catch (Exception e) {
/* 492 */       this.log.error("", e);
/* 493 */       row.getRowBuffer().rewind();
/* 494 */       this.log.error("row buffer [" + row.getRowBuffer().toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   void updMobileNum2GClient(String mobileNum, GReceiveClient gClient) {
/* 499 */     this.mobileNum2GClients.put(mobileNum, gClient);
/*     */   }
/*     */ 
/*     */   private void reciveMonitorPackData(UnitPackJT808 mocPack) throws Exception
/*     */   {
/* 504 */     int msgID = mocPack.getMsgID();
/*     */ 
/* 510 */     receiveDataPacket(mocPack);
/*     */ 
/* 517 */     short ackSeqenceNum = 0;
/* 518 */     switch (msgID)
/*     */     {
/*     */     case 2049:
/* 522 */       this.businessProcessor.processMultimedia(String.valueOf(mocPack.getSessionId()), mocPack);
/* 523 */       break;
/*     */     case 1792:
/* 525 */       this.businessProcessor.processDriverRecord(String.valueOf(mocPack.getSessionId()), mocPack);
/* 526 */       break;
/*     */     case 260:
/* 528 */       JT808MsgBody_0x0104 params = (JT808MsgBody_0x0104)mocPack
/* 529 */         .getMsgBody();
/* 530 */       ackSeqenceNum = params.getAckSeqnum();
/* 531 */       break;
/*     */     case 513:
/* 533 */       JT808MsgBody_0x0201 tposition = (JT808MsgBody_0x0201)mocPack
/* 534 */         .getMsgBody();
/* 535 */       ackSeqenceNum = tposition.getAckSeqnum();
/* 536 */       break;
/*     */     case 770:
/* 538 */       JT808MsgBody_0x0302 x0302 = (JT808MsgBody_0x0302)mocPack
/* 539 */         .getMsgBody();
/* 540 */       ackSeqenceNum = x0302.getAckSeqNum();
/* 541 */       break;
/*     */     case 1280:
/* 543 */       JT808MsgBody_0x0500 x0500 = (JT808MsgBody_0x0500)mocPack
/* 544 */         .getMsgBody();
/* 545 */       ackSeqenceNum = x0500.getAckSeqnum();
/* 546 */       break;
/*     */     case 2050:
/* 548 */       JT808MsgBody_0x0802 x0802 = (JT808MsgBody_0x0802)mocPack
/* 549 */         .getMsgBody();
/* 550 */       ackSeqenceNum = x0802.getAckSeqNum();
/*     */     }
/*     */ 
/* 555 */     if (ackSeqenceNum != 0) {
/* 556 */       UpMessage upMessage = UpMessageBuilder.getInstance().buildMessage(mocPack);
/* 557 */       if (upMessage != null)
/* 558 */         changeResultByMessageId(String.valueOf(mocPack.getSessionId()), ackSeqenceNum, upMessage);
/*     */     }
/*     */   }
/*     */ 
/*     */   void changeResultByMessageId(String messageId, UpMessage bObj)
/*     */   {
/* 565 */     if (messageId != null) {
/* 566 */       DownMessageAdapter message = (DownMessageAdapter)this.messageId2Message.get(messageId);
/* 567 */       if (message != null)
/* 568 */         message.setResultPack(bObj);
/*     */     }
/*     */   }
/*     */ 
/*     */   void changeResultByMessageId(String sessionId, short ackSeqencenum, UpMessage obj)
/*     */   {
/* 575 */     String messageId = getMessageIdByActSeqencenum(sessionId, ackSeqencenum);
/* 576 */     if (messageId != null)
/* 577 */       changeResultByMessageId(messageId, obj);
/*     */   }
/*     */ 
/*     */   private String getMessageIdByActSeqencenum(String sessionId, short ackSeqencenum)
/*     */   {
/* 582 */     String messageId = null;
/* 583 */     MessageIdWrapper wrapper = (MessageIdWrapper)this.vehSequenceNum2MessageIds.get(sessionId + ":" + ackSeqencenum);
/* 584 */     if (wrapper != null) {
/* 585 */       messageId = wrapper.messageId;
/*     */     }
/* 587 */     return messageId;
/*     */   }
/*     */ 
/*     */   private void receiveDataPacket(AbstractDataPacket dataPacket)
/*     */   {
/* 595 */     UnitPackJT808 pack = (UnitPackJT808)dataPacket;
/* 596 */     UpMessage upMessage = UpMessageBuilder.getInstance().buildMessage(pack);
/* 597 */     if (upMessage != null) {
/* 598 */       Iterator iterator = this.map.values().iterator();
/* 599 */       while (iterator.hasNext()) {
/* 600 */         ProcessorWrapper processorWrapper = (ProcessorWrapper)iterator.next();
/*     */ 
/* 602 */         if (processorWrapper.isDataPacketAcceptable(upMessage))
/* 603 */           processorWrapper.getProcessor().putInWaitingQueue(upMessage);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void distributePackage(UpMessage upMessage)
/*     */   {
/* 615 */     if (upMessage != null) {
/* 616 */       Iterator iterator = this.map.values().iterator();
/* 617 */       while (iterator.hasNext()) {
/* 618 */         ProcessorWrapper processorWrapper = (ProcessorWrapper)iterator.next();
/*     */ 
/* 620 */         if (processorWrapper.isDataPacketAcceptable(upMessage))
/* 621 */           processorWrapper.getProcessor().putInWaitingQueue(upMessage);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void receivedBusinessData(UpMessage upMessage)
/*     */   {
/* 634 */     Iterator iterator = this.map.values().iterator();
/* 635 */     while (iterator.hasNext()) {
/* 636 */       ProcessorWrapper processorWrapper = (ProcessorWrapper)iterator.next();
/*     */ 
/* 638 */       if (processorWrapper.isDataPacketAcceptable(upMessage))
/* 639 */         processorWrapper.getProcessor().putInWaitingQueue(upMessage);
/*     */     }
/*     */   }
/*     */ 
/*     */   void setMessageId2Reord(ObjectDataJT808 record, String sessionid)
/*     */   {
/* 645 */     this.log.debug("VehSequenceNum2MessageIds key:" + sessionid + ":" + record.getAckSeqenceNum());
/* 646 */     if (this.vehSequenceNum2MessageIds.get(sessionid + ":" + record.getAckSeqenceNum()) != null)
/* 647 */       record.setMessageId(((MessageIdWrapper)this.vehSequenceNum2MessageIds.remove(sessionid + ":" + record.getAckSeqenceNum())).getMessageId());
/*     */   }
/*     */ 
/*     */   GReceiveClient getGClient(String mobileNum)
/*     */   {
/* 652 */     return (GReceiveClient)this.mobileNum2GClients.get(mobileNum);
/*     */   }
/*     */ 
/*     */   protected VehSession getSession(String mobileNum) {
/* 656 */     GReceiveClient client = (GReceiveClient)this.mobileNum2GClients.get(mobileNum);
/* 657 */     if (client != null) {
/* 658 */       return client.getSession(mobileNum);
/*     */     }
/* 660 */     return null;
/*     */   }
/*     */ 
/*     */   public static EmmpGatewayConfig getEmmpGatewayConfig()
/*     */   {
/* 665 */     return emmpGatewayConfig;
/*     */   }
/*     */ 
/*     */   public static void setEmmpGatewayConfig(EmmpGatewayConfig emmpGatewayConfig) {
/* 669 */     emmpGatewayConfig = emmpGatewayConfig;
/*     */   }
/*     */ 
/*     */   public void tempSaveSequenceNum2Message(String sequenceNum, String messageId)
/*     */   {
/* 706 */     this.vehSequenceNum2MessageIds.put(sequenceNum, new MessageIdWrapper(messageId));
/* 707 */     clearSequenceNum2MessageOfTimeout();
/*     */   }
/*     */ 
/*     */   private void clearSequenceNum2MessageOfTimeout() {
/* 711 */     List<String> SequenceNumList = null;
/* 712 */     for (Iterator localIterator = this.vehSequenceNum2MessageIds.keySet().iterator(); localIterator.hasNext(); ) { Object o = localIterator.next();
/* 713 */       MessageIdWrapper m = (MessageIdWrapper)this.vehSequenceNum2MessageIds.get(o);
/* 714 */       if (m.isTimeout()) {
/* 715 */         if (SequenceNumList == null) {
/* 716 */           SequenceNumList = new ArrayList();
/*     */         }
/* 718 */         SequenceNumList.add((String)o);
/*     */       }
/*     */     }
/* 721 */     if (SequenceNumList != null)
/* 722 */       for (String seq : SequenceNumList)
/* 723 */         this.vehSequenceNum2MessageIds.remove(seq);
/*     */   }
/*     */ 
/*     */   private class MessageIdWrapper
/*     */   {
/*     */     private String messageId;
/*     */     private long createTime;
/* 731 */     private long TIMEOUT = 600000L;
/*     */ 
/*     */     public MessageIdWrapper(String messageId) {
/* 734 */       this.messageId = messageId;
/* 735 */       setCreateTime();
/*     */     }
/*     */     public String getMessageId() {
/* 738 */       return this.messageId;
/*     */     }
/*     */     public void setCreateTime() {
/* 741 */       this.createTime = System.currentTimeMillis();
/*     */     }
/*     */     public boolean isTimeout() {
/* 744 */       boolean bTimeout = false;
/* 745 */       if (System.currentTimeMillis() - this.createTime > this.TIMEOUT) {
/* 746 */         bTimeout = true;
/*     */       }
/* 748 */       return bTimeout;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class ProcessorWrapper
/*     */   {
/*     */     private String processorName;
/*     */     private UpMessageProcessor processor;
/*     */     private String[] acceptCommands;
/*     */ 
/*     */     ProcessorWrapper(String processorName, UpMessageProcessor processor, String[] acceptCommands)
/*     */     {
/* 677 */       this.processorName = processorName;
/* 678 */       this.processor = processor;
/* 679 */       this.acceptCommands = acceptCommands;
/*     */     }
/*     */ 
/*     */     String getProcessorName() {
/* 683 */       return this.processorName;
/*     */     }
/*     */     UpMessageProcessor getProcessor() {
/* 686 */       return this.processor;
/*     */     }
/*     */     String[] getAcceptCommands() {
/* 689 */       return this.acceptCommands;
/*     */     }
/*     */ 
/*     */     boolean isDataPacketAcceptable(UpMessage upMessage) {
/* 693 */       boolean commandAcceptable = false;
/* 694 */       for (String acceptCommand : getAcceptCommands()) {
/* 695 */         if (acceptCommand.toLowerCase().equals(upMessage.getCommand())) {
/* 696 */           commandAcceptable = true;
/* 697 */           break;
/*     */         }
/*     */       }
/* 700 */       return commandAcceptable;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.GReceiveMachineDefault
 * JD-Core Version:    0.6.1
 */