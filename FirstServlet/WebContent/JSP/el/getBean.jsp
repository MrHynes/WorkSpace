<%@ page language="java" import="com.ch06.JavaBean.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL访问JavaBean属性</title>
</head>
<body>
	ISBN:${book.isbn }<br> 
	书名:${book.name }<br>
	<br>
	<%
		Book book = (Book) request.getAttribute("book");
		if (book != null) {
	%>
	ISBN:<%=book.getIsbn()%><br> 书名:<%=book.getName()%><br>
	<%
		}
	%>
</body>
</html>