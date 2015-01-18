package org.iswin.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.iswin.Entity.Article;
import org.iswin.Entity.Category;
import org.iswin.Entity.PageHelp;
import org.iswin.dao.NewsDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("news")
public class NewsDaoImpl
  implements NewsDao
{

  @Resource
  private JdbcTemplate jdbcTemplate;

  public void createArticle(Article a)
  {
    try
    {
      this.jdbcTemplate
        .update("insert into article(title,content,summary,addtime,viewcount,author,category) values(?,?,?,?,?,?,?)", 
        new Object[] { a.getTitle(), a.getContent(), 
        a.getSummary(), 
        new Timestamp(System.currentTimeMillis()), 
        Integer.valueOf(0), a.getAuthor(), a.getCategory() });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void updateArticle(Article a)
  {
    try {
      this.jdbcTemplate
        .update("update article set title=?,content=?,summary=?,category=? where id=?", 
        new Object[] { a.getTitle(), a.getContent(), 
        a.getSummary(), a.getCategory(), Integer.valueOf(a.getId()) });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void deleteArticle(int id)
  {
    this.jdbcTemplate.update("delete from article where id=?", 
      new Object[] { Integer.valueOf(id) });
  }

  public void createCategory(Category c)
  {
    this.jdbcTemplate.update("insert into category(name) values(?)", 
      new Object[] { c.getName() });
  }

  public void deleteCategory(int id)
  {
    this.jdbcTemplate.update("delete from category where id=?", 
      new Object[] { Integer.valueOf(id) });
  }

  public void updateCategory(Category c)
  {
    this.jdbcTemplate.update("update category set name=? where id=?", 
      new Object[] { c.getName(), Integer.valueOf(c.getId()) });
  }

  public List<Article> getArticles(PageHelp page)
  {
    return this.jdbcTemplate
      .query("SELECT a.id as id,a.title as title,a.content as content,a.Summary as summary,a.addtime as addtime,a.viewcount as viewcount,u.nickname as author,c.name as category from article a join user u join category c ON (a.author=u.id and c.id=a.category) order by a.addtime desc limit ?,?", 
      new Object[] { 
      Integer.valueOf((page.getCurrentpage() - 1) * 
      page.getPagesize()), 
      Integer.valueOf(page.getPagesize()) }, new Article());
  }

  public Article getArticleById(int id)
  {
    return 
      (Article)this.jdbcTemplate
      .queryForObject(
      "SELECT a.id as id,a.title as title,a.content as content,a.Summary as summary,a.addtime as addtime,a.viewcount as viewcount,u.nickname as author,c.name as category from article a join user u join category c ON (a.author=u.id and c.id=a.category) where a.id=?", 
      new Object[] { Integer.valueOf(id) }, new Article());
  }

  public List<Article> getArticleByCategoryId(int cateid, PageHelp page)
  {
    return this.jdbcTemplate
      .query("SELECT a.id as id,a.title as title,a.content as content,a.Summary as summary,a.addtime as addtime,a.viewcount as viewcount,u.nickname as author,c.name as category from article a join user u join category c ON (a.author=u.id and c.id=a.category) where a.category=?", 
      new Object[] { Integer.valueOf(cateid) }, 
      new Article());
  }

  public List<Category> getCategorys()
  {
    return this.jdbcTemplate.query("select * from category", new Category());
  }

  public int getArticleCount()
  {
    return ((Integer)this.jdbcTemplate.queryForObject("select count(*) from article", 
      Integer.class)).intValue();
  }

  public void updateArticleCount(int id)
  {
    this.jdbcTemplate.update(
      "update article set viewcount=viewcount+1 where id=?", 
      new Object[] { Integer.valueOf(id) });
  }

  public List<Article> getHotArticle()
  {
    return this.jdbcTemplate.query(
      "select * from article order by viewcount desc limit 0,8", 
      new Article());
  }

  public List<Article> searchArticle(String key)
  {
    return this.jdbcTemplate
      .query("SELECT a.id as id,a.title as title,a.content as content,a.Summary as summary,a.addtime as addtime,a.viewcount as viewcount,u.nickname as author,c.name as category from article a join user u join category c ON (a.author=u.id and c.id=a.category) where a.title like ? or a.content like ?", 
      new Object[] { "%" + key + "%", "%" + key + "%" }, 
      new Article());
  }

  public List<Map<String, Object>> getJsonData(PageHelp page)
  {
    return this.jdbcTemplate
      .queryForList(
      "select id,title from article order by addtime desc limit ?,?", 
      new Object[] { 
      Integer.valueOf((page.getCurrentpage() - 1) * 
      page.getPagesize()), 
      Integer.valueOf(page.getPagesize()) });
  }

  public List<Map<String, Object>> getBlueReader()
  {
    return this.jdbcTemplate.queryForList("select title,link from bluereader order by FROM_UNIXTIME(data,'%Y-%m-%d %H:%m:%s') desc");
  }
}