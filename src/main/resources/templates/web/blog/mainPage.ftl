<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layuimini/lib/layui-v2.5.4/css/layui.css" media="all">
    <link rel="stylesheet" href="../layuimini/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="layui-elem-field layuimini-search">
            <legend>BOLG主页</legend>
            <div style="margin: 10px 10px 10px 10px">

                    <p style="margin-top: 50px;margin-bottom: 20px;">登录页</p>
                    <img src="../readmeImg/login.png" width="40%">
                    <p style="margin-top: 50px;margin-bottom: 20px;">首页</p>
                    <img src="../readmeImg/index.png" width="40%">
                    <p style="margin-top: 50px;margin-bottom: 20px;">菜单页</p>
                    <img src="../readmeImg/menu.png" width="40%">
                    <p style="margin-top: 50px;margin-bottom: 20px;">菜单添加页</p>
                    <img src="../readmeImg/menuadd.png" width="40%">
            </div>
        </fieldset>

    </div>
</div>
<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;
    });
</script>

</body>
</html>