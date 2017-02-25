<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL内置对象</title>
</head>
<body>
用户名：${param.name}<br>
密码：${param.password}<br>
兴趣：${paramValues.ins[0]}
${paramValues.ins[1]}
${paramValues.ins[2]}
${paramValues.ins[3]}
</body>
</html>