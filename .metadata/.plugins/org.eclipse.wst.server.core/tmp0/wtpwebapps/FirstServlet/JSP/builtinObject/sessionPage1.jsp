<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP内置对象</title>
</head>
<body>
request中的name:<%=request.getAttribute("name") %><br>
session中的name:<%=session.getAttribute("name") %><br>
application中的name:<%=application.getAttribute("name") %><br>
</body>
</html>