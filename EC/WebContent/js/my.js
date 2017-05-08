$(function () {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	user: {
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
            name: {
                message: 'The realname is not valid',
                validators: {
                    notEmpty: {
                        message: '真实姓名不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 20,
                        message: '请输入2-10个字符的真实姓名'
                    },
                    regexp: {
                        regexp:  /^(([\u4e00-\u9fa5]{2,5})|([a-zA-Z]{2,10}))$/,
                        message: '请输入正确的姓名'
                    }
                }
            },
            pwd: {
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
            },
            phone: {
                message: 'The phone is not valid',
                validators: {
                    notEmpty: {
                        message: '手机号码不能为空'
                    },
                    stringLength: {
                        min: 11,
                        max: 11,
                        message: '请输入11位手机号码'
                    },
                    regexp: {
                        regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                        message: '请输入正确的手机号码'
                    }
                }
            },
            code: {
                message: 'The postCode is not valid',
                validators: {
                    notEmpty: {
                        message: '邮编不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 6,
                        message: '请输入6位邮编'
                    },
                    regexp: {
                        regexp:  /^[1-9][0-9]{5}$/,
                        message: '请输入正确的邮政编码'
                    }
                }
            },
            address: {
                message: 'The address is not valid',
                validators: {
                    notEmpty: {
                        message: '地址不能为空'
                    },
                    stringLength: {
                        min: 0,
                        max: 100,
                        message: '地址信息长度不能大于100'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '邮箱地址格式有误'
                    }
                }
            },
            
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
/**
 * Created by Buer on 2017/4/24.
 */


