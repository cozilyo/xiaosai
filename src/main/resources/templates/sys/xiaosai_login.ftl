<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
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
            <span>密码：</span><input type="text" id="password" name="password" placeholder="最多16位">
        </div>
        <div style="margin-top: 20px;">
            <input type="submit" value="登录" style="background: #39cc39;"><input id="regis" type="button" value="注册" style="margin-left: 3px;background: #39cc39;">
        </div>
    </form>
</div>
<script type="application/javascript">
     $("#regis").on("click",function () {
         window.location.href("/xiaosai/register");
     })
</script>
</body>
</html>