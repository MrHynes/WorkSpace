<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>emp</title>
</head>
<body>
	<form action="insert_do.jsp">
		雇员编号：<input type="text" name="empno"><br> 
		雇员姓名：<input type="text" name="emname"><br> 
		雇员职位：<input type="text" name="job"><br> 
		雇佣日期：<input type="text" name="hiredate"><br>
		基本工资：<input type="text" name="sal"><br> 
		<input type="submit" value="提交"> 
		<input type="reset" value="重置">
	</form>
</body>
</html>