<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>分类管理</title>
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
					<button type="button" class="btn btn-primary">
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
					<div class="panel-heading">文章类型管理</div>
					<div class="panel-body">
						<form role="form" method="post">
							<div class="form-group">
								<label>类型</label> <input type="text" class="form-control"
									name="name" placeholder="类型"> <br>
								<button type="submit" class="btn btn-success">添加</button>
							</div>
						</form>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>类别</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${categorys}" var="cate">
									<tr>
										<td>${cate.name}</td>
										<td><a href="./update/${cate.id}" onclick="return false">修改</a>|<a
											href="./del/${cate.id}">删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="updatecate" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">修改类别</h4>
				</div>
				<form id="cateupdate" method="post" onsubmit="getUrl()">
					<div class="modal-body">
						<h3 class="modal-title">新类别</h3>
						<input class="form-control input-lg" type="text" name="name">
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary">
						<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<button id="modify">a</button>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${webroot }/resources/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${webroot }/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var url;
		function getUrl() {
			$('form').attr('action', url);
		}

		$("tbody tr td a").click(function() {
			url = $(this).attr("href");
			$('#updatecate').modal('show');
		});
	</script>
</body>
</html>