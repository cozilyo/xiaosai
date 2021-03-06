<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>XIAOSAI-登陆</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../layuimini/lib/layui-v2.5.4/css/layui.css" type="text/css" media="all">
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        html, body {width: 100%;height: 100%;overflow: hidden}
        body {background: #009688;}
        body:after {content:'';background-repeat:no-repeat;background-size:cover;-webkit-filter:blur(3px);-moz-filter:blur(3px);-o-filter:blur(3px);-ms-filter:blur(3px);filter:blur(3px);position:absolute;top:0;left:0;right:0;bottom:0;z-index:-1;}
        .layui-container {width: 100%;height: 100%;overflow: hidden}
        .admin-login-background {width:360px;height:300px;position:absolute;left:50%;top:40%;margin-left:-180px;margin-top:-100px;}
        .logo-title {text-align:center;letter-spacing:2px;padding:14px 0;}
        .logo-title h1 {color:#009688;font-size:25px;font-weight:bold;}
        .login-form {background-color:#fff;border:1px solid #fff;border-radius:3px;padding:14px 20px;box-shadow:0 0 8px #eeeeee;}
        .login-form .layui-form-item {position:relative;}
        .login-form .layui-form-item label {position:absolute;left:1px;top:1px;width:38px;line-height:36px;text-align:center;color:#d2d2d2;}
        .login-form .layui-form-item input {padding-left:36px;}
        .captcha {width:60%;display:inline-block;}
        .captcha-img {display:inline-block;width:34%;float:right;}
        .captcha-img img {height:34px;border:1px solid #e6e6e6;height:36px;width:100%;}
        .login_sys{
            float: right;
            margin-right: 20px;
            color: #00a2d4;
        }
    </style>
</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
<#--            <form class="layui-form" action="/xiaosai/checkUser" method="post">-->
<#--            <form class="layui-form" >-->
                <div class="layui-form-item logo-title">
                    <h1>XIAOSAI登录</h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username" for="username"></label>
                    <input type="text" name="userName" lay-verify="required|username" placeholder="用户名或者邮箱" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" name="password" lay-verify="required|password" placeholder="密码" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-vercode" for="captcha"></label>
                    <input id="captcha_id" type="text" name="captcha" lay-verify="required|captcha" placeholder="图形验证码" maxlength="5" autocomplete="off" class="layui-input verification captcha">
                    <div class="captcha-img">
                        <img id="captchaPic" class="captcha_Pic" src="/xiaosai/getVerify" alt="点击验证码更换" title="点击验证码更换">
                    </div>
                </div>
                <div class="layui-form-item" id="verify_msg">
                </div>
                <div class="layui-form-item">
                    <input type="checkbox" name="rememberMe" value="true" lay-skin="primary" title="记住密码">
                    <a class="login_sys" id="login_sys">扫一扫</a>
                </div>
                <div class="layui-form-item">
                    <button id="submit_id" class="layui-btn layui-btn-fluid" lay-submit lay-filter="loginBtn" disabled>登 入</button>
<#--                    <button id="submit_id" class="layui-btn layui-btn-fluid" type="submit" disabled>登 入</button>-->
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid xs_register" type="button">注 册 </button>
                </div>
<#--            </form>-->
        </div>
    </div>
</div>
<script src="../layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="../layuimini/lib/jq-module/jquery.particleground.min.js" charset="utf-8"></script>
<script src="../js/sweetalert2.9.5.4.all.js"></script>
<script src="../js/sys/login.js" charset="utf-8"></script>
</body>
</html>