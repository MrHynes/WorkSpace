<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL访问作用域变量</title>
</head>
<body>
<!-- 使用EL表达式可以代替java代码 <%=request.getAttribute("attr1")%>-->
 ${attr1}  
 <%=request.getAttribute("attr1")%>
</body>
</html>