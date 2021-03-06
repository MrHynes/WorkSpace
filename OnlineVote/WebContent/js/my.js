/*
function checkform(){ 
    if(document.getElementById('username').value.length==0){    
        alert('用户名输入不能为空！');
        document.getElementById('username').focus();
        return false;
    }
    if(document.getElementById('password').value.length==0){    
        alert('密码输入不能为空！');
        document.getElementById('password').focus();
        return false;
    }
    if(document.getElementById('txtUserName2').value.length==0){    
        alert('密码输入不能为空！');
        document.getElementById('txtUserName2').focus();
        return false;
    }
    if(document.getElementById('txtPassWord2').value.length==0){    
        alert('密码输入不能为空！');
        document.getElementById('txtPassWord2').focus();
        return false;
    }
    if(document.getElementById('txtPassWord3').value.length==0){    
        alert('密码输入不能为空！');
        document.getElementById('txtPassWord3').focus();
        return false;
    }
}
*/
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

