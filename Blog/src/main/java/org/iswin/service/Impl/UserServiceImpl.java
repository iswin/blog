package org.iswin.service.Impl;

import javax.annotation.Resource;
import org.iswin.Entity.Article;
import org.iswin.Entity.Category;
import org.iswin.Entity.Config;
import org.iswin.Entity.User;
import org.iswin.dao.ConfigDao;
import org.iswin.dao.NewsDao;
import org.iswin.dao.UserDao;
import org.iswin.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl
  implements UserService
{

  @Resource(name="news")
  private NewsDao newsdao;

  @Resource(name="user")
  private UserDao userdao;

  @Resource(name="config")
  private ConfigDao config;

  public boolean userLogin(User u)
  {
    return this.userdao.userLogin(u);
  }

  public void updateUser(User u)
  {
    this.userdao.updateUser(u);
  }

  public User getUser(String username)
  {
    return this.userdao.getUser(username);
  }

  public void createArticle(Article a)
  {
    this.newsdao.createArticle(a);
  }

  public void updateArticle(Article a)
  {
    this.newsdao.updateArticle(a);
  }

  public void deleteArticle(int id)
  {
    this.newsdao.deleteArticle(id);
  }

  public void createCategory(Category c)
  {
    this.newsdao.createCategory(c);
  }

  public void deleteCategory(int id)
  {
    this.newsdao.deleteCategory(id);
  }

  public void updateCategory(Category c)
  {
    this.newsdao.updateCategory(c);
  }

  public Config getConfig()
  {
    return this.config.getConfig();
  }

  public void updateConfig(Config c)
  {
    this.config.updateConfig(c);
  }
}