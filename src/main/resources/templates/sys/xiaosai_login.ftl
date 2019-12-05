<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<script type="text/javascript" src="../js/jQuery-v3.4.1.js"></script>
<body>
<div align="center">
    <div style="height: 50px;"></div>
    <div>
        <h1>xiaosai</h1>
    </div>
    <form action="/xiaosai/checkUser" method="post">
        <div>
            <span>账号：</span><input type="text" id="userName" name="userName" placeholder="用户名/手机号/邮箱">
        </div>
        <br/>
        <div>
            <span>密码：</span><input type="password" id="password" name="password" placeholder="最多16位">
        </div>
        <div style="margin-top: 20px;"><spa style="color: red">${msg}</spa></div>
        <div style="margin-top: 20px;">
            <input type="submit" value="登录" style="background: #39cc39;">
            <a href="/xiaosai/register">注册</a>
<#--            <input class="regis" id="regis" name="regis" type="button" value="注册" style="margin-left: 3px;background: #39cc39;">-->
        </div>
    </form>
</div>
<script type="application/javascript">
    /* $(".regis").click(function () {
         alert("111");
     })*/
</script>
</body>
</html>