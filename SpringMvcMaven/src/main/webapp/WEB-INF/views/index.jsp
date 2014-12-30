<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<title>基于SpringMvc实现Restful架构风格</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="SpringMvc,Restful,Maven">
	<meta http-equiv="description" content="基于SpringMvc实现Restful架构风格">
	
	<link rel="stylesheet" type="text/css" href="uikit-2.11.0/css/uikit.gradient.min.css">
	<link rel="stylesheet" type="text/css" href="uikit-2.11.0/css/components/notify.gradient.min.css">

</head>
<body>
	
	<div style="width:1024px;margin-top:50px;margin-left: auto;margin-right: auto;text-align: center;">
		<h1>基于SpringMvc实现Restful架构风格（Maven构建）</h1>
	</div>
	
	<div style="width:800px;margin-left: auto;margin-right: auto;">
		<fieldset class="uk-form">
			<legend>资源请求测试</legend>
			<button class="uk-button uk-button-primary uk-button-large" id="btnGet">获取人员GET</button>
			<button class="uk-button uk-button-primary uk-button-large" id="btnAdd">添加人员POST</button>
			<button class="uk-button uk-button-primary uk-button-large" id="btnUpdate">更新人员PUT</button>
			<button class="uk-button uk-button-danger uk-button-large" id="btnDel">删除人员DELETE</button>
			<button class="uk-button uk-button-primary uk-button-large" id="btnList">查询列表PATCH</button>
		</fieldset>
	</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="uikit-2.11.0/js/uikit.min.js"></script>
<script type="text/javascript" src="uikit-2.11.0/js/components/notify.min.js"></script>

<script type="text/javascript">

$(function(){
	roy.init();
});

(function(window,$){

	var roy={
		
		url:'',

		init:function(){
			roy.url='<%=basePath%>';
			$.UIkit.notify("页面初始化完成", {status:'info',timeout:500});
			$("#btnGet").click(roy.getPerson);
			$("#btnAdd").click(roy.addPerson);
			$("#btnDel").click(roy.delPerson);
			$("#btnUpdate").click(roy.updatePerson);
			$("#btnList").click(roy.listPerson);
		},
		getPerson:function(){
			$.ajax({
				url: roy.url + 'person/101/',
				type: 'GET',
				dataType: 'json'
			}).done(function(data, status, xhr) {
				$.UIkit.notify("获取人员信息成功", {status:'success',timeout:1000});
			}).fail(function(xhr, status, error) {
				$.UIkit.notify("请求失败！", {status:'danger',timeout:2000});
			});
		},
		addPerson:function(){
			$.ajax({
				url: roy.url + 'person',
				type: 'POST',
				dataType: 'json',
				data: {id: 1,name:'张三',sex:'男',age:23}
			}).done(function(data, status, xhr) {
				$.UIkit.notify(data.msg, {status:'success',timeout:1000});
			}).fail(function(xhr, status, error) {
				$.UIkit.notify("请求失败！", {status:'danger',timeout:2000});
			});
		},
		delPerson:function(){
			$.ajax({
				url: roy.url + 'person/109',
				type: 'DELETE',
				dataType: 'json'
			}).done(function(data, status, xhr) {
				$.UIkit.notify(data.msg, {status:'success',timeout:1000});
			}).fail(function(xhr, status, error) {
				$.UIkit.notify("请求失败！", {status:'danger',timeout:2000});
			});
		},
		updatePerson:function(){
			$.ajax({
				url: roy.url + 'person',
				type: 'POST',//注意在传参数时，加：_method:'PUT'　将对应后台的PUT请求方法
				dataType: 'json',
				data: {_method:'PUT',id: 221,name:'王五',sex:'男',age:23}
			}).done(function(data, status, xhr) {
				$.UIkit.notify(data.msg, {status:'success',timeout:1000});
			}).fail(function(xhr, status, error) {
				$.UIkit.notify("请求失败！", {status:'danger',timeout:2000});
			});
		},
		listPerson:function(){
			$.ajax({
				url: roy.url + 'person',
				type: 'POST',//注意在传参数时，加：_method:'PATCH'　将对应后台的PATCH请求方法
				dataType: 'json',
				data: {_method:'PATCH',name: '张三'}
			}).done(function(data, status, xhr) {
 				$.UIkit.notify(data[0].sex, {status:'success',timeout:1000});
			}).fail(function(xhr, status, error) {
				$.UIkit.notify("请求失败！", {status:'danger',timeout:2000});
			});
		}
	};
	window.roy=(window.roy)?window.roy:roy;
	
})(window,jQuery);

</script>
</body>
</html>
