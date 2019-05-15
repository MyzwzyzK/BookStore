<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
	<head>

		<base href="${basePath}">
		<meta charset="UTF-8">
		<title>H5模版:</title>
        <link href="jsp/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="jsp/js/jquery.js"></script>
<script type="text/javascript">
$(function(){   
    //顶部导航切换
    $(".nav li a").click(function(){
        $(".nav li a.selected").removeClass("selected")
        $(this).addClass("selected");
    })  
})  
</script>
	</head>
<body style="background:url(jsp/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="jsp/images/logo.png" title="系统首页" /></a>
    </div>
    <div class="topright">    
    <ul>
    <li><a href="user/backToFront" target="_parent">转到前台购书系统</a></li>
    <li><a href="user/manageSystemLoginOut" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>您好，${admin.username }</span>
    </div>    
    
    </div>

</body>
</html>