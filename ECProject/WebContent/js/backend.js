$(function() {
		$("#exit").click(function() {
			//http://www.weixuehao.com/archives/415 中文
			bootbox.confirm({
				size : "small",
				message : "确认退出系统吗?",
				callback : function(result) {
					if (result) {
						location.href = "/ECProject/backend/login.jsp";
					} else {
						return;
					}
				}
			});
		});
		$("#exit2").click(function() {
			bootbox.confirm({
				size : "small",
				message : "确认退出系统吗?",
				callback : function(result) {
					if (result) {
						location.href = "/ECProject/backend/login.jsp";
					} else {
						return;
					}
				}
			});
		});
	var i=0;
	
		$("#showInfo").click(function() {
				$("#username").attr("disabled",true);
				$("select").attr("disabled", true);
				$("#relname").attr("disabled", true);
				$("#birthday").attr("disabled", true);
				$("#telephone").attr("disabled", true);
				$("#email").attr("disabled", true);
				$("#postcode").attr("disabled", true);
				$("#address").attr("disabled", true);
			$("#alter").remove();
			i=0;
		});
		$("#alterInfo").click(function() {
			if(i==0){
				$("input").removeAttr("disabled");
				$("select").removeAttr("disabled");
				var info = $("<div id='alter'><br><div class='col-lg-5 col-lg-offset-1'><input type='submit' id='btnsubmit' class='btn btn-primary btn-block'></input></div>"
					+ "<div class='col-lg-5'><input type='reset' id='btnreset' class='btn btn-warning btn-block'></input></div></div>");
				$("#addressDiv").append(info);
				i++;
			}
		});
		
		$("#goodAdmin").click(function () {
			//removeClass
			$("#goodAdmin").addClass("active-menu");
			$("#userAdmin").removeClass("active-menu");
			$("#perInfoAdmin").removeClass("active-menu");
			$("#orderAdmin").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#userAdmin").click(function () {
			//removeClass
			$("#userAdmin").addClass("active-menu");
			$("#goodAdmin").removeClass("active-menu");
			$("#perInfoAdmin").removeClass("active-menu");
			$("#orderAdmin").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#perInfoAdmin").click(function () {
			//removeClass
			$("#perInfoAdmin").addClass("active-menu");
			$("#goodAdmin").removeClass("active-menu");
			$("#userAdmin").removeClass("active-menu");
			$("#orderAdmin").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#orderAdmin").click(function () {
			//removeClass
			$("#orderAdmin").addClass("active-menu");
			$("#goodAdmin").removeClass("active-menu");
			$("#userAdmin").removeClass("active-menu");
			$("#perInfoAdmin").removeClass("active-menu");
			$("#exit2").removeClass("active-menu");
		});
		$("#exit2").click(function () {
			//removeClass
			$("#exit2").addClass("active-menu");
			$("#goodAdmin").removeClass("active-menu");
			$("#userAdmin").removeClass("active-menu");
			$("#perInfoAdmin").removeClass("active-menu");
			$("#orderAdmin").removeClass("active-menu");
		});
	});