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
    <title>本年最热(Top50)</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont"></i> 首页 <span class="c-gray en">&gt;</span> 榜单管理 <span class="c-gray en">&gt;</span> 本周最热(Top50)<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">刷新</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <!-- <span class="l">
            <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
                <i class="Hui-iconfont">×</i> 批量删除
            </a>
            <a href="javascript:;" onclick="admin_add('添加小说','w-add.html','800','500')" class="btn btn-primary radius">
                <i class="Hui-iconfont">＋</i> 添加小说
            </a>
        </span>
        <form action="" method="" style="display: inline-block">
            <input type="text" name="name" placeholder="请输入书名" class="logon-min" style="margin-left:10px;padding:6px 10px;"/>
            <button type="submit" class="btn btn-primary radius" >查询</button>
        </form> -->
        <span class="r">共有数据：<strong>${count }</strong> 条</span> </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="9">本周最热(Top10)</th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox" name="" value=""></th>
            <th width="40">排名</th>
            <th width="150">书名</th>
            <th width="90">作者</th>
            <th width="150">热度</th>
            <th width="130">状态</th>
            <th width="100">时间</th>
            
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ranking" items="${list}" varStatus="cou">
        <tr class="text-c">
            <td><input type="checkbox" value="1" name=""></td>
            <c:choose>
            	<c:when test="${cou.count==10 }">
            		<td>${page*10}</td>
            	</c:when>
            	<c:otherwise>
            	 	<td>${page-1}${cou.count }</td>
            	</c:otherwise>
            </c:choose>
            <td>
				<a href="javascript:;" onclick="admin_add('小说详情','../fiction/SelectFictionServlet?flag=getSelectByName&name=${ranking.bookname }','800','500')">
					${ranking.bookname }
				</a>
			</td>
            <td>${ranking.name }</td>
            <td>${ranking.heat }</td>
            <td>${ranking.state }</td>
            <td>${ranking.time }</td>
            <!-- <td><a href="javascript:;" onclick="admin_add('编辑小说','w-edit.html','800','500')" > 编辑</a>&nbsp;<a href="">删除</a></td> -->
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="float: right" class="layui-laypage">  <!--这是分页布局   在上面引入css<link rel="stylesheet" type="text/css" href="../css/fenye.css" />
-->
	<%-- <c:choose>
	<c:when test="${like eq 'like'}">
		${count}条记录${page }/${pageNum}页 
        <a href='UserServlet?flag=getUserByName&page=${page-1}&username=${username}&like=like'>上一页</a> 
        <c:forEach var="i" begin="1" end="${pageNum }">
        	<c:choose>
        		<c:when test="${page==i }">
        			<span class='current'>${i }</span>
        		</c:when>
        		<c:otherwise>
        			<a href='UserServlet?flag=getUserByName&page=${i }&username=${username}&like=like'>${i }</a> 
        		</c:otherwise>
        	</c:choose>
        </c:forEach>
        <a href='UserServlet?flag=getUserByName&page=${page+1 }&username=${username}&like=like'>下一页</a>  
        <a href='UserServlet?flag=getUserByName&page=${pageNum}&username=${username}&like=like'>最后一页</a> 
	</c:when>
	<c:otherwise> --%>
	<a href='RankingListServlet?flag=getAllyeat&page=${page-1 }' class = "fan">上一页</a>
		        <c:forEach var="i" begin="1" end="${pageNum }">
		        	<c:choose>
		        		<c:when test="${page==i }">
		        			<span class='curr span'>${i }</span>
		        		</c:when>
		        		<c:otherwise>
		        			<a href='RankingListServlet?flag=getAllyeat&page=${i }' class="curr">${i }</a>
		        		</c:otherwise>
		        	</c:choose>
		        </c:forEach>
	       
	       <a href='RankingListServlet?flag=getAllyeat&page=${page+1 }' class = "fan">下一页</a>
      
	<%-- </c:otherwise>
	</c:choose> --%>
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
</script>
</body>
</html>