package org.iswin.Entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class Link
  implements RowMapper<Link>, Serializable
{
  private static final long serialVersionUID = -1025515783939877506L;
  private int id;
  private String url;
  private String descript;

  public Link()
  {
  }

  public Link(int id, String url, String des)
  {
    this.id = id;
    this.url = url;
    this.descript = des;
  }
  public int getId() {
    return this.id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getUrl() {
    return this.url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public String getDescript() {
    return this.descript;
  }
  public void setDescript(String descript) {
    this.descript = descript;
  }

  public Link mapRow(ResultSet rs, int arg1) throws SQLException {
    return new Link(rs.getInt("id"), rs.getString("url"), rs.getString("descript"));
  }
}