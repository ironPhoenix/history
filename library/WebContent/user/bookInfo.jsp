<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书详情</title>
<link href="../jscss/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../jscss/dashboard.css" rel="stylesheet">
    <script src="../jscss/assets/js/ie-emulation-modes-warning.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
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
            <li class="active"><a href="#">Overview</a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">图书详情</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="/library/tmp/${bookKind.indexNumber}.jpg" width="150" height="150" class="img-responsive" alt="这本书长什么样，服务器也忘了">
              <h4>${bookKind.bookName}</h4>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
            
              <span class="text-muted">作者: ${bookKind.author }</span>
			  <hr />
			  <span class="text-muted">出版社: ${bookKind.publishing }</span>
			  <hr />
			  <span class="text-muted">出版时间: ${bookKind.publishTime }</span>
			  <hr />
			  <span class="text-muted">引索号: ${bookKind.indexNumber }</span>
            </div>
          </div>

          <h2 class="sub-header">图书在馆信息</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>所属藏室</th>
                  <th>是否在馆</th>
                  <th>借出日期</th>
                  <th>续借次数</th>
                </tr>
              </thead>
              
              <tbody>
              	<c:forEach items="${bookKind.books}" var="l">
					<tr>
						<td>${l.room}</td>
						<c:if test="${l.borrower==null}">
							<td>在管</td>
							<td>（无）</td>
							<td>（无）</td>
						</c:if>
						<c:if test="${l.borrower!=null}">
							<td>借出</td>
							<td>${l.borrowedDate }</td>
							<td>${l.renewedTimes }次</td>
						</c:if>
						
					</tr>
				</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>