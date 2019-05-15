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
	<title>欢迎登录后台管理系统</title>
<link href="jsp/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="jsp/js/jquery.js"></script>
<script src="jsp/js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
		$('#loginInBack').click(function() {
			if ($('#loginname').val() == "") {
				$('#loginname').focus().css({
					border: "1px solid red",
					boxShadow: "0 0 2px red"
				});
				$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×请输入账号！</center></b></font>");
				return false;
			}

			if ($('#password').val() == "") {
				$('#password').focus();
				$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×请输入密码！</center></b></font>");
				return false;
			}
			
			var params = {
					"loginname":$('#loginname').val(),
					"password":$('#password').val()
			    };
			
			$.ajax({
			       type:"POST",
			       ansyc:false,
			       url:"${pageContext.request.contextPath}/user/manageSystemLogin",
			       dataType:"json",
			       contentType : 'application/json;charset=UTF-8',
			       data: JSON.stringify(params),
				success:function(data) {
					if(data.flag){
						$('#userCue').html("<font color='blue'><b><center>&nbsp;&nbsp;√登录成功，正在跳转...</center></b></font>");
						setTimeout(function(){
			    			   window.parent.location.href="${pageContext.request.contextPath}/jsp/main.jsp";
			    			 }, 500); 
					}else{
						$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×账号或密码错误！</center></b></font>");
					}
				}
			});
		});
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
	</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div class="logintop">    
    <span>欢迎登录后台管理系统</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
       
    <div class="loginbox" style="margin-top:100px;">
    
    <ul>
    <form action="${pageContext.request.contextPath}/user/manageSystemLogin" method="POST">
    <li><input id="loginname" name="loginname" type="text" class="loginuser" value="admin"/></li>
    <li><input id="password" name="password" type="password" class="loginpwd" value="123456" /></li>
    <li><div id="userCue" style="color: red;"></div></li> 
    <li><input  id="loginInBack" name="loginInBack" type="button" class="loginbtn" value="登录" style="margin-left:100px;"/></li>
    </form>
    </ul>
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  @CopyRight书店商城 </div>
	
    
</body>

</html>