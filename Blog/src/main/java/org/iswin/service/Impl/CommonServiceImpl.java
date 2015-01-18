package org.iswin.service.Impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.iswin.Entity.Article;
import org.iswin.Entity.Category;
import org.iswin.Entity.Link;
import org.iswin.Entity.PageHelp;
import org.iswin.dao.LinkDao;
import org.iswin.dao.NewsDao;
import org.iswin.service.CommonService;
import org.springframework.stereotype.Service;

@Service("commonService")
public class CommonServiceImpl
  implements CommonService
{

  @Resource(name="news")
  private NewsDao dao;

  @Resource(name="link")
  private LinkDao linkDao;

  public List<Article> getArticles(PageHelp page)
  {
    return this.dao.getArticles(page);
  }

  public Article getArticleById(int id)
  {
    return this.dao.getArticleById(id);
  }

  public List<Article> getArticleByCategoryId(int cateid, PageHelp page)
  {
    return this.dao.getArticleByCategoryId(cateid, page);
  }

  public List<Category> getCategorys()
  {
    return this.dao.getCategorys();
  }

  public List<Link> getLinks()
  {
    return this.linkDao.getLinks();
  }

  public void updateLink(Link link)
  {
    this.linkDao.updateLink(link);
  }

  public void delLink(int id)
  {
    this.linkDao.delLink(id);
  }

  public int getArticleCount()
  {
    return this.dao.getArticleCount();
  }

  public void updateArticleCount(int id)
  {
    this.dao.updateArticleCount(id);
  }

  public List<Article> getHotArticle()
  {
    return this.dao.getHotArticle();
  }

  public void addLink(Link l)
  {
    this.linkDao.addLink(l);
  }

  public List<Article> searchArticle(String key)
  {
    return this.dao.searchArticle(key);
  }

  public List<Map<String, Object>> getJsonData(PageHelp page)
  {
    return this.dao.getJsonData(page);
  }

  public List<Map<String, Object>> getBlueReader()
  {
    return this.dao.getBlueReader();
  }
}