package org.iswin.dao;

import java.util.List;
import org.iswin.Entity.Link;

public abstract interface LinkDao
{
  public abstract List<Link> getLinks();

  public abstract void updateLink(Link paramLink);

  public abstract void delLink(int paramInt);

  public abstract void addLink(Link paramLink);
}