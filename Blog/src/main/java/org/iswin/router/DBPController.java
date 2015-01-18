package org.iswin.router;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DBPController
{

  @Value("#{configProperties['jdbc.dir']}")
  private String backpath;

  @Value("#{configProperties['jdbc.username']}")
  private String dbuser;

  @Value("#{configProperties['jdbc.password']}")
  private String dbpass;

  @Value("#{configProperties['jdbc.dbname']}")
  private String dbname;

  @Value("#{configProperties['jdbc.host']}")
  private String dbhost;

  @Value("#{configProperties['mysql.bin.dir']}")
  private String mysqlbin;

  public String backUpData(String name)
  {
    String path = this.backpath + "/" + name;
    try {
      Runtime.getRuntime().exec(
        backParameters(this.mysqlbin, this.dbhost, this.dbuser, this.dbpass, this.dbname, 
        path));
    } catch (IOException e) {
      return "ERROR:" + e.getMessage();
    }
    return path;
  }

  private String backParameters(String bin, String host, String user, String pass, String dbname, String destination)
  {
    String cmd = bin + 
      "mysqldump -h %s -u%s %s --lock-all-tables=true --result-file=%s --default-character-set=utf8 %s";
    if (!pass.isEmpty())
      pass = "-p" + pass;
    cmd = String.format(cmd, new Object[] { host, user, pass, destination, dbname });
    return cmd;
  }

  @RequestMapping(value={"/xcoderiswinLogin/db/backup"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void backUp(PrintWriter out) {
    SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
    String now = sf.format(new Date(System.currentTimeMillis()));
    String res = backUpData(now);
    out.print(res);
  }
}