/**
 *登录页
 */
layui.use(['form'], function () {
    var form = layui.form,
        layer = layui.layer;

    // 登录过期的时候，跳出ifram框架
    if (top.location != self.location) top.location = self.location;

    // 粒子线条背景
    $(document).ready(function(){
        $('.layui-container').particleground({
            dotColor:'#5cbdaa',
            lineColor:'#5cbdaa'
        });
    });

    $(".xs_register").on("click",function () {
        window.location = "/xiaosai/regis";
    });

    //获取验证码
    $(".captcha_Pic").on("click", function() {
        $(".captcha_Pic").attr("src", '/xiaosai/getVerify?' + Math.random());//jquery方式
    });

    $("#captcha_id").on("input propertychange",function () {
        var value = $("#captcha_id").val();
        $.ajax({
            async: false,
            type: 'get',
            url: '/xiaosai/checkVerify',
            dataType: "json",
            data: {
                verifyInput: value
            },
            success: function (result) {
                if (result.return_code == 1) {
                    $("#verify_msg").html("<p style='color: #008000;'>验证成功</p>");
                    $("#submit_id").removeAttr("disabled");
                } else {
                    $("#verify_msg").html("<p style='color: red;'>验证失败或者失效！</p>");
                }
            }
        })
    });

    form.on('submit(loginBtn)',function (data) {
        var result = data.field;
        var params ={
            userName: result.userName,
            password: result.password,
            captcha: result.captcha
        }
        $.ajax({
            async: false,
            type: 'POST',
            url: '/xiaosai/checkUser',
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(params),
            success: function (val) {
                if (val.code == 0) {
                    console.log(val)
                    window.location = "/xiaosai/index?userName="+result.userName;
                } else {
                    Swal.fire(val.msg);
                }
            }
        })
    });

    //enter键触发提交
    $(document).on('keydown', function (event) {
        if (event.keyCode == 13) {
            $("#submit_id").trigger("click");
            return false
        }
    });

    //打开二维码
    $("#login_sys").on("click",function () {
        layer.open({
            type:2,
            title:"打开app，扫一扫",
            area:['315px','370px'],
            scrollbar:false,
            shadeClose:true,
            content:"/xiaosai/qrCode"
        })
    })
});