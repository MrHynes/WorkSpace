<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP内置对象的使用</title>
</head>
<body>
	<%
		request.setAttribute("name", "zhangsan");
		session.setAttribute("name", "lishi");
		application.setAttribute("name", "wangwu");
		//请求转发
		request.getRequestDispatcher("requestPage.jsp").forward(request, response);
	%>
</body>
</html>