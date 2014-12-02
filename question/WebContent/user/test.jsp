<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../docs.css">
<title>试卷</title>
<script type="text/javascript">
var c=60
var t
function timedCount()
{
document.getElementById('txt').innerHTML=c
c=c-1
t=setTimeout("timedCount()",60000)
if (c<0)
  {
  document.getElementById('a').innerHTML="时间已耗尽，试题无效";
  }
if (c==10)
	{
		alert("答题时间还有10分钟");
	}
}
</script>
</head>
<body onload="timedCount()">
	<div class="require">
	<div style="color:red"><h2>现在开始你有1小时来完成 所有题目，超时提交无效。</h2></div>
	<div><h3>题型说明：试卷分为单选题、判断和多选题三种题型。共45题（满分100分），其中单项选择25题（50分）、判断10题（20分）、多项选择题10题（30分）</h3></div>
	<div class="center" id="a">剩余答题时间<font size="12px" Color="red" id="txt"></font>分钟</div>
	<form action="../test/result" method="post">
		<h3>单项选择题</h3>
		<c:forEach items="${listDan}" var="l" varStatus="status">
			<div> ${status.count} ${l.question}</div>
			<div><input type="radio" name="dan${status.index}" value="A" />A. ${l.a}</div>	
			<div><input type="radio" name="dan${status.index}" value="B" />B. ${l.b}</div>		
			<div><input type="radio" name="dan${status.index}" value="C" />C. ${l.c}</div>
			<c:if test="${l.d!=null}">
				<div><input type="radio" name="dan${status.index}" value="D" />D. ${l.d}</div>	
			</c:if>						
			<hr />
		</c:forEach>
		<h3>判断题</h3>
		<c:forEach items="${listPan}" var="l" varStatus="status">
			<div>${status.count} ${l.question}</div>
			<div><input type="radio" name="pan${status.index}" value="1" />对</div>	
			<div><input type="radio" name="pan${status.index}" value="0" />错</div>							
			<hr />
		</c:forEach>
		<h3>多项选择题</h3>
		<c:forEach items="${listDuo}" var="l" varStatus="status">
			<div>${status.count} ${l.question}</div>
			<div><input type="checkbox" name="duo${status.index}" value="A" />A. ${l.a}</div>
			<div><input type="checkbox" name="duo${status.index}" value="B" />B. ${l.b}</div>	
			<div><input type="checkbox" name="duo${status.index}" value="C" />C. ${l.c}</div>
			<div><input type="checkbox" name="duo${status.index}" value="D" />D. ${l.d}</div>						
			<hr />
		</c:forEach>
		<input type="submit" class="button" value="我要交卷" onclick="this.disabled=true;this.form.submit()" />
	</form>
	</div>
</body>
</html>