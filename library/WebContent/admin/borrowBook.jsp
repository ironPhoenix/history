<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>读者借书</h4>
	<form action="../admin/borroweb" method="post">
		读者号:<input type="text" name="studentId" /> 
		图书号：<input type="text"name="bookId" /> 
		<input type="submit" value="借阅" />
	</form>
</body>
</html>