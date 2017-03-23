<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>与作用范围相关的内置对象</title>
</head>
<body>
<!-- JSP内置对象设置属性的值 -->
<%
pageContext.setAttribute("bookname","《JavaWeb技术》");
request.setAttribute("bookname","《Head First Java》");
session.setAttribute("bookname", "《操作系统》");
application.setAttribute("bookname", "《数据结构》");
%>
获取page属性范围的值:${pageScope.bookname}<br>
获取request属性范围的值：${requestScope.bookname}<br>
获取session属性范围的值：${sessionScope.bookname}<br>
获取application属性范围的值：${applicationScope.bookname}<br>
获取未指定属性范围的值：${bookname}<br>
</body>
</html>