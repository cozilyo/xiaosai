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
        // alert(value);
        $.ajax({
            async: false,
            type: 'get',
            url: '/xiaosai/checkVerify',
            dataType: "json",
            data: {
                verifyInput: value
            },
            success: function (result) {
                console.log(result);
                if (result.return_code == 1) {
                    $("#verify_msg").html("<p style='color: #008000;'>验证成功</p>");
                    $("#submit_id").removeAttr("disabled");
                } else {
                    $("#verify_msg").html("<p style='color: red;'>验证失败或者失效！</p>");
                }
            }
        })
    });
});