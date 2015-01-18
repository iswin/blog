package org.iswin.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.iswin.Entity.Link;
import org.iswin.dao.LinkDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("link")
public class LinkDaoImpl
  implements LinkDao
{

  @Resource
  private JdbcTemplate jdbcTemplate;

  public List<Link> getLinks()
  {
    return this.jdbcTemplate.query("select * from link", new Link());
  }

  public void updateLink(Link link)
  {
    this.jdbcTemplate
      .update("update link set url=?,descript=? where id=?", 
      new Object[] { link.getUrl(), link.getDescript(), 
      Integer.valueOf(link.getId()) });
  }

  public void delLink(int id)
  {
    this.jdbcTemplate.update("delete from link where id=?", new Object[] { Integer.valueOf(id) });
  }

  public void addLink(Link l)
  {
    this.jdbcTemplate.update("insert into link(url,descript) values(?,?)", 
      new Object[] { l.getUrl(), l.getDescript() });
  }
}