/*     */ package com.china317.core.codec.jtt809_2011;
/*     */ 
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.DownCloselinkInform_0x9008;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.DownConnectReq_0x9001;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.DownConnectRsp_0x9002;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.DownDisconnectInform_0x9007;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.DownDisconnectReq_0x9003;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.DownDisconnectRsp_0x9004;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.DownLinktestReq_0x9005;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.DownLinktestRsp_0x9006;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.DownTotalRecvBackMsg_0x9101;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UnknownCommandBodyPart;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UpCloseLinkInform_0x1008;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UpConnectReq_0x1001;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UpConnectResp_0x1002;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UpDisconnectInform_0x1007;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UpDisconnectReq_0x1003;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UpDisconnectRsp_0x1004;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UpLinkTestReq_0x1005;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.UpLinkTestRsp_0x1006;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downBaseMsg.DownBaseMsgVehicleAdded_0x9601;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgEmergencyMonitoringReq_0x9505;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgMonitorVehicleReq_0x9501;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgTakePhotoReq_0x9502;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgTakeTravelReq_0x9504;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downCtrlMsg.DownCtrlMsgTextInfo_0x9503;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgApplyForMonitorEndAck_0x9208;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgApplyForMonitorStartupAck_0x9207;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgApplyHisgnssdataAck_0x9209;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgCarInfo_0x9204;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgCarLocation_0x9202;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgHistoryArcossarea_0x9203;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgReportDriverInfo_0x920A;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgReturnEnd_0x9206;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgReturnStartup_0x9205;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downExgMsg.DownExgMsgTakeEwaybillReq_0x920B;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downPlatformMsg.DownPlatformMsgInfoReq_0x9302;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downPlatformMsg.DownPlatformMsgPostQueryReq_0x9301;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg.DownWarnMsgExgInform_0x9403;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg.DownWarnMsgInformTips_0x9402;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.downWarnMsg.DownWarnMsgUrgeTodoReq_0x9401;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upBaseMsg.UpBaseMsgVehicleAddedAck_0x1601;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg.UpCtrlMsgEmergencyMonitoringAck_0x1505;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg.UpCtrlMsgMonitorVehicleAck_0x1501;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg.UpCtrlMsgTakePhotoAck_0x1502;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg.UpCtrlMsgTakeTravelAck_0x1504;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upCtrlMsg.UpCtrlMsgTextInfoAck_0x1503;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgApplyForMonitorEnd_0x1208;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgApplyForMonitorStartup_0x1207;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgApplyHistoryDataReq_0x1209;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgHistoryLocation_0x1203;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgRealLocation_0x1202;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgRegister_0x1201;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgReportDriverInfoAck_0x120A;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgReturnEndAck_0x1206;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgReturnStartupAck_0x1205;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upExgMsg.UpExgMsgTakeEwaybillAck_0x120B;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upPlatformMsg.UpPlatformMsgInfoAck_0x1302;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upPlatformMsg.UpPlatformMsgPostQueryAck_0x1301;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upWarnMsg.UpWarnMsgAdptInfo_0x1402;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upWarnMsg.UpWarnMsgAdptTodoInfo_0x1403;
/*     */ import com.china317.core.codec.jtt809_2011.bodyPartImpl.upWarnMsg.UpWarnMsgUrgeTodoAck_0x1401;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class DataPacketBodyPartFactory
/*     */ {
/*  68 */   public static Log log = LogFactory.getLog(DataPacketBodyPartFactory.class);
/*     */ 
/*     */   public static DataPacketBodyPart getDataPacketBodyPart(int msgId, byte[] bodyBytes)
/*     */   {
/*     */     DataPacketBodyPart bodyPart;
/*  71 */     switch (msgId) {
/*     */     case 4097:
/*  73 */       bodyPart = new UpConnectReq_0x1001();
/*  74 */       break;
/*     */     case 4098:
/*  76 */       bodyPart = new UpConnectResp_0x1002();
/*  77 */       break;
/*     */     case 4099:
/*  79 */       bodyPart = new UpDisconnectReq_0x1003();
/*  80 */       break;
/*     */     case 4100:
/*  82 */       bodyPart = new UpDisconnectRsp_0x1004();
/*  83 */       break;
/*     */     case 4101:
/*  85 */       bodyPart = new UpLinkTestReq_0x1005();
/*  86 */       break;
/*     */     case 4102:
/*  88 */       bodyPart = new UpLinkTestRsp_0x1006();
/*  89 */       break;
/*     */     case 4103:
/*  91 */       bodyPart = new UpDisconnectInform_0x1007();
/*  92 */       break;
/*     */     case 4104:
/*  94 */       bodyPart = new UpCloseLinkInform_0x1008();
/*  95 */       break;
/*     */     case 36865:
/*  97 */       bodyPart = new DownConnectReq_0x9001();
/*  98 */       break;
/*     */     case 36866:
/* 100 */       bodyPart = new DownConnectRsp_0x9002();
/* 101 */       break;
/*     */     case 36867:
/* 103 */       bodyPart = new DownDisconnectReq_0x9003();
/* 104 */       break;
/*     */     case 36868:
/* 106 */       bodyPart = new DownDisconnectRsp_0x9004();
/* 107 */       break;
/*     */     case 36869:
/* 109 */       bodyPart = new DownLinktestReq_0x9005();
/* 110 */       break;
/*     */     case 36870:
/* 112 */       bodyPart = new DownLinktestRsp_0x9006();
/* 113 */       break;
/*     */     case 36871:
/* 115 */       bodyPart = new DownDisconnectInform_0x9007();
/* 116 */       break;
/*     */     case 36872:
/* 118 */       bodyPart = new DownCloselinkInform_0x9008();
/* 119 */       break;
/*     */     case 37121:
/* 121 */       bodyPart = new DownTotalRecvBackMsg_0x9101();
/* 122 */       break;
/*     */     case 4608:
/* 125 */       bodyPart = createExgMsgBody(bodyBytes);
/* 126 */       break;
/*     */     case 37376:
/* 128 */       bodyPart = createExgMsgBody(bodyBytes);
/* 129 */       break;
/*     */     case 4864:
/* 131 */       bodyPart = createPlatformMsgBody(bodyBytes);
/* 132 */       break;
/*     */     case 37632:
/* 134 */       bodyPart = createPlatformMsgBody(bodyBytes);
/* 135 */       break;
/*     */     case 5120:
/* 137 */       bodyPart = createWarnMsgBody(bodyBytes);
/* 138 */       break;
/*     */     case 37888:
/* 140 */       bodyPart = createWarnMsgBody(bodyBytes);
/* 141 */       break;
/*     */     case 5376:
/* 143 */       bodyPart = createCtrlMsgBody(bodyBytes);
/* 144 */       break;
/*     */     case 38144:
/* 146 */       bodyPart = createCtrlMsgBody(bodyBytes);
/* 147 */       break;
/*     */     case 5632:
/* 149 */       bodyPart = createBaseMsgBody(bodyBytes);
/* 150 */       break;
/*     */     case 38400:
/* 152 */       bodyPart = createBaseMsgBody(bodyBytes);
/* 153 */       break;
/*     */     default:
/* 155 */       bodyPart = new UnknownCommandBodyPart();
/*     */     }
/*     */ 
/* 159 */     return bodyPart;
/*     */   }
/*     */ 
/*     */   public static DataPacketBodyPart getDataPacketBodyPart2(int msgId)
/*     */   {
/*     */     DataPacketBodyPart bodyPart;
/* 164 */     switch (msgId) {
/*     */     case 4097:
/* 166 */       bodyPart = new UpConnectReq_0x1001();
/* 167 */       break;
/*     */     case 4098:
/* 169 */       bodyPart = new UpConnectResp_0x1002();
/* 170 */       break;
/*     */     case 4099:
/* 172 */       bodyPart = new UpDisconnectReq_0x1003();
/* 173 */       break;
/*     */     case 4100:
/* 175 */       bodyPart = new UpDisconnectRsp_0x1004();
/* 176 */       break;
/*     */     case 4101:
/* 178 */       bodyPart = new UpLinkTestReq_0x1005();
/* 179 */       break;
/*     */     case 4102:
/* 181 */       bodyPart = new UpLinkTestRsp_0x1006();
/* 182 */       break;
/*     */     case 4103:
/* 184 */       bodyPart = new UpDisconnectInform_0x1007();
/* 185 */       break;
/*     */     case 4104:
/* 187 */       bodyPart = new UpCloseLinkInform_0x1008();
/* 188 */       break;
/*     */     case 36865:
/* 190 */       bodyPart = new DownConnectReq_0x9001();
/* 191 */       break;
/*     */     case 36866:
/* 193 */       bodyPart = new DownConnectRsp_0x9002();
/* 194 */       break;
/*     */     case 36867:
/* 196 */       bodyPart = new DownDisconnectReq_0x9003();
/* 197 */       break;
/*     */     case 36868:
/* 199 */       bodyPart = new DownDisconnectRsp_0x9004();
/* 200 */       break;
/*     */     case 36869:
/* 202 */       bodyPart = new DownLinktestReq_0x9005();
/* 203 */       break;
/*     */     case 36870:
/* 205 */       bodyPart = new DownLinktestRsp_0x9006();
/* 206 */       break;
/*     */     case 36871:
/* 208 */       bodyPart = new DownDisconnectInform_0x9007();
/* 209 */       break;
/*     */     case 36872:
/* 211 */       bodyPart = new DownCloselinkInform_0x9008();
/* 212 */       break;
/*     */     case 37121:
/* 214 */       bodyPart = new DownTotalRecvBackMsg_0x9101();
/* 215 */       break;
/*     */     case 4609:
/* 219 */       bodyPart = new UpExgMsgRegister_0x1201(msgId);
/* 220 */       break;
/*     */     case 4610:
/* 222 */       bodyPart = new UpExgMsgRealLocation_0x1202(msgId);
/* 223 */       break;
/*     */     case 4611:
/* 225 */       bodyPart = new UpExgMsgHistoryLocation_0x1203(msgId);
/* 226 */       break;
/*     */     case 4613:
/* 228 */       bodyPart = new UpExgMsgReturnStartupAck_0x1205(msgId);
/* 229 */       break;
/*     */     case 4614:
/* 231 */       bodyPart = new UpExgMsgReturnEndAck_0x1206(msgId);
/* 232 */       break;
/*     */     case 4615:
/* 234 */       bodyPart = new UpExgMsgApplyForMonitorStartup_0x1207(msgId);
/* 235 */       break;
/*     */     case 4616:
/* 237 */       bodyPart = new UpExgMsgApplyForMonitorEnd_0x1208(msgId);
/* 238 */       break;
/*     */     case 4617:
/* 240 */       bodyPart = new UpExgMsgApplyHistoryDataReq_0x1209(msgId);
/* 241 */       break;
/*     */     case 4618:
/* 243 */       bodyPart = new UpExgMsgReportDriverInfoAck_0x120A(msgId);
/* 244 */       break;
/*     */     case 4619:
/* 246 */       bodyPart = new UpExgMsgTakeEwaybillAck_0x120B(msgId);
/* 247 */       break;
/*     */     case 4620:
/* 249 */       bodyPart = new UpExgMsgReportDriverInfoAck_0x120A(msgId);
/* 250 */       break;
/*     */     case 4621:
/* 252 */       bodyPart = new UpExgMsgTakeEwaybillAck_0x120B(msgId);
/* 253 */       break;
/*     */     case 37378:
/* 256 */       bodyPart = new DownExgMsgCarLocation_0x9202(msgId);
/* 257 */       break;
/*     */     case 37379:
/* 259 */       bodyPart = new DownExgMsgHistoryArcossarea_0x9203(msgId);
/* 260 */       break;
/*     */     case 37380:
/* 262 */       bodyPart = new DownExgMsgCarInfo_0x9204(msgId);
/* 263 */       break;
/*     */     case 37381:
/* 265 */       bodyPart = new DownExgMsgReturnStartup_0x9205(msgId);
/* 266 */       break;
/*     */     case 37382:
/* 268 */       bodyPart = new DownExgMsgReturnEnd_0x9206(msgId);
/* 269 */       break;
/*     */     case 37383:
/* 271 */       bodyPart = new DownExgMsgApplyForMonitorStartupAck_0x9207(msgId);
/* 272 */       break;
/*     */     case 37384:
/* 274 */       bodyPart = new DownExgMsgApplyForMonitorEndAck_0x9208(msgId);
/* 275 */       break;
/*     */     case 37385:
/* 277 */       bodyPart = new DownExgMsgApplyHisgnssdataAck_0x9209(msgId);
/* 278 */       break;
/*     */     case 37386:
/* 280 */       bodyPart = new DownExgMsgReportDriverInfo_0x920A(msgId);
/* 281 */       break;
/*     */     case 37387:
/* 283 */       bodyPart = new DownExgMsgTakeEwaybillReq_0x920B(msgId);
/* 284 */       break;
/*     */     case 4865:
/* 288 */       bodyPart = new UpPlatformMsgPostQueryAck_0x1301(msgId);
/* 289 */       break;
/*     */     case 4866:
/* 291 */       bodyPart = new UpPlatformMsgInfoAck_0x1302(msgId);
/* 292 */       break;
/*     */     case 37633:
/* 294 */       bodyPart = new DownPlatformMsgPostQueryReq_0x9301(msgId);
/* 295 */       break;
/*     */     case 37634:
/* 297 */       bodyPart = new DownPlatformMsgInfoReq_0x9302(msgId);
/* 298 */       break;
/*     */     case 5121:
/* 302 */       bodyPart = new UpWarnMsgUrgeTodoAck_0x1401(msgId);
/* 303 */       break;
/*     */     case 5122:
/* 305 */       bodyPart = new UpWarnMsgAdptInfo_0x1402(msgId);
/* 306 */       break;
/*     */     case 5123:
/* 308 */       bodyPart = new UpWarnMsgAdptTodoInfo_0x1403(msgId);
/* 309 */       break;
/*     */     case 37889:
/* 311 */       bodyPart = new DownWarnMsgUrgeTodoReq_0x9401(msgId);
/* 312 */       break;
/*     */     case 37890:
/* 314 */       bodyPart = new DownWarnMsgInformTips_0x9402(msgId);
/* 315 */       break;
/*     */     case 37891:
/* 317 */       bodyPart = new DownWarnMsgExgInform_0x9403(msgId);
/* 318 */       break;
/*     */     case 5377:
/* 322 */       bodyPart = new UpCtrlMsgMonitorVehicleAck_0x1501(msgId);
/* 323 */       break;
/*     */     case 5378:
/* 325 */       bodyPart = new UpCtrlMsgTakePhotoAck_0x1502(msgId);
/* 326 */       break;
/*     */     case 5379:
/* 328 */       bodyPart = new UpCtrlMsgTextInfoAck_0x1503(msgId);
/* 329 */       break;
/*     */     case 5380:
/* 331 */       bodyPart = new UpCtrlMsgTakeTravelAck_0x1504(msgId);
/* 332 */       break;
/*     */     case 5381:
/* 334 */       bodyPart = new UpCtrlMsgEmergencyMonitoringAck_0x1505(msgId);
/* 335 */       break;
/*     */     case 38145:
/* 338 */       bodyPart = new DownCtrlMsgMonitorVehicleReq_0x9501(msgId);
/* 339 */       break;
/*     */     case 38146:
/* 341 */       bodyPart = new DownCtrlMsgTakePhotoReq_0x9502(msgId);
/* 342 */       break;
/*     */     case 38147:
/* 344 */       bodyPart = new DownCtrlMsgTextInfo_0x9503(msgId);
/* 345 */       break;
/*     */     case 38148:
/* 347 */       bodyPart = new DownCtrlMsgTakeTravelReq_0x9504(msgId);
/* 348 */       break;
/*     */     case 38149:
/* 350 */       bodyPart = new DownCtrlMsgEmergencyMonitoringReq_0x9505(msgId);
/* 351 */       break;
/*     */     case 38401:
/* 353 */       bodyPart = new DownBaseMsgVehicleAdded_0x9601();
/* 354 */       break;
/*     */     case 5633:
/* 356 */       bodyPart = new UpBaseMsgVehicleAddedAck_0x1601();
/* 357 */       break;
/*     */     default:
/* 359 */       bodyPart = new UnknownCommandBodyPart();
/*     */     }
/*     */ 
/* 363 */     return bodyPart;
/*     */   }
/*     */ 
/*     */   private static DataPacketBodyPart createBaseMsgBody(byte[] bodyBytes)
/*     */   {
/* 369 */     int msgId = 0;
/*     */     try {
/* 371 */       msgId = 0xFFFF & ((0xFF & bodyBytes[22]) << 8) + (0xFF & bodyBytes[23]);
/*     */     } catch (Exception e) {
/* 373 */       log.error("DataPacketBodyPart createBaseMsgBody", e);
/*     */     }
/*     */     DataPacketBodyPart bodyPart;
/* 375 */     switch (msgId) {
/*     */     case 38401:
/* 377 */       bodyPart = new DownBaseMsgVehicleAdded_0x9601();
/* 378 */       break;
/*     */     case 5633:
/* 380 */       bodyPart = new UpBaseMsgVehicleAddedAck_0x1601();
/* 381 */       break;
/*     */     default:
/* 383 */       bodyPart = new UnknownCommandBodyPart();
/*     */     }
/*     */ 
/* 386 */     return bodyPart;
/*     */   }
/*     */ 
/*     */   private static DataPacketBodyPart createCtrlMsgBody(byte[] bodyBytes)
/*     */   {
/* 392 */     int msgId = 0;
/*     */     try {
/* 394 */       msgId = 0xFFFF & ((0xFF & bodyBytes[22]) << 8) + (0xFF & bodyBytes[23]);
/*     */     } catch (Exception e) {
/* 396 */       log.error("DataPacketBodyPart createCtrlMsgBody", e);
/*     */     }
/*     */     DataPacketBodyPart bodyPart;
/* 398 */     switch (msgId) {
/*     */     case 5377:
/* 400 */       bodyPart = new UpCtrlMsgMonitorVehicleAck_0x1501();
/* 401 */       break;
/*     */     case 5378:
/* 403 */       bodyPart = new UpCtrlMsgTakePhotoAck_0x1502();
/* 404 */       break;
/*     */     case 5379:
/* 406 */       bodyPart = new UpCtrlMsgTextInfoAck_0x1503();
/* 407 */       break;
/*     */     case 5380:
/* 409 */       bodyPart = new UpCtrlMsgTakeTravelAck_0x1504();
/* 410 */       break;
/*     */     case 5381:
/* 412 */       bodyPart = new UpCtrlMsgEmergencyMonitoringAck_0x1505();
/* 413 */       break;
/*     */     case 38145:
/* 416 */       bodyPart = new DownCtrlMsgMonitorVehicleReq_0x9501();
/* 417 */       break;
/*     */     case 38146:
/* 419 */       bodyPart = new DownCtrlMsgTakePhotoReq_0x9502();
/* 420 */       break;
/*     */     case 38147:
/* 422 */       bodyPart = new DownCtrlMsgTextInfo_0x9503();
/* 423 */       break;
/*     */     case 38148:
/* 425 */       bodyPart = new DownCtrlMsgTakeTravelReq_0x9504();
/* 426 */       break;
/*     */     case 38149:
/* 428 */       bodyPart = new DownCtrlMsgEmergencyMonitoringReq_0x9505();
/* 429 */       break;
/*     */     default:
/* 431 */       bodyPart = new UnknownCommandBodyPart();
/*     */     }
/*     */ 
/* 434 */     return bodyPart;
/*     */   }
/*     */ 
/*     */   private static DataPacketBodyPart createWarnMsgBody(byte[] bodyBytes)
/*     */   {
/* 440 */     int msgId = 0;
/*     */     try {
/* 442 */       msgId = 0xFFFF & ((0xFF & bodyBytes[22]) << 8) + (0xFF & bodyBytes[23]);
/*     */     } catch (Exception e) {
/* 444 */       log.error("DataPacketBodyPart createWarnMsgBody", e);
/*     */     }
/*     */     DataPacketBodyPart bodyPart;
/* 446 */     switch (msgId) {
/*     */     case 5121:
/* 448 */       bodyPart = new UpWarnMsgUrgeTodoAck_0x1401();
/* 449 */       break;
/*     */     case 5122:
/* 451 */       bodyPart = new UpWarnMsgAdptInfo_0x1402();
/* 452 */       break;
/*     */     case 5123:
/* 454 */       bodyPart = new UpWarnMsgAdptTodoInfo_0x1403();
/* 455 */       break;
/*     */     case 37889:
/* 457 */       bodyPart = new DownWarnMsgUrgeTodoReq_0x9401();
/* 458 */       break;
/*     */     case 37890:
/* 460 */       bodyPart = new DownWarnMsgInformTips_0x9402();
/* 461 */       break;
/*     */     case 37891:
/* 463 */       bodyPart = new DownWarnMsgExgInform_0x9403();
/* 464 */       break;
/*     */     default:
/* 466 */       bodyPart = new UnknownCommandBodyPart();
/*     */     }
/*     */ 
/* 469 */     return bodyPart;
/*     */   }
/*     */ 
/*     */   private static DataPacketBodyPart createPlatformMsgBody(byte[] bodyBytes)
/*     */   {
/* 475 */     int msgId = 0;
/*     */     try {
/* 477 */       msgId = 0xFFFF & ((0xFF & bodyBytes[0]) << 8) + (0xFF & bodyBytes[1]);
/*     */     } catch (Exception e) {
/* 479 */       log.error("DataPacketBodyPart createPlatformMsgBody", e);
/*     */     }
/*     */     DataPacketBodyPart bodyPart;
/* 481 */     switch (msgId) {
/*     */     case 4865:
/* 483 */       bodyPart = new UpPlatformMsgPostQueryAck_0x1301();
/* 484 */       break;
/*     */     case 4866:
/* 486 */       bodyPart = new UpPlatformMsgInfoAck_0x1302();
/* 487 */       break;
/*     */     case 37633:
/* 489 */       bodyPart = new DownPlatformMsgPostQueryReq_0x9301();
/* 490 */       break;
/*     */     case 37634:
/* 492 */       bodyPart = new DownPlatformMsgInfoReq_0x9302();
/* 493 */       break;
/*     */     default:
/* 495 */       bodyPart = new UnknownCommandBodyPart();
/*     */     }
/*     */ 
/* 498 */     return bodyPart;
/*     */   }
/*     */ 
/*     */   private static DataPacketBodyPart createExgMsgBody(byte[] bodyBytes)
/*     */   {
/* 504 */     int msgId = 0;
/*     */     try {
/* 506 */       msgId = 0xFFFF & ((0xFF & bodyBytes[22]) << 8) + (0xFF & bodyBytes[23]);
/*     */     } catch (Exception e) {
/* 508 */       log.error("DataPacketBodyPart createExgMsgBody", e);
/*     */     }
/*     */     DataPacketBodyPart bodyPart;
/* 510 */     switch (msgId) {
/*     */     case 4609:
/* 512 */       bodyPart = new UpExgMsgRegister_0x1201();
/* 513 */       break;
/*     */     case 4610:
/* 515 */       bodyPart = new UpExgMsgRealLocation_0x1202();
/* 516 */       break;
/*     */     case 4611:
/* 518 */       bodyPart = new UpExgMsgHistoryLocation_0x1203();
/* 519 */       break;
/*     */     case 4613:
/* 521 */       bodyPart = new UpExgMsgReturnStartupAck_0x1205();
/* 522 */       break;
/*     */     case 4614:
/* 524 */       bodyPart = new UpExgMsgReturnEndAck_0x1206();
/* 525 */       break;
/*     */     case 4615:
/* 527 */       bodyPart = new UpExgMsgApplyForMonitorStartup_0x1207();
/* 528 */       break;
/*     */     case 4616:
/* 530 */       bodyPart = new UpExgMsgApplyForMonitorEnd_0x1208();
/* 531 */       break;
/*     */     case 4617:
/* 533 */       bodyPart = new UpExgMsgApplyHistoryDataReq_0x1209();
/* 534 */       break;
/*     */     case 4618:
/* 536 */       bodyPart = new UpExgMsgReportDriverInfoAck_0x120A();
/* 537 */       break;
/*     */     case 4619:
/* 539 */       bodyPart = new UpExgMsgTakeEwaybillAck_0x120B();
/* 540 */       break;
/*     */     case 4620:
/* 542 */       bodyPart = new UpExgMsgReportDriverInfoAck_0x120A();
/* 543 */       break;
/*     */     case 4621:
/* 545 */       bodyPart = new UpExgMsgTakeEwaybillAck_0x120B();
/* 546 */       break;
/*     */     case 37378:
/* 549 */       bodyPart = new DownExgMsgCarLocation_0x9202();
/* 550 */       break;
/*     */     case 37379:
/* 552 */       bodyPart = new DownExgMsgHistoryArcossarea_0x9203();
/* 553 */       break;
/*     */     case 37380:
/* 555 */       bodyPart = new DownExgMsgCarInfo_0x9204();
/* 556 */       break;
/*     */     case 37381:
/* 558 */       bodyPart = new DownExgMsgReturnStartup_0x9205();
/* 559 */       break;
/*     */     case 37382:
/* 561 */       bodyPart = new DownExgMsgReturnEnd_0x9206();
/* 562 */       break;
/*     */     case 37383:
/* 564 */       bodyPart = new DownExgMsgApplyForMonitorStartupAck_0x9207();
/* 565 */       break;
/*     */     case 37384:
/* 567 */       bodyPart = new DownExgMsgApplyForMonitorEndAck_0x9208();
/* 568 */       break;
/*     */     case 37385:
/* 570 */       bodyPart = new DownExgMsgApplyHisgnssdataAck_0x9209();
/* 571 */       break;
/*     */     case 37386:
/* 573 */       bodyPart = new DownExgMsgReportDriverInfo_0x920A();
/* 574 */       break;
/*     */     case 37387:
/* 576 */       bodyPart = new DownExgMsgTakeEwaybillReq_0x920B();
/* 577 */       break;
/*     */     default:
/* 579 */       bodyPart = new UnknownCommandBodyPart();
/*     */     }
/*     */ 
/* 582 */     return bodyPart;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt809_2011.DataPacketBodyPartFactory
 * JD-Core Version:    0.6.1
 */