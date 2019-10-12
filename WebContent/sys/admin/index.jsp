<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../lib/html5shiv.js"></script>
    <script type="text/javascript" src="../lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="../css/text.css" />
    <link rel="stylesheet" type="text/css" href="../css/fenye.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="../lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>管理员信息</title>
    <style>
	*{margin: 0;padding: 0;}
	#main{position: absolute;width: 200px;left: 50%;margin-left: -100px;top:200px;text-align: center;}
	#main li{list-style-type: none;margin-top: 5px;}
	#main li a{color: #fff;}
</style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont"></i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 管理员信息<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">刷新</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
    	<span class="l">
        	<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
				<i class="Hui-iconfont">×</i> 批量删除
			</a>
            <a href="javascript:;" onclick="admin_add('添加管理员','admin-add.jsp','800','500')" class="btn btn-primary radius">
                <i class="Hui-iconfont">＋</i> 添加管理员</a></span>
        <span class="r">共有数据：<strong>${count }</strong> 条</span>
        <form action="AdminServlet?page=1&flag=getlikeadmin&like=like" method="post" style="display: inline-block">
            <input type="text" name="name" placeholder="请输入名称" class="logon-min" style="margin-left:10px;padding:6px 10px;"/>
            <button type="submit" class="btn btn-primary radius" >查询</button>
        </form>
    </div>
    <c:choose>
    	<c:when test="${count==0 }">
    		<table class="table table-border table-bordered table-bg">
					<thead>
			        	<tr>
			            	<th scope="col" colspan="9">管理员信息</th>
			        	</tr>
			        	<tr class="text-c">
			            	<th width="25"><input type="checkbox" name="" value=""></th>
			            	<th width="40">ID</th>
			            	<th width="150">名称</th>
			            	<th width="90">电话</th>
			            	<th width="150">邮箱</th>
			            	<th width="130">性别</th>
			            	<th width="130">出生年月</th>
			            	<!-- <th width="100">操作</th> -->
			        	</tr>
        			</thead>
					<thead>
						<tr>
							<th scope="col" colspan="9" style="text-align: center;">没有数据</th>
						</tr>
					</thead>
					
				</table>
    	</c:when>
    	<c:otherwise>
    				<table class="table table-border table-bordered table-bg">
        	<thead>
        	<tr>
            	<th scope="col" colspan="9">管理员信息</th>
        	</tr>
        	<tr class="text-c">
            	<th width="25"><input type="checkbox" name="" value=""></th>
            	<th width="40">ID</th>
            	<th width="150">名称</th>
            	<th width="90">电话</th>
            	<th width="150">邮箱</th>
            	<th width="130">性别</th>
            	<th width="130">出生年月</th>
            	<th width="100">操作</th>
        	</tr>
        	</thead>
        	<tbody>
        	<c:forEach var="admin" items="${list}">
        		<tr class="text-c">
            		<td><input type="checkbox" value="${admin.adminid }" name="check"></td>
            		<td>${admin.adminid }</td>
            		<td>${admin.adminname }</td>
            		<td>${admin.adminphone }</td>
            		<td>${admin.adminemail }</td>
            		<td>${admin.admingender }</td>
            		<td>${admin.admintime }</td>
            		<td>
            			<a href="javascript:;" onclick="admin_add('添加管理员','AdminServlet?flag=getalladminById&id=${admin.adminid }&name=${admin.adminname }&email=${admin.adminemail }&gender=${admin.admingender }&phone=${admin.adminphone }&time=${admin.admintime }','800','500')">编辑</a></span>
        				<a href="AdminServlet?flag=deleteadmin&id=${admin.adminid } " class="dblChoseAlert">删除</a>
        			</td>
        	</tr>
        	</c:forEach>
        	</tbody>
    	</table>
   	<div style="float: right" class="layui-laypage">  <!--这是分页布局   在上面引入css<link rel="stylesheet" type="text/css" href="../css/fenye.css" />
-->
	<c:choose>
	<c:when test="${like=='like'}">
		${count}条记录${page }/${pageNum}页 
        <a href='AdminServlet?flag=getlikeadmin&page=${page-1 }&like=like&name=${name}' class = "fan">上一页</a>
		        <c:forEach var="i" begin="1" end="${pageNum }">
		        	<c:choose>
		        		<c:when test="${page==i }">
		        			<span class='curr span'>${i }</span>
		        		</c:when>
		        		<c:otherwise>
		        			<a href='AdminServlet?flag=getlikeadmin&page=${i }&like=like&name=${name}' class="curr">${i }</a>
		        		</c:otherwise>
		        	</c:choose>
		        </c:forEach>
	       
	       <a href='AdminServlet?flag=getlikeadmin&page=${page+1 }&like=like&name=${name}' class = "fan">下一页</a>
      
	</c:when>
	<c:otherwise>
	<a href='AdminServlet?flag=getAlladmin&page=${page-1 }' class = "fan">上一页</a>
		        <c:forEach var="i" begin="1" end="${pageNum }">
		        	<c:choose>
		        		<c:when test="${page==i }">
		        			<span class='curr span'>${i }</span>
		        		</c:when>
		        		<c:otherwise>
		        			<a href='AdminServlet?flag=getAlladmin&page=${i }' class="curr">${i }</a>
		        		</c:otherwise>
		        	</c:choose>
		        </c:forEach>
	       
	       <a href='AdminServlet?flag=getAlladmin&page=${page+1 }' class = "fan">下一页</a>
      
	</c:otherwise>
	</c:choose> 
	</div>
    	</c:otherwise>
    </c:choose>
		<!-- &nbsp;&nbsp;<button type="submit" class="btn btn-primary radius" >批量删除</button> -->
    	
	<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#ffffff">
</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../js/fenye.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/simpleAlert.js"></script>
<script type="text/javascript">
    /*
        参数解释：
        title	标题
        url		请求的url
        id		需要操作的数据id
        w		弹出层宽度（缺省调默认值）
        h		弹出层高度（缺省调默认值）
    */
    /*管理员-增加*/
    
    function admin_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*管理员-删除*/
    function admin_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                }
            });
        });
    }

    /*管理员-编辑*/
    function admin_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*管理员-停用*/
    function admin_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            //此处请求后台程序，下方是成功后的前台处理……

            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
            $(obj).remove();
            layer.msg('已停用!',{icon: 5,time:1000});
        });
    }

    /*管理员-启用*/
    function admin_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            //此处请求后台程序，下方是成功后的前台处理……


            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!', {icon: 6,time:1000});
        });
    }
    
    function datadel(){
    	var check = document.getElementsByName("check");
    	var len=check.length;
    	var idAll="";
    	for(var i=0;i<len;i++){
    		if(check[i].checked){
    				idAll+=check[i].value+",";
    		}
    	}
    	window.location.href="AdminServlet?flag=detalladmins&idAll="+idAll;
    }
</script>
</body>
</html>