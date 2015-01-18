package org.iswin.router;

import java.io.PrintWriter;
import javax.annotation.Resource;
import org.iswin.Entity.PageHelp;
import org.iswin.service.CommonService;
import org.iswin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "commonService")
	private CommonService commonService;

	@RequestMapping(value = { "/" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String home(Model model) {
		model.addAttribute("config", this.userService.getConfig());
		model.addAttribute("category", this.commonService.getCategorys());
		model.addAttribute("links", this.commonService.getLinks());
		model.addAttribute("articles", this.commonService
				.getArticles(new PageHelp(1, this.commonService
						.getArticleCount())));
		model.addAttribute("hotarticle", this.commonService.getHotArticle());
		model.addAttribute("bluereader", this.commonService.getBlueReader());
		model.addAttribute("pageNO", Integer.valueOf(1));
		return "index";
	}

	@RequestMapping(value = { "/p/{id}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String homeByPageNo(Model model, @PathVariable Object id) {
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(id.toString());
		} catch (NumberFormatException e) {
			pageNo = 1;
		}
		System.out.println(pageNo);
		model.addAttribute("config", this.userService.getConfig());
		model.addAttribute("category", this.commonService.getCategorys());
		model.addAttribute("links", this.commonService.getLinks());
		model.addAttribute("articles", this.commonService
				.getArticles(new PageHelp(pageNo, this.commonService
						.getArticleCount())));
		model.addAttribute("hotarticle", this.commonService.getHotArticle());
		model.addAttribute("bluereader", this.commonService.getBlueReader());
		model.addAttribute("pageNO", Integer.valueOf(pageNo));
		return "index";
	}

	@RequestMapping({ "/a/{id}" })
	public String getArticleByid(@PathVariable String id, ModelMap map) {
		if (id != null) {
			map.addAttribute("category", this.commonService.getCategorys());
			map.addAttribute("links", this.commonService.getLinks());
			try {
				int ids = Integer.parseInt(id);
				map.addAttribute("article",
						this.commonService.getArticleById(ids));
				this.commonService.updateArticleCount(ids);
				map.addAttribute("hotarticle",
						this.commonService.getHotArticle());
				map.addAttribute("bluereader",
						this.commonService.getBlueReader());
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:../";
			}
		} else {
			return "redirect:../";
		}
		return "detail";
	}

	@RequestMapping({ "/category/{cname}" })
	public String getArticleByCategryname(@PathVariable("cname") String cname,
			ModelMap model) {
		if (cname != null) {
			try {
				model.addAttribute("config", this.userService.getConfig());
				model.addAttribute("category",
						this.commonService.getCategorys());
				model.addAttribute("links", this.commonService.getLinks());
				model.addAttribute(
						"articles",
						this.commonService.getArticleByCategoryId(
								Integer.parseInt(cname), new PageHelp(1, 0)));
				model.addAttribute("hotarticle",
						this.commonService.getHotArticle());
				model.addAttribute("bluereader",
						this.commonService.getBlueReader());
				model.addAttribute("pageNO", Integer.valueOf(1));
			} catch (Exception e) {
				return "redirect:../";
			}
		}
		return "index";
	}

	@RequestMapping(value = { "/search" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public String searchArticle(@RequestParam("key") String key, ModelMap model) {
		if (key != null) {
			try {
				model.addAttribute("config", this.userService.getConfig());
				model.addAttribute("category",
						this.commonService.getCategorys());
				model.addAttribute("links", this.commonService.getLinks());
				model.addAttribute("articles",
						this.commonService.searchArticle(key));
				model.addAttribute("hotarticle",
						this.commonService.getHotArticle());
				model.addAttribute("pageNO", Integer.valueOf(1));
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:./";
			}
		}
		return "index";
	}

	@RequestMapping({ "/error.php" })
	public void error(PrintWriter out) {
		out.print("Warning: fopen(config.php) [function.fopen]: failed to open stream: No such file or directory in /home/www/config.php on line 2");
	}
}