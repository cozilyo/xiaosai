<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>xiaosai-登录日志</title>
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
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">操作人</label>
                            <div class="layui-input-inline">
                                <input type="text" name="operator" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">操作模块</label>
                            <div class="layui-input-inline">
                                <input type="text" name="operationModule" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">操作类型</label>
                            <div class="layui-input-inline">
                                <input type="text" name="operationType" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">操作对象</label>
                            <div class="layui-input-inline">
                                <input type="text" name="operands" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">操作ip</label>
                            <div class="layui-input-inline">
                                <input type="text" name="ip" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">操作内容</label>
                            <div class="layui-input-inline">
                                <input type="text" name="operationContent" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">开始时间</label>
                            <div class="layui-input-inline">
                                <input type="text" id="startTime" name="startTime" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">结束时间</label>
                            <div class="layui-input-inline">
                                <input type="text" id="endTime" name="endTime" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">搜索</a>
                            <button type="reset" class="layui-btn layui-btn-primary data-reset-btn">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <div class="layui-btn-group">
            <#--<button class="layui-btn data-add-btn">添加</button>-->
            <a class="layui-btn data-add-btn layui-menu-tips" href="###" target="_self">导出当前</a>
            <a class="layui-btn data-add-btn layui-menu-tips" href="###" target="_self">导出所有</a>
<#--            <button class="layui-btn layui-btn-danger data-delete-btn" style="margin-left: 10px !important;">批量删除</button>-->
        </div>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>
<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="../js/web/logmanage/logManageList.js"></script>
<#--<script src="../layuimini/js/index.js"></script>-->

</body>
</html>