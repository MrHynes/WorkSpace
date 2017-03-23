<%@page import="java.util.Iterator"%>
<%@page import="com.dao.factory.DAOFactory"%>
<%@page import="com.dao.vo.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.org.apache.xpath.internal.compiler.Keywords"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>find</title>
</head>
<body>
	<%
		String key = request.getParameter("kw");
		if (key == null) {
			key = "";
		}
		List<Emp> all = DAOFactory.getIEmpDAOInstance().findAll(key);
		Iterator it = all.iterator();
	%>
	<center>
		<form action="find.jsp">
			请输入查询关键字：<input type="text" name="kw"> <input type="submit"
				value="查询">
		</form>
		<table border="1">
			<tr>
				<td>雇员编号</td>
				<td>雇员姓名</td>
				<td>雇员职位</td>
				<td>雇佣日期</td>
				<td>基本工资</td>
			</tr>
			<%
				while (it.hasNext()) {
					Emp emp = (Emp) it.next();
			%>
			<tr>
				<td><%=emp.getEmpno()%></td>
				<td><%=emp.getEmname()%></td>
				<td><%=emp.getJob()%></td>
				<td><%=emp.getHiredate()%></td>
				<td><%=emp.getSal()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>