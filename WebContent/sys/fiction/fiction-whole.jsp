<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />

<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="../layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="../css/text.css" />
<link rel="stylesheet" type="text/css" href="../css/fenye.css" />


<title>全部小说</title>

</head>
<body>
<nav class="breadcrumb">
	<i class="Hui-iconfont"></i> 首页 
	<span class="c-gray en">&gt;</span> 小说管理
 	<span class="c-gray en">&gt;</span>全部小说
  	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
  		<i class="Hui-iconfont">刷新</i>
  	</a>
</nav>



<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
			<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
				<i class="Hui-iconfont">×</i> 批量删除
			</a>
			<a href="javascript:;" onclick="admin_add('添加小说','fiction-add.jsp','800','500')" class="btn btn-primary radius">
				<i class="Hui-iconfont">＋</i> 添加小说
			</a>
		</span>
		<form action="WholeFictionServlet?flag=getFictionByName&like=like" method="post" style="display: inline-block">
			<input type="text" name="name" placeholder="请输入想查询书名" class="logon-min" style="margin-left:10px;padding:6px 10px;"/>
			<button type="submit" class="btn btn-primary radius" >查询</button>
		</form>
		<span class="r">共有数据：<strong>${count }</strong> 条</span>
	 </div>
		<c:choose>
			<c:when test="${count==0 }">
				<table class="table table-border table-bordered table-bg">
					<thead>
						<tr>
							<th scope="col" colspan="9">全部小说</th>
						</tr>
						<tr class="text-c">
							<th width="25"><input type="checkbox" name="" value=""></th>
							<th width="40">ID</th>
							<th width="150">书名</th>
							<th width="90">作者</th>
							<th width="130">字数</th>
							<th width="130">状态</th>
							<th width="100">时间</th>
							<th width="100">操作</th>
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
							<th scope="col" colspan="9">全部小说</th>
						</tr>
						<tr class="text-c">
							<th width="25"><input type="checkbox" name="" value=""></th>
							<th width="40">ID</th>
							<th width="150">书名</th>
							<th width="90">作者</th>
							<th width="130">字数</th>
							<th width="130">状态</th>
							<th width="100">时间</th>
							<th width="100">操作</th>
						</tr>
						
					</thead>
					<tbody>
						<c:forEach var="whole" items="${list }">
						<tr class="text-c">
							<td>
							  <input type="checkbox" name="check" class="checkOne" value="${whole.fiction_Id}">
			    			</td>
							<td>${whole.fiction_Id }</td>
							<td>
							<a href="javascript:;" onclick="admin_add('小说详情','SelectFictionServlet?flag=getSelectByName&name=${whole.fiction_Name}','800','500')">
								${whole.fiction_Name }
							</a>
							</td>
							<td>${whole.fiction_Writer }</td>
							<td>${whole.fiction_Now }</td>
							<td>${whole.fiction_Status }</td>
							<td>${whole.fiction_Time }</td>
							<td>
								
								<a href="javascript:;" onclick="admin_add('编辑小说','WholeFictionServlet?flag=getFictionById&id=${whole.fiction_Id}','800','500')" > 编辑</a>&nbsp;
							
								<a class="" data-type="auto" data-method="offset" href="WholeFictionServlet?flag=deleteFictionById&id=${whole.fiction_Id}&page=${page}">删除</a>
							
								
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="float: right" class="layui-laypage">  <!--这是分页布局   在上面引入css<link rel="stylesheet" type="text/css" href="../css/fenye.css" />
-->
				 <c:choose>
						<c:when test="${like eq 'like'}">
				        	<a href='WholeFictionServlet?flag=getFictionByName&page=${page-1}&name=${fiction_name}&like=like' class = "fan">上一页</a> 
				        		<c:forEach var="i" begin="1" end="${pageNum }">
				        			<c:choose>
				        				<c:when test="${page==i }">
				        					<span class='curr span'>${i }</span>
				        				</c:when>
				        				<c:otherwise>
				        					<a href='WholeFictionServlet?flag=getFictionByName&page=${i }&name=${fiction_name}&like=like' class="curr">${i }</a> 
				        				</c:otherwise>
				        			</c:choose>
				        		</c:forEach>
				        	<a href='WholeFictionServlet?flag=getFictionByName&page=${page+1 }&name=${fiction_name}&like=like' class = "fan">下一页</a>  
						</c:when>
						<c:otherwise>
							<a href='WholeFictionServlet?flag=getAllFictionPage&page=${page-1}' class = "fan">上一页</a>
						        <c:forEach var="i" begin="1" end="${pageNum }">
						        	<c:choose>
						        		<c:when test="${page==i }">
						        			<span class='curr span'>${i }</span>
						        		</c:when>
						        		<c:otherwise>
						        			<a href='WholeFictionServlet?flag=getAllFictionPage&page=${i }' class="curr">${i }</a>
						        		</c:otherwise>
						        	</c:choose>
						        </c:forEach>
					       	<a href='WholeFictionServlet?flag=getAllFictionPage&page=${page+1 }' class = "fan">下一页</a>
						</c:otherwise>
					</c:choose> 
				</div> 
			</c:otherwise>
		</c:choose>
</div>

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

/*管理员-编辑*/
function admin_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
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
	window.location.href="WholeFictionServlet?flag=deleteAllFiction&idAll="+idAll;
}
  
/* //关闭弹出层 
var index = parent.layer.getFrameIndex(window.name); 
parent.layer.close(index); */

</script>
</body>
</html>