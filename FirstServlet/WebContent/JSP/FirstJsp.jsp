<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FirstJsp</title>
</head>
<body>
	<!-- jsp申明 -->
	<%!int count = 0;
	String color[] = { "red", "green", "blue" };

	String getColor(int i) {
		return color[i];
	}%>
	<%=++count%><br>
	<%=getColor(1)%><br>
	<br>
	<table>
		<tr>
			<td>99乘法表</td>
		</tr>
		<%
			for (int i = 1; i <= 9; i++) {
		%>
		<tr>
			<%
				for (int j = 1; j <= i; j++) {
			%>
			<td><%=j%>*<%=i%>=<%=i * j%></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>