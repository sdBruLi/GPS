/*     */ package com.china317.emmp.jtt808Gateway.center2gateway;
/*     */ 
/*     */ import com.china317.core.codec.jtt808_2011.UnitPackJT808;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0200;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0700;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x0801;
/*     */ import com.china317.core.codec.jtt808_2011.bodyPartImpl.JT808MsgBody_0x8800;
/*     */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.codecExt.ObjectDataJT808;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.codecExt.ObjectDataPacket;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.data.DriverRecordData;
/*     */ import com.china317.emmp.jtt808Gateway.center2gateway.data.PhotoObj;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class BusinessProcessor
/*     */ {
/*  25 */   private Log log = LogFactory.getLog(BusinessProcessor.class);
/*     */   GReceiveMachineDefault gMachine;
/*  28 */   private Map<String, ObjectDataJT808> businessObjs = new HashMap();
/*     */ 
/*  30 */   private Map<Integer, ObjectDataPacket> tempMemery = new HashMap();
/*  31 */   public BusinessDispatcher businessDispatcher = BusinessDispatcher.getInstance();
/*     */ 
/*     */   public static BusinessProcessor getInstance()
/*     */   {
/*  41 */     return BusinessProcessHolder.instance;
/*     */   }
/*     */ 
/*     */   void processMultimedia(String sessionid, UnitPackJT808 mocPack) throws Exception {
/*  45 */     JT808MsgBody_0x0801 body_0x0801 = (JT808MsgBody_0x0801)mocPack.getMsgBody();
/*  46 */     PhotoObj photoObj = null;
/*  47 */     this.log.info(mocPack.getMobileNum() + "," + mocPack.getMsgPacketNum() + "/" + mocPack.getMsgPacketCount() + " seq " + mocPack.getSequenceNum());
/*  48 */     if ((mocPack.getMsgPacketCount() > 0) && (mocPack.getMsgPacketNum() == 1)) {
/*  49 */       photoObj = new PhotoObj();
/*  50 */       photoObj.setCreateTime(System.currentTimeMillis());
/*  51 */       photoObj.setPacketCount(mocPack.getMsgPacketCount());
/*  52 */       photoObj.setChannelID(body_0x0801.getChannelID());
/*  53 */       photoObj.setEventItemCoding(body_0x0801.getEventItemCoding());
/*  54 */       photoObj.setMultimediaFormatCoding(body_0x0801.getMultimediaFormatCoding());
/*  55 */       photoObj.setStartSeq(mocPack.getSequenceNum());
/*  56 */       photoObj.setMultimediaID(body_0x0801.getMultimediaID());
/*  57 */       photoObj.getGpsData().setBodyBuffer(body_0x0801.getGpsData().getBodyBuffer());
/*  58 */       photoObj.getGpsData().praseBody();
/*  59 */       photoObj.setMobileNum(mocPack.getMobileNum());
/*     */ 
/*  61 */       photoObj.setState(3);
/*     */ 
/*  63 */       switch (body_0x0801.getMultimediaType())
/*     */       {
/*     */       case 0:
/*  66 */         photoObj.setMultimediaType((byte)1);
/*  67 */         photoObj.setMsgId(36865);
/*  68 */         break;
/*     */       case 1:
/*  71 */         photoObj.setMultimediaType((byte)2);
/*  72 */         photoObj.setMsgId(36865);
/*  73 */         break;
/*     */       case 2:
/*  76 */         photoObj.setMultimediaType((byte)3);
/*  77 */         photoObj.setMsgId(36865);
/*     */       }
/*     */ 
/*  81 */       this.log.debug("[" + mocPack.getSequenceNum() + "]photo[" + photoObj.getMultimediaID() + "] gpsdata[" + photoObj.getGpsData().getTime() + 
/*  82 */         "]is: longitude[" + photoObj.getGpsData().getLangitude() + "] latitude[" + photoObj.getGpsData().getLatitude() + "]");
/*     */ 
/*  84 */       ObjectDataPacket packet = new ObjectDataPacket();
/*  85 */       packet.setId(mocPack.getMsgPacketNum());
/*  86 */       packet.setBuffer(body_0x0801.getMultimediaDataPkg());
/*  87 */       packet.setCreateTime(System.currentTimeMillis());
/*     */ 
/*  94 */       this.log.debug("[" + mocPack.getSequenceNum() + "]realtime photo block[" + packet.getId() + "] is " + 
/*  95 */         ByteUtil.getHexString(packet.getBuffer()));
/*     */ 
/*  97 */       photoObj.addPacket(Integer.valueOf(mocPack.getMsgPacketNum()), packet);
/*  98 */       setMemery(mocPack.getMobileNum() + ":" + photoObj.getStartSeq(), photoObj);
/*     */ 
/* 100 */       for (int i = photoObj.getStartSeq() + 1; i < photoObj.getStartSeq() + photoObj.getPacketCount(); i++) {
/* 101 */         ObjectDataPacket block = getTempMemery(Integer.valueOf(i));
/* 102 */         if (block != null) {
/* 103 */           photoObj.addPacket(Integer.valueOf(block.getId()), block);
/* 104 */           removeTempMemery(Integer.valueOf(i));
/*     */         }
/*     */       }
/*     */     }
/* 108 */     else if ((mocPack.getMsgPacketCount() > 0) && (mocPack.getMsgPacketNum() > 1)) {
/* 109 */       ObjectDataPacket pdb = new ObjectDataPacket();
/* 110 */       pdb.setId(mocPack.getMsgPacketNum());
/* 111 */       pdb.setBuffer(body_0x0801.getBodyBuffer());
/* 112 */       pdb.setCreateTime(System.currentTimeMillis());
/*     */ 
/* 114 */       ObjectDataJT808 bObj = getMemery(mocPack.getMobileNum() + ":" + (mocPack.getSequenceNum() - pdb.getId() + 1));
/* 115 */       if (bObj != null) {
/* 116 */         photoObj = (PhotoObj)bObj;
/*     */       }
/*     */ 
/* 119 */       if (photoObj == null)
/* 120 */         setTempMemery(Integer.valueOf(mocPack.getSequenceNum()), pdb);
/*     */       else {
/* 122 */         photoObj.addPacket(Integer.valueOf(pdb.getId()), pdb);
/*     */       }
/*     */ 
/* 129 */       this.log.debug("[" + mocPack.getSequenceNum() + "]realtime photo block[" + pdb.getId() + "] is " + ByteUtil.getHexString(pdb.getBuffer()));
/*     */     }
/*     */ 
/* 132 */     if (photoObj != null) {
/* 133 */       if (photoObj.getPacketsSize() == photoObj.getPacketCount()) {
/* 134 */         photoObj.setState(1);
/* 135 */         patchPhoto(photoObj);
/* 136 */         removeMemery(mocPack.getMobileNum() + ":" + photoObj.getStartSeq());
/*     */       }
/* 140 */       else if (isPatchMulti(photoObj, mocPack.getMsgPacketNum())) {
/* 141 */         patchPhoto(photoObj);
/*     */       }
/*     */ 
/* 146 */       this.gMachine.receivedBusinessData(photoObj);
/*     */     }
/*     */   }
/*     */ 
/*     */   void processDriverRecord(String sessionid, UnitPackJT808 mocPack) throws Exception {
/* 151 */     JT808MsgBody_0x0700 body_0x0700 = (JT808MsgBody_0x0700)mocPack.getMsgBody();
/* 152 */     DriverRecordData record = null;
/* 153 */     if ((mocPack.getMsgPacketCount() > 0) && (mocPack.getMsgPacketNum() == 1)) {
/* 154 */       record = new DriverRecordData();
/* 155 */       record.setPacketCount(mocPack.getMsgPacketCount());
/* 156 */       record.setStartSeq(mocPack.getSequenceNum());
/* 157 */       record.setMobileNum(mocPack.getMobileNum());
/* 158 */       record.setCommandRecord(body_0x0700.getCommand());
/* 159 */       record.setAckSeqenceNum(body_0x0700.getAckSeqNum());
/* 160 */       record.setMsgId(36867);
/*     */ 
/* 163 */       ObjectDataPacket packet = new ObjectDataPacket();
/* 164 */       packet.setId(mocPack.getMsgPacketNum());
/* 165 */       packet.setBuffer(body_0x0700.getDataBlock());
/* 166 */       packet.setCreateTime(System.currentTimeMillis());
/*     */ 
/* 168 */       this.log.debug("[" + mocPack.getSequenceNum() + "]realtime photo block[" + packet.getId() + "] is " + 
/* 169 */         ByteUtil.getHexString(packet.getBuffer()));
/*     */ 
/* 171 */       record.addPacket(Integer.valueOf(mocPack.getMsgPacketNum()), packet);
/*     */ 
/* 173 */       setMemery(mocPack.getMobileNum() + ":" + record.getStartSeq(), record);
/* 174 */       for (int i = record.getStartSeq() + 1; i < record.getStartSeq() + record.getPacketCount(); i++) {
/* 175 */         ObjectDataPacket block = getTempMemery(Integer.valueOf(i));
/* 176 */         if (block != null) {
/* 177 */           record.addPacket(Integer.valueOf(block.getId()), block);
/* 178 */           removeTempMemery(Integer.valueOf(i));
/*     */         }
/*     */       }
/*     */     }
/* 182 */     else if ((mocPack.getMsgPacketCount() > 0) && (mocPack.getMsgPacketNum() > 1)) {
/* 183 */       ObjectDataPacket pdb = new ObjectDataPacket();
/* 184 */       pdb.setId(mocPack.getMsgPacketNum());
/* 185 */       pdb.setBuffer(body_0x0700.getBodyBuffer());
/* 186 */       pdb.setCreateTime(System.currentTimeMillis());
/*     */ 
/* 188 */       ObjectDataJT808 bObj = getMemery(mocPack.getMobileNum() + ":" + (mocPack.getSequenceNum() - pdb.getId() + 1));
/*     */ 
/* 190 */       if (bObj != null) {
/* 191 */         record = (DriverRecordData)bObj;
/*     */       }
/*     */ 
/* 194 */       if (record == null)
/* 195 */         setTempMemery(Integer.valueOf(mocPack.getSequenceNum()), pdb);
/*     */       else {
/* 197 */         record.addPacket(Integer.valueOf(pdb.getId()), pdb);
/*     */       }
/* 199 */       this.log.debug("[" + mocPack.getSequenceNum() + "]realtime driverRecord block[" + pdb.getId() + "] is " + 
/* 200 */         ByteUtil.getHexString(pdb.getBuffer()));
/* 201 */     } else if (mocPack.getMsgPacketCount() == 0) {
/* 202 */       record = new DriverRecordData();
/* 203 */       record.setPacketCount(1);
/* 204 */       record.setStartSeq(mocPack.getSequenceNum());
/* 205 */       record.setMobileNum(mocPack.getMobileNum());
/* 206 */       record.setCommandRecord(body_0x0700.getCommand());
/* 207 */       record.setAckSeqenceNum(body_0x0700.getAckSeqNum());
/* 208 */       record.setMsgId(mocPack.getMsgID());
/*     */ 
/* 210 */       record.setMsgId(36867);
/* 211 */       ObjectDataPacket pdb = new ObjectDataPacket();
/* 212 */       pdb.setId(mocPack.getMsgPacketNum());
/* 213 */       pdb.setBuffer(body_0x0700.getDataBlock());
/* 214 */       pdb.setCreateTime(System.currentTimeMillis());
/*     */ 
/* 216 */       this.log.debug("[" + mocPack.getSequenceNum() + "]realtime driverRecord block[" + pdb.getId() + "] is " + 
/* 217 */         ByteUtil.getHexString(pdb.getBuffer()));
/*     */ 
/* 219 */       record.addPacket(Integer.valueOf(1), pdb);
/* 220 */       setMemery(mocPack.getMobileNum() + ":" + record.getStartSeq(), record);
/*     */     }
/*     */ 
/* 223 */     if ((record != null) && 
/* 224 */       (record.getPacketsSize() == record.getPacketCount())) {
/* 225 */       ObjectDataJT808 bObj = removeMemery(mocPack.getMobileNum() + ":" + record.getStartSeq());
/* 226 */       bObj.setSessionId(mocPack.getSessionId());
/* 227 */       this.gMachine.setMessageId2Reord(record, sessionid);
/* 228 */       bObj.setMessageId(record.getMessageId());
/* 229 */       this.gMachine.receivedBusinessData(bObj);
/*     */ 
/* 231 */       this.gMachine.changeResultByMessageId(bObj.getMessageId(), bObj);
/*     */     }
/*     */   }
/*     */ 
/*     */   private boolean isPatchMulti(PhotoObj photoObj, int currentNum)
/*     */   {
/* 241 */     if (photoObj.getPacketCount() - photoObj.getPacketsSize() == photoObj.getPacketCount() / 2)
/*     */     {
/* 243 */       for (int i = 1; i <= photoObj.getPacketsSize(); i++) {
/* 244 */         if (photoObj.getPackets().get(Integer.valueOf(i)) == null) {
/* 245 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 249 */     else if (photoObj.getPacketCount() == currentNum)
/*     */     {
/* 251 */       if (photoObj.getPacketsSize() != photoObj.getPacketCount()) {
/* 252 */         return true;
/*     */       }
/*     */     }
/*     */ 
/* 256 */     return false;
/*     */   }
/*     */ 
/*     */   public void patchPhoto(PhotoObj photo) throws Exception {
/* 260 */     List listPkgNums = new ArrayList();
/* 261 */     String line = "patch num is ";
/*     */ 
/* 263 */     for (int i = 1; i <= photo.getCurrentMaxSequenceNum(); i++) {
/* 264 */       if (photo.getPackets().get(Integer.valueOf(i)) == null) {
/* 265 */         listPkgNums.add(Integer.valueOf(i));
/* 266 */         line = line + i + ":";
/*     */       }
/*     */     }
/* 269 */     this.log.debug(line);
/*     */ 
/* 271 */     if ((listPkgNums.size() == 0) && (photo.getPacketCount() != photo.getPacketsSize()))
/*     */     {
/* 273 */       this.log.debug("photo compelete");
/*     */     }
/*     */     else {
/* 276 */       UnitPackJT808 pack = new UnitPackJT808(34816);
/* 277 */       JT808MsgBody_0x8800 body_0x8800 = new JT808MsgBody_0x8800();
/* 278 */       body_0x8800.setMultimediaID(photo.getMultimediaID());
/* 279 */       body_0x8800.setRetransPkgSum((byte)listPkgNums.size());
/* 280 */       body_0x8800.setRetransPkgList(listPkgNums);
/* 281 */       body_0x8800.bulidBody();
/*     */ 
/* 283 */       pack.setMsgBody(body_0x8800);
/* 284 */       pack.setMsgBody(body_0x8800.getBodyBuffer());
/* 285 */       pack.setMobileNum(photo.getMobileNum());
/* 286 */       pack.setSequenceNum(0);
/* 287 */       this.businessDispatcher.writePack(pack, "");
/* 288 */       this.log.info(photo.getMobileNum() + " 补包：" + line);
/*     */     }
/*     */   }
/*     */ 
/*     */   public ObjectDataJT808 getMemery(String key)
/*     */   {
/* 299 */     return (ObjectDataJT808)this.businessObjs.get(key);
/*     */   }
/*     */ 
/*     */   public void setMemery(String key, ObjectDataJT808 bObj) {
/* 303 */     clearMemery();
/* 304 */     this.businessObjs.put(key, bObj);
/*     */   }
/*     */ 
/*     */   private void clearMemery() {
/* 308 */     List<String> keys = null;
/* 309 */     for (String o : this.businessObjs.keySet()) {
/* 310 */       ObjectDataJT808 b = (ObjectDataJT808)this.businessObjs.get(o);
/* 311 */       if (System.currentTimeMillis() - b.getCreateTime() > 300000L) {
/* 312 */         if (keys == null) {
/* 313 */           keys = new ArrayList();
/*     */         }
/* 315 */         keys.add(o);
/*     */       }
/*     */     }
/* 318 */     if (keys != null)
/* 319 */       for (String key : keys)
/* 320 */         removeMemery(key);
/*     */   }
/*     */ 
/*     */   public ObjectDataJT808 removeMemery(String key)
/*     */   {
/* 335 */     return (ObjectDataJT808)this.businessObjs.remove(key);
/*     */   }
/*     */ 
/*     */   public ObjectDataPacket getTempMemery(Integer key) {
/* 339 */     return (ObjectDataPacket)this.tempMemery.get(key);
/*     */   }
/*     */ 
/*     */   public void setTempMemery(Integer key, ObjectDataPacket mObj) {
/* 343 */     clearTempMemery();
/* 344 */     this.tempMemery.put(key, mObj);
/*     */   }
/*     */ 
/*     */   private void clearTempMemery() {
/* 348 */     List<Integer> keys = null;
/* 349 */     for (Integer o : this.tempMemery.keySet()) {
/* 350 */       ObjectDataPacket b = (ObjectDataPacket)this.tempMemery.get(o);
/* 351 */       if (System.currentTimeMillis() - b.getCreateTime() > 300000L) {
/* 352 */         if (keys == null) {
/* 353 */           keys = new ArrayList();
/*     */         }
/* 355 */         keys.add(o);
/*     */       }
/*     */     }
/* 358 */     if (keys != null)
/* 359 */       for (Integer key : keys)
/* 360 */         this.tempMemery.remove(key);
/*     */   }
/*     */ 
/*     */   public ObjectDataPacket removeTempMemery(Integer key)
/*     */   {
/* 366 */     return (ObjectDataPacket)this.tempMemery.remove(key);
/*     */   }
/*     */ 
/*     */   public void setReceiveClient(GReceiveMachineDefault machine) {
/* 370 */     this.gMachine = machine;
/*     */   }
/*     */ 
/*     */   static class BusinessProcessHolder
/*     */   {
/*  37 */     static BusinessProcessor instance = new BusinessProcessor();
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.BusinessProcessor
 * JD-Core Version:    0.6.1
 */