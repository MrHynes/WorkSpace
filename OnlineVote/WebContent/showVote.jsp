<%@page import="com.j2ee.vo.Info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>showVote</title>
</head>
<body>
<center>
<%
	List<Info> list=(List)request.getAttribute("list");
	if(list!=null){
		%>
		<table border="1">
		<caption>在线投票</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>票数</th>
				<th>操作</th>
			</tr>
			<%
			for(int i=0;i<list.size();i++){
				Info info=list.get(i);
				%>
					<tr>
						<td width="100px"><%=info.getId()%></td>
						<td width="100px"><%=info.getName()%></td>
						<td width="300"><img src="img/1.png"  height="20px" width="20px"><%=info.getNum()%></td>
						<td width="100px"><a href="dovote?id=<%=info.getId()%>&num=<%=info.getNum()%>">投票</a></td>
					</tr>
				<%
			}
			%>
		</table>
		<% 
	}
%>
</center>
</body>
</html>