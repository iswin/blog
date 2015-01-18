<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改密码</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

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
					<button type="button" class="btn btn-primary">
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
					<div class="panel-heading">修改密码</div>
					<div class="panel-body">
						<form role="form" method="post">
							<div class="form-group">
								<label for="name">昵称</label> <input type="text"
									class="form-control" id="name" name="nickname" value="随风"
									placeholder="昵称">
							</div>
							<div class="form-group">
								<label for="name">新密码</label> <input type="password"
									class="form-control" id="name" name="password"
									placeholder="新密码">
							</div>
							<div class="form-group">
								<label for="desc">新密码确认</label> <input type="password"
									class="form-control" id="desc" name="password1"
									placeholder="新密码确认">
							</div>

							<button type="submit" class="btn btn-success">修改</button>
						</form>
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