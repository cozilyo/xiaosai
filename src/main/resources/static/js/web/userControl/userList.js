/*
用户列表页面
*/
layui.use(['form','layer', 'table'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table,
        layer = layui.layer;

    table.render({
        elem: '#currentTableId',
        url: '/xiaosai/userListData',
        method:'post',
        contentType: 'application/json',
        cols: [[
            {type: "checkbox", width: 50, fixed: "left"},
            {field: 'id', width: 65, title: 'ID', sort: true},
            {field: 'name', width: 80, title: '姓名'},
            {field: 'userName', width: 100, title: '用户名'},
            {field: 'telephone', width: 120, title: '电话号码'},
            {field: 'mail', title: '邮箱', minWidth: 80},
            {field: 'idNum', minWidth: 80, title: '身份证号'},
            {field: 'gender', width: 50, title: '性别',templet:function (d) {
                    if(d.gender=2){
                        return "男";
                    }else if(d.gender=1){
                        return "女";
                    }else {
                        return "保密";
                    }
                }},
            {field: 'age', width: 50, title: '年龄',sort: true},
            {field: 'createTime', width: 120, title: '创建时间',sort: true},
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
            url:"/xiaosai/userListData",
            where: {
                name:result.name,
                userName:result.userName,
                telephone:result.telephone,
                mail:result.mail,
                address:result.address
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
    })



    // 监听添加操作
    $(".data-add-btn").on("click", function () {
        layer.msg('用户添加请前往注册');
    });

    // 监听删除操作
    $(".data-delete-btn").on("click", function () {
        var checkStatus = table.checkStatus('tableReload'), data = checkStatus.data;
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
                } else {
                    layer.msg('用户删除失败！')
                }
            }
        })

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