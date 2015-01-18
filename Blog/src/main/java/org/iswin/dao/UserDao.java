package org.iswin.dao;

import org.iswin.Entity.User;

public abstract interface UserDao
{
  public abstract boolean userLogin(User paramUser);

  public abstract void updateUser(User paramUser);

  public abstract User getUser(String paramString);
}