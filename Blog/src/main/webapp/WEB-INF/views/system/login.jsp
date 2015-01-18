<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>管理员登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${webroot }/resources/css/bootstrap.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    .container{
      width: 30%;
    }
    .form-signin .form-signin-heading {
      text-align:center;
    }
    </style>
  </head>
  <body>
    <div class="container">
      <form class="form-signin" role="form" method="post">
        <h2 class="form-signin-heading">登录</h2>
        <input type="text" name="username" class="form-control input-lg" placeholder="用户名" required autofocus>
        <br>
        <input type="password" name="password" class="form-control input-lg" placeholder="密码" required>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${webroot }/resources/js/jquery-1.11.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${webroot }/resources/js/bootstrap.min.js"></script>
  </body>
</html>