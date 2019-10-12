<%@page import="java.util.List"%>
<%@page import="com.fiction.entity.ViewChapters"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="../css/text.css" />
	<link rel="stylesheet" type="text/css" href="../css/fenye.css" />
	<link rel="stylesheet" type="text/css" href="../css/fiction-select.css" />
    
    <title>查看小说</title>
</head>
<body>
<%-- <nav class="breadcrumb"><i class="Hui-iconfont"></i> 首页 <span class="c-gray en">&gt;</span> 小说管理 <span class="c-gray en">&gt;</span> 查看小说 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">刷新</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
                <i class="Hui-iconfont">×</i> 批量删除
                
            </a>
            <a href="javascript:;" onclick="admin_add('添加小说','select-add.jsp','800','550')" class="btn btn-primary radius">
                <i class="Hui-iconfont">＋</i> 添加小说
            </a>
        </span>
        <form action="SelectFictionServlet?flag=getSelectByName&like=like" method="post" style="display: inline-block">
            <input type="text" name="name" placeholder="请输入想查询书名" class="logon-min" style="margin-left:10px;padding:6px 10px;"/>
            <button type="submit" class="btn btn-primary radius" >查询</button>
        </form>
        <span class="r">共有数据：<strong>${count }</strong> 条</span> </div> --%>
        <%-- <c:choose>
        	<c:when test="${count==0 }">
        		<table class="table table-border table-bordered table-bg">
			        <thead>
			        <tr>
			            <th scope="col" colspan="9">查看小说</th>
			        </tr>
			        <tr class="text-c">
			            <th width="80"><input type="checkbox" name="" value=""></th>
			            <th width="80">ID</th>
			            <th width="150">小说详情</th>
			            <th width="100">操作</th>
			        </tr>
			        </thead>
			        <thead>
						<tr>
							<th scope="col" colspan="9" style="text-align: center;">没有数据</th>
						</tr>
					</thead>
        		</table>
        	</c:when> --%>
        	<%-- <c:otherwise>
        		<table class="table table-border table-bordered table-bg">
			        <thead>
			        <tr>
			            <th scope="col" colspan="9">查看小说</th>
			        </tr>
			        <tr class="text-c">
			            <th width="80"><input type="checkbox" name="" value=""></th>
			            <th width="80">ID</th>
			            <th width="150">小说详情</th>
			            <th width="100">操作</th>
			        </tr>
			        </thead>
			        <tbody> --%>
<c:choose>
	<c:when test="${count==0 }">
		<div style="margin:0 auto;padding: 150px 0;height:100%;width:100%;">
			<h1 style="text-align: center;">小说还未录入哦！</h1>
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach var="selectqq" items="${list }">
			<c:choose>
				<c:when test="${selectqq_name eq selectqq.selectqq_Name}">
					<%-- <tr class="text-c"  id="top">
					   <td>
							<input type="checkbox" name="check" class="checkOne" value="${selectqq.selectqq_Id}">
					    </td>
			           <td>${selectqq.selectqq_Id }</td>
					    <td> --%>
					   <div class="box">
					        <div class="img">
					             <img src="../images/${selectqq.selectqq_Image }" >
					         </div>
					         <div class="text">
						          <div class="title">
							          <h4 style="font-weight: 600;font-size: 15px;color: #555;">${selectqq.selectqq_Name }</h4>
							          <p>作&nbsp;&nbsp;者:${selectqq.selectqq_Writer }</p>
							          <p>最后更新:${selectqq.selectqq_Time }</p>
							          <p>最新更新:<a href="">${selectqq.selectqq_Zuixin }</a> </p>
						           </div>
						           <div class="introduce ">
							          ${selectqq.selectqq_Jianjie }
						           </div>
					          </div>
					  	</div>
					  	<br>
						<div class="layui-collapse" lay-accordion="" >
							<div class="layui-colla-item">
								<h2 class="layui-colla-title" style="background-color:#FFF;">章节</h2>
									<div class="layui-colla-content layui-show ">
										 <div class="layui-collapse" lay-accordion="">
										     <iframe name="myiframe" id="myrame" src="ViewChaptersServlet?flag=${selectqq.selectqq_Name }" frameborder="0" align="left" scrolling="off" width="100%" height="500px">
										      </iframe>
										  </div>
									</div>
							</div>
						</div>
					            	<%-- </td>
						            <td>
							            <a href="javascript:;" onclick="admin_add('编辑小说','SelectFictionServlet?flag=getSelectById&id=${selectqq.selectqq_Id}','800','500')" > 编辑</a>&nbsp;
							            <a href="SelectFictionServlet?flag=deleteSelectById&id=${selectqq.selectqq_Id }">删除</a>
						            </td>
						            
			        			</tr> --%>
				</c:when>
				<c:otherwise>
								<%-- <tr class="text-c" >
					            	<td>
									  <input type="checkbox" name="check" class="checkOne" value="${selectqq.selectqq_Id}">
					    			</td>
			            			<td>${selectqq.selectqq_Id }</td> --%>
					            	<!-- <td> -->
					<div class="box">
					   <div class="img">
					       <img src="../images/${selectqq.selectqq_Image }" >
					   </div>
					    <div class="text">
					       <div class="title">
					            <h4 style="font-weight: 600;font-size: 15px;color: #555;">${selectqq.selectqq_Name }</h4>
					                  <p>作&nbsp;&nbsp;者:${selectqq.selectqq_Writer }</p>
					                  <p>最后更新:${selectqq.selectqq_Time }</p>
					                  <p>最新更新:<a href="">${selectqq.selectqq_Zuixin }</a> </p>
					       </div>
					       <div class="introduce ">
						        ${selectqq.selectqq_Jianjie }
					       </div>
					    </div>
					    </div>
							<div class="layui-collapse" lay-accordion="" >
								<div class="layui-colla-item">
									<!-- <a class="layui-colla-title " data-href="ViewChaptersServlet" href="javascript:void(0)">章节111</a> -->
									<h2 class="layui-colla-title "  style="background-color:#FFF; ">章节</h2>
										<div class="layui-colla-content ">
										     <iframe name="myiframe" id="myrame" src="ViewChaptersServlet?flag=${selectqq.selectqq_Name }" frameborder="0" align="left" scrolling="off" width="100%" height="100%">
										     </iframe>
										</div>
								</div>
							</div>
					            	<!-- </td> -->
						         <%--    <td>
							            <a href="javascript:;" onclick="admin_add('编辑小说','SelectFictionServlet?flag=getSelectById&id=${selectqq.selectqq_Id}','800','500')" > 编辑</a>&nbsp;
							            <a href="SelectFictionServlet?flag=deleteSelectById&id=${selectqq.selectqq_Id }">删除</a>
						            </td>
			        			</tr> --%>
					</c:otherwise>
				</c:choose>
			  </c:forEach>
			</c:otherwise>
		</c:choose>
			       
		<!-- 	        </tbody>
    		</table> -->
			<%-- <div style="float: right" class="layui-laypage">  <!--这是分页布局   在上面引入css<link rel="stylesheet" type="text/css" href="../css/fenye.css" />
		-->
			<c:choose>
				 <c:when test="${like eq 'like'}">
		        	<a href='SelectFictionServlet?flag=getSelectByName&page=${page-1}&name=${selectqq_name}&like=like' class = "fan">上一页</a> 
		        		<c:forEach var="i" begin="1" end="${pageNum }">
		        			<c:choose>
		        				<c:when test="${page==i }">
		        					<span class='curr span'>${i }</span>
		        				</c:when>
		        				<c:otherwise>
		        					<a href='SelectFictionServlet?flag=getSelectByName&page=${i }&name=${selectqq_name}&like=like' class="curr">${i }</a> 
		        				</c:otherwise>
		        			</c:choose>
		        		</c:forEach>
		        	<a href='SelectFictionServlet?flag=getSelectByName&page=${page+1 }&name=${selectqq_name}&like=like' class = "fan">下一页</a>  
				</c:when> 
				 <c:otherwise> 
					<a href='SelectFictionServlet?flag=getAllSelectPage&page=${page-1}' class = "fan">上一页</a>
				        <c:forEach var="i" begin="1" end="${pageNum }">
				        	<c:choose>
				        		<c:when test="${page==i }">
				        			<span class='curr span'>${i }</span>
				        		</c:when>
				        		<c:otherwise>
				        			<a href='SelectFictionServlet?flag=getAllSelectPage&page=${i }' class="curr">${i }</a>
				        		</c:otherwise>
				        	</c:choose>
				        </c:forEach>
			       	<a href='SelectFictionServlet?flag=getAllSelectPage&page=${page+1 }' class = "fan">下一页</a>
				 </c:otherwise>
			</c:choose>
			</div>  --%>
       <%--  </c:otherwise> --%>
       <%-- </c:choose> --%>
<!-- </div> -->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="../layui/layui.js"></script>
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
  //批量删除
    function datadel(){
    	var check = document.getElementsByName("check");
    	var len=check.length;
    	var idAll="";
    	for(var i=0;i<len;i++){
    		if(check[i].checked){
    				idAll+=check[i].value+",";
    		}
    	}
    	window.location.href="SelectFictionServlet?flag=deleteAllSelect&idAll="+idAll;
    }
  /* //关闭弹出层 
    var index = parent.layer.getFrameIndex(window.name); 
    parent.layer.close(index); */
    //章节折叠面板
     layui.use(['element', 'layer'], function(){
      var element = layui.element;
      var layer = layui.layer;
      
      //监听折叠
      element.on('collapse(test)', function(data){
        layer.msg('展开状态：'+ data.show);
      });
    });
    
    
    //顶置表格中特定行	
     window.onload=function(){
    	document.getElementById("top").scrollIntoView();
    }
   
</script>
</body>
</html>