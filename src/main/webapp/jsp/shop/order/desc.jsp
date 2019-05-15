<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单详细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/order/desc.css?version=20180334'/>">
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
			<a href="#" style="color:#6E6E6E;">订单详情</a>
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
	<div class="divOrder">
		<span>订单号：${order.orderid }
			(${order.status})
		　　　下单时间：<fmt:formatDate value='${order.ordertime }' type='date' pattern='yyyy年MM月dd HH:mm:ss'/></span>
	</div>
	<div class="divContent">
		<div class="div2">
			<dl>
				<dt>收货人信息</dt>
				<dd>${order.address }</dd>
			</dl>
		</div>
		<div class="div2">
			<dl>
				<dt>商品清单</dt>
				<dd>
					<table cellpadding="0" cellspacing="0">
						<tr>
							<th class="tt">商品名称</th>
							<th class="tt" align="left">单价</th>
							<th class="tt" align="left">数量</th>
							<th class="tt" align="left">小计</th>
						</tr>


<c:forEach items="${order.bookList }" var="book">
						<tr style="padding-top: 20px; padding-bottom: 20px;">
							<td class="td" width="400px">
								<div class="bookname">
								  <img align="middle" width="70" src="<c:url value='/book_img/${book.imageb }'/>"/>
								  <a href="<c:url value='/bookShop/getBookItems?lsbn=${book.lsbn }'/>">${book.name }</a>
								</div>
							</td>
							<td class="td" >
								<span>&yen;${book.currprice }</span>
							</td>
							<td class="td">
								<span>${book.num }</span>
							</td>
							<td class="td">
								<span>&yen;${book.num*book.currprice }</span>
							</td>			
						</tr>
</c:forEach>


					</table>
				</dd>
			</dl>
		</div>
		<div style="margin: 10px 10px 10px 550px;">
			<span style="font-weight: 900; font-size: 15px;">合计金额：</span>
			<span class="price_t">&yen;${order.total }</span><br/>
<c:if test="${order.status eq '未付款' }">
	<a href="<c:url value='#'/>" class="pay"></a><br/>
</c:if>
<%-- <c:if test="${order.status eq '未付款' and btn eq 'cancel'}"> --%>
<c:if test="${order.status eq '未付款'}">
    <a id="cancel" href="<c:url value='#'/>">取消订单</a><br/>
</c:if>
<%-- <c:if test="${order.status eq '已发货' and btn eq 'confirm'}"> --%>
<c:if test="${order.status eq '已发货'}">
	<a id="confirm" href="<c:url value='#'/>">确认收货</a><br/>
</c:if>	
		</div>
	</div>
	
	</div>

</body>
</html>

