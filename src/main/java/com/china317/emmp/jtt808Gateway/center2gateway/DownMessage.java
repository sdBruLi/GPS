package com.china317.emmp.jtt808Gateway.center2gateway;

import com.china317.core.base.Message;
import com.china317.core.codec.jtt808_2011.UnitPackJT808;

public abstract interface DownMessage extends Message
{
  public abstract String getCommand();

  public abstract UnitPackJT808 pack()
    throws Exception;

  public abstract String getMessageKey();
}

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\
 * Qualified Name:     com.china317.emmp.jtt808Gateway.center2gateway.DownMessage
 * JD-Core Version:    0.6.1
 */