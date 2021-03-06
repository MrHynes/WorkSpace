<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL流程控制标签</title>
</head>
<body>

	<c:if test="{2>5}" var="result">
 		 条件为真，结果的值为：${result}<br>
  		 条件为假，结果的值为：${username}<br>
	</c:if>
	<c:set var="username" value="imut"></c:set>
	<c:if test="${username=='imut' }" var="result">
		条件为真，结果的值为：${result}<br>
	        条件为假，结果的值为：${username}<br>
	</c:if>
	<c:set var="score" value="80"></c:set>
	<c:choose>
		<c:when test="${score>=90}">优秀</c:when>
		<c:when test="${score<90&&score>=75 }">良好</c:when>
		<c:when test="${score<75&&score>=60 }">及格</c:when>
		<c:otherwise>不及格</c:otherwise>
	</c:choose>
</body>
</html>