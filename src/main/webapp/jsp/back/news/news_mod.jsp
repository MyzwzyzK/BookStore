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
                   <link rel="stylesheet" href="layui/css/layui.css"  media="all">
          <link href="jsp/css/style.css" rel="stylesheet" type="text/css"/>
	       <script language="JavaScript" src="jsp/js/jquery.js"></script>
           <script src="layer/layer.js"></script>
           <script src="layui/layui.js" charset="utf-8"></script>
   
    </head>
	<body>
		
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>测试表单数据</li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>添加信息</span></div>
     <form action="news/ModifyPage" " id="modForm"method="post">
    <ul class="forminfo">
        <li><label>编号</label><input name="id" readonly="true" id="id" type="text" class="dfinput"value="${ news.id}"/></li>
        <li><label>上传时间</label><input name="postTime" id="postTime" type="text" class="dfinput" value="${ news.postTime}"/></li>
        <li><label>标题</label><input name="newsTitle" id="newsTitle" type="text" class="dfinput" value="${ news.newsTitle}"/></li>
        <li><label>介绍</label><textarea name="newsContent" id="newsContent" cols="10" rows="30" class="textinput" >${news.newsContent}</textarea></li>
        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="保存" id="save"/></li>
        <input type="hidden" id="newsImg" name="newsImg"value="${ news.newsImg}"/>
    </ul>
    </form>
</div>
	</body>
    <script type="text/javascript">
    $(function(){
        $("#save").on("click",function(){
       	layer.msg('拼命上传中,请稍后....', {
       		  icon: 16
       		  ,shade: 0.45
       		});
       	setTimeout(function(){
       		$("#modForm").submit();
       	  layer.closeAll('loading');
       	}, 2000);
       	 

       });
    	
    	
    	
    });
    
    
    
    </script>
</html>