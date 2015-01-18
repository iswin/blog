package org.iswin.listener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter
  implements Filter
{
  public void destroy()
  {
  }

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException
  {
    HttpServletRequest request = (HttpServletRequest)req;
    HttpServletResponse response = (HttpServletResponse)res;
    String loginpath = request.getRequestURI();
    String login = "/xcoderiswinLogin/login";
    if (!loginpath.startsWith(login)) {
      Object auth = request.getSession().getAttribute("user");
      if (auth == null) {
        response.sendRedirect(login);
        return;
      }
    }
    chain.doFilter(req, res);
  }

  public void init(FilterConfig conf)
    throws ServletException
  {
  }
}