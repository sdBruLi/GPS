package com.china317.core.base;

import com.china317.core.codec.jtt808_2011.UnitPackJT808;

public abstract interface UpMessage extends Message
{
  public abstract String getCommand();

  public abstract void unpack(UnitPackJT808 paramUnitPackJT808);
}

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.base.UpMessage
 * JD-Core Version:    0.6.1
 */