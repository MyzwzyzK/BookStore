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
     <form action="news/addNews" enctype="multipart/form-data" id="addForm"method="post">
    <ul class="forminfo">
        <li><label>标题</label><input name="newsTitle" id="newsTitle" type="text" class="dfinput"/></li>
        <li><label>图片</label><input name="myFile" id="myFile" type="file" class="dfinput"/></li>
        <li><label>内容</label><textarea name="newsContent" id="newsContent" cols="" rows="" class="textinput"></textarea></li>
        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="保存" id="save"/></li>
    </ul>
    </form>
</div>
	</body>
    <script type="text/javascript">
    $(function(){
        $("#save").on("click",function(){
          	 var value = document.getElementById("myFile").value;
       	 if(value==undefined||value==null||value==""){
       		 layer.msg('未选择要上传的文件！');
       		 return false;
       	 }
       	 else{
       	layer.msg('拼命上传中,请稍后....', {
       		  icon: 16
       		  ,shade: 0.45
       		});
       	setTimeout(function(){
       	     var formData = new FormData($("#addForm")[0]);
       	     $.ajax({
       	         url: 'news/addNews',
       	         type: 'POST',
       	         data: formData,
       	         async:false,
       	         cache: false,
       	         contentType: false,
       	         enctype: 'multipart/form-data',
       	         processData: false,
       	         success: function (data) {
       	         document.getElementById("myFile").value=null; 
       	        	   layer.msg('数据上传成功！');
       	        	   parent.layer.closeAll();
       	         }
       	     });
       	  layer.closeAll('loading');
       	}, 2000);
       	 }

       });
    	
    	
    	
    });
    
    
    
    </script>
</html>