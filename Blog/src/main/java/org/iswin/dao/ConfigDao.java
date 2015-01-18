package org.iswin.dao;

import org.iswin.Entity.Config;

public abstract interface ConfigDao
{
  public abstract Config getConfig();

  public abstract void updateConfig(Config paramConfig);
}