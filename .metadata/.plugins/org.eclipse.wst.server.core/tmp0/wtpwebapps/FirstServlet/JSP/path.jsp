<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Web 路径</title>
</head>
<body>
Web应用的相对路径：<%=request.getContextPath() %><br>
request请求相对于Web应用的相对路径:<%=request.getServletPath() %><br>
request请求相对于服务器的相对路径:<%=request.getRequestURI() %><br>
request请求的绝对路径:<%=request.getRequestURL() %><br>
当前应用的物理地址:<%=application.getRealPath("/")%><br>
</body>
</html>