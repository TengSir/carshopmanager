<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xxx管理后台系统</title>
<base  href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/CarShopManager/">
	<!-- 每个easyui界面都要用到的基础css和js库 -->
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>

<div class="easyui-layout" style="width:100%;height:700px;">
		<div data-options="region:'north'" style="height:100px">
				<h1>XX后台管理系统</h1>
		</div>
		<div data-options="region:'south',split:true" style="height:50px;">
		<a href="#">前台网站</a>
		</div>
		<div data-options="region:'west',split:true" title="系统菜单" style="width:200px;">
			<ul class="easyui-tree"  id="sysmenu">
				<li>
					<span>所有功能</span>
					<ul>
						<li>
							<span>用户管理</span>
							<ul>
								<li>
									<span>用户添加</span>
								</li>
								<li>
									<span>所有用户</span>
								</li>
								<li>
									<span>搜索用户</span>
								</li>
							</ul>
						</li>
						<li data-options="state:'closed'">
							<span>Program Files</span>
							<ul>
								<li>Intel</li>
								<li>Java</li>
								<li>Microsoft Office</li>
								<li>Games</li>
							</ul>
						</li>
						<li>index.html</li>
						<li>about.html</li>
						<li>welcome.html</li>
					</ul>
				</li>
			</ul>
				
		
		
		</div>
		<div data-options="region:'center',iconCls:'icon-ok'">
				<div id="tt" class="easyui-tabs" data-options="tools:'#tab-tools'" style="width:100%;height:100%">
						<div title="系统消息" style="padding:10px">
							<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
							<ul>
								<li>easyui is a collection of user-interface plugin based on jQuery.</li>
								<li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
								<li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
								<li>complete framework for HTML5 web page.</li>
								<li>easyui save your time and scales while developing your products.</li>
								<li>easyui is very easy but powerful.</li>
							</ul>
						</div>
										
				</div>
		</div>
	</div>
<script type="text/javascript">

//用easyui的事件注入方法来对菜单上所有操作菜单添加功能

$('#sysmenu').tree({
	onClick: function(node){
		if(node.text=='所有用户')
		{
			addPanel(node.text,'allUsers1.jsp');
		}else if(node.text='用户添加'){
			addPanel(node.text);
		}
		//alert(node.text);  // alert node text property when clicked
	}
});
</script>


<!-- 这里是动态管理选项卡的js函数 -->

<script type="text/javascript">
		var index = 1;
		function addPanel(title,url){
			index++;
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
			
		}
		function removePanel(){
			var tab = $('#tt').tabs('getSelected');
			if (tab){
				var index = $('#tt').tabs('getTabIndex', tab);
				$('#tt').tabs('close', index);
			}
		}
	</script>


</body>
</html>