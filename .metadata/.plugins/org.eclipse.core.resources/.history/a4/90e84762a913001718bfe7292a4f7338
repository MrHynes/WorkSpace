<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	/*
	String onlineNum=(String)application.getAttribute("userNum");
	application.setAttribute("userNum", Integer.parseInt(onlineNum)-1+"");
	*/
	Set<String> onlineNum=(HashSet)application.getAttribute("onlineNum");
	String name = (String)session.getAttribute("users");
	//用户退出系统时，将该用户从application的onlineNum列表中删除。
	//但是还是会有bug，当用户直接关闭浏览器，集合中的依然会存在。
	onlineNum.remove(name);
	session.invalidate() ;
	response.sendRedirect("login.jsp");
%>
</body>
</html>