package org.iswin.dao.impl;

import javax.annotation.Resource;
import org.iswin.Entity.Config;
import org.iswin.dao.ConfigDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("config")
public class ConfigDaoImpl
  implements ConfigDao
{

  @Resource
  private JdbcTemplate jdbcTemplate;

  public Config getConfig()
  {
    return 
      (Config)this.jdbcTemplate
      .queryForObject("select * from config", new Config());
  }

  public void updateConfig(Config c)
  {
    this.jdbcTemplate.update("update config set name=?,descript=?,keywords=?", 
      new Object[] { c.getName(), c.getDescript(), c.getKeywords() });
  }
}