<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>xiaosai-菜单管理添加</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layuimini/lib/layui-v2.5.4/css/layui.css" media="all">
    <link rel="stylesheet" href="../layuimini/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>菜单管理添加</legend>
        </fieldset>

        <form class="layui-form" lay-filter="pg">
            <div class="layui-form-item">
                <label class="layui-form-label">菜单名称</label>
                <div class="layui-input-block">
                    <input type="text" name="title" lay-verify="required" placeholder="请输入" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单地址</label>
                <div class="layui-input-block">
                    <input type="text" name="href" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">图标名称</label>
                <div class="layui-input-block">
                    <input type="text" name="icon" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">目标</label>
                <div class="layui-input-inline">
                    <input type="text" id="target" name="target" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <select id="target_so" name="target_so" lay-filter="target_so">
                        <option value="">请选择</option>
                        <option value="_self">_self</option>
                        <option value="_blank">_blank</option>
                        <option value="_parent">_parent</option>
                        <option value="_top">_top</option>
                        <option value="framename">framename</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">导航标识</label>
                <div class="layui-input-inline">
                    <input type="text" id="navigationBarName" name="navigationBarName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <select id="navigationBarName_so" name="navigationBarName_so" lay-filter="navigationBarName_so">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">导航排序</label>
                <div class="layui-input-inline">
                    <input type="text" id="navigationBarIndex" name="navigationBarIndex" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <select id="navigationBarIndex_so" name="navigationBarIndex_so" lay-filter="navigationBarIndex_so">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">导航id</label>
                <div class="layui-input-inline">
                    <input type="text" id="navId" name="navId" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <select id="navId_so" name="navId_so" lay-filter="navId_so">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">父级id</label>
                <div class="layui-input-inline">
                    <input type="text" id="parentId" name="parentId" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <select id="parentId_so" class="parentId_so" name="parentId_so" lay-filter="parentId_so">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否按钮</label>
                <div class="layui-input-block">
<#--                    <input type="text" name="isMenu" lay-verify="required" placeholder="1-是，其他不是" autocomplete="off" class="layui-input">-->
                    <input type="radio" name="isMenu" value="1" title="是" checked="">
                    <input type="radio" name="isMenu" value="2" title="否">
                    <input type="radio" name="isMenu" value="3" title="其他">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="data-submit-btn">立即保存</button>
<#--                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>-->
                    <button type="button" class="layui-btn layui-btn-danger cancel">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>

<#--<input type="hidden" value="${id}" class="menuEditId">-->
<#--<input type="hidden" class="navId">-->

<script src="../layuimini/lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="../js/sys/menuAdd.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

</body>
</html>