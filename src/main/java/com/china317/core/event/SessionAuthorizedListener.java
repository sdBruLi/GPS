package com.china317.core.event;

import org.apache.mina.core.session.IoSession;

public abstract interface SessionAuthorizedListener
{
  public abstract void sessionAuthorized(IoSession paramIoSession, String paramString);
}

/* Location:           C:\Users\Administrator\Desktop\UpMessageProcessor\新建文件夹\core-1.2beta\
 * Qualified Name:     com.china317.core.event.SessionAuthorizedListener
 * JD-Core Version:    0.6.1
 */