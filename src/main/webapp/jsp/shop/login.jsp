<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/shop/js/login/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/shop/js/login/login.js?version=2018041313"></script>
<link href="${pageContext.request.contextPath}/jsp/shop/css/login/login.css?version=2018041116" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>二手书店</h1>

	<div class="login" style="margin-top: 50px;">

		<div class="header">
			<div class="switch" id="switch">
				<a class="switch_btn_focus" id="switch_qlogin"
					href="javascript:void(0);" tabindex="7">快速登录</a> <a
					class="switch_btn" id="switch_login" href="javascript:void(0);"
					tabindex="8">快速注册</a>
				<div class="switch_bottom" id="switch_bottom"
					style="position: absolute; width: 64px; left: 0px;"></div>
			</div>
		</div>


		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">
			<!--登录-->
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
						<form action="${pageContext.request.contextPath}/user/login" name="loginform"
							accept-charset="utf-8" id="login_form" class="loginForm"
							method="post">
							<input type="hidden" name="did" value="0" /> <input
								type="hidden" name="to" value="log" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="loginnamelog">帐号：</label>
								<div class="inputOuter" id="uArea">

									<input type="text" id="loginnamelog" name="loginnamelog" class="inputstyle" value="ZhangSan"/>
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="passwordlog">密码：</label>
								<div class="inputOuter" id="pArea">

									<input type="password" id="passwordlog" name="passwordlog" class="inputstyle" value="123456"/>
								</div>
							</div>
							 <div id="userCueLogin" style="color: red;"></div> 
							<div style="padding-left: 50px; margin-top: 20px;">
								<input type="button" id="loginInFront" value="登 录" style="width: 150px;"
									class="button_blue" />
							</div>
						</form>
					</div>
				</div>
			</div>
			<!--登录end-->
		</div>

		<!--注册-->
		<div class="qlogin" id="qlogin" style="display: none;">
			<div class="web_login">
				<form name="form2" id="regUser" accept-charset="utf-8" action=""
					method="post">
					<input type="hidden" name="to" value="reg" /> <input type="hidden"
						name="did" value="0" />
					<ul class="reg_form" id="reg-ul">
						<!-- <div id="userCue" class="cue" style="color: red;">暂不支持注册!</div> -->
						
						<li><label for="username" class="input-tips2">用户名：</label>
							<div class="inputOuter2">

								<input type="text" id="username" name="username" maxlength="10"
									class="inputstyle2" value="鹏"/>
							</div></li>
							
						<li><label for="loginname" class="input-tips2">账号：</label>
							<div class="inputOuter2">
								<input type="text" id="loginname" name="loginname" maxlength="16"
									class="inputstyle2" value="admin"/>
							</div></li>
							
						<li><label for="passwd" class="input-tips2">密码：</label>
							<div class="inputOuter2">
								<input type="password" id="passwd" name="passwd" maxlength="16"
									class="inputstyle2" value="123456"/>
							</div></li>
						<li><label for="passwd2" class="input-tips2">确认密码：</label>
							<div class="inputOuter2">
								<input type="password" id="passwd2" name="passwd2" maxlength="16"
									class="inputstyle2" value="123456"/>
							</div></li>
							
						<li>
							<div id="userCue" style="color: red;"></div>
							<div class="inputArea">
								<input type="button" id="reg"
									style="margin-top: 10px; margin-left: 85px;"
									class="button_blue" value="同意协议并注册" /> <a href="#"
									class="zcxy" >注册协议</a>
							</div>
						</li>
						<div class="cl"></div>
					</ul>
				</form>
			</div>
		</div>
		<!--注册end-->
	</div>
</body>
</html>