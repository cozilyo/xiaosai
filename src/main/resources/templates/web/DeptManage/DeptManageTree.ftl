<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>xiaosai-部门管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layuimini/lib/layui-v2.5.4/css/layui.css" media="all">
    <link rel="stylesheet" href="../layuimini/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <div class="layui-container">
            <div class="layui-row">
<#--                部门侧边栏-->
                <div class="layui-col-lg3">
                    <fieldset class="layui-elem-field layuimini-search">
                        <legend>部门信息</legend>
                        <div style="margin: 10px 10px 10px 10px">
                            <div id="dept-manage-tree" class="demo-tree"></div>
                        </div>
                    </fieldset>
                </div>
<#--                部门详情信息-->
                <div class="layui-col-lg9">
                    <fieldset class="layui-elem-field layuimini-search">
                        <legend>部门人员信息</legend>
                        <div>
                            <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
                        </div>
                    </fieldset>
                </div>
            </div>
        </div>


        <div class="layui-btn-group">
            <#--<button class="layui-btn data-export-part-btn">导出当前</button>
            <button class="layui-btn data-export-all-btn">导出所有</button>-->
        </div>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>
<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="../js/web/deptmanage/deptManage.js"></script>

</body>
</html>