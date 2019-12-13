<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="../layui/css/layui.css">
<script type="text/javascript" src="../js/jQuery-v3.4.1.js"></script>
<body>
<ul class="layui-nav layui-nav-tree" lay-filter="test">
    <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
    <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;">默认展开</a>
        <dl class="layui-nav-child">
            <dd><a href="javascript:;">选项1</a></dd>
            <dd><a href="javascript:;">选项2</a></dd>
            <dd><a href="">跳转</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:;">解决方案</a>
        <dl class="layui-nav-child">
            <dd><a href="">移动模块</a></dd>
            <dd><a href="">后台模版</a></dd>
            <dd><a href="">电商平台</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="">产品</a></li>
    <li class="layui-nav-item"><a href="">大数据</a></li>
</ul>
</body>
<#--layui.alljs要在代码块之后-->
<script type="text/javascript" src="../layui/layui.all.js"></script>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use("element",function () {
        var element = layui.element;
    });
</script>
</html>