<%@ page language="java" import="com.ch05.Listener.User" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>对象绑定监听</title>
</head>
<body>
<%
User user=new User("张三");
session.setAttribute("user", user);
%>
<%=user.getData() %><br>
<%session.removeAttribute("user"); %>
<%=user.getData() %>
</body>
</html>