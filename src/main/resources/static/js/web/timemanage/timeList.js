/*
时间管理列表
*/
layui.use(['form','layer', 'table'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        layer = layui.layer;

    table.render({
        elem: '#currentTableId',
        url: '/xiaosai/timeListData',
        method:'post',
        contentType: 'application/json',
        cols: [[
            {type: "checkbox", width: 50, fixed: "left"},
            {type:"numbers",title:"序号"},
            // {field: 'id', width: 65, title: 'ID', sort: true},
            {field: 'name', width: 80, title: '姓名'},
            {field: 'nickname', width: 80, title: '昵称'},
            {field: 'address', width: 120, title: '地点'},
            {field: 'incident', title: '事件', minWidth: 80},
            {field: 'accomplishment',width:75, title: '完成量'},
            {field: 'stepDo', width: 50, title: '下一步'},
            {field: 'startTime', width: 120, title: '开始时间',sort: true},
            {field: 'endTime', width: 120, title: '结束时间',sort: true},
            {field: 'createTime', width: 120, title: '创建时间',sort: true},
            {field: 'modifyTime', width: 120, title: '修改时间',sort: true},
            {title: '操作', minWidth: 60, templet: '#currentTableBar', fixed: "right", align: "center"}
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
            url:"/xiaosai/timeListData",
            where: {
                name:result.name,
                nickname:result.nickname,
                address:result.address,
                incident:result.incident
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
            url:"/xiaosai/timeListData",
            where: {
                name:'',
                nickname:'',
                address:'',
                incident:''
            },
            page:{
                curr: 1
            }
        });
    })



    // 监听添加操作
    // $(".data-add-btn").on("click", function () {
    //     layer.msg('用户添加请前往注册');
    // });

    // 监听删除操作
    $(".data-delete-btn").on("click", function () {
        var checkStatus = table.checkStatus('tableReload'), data = checkStatus.data;
        if(data.length>0){
            var paramsList = new Array();
            for(var i=0;i<data.length;i++){
                paramsList.push(data[i].userId);
            }
            // console.log(JSON.stringify(paramsList))
            $.ajax({
                async: false,
                type: 'post',
                url: '/xiaosai/batchDelUser',
                dataType: "json",
                data: {
                    userIds: JSON.stringify(paramsList)
                },
                success: function (result) {
                    if (result.code == 0) {
                        layer.msg('用户删除成功')
                        //执行重载
                        table.reload('tableReload', {
                            url:"/xiaosai/userListData",
                            where: {
                                name:'',
                                userName:'',
                                telephone:'',
                                mail:'',
                                address:''
                            },
                            page:{
                                curr: 1
                            }
                        });
                    } else {
                        // layer.msg('用户删除失败！')
                        Swal.fire('用户删除失败！');
                    }
                }
            })
        }else {
            // layer.msg('请选择！')
            Swal.fire('请选择！');
        }

    });

    //监听表格复选框选择
    /*table.on('checkbox(currentTableFilter)', function (obj) {
        console.log(obj)
    });*/

    table.on('tool(currentTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            window.location = "/xiaosai/timeManageEdit?id="+data.id;
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        }
    });

});