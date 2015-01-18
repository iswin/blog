package org.iswin.Entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;

public class Article
  implements RowMapper<Article>, Serializable
{
  private static final long serialVersionUID = 3412298255996825789L;
  private int id;
  private String title;
  private String content;
  private String summary;
  private Timestamp addtime;
  private int viewcount;
  private Object author;
  private Object category;

  public Article()
  {
  }

  public Article(int id, String title, String content, String summary, Timestamp addtime, int viewcount, Object author, Object category)
  {
    this.id = id;
    this.title = title;
    this.content = content;
    this.summary = summary;
    this.addtime = addtime;
    this.viewcount = viewcount;
    this.author = author;
    this.category = category;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSummary() {
    return this.summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Timestamp getAddtime() {
    return this.addtime;
  }

  public void setAddtime(Timestamp addtime) {
    this.addtime = addtime;
  }

  public int getViewcount() {
    return this.viewcount;
  }

  public void setViewcount(int viewcount) {
    this.viewcount = viewcount;
  }

  public Article mapRow(ResultSet rs, int rows) throws SQLException
  {
    return new Article(rs.getInt("id"), rs.getString("title"), 
      rs.getString("content"), rs.getString("summary"), 
      rs.getTimestamp("addtime"), rs.getInt("viewcount"), 
      rs.getObject("author"), rs.getObject("category"));
  }

  public Object getAuthor() {
    return this.author;
  }

  public void setAuthor(Object author) {
    this.author = author;
  }

  public Object getCategory() {
    return this.category;
  }

  public void setCategory(Object category) {
    this.category = category;
  }
}