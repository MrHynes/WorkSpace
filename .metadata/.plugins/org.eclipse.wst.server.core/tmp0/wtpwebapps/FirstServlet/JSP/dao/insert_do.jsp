<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.dao.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="com.dao.vo.Emp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>emp</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
%>
<body>

	<%
		Emp e = new Emp();
		e.setEmpno(Integer.parseInt(request.getParameter("empno")));
		e.setEmname(request.getParameter("emname"));
		e.setJob(request.getParameter("job"));
		e.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate")));
		e.setSal(Float.parseFloat(request.getParameter("sal")));
		if (DAOFactory.getIEmpDAOInstance().doCreate(e)) {
	%>
	<h2>雇员信息添加成功！</h2>
	<%
		} else {
	%>
	<h2>雇员信息添加失败</h2>
	<%
		}
	%>
</body>
</html>