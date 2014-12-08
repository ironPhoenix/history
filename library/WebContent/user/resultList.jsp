<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>相关书目信息</title>
    <link href="../jscss/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../jscss/dashboard.css" rel="stylesheet">
    <script src="../jscss/assets/js/ie-emulation-modes-warning.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../user/bookSearch.jsp">图书管理系统</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li></li>
			</ul>
			<form class="navbar-form navbar-right" action="../search/find" method="post">
				<input type="text" name="bookName" class="form-control" placeholder="图书搜索">
			</form>
		</div>	
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="../search/find?pageNumber=${currentPageNumber-1} ">上一页</a></li>
					<li><a href="../search/find?pageNumber=${currentPageNumber+1} ">下一页</a></li>
					<li><a>当前第 ${currentPageNumber} 页</a></li>
					<li><a>共 ${maxPageNumber} 页</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">相关书目信息</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>书籍名称</th>
								<th>作者</th>
								<th>出版社</th>
								<th>出版日期</th>
								<th>详细信息</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${bookKindList}" var="l">
								<tr>
									<td>${l.bookName}</td>
									<td>${l.author}</td>
									<td>${l.publishing}</td>
									<td>${l.publishTime}</td>
									<td><a href="../search/look?indexNumber=${l.indexNumber}"><button
												type="button" class="btn btn-xs btn-success">查看</button></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../jscss/dist/js/bootstrap.min.js"></script>
	<script src="../jscss/assets/js/docs.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../jscss/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>