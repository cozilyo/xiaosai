layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        ,$ = layui.jquery;

    if($("#timeManageId").val()>0){
        var params ={
            id: $("#timeManageId").val()
        }
        $(function () {
            $.ajax({
                async: false,
                type: 'POST',
                url: '/xiaosai/editTimeManageEcho',
                data: params,
                success: function (val) {
                    if (val.code == 0) {
                        form.val("pg", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                            "name": val.data.name // "name": "value"
                            ,"nickname": val.data.nickname
                            ,"address":val.data.address
                            ,"incident": val.data.incident
                            ,"accomplishment":val.data.accomplishment
                            ,"stepDo":val.data.stepDo
                            ,"startTime":val.data.startTime
                            ,"endTime":val.data.endTime
                        });
                    }
                }
            })
        });
    }

    laydate.render({
        elem:'#startTime',
        type: 'datetime'
    })

    laydate.render({
        elem:'#endTime',
        type: 'datetime'
    })

    laydate.render({
        elem:'#createTime',
        type: 'datetime'
    })

    laydate.render({
        elem:'#modifyTime',
        type: 'datetime'
    })

    //监听提交
    form.on('submit(data-submit-btn)', function (data) {
        var result = data.field;
        var params ={
            id: $("#timeManageId").val(),
            name: result.name,
            nickname: result.nickname,
            address:result.address,
            incident: result.incident,
            accomplishment: result.accomplishment,
            stepDo: result.stepDo,
            startTime:result.startTime,
            endTime:result.endTime
        }
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/editTimeManage',
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(params),
            success: function (val) {
                if (val.code == 0) {
                    //layer.msg(val.msg);
                    //执行重载
                    window.location = "/xiaosai/timeList";
                } else {
                    layer.msg(val.msg);
                }
            }
        })
        return false;
    });
    //监听取消按钮
    $(".cancel").on("click", function () {
        window.location = "/xiaosai/timeList";
    });
});