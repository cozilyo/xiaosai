/**
 * 图标设置
 */
layui.use(['form'], function () {
    var form = layui.form
        , layer = layui.layer
        ,$ = layui.jquery;

        $(function () {
            $.ajax({
                async: false,
                type: 'GET',
                url: '/xiaosai/logoIconEcho',
                success: function (datata) {
                    var pojo = datata.data.pojo;
                    var pojos = datata.data.pojos;
                    if (datata.code == 0) {
                        $("#userName").val(datata.data.userName);
                        $("#title").val(pojo.title);
                        $("#imageId").val(pojo.id);
                        $("#href").val(pojo.href);
                        $.each(pojos,function (key,value) {
                            $("#imageExanple").append("<img src='"+value.image+"' title='"+value.id+"'/>");
                            $("#image_so").append("<option value=\""+value.id+"\">"+value.id+"</option>");
                        })
                    }
                }
            })
            form.render("select");
        });

    form.on('select(image_so)',function (data) {
        $('#imageId').val(data.value);
    })

    //监听提交
    form.on('submit(saveBtn)', function (data) {
        var result = data.field;
        var params ={
            imageId:result.imageId,
            userName: result.userName,
            title: result.title,
            href:result.href
        }
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/editLogoIconData',
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