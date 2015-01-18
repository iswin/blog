<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>查看所有文章</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
.navbar-blue {
	background-color: #009966
}

.btn-default {
	margin-right: 50px;
}

.btn-primary a {
	color: white
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">随风博客管理系统</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="btn btn-group-vertical">
					<button type="button" class="btn btn-default">
						<a href="../">网站设置</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="../user/update">修改密码</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="../category/add">添加分类</a>
					</button>
					<button type="button" class="btn btn-primary">
						<a href="../article/all">查看所有文章</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="../article/create">添加文章</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="../link/all">友情连接</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="../logout">退出</a>
					</button>
				</div>
			</div>
			<div class="col-md-9">
				<div class="panel panel-info">
					<div class="panel-heading">查看所有文章</div>
					<!-- Table -->
					<table class="table table-hover">
						<thead>
							<tr>
								<th width="10%">ID</th>
								<th width="65%">文章标题</th>
								<th width="10%">作者</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${articles}" var="article">
								<tr>
									<td>${article.id}</td>
									<td><a href="${webroot}/a/${article.id}">${article.title}</a></td>
									<td><a href="">${article.author}</a></td>
									<td><a href="${webroot}/xcoderiswinLogin/article/update/${article.id}">修改</a>｜<a
										href="${webroot}/xcoderiswinLogin/article/del/${article.id}">删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<ul class="pager">
						<li><a href="${webroot}/xcoderiswinLogin/article/all/${pno-1}">上一页</a></li>
						<li><a href="${webroot}/xcoderiswinLogin/article/all/${pno+1}">下一页</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${webroot }/resources/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${webroot }/resources/js/bootstrap.min.js"></script>
</body>
</html>