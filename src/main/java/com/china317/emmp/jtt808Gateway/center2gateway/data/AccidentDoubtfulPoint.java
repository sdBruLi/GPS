/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.data;
/*    */ 
/*    */ import com.china317.core.codec.jtt808_2011.util.ByteUtil;
/*    */ import com.china317.emmp.jtt808Gateway.server.common.UtilTime;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class AccidentDoubtfulPoint
/*    */ {
/*    */   private String time;
/*    */   private List<SpeedSwitchingNode> nodes;
/*    */ 
/*    */   public String getTime()
/*    */   {
/* 14 */     return this.time;
/*    */   }
/*    */   public void setTime(String time) {
/* 17 */     this.time = time;
/*    */   }
/*    */   public List<SpeedSwitchingNode> getNodes() {
/* 20 */     return this.nodes;
/*    */   }
/*    */   public void setNodes(List<SpeedSwitchingNode> nodes) {
/* 23 */     this.nodes = nodes;
/*    */   }
/*    */   public int parse(int index, byte[] datas) {
/* 26 */     int currentIndex = index;
/* 27 */     byte[] timebytes = new byte[6];
/* 28 */     System.arraycopy(datas, currentIndex, timebytes, 0, 6);
/* 29 */     currentIndex += 6;
/* 30 */     this.time = ByteUtil.getHexString(timebytes);
/* 31 */     for (int i = 0; i < 100; i++) {
/* 32 */       SpeedSwitchingNode node = new SpeedSwitchingNode();
/* 33 */       node.setSpeed(datas[(currentIndex++)]);
/* 34 */       node.setSwitching(datas[(currentIndex++)]);
/* 35 */       if (this.nodes == null) {
/* 36 */         this.nodes = new ArrayList();
/*    */       }
/* 38 */       this.nodes.add(node);
/*    */     }
/* 40 */     return currentIndex;
/*    */   }
/*    */   public String getAccidentDoubtfulLine() {
/* 43 */     StringBuffer line = new StringBuffer("");
/* 44 */     for (int i = 0; i < this.nodes.size(); i++) {
/* 45 */       line.append(((SpeedSwitchingNode)this.nodes.get(i)).toString());
/* 46 */       if (i != this.nodes.size() - 1) {
/* 47 */         line.append(",");
/*    */       }
/*    */     }
/* 50 */     return line.toString();
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 54 */     StringBuffer line = new StringBuffer("");
/* 55 */     line.append("time:");
/* 56 */     line.append(UtilTime.BCDTimeToCommon(this.time));
/* 57 */     line.append(" nodes:");
/* 58 */     for (SpeedSwitchingNode node : this.nodes) {
/* 59 */       line.append("[");
/* 60 */       line.append(node.toString());
/* 61 */       line.append("] ");
/*    */     }
/* 63 */     return line.toString();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.data.AccidentDoubtfulPoint
 * JD-Core Version:    0.6.1
 */