<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="input" action="../test/a" method="post">
I have a bike:
<input type="checkbox" name="vehicle" value="A" checked="checked" />
<br />
I have a car: 
<input type="checkbox" name="vehicle" value="B" />
<br />
I have an airplane: 
<input type="checkbox" name="vehicle" value="C" />
<br /><br />
<input type="submit" value="Submit" />
</form> 

<p>如果您点击 "Submit" 按钮，您将把输入传送到名为 html_form_action.asp 的新页面。</p>
</body>
</html>