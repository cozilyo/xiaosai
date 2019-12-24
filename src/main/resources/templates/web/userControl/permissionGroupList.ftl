<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>权限组管理</title>
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
                            <label class="layui-form-label">权限组名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="groupName" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">权限等级</label>
                            <div class="layui-input-inline">
                                <input type="text" name="accessLevel" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">创建时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="createTime" autocomplete="off" class="layui-input">
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
            <button class="layui-btn data-add-btn">添加</button>
            <button class="layui-btn layui-btn-danger data-delete-btn">删除</button>
        </div>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
    </div>
</div>
<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '/xiaosai/PermissionGroupListData',
            method:'post',
            contentType: 'application/json',
            cols: [[
                {type: "checkbox", width: 50, fixed: "left"},
                {field: 'id', width: 65, title: 'ID', sort: true},
                {field: 'groupName', minwidth: 60, title: '权限组名称'},
                {field: 'groupType', width: 100, title: '权限组代号'},
                {field: 'accessLevel', width: 120, title: '权限等级'},
                {field: 'createTime', title: '创建时间', minWidth: 80},
                {field: 'modifyTime', minWidth: 80, title: '修改时间'},
                {title: '操作', minWidth: 50, templet: '#currentTableBar', fixed: "right", align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            page: true
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = data.field;
            //执行搜索重载
            table.reload('currentTableId', {
                url:"/xiaosai/PermissionGroupListData",
                where: {
                    groupName: result.groupName,
                    accessLevel: result.accessLevel,
                    createTime: result.createTime
                },
                page:{
                    curr: 1
                }
            }, 'data');
            return false;
        });

        //监听重置操作
        /*form.on('submit(data-reset-btn)', function (data) {
            var result = data.field;
            //执行搜索重载
            table.reload('currentTableId', {
                url:"/xiaosai/PermissionGroupListData",
                where: {
                    groupName: result.groupName,
                    accessLevel: result.accessLevel,
                    createTime: result.createTime
                },
                page:{
                    curr: 1
                }
            }, 'data');
            return false;
        });*/

        // 监听添加操作
        $(".data-add-btn").on("click", function () {
            layer.msg('添加数据');
        });

        // 监听删除操作
        $(".data-delete-btn").on("click", function () {
            var checkStatus = table.checkStatus('currentTableId')
                , data = checkStatus.data;
            layer.alert(JSON.stringify(data));
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (obj.event === 'delete') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });

    });
</script>
<script>

</script>

</body>
</html>