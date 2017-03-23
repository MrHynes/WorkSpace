<%@ page language="java" import="com.ch07.MVC.User" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录成功</title>
</head>
<body>
用户：<%=((User)session.getAttribute("user")).getUserName()%>
您好！欢迎您使用xx系统！
</body>
</html>