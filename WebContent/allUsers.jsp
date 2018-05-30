<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body style="margin: 0px;padding: 5px;">
	<table id="dg" title="用户列表" style="width:100%;height:400px;margin: 0px;"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'admin/UserAction!listUserByPage.action',method:'get'">
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
	<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});			
		})
	</script>


</body>
</html>