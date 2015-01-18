package org.iswin.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Resource;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("cron")
public class Cron
{

  @Resource
  private JdbcTemplate jdbcTemplate;
  private String url = "http://api.bluereader.org/hot";

  public String getJson() throws IOException {
    URL u = new URL(this.url);
    HttpURLConnection conn = (HttpURLConnection)u.openConnection();
    BufferedReader read = new BufferedReader(new InputStreamReader(
      conn.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line = null;
    while ((line = read.readLine()) != null) {
      sb.append(line).append("\n");
    }
    return sb.toString();
  }

  public int updateblueReader() throws IOException, ParseException {
    String json = getJson();
    JSONParser parse = new JSONParser();
    JSONArray array = (JSONArray)parse.parse(json);
    System.out.println("Fetch data!");
    this.jdbcTemplate.update("truncate table bluereader");
    for (Iterator localIterator = array.iterator(); localIterator.hasNext(); ) { Object o = localIterator.next();
      String title = ((Map)o).get("title").toString();
      String link = ((Map)o).get("link").toString();
      String data = ((Map)o).get("pubTime").toString();
      this.jdbcTemplate.update(
        "insert into bluereader(title,link,data) values(?,?,?)", 
        new Object[] { title, link, data });
    }
    return 0;
  }

  public void cron() {
    Timer time = new Timer();
    time.schedule(new TimerTask()
    {
      public void run() {
        try {
          System.out.println("start the task!");
          Cron.this.updateblueReader();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (ParseException e) {
          e.printStackTrace();
        }
      }
    }
    , 2000L, 120000L);
  }
}