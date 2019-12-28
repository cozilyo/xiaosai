/**
 * 权限组编辑
 */
layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        ,$ = layui.jquery;


    if($(".menuEditId").val()>0){
        var params ={
            id: $(".menuEditId").val()
        }
        $(function () {
            $.ajax({
                async: false,
                type: 'POST',
                url: '/xiaosai/menuEditDataEcho',
                data: params,
                success: function (val) {
                    if (val.code == 0) {
                        form.val("pg", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                            "title": val.data.title // "name": "value"
                            ,"href": val.data.href
                            ,"icon": val.data.icon
                            ,"target": val.data.target
                            ,"navigationBarName": val.data.navigationBarName
                            ,"navigationBarIndex": val.data.navigationBarIndex
                        });
                        $(".navId").val(val.data.navId);
                    }
                }
            })
        });
    }



    //监听提交
    form.on('submit(data-submit-btn)', function (data) {
        var result = data.field;
        var id = $(".menuEditId").val();
        var navId = $(".navId").val();
        var params ={
            id: id,
            navId:navId,
            title: result.title,
            href: result.href,
            icon: result.icon,
            target: result.target,
            navigationBarName: result.navigationBarName,
            navigationBarIndex: result.navigationBarIndex
        }
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/editMenuData',
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(params),
            success: function (val) {
                if (val.code == 0) {
                    layer.msg(val.msg);
                    //执行重载
                    window.location = "/xiaosai/menuList";
                } else {
                    layer.msg(val.msg);
                }
            }
        })
        return false;
    });
    //监听取消按钮
    $(".cancel").on("click", function () {
        window.location = "/xiaosai/menuList";
    });
});