<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录页面</title>
</head>
<body>
	<%
		String message = (String) session.getAttribute("message");
		if (message != null) {
			out.println(message);
			session.removeAttribute("message");
		}
	%>
	<form action="/FirstServlet/filter" method="post"><!-- / 代表web服务器的根目录即：http://localhost:8080/ -->
		用户名:<input type="text" name="name" /><br> 
		密码：<input type="password" name="password" /><br> 
		<input type="submit" value="登录" /> 
		<input type="reset" value="取消" />
	</form>
</body>
</html>