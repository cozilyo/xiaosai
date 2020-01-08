/**
 * 基本资料修改
 */
layui.use(['form'], function () {
    var form = layui.form
        , layer = layui.layer
        ,$ = layui.jquery;

    //初始化编辑页
    if($("#soleName").val()!=''){
        var params ={
            userName: $("#soleName").val()
        }
        $(function () {
            $.ajax({
                async: false,
                type: 'POST',
                url: '/xiaosai/userEditEcho',
                data: params,
                success: function (datata) {
                    var result = datata.data;
                    if (datata.code == 0) {
                        console.log(datata)
                        $("#userId").val(result.id);
                        $("#userName").val(result.userName);
                        $("#telephone").val(result.telephone);
                        $("#mail").val(result.mail);
                        $("#remark").val(result.remark);
                    }
                }
            })
        });
    }

    //监听提交
    form.on('submit(saveBtn)', function (data) {
        /*layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        })*/
        var result = data.field;
        var params ={
            id: $("#userId").val(),
            userName: result.userName,
            telephone: result.telephone,
            mail:result.mail,
            remark: result.remark
        }
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/userEditData',
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(params),
            success: function (val) {
                if (val.code == 0) {
                    Swal.fire(val.msg);
                } else {
                    Swal.fire(val.msg);
                }
            }
        })
        return false;
    });
});