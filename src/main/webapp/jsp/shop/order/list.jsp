<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/order/list.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/top.css?version=20180329'/>">
<style type="text/css">
body{
	margin:0px;
}	
</style>
  </head>
  
  <body>
  <div class="listmain">
	<div class="listTop" style="font-size: 10pt;">
		<div class="current">&nbsp;当前位置：
			<a href="${pageContext.request.contextPath}/bookShop/toBookList" style="color:#6E6E6E;">书店</a> &gt;      
			<a href="#" style="color:#6E6E6E;">我的订单</a>
			<!-- <a href="#" style="float:right;margin-right:10px">退出</a> -->
			<div style="float:right;margin-right:5px">
			<%-- 根据用户是否登录，显示不同的链接 --%>
			<c:choose>
				<c:when test="${empty sessionScope.user }">
					  <%-- <a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">会员登录</a> |&nbsp; 
					  <a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注册会员</a>	 --%>
					  <a href="${pageContext.request.contextPath}/jsp/shop/body.jsp" >登录</a> |&nbsp; 
					  <a href="#" >注册</a>	
				</c:when>
				<c:otherwise>
					      您好：${sessionScope.user.username }&nbsp;&nbsp;|&nbsp;&nbsp;
					  <a href="${pageContext.request.contextPath}/cartitem/getCartitem" >
					  			我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
					  <a href="<c:url value='/order/toOrderList'/>" >我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
					  <a href="${pageContext.request.contextPath}/user/loginout" >退出</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:otherwise>
			</c:choose>
		</div>
		</div>
		
		
		
		<h1 style="text-align: center;">二手旧书网</h1>
	</div>
	<center>
<div class="divMain">
	
	<div class="divTitle">
		<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
		<span style="margin-left: 40px;margin-right: 38px;">金额</span>
		<span style="margin-left: 50px;margin-right: 40px;">订单状态</span>
		<span style="margin-left: 50px;margin-right: 50px;">操作</span>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">

<c:forEach items="${orderList }" var="order">

		<tr class="tt">
			<td width="320px">订单号：<a  href="<c:url value='/order/getOrderItems?orderid=${order.orderid }'/>">${order.orderid }</a></td>
			<td width="200px">下单时间：<fmt:formatDate value='${order.ordertime }' type='date' pattern='yyyy年MM月dd HH:mm:ss'/></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">


  <c:forEach items="${order.bookList }" var="book">
	<a class="link2" href="<c:url value='/bookShop/getBookItems?lsbn=${book.lsbn }'/>">
	    <img border="0" width="70" src="${pageContext.request.contextPath}/book_img/${book.imageb }"/>
	</a>
  </c:forEach>
	
			</td>
			<td width="115px">
				<span class="price_t">&yen;${order.total }</span>
			</td>
			<td width="142px">
				(${order.status })
			</td>
			<td>
			<a href="<c:url value='/order/getOrderItems?orderid=${order.orderid }'/>">查看</a><br/>
<c:if test="${order.status eq '未付款' }">
				<a href="<c:url value='#'/>">支付</a><br/>
				<a href="<c:url value='#'/>">取消</a><br/>						
</c:if>
<c:if test="${order.status eq '已发货' }">
				<a href="<c:url value='#'/>">确认收货</a><br/>
</c:if>
			</td>
		</tr>
</c:forEach>



	</table>
	<br/>
	<%-- <%@include file="/jsps/pager/pager.jsp" %> --%>
</div>
</center>
</div>
  </body>
</html>
