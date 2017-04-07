$(function () {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	username: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 10,
                        message: '用户名长度必须在6到10位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写字母、数字和下划线'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 10,
                        message: '密码长度必须在6到10位之间'
                    }
                }
            }
        }
    });
});

/*
$(function() {
	$("#resetInfo").click(function() {
		$("#txtUserName2").val='';
		$("#txtPassWord2").val='';
		$("#txtPassWord3").val='';
	});
});
*/

//dom方式
/*
function reset() {
	document.getElememtById("txtUserName2").value='';
	document.getElememtById("txtPassWord2").value='';
	document.getElememtById("txtPassWord3").value='';
}
*/
