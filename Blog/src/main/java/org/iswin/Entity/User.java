package org.iswin.Entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class User
  implements RowMapper<User>, Serializable
{
  private static final long serialVersionUID = 1L;
  private int id;
  private String username;
  private String nickname;
  private String password;

  public User()
  {
  }

  public User(String username, String password)
  {
    this.username = username;
    this.password = password;
  }
  public User(int id, String username, String nickname, String password) {
    this.id = id;
    this.username = username;
    this.nickname = nickname;
    this.password = password;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNickname() {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User mapRow(ResultSet rs, int count) throws SQLException
  {
    return new User(rs.getInt("id"), rs.getString("username"), 
      rs.getString("nickname"), rs.getString("password"));
  }
}