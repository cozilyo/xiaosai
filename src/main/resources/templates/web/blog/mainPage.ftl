<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layuimini/lib/layui-v2.5.4/css/layui.css" media="all">
    <link rel="stylesheet" href="../layuimini/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="layui-elem-field layuimini-search">
            <legend>BOLG主页</legend>
            <div class="layui-inline">
                <video width="200px" height="150px"></video>
                <canvas width="200px" height="150px"></canvas>
                <p>
                    <button id="start" class="layui-btn">打开摄像头</button>
                    <button id="snap" class="layui-btn layui-btn-normal">截取图像</button>
                    <button id="close" class="layui-btn layui-btn-danger">关闭摄像头</button>
                </p>
            </div>
            <div style="margin: 10px 10px 10px 10px">

                    <p style="margin-top: 50px;margin-bottom: 20px;">登录页</p>
                    <img src="../readmeImg/login.png" width="40%">
                    <p style="margin-top: 50px;margin-bottom: 20px;">首页</p>
                    <img src="../readmeImg/index.png" width="40%">
                    <p style="margin-top: 50px;margin-bottom: 20px;">菜单页</p>
                    <img src="../readmeImg/menu.png" width="40%">
                    <p style="margin-top: 50px;margin-bottom: 20px;">菜单添加页</p>
                    <img src="../readmeImg/menuadd.png" width="40%">
            </div>
        </fieldset>

    </div>
</div>
<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;
    });
    window.onload = function () {
        var canvas = document.getElementsByTagName('canvas')[0],
            context = canvas.getContext('2d'),
            video = document.getElementsByTagName("video")[0],
            snap = document.getElementById("snap"),
            close = document.getElementById("close"),
            start = document.getElementById("start"),
            MediaStreamTrack;
        start.addEventListener('click', function () {
            if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
                navigator.mediaDevices.getUserMedia({
                    video: true,
                    audio: true
                }).then(function (stream) {
                    MediaStreamTrack=typeof stream.stop==='function'?stream:stream.getTracks()[1];
                    // video.src=(window.URL).createObjectURL(stream);
                    try{
                        video.srcObject = stream;
                    }catch (e) {
                        video.src=(window.URL).createObjectURL(stream);
                    }
                    video.play();
                }).catch(function(err){
                    console.log(err);
                });
            }else if(navigator.getMedia){
                navigator.getMedia({
                    video: true
                }).then(function (stream) {
                    MediaStreamTrack=stream.getTracks()[1];
                    // video.src=(window.webkitURL).createObjectURL(stream);
                    try{
                        video.srcObject = stream;
                    }catch (e) {
                        video.src=(window.URL).createObjectURL(stream);
                    }
                    video.play();
                }).catch(function(err){
                    console.log(err);
                });
            }
        });
        snap.addEventListener('click', function () {
            context.drawImage(video, 0, 0,200,150);
        });
        close.addEventListener('click', function () {
            MediaStreamTrack && MediaStreamTrack.stop();
        });
    }
</script>

</body>
</html>