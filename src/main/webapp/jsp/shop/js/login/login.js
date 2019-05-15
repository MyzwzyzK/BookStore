$(function(){
	
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'70px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
		
		});
	$('#switch_login').click(function(){
		
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'154px',width:'70px'});
		
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
		});
if(getParam("a")=='0')
{
	$('#switch_login').trigger('click');
}

	});
	
function logintab(){
	scrollTo(0);
	$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
	$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
	$('#switch_bottom').animate({left:'154px',width:'96px'});
	$('#qlogin').css('display','none');
	$('#web_qr_login').css('display','block');
	
}


//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}  


var reMethod = "GET",
	pwdmin = 6;

$(document).ready(function() {
	
	$('#loginInFront').click(function() {
		if ($('#loginnamelog').val() == "") {
			$('#loginnamelog').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCueLogin').html("<font color='red'><b><center>&nbsp;&nbsp;×请输入账号！</center></b></font>");
			return false;
		}

		if ($('#passwordlog').val() == "") {
			$('#passwordlog').focus();
			$('#userCueLogin').html("<font color='red'><b><center>&nbsp;&nbsp;×请输入密码！</center></b></font>");
			return false;
		}
		
		var params = {
				"loginname":$('#loginnamelog').val(),
				"password":$('#passwordlog').val()
		    };
		
		$.ajax({
		       type:"POST",
		       ansyc:false,
		       url:getRootPath()+"/user/login",
		       dataType:"json",
		       contentType : 'application/json;charset=UTF-8',
		       data: JSON.stringify(params),
			success:function(data) {
				if(data.flag){
					$('#userCueLogin').html("<font color='blue'><b><center>&nbsp;&nbsp;√登录成功，正在跳转...</center></b></font>");
					setTimeout(function(){
		    			   window.parent.location.href=getRootPath()+"/bookShop/toBookList";
		    			 }, 500); 
				}else{
					$('#userCueLogin').html("<font color='red'><b><center>&nbsp;&nbsp;×账号或密码错误！</center></b></font>");
				}
			}
		});
	});

	$('#reg').click(function() {
		
		if ($('#username').val() == "") {
			$('#username').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×用户名不能为空！</center></b></font>");
			return false;
		}

		if ($('#loginname').val() == "") {
			$('#loginname').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×账号不能为空！</center></b></font>");
			return false;
		}

		if ($('#passwd').val().length < pwdmin) {
			$('#passwd').focus();
			$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×密码不能小于" + pwdmin + "位！</center></b></font>");
			return false;
		}
		if ($('#passwd2').val() != $('#passwd').val()) {
			$('#passwd2').focus();
			$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×两次密码不一致！</center></b></font>");
			return false;
		}
		var params = {
				"username":$('#username').val(),
				"loginname":$('#loginname').val(),
				"password":$('#passwd').val()
		    };
		$.ajax({
		       type:"POST",
		       ansyc:false,
		       url:getRootPath()+"/user/register",
		       dataType:"json",
		       contentType : 'application/json;charset=UTF-8',
		       data: JSON.stringify(params),
			success:function(data) {
				if(data.flag){
					$('#userCue').html("<font color='blue'><b><center>&nbsp;&nbsp;√注册成功！！</center></b></font>");
				}else{
					$('#userCue').html("<font color='red'><b><center>&nbsp;&nbsp;×账号已存在！</center></b></font>");
				}
			}
		});
	});
	

});

function getRootPath() {  
    var pathName = window.location.pathname.substring(1);  
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));  
    return window.location.protocol + '//' + window.location.host + '/' + webName;  
}