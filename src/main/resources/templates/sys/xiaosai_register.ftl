<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<body>
<div align="center">
    <div style="height: 50px;"></div>
    <div>
        <h1>xiaosai</h1>
    </div>
    <form action="/xiaosai/addUser" method="post">
        <div>
            <span>姓名：</span><input type="text" id="name" name="name" placeholder="您的有效昵称">
        </div>
        <br/>
        <div>
            <span>账号：</span><input type="text" id="userName" name="userName" placeholder="用户名/手机号/邮箱">
        </div>
        <br/>
        <div>
            <span>密码：</span><input type="text" id="password" name="password" placeholder="最多16位">
        </div>
        <br/>
        <div>
            <span>手机号：</span><input type="text" id="telephone" name="telephone" placeholder="手机号或者电话">
        </div>
        <br/>
        <div>
            <span>邮箱：</span><input type="text" id="mail" name="mail" placeholder="请输入正确的邮箱">
        </div>
        <br/>
        <div>
            <span>性别：</span><span>男</span><input type="radio" id="gender" name="gender" value="1">
            <span>女</span><input type="radio" id="gender" name="gender" value="0">
            <span>未知</span><input type="radio" id="gender" name="gender" value="2" checked="checked">
        </div>
        <br/>
        <div>
            <span>年龄：</span><input type="text" id="age" name="age" placeholder="0-150">
        </div>
        <br/>
        <div>
            <span>身份证号：</span><input type="text" id="idNum" name="idNum" placeholder="请输入正确的身份证号">
        </div>
        <div style="margin-top: 20px;">
            <input type="submit" value="注册" style="background: #39cc39;"><input type="button" value="登录" style="margin-left: 3px;background: #39cc39;">
        </div>
    </form>
</div>

</body>
</html>