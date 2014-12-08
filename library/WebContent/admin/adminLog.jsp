<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../jscss/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../jscss/signin.css" rel="stylesheet">
<script src="../jscss/assets/js/ie-emulation-modes-warning.js"></script>
<title>管理员登陆</title>
</head>
<body>
	 <div class="container">
      <form class="form-signin" action="../admin/login" method="post" role="form">
        <h2 class="form-signin-heading">管理员登陆</h2>
        <input type="text" class="form-control" name="username" placeholder="用户名" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>