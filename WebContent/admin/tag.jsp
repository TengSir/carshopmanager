<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<s:set name="sex" value="male"></s:set>
	<s:if test="#sex==male">
男性

</s:if>
	<s:else>
女性
</s:else>

	<br />

<table>
	<tr>
	<td>品牌名</td>
	<td>系列名</td>
	<td>排量</td>
	<td>售价</td>
	</tr>
	<s:iterator value="cars"  >
		<tr>
		<td><s:property value="pinpaiming"/>  </td>
		<td><s:property value="xilie"/>  </td>
		<td><s:property value="pailiang"/>  </td>
		<td><s:property value="shoujia"/>  </td>
		</tr>
	</s:iterator>
</table>

	
</body>
</html>