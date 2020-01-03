/**
 * 菜单管理列表
 */
layui.use(['table', 'treetable'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var treetable = layui.treetable;

    // 渲染表格
    layer.load(2);
    treetable.render({
        treeColIndex: 1,
        treeSpid: 0,
        treeIdName: 'id',
        treePidName: 'parentId',
        elem: '#munu-table',
        url: '/xiaosai/menuInfo',
        page: false,
        cols: [[
            {type: 'numbers'},
            {field: 'title', minWidth: 200, title: '菜单名称'},
            {field: 'href', title: '菜单地址'},
            {field: 'icon', title: '图标名称'},
            {field: 'target',width:75, title: '目标'},
            {field: 'navigationBarName', title: '导航标识'},
            {field: 'id',width:75, title: '菜单id'},
            {field: 'parentId',width:75, title: '父级id'},
            {field: 'navId',width:75, title: '导航id'},
            {field: 'navigationBarIndex',width:100,  title: '导航排序'},
            // {field: 'authorityId', width: 80, align: 'center', title: '排序号'},
            {
                field: 'isMenu', width: 80, align: 'center', templet: function (d) {
                    if (d.isMenu == 1) {
                        return '<span class="layui-badge layui-bg-gray">按钮</span>';
                    }
                    if (d.parentId ==0) {
                        return '<span class="layui-badge layui-bg-blue">目录</span>';
                    } else {
                        return '<span class="layui-badge-rim">菜单</span>';
                    }
                }, title: '类型'
            },
            {templet: '#auth-state', width: 120, align: 'center', title: '操作'}
        ]],
        done: function () {
            layer.closeAll('loading');
        }
    });

    $('#btn-expand').click(function () {
        treetable.expandAll('#munu-table');
    });

    $('#btn-fold').click(function () {
        treetable.foldAll('#munu-table');
    });

    //监听工具条
    table.on('tool(munu-table)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'del') {
            $.ajax({
                async: false,
                type: 'POST',
                url: '/xiaosai/delBarInfo',
                data:{
                    id: data.id
                },
                success: function (val) {
                    if (val.code == 0) {
                        window.location = "/xiaosai/menuList";
                    }else {
                        layer.msg(val.msg);
                    }
                }
            });
        } else if (layEvent === 'edit') {
            window.location = "/xiaosai/menuEdit?id="+data.id;
        }
    });
});