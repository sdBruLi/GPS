package com.china317.core.codec.jtt808_2011;

import org.apache.mina.core.buffer.IoBuffer;

public abstract interface UnitPackBody
{
  public abstract void bulidBody()
    throws Exception;

  public abstract void praseBody()
    throws Exception;

  public abstract IoBuffer getBodyBuffer();

  public abstract void setBodyBuffer(IoBuffer paramIoBuffer);

  public abstract boolean isBuildBody();
}

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.codec.jtt808_2011.UnitPackBody
 * JD-Core Version:    0.6.1
 */