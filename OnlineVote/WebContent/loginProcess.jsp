<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogingProcess</title>
</head>
<body>
	<%
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if ("123456".equals(password)) {
			request.getRequestDispatcher("query").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>