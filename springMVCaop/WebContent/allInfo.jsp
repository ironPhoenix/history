<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${infoList}" var="l">
		<tr>
			<td>${l.name}</td>
			<td>${l.message}</td>
			<td><a href="InfoAction?type=change&id=${l.id}">修改</a></td>
			<td><a href="InfoAction?type=delete&id=${l.id}">删除</a></td>
		</tr>
		<br />
	</c:forEach>
	<a href="InfoAction?type=show&pageNumber=${pageNumberInfoList-1} " >上一页</a>
	<a href="InfoAction?type=show&pageNumber=${pageNumberInfoList+1} " >下一页</a>
</body>
</html>