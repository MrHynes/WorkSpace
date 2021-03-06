$(function () {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {/*验证：规则*/
        	username: {//验证input项：验证规则
                message: '用户名验证失败',
                validators: {
                    notEmpty: {//非空验证：提示消息
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 15,
                        message: '用户名长度必须在3到15位之间'
                    },
                    threshold :  4 , //有4字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，4字符以上才开始）
                    remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                        url: 'user/usernameIsExist.do',//验证地址
                        message: '无法使用该用户名，用户已存在',//提示消息
                        delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                        type: 'POST'//请求方式,
             
                        /**自定义提交数据，默认值提交当前input value
                         *  data: function(validator) {
                              return {
                                  password: $('[name="passwordNameAttributeInYourForm"]').val(),
                                  whatever: $('[name="whateverNameAttributeInYourForm"]').val()
                              };
                           }
                         */
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9]+$/,
                        message: '用户名只能包含大写、小写字母、数字'
                       // regexp: /^[a-zA-Z0-9_]+$/,
                        //message: '用户名只能包含大写、小写字母、数字和下划线'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 15,
                        message: '密码长度必须在3到15位之间'
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
                        min: 3,
                        max: 15,
                        message: '密码长度必须在3到15位之间'
                    },
                    identical: {//相同
                        field: 'password', //需要进行比较的input name值
                        message: '两次密码不一致'
                    }
                }
            },
            phoneNum: {
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
            postCode: {
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
            realName: {
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
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '邮箱地址格式有误'
                    }
                }
            },//
            checkOne: {
            	validators: {
            		notEmpty: {
            			message: 'Please accept the agreement'
            	    }
                 }
            }
        }
    });
    
    
    
});


