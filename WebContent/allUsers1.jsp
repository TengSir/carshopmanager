<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base  href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/CarShopManager/">
	<!-- 每个easyui界面都要用到的基础css和js库 -->
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body style="margin: 0px;padding: 5px;">
	<table class="easyui-datagrid"  style="width:100%;height:300px;margin: 5px;"
			data-options="singleSelect:true,collapsible:true,url:'admin/UserAction!listUserByPage.action?rows=5&page=2',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'userid',width:80,align:'left'">用户编号</th>
				<th data-options="field:'username',width:120,align:'left'">账户</th>
				<th data-options="field:'nickname',width:120,align:'left'">昵称</th>
				<th data-options="field:'sex',width:40,align:'left'">性别</th>
				<th data-options="field:'age',width:40,align:'left'">年龄</th>
				<th data-options="field:'job',width:60,align:'left'">职业</th>
				<th data-options="field:'image',width:100,align:'left'">头像</th>
			</tr>
		</thead>
	</table>

</body>
</html>