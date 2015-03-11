<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>${article.title} - ${article.category} - 随风's Blog</title>
<title>${config.name}|${config.descript}</title>
<meta name="description" content="${config.descript}">
<meta name="keywords" content="${config.keywords}">
<meta name="author" content="${config.name}">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="${webroot }/resources/css/bootstrap.min.css">

<link href="${webroot }/resources/kindeditor/plugins/code/prettify.css"
	type="text/css" rel="stylesheet" />
<link href="${webroot }/resources/kindeditor/plugins/code/desert.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${webroot }/resources/kindeditor/plugins/code/prettify.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
pre.prettyprint {
	font-size: 12px;
}

.muted {
	margin-right: 30px;
}
</style>
</head>
<body onload="prettyPrint()">
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-inverse" role="navigation">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${webroot}">首页</a></li>
					<c:forEach var="cate" items="${category}">
						<li><a href="${webroot}/category/${cate.id}">${cate.name}</a></li>
					</c:forEach>
				</ul>
				<ul class="nav navbar-right">
					<form class="navbar-form" role="search" action="${webroot}/search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="搜索">
						</div>
						<button type="submit" class="btn btn-success">搜索</button>
					</form>
				</ul>
			</nav>
		</div>

		<div class="row">
			<div class="col-md-9">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="">
								<p>
								<h4>${article.title}</h4>
								</p>
								<span class="muted"><i class="glyphicon glyphicon-user"></i>${article.author}</span>
								<span class="muted"><i
									class="glyphicon glyphicon-eye-open"></i>${article.viewcount}</span> <span
									class="muted"><i class="glyphicon glyphicon-time"></i> <fmt:formatDate
										value="${article.addtime}" type="date" /></span> <span class="muted"><i
									class="glyphicon glyphicon-list-alt"></i>${article.category}</span>
							</div>
						</div>
						<div class="panel-body">${article.content}</div>
					</div>
				</div>
				<ul class="pager">
					<li class="previous"><a href="#">&larr; 上一篇</a></li>
					<li class="next"><a href="#">下一篇 &rarr;</a></li>
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
			<div class="col-md-3">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">安全热点(由深蓝阅读驱动)</h3>
					</div>
					<ul class="list-group">
						<c:forEach items="${bluereader}" var="blue">
							<li class="list-group-item"><a
								href="${blue.link}" target="_blank">${blue.title}</a></li>
						</c:forEach>
					</ul>
				</div>
				
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">热门文章</h3>
					</div>
					<ul class="list-group">
						<c:forEach items="${hotarticle}" var="article">
							<li class="list-group-item"><a
								href="${webroot}/a/${article.id}">${article.title}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">友情链接</h3>
					</div>
					<ul class="list-group">
						<c:forEach items="${links}" var="link">
							<li class="list-group-item"><a href="${link.url}">${link.descript}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>

		<div class="row">
			<nav class="navbar navbar-inverse" role="navigation">
				<p class="navbar-text navbar-left">
					版权所有，保留一切权利！ © 2014 <a href="#" class="navbar-link">随风'S Blog</a>，本程序基于Spring
					Mvc。Theme & Coding By iswin
				</p>
			</nav>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${webroot }/resources/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${webroot }/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=3&amp;lang=zh"></script>
	<script type="text/javascript" charset="utf-8"
		src="http://static.bshare.cn/b/bshareC0.js"></script>


</body>
</html>
