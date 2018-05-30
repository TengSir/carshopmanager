<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<base  href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/CarShopManager/">
	<meta charset="UTF-8">
	<title>二手车商城后台管理系统</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
<canvas id="c" style="position: absolute;z-index: -100;margin: 0px;width: 98%"></canvas>
	<div style="width: 400px;margin: auto;margin-top: 100px;">
		<div class="easyui-panel" title="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二手车商城-后台管理系统-用户登陆"  region="center" style="width:400px;max-width:400px;padding:30px 60px;margin: auto">
	
		<form id="ff" method="post" action="admin/UserAction!login.action">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="username" style="width:100%" data-options="label:'账户:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" name="password"  style="width:100%" data-options="label:'密码:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="code"  maxlength="4" style="width:60%" data-options="label:'验证码:'">
				<img id="code" src="admin/CodeAction.action" style="width: 90px;height: 30px;position: relative;top: 11px;margin-left: 10px;" />
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">登陆</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清空</a>
		</div>
	</div>
	</div>
	<script>
		function alert1(title,message){
			$.messager.alert(title,message);
		}
		function errorMessage(title,message){
			$.messager.alert(title,message,'error');
		}
		function infoMessage(title,message){
			$.messager.alert(title,message,'info');
		}
		function questionMessage(title,message){
			$.messager.alert(title,message,'question');
		}
		function warningMessage(title,message){
			$.messager.alert(title,message,'warning');
		}
	</script>
	
	
	<script>
		function submitForm(){
			var  code=$("[name='code']").val();
			$.get("admin/CodeAction!checkCode.action?code="+code,function(data){
				if(data=='false')
				{
					$('#dlg').html("<span style='color:red;font-weight:bold'>验证码错误！</span>");
					errorMessage('温馨提示','验证码错误！');
					$('#dlg').dialog('open');
				}else
				{
					$('#ff').submit();
				}
			})
		}
		function clearForm(){
			$('#ff').form('clear');
		}
		$(document).ready(function(){
			$('#dlg').dialog('close');//网页一打开让提示框消失
			
			$("#code").click(function(){
				$(this).attr("src","admin/CodeAction.action?time="+new Date())
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
</body>
</html>