/**
 * 菜单管理添加
 */
layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        ,$ = layui.jquery;


    //初始化
    $(function () {
        //初始化导航栏信息
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/navBarInfo',
            success: function (val) {
                if (val.code == 0) {
                    $.each(val.data,function (index,value) {
                        //初始化导航标识
                        $("#navigationBarName_so").append("<option value=\""+value.navigationBarName+"\">"+value.navigationBarName+"</option>");
                        //初始化导航排序
                        $("#navigationBarIndex_so").append("<option value=\""+value.navigationBarIndex+"\">"+value.navigationBarName+"("+value.navigationBarIndex+")</option>");
                        //初始化导航id
                        $("#navId_so").append("<option value=\""+value.id+"\">"+value.navigationBarName+"("+value.id+")</option>");
                        //有些时候，你的有些表单元素可能是动态插入的。这时 form 模块 的自动化渲染是会对其失效的。
                        // 虽然我们没有双向绑定机制（因为我们叫经典模块化框架，偷笑.gif） 但没有关系，
                        // 你只需要执行 form.render(type, filter); 方法即可。
                    })
                }else {
                    layer.msg("接口发生错误！");
                }
            }
        });
        //初始化父级id
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/menuInfo',
            success: function (val) {
                if (val.code == 0) {
                    $.each(val.data,function (index,value) {
                        $(".parentId_so").append("<option value=\""+value.id+"\">"+value.title+"("+value.id+")</option>");
                    })
                }else {
                    layer.msg("接口发生错误！");
                }
            }
        });

        //有些时候，你的有些表单元素可能是动态插入的。这时 form 模块 的自动化渲染是会对其失效的。
        // 虽然我们没有双向绑定机制（因为我们叫经典模块化框架，偷笑.gif） 但没有关系，
        // 你只需要执行 form.render(type, filter); 方法即可。
        form.render("select");
    });

    //监听提交
    form.on('submit(data-submit-btn)', function (data) {
        var result = data.field;
        var params ={
            navId:result.navId,
            parentId:result.parentId,
            isMenu:result.isMenu,
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
            url: '/xiaosai/addMenuData',
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


    //监听目标
    form.on('select(target_so)',function (data) {
        $('#target').val(data.value);
    })

    //监听导航标识
    form.on('select(navigationBarName_so)',function (data) {
        $('#navigationBarName').val(data.value);
    })

    //监听导航排序
    form.on('select(navigationBarIndex_so)',function (data) {
        $('#navigationBarIndex').val(data.value);
    })

    //监听导航id
    form.on('select(navId_so)',function (data) {
        $('#navId').val(data.value);
    })

    //监听父级id
    form.on('select(parentId_so)',function (data) {
        $('#parentId').val(data.value);
    })


    //监听取消按钮
    $(".cancel").on("click", function () {
        window.location = "/xiaosai/menuList";
    });

});