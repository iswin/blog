package org.iswin.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class Category
  implements RowMapper<Category>
{
  private int id;
  private String name;

  public Category()
  {
  }

  public Category(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Category mapRow(ResultSet rs, int arg1) throws SQLException
  {
    return new Category(rs.getInt("id"), rs.getString("name"));
  }
}