/*     */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808Builder;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8001;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8100;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8103;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8103_param_item;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8104;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8105;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8201;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8202;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8300;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8301;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8301_item;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8302;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8302_AnswerItem;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8303;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8303_item;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8304;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8400;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8401;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8401_item;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8500;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8600;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8600_region_item;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8601;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8602;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8602_region_item;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8603;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8604;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8604_peak_item;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8605;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8606;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8606_inflexion_item;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8607;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8700;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8701;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8802;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8803;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8804;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8805;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8900;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8A00;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.data.MultimediaData;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.messageImpl.ShootCommandMessage;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.mina.core.buffer.IoBuffer;
/*     */ 
/*     */ public class BusinessDispatcher
/*     */ {
/*  59 */   private Log log = LogFactory.getLog(BusinessDispatcher.class);
/*     */   GReceiveMachineDefault gMachine;
/*  61 */   private Map<String, List<MultimediaData>> shotBusinessObjs = new HashMap();
/*     */ 
/*     */   public static BusinessDispatcher getInstance()
/*     */   {
/*  69 */     return BusinessDispatcherHolder.instance;
/*     */   }
/*     */ 
/*     */   public boolean registerResponse(String mobileNum, int seqNum, byte result, String authCode) throws Exception
/*     */   {
/*  74 */     UnitPackJT808 pack = new UnitPackJT808(
/*  75 */       33024);
/*  76 */     pack.setMobileNum(mobileNum);
/*  77 */     JT808MsgBody_0x8100 body = new JT808MsgBody_0x8100();
/*  78 */     body.setResponseSequenceNum(seqNum);
/*  79 */     body.setResult(result);
/*  80 */     body.setAuthCode(authCode);
/*  81 */     pack.setMsgBody(body);
/*     */ 
/*  83 */     return writePack(pack, "");
/*     */   }
/*     */ 
/*     */   public boolean authenticationResponse(String mobileNum, int seqNum, byte result) throws Exception
/*     */   {
/*  88 */     UnitPackJT808 pack = new UnitPackJT808(32769);
/*  89 */     pack.setMobileNum(mobileNum);
/*  90 */     JT808MsgBody_0x8001 body = new JT808MsgBody_0x8001();
/*  91 */     body.setResponseSequenceNum(seqNum);
/*  92 */     body.setResponseMsgID(258);
/*  93 */     body.setResult(result);
/*  94 */     pack.setMsgBody(body);
/*     */ 
/*  96 */     return writePack(pack, "");
/*     */   }
/*     */ 
/*     */   public boolean deregisterResponse(String mobileNum, int seqNum, byte result) throws Exception
/*     */   {
/* 101 */     UnitPackJT808 pack = new UnitPackJT808(32769);
/* 102 */     pack.setMobileNum(mobileNum);
/* 103 */     JT808MsgBody_0x8001 body = new JT808MsgBody_0x8001();
/* 104 */     body.setResponseSequenceNum(seqNum);
/* 105 */     body.setResponseMsgID(3);
/* 106 */     body.setResult(result);
/* 107 */     pack.setMsgBody(body);
/*     */ 
/* 109 */     return writePack(pack, "");
/*     */   }
/*     */ 
/*     */   public boolean terminalAlarmResponse(String mobileNum, int seqNum) throws Exception
/*     */   {
/* 114 */     UnitPackJT808 pack = new UnitPackJT808(32769);
/* 115 */     pack.setMobileNum(mobileNum);
/* 116 */     JT808MsgBody_0x8001 body = new JT808MsgBody_0x8001();
/* 117 */     body.setResponseSequenceNum(seqNum);
/* 118 */     body.setResponseMsgID(512);
/* 119 */     body.setResult((byte)0);
/* 120 */     pack.setMsgBody(body);
/*     */ 
/* 122 */     return writePack(pack, "alarm" + System.currentTimeMillis());
/*     */   }
/*     */ 
/*     */   public boolean shotImmedi(ShootCommandMessage shootCommandMessage, String messageId)
/*     */     throws Exception
/*     */   {
/* 149 */     return writePack(shootCommandMessage.pack(), messageId);
/*     */   }
/*     */ 
/*     */   public void setReceiveClient(GReceiveMachineDefault machine)
/*     */   {
/* 155 */     this.gMachine = machine;
/*     */   }
/*     */ 
/*     */   public boolean isOnline(String mobileNum) {
/* 159 */     return this.gMachine.isOnline(mobileNum);
/*     */   }
/*     */ 
/*     */   public boolean teminalControl(String mobileNum, byte command, String commandParam, String messageId) throws Exception
/*     */   {
/* 164 */     if (((command != 1) && (command != 2)) || (((commandParam != null) && 
/* 165 */       (!"".equals(commandParam))) || (
/* 165 */       (command != 1) && (command != 2)))) {
/* 166 */       return writePack(
/* 167 */         JT808MsgBody_0x8105.teminalControl(mobileNum, 
/* 167 */         command, commandParam), messageId);
/*     */     }
/*     */ 
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean settingParameter(String mobileNum, List<JT808MsgBody_0x8103_param_item> paramList, String messageId)
/*     */     throws Exception
/*     */   {
/* 177 */     if ((paramList != null) && (paramList.size() > 0)) {
/* 178 */       return writePack(
/* 179 */         JT808MsgBody_0x8103.createParameterPack(mobileNum, 
/* 179 */         (byte)paramList.size(), paramList), messageId);
/*     */     }
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean queryParameter(String mobileNum, String messageId) throws Exception
/*     */   {
/* 186 */     return writePack(JT808MsgBody_0x8104.queryTeminalParam(mobileNum), 
/* 187 */       messageId);
/*     */   }
/*     */ 
/*     */   public boolean queryPosition(String mobileNum) throws Exception {
/* 191 */     return writePack(JT808MsgBody_0x8201.queryTemporaryPostion(mobileNum), 
/* 192 */       String.valueOf(System.currentTimeMillis()));
/*     */   }
/*     */ 
/*     */   public boolean tempTrackControl(String mobileNum, short interval, int period) throws Exception
/*     */   {
/* 197 */     return writePack(
/* 198 */       JT808MsgBody_0x8202.traceTemporaryPostion(mobileNum, 
/* 198 */       interval, period), String.valueOf(System.currentTimeMillis()));
/*     */   }
/*     */ 
/*     */   public boolean sendMessage(String mobileNum, String info, byte msgType, byte terminalMonitor, byte tts, byte advPanel) throws Exception
/*     */   {
/* 203 */     return writePack(
/* 204 */       JT808MsgBody_0x8300.createTextMessage(mobileNum, info, 
/* 204 */       msgType, terminalMonitor, tts, advPanel), 
/* 205 */       String.valueOf(System.currentTimeMillis()));
/*     */   }
/*     */ 
/*     */   public boolean eventSetting(String mobileNum, byte settingType, List<JT808MsgBody_0x8301_item> eventItems) throws Exception
/*     */   {
/* 210 */     return writePack(
/* 211 */       JT808MsgBody_0x8301.createSettingPack(mobileNum, 
/* 211 */       settingType, eventItems), String.valueOf(System.currentTimeMillis()));
/*     */   }
/*     */ 
/*     */   public boolean question(String mobileNum, String problem, byte msgType, byte tts, byte advPanel, List<JT808MsgBody_0x8302_AnswerItem> answerItems, String messageId)
/*     */     throws Exception
/*     */   {
/* 218 */     return writePack(
/* 219 */       JT808MsgBody_0x8302.createQuestionPack(mobileNum, 
/* 219 */       problem, msgType, tts, advPanel, answerItems), messageId);
/*     */   }
/*     */ 
/*     */   public boolean orderMenuSetting(String mobileNum, byte settingType, List<JT808MsgBody_0x8303_item> infoItems, String messageId)
/*     */     throws Exception
/*     */   {
/* 225 */     return writePack(JT808MsgBody_0x8303.createInfoOrderMenuSetting(
/* 226 */       mobileNum, settingType, infoItems), messageId);
/*     */   }
/*     */ 
/*     */   public boolean infoService(String mobileNum, String info, byte infoType, String messageId) throws Exception
/*     */   {
/* 231 */     return writePack(
/* 232 */       JT808MsgBody_0x8304.createInfoServicePack(mobileNum, 
/* 232 */       infoType, (short)info.getBytes("GBK").length, info), messageId);
/*     */   }
/*     */ 
/*     */   public boolean phoneCallback(String mobileNum, String phoneNum, byte sign, String messageId) throws Exception
/*     */   {
/* 237 */     return writePack(
/* 238 */       JT808MsgBody_0x8400.createPhoneCallback(mobileNum, 
/* 238 */       sign, phoneNum), messageId);
/*     */   }
/*     */ 
/*     */   public boolean phoneBookSetting(String mobileNum, byte settingType, List<JT808MsgBody_0x8401_item> contactItems, String messageId)
/*     */     throws Exception
/*     */   {
/* 244 */     return writePack(
/* 245 */       JT808MsgBody_0x8401.createPhoneDirectoryPack(mobileNum, 
/* 245 */       settingType, contactItems), messageId);
/*     */   }
/*     */ 
/*     */   public boolean vehControl(String mobileNum, byte door, String messageId) throws Exception
/*     */   {
/* 250 */     return writePack(JT808MsgBody_0x8500.createVehControl(mobileNum, door), 
/* 251 */       messageId);
/*     */   }
/*     */ 
/*     */   public boolean circleSetting(String mobileNum, byte settingType, List<JT808MsgBody_0x8600_region_item> regionItems, String messageId)
/*     */     throws Exception
/*     */   {
/* 257 */     return writePack(
/* 258 */       JT808MsgBody_0x8600.createCircleRegionPack(mobileNum, 
/* 258 */       settingType, regionItems), messageId);
/*     */   }
/*     */ 
/*     */   public boolean delCircle(String mobileNum, List<Integer> regionIdList, String messageId) throws Exception
/*     */   {
/* 263 */     return writePack(JT808MsgBody_0x8601.createDelCircleRegionPack(
/* 264 */       mobileNum, regionIdList), messageId);
/*     */   }
/*     */ 
/*     */   public boolean driverRecordGather(String mobileNum, byte command, String messageId) throws Exception
/*     */   {
/* 269 */     return writePack(JT808MsgBody_0x8700.createDriverRecordGatherPack(
/* 270 */       mobileNum, command), messageId);
/*     */   }
/*     */ 
/*     */   public boolean driverRecordDownload(String mobileNum, byte command, IoBuffer dataBlock, String messageId) throws Exception
/*     */   {
/* 275 */     return writePack(JT808MsgBody_0x8701.createDriverRecordParamDownPack(mobileNum, command, dataBlock), messageId);
/*     */   }
/*     */ 
/*     */   public boolean settingRectangleRegion(String mobileNum, byte settingType, List<JT808MsgBody_0x8602_region_item> regionItems, String messageId) throws Exception
/*     */   {
/* 280 */     return writePack(JT808MsgBody_0x8602.createRectangleRegionPack(mobileNum, settingType, regionItems), messageId);
/*     */   }
/*     */ 
/*     */   public boolean delRectangleRegion(String mobileNum, List<Integer> regionIdList, String messageId) throws Exception
/*     */   {
/* 285 */     return writePack(JT808MsgBody_0x8603.createDelRectangleRegionPack(mobileNum, regionIdList), messageId);
/*     */   }
/*     */ 
/*     */   public boolean settingPolygonRegion(String mobileNum, int regionId, short regionAttribute, String startTime, String stopTime, short maxSpeed, byte overspeedTime, List<JT808MsgBody_0x8604_peak_item> peakList, String messageId)
/*     */     throws Exception
/*     */   {
/* 291 */     return writePack(JT808MsgBody_0x8604.createPolygonRegionPack(mobileNum, regionId, regionAttribute, startTime, stopTime, maxSpeed, overspeedTime, peakList), messageId);
/*     */   }
/*     */ 
/*     */   public boolean delPolygonRegion(String mobileNum, List<Integer> regionIdList, String messageId) throws Exception
/*     */   {
/* 296 */     return writePack(JT808MsgBody_0x8605.createDelPolygonRegionPack(mobileNum, regionIdList), messageId);
/*     */   }
/*     */ 
/*     */   public boolean settingRoute(String mobileNum, int routeId, short routeAttribute, String startTime, String stopTime, List<JT808MsgBody_0x8606_inflexion_item> inflexionList, String messageId)
/*     */     throws Exception
/*     */   {
/* 302 */     return writePack(JT808MsgBody_0x8606.createRoutePack(mobileNum, routeId, routeAttribute, startTime, stopTime, inflexionList), messageId);
/*     */   }
/*     */ 
/*     */   public boolean delRoute(String mobileNum, List<Integer> regionIdList, String messageId) throws Exception
/*     */   {
/* 307 */     return writePack(JT808MsgBody_0x8607.createDelRoute(mobileNum, regionIdList), messageId);
/*     */   }
/*     */ 
/*     */   public boolean storeMultiDataSearch(String mobileNum, byte multimediaType, byte channelID, byte eventItemCoding, String startTime, String stopTime, String messageId) throws Exception
/*     */   {
/* 312 */     return writePack(JT808MsgBody_0x8802.createStoreMultiDataSearch(mobileNum, multimediaType, channelID, eventItemCoding, startTime, stopTime), messageId);
/*     */   }
/*     */ 
/*     */   public boolean storeMultiDataSearchUpload(String mobileNum, byte multimediaType, byte channelID, byte eventItemCoding, String startTime, String stopTime, byte delSign, String messageId)
/*     */     throws Exception
/*     */   {
/* 318 */     return writePack(JT808MsgBody_0x8803.createStoreMultiDataUpload(mobileNum, multimediaType, channelID, eventItemCoding, startTime, stopTime, delSign), messageId);
/*     */   }
/*     */ 
/*     */   public boolean singleMultiDataSearchUpload(String mobileNum, int multimediaId, byte delSign, String messageId) throws Exception
/*     */   {
/* 323 */     return writePack(JT808MsgBody_0x8805.createSingleMultiDataSearchUpload(mobileNum, multimediaId, delSign), messageId);
/*     */   }
/*     */ 
/*     */   public boolean audioStart(String mobileNum, byte recordCommand, short recordTime, byte storeSign, byte audioGatherFrequency, String messageId) throws Exception
/*     */   {
/* 328 */     return writePack(JT808MsgBody_0x8804.createAudioStartCommand(mobileNum, recordCommand, recordTime, storeSign, audioGatherFrequency), messageId);
/*     */   }
/*     */ 
/*     */   public boolean transSelfDataDown(String mobileNum, byte transType, IoBuffer dataBlock, String messageId) throws Exception
/*     */   {
/* 333 */     return writePack(JT808MsgBody_0x8900.createTransDownPack(mobileNum, transType, dataBlock), messageId);
/*     */   }
/*     */ 
/*     */   public boolean platformRSA(String mobileNum, int e, byte[] n, String messageId) throws Exception {
/* 337 */     return writePack(JT808MsgBody_0x8A00.createPlatformRSA(mobileNum, e, n), messageId);
/*     */   }
/*     */ 
/*     */   public boolean writePack(UnitPackJT808 pack, String messageId)
/*     */   {
/* 342 */     boolean isSend = false;
/* 343 */     GReceiveClient client = null;
/*     */     try {
/* 345 */       IoBuffer buff = UnitPackJT808Builder.buildPacket(pack);
/* 346 */       byte[] bytes = new byte[buff.limit()];
/* 347 */       buff.get(bytes);
/* 348 */       VehSession session = null;
/* 349 */       client = this.gMachine.getGClient(pack.getMobileNum());
/* 350 */       if (client != null) {
/* 351 */         session = client.getSession(pack.getMobileNum());
/* 352 */         if (session != null)
/*     */         {
/* 362 */           return client.writeRransVehMsg(session.sessionId, 1, bytes, 
/* 363 */             messageId);
/*     */         }
/* 365 */         this.log.debug("0x8100 Not get sessionID, by photoNumber[" + 
/* 366 */           pack.getMobileNum() + "]");
/* 367 */         client.isConnect();
/*     */       }
/*     */       else {
/* 370 */         this.log.debug(pack.getMobileNum() + " is unlogon");
/*     */       }
/*     */     } catch (Exception e) {
/* 373 */       this.log.error("", e);
/* 374 */       if (client != null) {
/* 375 */         client.closeService();
/*     */       }
/*     */     }
/*     */ 
/* 379 */     return isSend;
/*     */   }
/*     */ 
/*     */   public void setShotMemery(String key, MultimediaData obj) {
/* 383 */     List<MultimediaData> keys = null;
/* 384 */     List<MultimediaData> list = null;
/* 385 */     if (this.shotBusinessObjs.get(key) == null) {
/* 386 */       list = new ArrayList();
/* 387 */       list.add(obj);
/* 388 */       this.shotBusinessObjs.put(key, list);
/*     */     } else {
/* 390 */       list = (List)this.shotBusinessObjs.get(key);
/*     */ 
/* 392 */       for (MultimediaData b : list) {
/* 393 */         if (System.currentTimeMillis() - b.getCreateTime() > 300000L) {
/* 394 */           if (keys == null) {
/* 395 */             keys = new ArrayList();
/*     */           }
/* 397 */           keys.add(b);
/*     */         }
/*     */       }
/* 400 */       if (keys != null) {
/* 401 */         for (MultimediaData k : keys) {
/* 402 */           list.remove(k);
/*     */         }
/*     */       }
/* 405 */       list.add(obj);
/*     */     }
/*     */   }
/*     */ 
/*     */   public MultimediaData getShotMemery(String key, long time) {
/* 410 */     List list = (List)this.shotBusinessObjs.get(key);
/* 411 */     if (list == null) {
/* 412 */       return null;
/*     */     }
/* 414 */     for (int i = 0; i < list.size(); i++) {
/* 415 */       if (time - ((MultimediaData)list.get(i)).getCreateTime() < 300000L) {
/* 416 */         return (MultimediaData)list.remove(i);
/*     */       }
/*     */     }
/* 419 */     if (list.size() > 0) {
/* 420 */       return (MultimediaData)list.remove(list.size() - 1);
/*     */     }
/*     */ 
/* 423 */     return null;
/*     */   }
/*     */ 
/*     */   static class BusinessDispatcherHolder
/*     */   {
/*  65 */     static BusinessDispatcher instance = new BusinessDispatcher();
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.BusinessDispatcher
 * JD-Core Version:    0.6.1
 */