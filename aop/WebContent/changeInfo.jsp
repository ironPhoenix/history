<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="InfoAction" method="post">
		<input type="hidden" name="type" value="saveById" > 
		<input type="hidden" name="id" value=${info.id} > 
		留言人：<input type="text" name="name" value=${info.name} > 
		留言板：<input type="text" name="message" value=${info.message} >
		<input type="submit" />
	</form>
</body>
</html>