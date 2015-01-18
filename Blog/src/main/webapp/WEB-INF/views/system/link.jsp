<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>友情链接管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link rel="stylesheet" href="${webroot}/resources/css/bootstrap.min.css" />

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
					<button type="button" class="btn btn-default">
						<a href="../article/all">查看所有文章</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="../article/create">添加文章</a>
					</button>
					<button type="button" class="btn btn-primary">
						<a href="../link/all">友情连接</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="../logout">退出</a>
					</button>
				</div>
			</div>
			<div class="col-md-9">
				<div class="panel panel-info">
					<div class="panel-heading">友情链接管理</div>
					<div class="panel-body">
						<form role="form" method="post" action="./add">
							<div class="form-group">
								<label for="name">地址</label> <input type="text"
									class="form-control" name="url" placeholder="地址"> <br>
								<label for="name">描述</label> <input type="text"
									class="form-control" name="descript" placeholder="描述">
								<br>
								<button type="submit" class="btn btn-success">添加</button>
							</div>
						</form>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>地址</th>
									<th>描述</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${links}" var="link">
									<tr>
										<td>${link.url}</td>
										<td>${link.descript}</td>
										<td><a href="./del/${link.id}">删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>