package com.china317.core.event;

import org.apache.mina.core.session.IoSession;

public abstract interface SessionClosedListener
{
  public abstract void sessionClosed(IoSession paramIoSession);
}

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.event.SessionClosedListener
 * JD-Core Version:    0.6.1
 */