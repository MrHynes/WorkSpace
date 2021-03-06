<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script src="js/ajax.js" type="text/javascript"></script>
	<script src="js/json.js" type="text/javascript"></script>
	<script src="js/json2.js" type="text/javascript"></script>
   <style type="text/css">

	#content1 {
	
		width:90%;
		align:center;
		height:auto;
		padding-top:10px;
		margin:0;
		padding:5px 0px 0px 5px;
		border:1px solid #EEEEEE;
		
	}
	
	
	</style>
  </head>
  
  <body onload="getMsgPerSecond();">
  
  
    <div class="main">
    	
    	<div class="content">
    	<div id="content1">
    		<h4 align="center">聊天页面</h4>
    		<!-- <hr> -->
    		<p align="center">
    		<textarea id="chatArea" cols="100" rows="10" readonly="readonly"></textarea>
    		</p>
    		
	    		<table align="center">
		    		<tr>
			    		<td>
			    		<input id="chatMsg" type="text" size="60" />
			    		<input type="submit" value="提交" onclick="sendMsg() ;"/>    		
			    		</td>
		    		</tr>
	    		<tr >
	    		<td align="center">
	    		  <div style="text-align:center;background-color:#ff6600; height:30px;  width:20%" >
	    		  	<a href="exit.jsp">
	    		    	<font style="font-size: 16px; font-weight:bold;color: #FFFFFF">退&nbsp;&nbsp;出</font>
	    		    </a>
	    		  </div>
	    		</td>
	    		
	    		</tr>
	    		<tr>
	    			<td align="center"><button onclick="getMsgList();">获取消息列表</button></td>
	    		</tr>
	    		</table>
	    		<table id="msgTable" cellspacing="1" align="center" width="80%" border="1px solid green">
	    			<tr >
	    			<td width="30%">时间</td>
	    			<td width="40%">内容</td>
	    			<td width="30%">发送人</td>
	    			</tr>
	    		</table>
    		
    	</div>
    	</div>
	
    </div>
   <script type="text/javascript">
    		
   			var xhr = createXMLRequest() ;
    		function sendMsg() {
    			
    			var url = "chatServlet" ;
    			
    			var msg = document.getElementById("chatMsg").value ;
    			document.getElementById("chatMsg").value="";
    			
    			if ( msg == null || msg == "") {
    				alert("msg is null!"); 
    				return ;
    			}
    	
    			var payload = "action=sendMsg&msg="+msg + "&time="+new Date() ;
    			xhr.open("POST", url,"true") ;
    			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8") ;
    			xhr.onreadystatechange = function() {
    				processResponse(xhr) ;
    			};
    			xhr.send(payload) ;
    		}

    		 function processResponse(xhr) {
    			 if (xhr.readyState==4 && xhr.status==200) {
					 var chatArea = document.getElementById("chatArea") ;
					 chatArea.value = null ;
					 var msgList = xhr.responseText.parseJSON() ;
					 for ( var i=0; i<msgList.length; i++) {
						 
						 if ( i == msgList.length-1) {
							 chatArea.value += msgList[i] ;
						 } else {
							 chatArea.value += msgList[i] + "\n" ;
						 }
						 
					 }
					 
				 }			
			} 
    		 function getMsg() {
    			 var url = "chatServlet?action=getMsg" ;
    			 xhr.open("GET", url, true) ;
    			 xhr.onreadystatechange= function() {
    				 processResponse(xhr) ;
    			 } ;
    			 xhr.send(null) ;
    		 }
    		 
    		function getMsgPerSecond() {
    			
    			//setInterval("getMsg()",1000) ;  
    			 
    		 } ;
    		 
    		 function getMsgList() {
    			 var url = "chatServlet?action=msgList" ;
    			 xhr.open("GET",url, "true") ;
    			 xhr.onreadystatechange = function() {
    				 if (xhr.readyState == 4 && xhr.status == 200 ) {
    					 var msgList = xhr.responseText.parseJSON() ;
    					 showMsg(msgList) ;
    				 } 
    			 } ;
    			 xhr.send(null) ;
    		 }
    		 function showMsg(msgList) {
    			 var msg = null ;
    			 var table = document.getElementById("msgTable") ;
    			 var tr, td1,td2,td3 ;
    			 for ( var i =0; i<msgList.length; i++) {
    				 tr = document.createElement("tr") ;
    				 td1 = document.createElement("td") ;
    				 td2 = document.createElement("td") ;
    				 td3 = document.createElement("td") ;
    				 td1.innerHTML = msgList[i].date ;
    				 td2.innerHTML = msgList[i].content ;
    				 td3.innerHTML = msgList[i].username ;
    				 tr.appendChild(td1) ;
    				 tr.appendChild(td2) ;
    				 tr.appendChild(td3) ;
    				 table.appendChild(tr) ;
    			 }
    		 }
    	</script>
  
  </body>
</html>
