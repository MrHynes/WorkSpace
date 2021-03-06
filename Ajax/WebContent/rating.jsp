<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/json.js"></script>
<body>

	<h3>您对这门课程的感兴趣吗？</h3>
	<form id="ratingForm" action="ratingServlet" method="POST">
		<input type="radio" name="rating" value="5" checked="checked">5
		<input type="radio" name="rating" value="4">4 <input
			type="radio" name="rating" value="3">3 <input type="radio"
			name="rating" value="2">2 <input type="radio" name="rating"
			value="1">1 <br> 理由是：<br>
		<textarea id="comment" cols="20" rows="5"></textarea>
		<br> <input type="button" value="确定" onclick="ratingProcess();" />
	</form>
	<div id="showRating"
		style="border: 1px solid green; display: none; width: 50%"></div>

	<script>
		var xmlrequest;

		function createXMLRequest() {

			if (window.XMLHttpRequest) {

				xmlrequest = new XMLHttpRequest();
			} else if (window.ActiveXObject) {

				try {

					xmlrequest = new ActiveXObject("Msxml2.XMLHTTP");

				} catch (e) {

					try {

						xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
					}
				}
			}
		}

		function ratingProcess() {

			//获取radio和textarea中的值
			var show = document.getElementById("showRating");
			show.innerHTML = "";
			var ratingForm = document.getElementById("ratingForm");
			var ratings = ratingForm.rating;
			var ratingValue = null;
			for (var i = 0; i < ratings.length; i++) {

				if (ratings[i].checked) {
					ratingValue = ratings[i].value;
					break;
				}
			}
			var comm = ratingForm.comment.value;

			// 先创建一个js对象
			var payloadJson = {
				rating : ratingValue,
				comm : comm
			};
			//payloadJson.rating = ratingValue;
			//payloadJson.comm = comm ;
			// 将该js对象 序列化为 jsonString
			var payload = payloadJson.toJSONString();

			createXMLRequest();
			var uri = "ratingServlet";
			xmlrequest.open("POST", uri, true);
			//设置请求头的内容类型

			xmlrequest.setRequestHeader("Content-Type",
					"application/json;charset=utf-8");
			xmlrequest.onreadystatechange = function() {
				processResponse();
			}
			xmlrequest.send(payload);

		}
		function processResponse() {

			if (xmlrequest.readyState == 4) {

				if (xmlrequest.status == 200) {
					//  将jsonstring 转化成 jsObject
					var jsObject = xmlrequest.responseText.parseJSON()
					var result = jsObject.result;
					var showRating = document.getElementById("showRating");
					showRating.innerHTML = result;
					showRating.style.display = "";
				}

			}

		}
	</script>
</body>
</html>