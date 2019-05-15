<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<title>后台管理系统</title>
        <link rel="stylesheet" href="jsp/css/reset.css" />
        <link rel="stylesheet" href="jsp/css/content.css?version=201804114" />
        <link href="jsp/css/style.css?version=201804112" rel="stylesheet" type="text/css" />
        <script src="jsp/js/jquery.js"></script>
	</head>
	<body marginwidth="0" marginheight="0">
	<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li><a href="#">首页</a></li>
			    <li><a href="#">修改个人资料</a></li>
		    </ul>
	    </div>
	<div class="container">
		<div class="public-content">
			<div class="public-content-cont">
			<form action="user/modifyPersonalInformationSubmit" id="modForm" method="post">
				<input type="hidden" name="userid" id="userid" value="${admin.userid }" />
				<div class="form-group">
					<label   for="username">用户名:</label>
					<input class="form-input-txt" type="text" name="username" id="username" 
										value="${admin.username }" />
				</div>
                 <div class="form-group">
                    <label   for="loginname">账号:</label>
                    <input class="form-input-txt" type="text" name="loginname" id="loginname" 
                    					disabled="disabled" value="${admin.loginname }" />
                </div>
                 <div class="form-group">
                    <label   for="">地址:</label>
                    <input class="form-input-txt" type="text" name="address" id="address" 
                    					value="${admin.address }" />
                </div>
                 <div class="form-group">
                    <label   for="address">邮编:</label>
                    <input class="form-input-txt" type="text" name="addresscode" id="addresscode" 
                    					value="${admin.addresscode }" />
                </div>
                <div class="form-group">
                    <label   for="email">邮箱:</label>
                    <input class="form-input-txt" type="text" name="email" id="email" 
                    					value="${admin.email }" />
                </div>
                <div class="form-group">
                    <label   for="phone">手机号码:</label>
                    <input class="form-input-txt" type="text" name="phone" id="phone" 
                    					value="${admin.phone }" />
                </div>
                <div class="form-group">
                    <label   for="identity">权限:</label>
                    <input class="form-input-txt" type="text" name="identity" id="identity"
                    			disabled="disabled"
                    			<c:choose> 
                    			<c:when test="${admin.identity eq 'admin'}">
                    			value="管理员"
                    			</c:when>
                    			<c:otherwise >
                    			value="普通用户"
                    			</c:otherwise>
                    			</c:choose>
                    					 />
                </div>
                <div id="userCue" style="color: red;float:left"></div>
                <div class="form-group">
                    <input class="form-btn" style="margin-left:150px;margin-top:30px;" type="button" name="modify" id="modify" value="保存" />
                </div>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript">
$(function(){
	
	$("#modify").on("click",function(){
	    if($("#username").val()==""||$("#username").val()==null){
	    	//layer.tips('账号不能为空', '#account');
	    	$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×用户名不能为空！</center></b></font>");
	    	return false;
	    }
		if($("#address").val()==""||$("#address").val()==null){
			//layer.tips('密码不能为空', '#password');
			$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×地址不能为空！</center></b></font>");
	    	return false;
	    }
		if($("#addresscode").val()==""||$("#addresscode").val()==null){
			//layer.tips('新密码不能为空', '#new_password');
			$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×邮编不能为空！</center></b></font>");
			return false;
		}
		if($("#email").val()==""||$("#email").val()==null){
			//layer.tips('确认密码不能为空', '#confirm_pas');
			$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×邮箱不能为空！</center></b></font>");
		return false;
		}
		if($("#phone").val()==""||$("#phone").val()==null){
			//layer.tips('确认密码不能为空', '#confirm_pas');
			$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×手机号码不能为空！</center></b></font>");
		return false;
		}
		var params = {
				"userid":$("#userid").val(),
				"loginname":$("#loginname").val(),
				"username":$("#username").val(),
	 	    	   "address":$("#address").val(),
	 	    	  "addresscode":$("#addresscode").val(),
	 	    	 "email":$("#email").val(),
	 	    	  "phone":$("#phone").val()
		    };
		$.ajax({
	 	       type:"POST",
	 	       ansyc:false,
	 	       url: "user/modifyPersonalInformationSubmit",
	 	       data: JSON.stringify(params),
	 	       dataType:"json",
	 	       contentType:"application/json;charset=utf-8",
	 	       success:function(data){
	 	    	 if(data.flag){
	 	    		 //layer.msg('修改成功！', {icon: 1});
	 	    		 alert('修改成功！');
		    		   /* setTimeout(function(){
		    			   window.parent.location.href="jsp/index.jsp";
		    			 }, 2000); */
	 	    	 }else{
	 	    		//layer.msg('用户名密码不对！', {icon: 1});
	 	    		alert('出错啦，修改失败！');
	 	    	 }
	 	       }
	 	}); 
});
	
});
</script>
</body>
</html>