<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>voteprocess</title>
</head>
<body>
<%
String id=request.getParameter("id");
String num=request.getParameter("num");
Object voted=session.getAttribute("voted");
//判断上一次投票操作到现在的时间间隔是否大于10s
boolean isRigthTime=(System.currentTimeMillis()-session.getLastAccessedTime())/1000<10;
String msg=null;
if(voted!=null&&isRigthTime){
	%>
	<jsp:forward page="voteFailure.jsp"></jsp:forward>
	<%
}else{
	session.setAttribute("voted", "1");
	%>
	<jsp:forward page="doVoters?id=<%=id%>&num=<%=num%>"></jsp:forward>
	<%
}
%>
</body>
</html>