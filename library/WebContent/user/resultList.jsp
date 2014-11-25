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
	<c:forEach items="${bookKindList}" var="l">
		<tr>
			<td>${l.bookName}</td>
			<td>${l.author}</td>
			<td>${l.publishing}</td>
			<td>${l.publishTime}</td>
			<td><a href="../search/look?indexNumber=${l.indexNumber}">查看详情</a></td>
		</tr>
		<br />
	</c:forEach>
	<a href="../search/find?pageNumber=${currentPageNumber-1} ">上一页</a> 当前第
	${currentPageNumber} 页
	<a href="../search/find?pageNumber=${currentPageNumber+1} ">下一页</a> 共
	${maxPageNumber} 页
</body>
</html>