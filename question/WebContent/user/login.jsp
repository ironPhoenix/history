<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/question/test/checkAndGet" method="post">
		<div>用户名:<input type="text" name="username" required="required" pattern=".{2,4}" title="请输入正确姓名"/> </div>
		<p></p>
		<div>手机号:<input type="text"name="phoneNumber" required="required" pattern="1\d{10}" title="请输入正确的手机号码"/> </div>
		<p></p>
		<div>工作单位:<input type="text"name="workSpace" /> <font color="red">*可选填</font></div>
		<p></p>
		<input type="submit" value="开始答题" />
	</form>
</body>
</html>