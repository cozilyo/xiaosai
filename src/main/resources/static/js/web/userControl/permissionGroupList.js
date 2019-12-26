/**
 * 用户权限组
 */
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
        id: 'tableReload',
        limits: [10, 15, 20, 25, 50, 100],
        limit: 10,
        page: true
    });

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var result = data.field;
        //执行搜索重载
        table.reload('tableReload', {
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
    $(".data-reset-btn").on("click",function () {
        //执行重置重载
        table.reload('tableReload', {
            url:"/xiaosai/PermissionGroupListData",
            where: {
                groupName: '',
                accessLevel: '',
                createTime: ''
            },
            page:{
                curr: 1
            }
        });
    })

    // 监听添加操作
    $(".data-add-btn").on("click", function () {
        /*top.layui.index.openTabsPage("/xiaosai/PermissionGroupAdd","添加权限组");*/
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