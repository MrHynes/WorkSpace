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

