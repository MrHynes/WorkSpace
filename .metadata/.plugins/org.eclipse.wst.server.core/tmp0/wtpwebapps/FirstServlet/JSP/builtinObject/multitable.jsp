<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>99乘法表</title>
</head>
<body>
 <%
 out.println("<table border=\"1\">");
 for(int i=1;i<=9;i++){
	 out.println("<tr>");
	 for(int j=1;j<=i;j++){
		 out.println("<td>"+j+"*"+i+"="+i*j+"</td>");
	 }
	 out.println("</tr>");
 }
 out.println("</table>");
 %>
</body>
</html>