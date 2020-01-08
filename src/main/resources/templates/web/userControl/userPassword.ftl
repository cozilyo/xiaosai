<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layuimini/lib/layui-v2.5.4/css/layui.css" media="all">
    <link rel="stylesheet" href="../layuimini/css/public.css" media="all">
    <style>
        .layui-form-item .layui-input-company {width: auto;padding-right: 10px;line-height: 38px;}
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label required">旧的密码</label>
                <div class="layui-input-block">
                    <input type="password" name="old_password" lay-verify="required" lay-reqtext="旧的密码不能为空" placeholder="请输入旧的密码"  value="" class="layui-input">
                    <tip>填写自己账号的旧的密码。</tip>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label required">新的密码</label>
                <div class="layui-input-block">
                    <input type="password" name="new_password" lay-verify="required" lay-reqtext="新的密码不能为空" placeholder="请输入新的密码"  value="" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">新的密码</label>
                <div class="layui-input-block">
                    <input type="password" name="again_password" lay-verify="required" lay-reqtext="新的密码不能为空" placeholder="请输入新的密码"  value="" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="saveBtn">确认保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
<input type="hidden" id="soleName" value="${userName}">
<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="../js/sweetalert2.9.5.4.all.js"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer
            ,$ = layui.jquery;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            /*layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })*/
            var result = data.field;
            if(result.new_password!=result.again_password){
                Swal.fire("两次密码不一致！请重新输入");
                return false;
            }
            var params ={
                userName: $("#soleName").val(),
                password: result.old_password,
                passwords:result.new_password
            }
            $.ajax({
                async: false,
                type: 'POST',
                url: '/xiaosai/userPasswordEditData',
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(params),
                success: function (val) {
                    if (val.code == 0) {
                        Swal.fire(val.msg);
                    } else {
                        Swal.fire(val.msg);
                    }
                }
            })
            return false;
        });
    });
</script>
</body>
</html>