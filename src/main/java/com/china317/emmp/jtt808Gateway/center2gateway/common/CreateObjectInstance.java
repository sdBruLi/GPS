/*    */ package com.china317.emmp.jtt808Gateway.center2gateway.common;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ 
/*    */ public class CreateObjectInstance
/*    */ {
/*  6 */   private static CreateObjectInstance instance = new CreateObjectInstance();
/*    */ 
/*    */   public static CreateObjectInstance getInstance()
/*    */   {
/* 10 */     return instance;
/*    */   }
/*    */ 
/*    */   public Object createObjectInstance(String className) throws Exception {
/* 14 */     Object o = null;
/* 15 */     Class c = Class.forName(className);
/* 16 */     Constructor constructor = c.getConstructor(new Class[0]);
/* 17 */     o = constructor.newInstance(null);
/* 18 */     return o;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.common.CreateObjectInstance
 * JD-Core Version:    0.6.1
 */