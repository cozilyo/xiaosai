/**
 * 日志管理-登录日志管理列表
 */
layui.use(['form', 'table','laydate'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        laydate = layui.laydate;

    table.render({
        elem: '#currentTableId',
        url: '/xiaosai/logManageListData',
        method:'post',
        contentType: 'application/json',
        cols: [[
            // {type: "checkbox", width: 50, fixed: "left"},
            {type: "numbers",title:"序号"},
            {field: 'operator', width: 100, title: '操作人'},
            {field: 'operationModule', width: 100, title: '模块'},
            {field: 'operationType', width: 120, title: '类型'},
            {field: 'operands', title: '对象', width: 120},
            {field: 'ip', width: 120, title: 'ip'},
            {field: 'operationContent', minWidth: 80, title: '操作内容'},
            {field: 'operationTime', width: 160, title: '操作时间'}
            // {title: '操作', minWidth: 50, templet: '#currentTableBar', fixed: "right", align: "center"}
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
            url:"/xiaosai/logManageListData",
            where: {
                operator: result.operator,
                operationModule: result.operationModule,
                operationType: result.operationType,
                operands: result.operands,
                ip: result.ip,
                operationContent: result.operationContent,
                startTime: result.startTime,
                endTime: result.endTime
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
            url:"/xiaosai/logManageListData",
            where: {
                operator: '',
                operationModule: '',
                operationType: '',
                operands: '',
                ip: '',
                operationContent: '',
                startTime: '',
                endTime: ''
            },
            page:{
                curr: 1
            }
        });
    })

    laydate.render({
        elem:'#startTime',
        type: "datetime"
    });

    laydate.render({
        elem:'#endTime',
        type: "datetime"
    });

    // 监听导出部分操作
    $(".data-export-part-btn").on("click", function () {
        var url = "/xiaosai/exportLogExcel?operator="+$('#operator').val()+"&operationModule="+$('#operationModule').val()+
            "&operationType="+$('#operands').val()+"&ip="+$('#ip').val()+"&operationContent="+$('#operationContent').val()+
            "&startTime="+$('#startTime').val()+"&endTime="+$('#endTime').val();
        window.location.href = url;
    });

    // 监听导出所有操作
    $(".data-export-all-btn").on("click", function () {
        var url = "/xiaosai/exportLogExcel";
        window.location.href = url;
    });

    // 监听删除操作
    $(".data-delete-btn").on("click", function () {
        var checkStatus = table.checkStatus('currentTableId')
            , data = checkStatus.data;
        layer.alert(JSON.stringify(data));
    });

    //监听表格复选框选择
    /*table.on('checkbox(currentTableFilter)', function (obj) {
        console.log(obj)
    });*/

    //监听表格编辑和删除
    table.on('tool(currentTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            window.location = "/xiaosai/PermissionGroupEdit?id="+data.id;
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        }
    });

});