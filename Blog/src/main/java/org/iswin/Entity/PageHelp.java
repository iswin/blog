package org.iswin.Entity;

public class PageHelp
{
  private int count;
  private int pagesize = 10;

  private int currentpage = 1;
  private int totalpages;

  public PageHelp(int pageno, int count)
  {
    this.currentpage = pageno;
    this.count = count;
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getPagesize() {
    return this.pagesize;
  }

  public void setPagesize(int pagesize) {
    this.pagesize = pagesize;
  }

  public int getCurrentpage() {
    int totlepage = getTotalpages();
    if ((this.currentpage > totlepage) || (this.currentpage <= 0))
      return totlepage;
    return this.currentpage;
  }

  public void setCurrentpage(int currentpage) {
    this.currentpage = currentpage;
  }

  public int getTotalpages() {
    this.totalpages = (this.count / this.pagesize + 1);
    return this.totalpages > 0 ? this.totalpages : 1;
  }

  public void setTotalpages(int totalpages) {
    this.totalpages = totalpages;
  }
}