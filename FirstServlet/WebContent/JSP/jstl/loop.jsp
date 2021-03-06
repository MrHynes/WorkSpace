<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="com.ch09.JSTL.*,java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL循环标签</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>x的值</td>
			<td>varStatus.index</td>
			<td>varStatus.count</td>
			<td>varStatus.first</td>
			<td>varStatus.last</td>
		</tr>
		<c:forEach var="x" varStatus="status" begin="0" end="9" step="3">
			<tr>
				<td>${x}</td>
				<td>${status.index}</td>
				<td>${status.count }</td>
				<td>${status.first }</td>
				<td>${status.last}</td>
			</tr>
		</c:forEach>
	</table>

	<%
		List users = new ArrayList();
		for (int i = 0; i < 4; i++) {
			User user = new User();
			user.setName("user" + i);
			user.setPass("pass" + i);
			users.add(user);
		}
		session.setAttribute("users", users);
	%>
	<c:forEach items="${users}" var="user">
	用户名：${user.name}---密码:${user.pass}<br>
	</c:forEach>

	<c:set var="str" value="name=xxx;pass=jjj"></c:set>
	<c:forTokens items="${str}" delims=";" var="info">
		<c:forTokens items="${info}" delims="=" var="info2">
	  		${info2}<br>
		</c:forTokens>
	</c:forTokens>
	</bodhtml>