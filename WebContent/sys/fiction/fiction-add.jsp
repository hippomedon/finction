<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">

</head>
<body>
    <form class="layui-form layui-form-pane" action="WholeFictionServlet?flag=addFiction" method="post" style="padding:10% 30% 0 30%;  height:378px; width: 320px;">

        <div class="layui-form-item">
            <label class="layui-form-label">书名</label>
            <div class="layui-input-inline">
                <input name="name" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">作者</label>
            <div class="layui-input-inline">
                <input name="writer" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required">
            </div>
        </div>
        <div class="layui-form-item">
		      <label class="layui-form-label">字数</label>
		      <div class="layui-input-inline">
		        <input name="now" class="layui-input" type="tel" placeholder="请输入" autocomplete="off" lay-verify="now">
		      </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input name="status" title="完结" type="radio" checked="" value="完结">
                <input name="status" title="连载" type="radio" value="连载">
            </div>
        </div>

        <div class="layui-form">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">上传时间</label>
                    <div class="layui-input-inline">
                        <input name="time" class="layui-input" id="test19" type="text" placeholder="yyyy-MM-dd" >
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn" lay-filter="demo2" lay-submit="" type="submit" id="submit">提交</button>
        </div>

    </form>
    <script type="text/javascript" src="../layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../lib/jquery/1.9.1/jquery.js"></script>
    <script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
    <script>
        //初始赋值
        layui.use('laydate', function() {
            var laydate = layui.laydate;
            laydate.render({
                elem: '#test19'
                /*, value: '1989-10-14'*/
                , isInitValue: true
            });
        });
        layui.use(['form', 'layedit', 'laydate'], function(){
            var form = layui.form
                    ,layer = layui.layer
                    ,layedit = layui.layedit
                    ,laydate = layui.laydate;

            //日期
            laydate.render({
                elem: '#date'
            });
            laydate.render({
                elem: '#date1'
            });

            //创建一个编辑器
            var editIndex = layedit.build('LAY_demo_editor');

            //自定义验证规则
            form.verify({
                title: function(value){
                    if(value.length < 5){
                        return '标题至少得5个字符啊';
                    }
                }
                ,pass: [
                    /^[\S]{6,12}$/
                    ,'密码必须6到12位，且不能出现空格'
                ]
                ,content: function(value){
                    layedit.sync(editIndex);
                }
            });

            //监听指定开关
            form.on('switch(switchTest)', function(data){
                layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                    offset: '6px'
                });
                layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
            });

            //监听提交
            form.on('submit(demo1)', function(data){
                layer.alert(JSON.stringify(data.field), {
                    title: '最终的提交信息'
                });
                return false;
            });

            //表单初始赋值
            form.val('example', {
                "username": "贤心" // "name": "value"
                ,"password": "123456"
                ,"interest": 1
                ,"like[write]": true //复选框选中状态
                ,"close": true //开关状态
                ,"sex": "女"
                ,"desc": "我爱 layui"
            })
	    //数字验证
	    form.verify({
	      now: function(value, item){ //value：表单的值、item：表单的DOM对象
	        if(/[^\d]/g.test(value)){
	          return '请输入数字';
	        }
	      }
	    });     
   });
        /*$(function(){
            $('#submit').on('click',function(){
                   //关闭弹出层 
                  parent.layer.close(index);
                  //刷新父页面 
                  window.parent.location.reload();
                 }); 
            });*/
        
    </script>
</body>
</html>