package org.iswin.router;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.iswin.Entity.PageHelp;
import org.iswin.service.CommonService;
import org.iswin.task.Cron;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/api"})
public class Api
{

  @Resource(name="commonService")
  private CommonService commonService;

  @Resource(name="cron")
  private Cron cron;

  @RequestMapping(value={"/content/{pno}"}, produces={"text/html;charset=UTF-8"})
  public void getAllArticle(@PathVariable("pno") Object pageno, HttpServletResponse res)
    throws IOException
  {
    this.cron.cron();
    res.setCharacterEncoding("utf-8");
    res.setContentType("text/html; charset=utf-8");
    PrintWriter out = res.getWriter();
    int pageNo = 1;
    try {
      pageNo = Integer.parseInt(pageno.toString());
    } catch (NumberFormatException e) {
      pageNo = 1;
    }
    List list = this.commonService
      .getJsonData(new PageHelp(pageNo, this.commonService
      .getArticleCount()));
    out.print(JSONArray.toJSONString(list));
  }
}