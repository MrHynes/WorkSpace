<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL表达式访问List元素</title>
</head>
<body>
<table align="left" border="1">
	<tr>
		<th>系别</th>
	</tr>
	<tr>
		<td>${departments["0"]}</td>
	</tr>
	<tr>
		<td>${departments["1"]}</td>
	</tr>
	<tr>
		<td>${departments["2"]}</td>
	</tr>
	<tr>
		<td>${departments["3"]}</td>
	</tr>

</table>

</body>
</html>