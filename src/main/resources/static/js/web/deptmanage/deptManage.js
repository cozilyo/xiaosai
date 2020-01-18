/**
 * 部门管理
 */
layui.use(['form','tree','table'], function () {
    var form = layui.form
        , layer = layui.layer
        ,tree = layui.tree
        ,table = layui.table
        , $ = layui.jquery;

    $(function () {
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/deptManageData',
            success: function (val) {
                if (val.code == 0) {
                    tree.render({
                        elem: '#dept-manage-tree'
                        ,data: val.data
                        ,isJump: true  //link 为参数匹配
                        ,showCheckbox: false
                        ,onlyIconControl: true
                        ,click: function(obj){
                            table.reload('tableReload', {
                                url: '/xiaosai/deptToUserData',
                                where: { //设定异步数据接口的额外参数，任意设
                                    deptId:obj.data.id
                                }
                                ,page: {
                                    curr: 1 //重新从第 1 页开始
                                }
                            }); //只重载数据
                        }
                    });
                }
            }
        });

        table.render({
            elem: '#currentTableId',
            url: '/xiaosai/deptToUserData',
            method:'post',
            contentType: 'application/json',
            cols: [[
                {type:"numbers",title:"序号"},
                {field: 'name', width: 80, title: '姓名'},
                {field: 'userName', width: 100, title: '用户名'},
                {field: 'telephone', width: 120, title: '电话号码'},
                {field: 'mail', title: '邮箱', minWidth: 80},
                {field: 'gender', width: 60, title: '性别',templet:function (d) {
                        if(d.gender==2){
                            return "男";
                        }else if(d.gender==1){
                            return "女";
                        }else {
                            return "保密";
                        }
                    }},
                {field: 'deptName', minWidth: 80, title: '部门名称'}
            ]],
            id: 'tableReload',
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            page: true

        });
    });

})
