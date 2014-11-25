<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../admin/addb" method="post"
		enctype="multipart/form-data">
		<div>
			图书引索:<input type="text" name="indexNumber" required="required" />
		</div>
		<div>
			图书编号: <input type="text" name="bookId" required="required" />
		</div>
		<div>
			所在藏室: <input type="text" name="room" required="required" />
			<option value="一区301">一区301</option>
			<option value="一区508">一区508</option>
			<option value="二区307">二区307</option>
		</div>
		<div>
			<input type="submit" value="添加" />
		</div>
	</form>
</body>
</html>