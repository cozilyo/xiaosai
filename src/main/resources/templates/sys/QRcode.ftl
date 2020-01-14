<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div class="qrCodeImg-box" id="qrImgDiv"></div>

</body>
<script src="../layuimini/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script>

    $(document).ready(function(){
        initQrImg();
    });

    var path = "://"+window.location.host;
    var getQrPath = "http" + path + "/xiaosai/getLoginQr";
    var wsPath = "ws" + path + "/websocket/";

    function initQrImg(){
        $("#qrImgDiv").empty();

        var xmlhttp;
        xmlhttp=new XMLHttpRequest();
        xmlhttp.open("GET",getQrPath,true);
        xmlhttp.responseType = "blob";
        xmlhttp.onload = function(){
            //console.log(this);
            uuid = this.getResponseHeader("uuid");

            if (this.status == 200) {
                var blob = this.response;
                var img = document.createElement("img");
                img.className = 'qrCodeBox-img';
                img.onload = function(e) {
                    window.URL.revokeObjectURL(img.src);
                };
                img.src = window.URL.createObjectURL(blob);
                document.getElementById("qrImgDiv").appendChild(img);

                initWebSocket();
            }
        }
        xmlhttp.send();
    }



    function initWebSocket() {

        if (typeof (WebSocket) == "undefined") {
            //console.log("您的浏览器不支持WebSocket");
        } else {
            //console.log("您的浏览器支持WebSocket");
            //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
            //等同于socket = new WebSocket("ws://localhost:8083/checkcentersys/websocket/20");
            var wsPathStr = wsPath + uuid;
            socket = new WebSocket(wsPathStr);
            //打开事件
            socket.onopen = function () {
                //console.log("Socket 已打开");
                //socket.send("这是来自客户端的消息" + location.href + new Date());
            };
            //获得消息事件
            socket.onmessage = function (msg) {
                //console.log(msg.data);
                var data = JSON.parse(msg.data);
                if (data.code == 200) {
                    alert("登录成功！");
                    //这里存放自己业务需要的数据。怎么放自己看
                    window.sessionStorage.uuid = uuid;
                    window.sessionStorage.userId = data.userId;
                    window.sessionStorage.projId = data.projId;

                    window.location.href = "/xiaosai/qrCode";
                } else {
                    //如果过期了，关闭连接、重置连接、刷新二维码
                    socket.close();
                    initQrImg();
                }
                //发现消息进入    开始处理前端触发逻辑
            };
            //关闭事件
            socket.onclose = function () {
                //console.log("Socket已关闭");
            };
            //发生了错误事件
            socket.onerror = function () {
                alert("Socket发生了错误");
                //此时可以尝试刷新页面
            }
        }
    }
</script>
</html>