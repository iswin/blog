package org.iswin.service;

import java.util.List;
import java.util.Map;
import org.iswin.Entity.Article;
import org.iswin.Entity.Category;
import org.iswin.Entity.Link;
import org.iswin.Entity.PageHelp;

public abstract interface CommonService
{
  public abstract List<Article> getArticles(PageHelp paramPageHelp);

  public abstract Article getArticleById(int paramInt);

  public abstract List<Article> getArticleByCategoryId(int paramInt, PageHelp paramPageHelp);

  public abstract List<Category> getCategorys();

  public abstract List<Link> getLinks();

  public abstract int getArticleCount();

  public abstract void updateLink(Link paramLink);

  public abstract void delLink(int paramInt);

  public abstract void updateArticleCount(int paramInt);

  public abstract List<Article> getHotArticle();

  public abstract void addLink(Link paramLink);

  public abstract List<Article> searchArticle(String paramString);

  public abstract List<Map<String, Object>> getJsonData(PageHelp paramPageHelp);

  public abstract List<Map<String, Object>> getBlueReader();
}