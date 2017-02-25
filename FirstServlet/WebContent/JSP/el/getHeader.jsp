<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL内置对象</title>
</head>
<body>
主机名：${header.host}<br>
用户浏览器信息：${header["User-Agent"]}<br>
浏览器可接受的MIME类型：${header.Accept}<br>
</body>
</html>