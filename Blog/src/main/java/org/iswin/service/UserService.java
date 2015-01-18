package org.iswin.service;

import org.iswin.Entity.Article;
import org.iswin.Entity.Category;
import org.iswin.Entity.Config;
import org.iswin.Entity.User;

public abstract interface UserService
{
  public abstract boolean userLogin(User paramUser);

  public abstract void updateUser(User paramUser);

  public abstract User getUser(String paramString);

  public abstract void createArticle(Article paramArticle);

  public abstract void updateArticle(Article paramArticle);

  public abstract void deleteArticle(int paramInt);

  public abstract void createCategory(Category paramCategory);

  public abstract void deleteCategory(int paramInt);

  public abstract void updateCategory(Category paramCategory);

  public abstract Config getConfig();

  public abstract void updateConfig(Config paramConfig);
}