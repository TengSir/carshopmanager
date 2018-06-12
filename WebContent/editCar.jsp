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
	<link rel="stylesheet" type="text/css" href="css/uploadify.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery.uploadify.min.js"></script>
	
</head>
<body style="margin: 0px;padding: 0px;">
<div class="easyui-panel" style="width:100%;max-width:100%;margin: 0px;padding: 0px;">
		<form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
			<div class="easyui-accordion" style="width:100%;height:300px;margin: 0px;padding: 0px;">
				<div title="基本信息" data-options="iconCls:'icon-large-smartart'" style="overflow:auto;padding: 5px;">
					<table></table>
					品牌:<input class="easyui-textbox" name="name" data-options="required:true" style="width: 120px;height: 20px;">
					系列:<input class="easyui-textbox" name="name" data-options="required:true" style="width: 120px;height: 20px;"><br/>
					排量:<input class="easyui-textbox" name="name" data-options="required:true" style="width: 120px;height: 20px;">
					售价:<input class="easyui-textbox" name="name" data-options="required:true" style="width: 120px;height: 20px;"><br/>
					公里:<input class="easyui-textbox" name="name" data-options="required:true" style="width: 120px;height: 20px;">
					类型:<input class="easyui-textbox" name="name" data-options="required:true" style="width: 120px;height: 20px;"><br/>
					变速箱:<input class="easyui-textbox" name="name" data-options="required:true" style="width: 120px;height: 20px;"><br/>
					第几手:<input class="easyui-textbox" name="name" data-options="required:true" style="width: 120px;height: 20px;"><br/>
					燃料类型:<input class="easyui-textbox" name="name" data-options="required:true" style="width: 120px;height: 20px;">
				</div>
				<div title="车辆图片" data-options="iconCls:'icon-large-picture'" style="overflow: hidden;">
<!-- 					<img src="images/temp/1.jpg" style="width: 100%;height: 100%"/> -->
					<img  id="imgPrew"  style="width: 100px;height: 80px;border:1px solid red"/>
					<input type="file" name="image" id="image" />
				</div>
				<div title="车辆视频" data-options="iconCls:'icon-large-clipart'" style="overflow: hidden;">
					<video src="videos/1.mp4"  style="width: 100%;height:100%" controls="controls" preload="auto"></video>
				</div>
				<div title="车辆介绍" data-options="iconCls:'icon-large-shapes'" style="overflow: hidden;padding: 5px;">
					<input class="easyui-textbox" labelPosition="top" multiline="true"  style="width:100%;height:100%;margin: 5px;">
				</div>
			</div>
		</form>
		<div style="text-align:center;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:60px">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:60px">清空</a>
		</div>
	</div>
	<script>
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
		
		
		$(document).ready(function(){
			 $('#image').uploadify({
				 	'auto'    :  true,
				 	'fileObjName':'image',
				 	'buttonText' : '选中图片',
			        'swf'      : 'uploadify.swf',
			        'uploader' : 'admin/CarAction!updateCar.action',
			        'onUploadSuccess' : function(file, data, response) {
			        	$("#imgPrew").attr("src",data);
			            //alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
			        }
			        // Put your options here
			    });
		})
	</script>



</body>
</html>