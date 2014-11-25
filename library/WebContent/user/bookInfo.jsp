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
	<div>书名 :${bookKind.bookName }</div>
	<div>作者:${bookKind.author }</div>
	<div>出版社:${bookKind.publishing }</div>
	<div>出版时间:${bookKind.publishTime }</div>
	<div>引索号:${bookKind.indexNumber }</div>
	<div>
		封面:<img src="/tmp/${bookKind.indexNumber }" width="128" height="128" />
	</div>

	<c:forEach items="${bookKind.books}" var="l">
		<tr>
			<td>${l.room}</td>
			<c:if test="${l.borrower==null}">
				<td>在管</td>
			</c:if>
			<c:if test="${l.borrower!=null}">
				<td>借出</td>
			</c:if>
		</tr>
		<br />
	</c:forEach>
</body>
</html>