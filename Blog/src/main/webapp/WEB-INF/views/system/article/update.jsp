<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>添加文章</title>
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
<link rel="stylesheet"
	href="${webroot }/resources/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="${webroot }/resources/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8"
	src="${webroot }/resources/kindeditor/kindeditor.js"></script>
<script charset="utf-8"
	src="${webroot }/resources/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="${webroot }/resources/kindeditor/plugins/code/prettify.js"></script>
<script>
	KindEditor
			.ready(function(K) {
				var editor1 = K
						.create(
								'textarea[name="content"]',
								{
									cssPath : '${webroot}/resources/kindeditor/plugins/code/prettify.css',
									uploadJson : 'kindeditor/jsp/upload_json.jsp',
									fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
									allowFileManager : true,
									afterCreate : function() {
										var self = this;
										K.ctrl(document, 13, function() {
											self.sync();
											document.forms['createarticle']
													.submit();
										});
										K.ctrl(self.edit.doc, 13, function() {
											self.sync();
											document.forms['createarticle']
													.submit();
										});
									}
								});
				prettyPrint();
			});
</script>

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
						<a href="./">网站设置</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="">修改密码</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="">添加分类</a>
					</button>
					<button type="button" class="btn btn-primary">
						<a href="">添加文章</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="">查看所有文章</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="">查看友情连接</a>
					</button>
					<button type="button" class="btn btn-default">
						<a href="">添加友情连接</a>
					</button>
				</div>
			</div>
			<div class="col-md-9">
				<div class="panel panel-info">
					<div class="panel-heading">添加文章</div>
					<div class="panel-body">
						<form role="form" name="createarticle" method="post">
							<input type="hidden" name="id" value="${article.id}">
							<div class="form-group">
								<label>标题</label> <input type="text" class="form-control"
									name="title" value="${article.title}" placeholder="标题">
							</div>
							<div class="form-group">
								<label>分类</label> <br> <select class="btn btn-primary"
									name="category">
									<c:forEach items="${category}" var="cate">
										<option value=${cate.id}>${cate.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label>摘要</label>
								<textarea cols="110" rows="5" name="summary">${article.summary}</textarea>
							</div>
							<div class="form-group">
								<label>内容</label>
								<textarea name="content" cols="110" rows="20">${article.content}</textarea>
								<br /> <input type="submit" class="btn btn-success"
									name="button" value="发布" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${webroot }/resources/js/jquery-1.11.1.min.js"></script>
	<script src="${webroot }/resources/js/bootstrap.min.js"></script>
</body>
</html>