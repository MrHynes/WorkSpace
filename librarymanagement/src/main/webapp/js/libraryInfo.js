$(function () {
	$("input").attr("disabled",true);
	$("textarea").attr("disabled",true);
	loadInfo();
	function loadInfo(){
	$.ajax({
        url:'library/info.do',
        type:'POST', //GET
        async:true,    //或false,是否异步
        data:{	          	
        },
        timeout:5000,    //超时时间
        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text	    
        success:function(data,textStatus,jqXHR){
        	$("#id").val(data.id);
        	$("#libraryName").val(data.libraryname);
        	$("#libraryLeader").val(data.curator);
        	$("#libraryTel").val(data.tel);
        	$("#libraryAddress").val(data.address);
        	$("#libraryEmail").val(data.email);
        	$("#libraryUrl").val(data.url);
        	$("#libraryCreateTime").val(data.createDate);
        	$("#libraryIntroduct").val(data.introduce);
        }
	});
	}
	$("#modify").click(function(){
		$("input").attr("disabled",false);
		$("textarea").attr("disabled",false);
	})
	$("#save").click(function(){
		$.ajax({
			url:'library/save.do',
			type:'POST',
			async:true,
			data:{
				id:$("#id").val(),
	        	libraryname:$("#libraryName").val(),
	        	curator:$("#libraryLeader").val(),
	        	tel:$("#libraryTel").val(),
	        	address:$("#libraryAddress").val(),
	        	createDate:$("#libraryCreateTime").val(),
	        	email:$("#libraryEmail").val(),
	        	url:$("#libraryUrl").val(),
	        	introduce:$("#libraryIntroduct").val()
			},
			timeout:5000,
			dataType:'json',
			success:function(data,textStatus,jqXHR){
				alert("保存成功");
				location.reload();
			}
		});
	});
	
});

