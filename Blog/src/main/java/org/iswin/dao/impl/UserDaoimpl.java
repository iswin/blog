package org.iswin.dao.impl;

import javax.annotation.Resource;
import org.iswin.Entity.User;
import org.iswin.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("user")
public class UserDaoimpl
  implements UserDao
{

  @Resource
  private JdbcTemplate jdbcTemplate;

  public boolean userLogin(User u)
  {
    int count = ((Integer)this.jdbcTemplate.queryForObject(
      "select count(*) from user where username=? and password=?", 
      new Object[] { u.getUsername(), u.getPassword() }, 
      Integer.class)).intValue();

    if (count > 0)
      return true;
    return false;
  }

  public void updateUser(User u) {
    try {
      this.jdbcTemplate.update(
        "update user set password=?,nickname=? where username=?", 
        new Object[] { u.getPassword(), u.getNickname(), 
        u.getUsername() });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public User getUser(String username)
  {
    return (User)this.jdbcTemplate.queryForObject(
      "select * from user where username=?", 
      new Object[] { username }, new User());
  }
}