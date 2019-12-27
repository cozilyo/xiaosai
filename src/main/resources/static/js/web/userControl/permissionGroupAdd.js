layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        ,$ = layui.jquery;

    //监听提交
    form.on('submit(data-submit-btn)', function (data) {
        var result = data.field;
        var params ={
            groupName: result.groupName,
            groupType: result.groupType,
            accessLevel: result.accessLevel
        }
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/addPermissionGroup',
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