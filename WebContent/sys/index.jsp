<%-- <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />

<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />

<title>H-ui.admin v3.1</title>
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="">小说管理系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="">H-ui</a>
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.1</span>
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<nav class="nav navbar-nav">

		</nav>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>管理员</li>
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A">admin</a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
						<li><a href="../login.html">退出</a></li>
				</ul>
			</li>
				<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px"></i></a>
					<!--<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>-->
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont"><img src="images/3.png" width="30px" height="30px"></i> 小说管理<i class="Hui-iconfont menu_dropdown-arrow"><div class="sanjiao"></div></i></dt>
			<dd>
				<ul>
				<li><a data-href="fiction/WholeFictionServlet?flag=getAllFictionPage" data-title="全部小说" href="javascript:void(0)">全部小说</a></li>
				<li><a data-href="fiction/SelectFictionServlet?flag=getAllSelectPage" data-title="查看小说" href="javascript:void(0)">查看小说</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont"><img src="images/4.png" width="30px" height="25px"></i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow"><div class="sanjiao"></div></i></dt>
			<dd>
				<ul>
					<li><a data-href="yonghu/index.html" data-title="用户信息" href="javascript:void(0)">用户信息</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont"><img src="images/2.png" width="30px" height="30px"></i> 榜单管理<i class="Hui-iconfont menu_dropdown-arrow"><div class="sanjiao"></div></i></dt>
			<dd>
				<ul>
					<li><a data-href="bangdan/week.html" data-title="本周最热(Top10)" href="javascript:void(0)">本周最热(Top10)</a></li>
					<li><a data-href="bangdan/month.html" data-title="本月最热(Top50)" href="javascript:void(0)">本月最热(Top50)</a></li>
					<li><a data-href="bangdan/year.html" data-title="年度最佳(Top100)" href="javascript:void(0)">年度最佳(Top100)</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont"><img src="images/1.png" width="30px" height="30px"></i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow"><div class="sanjiao"></div></i></dt>
			<dd>
				<ul>
					<li><a data-href="user/index.html" data-title="管理员信息" href="javascript:void(0)">管理员信息</a></li>
			</ul>
		</dd>
	</dl>
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="我的桌面" data-href="welcome.html">我的桌面</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="fiction/WholeFictionServlet?flag=getAllFictionPage"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript" src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
$(function(){
	/*$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}		
			},
			'closeall': function(t) {
				alert('Trigger was '+t.id+'\nAction was Email');
			},
		}
	});*/
});
/*个人信息*/
function myselfinfo(){
	layer.open({
		type: 1,
		area: ['300px','200px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		content: '<div>管理员信息</div>'
	});
}

/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}


</script> 


</body>
</html>======= --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>小说后台管理系统</title>
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="">小说管理系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="">H-ui</a>
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.1</span>
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<nav class="nav navbar-nav">

		</nav>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>管理员</li>
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A">${name }</a>
					 <%-- <div class="dl-log">
    					当前登录的管理员有：
    					<span class="dl-log-user">
    					<c:forEach var="name" items="${list }">
    					【${name }】
    					</c:forEach>
    					</span>
   					</div> --%>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
						<li><a href="../LoginoutServlet">退出</a></li>
					</ul>
			    </li>
				<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px"></i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<!-- <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li> -->
						<!-- <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li> -->
						<!-- <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li> -->
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont"><img src="images/3.png" width="30px" height="30px"></i> 小说管理<i class="Hui-iconfont menu_dropdown-arrow"><div class="sanjiao"></div></i></dt>
			<dd>
				<ul>
				<li><a data-href="fiction/WholeFictionServlet?flag=getAllFictionPage" data-title="全部小说" href="javascript:void(0)">全部小说</a></li>
				<!-- <li><a data-href="fiction/SelectFictionServlet?flag=getAllSelectPage" data-title="查看小说" href="javascript:void(0)">查看小说</a></li> -->
			</ul>
		</dd>
	</dl>
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont"><img src="images/4.png" width="30px" height="25px"></i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow"><div class="sanjiao"></div></i></dt>
			<dd>
				<ul>
					<li><a data-href="user/UserServlet?&flag=getAlluser&page=1" data-title="用户信息" href="javascript:void(0)">用户信息</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont"><img src="images/2.png" width="30px" height="30px"></i> 榜单管理<i class="Hui-iconfont menu_dropdown-arrow"><div class="sanjiao"></div></i></dt>
			<dd>
				<ul>
					<li><a data-href="bangdan/RankingListServlet?flag=getAllweek&page=1" data-title="本周最热(Top50)" href="javascript:void(0)">本周最热(Top50)</a></li>
					<li><a data-href="bangdan/RankingListServlet?flag=getAllmonth&page=1" data-title="本月最热(Top50)" href="javascript:void(0)">本月最热(Top50)</a></li>
					<li><a data-href="bangdan/RankingListServlet?flag=getAllyeat&page=1" data-title="本年最热(Top50)" href="javascript:void(0)">年度最佳(Top50)</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont"><img src="images/1.png" width="30px" height="30px"></i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow"><div class="sanjiao"></div></i></dt>
			<dd>
				<ul>
					<li><a data-href="admin/AdminServlet?page=1&flag=getAlladmin" data-title="管理员信息" href="javascript:void(0)">管理员信息</a></li>
			</ul>
		</dd>
	</dl>
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="全部小说" data-href="welcome.html">全部小说</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="fiction/WholeFictionServlet?flag=getAllFictionPage"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
$(function(){
	/*$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}		
			},
			'closeall': function(t) {
				alert('Trigger was '+t.id+'\nAction was Email');
			},
		}
	});*/
});
/*个人信息*/
function myselfinfo(){
	layer.open({
		type: 1,
		area: ['300px','200px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		content: '<div><br><p style="text-indent:70px;">名称：${name}</p>  <p style="text-indent:70px;">电话：${phone}</p> <p style="text-indent:70px;">邮箱：${email}</p></div>',
				
	});
}

/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}


</script> 


</body>
</html>
