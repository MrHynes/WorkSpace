<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL表达式访问Map</title>
</head>
<body>
<table align="left" border="1">
	<tr>
		<th>地点</th>
		<th>号码</th>
	</tr>
	<tr>
		<td>家庭</td>
		<td>${phones.home}</td>
	</tr>
	<tr>
		<td>学校</td>
		<td>${phones.school}</td>
	</tr>
	<tr>
		<td>办公室</td>
		<td>${phones["office"]}</td>
	</tr>
</table>
</body>
</html>