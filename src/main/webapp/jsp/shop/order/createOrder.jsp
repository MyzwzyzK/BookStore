<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jp.po.CartDetails,java.util.ArrayList,java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>createOrder.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/order/createOrder.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/top.css?version=20180329'/>">
	<script src="<c:url value='/jsp/shop/jquery/jquery-1.5.1.js'/>"></script>
	<script src="<c:url value='/jsp/shop/js/round.js'/>"></script>
	<script type="text/javascript" src="/jsp/js/json2.js"></script>
<style type="text/css">
#addr{width: 500px; height: 32px;border: 1px solid #7f9db9; padding-left: 10px; line-height: 32px;}
body{
	margin:0px;
}	
</style>

	<script type="text/javascript">
	//计算合计
	$(function() {
		var total = 0;
		$(".Subtotal").each(function() {
			total += Number($(this).text());
		});
		$("#total").text(round(total, 2));
	});
	</script>
  </head>
	
  <body>
  <div class="listmain">
  <div class="listTop" style="font-size: 10pt;">
		<div class="current">&nbsp;当前位置：
			<a href="${pageContext.request.contextPath}/bookShop/toBookList" style="color:#6E6E6E;">书店</a> &gt;      
			<a href="#" style="color:#6E6E6E;">创建新订单</a>
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
	<div>
  <c:choose>
  	<c:when test="${empty itemList }">空空如也~</c:when>
  	<c:otherwise>
<form id="form1" action="<c:url value='/order/createNewOrderSubmit'/>" method="post">
	<input type="hidden" name="cartItemIds" value="${cartItemIds }"/>
	<input type="hidden" name="method" value="createOrder"/>
<table width="95%" align="center" cellpadding="0" cellspacing="0">
	<tr bgcolor="#efeae5">
		<td width="400px" colspan="5"><span style="font-weight: 900;">生成订单</span></td>
	</tr>
	<tr align="center">
		<td width="10%">&nbsp;</td>
		<td width="50%">图书名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
	</tr>



<c:forEach items="${itemList }" var="cartDetails">
	<tr align="center">
		<td align="right" >
			<a class="linkImage" href="<c:url value='/jsp/shop/book/desc.jsp'/>"><img border="0" width="54" align="top" src="${pageContext.request.contextPath}/book_img/${cartDetails.imageb }"/></a>
		</td>
		<td align="left" >
		    <a href="<c:url value='/shop/book/desc.jsp'/>"><span>${cartDetails.name }</span></a>
		</td>
		<td>&yen;${cartDetails.currprice }</td>
		<td>${cartDetails.num }</td>
		<td width="100px">
			<span class="price_n">&yen;<span class="subTotal" id="${cartDetails.cartitemid }Subtotal">${cartDetails.total }</span></span>
		</td>
	</tr>
</c:forEach>
	
	<tr>
		<td colspan="6" align="right">
			<span>总计：</span><span class="price_t">&yen;<span id="total" >${total }</span></span>
		</td>
	</tr>
	<tr>
		<td colspan="5" bgcolor="#efeae5"><span style="font-weight: 900">收货地址</span></td>
	</tr>
	<tr>
		<td colspan="6">
			<input id="addr" type="text" name="address" placeholder="请输入收获地址"/>
		</td>
	</tr>
	<tr>
		<td style="border-top-width: 4px;" colspan="5" align="right">
			<a id="linkSubmit" href="javascript:createOrderSubmit();">提交订单</a>
			<input id="itemList" value="${itemList}" type="hidden">
		</td>
	</tr>
</table>
</form>
  	</c:otherwise>
  </c:choose>
  </div>
  </div>
  </body>
  
  <script type="text/javascript">
  function createOrderSubmit() {
	  	if(window.confirm("你确定？")){
		    var total = document.getElementById("total").innerText;
		    var address = document.getElementById("addr").value;
		    var list = '<%=request.getAttribute("itemList")%>';
	
		    var params = {
		    	"itemlist":list,
		    	"total":total,
		    	"address":address
		    };
		    $.ajax({
		        type: 'post',
		        url: "${pageContext.request.contextPath }/order/createNewOrderSubmit",
		        contentType:"application/json;charset=utf-8",
		        dataType: 'json',
		        data: JSON.stringify(params),
		        success: function(data){
		        	if(data.flag){
		 	    		 alert('下单成功！');
			    		    setTimeout(function(){
			    			   window.parent.location.href="${pageContext.request.contextPath }/order/toOrderList";
			    			 }, 1000); 
		 	    	 }else{
		 	    		alert('下单失败！');
		 	    	 }
		        }
		    });
	  	}
	}
  </script>
</html>
