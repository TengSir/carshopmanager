<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<base  href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/CarShopManager/">
	<meta charset="UTF-8">
	<title>二手车商城后台管理系统-首页</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/canvas.js"></script>
</head>
<body>
<canvas id="c" style="position: absolute;z-index: -100;margin: 0px;width: 98%"></canvas>
	<div class="easyui-layout" style="width:100%;height:650px;">
		<div data-options="region:'north'" style="height:80px;padding-left: 20px;">
			<p>
			<span style="font-weight:bold; font-size: 30px;font-family:'宋体';margin-right: 50px;text-shadow: -1px -1px 10px orange;">二手车商城后台管理系统</span>
			<img src="${sessionScope.user.image}" style="width: 20px;height: 20px;border:1px solid gray;border-radius: 10px;position: relative;top: 5px;margin-right: 10px;"/>欢迎您：${sessionScope.user.nickname}！<a href="admin/UserAction!logoff.action">安全退出</a>
			</p>
		</div>
		<div data-options="region:'south',split:true" style="height:50px;padding-top: 5px;padding-left: 20px;">
			<a href="http://localhost:8080/CarShop">系统说明</a>
			<a href="http://localhost:8080/CarShop">员工守则</a>
			<a href="http://localhost:8080/CarShop">公司信息</a>
			<a href="http://localhost:8080/CarShop">前台网站</a>
		</div>
		<div data-options="region:'east',split:true" title="公告" style="width:150px;"></div>
		<div data-options="region:'west',split:true" title="菜单栏" style="width:200px;">
		<ul class="easyui-tree" id="menutree">
			<li>
				<span>所有功能</span>
				<ul>
					<li data-options="state:'closed'">
						<span>用户管理</span>
						<ul>
							<li>
								<span>所有用户</span>
							</li>
							<li>
								<span>添加用户</span>
							</li>
							<li>
								<span>删除用户</span>
							</li>
							<li>
								<span>修改用户</span>
							</li>
						</ul>
					</li>
					<li  data-options="state:'closed'">
						<span>商品管理</span>
						<ul>
							<li>所有商品</li>
							<li>添加商品</li>
							<li>修改商品</li>
							<li>删除商品</li>
						</ul>
					</li>
					<li  data-options="state:'closed'">
						<span>订单管理</span>
						<ul>
							<li>异常订单</li>
							<li>所有订单</li>
							<li>处理订单</li>
							<li>搜索订单</li>
						</ul>
					</li>
					<li  data-options="state:'closed'">
						<span>个人中心</span>
						<ul>
							<li>修改密码</li>
							<li>修改资料</li>
							<li>修改头像</li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
		
		
		</div>
		<div data-options="region:'center',iconCls:' ui-icon-comment'">
			<div id="main" class="easyui-tabs" style="width:100%;height:100%">
				<div title="销售统计" style="padding:10px"  data-options="iconCls:'icon-large-chart'" >
					<div id="chartContainer" style="height: 100%; width: 100%;"></div>
				</div>
				<div title="我的消息" style="padding:10px"  data-options="iconCls:'icon-large-smartart',closable:true" >
					<table class="easyui-datagrid"
						data-options="border:false,singleSelect:true,fit:true,fitColumns:true">
						<thead>
							<tr>
								<th data-options="field:'itemid'" width="80">Item ID</th>
								<th data-options="field:'productid'" width="100">Product ID</th>
								<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
								<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
								<th data-options="field:'attr1'" width="150">Attribute</th>
								<th data-options="field:'status',align:'center'" width="60">Status</th>
							</tr>
						</thead>
					</table>
				</div>
				<div title="系统通知" data-options="iconCls:'icon-help',closable:true" style="padding:10px">
					<ul class="easyui-datalist" title="公司消息" lines="true" style="width:100%;height:100%">
						<li value="AL">Alabama</li>
						<li value="AK">Alaska</li>
						<li value="AZ">Arizona</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#menutree').tree({
				onClick: function(node){
					if(node.text=='所有用户'){
						addPanel(node.text);
					}
				}
			});
		})
	</script>
	<script type="text/javascript">
		var index = 2;
		function addPanel(t){
			index++;
// 			$('#main').tabs('add',{
// 				title: t,
// 				content: "<table class=‘easyui-datagrid‘ title=‘Basic DataGrid‘ style=‘width:100%;height:100%’data-options=singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'><thead><tr><th data-options=‘field:'itemid',width:80‘>Item ID</th><th data-options=‘field:'productid',width:100‘>Product</th><th data-options=‘field:'listprice',width:80,align:'right'‘>List Price</th><th data-options=‘field:'unitcost',width:80,align:'right'‘>Unit Cost</th><th data-options=‘field:'attr1',width:250‘>Attribute</th><th data-options=‘field:'status',width:60,align:'center'‘>Status</th></tr></thead></table>",
// 				closable: true
// 			});
			
			if ($('#main').tabs('exists', t)){
				$('#main').tabs('select', t);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="allUsers.jsp" style="width:100%;height:100%;"></iframe>';
				$('#main').tabs('add',{
					title:t,
					content:content,
					closable:true
				});
			}
		}
		function removePanel(){
			var tab = $('#main').tabs('getSelected');
			if (tab){
				var index = $('#main').tabs('getTabIndex', tab);
				$('#main').tabs('close', index);
			}
		}
	</script>
	
	
<script type="text/javascript">
		(function($){
			function getParentMenu(rootMenu, menu){
				return findParent(rootMenu);

				function findParent(pmenu){
					var p = undefined;
					$(pmenu).find('.menu-item').each(function(){
						if (!p && this.submenu){
							if ($(this.submenu)[0] == $(menu)[0]){
								p = pmenu;
							} else {
								p = findParent(this.submenu);
							}
						}
					});
					return p;
				}
			}
			function getParentItem(pmenu, menu){
				var item = undefined;
				$(pmenu).find('.menu-item').each(function(){
					if ($(this.submenu)[0] == $(menu)[0]){
						item = $(this);
						return false;
					}
				});
				return item;
			}

			$.extend($.fn.menu.methods, {
				enableNav: function(jq, rootMenu){
					var firstItemSelector = '.menu-item:not(.menu-item-disabled):first';
					var lastItemSelector = '.menu-item:not(.menu-item-disabled):last';
					return jq.each(function(){
						var menu = $(this);
						rootMenu = $(rootMenu).length ? $(rootMenu) : menu;
						menu.attr('tabindex','0').css('outline','none').unbind('.menunav').bind('keydown.menunav', function(e){
							var item = $(this).find('.menu-active');
							switch(e.keyCode){
								case 13:  // enter
									item.trigger('click');
									break;
								case 27:  // esc
									rootMenu.find('.menu-active').trigger('mouseleave');
									break;
								case 38:  // up
									var prev = item.length ? item.prevAll(firstItemSelector) : menu.find(lastItemSelector);
									prev.trigger('mouseenter');
									return false;
								case 40:  // down
									var next = item.length ? item.nextAll(firstItemSelector) : menu.find(firstItemSelector);
									next.trigger('mouseenter');
									return false;
								case 37:  // left
									var pmenu = getParentMenu(rootMenu, menu);
									if (pmenu){
										item.trigger('mouseleave');
										var pitem = getParentItem(pmenu, menu);
										if (pitem){
											pitem.trigger('mouseenter');
										}
										pmenu.focus();
									}
									return false;
								case 39:  // right
									if (item.length && item[0].submenu){
										$(item[0].submenu).menu('enableNav', rootMenu).find(firstItemSelector).trigger('mouseenter');
										$(item[0].submenu).focus();
									}
									return false;
							}
						});
					});
				}
			});
		})(jQuery);

		$(function(){
			$('#mm-nav').menu().menu('enableNav');
			$(document).keydown(function(e){
				if (e.altKey && e.keyCode == 87){
					$('#mm-nav').focus();
				}
			})
		})
	</script>
	<script>
			window.onload=function  () {
			  var canvas=document.getElementById("c");
			  //让画布的宽度为浏览器可视区域的宽度  注意不能使用canvas.style.width
			  canvas.width=document.documentElement.clientWidth;
			  canvas.height=document.documentElement.clientHeight;
			  //设置画布背景颜色
			  canvas.style.background="#FFFFFF";
			  var cobj=canvas.getContext("2d");
			  
			  //星星的数组
			  var startArr=[];
			  //用随机数生成星星的颗数
			  var starNums=100+Math.random()*20;
			  for(var i=0;i<starNums;i++)
			  {
			  	//x,y,radius1,radius2,num,drawType,color
			  	
			  	
			  	 var starObj={radius1:20+10*Math.random(),radius2:8+7*Math.random(),x:30+(canvas.width-60)*Math.random(),y:30+(canvas.height-60)*Math.random(),num:4+Math.ceil(4*Math.random()),color:"rgb("+parseInt(Math.random()*255)+","+parseInt(Math.random()*255)+","+parseInt(Math.random()*255)+")",angle:360*Math.random(),changeAgele:-5+10*Math.random()}
			  	 
			  	 startArr.push(starObj);
			  }
			  
			  
			  setInterval(function(){
			  	 cobj.clearRect(0,0,canvas.width,canvas.height);
			  	 for(var i=0;i<startArr.length;i++)
			  	 {
			  	 	startArr[i].angle+=startArr[i].changeAgele;
			  	 	cobj.save();
			  	 	cobj.beginPath();
			  	 	
			  	 	cobj.translate(startArr[i].x,startArr[i].y);
					cobj.rotate(startArr[i].angle*Math.PI/180);
					cobj.scale(Math.sin(startArr[i].angle*Math.PI/180),Math.sin(startArr[i].angle*Math.PI/180));
					cobj.globalAlpha=Math.abs(Math.sin(startArr[i].angle*Math.PI/180));
			  	 	//绘制多边形
			  	 	drawStar(0,0,startArr[i].radius1,startArr[i].radius2,startArr[i].num,"fill",startArr[i].color)
			  	 	cobj.restore();
			  	 }
			  },60);
			  
			  
			  
			  //绘制多边形
				function drawStar(x,y,radius1,radius2,num,drawType,color)
				{
					var angle=360/(num*2);
					var arr=[];
					for(var i=0;i<num*2;i++)
					{
						var starObj={};
						if(i%2==0)
						{
							starObj.x=x+radius1*Math.cos(i*angle*Math.PI/180);
							starObj.y=y+radius1*Math.sin(i*angle*Math.PI/180);
						}
						else
						{
							starObj.x=x+radius2*Math.cos(i*angle*Math.PI/180);
							starObj.y=y+radius2*Math.sin(i*angle*Math.PI/180);
						}
						
						arr.push(starObj);
					}
					
					cobj.beginPath();
					cobj.fillStyle=color;
					cobj.fillStyle=color;
					cobj.moveTo(arr[0].x,arr[0].y);
					for(var i=1;i<arr.length;i++)
					{
						cobj.lineTo(arr[i].x,arr[i].y);
					}
					cobj.closePath();
					if(drawType=="fill")
					{
						cobj.fill();
					}
					else
					{
						cobj.stroke();
					}
				}
			  
			}
		</script>
		
		<!-- 生成图表的js -->
		<script>
window.onload = function () {

var options = {
	title: {
		text: "商品销售统计图"
	},
	subtitles: [{
		text: "As of November, 2017"
	}],
	animationEnabled: true,
	data: [{
		type: "pie",
		startAngle: 40,
		toolTipContent: "<b>{label}</b>: {y}%",
		showInLegend: "true",
		legendText: "{label}",
		indexLabelFontSize: 16,
		indexLabel: "{label} - {y}%",
		dataPoints: [
			{ y: 48.36, label: "Windows 7" },
			{ y: 26.85, label: "Windows 10" },
			{ y: 1.49, label: "Windows 8" },
			{ y: 6.98, label: "Windows XP" },
			{ y: 6.53, label: "Windows 8.1" },
			{ y: 2.45, label: "Linux" },
			{ y: 3.32, label: "Mac OS X 10.12" },
			{ y: 4.03, label: "Others" }
		]
	}]
};
$("#chartContainer").CanvasJSChart(options);

}
</script>

</body>
</html>