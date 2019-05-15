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
			    <li><a href="#">修改密码</a></li>
		    </ul>
	    </div>
	<div class="container">
		<div class="public-content">
			<div class="public-content-cont">
			<form action="user/modifyPasswordSubmit" id="modForm" method="post">
			
				<div class="form-group">
					<label for="">&nbsp;&nbsp;&nbsp;&nbsp;账号:</label>
					<input class="form-input-txt" type="text" name="account" id="account" disabled="disabled" value="${admin.loginname }" />
				</div>
                 <div class="form-group">
                    <label for="">&nbsp;&nbsp;旧密码:</label>
                    <input class="form-input-txt" type="password" name="password" id="password" value="" />
                </div>
                 <div class="form-group">
                    <label for="">&nbsp;&nbsp;新密码:</label>
                    <input class="form-input-txt" type="password" name="new_password" id="new_password" value="" />
                </div>
                 <div class="form-group">
                    <label for="">确认密码:</label>
                    <input class="form-input-txt" type="password" name="confirm_pas" id="confirm_pas" value="" />
                </div>
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
	    if($("#account").val()==""||$("#account").val()==null){
	    	debugger;
	    	//layer.tips('账号不能为空', '#account');
	    	alert('账号不能为空');
	    	return false;
	    }
		if($("#password").val()==""||$("#password").val()==null){
			//layer.tips('密码不能为空', '#password');
			alert('密码不能为空');
	    	return false;
	    }
		if($("#new_password").val()==""||$("#new_password").val()==null){
			//layer.tips('新密码不能为空', '#new_password');
			alert('新密码不能为空');
			return false;
		}
		if($("#confirm_pas").val()==""||$("#confirm_pas").val()==null){
			//layer.tips('确认密码不能为空', '#confirm_pas');
			alert('确认密码不能为空');
		return false;
		}
		if($("#new_password").val()!=$("#confirm_pas").val()){
			$("#new_password").val("");
			$("#confirm_pas").val("");
			//layer.msg('密码不一致，请重新输入');
			alert('新密码不一致，请重新输入');
		    return false;
		}
		if($("#new_password").val().length<6||$("#new_password").val().length>20){
			
			//layer.msg('密码长度必须在6-8,请重新输入');
			alert('密码长度必须在6-20,请重新输入')
			$("#new_password").val("");
			$("#confirm_pas").val("");
		    return false;
			
		}
		$.ajax({
	 	       type:"POST",
	 	       ansyc:false,
	 	       url: "user/modifyPasswordSubmit",
	 	       data:{loginname:$("#account").val(),
	 	    	   password:$("#password").val(),
	 	    	  newPassword:$("#new_password").val()
	 	       },
	 	       dataType:"json",
	 	       contentType:"application/x-www-form-urlencoded;charset=utf-8",
	 	       success:function(data){
	 	    	 if(data.flag){
	 	    		 //layer.msg('修改成功！', {icon: 1});
	 	    		 alert('修改密码成功！');
		    		   /* setTimeout(function(){
		    			   window.parent.location.href="jsp/index.jsp";
		    			 }, 2000); */
	 	    	 }else{
	 	    		//layer.msg('用户名密码不对！', {icon: 1});
	 	    		alert('用户名密码不正确！');
	 	    	 }
	 	       }
	 	}); 
});
	
});
</script>
</body>
</html>