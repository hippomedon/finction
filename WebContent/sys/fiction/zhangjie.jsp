<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
#list {
    padding: 2px;
width: 100%;
}
#list dl {
    float: left;
    overflow: hidden;
    padding-bottom: 1px;
    margin: auto;
    padding: 0;
	width: 100%;
}
#list dd {
    border-bottom: 1px dashed #ccc;
    display: inline;
    float: left;
    height: 25px;
    line-height: 200%;
    margin-bottom: 5px;
    overflow: hidden;
    text-align: left;
    text-indent: 10px;
    vertical-align: middle;
    width: 25%;
	margin: auto;
    padding: 0;
	font-size: 12px;
}
a{
	color: #444;
	text-decoration: none;
	text-align: left;
    text-indent: 10px;
    line-height: 200%;
}
</style>
</head>
<body>
<div id="list">
<dl>
<c:forEach var="xiaoshuo" items="${listq }">
		<dd>
			<a href="select-zj.jsp">${xiaoshuo.text_Title }</a>
		</dd>
	</c:forEach>
</dl>
</div>
</body>
</html>