<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP动作元素parma&forward</title>
</head>
<body>
<jsp:forward page="target.jsp?name=zhangsan&password=123456">
<jsp:param value="22" name="age"/>
<jsp:param value="178-0591-8389" name="telephone"/>
<jsp:param value="180-6576-3629" name="telephone"/>
</jsp:forward>
</body>
</html>