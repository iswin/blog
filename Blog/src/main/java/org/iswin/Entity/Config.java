package org.iswin.Entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class Config
  implements RowMapper<Config>, Serializable
{
  private static final long serialVersionUID = 5092984623844201109L;
  private String name;
  private String descript;
  private String keywords;

  public Config()
  {
  }

  public Config(String name, String des, String key)
  {
    this.name = name;
    this.descript = des;
    this.keywords = key;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescript() {
    return this.descript;
  }
  public void setDescript(String descript) {
    this.descript = descript;
  }
  public String getKeywords() {
    return this.keywords;
  }
  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public Config mapRow(ResultSet rs, int arg1) throws SQLException {
    return new Config(rs.getString("name"), rs.getString("descript"), rs.getString("keywords"));
  }
}