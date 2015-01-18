package org.iswin.router;

import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.iswin.Entity.Article;
import org.iswin.Entity.Category;
import org.iswin.Entity.Link;
import org.iswin.Entity.PageHelp;
import org.iswin.Entity.User;
import org.iswin.service.CommonService;
import org.iswin.service.UserService;
import org.iswin.task.Cron;
import org.iswin.util.NameComparator;
import org.iswin.util.SizeComparator;
import org.iswin.util.TypeComparator;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SystemAction {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "commonService")
	private CommonService commonService;

	@Resource(name = "cron")
	private Cron cron;

	@RequestMapping(value = { "/xcoderiswinLogin/article/create" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public String createArticle(@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("category") int category,
			@RequestParam("summary") String summary, HttpSession session) {
		User u = (User) session.getAttribute("user");
		this.userService
				.createArticle(new Article(0, title, content, summary, null, 0,
						Integer.valueOf(u.getId()), Integer.valueOf(category)));
		return "redirect:/xcoderiswinLogin/article/all";
	}

	@RequestMapping(value = { "/xcoderiswinLogin/article/create" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String createArticles(ModelMap map) {
		map.addAttribute("category", this.commonService.getCategorys());
		return "/system/article/create";
	}

	@RequestMapping(value = { "/xcoderiswinLogin/article/update/{id}" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public String updateArticleByid(@PathVariable("id") String id,
			ModelMap map, @RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("category") int category,
			@RequestParam("summary") String summary, HttpSession session) {
		User u = (User) session.getAttribute("user");
		if (id != null) {
			this.userService.updateArticle(new Article(Integer.parseInt(id),
					title, content, summary, null, 0,
					Integer.valueOf(u.getId()), Integer.valueOf(category)));
		}
		return "redirect:/xcoderiswinLogin/article/all";
	}

	@RequestMapping(value = { "/xcoderiswinLogin/article/update/{id}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String updateArticle(@PathVariable("id") int id, ModelMap map) {
		map.addAttribute("article", this.commonService.getArticleById(id));
		map.addAttribute("category", this.commonService.getCategorys());
		return "/system/article/update";
	}

	@RequestMapping({ "/xcoderiswinLogin/article/all" })
	public String showArticles(ModelMap map) {
		int count = this.commonService.getArticleCount();
		PageHelp p = new PageHelp(1, count);
		System.out.println(p.getTotalpages());
		List<Article> article = this.commonService.getArticles(p);
		for (Article a : article) {
			System.out.println(a.getAuthor().toString() + "  "
					+ a.getCategory());
		}
		map.addAttribute("articles", article);
		map.addAttribute("pno", Integer.valueOf(1));
		return "/system/article/all";
	}

	@RequestMapping({ "/xcoderiswinLogin/article/all/{no}" })
	public String showArticlesByPno(@PathVariable("no") String no, ModelMap map) {
		int pno = 1;
		if (no != null) {
			try {
				pno = Integer.parseInt(no);
			} catch (NumberFormatException e) {
				pno = 1;
			}
		}
		int count = this.commonService.getArticleCount();
		PageHelp p = new PageHelp(pno, count);
		System.out.println(p.getTotalpages());
		List<Article> article = this.commonService.getArticles(p);
		for (Article a : article) {
			System.out.println(a.getAuthor().toString() + "  "
					+ a.getCategory());
		}
		map.addAttribute("articles", article);
		map.addAttribute("pno", Integer.valueOf(pno));
		return "/system/article/all";
	}

	@RequestMapping({ "/xcoderiswinLogin/article/del/{id}" })
	public String delArticleById(@PathVariable("id") String id) {
		if (id != null)
			this.userService.deleteArticle(Integer.parseInt(id));
		return "redirect:/xcoderiswinLogin/article/all";
	}

	@RequestMapping(value = { "/xcoderiswinLogin/category/add" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String categoryCreate(ModelMap map) {
		map.addAttribute("categorys", this.commonService.getCategorys());
		return "/system/category";
	}

	@RequestMapping(value = { "/xcoderiswinLogin/category/add" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public String createCategory(@RequestParam("name") String name) {
		this.userService.createCategory(new Category(0, name));
		return "redirect:/xcoderiswinLogin/category/add";
	}

	@RequestMapping({ "/xcoderiswinLogin/category/del/{id}" })
	public String delCategory(@PathVariable("id") String id) {
		if (id != null) {
			this.userService.deleteCategory(Integer.parseInt(id));
		}
		return "redirect:/xcoderiswinLogin/category/add";
	}

	@RequestMapping(value = { "/xcoderiswinLogin/category/update/{id}" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public String updateCateGory(@PathVariable String id,
			@RequestParam("name") String name) {
		if ((id != null) && (name != null)) {
			this.userService.updateCategory(new Category(Integer.parseInt(id),
					name));
		}
		return "redirect:/xcoderiswinLogin/category/add";
	}

	@RequestMapping({ "/xcoderiswinLogin/link/all" })
	public String getLinks(ModelMap map) {
		map.addAttribute("links", this.commonService.getLinks());
		return "/system/link";
	}

	@RequestMapping(value = { "/xcoderiswinLogin/link/add" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public String addLink(@RequestParam("url") String url,
			@RequestParam("descript") String descript) {
		this.commonService.addLink(new Link(0, url, descript));
		return "redirect:/xcoderiswinLogin/link/all";
	}

	@RequestMapping({ "/xcoderiswinLogin/link/del/{id}" })
	public String delLink(@PathVariable("id") String id) {
		if (id != null) {
			this.commonService.delLink(Integer.parseInt(id));
		}
		return "redirect:/xcoderiswinLogin/link/all";
	}

	@RequestMapping({ "/xcoderiswinLogin/task/run" })
	public void runTask() {
		this.cron.cron();
	}

	@RequestMapping({ "/xcoderiswinLogin/file/file_manager_json" })
	public void fileUpload_json(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/resources/attached/";
		String rootUrl = request.getContextPath() + "/resources/attached/";
		String[] fileTypes = { "gif", "jpg", "jpeg", "png", "bmp" };

		String dirName = request.getParameter("dir");
		if (dirName != null) {
			if (!Arrays.asList(
					new String[] { "image", "flash", "media", "file" })
					.contains(dirName)) {
				out.println("Invalid Directory name.");
				return;
			}
			rootPath = rootPath + dirName + "/";
			rootUrl = rootUrl + dirName + "/";
			File saveDirFile = new File(rootPath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
		}
		String path = request.getParameter("path") != null ? request
				.getParameter("path") : "";
		String currentPath = rootPath + path;
		String currentUrl = rootUrl + path;
		String currentDirPath = path;
		String moveupDirPath = "";
		if (!"".equals(path)) {
			String str = currentDirPath.substring(0,
					currentDirPath.length() - 1);
			moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0,
					str.lastIndexOf("/") + 1) : "";
		}
		String order = request.getParameter("order") != null ? request
				.getParameter("order").toLowerCase() : "name";

		if (path.indexOf("..") >= 0) {
			out.println("Access is not allowed.");
			return;
		}
		if ((!"".equals(path)) && (!path.endsWith("/"))) {
			out.println("Parameter is not valid.");
			return;
		}
		File currentPathFile = new File(currentPath);
		if (!currentPathFile.isDirectory()) {
			out.println("Directory does not exist.");
			return;
		}
		List fileList = new ArrayList();
		if (currentPathFile.listFiles() != null) {
			for (File file : currentPathFile.listFiles()) {
				Hashtable hash = new Hashtable();
				String fileName = file.getName();
				if (file.isDirectory()) {
					hash.put("is_dir", Boolean.valueOf(true));
					hash.put("has_file",
							Boolean.valueOf(file.listFiles() != null));
					hash.put("filesize", Long.valueOf(0L));
					hash.put("is_photo", Boolean.valueOf(false));
					hash.put("filetype", "");
				} else if (file.isFile()) {
					String fileExt = fileName.substring(
							fileName.lastIndexOf(".") + 1).toLowerCase();
					hash.put("is_dir", Boolean.valueOf(false));
					hash.put("has_file", Boolean.valueOf(false));
					hash.put("filesize", Long.valueOf(file.length()));
					hash.put(
							"is_photo",
							Boolean.valueOf(Arrays.asList(fileTypes).contains(
									fileExt)));
					hash.put("filetype", fileExt);
				}
				hash.put("filename", fileName);
				hash.put("datetime",
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long
								.valueOf(file.lastModified())));
				fileList.add(hash);
			}
		}
		if ("size".equals(order))
			Collections.sort(fileList, new SizeComparator());
		else if ("type".equals(order))
			Collections.sort(fileList, new TypeComparator());
		else {
			Collections.sort(fileList, new NameComparator());
		}
		JSONObject result = new JSONObject();
		result.put("moveup_dir_path", moveupDirPath);
		result.put("current_dir_path", currentDirPath);
		result.put("current_url", currentUrl);
		result.put("total_count", Integer.valueOf(fileList.size()));
		result.put("file_list", fileList);
		response.setContentType("application/json; charset=UTF-8");
		out.println(result.toJSONString());
	}

	@RequestMapping({ "/xcoderiswinLogin/file/upload_json" })
	public void upload_json(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out)
			throws FileUploadException {
		String savePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/resources/attached/";

		String saveUrl = request.getContextPath() + "/resources/attached/";

		HashMap extMap = new HashMap();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		long maxSize = 1000000L;

		response.setContentType("text/html; charset=UTF-8");

		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println(getError("请选择文件。"));
			return;
		}
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			out.println(getError("上传目录不存在。"));
			return;
		}
		if (!uploadDir.canWrite()) {
			out.println(getError("上传目录没有写权限。"));
			return;
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if (!extMap.containsKey(dirName)) {
			out.println(getError("目录名不正确。"));
			return;
		}
		savePath = savePath + dirName + "/";
		saveUrl = saveUrl + dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath = savePath + ymd + "/";
		saveUrl = saveUrl + ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List items = upload.parseRequest(request);
		Iterator itr = items.iterator();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			String fileName = item.getName();
			long fileSize = item.getSize();
			if (!item.isFormField()) {
				if (item.getSize() > maxSize) {
					out.println(getError("上传文件大小超过限制。"));
					return;
				}
				String fileExt = fileName.substring(
						fileName.lastIndexOf(".") + 1).toLowerCase();

				if (!Arrays.asList(((String) extMap.get(dirName)).split(","))
						.contains(fileExt)) {
					out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许"
							+ (String) extMap.get(dirName) + "格式。"));
					return;
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_"
						+ new Random().nextInt(1000) + "." + fileExt;
				try {
					File uploadedFile = new File(savePath, newFileName);
					item.write(uploadedFile);
				} catch (Exception e) {
					out.println(getError("上传文件失败。"));
					return;
				}

				JSONObject obj = new JSONObject();
				obj.put("error", Integer.valueOf(0));
				obj.put("url", saveUrl + newFileName);
				out.println(obj.toJSONString());
			}
		}
	}

	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", Integer.valueOf(1));
		obj.put("message", message);
		return obj.toJSONString();
	}
}