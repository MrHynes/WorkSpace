<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL表达式访问数组元素的值</title>
</head>
<body>
<table align="center" border="3" bordercolor="red">
	<tr>
		<th>ISBN</th>
		<th>书名</th>
	</tr>
	<tr>
		<td>${books[0].isbn}</td>
		<td>${books[0].name}</td>
	</tr>
	<tr>
		<td>${books[1].isbn}</td>
		<td>${books[1].name}</td>
	</tr>
	<tr>
		<td>${books[2].isbn}</td>
		<td>${books[2].name}</td>
	</tr>
	<tr>
		<td>${books[3].isbn}</td>
		<td>${books[3].name}</td>
	</tr>
</table>
</body>
</html>