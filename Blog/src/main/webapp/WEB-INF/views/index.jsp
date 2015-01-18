<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="google-site-verification" content="UCztEW9E5nPyQ57Ahe4i-oGOYgpYucmjpK5t7xk94xU" />
<title>${config.name}|${config.descript}</title>
<meta name="description" content="${config.descript}">
<meta name="keywords" content="${config.keywords}">
<meta name="author" content="${config.name}">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="${webroot }/resources/kindeditor/plugins/code/prettify.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${webroot }/resources/kindeditor/plugins/code/prettify.js"></script>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="${webroot }/resources/css/bootstrap.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
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
					<form class="navbar-form" role="search" action="${webroot}/search"
						method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="key"
								placeholder="搜索">
						</div>
						<button type="submit" class="btn btn-success">搜索</button>
					</form>
				</ul>
			</nav>
		</div>

		<div class="row">
			<div class="col-md-9">
				<c:forEach items="${articles}" var="article">
					<div class="row">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="">
									<p>
										<a href="${webroot}/a/${article.id}"><h4>${article.title}</h4></a>
									</p>
									<span class="muted"><i class="glyphicon glyphicon-user"></i>${article.author}</span>
									<span class="muted"><i
										class="glyphicon glyphicon-eye-open"></i>${article.viewcount}</span>
									<span class="muted"><i class="glyphicon glyphicon-time"></i>
										<fmt:formatDate value="${article.addtime}" type="date" /></span> <span
										class="muted"><i class="glyphicon glyphicon-list-alt"></i>${article.category}</span>
								</div>
							</div>
							<div class="panel-body">${article.summary}<a
									href="${webroot}/a/${article.id}">...更多内容</a>
							</div>
						</div>
					</div>
				</c:forEach>


				<ul class="pager">
					<li><a href="${webroot}/p/${pageNO-1}">&larr; 前一页</a></li>
					<li><a href="${webroot}/p/${pageNO+1}">后一页 &rarr;</a></li>
				</ul>

			</div>
			<div class="col-md-3">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">安全热点(由深蓝阅读驱动)</h3>
					</div>
					<ul class="list-group">
						<c:forEach items="${bluereader}" var="blue">
							<li class="list-group-item"><a href="${blue.link}" target="_blank">${blue.title}</a></li>
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
</body>
</html>
