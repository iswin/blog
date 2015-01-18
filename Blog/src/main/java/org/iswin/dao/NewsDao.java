package org.iswin.dao;

import java.util.List;
import java.util.Map;
import org.iswin.Entity.Article;
import org.iswin.Entity.Category;
import org.iswin.Entity.PageHelp;

public abstract interface NewsDao
{
  public abstract void createArticle(Article paramArticle);

  public abstract void updateArticle(Article paramArticle);

  public abstract void deleteArticle(int paramInt);

  public abstract void createCategory(Category paramCategory);

  public abstract void deleteCategory(int paramInt);

  public abstract void updateCategory(Category paramCategory);

  public abstract List<Article> getArticles(PageHelp paramPageHelp);

  public abstract Article getArticleById(int paramInt);

  public abstract List<Article> getArticleByCategoryId(int paramInt, PageHelp paramPageHelp);

  public abstract List<Category> getCategorys();

  public abstract int getArticleCount();

  public abstract void updateArticleCount(int paramInt);

  public abstract List<Article> getHotArticle();

  public abstract List<Article> searchArticle(String paramString);

  public abstract List<Map<String, Object>> getJsonData(PageHelp paramPageHelp);

  public abstract List<Map<String, Object>> getBlueReader();
}