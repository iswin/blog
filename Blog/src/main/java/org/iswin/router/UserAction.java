package org.iswin.router;

import java.io.IOException;
import java.io.PrintStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.iswin.Entity.User;
import org.iswin.service.UserService;
import org.iswin.util.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAction
{

  @Resource(name="userService")
  private UserService userService;

  @RequestMapping(value={"/admin/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String userLogin()
  {
    return "/system/login";
  }

  @RequestMapping({"/admin/"})
  public String systemIndex(ModelMap map) {
    map.addAttribute("config", this.userService.getConfig());
    return "/system/index";
  }

  @RequestMapping(value={"/admin/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView userLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, HttpServletResponse resp)
  {
    boolean res = false;
    ModelAndView mv = new ModelAndView();
    try {
      res = this.userService
        .userLogin(new User(username, MD5.getMd5(password)));
      if (!res) {
        mv.setViewName("redirect:/admin/login");
      } else {
        System.out.println("success");
        session.setAttribute("user", this.userService.getUser(username));
        mv.setViewName("redirect:/admin/");
      }
    } catch (Exception e) {
      try {
        resp.sendRedirect("../");
      } catch (IOException ee) {
        ee.printStackTrace();
      }
    }
    return mv;
  }

  @RequestMapping({"/admin/logout"})
  public ModelAndView logOut(HttpSession session) {
    session.removeAttribute("user");
    return new ModelAndView("redirect:/admin/login");
  }

  @RequestMapping(value={"/admin/user/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String userUpdate(@RequestParam("nickname") String nickname, @RequestParam("password") String password, HttpSession session)
  {
    User u = (User)session.getAttribute("user");
    this.userService.updateUser(new User(0, u.getUsername(), nickname, 
      MD5.getMd5(password)));
    session.removeAttribute("user");
    return "redirect:/admin/login";
  }

  @RequestMapping(value={"/admin/user/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String updateUser() {
    return "/system/password";
  }
}