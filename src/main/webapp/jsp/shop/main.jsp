<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>main</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/main.css'/>">
  </head>
  
  <body>
  <div align="center">
  	<iframe frameborder="0" src="<c:url value='/jsp/shop/body.jsp'/>" name="body"></iframe>
  </div>
<%-- <table class="table" align="center">
	<tr class="trTop">
		<td colspan="2" class="tdTop">
			<iframe frameborder="0" src="<c:url value='/jsp/shop/top.jsp'/>" name="top"></iframe>
		</td>
	</tr>
	<tr>
		<td class="tdLeft" rowspan="2">
			<iframe frameborder="0" src="<c:url value='/CategoryServlet?method=findAll'/>" name="left"></iframe>
			全部图书分类...
		</td>
		<td class="tdSearch" style="border-bottom-width: 0px;">
			<iframe frameborder="0" src="<c:url value='/jsp/shop/search.jsp'/>" name="search"></iframe>
		</td>
	</tr>
	<tr>
		<td style="border-top-width: 0px;">
			<iframe frameborder="0" src="<c:url value='/jsp/shop/body.jsp'/>" name="body"></iframe>
		</td>
	</tr>
</table> --%>
  </body>
</html>
