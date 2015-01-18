package org.iswin.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BlogPara
  implements ServletContextListener
{
  public void contextDestroyed(ServletContextEvent context)
  {
  }

  public void contextInitialized(ServletContextEvent context)
  {
    context.getServletContext().setAttribute("webroot", 
      "http://127.0.0.1:8080/blog");
  }
}