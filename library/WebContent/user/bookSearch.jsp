<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>图书管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="/library/jscss/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="/library/jscss/dist/signin.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/library/jscss/jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../jscss/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>	
	 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">图书管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" role="form" action="/library/borrower/login" method="post">
            <div class="form-group">
              <input type="text" name="username" placeholder="读者号" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" name="password" placeholder="密码" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">登陆</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
         <form class="form-signin" action="/library/search/find" method="post" role="form">
        <h2 class="form-signin-heading">图书搜索</h2>
        <input type="text" class="form-control" name="bookName" placeholder="书名" required autofocus>
        <button class="btn btn-lg btn-primary btn-block" type="submit">搜索</button>
      </form>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>科学文库开通仪式通知</h2>
          <p>科学文库是中国科技出版传媒股份有限公司第一批数字出版建设的重点项目，是中国科技出版传媒股份有限公司建立的针对图书内容资源的第一个在线全文发布平台。2014年度，平台上可供订阅的电子书（出版日期在2013年之前的科学出版社图书）共计33974种，覆盖科学、技术、生命科学、人文社科、地球科学与环境等7个学科包... </p>
          <p><a class="btn btn-default" href="#" role="button">查看详情  &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>“JSTOR西文期刊全文回溯库”开通试用通知</h2>
          <p>JSTOR全名为Journal Storage，始于美仑基金会的数字典藏计划，是一个对过期期刊进行数字化的非营利性机构，于1995年8月成立。该机构有鉴于期刊订费高涨，及过期期刊对于图书馆所造成经费及存放空间等问题，有计划地建立核心学术性过期期刊的数字化存档，以节省空间，同时提供资料检索的功能，有效提高使用的便利性... </p>
          <p><a class="btn btn-default" href="#" role="button">查看详情  &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Wind资讯金融终端开通试用通知</h2>
          <p>Wind资讯金融终端占据了90%以上的金融高端人群，是金融研究和投资实战的必备工具。Wind资讯数据服务覆盖了买方和卖方金融机构，源源不断的为各类金融业务系统提供稳定可靠的数据内容。实证研究已成为当今高校科研的主流，因此，Wind资讯将业内最准确、最完整、最及时的数据开放给高校师生...</p>
          <p><a class="btn btn-default" href="#" role="button">查看详情  &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Company 2014</p>
      </footer>
    </div> <!-- /container -->

    <script src="/library/jscss/dist/js/bootstrap.min.js"></script>
    <script src="/library/jscss/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</body>
</html>