<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="itemsList.action">查询商品信息1(Controller:ItemController1)</a><br>
<a href="itemsList2.action">查询商品信息2(Controller:ItemController2)</a><br>
<a href="queryItems.action">查询商品信息(注解方式)(Controller:ItemController3)</a>


<h3>springmvc3.xml</h3>
<a href="students/getstu.action">1./students/getstu.action</a><br>
<a href="students/getstu2/cheng.action">2./students/getstu2/cheng.action</a><br>
<a href="students/getstu3.action?name=cheng">3./students/getstu3.action?name=cheng</a><br>
4.
<form action="students/getstu3.action">
	<input type="text" name="name">
	<input type="submit" value="提交">
</form>
</body>
</html>