<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page作用范围</title>
</head>
<body>
<jsp:useBean id="counter" class="com.ch06.JavaBean.CountBean" scope="page"></jsp:useBean>
计数器的值:<jsp:getProperty property="count" name="counter"/>
</body>
</html>