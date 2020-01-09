<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>设置图标</title>
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
            <legend>图标编辑</legend>
            <div class="layui-form layuimini-form">
                <div class="layui-form-item">
                    <label class="layui-form-label required">管理账号</label>
                    <div class="layui-input-block">
                        <input type="text" id="userName" name="userName" lay-verify="required" lay-reqtext="管理账号不能为空" placeholder="请输入管理账号" class="layui-input">
                        <tip>填写自己管理账号的名称。</tip>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label required">主题</label>
                    <div class="layui-input-block">
                        <input type="text" id="title" name="title" lay-verify="required" lay-reqtext="主题不能为空" placeholder="请输入主题" class="layui-input">
                        <tip>此项只有超级管理员才能修改</tip>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">图标示例</label>
                    <div class="layui-input-block" id="imageExanple">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label required">图标</label>
                    <div class="layui-input-inline">
                        <input type="text" id="imageId" name="imageId" lay-verify="required" lay-reqtext="图标地址不能为空" placeholder="请输入图标地址" class="layui-input" readonly>
                    </div>
                    <div class="layui-input-inline">
                        <select id="image_so" name="image_so" lay-filter="image_so">
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label required">主页</label>
                    <div class="layui-input-block">
                        <input type="text" id="href" name="href"  placeholder="请输入主页地址" class="layui-input">
                        <tip>此项只有超级管理员才能修改</tip>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="saveBtn">确认保存</button>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>

</div>

<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="../js/sweetalert2.9.5.4.all.js"></script>
<script src="../js/sys/logoIcon.js"></script>

</body>
</html>