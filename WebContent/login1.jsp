<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>

	<div  style="width: 440px;margin: auto;margin-top: 150px;">
		<div class="easyui-panel" title="用户登陆" style="width:100%;max-width:400px;padding:30px 60px;">
			<form id="ff" method="post" action="admin/UserAction!processLogin.action">
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="u.username" style="width:100%" data-options="label:'用户名:',required:true,buttonText:'检测'">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-passwordbox" name="u.password" style="width:100%" data-options="label:'密码:',required:true">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="code" style="width:100%" data-options="label:'验证码:'">
				</div>
			</form>
			<div style="text-align:center;padding:5px 0">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">登陆</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清空</a>
			</div>
		</div>
	
	</div>
	<script>

		alert2();
		function submitForm(){
			
			$("#ff").submit();//jquery  对表单提交的函数
			//$('#ff').form('submit');
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
	<c:if test="${requestScope.message eq 'loginFail' }">
		<script type="text/javascript">
		$.messager.alert('温馨提示','用户名和密码错误，登陆失败!','error');
		</script>
	</c:if>

</body>
</html>