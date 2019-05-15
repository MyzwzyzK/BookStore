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
        <li>修改图书类型</li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>修改信息</span></div>
     <form action="${pageContext.request.contextPath}/type/modifyTypeSubmit" id="modForm"method="post">
     	<input name="id" id="id" type="hidden" value="${type.id }" />
    <ul class="forminfo">
      <li><label>书籍类型:</label><input name="name" id="name" type="text" value="${type.name }" class="dfinput"/></li>
      <li><label>类型介绍:</label><input name="description" id="description" type="text" value="${type.description }" class="dfinput"/></li>
      <li><label>&nbsp;</label><input name="save" id="save" type="submit" class="btn" value="保存" id="save"/></li>
    </ul>
    </form>
</div>
	</body>
</html>