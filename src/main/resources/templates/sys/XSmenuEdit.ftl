<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>xiaosai-菜单管理编辑</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layuimini/lib/layui-v2.5.4/css/layui.css" media="all">
    <link rel="stylesheet" href="../layuimini/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>菜单管理编辑</legend>
        </fieldset>

        <form class="layui-form" lay-filter="pg">
            <div class="layui-form-item">
                <label class="layui-form-label">菜单名称</label>
                <div class="layui-input-block">
                    <input type="text" name="title" lay-verify="required" placeholder="请输入" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单地址</label>
                <div class="layui-input-block">
                    <input type="text" name="href" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">图标名称</label>
                <div class="layui-input-block">
                    <input type="text" name="icon" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">目标</label>
                <div class="layui-input-block">
                    <input type="text" name="target" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">导航标识</label>
                <div class="layui-input-block">
                    <input type="text" name="navigationBarName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">导航排序</label>
                <div class="layui-input-block">
                    <input type="text" name="navigationBarIndex" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="data-submit-btn">立即保存</button>
<#--                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>-->
                    <button type="button" class="layui-btn layui-btn-danger cancel">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>

<input type="hidden" value="${id}" class="menuEditId">
<input type="hidden" class="navId">

<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="../js/sys/menuEdit.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

</body>
</html>