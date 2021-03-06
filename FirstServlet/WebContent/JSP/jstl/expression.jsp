<%@page import="com.ch09.JSTL.SimpleBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>表达式标签c:out</title>
</head>
<body>
<%
pageContext.setAttribute("school","福建师范大学");
%>

<h3>c:out标签</h3>
<c:out value="school"></c:out><br>
<c:out value="${school}"></c:out><br>
<c:out value="${name}" default="数学与计算机科学学院"></c:out><br>
<c:out value="${major}">计算机科学与技术</c:out><br>

<h3>c:set标签 </h3>
<c:set var="username" value="chengqi" scope="page"></c:set>
输出变量值：${pageScope.username}<br>
<%
SimpleBean bean=new SimpleBean();
request.setAttribute("simple", bean);
%>
<c:set target="${simple }" property="info" value="福建师范大学"></c:set>
输出SimpleBean对象info的值：${requestScope.simple.info}<br>

<h3>c:remove标签</h3>
<c:remove var="simple"/>
输出SimpleBean对象info的值：${requestScope.simple.info}<br>

<h3>c:catch标签</h3>
<c:catch var="error">
	<%int i=5/0; %>
</c:catch>
异常信息是：${error}<br>
</body>
</html>