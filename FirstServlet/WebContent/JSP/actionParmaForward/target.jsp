<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP动作元素parma&forward</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String telephones[] = request.getParameterValues("telephone");
	%>
	用户名:<%=name%><br>
	密码:<%=password%><br>
	年龄:<%=age%><br>
	<%
		for (int i = 0; i < telephones.length; i++) {
	%>
	电话:<%=telephones[i]%><br>
	<%
		}
	%>
</body>
</html>