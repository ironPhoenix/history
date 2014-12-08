<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../jscss/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../jscss/justified-nav.css" rel="stylesheet">
<link href="../jscss/signin.css" rel="stylesheet">
<script src="../jscss/assets/js/ie-emulation-modes-warning.js"></script>
<title>读者还书</title>
</head>
<body>
	<div class="container">
      <div class="masthead">
        <h3 class="text-muted">管理员界面</h3>
        <ul class="nav nav-justified">
          <li><a href="borrowBook.jsp">读者借书</a></li>
          <li class="active"><a href="returnBook.jsp">读者还书</a></li>
          <li><a href="addBookKind.jsp">添加书种</a></li>
          <li><a href="addBook.jsp">添加书籍</a></li>
        </ul>
      </div>

     <form class="form-signin" action="../admin/returnb" method="post" role="form">
        <h2 class="form-signin-heading">读者还书</h2>
        <input type="text" class="form-control" name="bookId" placeholder="图书号" required autofocus/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">归还</button>
      </form>
    </div> <!-- /container -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>