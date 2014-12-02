<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册答题</title>
<link rel="stylesheet" type="text/css" href="../docs.css">
</head>
<body>
	<form action="/question/test/checkAndGet"  class="form" method="post">
		<h1>请输入用户信息</h1>
		<div>真实姓名: <input class="input" type="text" name="username" required="required" pattern=".{2,4}" title="请输入正确姓名"/> </div>
		</br>
		<div>手机号码: <input class="input" type="text"name="phoneNumber" required="required" pattern="1\d{10}" title="请输入正确手机号"/> </div>
		</br>
		<div>工作单位: <input class="input" type="text"name="workSpace" /> <font color="red">*可选填</font></div>
		<p></p>
		<input class="button" type="submit" value="开始答题" />
	</form>
</body>

</html>