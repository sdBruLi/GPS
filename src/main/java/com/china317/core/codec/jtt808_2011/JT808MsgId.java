/*     */ package com.china317.core.codec.jtt808_2011;
/*     */ 
/*     */ public class JT808MsgId
/*     */ {
/*     */   public static final int MSGID_CLIENT_response = 1;
/*     */   public static final int MSGID_CLIENT_heartbeat = 2;
/*     */   public static final int MSGID_CLIENT_deregister = 3;
/*     */   public static final int MSGID_CLIENT_register = 256;
/*     */   public static final int MSGID_CLIENT_authentication = 258;
/*     */   public static final int MSGID_CLIENT_response_query_parameter = 260;
/*     */   public static final int MSGID_CLIENT_response_query_property = 263;
/*     */   public static final int MSGID_CLIENT_update_result = 264;
/*     */   public static final int MSGID_CLIENT_position = 512;
/*     */   public static final int MSGID_CLIENT_response_query_position = 513;
/*     */   public static final int MSGID_CLIENT_event_report = 769;
/*     */   public static final int MSGID_CLIENT_response_question = 770;
/*     */   public static final int MSGID_CLIENT_info_order_or_cancel = 771;
/*     */   public static final int MSGID_CLIENT_vehicle_control = 1280;
/*     */   public static final int MSGID_CLIENT_driver_record_upload = 1792;
/*     */   public static final int MSGID_CLIENT_elec_freight_note = 1793;
/*     */   public static final int MSGID_CLIENT_driver_info_report = 1794;
/*     */   public static final int MSGID_CLIENT_batch_position = 1796;
/*     */   public static final int MSGID_CLIENT_can_data_report = 1797;
/*     */   public static final int MSGID_CLIENT_multimedia_event_upload = 2048;
/*     */   public static final int MSGID_CLIENT_multimedia_upload = 2049;
/*     */   public static final int MSGID_CLIENT_store_multimedia_searches = 2050;
/*     */   public static final int MSGID_CLIENT_shot_immedi_resp = 2053;
/*     */   public static final int MSGID_CLIENT_data_up_trans = 2304;
/*     */   public static final int MSGID_CLIENT_data_compression_upload = 2305;
/*     */   public static final int MSGID_CLIENT_terminal_rsa = 2560;
/*     */   public static final int MSGID_SERVER_response = 32769;
/*     */   public static final int MSGID_SERVER_data_reload_resp = 32771;
/*     */   public static final int MSGID_SERVER_response_register = 33024;
/*     */   public static final int MSGID_SERVER_setting_parameter = 33027;
/*     */   public static final int MSGID_SERVER_query_parameter = 33028;
/*     */   public static final int MSGID_SERVER_control = 33029;
/*     */   public static final int MSGID_SERVER_query_select_parameter = 33030;
/*     */   public static final int MSGID_SERVER_query_terminal = 33031;
/*     */   public static final int MSGID_SERVER_update_down = 33032;
/*     */   public static final int MSGID_SERVER_query_position = 33281;
/*     */   public static final int MSGID_SERVER_temp_position_track = 33282;
/*     */   public static final int MSGID_SERVER_send_text = 33536;
/*     */   public static final int MSGID_SERVER_event_setting = 33537;
/*     */   public static final int MSGID_SERVER_question = 33538;
/*     */   public static final int MSGID_SERVER_order_menu_setting = 33539;
/*     */   public static final int MSGID_SERVER_info_service = 33540;
/*     */   public static final int MSGID_SERVER_phone_callback = 33792;
/*     */   public static final int MSGID_SERVER_phonedirectory_setting = 33793;
/*     */   public static final int MSGID_SERVER_vehicle_control = 34048;
/*     */   public static final int MSGID_SERVER_setting_circle_region = 34304;
/*     */   public static final int MSGID_SERVER_delete_circle_region = 34305;
/*     */   public static final int MSGID_SERVER_setting_rectangle_region = 34306;
/*     */   public static final int MSGID_SERVER_delete_rectangle_region = 34307;
/*     */   public static final int MSGID_SERVER_setting_polygon_region = 34308;
/*     */   public static final int MSGID_SERVER_delete_polygon_region = 34309;
/*     */   public static final int MSGID_SERVER_setting_route = 34310;
/*     */   public static final int MSGID_SERVER_delete_route = 34311;
/*     */   public static final int MSGID_SERVER_driver_record_gather = 34560;
/*     */   public static final int MSGID_SERVER_driver_record_param_down = 34561;
/*     */   public static final int MSGID_SERVER_driverinfo_query = 34562;
/*     */   public static final int MSGID_SERVER_response_multimedia_upload = 34816;
/*     */   public static final int MSGID_SERVER_shot_immedi = 34817;
/*     */   public static final int MSGID_SERVER_store_multimedia_searches = 34818;
/*     */   public static final int MSGID_SERVER_store_multimedia_upload = 34819;
/*     */   public static final int MSGID_SERVER_record_start = 34820;
/*     */   public static final int MSGID_SERVER_single_multi_search_upload = 34821;
/*     */   public static final int MSGID_SERVER_data_down_trans = 35072;
/*     */   public static final int MSGID_SERVER_platform_rsa = 35328;
/*     */ 
/*     */   public static String getStringCommand(int command)
/*     */   {
/* 268 */     StringBuffer line = new StringBuffer("0x");
/* 269 */     String tempLin = Integer.toHexString(command);
/* 270 */     for (int i = 0; i < 4 - tempLin.length(); i++) {
/* 271 */       line.append("0");
/*     */     }
/* 273 */     line.append(tempLin);
/* 274 */     return line.toString().toLowerCase();
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.JT808MsgId
 * JD-Core Version:    0.6.1
 */