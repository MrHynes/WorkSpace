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
            relname: {
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
            tyepName: {
                message: '类别名验证失败',
                validators: {
                    notEmpty: {
                        message: '类别名不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 20,
                        message: '类别名长度必须在1到20位之间'
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
                        max: 15,
                        message: '密码长度必须在6到15位之间'
                    },
                    different: {//不能和用户名相同
                        field: 'username',//需要进行比较的input name值
                        message: '不能和用户名相同'
                    }
                }
            },
            repassword: {
                validators: {
                    notEmpty: {
                        message: '请再次输入密码'
                    },
                    stringLength: {
                        min: 6,
                        max: 15,
                        message: '密码长度必须在6到15位之间'
                    },
                    identical: {//相同
                        field: 'password', //需要进行比较的input name值
                        message: '两次密码不一致'
                    }
                }
            },
            oldpassword:{
            	validators: {
                    notEmpty: {
                        message: '请输入旧密码'
                    },
                    stringLength: {
                        min: 6,
                        max: 15,
                        message: '密码长度必须在6到15位之间'
                    }
                }
            },
            telephone: {
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
            postcode: {
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
            birthday:{
            	validators: {
                    notEmpty: {
                        message: '生日不能为空'
                    },
                    regexp:{
                    	 regexp:/^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/,
                         message: '请输入正确的日期yyyy-MM-dd'
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
            cost:{
                validators: {
                    notEmpty: {
                        message: '费用不能为空'
                    },
                    regexp:{
                        regexp:/^[1-9]{1}\d*(\.\d{1,2})?$/,
                        message: '只能输入数字'
                    }

                }
            },
            usefulLife:{
                validators: {
                    notEmpty: {
                        message: '有效期不能为空'
                    },
                    regexp:{
                        regexp:/^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/,
                        message: '请输入正确的日期yyyy-MM-dd'
                    }

                }
            }
        }
    });
    
});


var xhr;
var flag;
function createXHR() {
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		try {
			xhr = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
}

function checkuser(username) {
	createXHR();
	xhr.open("GET", "/ECProject/isExist?username=" + username);
	xhr.onreadystatechange = checkuserCalBack;
	xhr.send(null);
}
function checkuserCalBack() {
	if (xhr.readyState == 4) {
		if (xhr.status == 200) {
			var text = xhr.responseText;
			if (text == "true") {
				flag = true;
				document.getElementById("text").innerHTML = "可以注册";
			} else {
				flag = false;
				document.getElementById("text").innerHTML = "不可以注册";
			}
		}
	}
}
function checkForm() {
	return flag;
}


