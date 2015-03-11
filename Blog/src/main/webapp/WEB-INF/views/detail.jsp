<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>随风'S Blog|网络安全爱好者,专注于Web应用安全漏洞研究</title>
    <meta name="google-site-verification" content="UCztEW9E5nPyQ57Ahe4i-oGOYgpYucmjpK5t7xk94xU" />
    <title>${article.title} - ${article.category} - 随风's Blog</title>
<title>${config.name}|${config.descript}</title>
<meta name="description" content="${config.descript}">
<meta name="keywords" content="${config.keywords}">
<meta name="author" content="${config.name}">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
     <link rel="stylesheet" href="${webroot }/resources/css/amazeui.min.css" />
    <link href="${webroot }/resources/kindeditor/plugins/code/prettify.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${webroot }/resources/kindeditor/plugins/code/prettify.js"></script>
   
    <style>
        @media only screen and (min-width: 1200px) {
            .blog-g-fixed {
                max-width: 95%;
            }
        }
        @media only screen and (min-width: 641px) {
            .blog-sidebar {
                font-size: 1.4rem;
            }
        }
        .blog-main {
            padding: 20px 0;
        }
        .blog-title {
            margin: 10px 0 20px 0;
        }
        .blog-meta {
            font-size: 14px;
            margin: 10px 0 20px 0;
            color: #222;
        }
        .blog-meta a {
            color: #27ae60;
        }
        .blog-pagination a {
            font-size: 1.4rem;
        }
        .blog-team li {
            padding: 4px;
        }
        .blog-team img {
            margin-bottom: 0;
        }
        .blog-footer {
            padding: 10px 0;
            text-align: center;
        }
    </style>
</head>

<body onload="prettyPrint()">
    <header class="am-topbar">
        <h1 class="am-topbar-brand">
    <a href="${webroot}">随风'S Blog</a>
  </h1>


        <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li class="am-active"><a href="${webroot}">首页</a>
                </li>
                <c:forEach var="cate" items="${category}">
                    <li><a href="${webroot}/category/${cate.id}">${cate.name}</a>
                    </li>
                </c:forEach>
            </ul>

            <form class="am-topbar-form am-topbar-left am-form-inline am-topbar-right" action="${webroot}/search" role="search">
                <div class="am-form-group">
                    <input type="text" class="am-form-field am-input-sm" placeholder="搜索文章">
                </div>
                <button type="submit" class="am-btn am-btn-default am-btn-sm">搜索</button>
            </form>

        </div>
    </header>

    <div class="am-g am-g-fixed blog-g-fixed">
        <div class="am-u-md-9">
                <article class="blog-main">
                    <h3 class="am-article-title blog-title">
        <a href="${webroot}/a/${article.id}">${article.title}</a>
      </h3>
                    <h4 class="am-article-meta blog-meta">by <a href="">${article.author} </a> posted on <fmt:formatDate value="${article.addtime}" type="date" /> under <a href="#">${article.category}</a></h4>
                    <div class="am-g blog-content">
                        ${article.content}
                    </div>
                </article>
            <hr class="am-article-divider blog-hr">
            <ul class="am-pagination blog-pagination">
                <li class="am-pagination-prev"><a href="${webroot}/p/${pageNO-1}">&laquo; 上一页</a>
                </li>
                <li class="am-pagination-next"><a href="${webroot}/p/${pageNO+1}">下一页 &raquo;</a>
                </li>
            </ul>
            <div class="bshare-custom">
					<span>分享此文:</span> <a title="分享到QQ空间" class="bshare-qzone"></a><a
						title="分享到新浪微博" class="bshare-sinaminiblog"></a><a title="分享到人人网"
						class="bshare-renren"></a><a title="分享到腾讯微博" class="bshare-qqmb"></a><a
						title="分享到网易微博" class="bshare-neteasemb"></a><a title="更多平台"
						class="bshare-more bshare-more-icon more-style-addthis"></a><span
						class="BSHARE_COUNT bshare-share-count">0</span>
				</div>
				<div class="ds-thread" data-thread-key="${article.id}"
					data-title="${article.title}"
					data-url="http://www.iswin.org/a/${article.id}"></div>
				<script type="text/javascript">
					var duoshuoQuery = {
						short_name : "iswin"
					};
					(function() {
						var ds = document.createElement('script');
						ds.type = 'text/javascript';
						ds.async = true;
						ds.src = (document.location.protocol == 'https:' ? 'https:'
								: 'http:')
								+ '//static.duoshuo.com/embed.js';
						ds.charset = 'UTF-8';
						(document.getElementsByTagName('head')[0] || document
								.getElementsByTagName('body')[0])
								.appendChild(ds);
					})();
				</script>
				<!-- 多说公共JS代码 end -->


        </div>

        <div class="am-u-md-3 blog-sidebar">
            <div class="am-panel-group">
                <section class="am-panel am-panel-default">
                    <div class="am-panel-hd">关于我</div>
                    <div class="am-panel-bd">
                        <p></p>
                    </div>
                </section>

                <section class="am-panel am-panel-default">
                    <div class="am-panel-hd">安全热点(由深蓝阅读驱动)</div>
                    <ul class="am-list blog-list">
                        <c:forEach items="${bluereader}" var="blue">
							<li><a href="${blue.link}" target="_blank">${blue.title}</a></li>
						</c:forEach>
                    </ul>
                </section>

                <section class="am-panel am-panel-default">
                    <div class="am-panel-hd">热门文章</div>
                    <ul class="am-list blog-list">
                        <c:forEach items="${hotarticle}" var="article">
							<li><a
								href="${webroot}/a/${article.id}">${article.title}</a></li>
						</c:forEach>
                    </ul>
                </section>

                <section class="am-panel am-panel-default">
                    <div class="am-panel-hd">友情链接</div>
                    <ul class="am-list blog-list">
                       <c:forEach items="${links}" var="link">
							<li><a href="${link.url}">${link.descript}</a></li>
						</c:forEach>
                    </ul>
                </section>

            </div>
        </div>

    </div>

    <footer class="blog-footer">
        <p>
            版权所有，保留一切权利！ © 2014 随风'S Blog</br><small>本程序基于Spring Mvc。Theme & Coding By iswin</small>
        </p>
    </footer>

    <!--[if lt IE 9]>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<![endif]-->

    <!--[if (gte IE 9)|!(IE)]><!-->
 <script src="${webroot }/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${webroot }/resources/js//amazeui.min.js"></script>
    <!--<![endif]-->
	<script type="text/javascript" charset="utf-8"
		src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=3&amp;lang=zh"></script>
	<script type="text/javascript" charset="utf-8"
		src="http://static.bshare.cn/b/bshareC0.js"></script>
</body>

</html>