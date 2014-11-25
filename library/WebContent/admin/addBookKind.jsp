<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加书种类</title>
</head>
<body>
	<form action="../admin/addbk" method="post" enctype="multipart/form-data">
		<div>引索号:<input type="text" name="indexNumber" /> </div>
		<div>书名:   <input type="text" name="bookName" /> </div>
		<div>作者:   <input type="text" name="author" /> </div>
		<div>出版社:     <input type="text" name="publishing" /> </div>
		<div>出版时间:<input type="month" name="publishTime" /> </div>
		<div>书籍照片: <input type="file" name="bookPicture" required="required" /></div>
		<div><input type="submit" value="添加"  /></div>
	</form>
</body>
</html>