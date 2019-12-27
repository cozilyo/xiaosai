/**
 * 权限组编辑
 */
layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        ,$ = layui.jquery;


    if($(".permissionGroupId").val()>0){
        var params ={
            id: $(".permissionGroupId").val()
        }
        $(function () {
            $.ajax({
                async: false,
                type: 'POST',
                url: '/xiaosai/editPermissionGroupEcho',
                data: params,
                success: function (val) {
                    if (val.code == 0) {
                        form.val("pg", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                            "groupName": val.data.groupName // "name": "value"
                            ,"groupType": val.data.groupType
                            ,"accessLevel": val.data.accessLevel
                        });
                    }
                }
            })
        });
    }



    //监听提交
    form.on('submit(data-submit-btn)', function (data) {
        var result = data.field;
        var id = $(".permissionGroupId").val();
        var params ={
            id: id,
            groupName: result.groupName,
            groupType: result.groupType,
            accessLevel: result.accessLevel
        }
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/editPermissionGroup',
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(params),
            success: function (val) {
                if (val.code == 0) {
                    layer.msg(val.msg);
                    //执行重载
                    window.location = "/xiaosai/PermissionGroupList";
                } else {
                    layer.msg(val.msg);
                }
            }
        })
        return false;
    });
    //监听取消按钮
    $(".cancel").on("click", function () {
        window.location = "/xiaosai/PermissionGroupList";
    });
});